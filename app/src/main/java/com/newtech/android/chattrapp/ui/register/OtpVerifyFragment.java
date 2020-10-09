package com.newtech.android.chattrapp.ui.register;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.Validator;
import com.newtech.android.chattrapp.ui.login.CreatePasswordFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtpVerifyFragment extends Fragment implements Validator {

    @BindView(R.id.btnContinueOtp)
    Button btnContinueOtp;

    public OtpVerifyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_otp_verify, container, false);
        ButterKnife.bind(this, view);
        ((MainActivity)getActivity()).setupActionBar(getString(R.string.text_input_otp), false, null);
        btnContinueOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getArguments()!=null && getArguments().getString("loginArg")!=null){
                    NavHostFragment.findNavController(OtpVerifyFragment.this)
                            .navigate(R.id.action_otpVerifyFragment_to_createPasswordFragment);
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle(R.string.text_input_otp);
                }else {
                    NavHostFragment.findNavController(OtpVerifyFragment.this)
                            .navigate(R.id.action_otpVerifyFragment_to_infoFragment);
                }


            }
        });
        return view;
    }


    @Override
    public boolean isValidateInput() {
        return false;
    }
}