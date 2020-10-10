package com.newtech.android.chattrapp.ui.register;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.Validator;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PhoneNumberFragment extends Fragment implements Validator {
    @BindView(R.id.fieldPhone)
    TextInputLayout fieldPhone;

    @BindView(R.id.edtPhone)
    TextInputEditText edtPhone;

    @BindView(R.id.btnNextView)
    FloatingActionButton btnNextView;

    public PhoneNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone_number, container, false);
        ButterKnife.bind(this, view);
        edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnNextView.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(edtPhone.getText().toString())) {
                    btnNextView.setEnabled(false);
                }
            }
        });
        btnNextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = edtPhone.getText().toString();
                if (isValidateInput()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fullName", getArguments().getString("fullName"));
                    bundle.putString("phoneNumber", phoneNumber);
                    NavHostFragment.findNavController(PhoneNumberFragment.this)
                            .navigate(R.id.action_phoneNumberFragment_to_otpVerifyFragment, bundle);
                }
            }
        });
        return view;
    }

    @Override
    public boolean isValidateInput() {
        return true;
    }
}