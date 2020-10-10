package com.newtech.android.chattrapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.newtech.android.chattrapp.api.AuthenticationApi;
import com.newtech.android.chattrapp.api.ServiceGenerator;
import com.newtech.android.chattrapp.api.UserApi;


public class Utils {

    public static AuthenticationApi getAuthenticationApi() {
        return ServiceGenerator.createService(AuthenticationApi.class);
    }
    public static UserApi getUserApi() {
        return ServiceGenerator.createService(UserApi.class);
    }
    public static AlertDialog.Builder showMessage(Context context, String title, String message) {
        return new AlertDialog.Builder(context).setMessage(title).setMessage(message).setPositiveButton("ĐÓNG", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
