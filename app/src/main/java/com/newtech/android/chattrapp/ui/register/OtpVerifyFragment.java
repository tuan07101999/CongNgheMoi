package com.newtech.android.chattrapp.ui.register;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.Utils;
import com.newtech.android.chattrapp.Validator;
import com.newtech.android.chattrapp.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtpVerifyFragment extends Fragment implements Validator, IOtpView {
    private static final String TAG = "OtpVerifyFragment";

    @BindView(R.id.textSendMessage)
    TextView textSendMessage;

    @BindView(R.id.btnContinueOtp)
    Button btnContinueOtp;

    @BindView(R.id.fieldOtp)
    TextInputLayout fieldOtp;

    @BindView(R.id.edtOpt)
    TextInputEditText editOtp;

    ProgressDialog mProgressDialog;

    RegisterProvider mRegisterProvider;


    public OtpVerifyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_otp_verify, container, false);
        ButterKnife.bind(this, view);

        ((MainActivity) getActivity()).setupActionBar(getString(R.string.text_input_otp), false, null);

        mProgressDialog = new ProgressDialog(getActivity());
        mRegisterProvider = new RegisterProvider(this);
        //hiện số điện thoại người dùng
        textSendMessage.setText(getString(R.string.text_notifiy_otp, getArguments().getString("phoneNumber")));
        sendOtpImage(getArguments().getString("phoneNumber"));
        btnContinueOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getArguments() != null && getArguments().getString("loginArg") != null) {
                    if (isValidOtp(editOtp.getText().toString())) {
                        navigateCreateNewPassword();
                    }

                } else {
                    //Tạo tài khoản
                    if (isValidOtp(editOtp.getText().toString())) {
                        String phoneNumber = getArguments().getString("phoneNumber");
                        String fullName = getArguments().getString("fullName");
                        mRegisterProvider.signup(new User());
                        navigateUpdateInfo();
                    }

                }
            }
        });
        return view;
    }


    @Override
    public boolean isValidateInput() {
        return false;
    }

    @Override
    public void showLoading() {
        mProgressDialog.setTitle("Đang xử lý");
        mProgressDialog.setMessage("Xin vui lòng đợi trong giây lát");
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void sendOtpImage(String phoneNumber) {

    }

    @Override
    public boolean isValidOtp(String Otp) {
        return true;
    }


    @Override
    public void navigateUpdateInfo() {
        NavHostFragment.findNavController(OtpVerifyFragment.this)
                .navigate(R.id.action_otpVerifyFragment_to_infoFragment);
    }

    @Override
    public void navigateCreateNewPassword() {
        NavHostFragment.findNavController(OtpVerifyFragment.this)
                .navigate(R.id.action_otpVerifyFragment_to_createPasswordFragment);
    }

    @Override
    public void onErrorMessage(String message) {
        Utils.showMessage(getActivity(), "Lỗi", message).show();
    }
}