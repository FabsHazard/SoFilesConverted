package com.tencent.mars.xlog;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

public class Log {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String SYS_INFO;
    private static final String TAG = "mars.xlog.log";
    private static LogImp debugLog = null;
    /* access modifiers changed from: private */
    public static int level = 6;
    /* access modifiers changed from: private */
    public static LogImp logImp;
    private static Map<String, LogInstance> sLogInstanceMap = new HashMap();
    public static Context toastSupportContext;

    public interface LogImp {
        void appenderClose();

        void appenderFlush(long j, boolean z);

        void appenderOpen(int i, int i2, String str, String str2, String str3, int i3);

        int getLogLevel(long j);

        long getXlogInstance(String str);

        void logD(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4);

        void logE(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4);

        void logF(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4);

        void logI(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4);

        void logV(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4);

        void logW(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4);

        long openLogInstance(int i, int i2, String str, String str2, String str3, int i3);

        void releaseXlogInstance(String str);

        void setAppenderMode(long j, int i);

        void setConsoleLogOpen(long j, boolean z);

        void setMaxAliveTime(long j, long j2);

        void setMaxFileSize(long j, long j2);
    }

    static {
        AnonymousClass1 r14 = new LogImp() {
            private Handler handler = new Handler(Looper.getMainLooper());

            public void appenderClose() {
            }

            public void appenderFlush(long j, boolean z) {
            }

            public void appenderOpen(int i, int i2, String str, String str2, String str3, int i3) {
            }

            public long getXlogInstance(String str) {
                return 0;
            }

            public long openLogInstance(int i, int i2, String str, String str2, String str3, int i3) {
                return 0;
            }

            public void releaseXlogInstance(String str) {
            }

            public void setAppenderMode(long j, int i) {
            }

            public void setConsoleLogOpen(long j, boolean z) {
            }

            public void setMaxAliveTime(long j, long j2) {
            }

            public void setMaxFileSize(long j, long j2) {
            }

            public void logV(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
                if (Log.level <= 0) {
                    android.util.Log.v(str, str4);
                }
            }

            public void logI(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
                if (Log.level <= 2) {
                    android.util.Log.i(str, str4);
                }
            }

            public void logD(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
                if (Log.level <= 1) {
                    android.util.Log.d(str, str4);
                }
            }

            public void logW(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
                if (Log.level <= 3) {
                    android.util.Log.w(str, str4);
                }
            }

            public void logE(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
                if (Log.level <= 4) {
                    android.util.Log.e(str, str4);
                }
            }

            public void logF(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, final String str4) {
                if (Log.level <= 5) {
                    android.util.Log.e(str, str4);
                    if (Log.toastSupportContext != null) {
                        this.handler.post(new Runnable() {
                            public void run() {
                                Toast.makeText(Log.toastSupportContext, str4, 1).show();
                            }
                        });
                    }
                }
            }

            public int getLogLevel(long j) {
                return Log.level;
            }
        };
        debugLog = r14;
        logImp = r14;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
            sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
            sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
            sb.append("] BOARD:[" + Build.BOARD);
            sb.append("] DEVICE:[" + Build.DEVICE);
            sb.append("] DISPLAY:[" + Build.DISPLAY);
            sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            sb.append("] HOST:[" + Build.HOST);
            sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            sb.append("] MODEL:[" + Build.MODEL);
            sb.append("] PRODUCT:[" + Build.PRODUCT);
            sb.append("] TAGS:[" + Build.TAGS);
            sb.append("] TYPE:[" + Build.TYPE);
            sb.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        SYS_INFO = sb.toString();
    }

    public static void setLogImp(LogImp logImp2) {
        logImp = logImp2;
    }

    public static LogImp getImpl() {
        return logImp;
    }

