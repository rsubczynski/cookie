package com.example.user.mycookieklicker.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsUtils {

    public static final String PREFS_OPTIONS_RUN_IN_BACKGROUND = "appRunInBackground";

    private static SharedPrefsUtils sharedPrefsUtils;
    private SharedPreferences sharedPreferences;

    public static SharedPrefsUtils getInstance(Context context) {
        if (sharedPrefsUtils == null) {
            sharedPrefsUtils = new SharedPrefsUtils(context);
        }
        return sharedPrefsUtils;
    }

    private SharedPrefsUtils(Context context) {
        sharedPreferences = context.getSharedPreferences("YourCustomNamedPreference",Context.MODE_PRIVATE);
    }

    public void saveOption(String key, Boolean value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public boolean getOption(String key) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getBoolean(key, false);
        }
        return false;
    }
}

