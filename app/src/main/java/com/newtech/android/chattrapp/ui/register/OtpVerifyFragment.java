package com.newtech.android.chattrapp.ui.register;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.QueryPreferences;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.Utils;
import com.newtech.android.chattrapp.Validator;
import com.newtech.android.chattrapp.model.User;

import java.util.concurrent.TimeUnit;

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

    /**
     * Xử lý nhận tin mã xác thực
     */
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            hideLoading();
            if (phoneAuthCredential.getSmsCode() != null) {
                editOtp.setText(phoneAuthCredential.getSmsCode());
                setValidOtp(true);
            }else {
                setValidOtp(false);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            hideLoading();
            setValidOtp(false);
            onErrorMessage(e.getLocalizedMessage());
        }
    };
    private boolean isValidOtp;

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

        sendOtpMessage(getArguments().getString("phoneNumber"));

        btnContinueOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), isValidOtp() + "", Toast.LENGTH_SHORT).show();
                if (getArguments() != null && getArguments().getString("loginArg") != null) {
                    if (isValidOtp()) {
                        navigateCreateNewPassword();
                    }

                } else {
                    if (isValidOtp()) {
                        String phoneNumber = getArguments().getString("phoneNumber");
                        String fullName = getArguments().getString("fullName");
                        mRegisterProvider.signup(new User(phoneNumber, fullName, ""));
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
    public void setUser(User user) {
        QueryPreferences.setPrefUserId(getActivity(), user.getPhonenumber());
    }


    @Override
    public void sendOtpMessage(String phoneNumber) {
        showLoading();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+84" + phoneNumber,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
    }

    public boolean isValidOtp() {
        return isValidOtp;
    }


    public void setValidOtp(boolean validOtp) {
        isValidOtp = validOtp;
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