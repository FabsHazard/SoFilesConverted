package com.microtech.aidexx.utils;

import androidx.core.app.NotificationCompat;
import com.tencent.mars.xlog.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microtech/aidexx/utils/LogUtils;", "", "()V", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogUtils.kt */
public final class LogUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_BLE = "AiDex";
    public static final String LOG_NAME = "CGMS";
    public static final String LOG_NAME_SQL = "CGMS-SQL";

    @JvmStatic
    public static final void debug(String str) {
        Companion.debug(str);
    }

    @JvmStatic
    public static final void debug(String str, String str2) {
        Companion.debug(str, str2);
    }

    @JvmStatic
    public static final void eAiDex(String str) {
        Companion.eAiDex(str);
    }

    @JvmStatic
    public static final void error(String str) {
        Companion.error(str);
    }

    @JvmStatic
    public static final void error(String str, String str2) {
        Companion.error(str, str2);
    }

    @JvmStatic
    public static final void xLog(String str, String str2) {
        Companion.xLog(str, str2);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015J\u0006\u0010\u0016\u001a\u00020\bJ\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/microtech/aidexx/utils/LogUtils$Companion;", "", "()V", "LOG_BLE", "", "LOG_NAME", "LOG_NAME_SQL", "data", "", "msg", "debug", "tag", "debugErrorLong", "debugLong", "debug_s", "debug_thread", "eAiDex", "error", "error_s", "tr", "Ljava/lang/Exception;", "Lkotlin/Exception;", "printStackTrace", "xLog", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LogUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void debug_s(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        }

        public final void debug_thread(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        }

        public final void error_s(String str, Exception exc) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(exc, "tr");
        }

        public final void printStackTrace() {
        }

        private Companion() {
        }

        @JvmStatic
        public final void debug(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            Log.d(str, str2);
        }

        @JvmStatic
        public final void xLog(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            Log.d(str, str2);
        }

        @JvmStatic
        public final void debug(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            debugLong(LogUtils.LOG_NAME, str);
        }

        public final void data(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            debugLong(LogUtils.LOG_NAME_SQL, str);
        }

        public final void debugLong(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            int length = 2001 - str.length();
            while (str2.length() > length) {
                String substring = str2.substring(0, length);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                Log.d(LogUtils.LOG_NAME, substring);
                str2 = str2.substring(length);
                Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
            }
            Log.d(LogUtils.LOG_NAME, str2);
        }

        public final void debugErrorLong(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            int length = 2001 - str.length();
            while (str2.length() > length) {
                String substring = str2.substring(0, length);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                Log.e(LogUtils.LOG_NAME, substring);
                str2 = str2.substring(length);
                Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
            }
            Log.e(LogUtils.LOG_NAME, str2);
        }

        @JvmStatic
        public final void error(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Log.e(LogUtils.LOG_NAME, str);
        }

        @JvmStatic
        public final void error(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            Log.e(str, str2);
        }

        @JvmStatic
        public final void eAiDex(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Log.e(LogUtils.LOG_BLE, str);
        }
    }
}
