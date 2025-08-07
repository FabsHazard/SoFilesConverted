package com.microtech.aidexx.utils;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

public class LocalManageUtil {
    private static final String TAG = "LocalManageUtil";

    public static boolean isArabicNotSupported() {
        return true;
    }

    public static void saveSystemCurrentLanguage(Context context) {
    }

    public static void saveSystemCurrentLanguage(Context context, Configuration configuration) {
    }

    public static Locale getSystemLocale(Context context) {
        return LanguageUtil.getInstance(context).getSystemCurrentLocal();
    }

    public static Locale getSetLanguageLocale(Context context) {
        switch (LanguageUtil.getInstance(context).getSelectLanguage()) {
            case 0:
                return Locale.ENGLISH;
            case 1:
                return Locale.SIMPLIFIED_CHINESE;
            case 2:
                return new Locale("cs");
            case 3:
                return new Locale("sk");
            case 4:
                return Locale.FRANCE;
            case 5:
                if (isArabicNotSupported()) {
                    return new Locale("en");
                }
                return new Locale("ar");
            case 6:
                return new Locale("it");
            case 7:
                return new Locale("mn");
            case 8:
                return new Locale("ro");
            case 9:
                return new Locale("tr");
            case 10:
                return new Locale("es");
            case 11:
                return new Locale("ru");
            case 12:
                return new Locale("de");
            case 13:
                return new Locale("sv");
            default:
                Locale systemLocale = getSystemLocale(context);
                int i = 0;
                if ("en".equals(systemLocale.getLanguage()) || "zh".equals(systemLocale.getLanguage()) || "cs".equals(systemLocale.getLanguage()) || "sk".equals(systemLocale.getLanguage()) || "fr".equals(systemLocale.getLanguage()) || "ar".equals(systemLocale.getLanguage()) || "mn".equals(systemLocale.getLanguage()) || "it".equals(systemLocale.getLanguage()) || "ro".equals(systemLocale.getLanguage()) || "tr".equals(systemLocale.getLanguage()) || "es".equals(systemLocale.getLanguage()) || "ru".equals(systemLocale.getLanguage()) || "de".equals(systemLocale.getLanguage()) || "sv".equals(systemLocale.getLanguage())) {
                    if ("zh".equals(systemLocale.getLanguage())) {
                        i = 1;
                    } else if ("cs".equals(systemLocale.getLanguage())) {
                        i = 2;
                    } else if ("sk".equals(systemLocale.getLanguage())) {
                        i = 3;
                    } else if ("fr".equals(systemLocale.getLanguage())) {
                        i = 4;
                    } else if ("ar".equals(systemLocale.getLanguage())) {
                        if (!isArabicNotSupported()) {
                            i = 5;
                        }
                    } else if ("it".equals(systemLocale.getLanguage())) {
                        i = 6;
                    } else if ("mn".equals(systemLocale.getLanguage())) {
                        i = 7;
                    } else if ("ro".equals(systemLocale.getLanguage())) {
                        i = 8;
                    } else if ("tr".equals(systemLocale.getLanguage())) {
                        i = 9;
                    } else if ("es".equals(systemLocale.getLanguage())) {
                        i = 10;
                    } else if ("ru".equals(systemLocale.getLanguage())) {
                        i = 11;
                    } else if ("de".equals(systemLocale.getLanguage())) {
                        i = 12;
                    } else if ("sv".equals(systemLocale.getLanguage())) {
                        i = 13;
                    }
                    LanguageUtil.getInstance(context).saveLanguage(i);
                    return systemLocale;
                }
                LanguageUtil.getInstance(context).saveLanguage(0);
                return Locale.ENGLISH;
        }
    }

    public static boolean isSameWithSetting(Context context) {
        return context.getResources().getConfiguration().locale.equals(getSetLanguageLocale(context));
    }

    public static void saveSelectLanguage(Context context, int i) {
        LanguageUtil.getInstance(context).saveLanguage(i);
    }
}
