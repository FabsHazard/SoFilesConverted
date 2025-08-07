package com.microtech.aidexx.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Locale;

public class LanguageUtil {
    private static volatile LanguageUtil instance;
    private final String LANGUAGE = "language";
    private final String SP_NAME = "sp_setting";
    private final String TAG_SYSTEM_LANGUAGE = "system_language";
    private final SharedPreferences mSharedPreferences;
    private Locale systemCurrentLocal = Locale.ENGLISH;

    public void saveLanguage(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("language", i);
        edit.apply();
    }

    public int getSelectLanguage() {
        return this.mSharedPreferences.getInt("language", -1);
    }

    public Locale getSystemCurrentLocal() {
        return this.systemCurrentLocal;
    }

    public void setSystemCurrentLocal(Locale locale) {
        this.systemCurrentLocal = locale;
    }

    public LanguageUtil(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("sp_setting", 0);
    }

    public static LanguageUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (LanguageUtil.class) {
                if (instance == null) {
                    instance = new LanguageUtil(context);
                }
            }
        }
        return instance;
    }
}
