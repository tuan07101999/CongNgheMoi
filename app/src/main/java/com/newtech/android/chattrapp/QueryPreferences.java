package com.newtech.android.chattrapp;

import android.content.Context;
import android.preference.PreferenceManager;

public class QueryPreferences {
    private static final String PREF_USER_ID = "phoneNumber";


    public static String getPrefUserId(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_USER_ID, null);
    }

    public static void setPrefUserId(Context context, String lastResultId) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_USER_ID, lastResultId)
                .apply();
    }
}