    public static void appenderOpen(int i, int i2, String str, String str2, String str3, int i3) {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.appenderOpen(i, i2, str, str2, str3, i3);
        }
    }

    public static void appenderClose() {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.appenderClose();
            for (Map.Entry<String, LogInstance> key : sLogInstanceMap.entrySet()) {
                closeLogInstance((String) key.getKey());
            }
        }
    }

    public static void appenderFlush() {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.appenderFlush(0, false);
            for (Map.Entry<String, LogInstance> value : sLogInstanceMap.entrySet()) {
                ((LogInstance) value.getValue()).appenderFlush();
            }
        }
    }

    public static void appenderFlushSync(boolean z) {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.appenderFlush(0, z);
        }
    }

    public static int getLogLevel() {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            return logImp2.getLogLevel(0);
        }
        return 6;
    }

    public static void setLevel(int i, boolean z) {
        level = i;
        android.util.Log.w(TAG, "new log level: " + i);
        if (z) {
            android.util.Log.e(TAG, "no jni log level support");
        }
    }

    public static void setConsoleLogOpen(boolean z) {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.setConsoleLogOpen(0, z);
        }
    }

    public static void f(String str, String str2) {
        Object[] objArr = null;
        f(str, str2, (Object[]) null);
    }

    public static void e(String str, String str2) {
        Object[] objArr = null;
        e(str, str2, (Object[]) null);
    }

    public static void w(String str, String str2) {
        Object[] objArr = null;
        w(str, str2, (Object[]) null);
    }

    public static void i(String str, String str2) {
        Object[] objArr = null;
        i(str, str2, (Object[]) null);
    }

    public static void d(String str, String str2) {
        Object[] objArr = null;
        d(str, str2, (Object[]) null);
    }

    public static void v(String str, String str2) {
        Object[] objArr = null;
        v(str, str2, (Object[]) null);
    }

    public static void f(String str, String str2, Object... objArr) {
        LogImp logImp2 = logImp;
        if (logImp2 != null && logImp2.getLogLevel(0) <= 5) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            String str3 = str;
            logImp.logF(0, str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        LogImp logImp2 = logImp;
        if (logImp2 != null && logImp2.getLogLevel(0) <= 4) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logE(0, str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        LogImp logImp2 = logImp;
        if (logImp2 != null && logImp2.getLogLevel(0) <= 3) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logW(0, str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        LogImp logImp2 = logImp;
        if (logImp2 != null && logImp2.getLogLevel(0) <= 2) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logI(0, str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        LogImp logImp2 = logImp;
        if (logImp2 != null && logImp2.getLogLevel(0) <= 1) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logD(0, str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        LogImp logImp2 = logImp;
        if (logImp2 != null && logImp2.getLogLevel(0) <= 0) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logV(0, str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        String str3;
        LogImp logImp2 = logImp;
        if (logImp2 != null && logImp2.getLogLevel(0) <= 4) {
            if (objArr == null) {
                str3 = str2;
            } else {
                str3 = String.format(str2, objArr);
            }
            if (str3 == null) {
                str3 = "";
            }
            String str4 = str;
            logImp.logE(0, str4, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3 + "  " + android.util.Log.getStackTraceString(th));
        }
    }

    public static String getSysInfo() {
        return SYS_INFO;
    }

    public static LogInstance openLogInstance(int i, int i2, String str, String str2, String str3, int i3) {
        synchronized (sLogInstanceMap) {
            if (sLogInstanceMap.containsKey(str3)) {
                LogInstance logInstance = sLogInstanceMap.get(str3);
                return logInstance;
            }
            LogInstance logInstance2 = new LogInstance(i, i2, str, str2, str3, i3);
            sLogInstanceMap.put(str3, logInstance2);
            return logInstance2;
        }
    }

    public static void closeLogInstance(String str) {
        synchronized (sLogInstanceMap) {
            if (logImp != null && sLogInstanceMap.containsKey(str)) {
                logImp.releaseXlogInstance(str);
                long unused = sLogInstanceMap.remove(str).mLogInstancePtr = -1;
            }
        }
    }

    public static LogInstance getLogInstance(String str) {
        synchronized (sLogInstanceMap) {
            if (!sLogInstanceMap.containsKey(str)) {
                return null;
            }
            LogInstance logInstance = sLogInstanceMap.get(str);
            return logInstance;
        }
    }

    public static class LogInstance {
        /* access modifiers changed from: private */
        public long mLogInstancePtr;
        private String mPrefix;

        private LogInstance(int i, int i2, String str, String str2, String str3, int i3) {
            this.mLogInstancePtr = -1;
            this.mPrefix = null;
            if (Log.logImp != null) {
                this.mLogInstancePtr = Log.logImp.openLogInstance(i, i2, str, str2, str3, i3);
                this.mPrefix = str3;
            }
        }

        public void f(String str, String str2, Object... objArr) {
            String str3;
            if (Log.logImp != null && getLogLevel() <= 5 && this.mLogInstancePtr != -1) {
                if (objArr == null) {
                    str3 = str2;
                } else {
                    str3 = String.format(str2, objArr);
                }
                Log.logImp.logF(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
            }
        }

        public void e(String str, String str2, Object... objArr) {
            String str3;
            if (Log.logImp != null && getLogLevel() <= 4 && this.mLogInstancePtr != -1) {
                if (objArr == null) {
                    str3 = str2;
                } else {
                    str3 = String.format(str2, objArr);
                }
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str;
                Log.logImp.logE(this.mLogInstancePtr, str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
            }
        }

        public void w(String str, String str2, Object... objArr) {
            String str3;
            if (Log.logImp != null && getLogLevel() <= 3 && this.mLogInstancePtr != -1) {
                if (objArr == null) {
                    str3 = str2;
                } else {
                    str3 = String.format(str2, objArr);
                }
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str;
                Log.logImp.logW(this.mLogInstancePtr, str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
            }
        }

        public void i(String str, String str2, Object... objArr) {
            String str3;
            if (Log.logImp != null && getLogLevel() <= 2 && this.mLogInstancePtr != -1) {
                if (objArr == null) {
                    str3 = str2;
                } else {
                    str3 = String.format(str2, objArr);
                }
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str;
                Log.logImp.logI(this.mLogInstancePtr, str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
            }
        }

        public void d(String str, String str2, Object... objArr) {
            String str3;
            if (Log.logImp != null && getLogLevel() <= 1 && this.mLogInstancePtr != -1) {
                if (objArr == null) {
                    str3 = str2;
                } else {
                    str3 = String.format(str2, objArr);
                }
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str;
                Log.logImp.logD(this.mLogInstancePtr, str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
            }
        }

        public void v(String str, String str2, Object... objArr) {
            String str3;
            if (Log.logImp != null && getLogLevel() <= 0 && this.mLogInstancePtr != -1) {
                if (objArr == null) {
                    str3 = str2;
                } else {
                    str3 = String.format(str2, objArr);
                }
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str;
                Log.logImp.logV(this.mLogInstancePtr, str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
            }
        }

        public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            String str3;
            if (Log.logImp != null && getLogLevel() <= 4 && this.mLogInstancePtr != -1) {
                if (objArr == null) {
                    str3 = str2;
                } else {
                    str3 = String.format(str2, objArr);
                }
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str;
                Log.logImp.logE(this.mLogInstancePtr, str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3 + "  " + android.util.Log.getStackTraceString(th));
            }
        }

        public void appenderFlush() {
            if (Log.logImp != null && this.mLogInstancePtr != -1) {
                Log.logImp.appenderFlush(this.mLogInstancePtr, false);
            }
        }

        public void appenderFlushSync() {
            if (Log.logImp != null && this.mLogInstancePtr != -1) {
                Log.logImp.appenderFlush(this.mLogInstancePtr, true);
            }
        }

        public int getLogLevel() {
            if (Log.logImp == null || this.mLogInstancePtr == -1) {
                return 6;
            }
            return Log.logImp.getLogLevel(this.mLogInstancePtr);
        }

        public void setConsoleLogOpen(boolean z) {
            if (Log.logImp != null && this.mLogInstancePtr != -1) {
                Log.logImp.setConsoleLogOpen(this.mLogInstancePtr, z);
            }
        }
    }
}
