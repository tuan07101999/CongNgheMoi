package com.newtech.android.chattrapp.ui.login;

import android.util.Log;

import com.newtech.android.chattrapp.Utils;
import com.newtech.android.chattrapp.api.AuthenticationApi;
import com.newtech.android.chattrapp.api.ServiceGenerator;
import com.newtech.android.chattrapp.model.User;
import com.newtech.android.chattrapp.model.UserLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private ILoginView mLoginView;

    public LoginPresenter(ILoginView loginView) {
        mLoginView = loginView;
    }

    void login(final String phoneNumber, String password) {
        mLoginView.showLoading();
        Call<User> userCall = Utils.getAuthenticationApi().login(new UserLogin(phoneNumber, password));
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                mLoginView.hideLoading();
                //nếu đăng nhập thành công thì chuyển đến màn hình chính
                if (response.isSuccessful() && response.body() != null) {
                    mLoginView.navigateHome();
                } else {
                    //ngược lại hiện thông báo lỗi
                    mLoginView.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //xuất hiện ngoại lệ trong quá trình đăng nhập
                mLoginView.hideLoading();
                mLoginView.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
