package com.newtech.android.chattrapp.ui.register;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.Validator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullNameFragment extends Fragment implements Validator {
    @BindView(R.id.fieldFullName)
    TextInputLayout fieldFullName;

    @BindView(R.id.edtFullName)
    TextInputEditText edtFullName;

    @BindView(R.id.btnNextView)
    FloatingActionButton btnNextView;

    public FullNameFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_name, container, false);
        ButterKnife.bind(this, view);
        edtFullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnNextView.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(edtFullName.getText().toString())){
                    btnNextView.setEnabled(false);
                }
            }
        });
        btnNextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = edtFullName.getText().toString();
                if (isValidateInput()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fullName", fullName);
                    NavHostFragment.findNavController(FullNameFragment.this)
                            .navigate(R.id.action_fullNameFragment_to_phoneNumberFragment, bundle);
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