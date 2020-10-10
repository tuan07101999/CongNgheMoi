package com.newtech.android.chattrapp.ui.register;

public interface IOtpView {
    void showLoading();

    void hideLoading();

    void sendOtpImage(String phoneNumber);

    boolean isValidOtp(String Otp);

    void navigateUpdateInfo();

    void navigateCreateNewPassword();

    void onErrorMessage(String message);
}
