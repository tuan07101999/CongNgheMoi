package com.newtech.android.chattrapp.ui.register;

import com.newtech.android.chattrapp.Utils;
import com.newtech.android.chattrapp.api.ServiceGenerator;
import com.newtech.android.chattrapp.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterProvider {
    private IOtpView mIOtpView;
    private IInfoView mIInfoView;

    public RegisterProvider(IOtpView iOtpView) {
        mIOtpView = iOtpView;
    }

    public RegisterProvider(IInfoView IInfoView) {
        mIInfoView = IInfoView;
    }

    void getUserById(String phoneNumber){
        Call<User> userCall = Utils.getUserApi().getUserById(phoneNumber);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                mIOtpView.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    mIInfoView.setUser(response.body());
                } else {
                    mIInfoView.onErrorMessage(response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mIOtpView.onErrorMessage(t.getLocalizedMessage());
            }
        });
    }


    void signup(User user) {
        mIOtpView.showLoading();
        Call<User> userCall = Utils.getAuthenticationApi().signup(user);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                mIOtpView.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    mIOtpView.setUser(response.body());
                } else {
                    mIOtpView.onErrorMessage(response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mIOtpView.onErrorMessage(t.getLocalizedMessage());
            }
        });
    }


}
