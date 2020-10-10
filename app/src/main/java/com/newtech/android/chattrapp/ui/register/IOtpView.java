package com.newtech.android.chattrapp.ui.register;

public interface IOtpView {
    void showLoading();

    void hideLoading();

    void sendOtpMessage(String phoneNumber);

    void navigateUpdateInfo();
    void navigateCreateNewPassword();

    void onErrorMessage(String message);
}
