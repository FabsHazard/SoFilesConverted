package com.huawei.hms.scankit.p;

/* compiled from: AIScanException */
public class a extends Exception {
    protected static final boolean a = (System.getProperty("surefire.test.class.path") != null);
    protected static final StackTraceElement[] b;
    private static final a c;

    static {
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        b = stackTraceElementArr;
        a aVar = new a();
        c = aVar;
        aVar.setStackTrace(stackTraceElementArr);
    }

    private a() {
    }

    public static a a() {
        return a ? new a() : c;
    }

    private a(String str) {
        super(str);
    }

    public static a a(String str) {
        return new a(str);
    }
}
