package com.prateek.visionconnect.core;


import android.content.Context;
import android.content.SharedPreferences;



public class PreferenceUtil {

    private SharedPreferences getPrefs(Context context) {
        //SharedPreferences file name
        String SHARED_PREFS_FILE_NAME = "com.prateek.visionconnect.core.my_pref";
        return context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }

    //Save Booleans
    public void savePref(Context context, String key, boolean value) {
        getPrefs(context).edit().putBoolean(key, value).apply();
    }

    //Get Booleans
    public boolean getBoolean(Context context, String key) {
        return getPrefs(context).getBoolean(key, false);
    }

    //Get Booleans if not found return a predefined default value
    public boolean getBoolean(Context context, String key, boolean defaultValue) {
        return getPrefs(context).getBoolean(key, defaultValue);
    }

    //Strings
    public void save(Context context, String key, String value) {
        getPrefs(context).edit().putString(key, value).apply();
    }

    public String getString(Context context, String key) {
        return getPrefs(context).getString(key, "");
    }

    public String getString(Context context, String key, String defaultValue) {
        return getPrefs(context).getString(key, defaultValue);
    }

    //Integers
    public void save(Context context, String key, int value) {
        getPrefs(context).edit().putInt(key, value).apply();
    }

    public int getInt(Context context, String key) {
        return getPrefs(context).getInt(key, 0);
    }

    public int getInt(Context context, String key, int defaultValue) {
        return getPrefs(context).getInt(key, defaultValue);
    }

    //Floats
    public void save(Context context, String key, float value) {
        getPrefs(context).edit().putFloat(key, value).apply();
    }

    public float getFloat(Context context, String key) {
        return getPrefs(context).getFloat(key, 0);
    }

    public float getFloat(Context context, String key, float defaultValue) {
        return getPrefs(context).getFloat(key, defaultValue);
    }

    //Longs
    public void save(Context context, String key, long value) {
        getPrefs(context).edit().putLong(key, value).apply();
    }

    public long getLong(Context context, String key) {
        return getPrefs(context).getLong(key, 0);
    }

    public long getLong(Context context, String key, long defaultValue) {
        return getPrefs(context).getLong(key, defaultValue);
    }



}
