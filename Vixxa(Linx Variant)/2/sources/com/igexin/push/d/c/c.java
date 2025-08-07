package com.igexin.push.d.c;

import com.igexin.a.a.d.a;
import okio.Utf8;
import org.apache.commons.codec.CharEncoding;

public abstract class c extends a {
    public int i;
    public byte j;
    public byte k = 11;

    /* access modifiers changed from: protected */
    public int a(String str) {
        if (str.equals("UTF-8")) {
            return 1;
        }
        if (str.equals(CharEncoding.UTF_16)) {
            return 2;
        }
        if (str.equals(CharEncoding.UTF_16BE)) {
            return 16;
        }
        if (str.equals(CharEncoding.UTF_16LE)) {
            return 17;
        }
        if (str.equals("GBK")) {
            return 25;
        }
        if (str.equals("GB2312")) {
            return 26;
        }
        if (str.equals("GB18030")) {
            return 27;
        }
        return str.equals("ISO-8859-1") ? 33 : 1;
    }

    /* access modifiers changed from: protected */
    public String a(byte b) {
        byte b2 = b & Utf8.REPLACEMENT_BYTE;
        if (b2 == 1) {
            return "UTF-8";
        }
        if (b2 == 2) {
            return CharEncoding.UTF_16;
        }
        if (b2 == 16) {
            return CharEncoding.UTF_16BE;
        }
        if (b2 == 17) {
            return CharEncoding.UTF_16LE;
        }
        if (b2 == 33) {
            return "ISO-8859-1";
        }
        switch (b2) {
            case 25:
                return "GBK";
            case 26:
                return "GB2312";
            case 27:
                return "GB18030";
            default:
                return "UTF-8";
        }
    }

    public abstract void a(byte[] bArr);

    public int b_() {
        return this.i;
    }

    public abstract byte[] c();
}
