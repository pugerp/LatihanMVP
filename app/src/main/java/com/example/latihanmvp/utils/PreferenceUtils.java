package com.example.latihanmvp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.latihanmvp.data.PrefKey;

public class PreferenceUtils {
    private SharedPreferences pref;

    public PreferenceUtils(Context context, String name) {
        this.pref = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public void setString(String s, String value) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(s, value);
        editor.apply();
    }

    public String getString(String s) {
        return pref.getString(s, "");
    }
}
