package com.huawei.hms.scankit.p;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.CharEncoding;

/* compiled from: CharacterSetECI */
public enum o0 {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{"ISO-8859-1"}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_6((String) 8, (int) new String[]{"ISO-8859-6"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_8((String) 10, (int) new String[]{"ISO-8859-8"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_10((String) 12, (int) new String[]{"ISO-8859-10"}),
    ISO8859_11((String) 13, (int) new String[]{"ISO-8859-11"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_14((String) 16, (int) new String[]{"ISO-8859-14"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{CharEncoding.UTF_16BE, "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{"UTF-8"}),
    ASCII((String) new int[]{27, 170}, (int) new String[]{CharEncoding.US_ASCII}),
    Big5(28),
    GB18030((String) 29, (int) new String[]{"GB2312", "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    
    private static final Map<Integer, o0> D = null;
    private static final Map<String, o0> E = null;
    private final int[] a;
    private final String[] b;

    static {
        D = new HashMap();
        E = new HashMap();
        for (o0 o0Var : values()) {
            for (int valueOf : o0Var.a) {
                D.put(Integer.valueOf(valueOf), o0Var);
            }
            E.put(o0Var.name(), o0Var);
            for (String put : o0Var.b) {
                E.put(put, o0Var);
            }
        }
    }

    private o0(int i) {
        this(r2, r3, new int[]{i}, new String[0]);
    }

    public int a() {
        return this.a[0];
    }

    private o0(int i, String... strArr) {
        this.a = new int[]{i};
        this.b = strArr;
    }

    public static o0 a(int i) throws a {
        if (i >= 0 && i < 900) {
            return D.get(Integer.valueOf(i));
        }
        throw a.a();
    }

    public static o0 a(String str) {
        return E.get(str);
    }

    private o0(int[] iArr, String... strArr) {
        this.a = iArr;
        this.b = strArr;
    }
}
