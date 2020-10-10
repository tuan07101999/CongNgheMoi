package com.newtech.android.chattrapp.ui.register;

import com.newtech.android.chattrapp.model.User;

public interface IInfoView {
    void showLoading();
    void hideLoading();
    void updateUser(User user);
    void navigateAferUpdateSuccess();
    void onErrorMessage(String msg);

}
