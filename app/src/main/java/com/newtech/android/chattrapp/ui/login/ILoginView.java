package com.newtech.android.chattrapp.ui.login;

import com.newtech.android.chattrapp.model.User;

public interface ILoginView {
    void showLoading();
    boolean login(String phoneNumber,String password);
    void setUser(User user);
    void navigateHome();
    void navigateGetPassword();
    void onErrorLoading(String message);
}
