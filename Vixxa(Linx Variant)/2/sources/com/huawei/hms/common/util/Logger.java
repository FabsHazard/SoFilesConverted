package com.huawei.hms.common.util;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;
import org.json.JSONException;

public class Logger {
    public static final boolean a = false;
    public static final String b = "Logger";
    public static final String c = "|";
    public static final int d = 8;
    public static final int e = 20;
    public static final String f = "dynamic-api_";

    public static class b extends Throwable {
        public static final long d = 7129050843360571879L;
        public String a;
        public Throwable b;
        public Throwable c;

        public b(Throwable th) {
            this.c = th;
        }

        /* access modifiers changed from: private */
        public void a(Throwable th) {
            this.b = th;
        }

        public void a(String str) {
            this.a = str;
        }

        public Throwable getCause() {
            Throwable th = this.b;
            if (th == this) {
                return null;
            }
            return th;
        }

        public String getMessage() {
            return this.a;
        }

        public String toString() {
            Throwable th = this.c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.a == null) {
                return name;
            }
            String str = name + ": ";
            return this.a.startsWith(str) ? this.a : str + this.a;
        }
    }

    public static int a(int i, String str, String str2) {
        return Log.println(i, a(str), a(str2, 7));
    }

    public static String a(int i) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        StringBuilder sb = new StringBuilder();
        sb.append(Process.myPid()).append("-").append(Process.myTid()).append(c).append(stackTraceElement.getFileName()).append(c).append(stackTraceElement.getClassName()).append(c).append(stackTraceElement.getMethodName()).append(c).append(stackTraceElement.getLineNumber());
        return sb.toString();
    }

    public static String a(String str) {
        return f + str;
    }

    public static String a(String str, int i) {
        return !TextUtils.isEmpty(str) ? a(i) + c + str : a(i);
    }

    public static Throwable a(Throwable th) {
        if (isLoggable(3)) {
            return th;
        }
        if (th == null) {
            return null;
        }
        int i = ((th instanceof IOException) || (th instanceof JSONException)) ? 8 : 20;
        b bVar = new b(th);
        StackTraceElement[] stackTrace = bVar.getStackTrace();
        if (stackTrace.length > i) {
            bVar.setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i));
        } else {
            bVar.setStackTrace(stackTrace);
        }
        bVar.a(anonymizeMessage(th.getMessage()));
        Throwable cause = th.getCause();
        b bVar2 = bVar;
        while (cause != null) {
            b bVar3 = new b(cause);
            bVar3.a(anonymizeMessage(cause.getMessage()));
            bVar2.a((Throwable) bVar3);
            cause = cause.getCause();
            bVar2 = bVar3;
        }
        return bVar;
    }

    public static String anonymizeMessage(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i % 2 == 1) {
                charArray[i] = '*';
            }
        }
        return new String(charArray);
    }

    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(a(str), a(str2, 5), a(th));
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static boolean isLoggable(int i) {
        return Log.isLoggable(f, i);
    }

    public static void println(int i, String str, Object obj) {
        if (i >= 3 && isLoggable(i)) {
            a(i, str, obj == null ? "null" : obj.toString());
        }
    }

    public static void println(int i, String str, String str2, Object... objArr) {
        if (i >= 3) {
            if (str2 == null) {
                Log.w(b, "format is null, not log");
                return;
            }
            try {
                if (isLoggable(i)) {
                    a(i, str, format(str2, objArr));
                }
            } catch (IllegalFormatException e2) {
                w(b, "log format error" + str2, (Throwable) e2);
            }
        }
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    public static void w(String str, String str2, Throwable th) {
        Log.w(a(str), a(str2, 5), a(th));
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }
}
