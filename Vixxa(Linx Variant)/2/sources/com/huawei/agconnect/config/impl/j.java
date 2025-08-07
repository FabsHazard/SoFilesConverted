package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

class j implements d {
    private final Context a;
    private final String b;

    j(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    private static String a(String str) {
        try {
            return "agc_" + Hex.encodeHexString(a(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bArr);
    }

    public String a(String str, String str2) {
        int identifier;
        String a2 = a(str);
        if (TextUtils.isEmpty(a2) || (identifier = this.a.getResources().getIdentifier(a2, TypedValues.Custom.S_STRING, this.b)) == 0) {
            return str2;
        }
        try {
            return this.a.getResources().getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return str2;
        }
    }
}
