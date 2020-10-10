package com.newtech.android.chattrapp.ui.register;

import com.newtech.android.chattrapp.model.User;

public interface IOtpView {
    void showLoading();

    void hideLoading();

    void setUser(User user);

    void sendOtpMessage(String phoneNumber);

    void navigateUpdateInfo();

    void navigateCreateNewPassword();

    void onErrorMessage(String message);
}
