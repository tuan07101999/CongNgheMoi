package com.newtech.android.chattrapp.api;

import com.newtech.android.chattrapp.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApi {
    @GET("user/{id}")
    Call<User> getUserById(@Path("id") String phoneNumber);

    @POST("user/update/{id}")
    Call<User> updateUser(@Path("id") String phoneNumber, @Body User user);
}
