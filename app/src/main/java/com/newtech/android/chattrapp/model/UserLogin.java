package com.newtech.android.chattrapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserLogin implements Serializable {
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("password")
    @Expose
    private String password;

    public UserLogin() {
    }

    public UserLogin(String phonenumber, String password) {
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
