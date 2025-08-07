package com.simple.spiderman.utils;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.simple.spiderman.utils.CrashModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SpiderManUtils {
    public static CrashModel parseCrash(Context context, Throwable th) {
        CrashModel crashModel = new CrashModel();
        try {
            crashModel.setEx(th);
            crashModel.setTime(new Date().getTime());
            if (th.getCause() != null) {
                th = th.getCause();
            }
            crashModel.setExceptionMsg(th.getMessage());
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String name = th.getClass().getName();
            StackTraceElement parseThrowable = parseThrowable(context, th);
            if (parseThrowable == null) {
                return crashModel;
            }
            crashModel.setLineNumber(parseThrowable.getLineNumber());
            crashModel.setClassName(parseThrowable.getClassName());
            crashModel.setFileName(parseThrowable.getFileName());
            crashModel.setMethodName(parseThrowable.getMethodName());
            crashModel.setExceptionType(name);
            crashModel.setFullException(stringWriter.toString());
            crashModel.setVersionCode(getVersionCode(context));
            crashModel.setVersionName(getVersionName(context));
            return crashModel;
        } catch (Exception unused) {
        }
    }

    public static StackTraceElement parseThrowable(Context context, Throwable th) {
        if (th == null || th.getStackTrace() == null || th.getStackTrace().length == 0) {
            return null;
        }
        String packageName = context.getPackageName();
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (stackTraceElement.getClassName().contains(packageName)) {
                return stackTraceElement;
            }
        }
        return th.getStackTrace()[0];
    }

    public static String getCachePath(Context context) {
        return context.getCacheDir().getAbsolutePath();
    }

    public static String getVersionCode(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getVersionName(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (Exception unused) {
            return "";
        }
    }

    public static Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]), new Object[0]);
            if (invoke != null) {
                return (Application) invoke;
            }
            throw new NullPointerException("you should init first");
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException("you should init first");
        }
    }

    public static void killApp() {
        Process.killProcess(Process.myPid());
    }

    public static String getShareText(Context context, CrashModel crashModel) {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm", Locale.getDefault());
        sb.append(context.getString(R.string.simpleCrashInfo)).append("\n").append(crashModel.getExceptionMsg()).append("\n\n");
        sb.append(context.getString(R.string.simpleClassName)).append(crashModel.getFileName()).append("\n\n");
        sb.append(context.getString(R.string.simpleFunName)).append(crashModel.getMethodName()).append("\n\n");
        sb.append(context.getString(R.string.simpleLineNum)).append(crashModel.getLineNumber()).append("\n\n");
        sb.append(context.getString(R.string.simpleExceptionType)).append(crashModel.getExceptionType()).append("\n\n");
        sb.append(context.getString(R.string.simpleTime)).append(simpleDateFormat.format(Long.valueOf(crashModel.getTime()))).append("\n\n");
        CrashModel.Device device = crashModel.getDevice();
        sb.append(context.getString(R.string.simpleModel)).append(crashModel.getDevice().getModel()).append("\n\n");
        sb.append(context.getString(R.string.simpleBrand)).append(crashModel.getDevice().getBrand()).append("\n\n");
        sb.append(context.getString(R.string.simpleVersion)).append("Android " + device.getRelease() + "-" + device.getVersion()).append("\n\nCPU-ABI:");
        sb.append(device.getCpuAbi()).append("\n\nversionCode:");
        sb.append(crashModel.getVersionCode()).append("\n\nversionName:");
        sb.append(crashModel.getVersionName()).append("\n\n");
        sb.append(context.getString(R.string.simpleAllInfo)).append("\n").append(crashModel.getFullException()).append("\n");
        return sb.toString();
    }

    public static void saveTextToFile(String str, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(str);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void saveTextToFile(String str, String str2) throws IOException {
        saveTextToFile(str, new File(str2));
    }
}
