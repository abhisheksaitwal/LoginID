package com.sourcey.loginproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by Abhi on 30-12-2016.
 */

public class UserManager {

private final String KEY_PREFS = "user_login";

    private final String KEY_EMAIL = "email";

    private final String KEY_PASSWORD = "password";

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    public UserManager(Context context) {
        mPrefs = context.getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();
    }

    public boolean checkLoginValidate(String email, String password) {
        String realEmail = mPrefs.getString(KEY_EMAIL, "");
        String realPassword = mPrefs.getString(KEY_PASSWORD, "");

        if ((!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) &&
                email.equals(realEmail) &&
                password.equals(realPassword)) {
            return true;
        }
        return false;
    }

    public boolean registerUser(String email, String password) {

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            return false;
        }

        mEditor.putString(KEY_EMAIL, email);
        mEditor.putString(KEY_PASSWORD, password);
        return mEditor.commit();
    }

}
