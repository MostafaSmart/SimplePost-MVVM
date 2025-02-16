package com.example.myapplication.data.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import com.example.myapplication.data.Models.User;

public class UserPreferences {
    private static final String PREF_NAME = "user_prefs";
    private static final String KEY_ID = "user_id";
    private static final String KEY_NAME = "user_name";
    private static final String KEY_EMAIL = "user_email";
    private static final String KEY_PASSWORD = "user_password";  // يفضل عدم تخزينها
    private static final String KEY_ACCESS_TOKEN = "access_token";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public UserPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUser(User user) {
        editor.putInt(KEY_ID, user.getID());
        editor.putString(KEY_NAME, user.getName());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_PASSWORD, encode(user.getPassword())); // التشفير اختياري
        editor.putString(KEY_ACCESS_TOKEN, user.getAcssesToken());
        editor.apply();
    }

    // 🔹 استرجاع بيانات المستخدم
    public User getUser() {
        int id = sharedPreferences.getInt(KEY_ID, -1);
        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);
        String password = decode(sharedPreferences.getString(KEY_PASSWORD, null)); // فك التشفير
        String accessToken = sharedPreferences.getString(KEY_ACCESS_TOKEN, null);

        if (id == -1 || name == null || email == null || accessToken == null) {
            return null;
        }

        return new User(id, name, email, password, accessToken);
    }

    public boolean isLoggedIn() {
        return sharedPreferences.contains(KEY_ACCESS_TOKEN);
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }

    // 🔒 تشفير البيانات (Base64 - يفضل استخدام طريقة أقوى)
    private String encode(String value) {
        return value != null ? Base64.encodeToString(value.getBytes(), Base64.DEFAULT) : null;
    }

    private String decode(String value) {
        return value != null ? new String(Base64.decode(value, Base64.DEFAULT)) : null;
    }
}
