package com.simple.spiderman.utils;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class CrashModel implements Parcelable {
    public static final Parcelable.Creator<CrashModel> CREATOR = new Parcelable.Creator<CrashModel>() {
        public CrashModel createFromParcel(Parcel parcel) {
            return new CrashModel(parcel);
        }

        public CrashModel[] newArray(int i) {
            return new CrashModel[i];
        }
    };
    private String className;
    private Device device = new Device();
    private Throwable ex;
    private String exceptionMsg;
    private String exceptionType;
    private String fileName;
    private String fullException;
    private int lineNumber;
    private String methodName;
    private String packageName;
    private long time;
    private String versionCode;
    private String versionName;

    public int describeContents() {
        return 0;
    }

    protected CrashModel(Parcel parcel) {
        this.ex = (Throwable) parcel.readSerializable();
        this.exceptionMsg = parcel.readString();
        this.className = parcel.readString();
        this.fileName = parcel.readString();
        this.methodName = parcel.readString();
        this.lineNumber = parcel.readInt();
        this.exceptionType = parcel.readString();
        this.fullException = parcel.readString();
        this.time = parcel.readLong();
        this.versionCode = parcel.readString();
        this.versionName = parcel.readString();
    }

    public CrashModel() {
    }

    public Throwable getEx() {
        return this.ex;
    }

    public void setEx(Throwable th) {
        this.ex = th;
    }

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String str) {
        this.exceptionMsg = str;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public String getFileName() {
        return TextUtils.isEmpty(this.fileName) ? this.className : this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String str) {
        this.methodName = str;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(int i) {
        this.lineNumber = i;
    }

    public String getExceptionType() {
        return this.exceptionType;
    }

    public void setExceptionType(String str) {
        this.exceptionType = str;
    }

    public String getFullException() {
        return this.fullException;
    }

    public void setFullException(String str) {
        this.fullException = str;
    }

    public String getPackageName() {
        return getClassName().replace(getFileName(), "");
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public Device getDevice() {
        return this.device;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.ex);
        parcel.writeString(this.exceptionMsg);
        parcel.writeString(this.className);
        parcel.writeString(this.fileName);
        parcel.writeString(this.methodName);
        parcel.writeInt(this.lineNumber);
        parcel.writeString(this.exceptionType);
        parcel.writeString(this.fullException);
        parcel.writeLong(this.time);
        parcel.writeString(this.versionCode);
        parcel.writeString(this.versionName);
    }

    public static class Device implements Parcelable {
        public static final Parcelable.Creator<Device> CREATOR = new Parcelable.Creator<Device>() {
            public Device createFromParcel(Parcel parcel) {
                return new Device(parcel);
            }

            public Device[] newArray(int i) {
                return new Device[i];
            }
        };
        private String brand = Build.BRAND;
        private String cpuAbi = Build.CPU_ABI;
        private String model = Build.MODEL;
        private String release = Build.VERSION.RELEASE;
        private String version = String.valueOf(Build.VERSION.SDK_INT);

        public int describeContents() {
            return 0;
        }

        public Device() {
        }

        protected Device(Parcel parcel) {
            this.model = parcel.readString();
            this.brand = parcel.readString();
            this.version = parcel.readString();
            this.release = parcel.readString();
            this.cpuAbi = parcel.readString();
        }

        public String getModel() {
            return this.model;
        }

        public String getBrand() {
            return this.brand;
        }

        public String getVersion() {
            return this.version;
        }

        public String getRelease() {
            return this.release;
        }

        public String getCpuAbi() {
            return this.cpuAbi;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.model);
            parcel.writeString(this.brand);
            parcel.writeString(this.version);
            parcel.writeString(this.release);
            parcel.writeString(this.cpuAbi);
        }
    }

    public String toString() {
        return "CrashModel{ex=" + this.ex + ", packageName='" + this.packageName + "', exceptionMsg='" + this.exceptionMsg + "', className='" + this.className + "', fileName='" + this.fileName + "', methodName='" + this.methodName + "', lineNumber=" + this.lineNumber + ", exceptionType='" + this.exceptionType + "', fullException='" + this.fullException + "', time=" + this.time + ", device=" + this.device + ", versionCode='" + this.versionCode + "', versionName='" + this.versionName + "'}";
    }
}
