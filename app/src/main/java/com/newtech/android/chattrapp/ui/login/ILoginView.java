package com.newtech.android.chattrapp.ui.login;

import com.newtech.android.chattrapp.model.User;

public interface ILoginView {
    void showLoading();
    void hideLoading();
    void navigateHome();
    void navigateGetPassword();
    void onErrorLoading(String message);
}
