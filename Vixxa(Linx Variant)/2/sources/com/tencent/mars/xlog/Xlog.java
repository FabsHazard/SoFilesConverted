package com.tencent.mars.xlog;

import com.tencent.mars.xlog.Log;

public class Xlog implements Log.LogImp {
    public static final int AppednerModeAsync = 0;
    public static final int AppednerModeSync = 1;
    public static final int COMPRESS_LEVEL1 = 1;
    public static final int COMPRESS_LEVEL2 = 2;
    public static final int COMPRESS_LEVEL3 = 3;
    public static final int COMPRESS_LEVEL4 = 4;
    public static final int COMPRESS_LEVEL5 = 5;
    public static final int COMPRESS_LEVEL6 = 6;
    public static final int COMPRESS_LEVEL7 = 7;
    public static final int COMPRESS_LEVEL8 = 8;
    public static final int COMPRESS_LEVEL9 = 9;
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    public static final int ZLIB_MODE = 0;
    public static final int ZSTD_MODE = 1;

    public static class XLogConfig {
        public int cachedays = 0;
        public String cachedir;
        public int compresslevel = 0;
        public int compressmode = 0;
        public int level = 2;
        public String logdir;
        public int mode = 0;
        public String nameprefix;
        public String pubkey = "";
    }

    private static native void appenderOpen(XLogConfig xLogConfig);

    private static String decryptTag(String str) {
        return str;
    }

    public static native void logWrite(XLoggerInfo xLoggerInfo, String str);

    public static native void logWrite2(long j, int i, String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4);

    public native void appenderClose();

    public native void appenderFlush(long j, boolean z);

    public native int getLogLevel(long j);

    public native long getXlogInstance(String str);

    public native long newXlogInstance(XLogConfig xLogConfig);

    public native void releaseXlogInstance(String str);

    public native void setAppenderMode(long j, int i);

    public native void setConsoleLogOpen(long j, boolean z);

    public native void setMaxAliveTime(long j, long j2);

    public native void setMaxFileSize(long j, long j2);

    static class XLoggerInfo {
        public String filename;
        public String funcname;
        public int level;
        public int line;
        public long maintid;
        public long pid;
        public String tag;
        public long tid;

        XLoggerInfo() {
        }
    }

    public static void open(boolean z, int i, int i2, String str, String str2, String str3, String str4) {
        if (z) {
            System.loadLibrary("c++_shared");
            System.loadLibrary("marsxlog");
        }
        XLogConfig xLogConfig = new XLogConfig();
        xLogConfig.level = i;
        xLogConfig.mode = i2;
        xLogConfig.logdir = str2;
        xLogConfig.nameprefix = str3;
        xLogConfig.pubkey = str4;
        xLogConfig.compressmode = 0;
        xLogConfig.compresslevel = 0;
        xLogConfig.cachedir = str;
        xLogConfig.cachedays = 0;
        appenderOpen(xLogConfig);
    }

    public void logV(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
        logWrite2(j, 0, decryptTag(str), str2, str3, i, i2, j2, j3, str4);
    }

    public void logD(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
        logWrite2(j, 1, decryptTag(str), str2, str3, i, i2, j2, j3, str4);
    }

    public void logI(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
        logWrite2(j, 2, decryptTag(str), str2, str3, i, i2, j2, j3, str4);
    }

    public void logW(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
        logWrite2(j, 3, decryptTag(str), str2, str3, i, i2, j2, j3, str4);
    }

    public void logE(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
        logWrite2(j, 4, decryptTag(str), str2, str3, i, i2, j2, j3, str4);
    }

    public void logF(long j, String str, String str2, String str3, int i, int i2, long j2, long j3, String str4) {
        logWrite2(j, 5, decryptTag(str), str2, str3, i, i2, j2, j3, str4);
    }

    public void appenderOpen(int i, int i2, String str, String str2, String str3, int i3) {
        XLogConfig xLogConfig = new XLogConfig();
        xLogConfig.level = i;
        xLogConfig.mode = i2;
        xLogConfig.logdir = str2;
        xLogConfig.nameprefix = str3;
        xLogConfig.compressmode = 0;
        xLogConfig.pubkey = "";
        xLogConfig.cachedir = str;
        xLogConfig.cachedays = i3;
        appenderOpen(xLogConfig);
    }

    public static void logWrite2(int i, String str, String str2, String str3, int i2, int i3, long j, long j2, String str4) {
        logWrite2(0, i, str, str2, str3, i2, i3, j, j2, str4);
    }

    public long openLogInstance(int i, int i2, String str, String str2, String str3, int i3) {
        XLogConfig xLogConfig = new XLogConfig();
        xLogConfig.level = i;
        xLogConfig.mode = i2;
        xLogConfig.logdir = str2;
        xLogConfig.nameprefix = str3;
        xLogConfig.compressmode = 0;
        xLogConfig.pubkey = "";
        xLogConfig.cachedir = str;
        xLogConfig.cachedays = i3;
        return newXlogInstance(xLogConfig);
    }
}
