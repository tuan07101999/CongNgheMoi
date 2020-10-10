package com.newtech.android.chattrapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("avatarlink")
    @Expose
    private String avatarlink;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;

    public User() {
    }

    public User(String name, String avatarlink, String phonenumber) {
        this.name = name;
        this.avatarlink = avatarlink;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarlink() {
        return avatarlink;
    }

    public void setAvatarlink(String avatarlink) {
        this.avatarlink = avatarlink;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
