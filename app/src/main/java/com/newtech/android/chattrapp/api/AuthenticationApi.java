package com.newtech.android.chattrapp.api;

import com.newtech.android.chattrapp.model.User;
import com.newtech.android.chattrapp.model.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AuthenticationApi {
    @POST("user/login")
    Call<User> login(@Body UserLogin userLogin);
}
