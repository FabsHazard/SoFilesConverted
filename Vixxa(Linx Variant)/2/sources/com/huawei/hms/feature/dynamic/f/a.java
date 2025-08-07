package com.huawei.hms.feature.dynamic.f;

import android.util.Base64;
import com.huawei.hms.common.util.Logger;

public abstract class a {
    public static final String a = "Base64";

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            String encodeToString = Base64.encodeToString(bArr, 2);
            return encodeToString != null ? encodeToString : "";
        } catch (AssertionError e) {
            Logger.e(a, "An exception occurred while encoding with Base64,AssertionError:", (Throwable) e);
        }
    }

    public static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            byte[] decode = Base64.decode(str, 2);
            if (decode != null) {
                return decode;
            }
        } catch (IllegalArgumentException e) {
            Logger.e(a, "Decoding with Base64 IllegalArgumentException:", (Throwable) e);
        }
        return new byte[0];
    }
}
