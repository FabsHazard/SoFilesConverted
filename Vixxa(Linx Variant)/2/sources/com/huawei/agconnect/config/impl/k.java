package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

class k extends j {
    private final Map<String, String> a = new HashMap();
    private final Object b = new Object();
    private g c;
    private boolean d = true;
    private final String e;

    k(Context context, String str) {
        super(context, str);
        this.e = str;
        try {
            String a2 = a("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
            String a3 = a("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
            String a4 = a("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
            String a5 = a("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
            if (a2 == null || a3 == null || a4 == null || a5 == null) {
                this.d = false;
            } else {
                this.c = new f(a2, a3, a4, a5);
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("SecurityResourcesReader", "Exception when reading the 'K&I' for 'Config'.");
            this.c = null;
        }
    }

    private String a(String str) {
        return super.a(str, (String) null);
    }

    public String a(String str, String str2) {
        if (!this.d) {
            String a2 = a(str);
            return a2 != null ? a2 : str2;
        } else if (this.c == null) {
            Log.e("SecurityResourcesReader", "KEY is null return def directly");
            return str2;
        } else {
            synchronized (this.b) {
                String str3 = this.a.get(str);
                if (str3 != null) {
                    return str3;
                }
                String a3 = a(str);
                if (a3 == null) {
                    return str2;
                }
                String a4 = this.c.a(a3, str2);
                this.a.put(str, a4);
                return a4;
            }
        }
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=" + this.d + '}';
    }
}
