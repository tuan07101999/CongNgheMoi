package com.newtech.android.chattrapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserLogin implements Serializable {
    @SerializedName("phonenumber")
    private String phoneNumber;

    private String password;

    public UserLogin(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
