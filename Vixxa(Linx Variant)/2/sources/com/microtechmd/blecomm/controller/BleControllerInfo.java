package com.microtechmd.blecomm.controller;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

public class BleControllerInfo implements Parcelable {
    public static final Parcelable.Creator<BleControllerInfo> CREATOR = new Parcelable.Creator<BleControllerInfo>() {
        public BleControllerInfo createFromParcel(Parcel parcel) {
            return new BleControllerInfo(parcel);
        }

        public BleControllerInfo[] newArray(int i) {
            return new BleControllerInfo[i];
        }
    };
    public String address;
    public int calTemp;
    public boolean isPaired;
    public String name;
    public byte[] params;
    public int rssi;
    public String sn;
    public int status;
    public int type;

    public int describeContents() {
        return 0;
    }

    public BleControllerInfo() {
    }

    public BleControllerInfo(int i, String str, String str2, String str3) {
        this.type = i;
        this.address = str;
        this.name = str2;
        this.sn = str3;
    }

    public BleControllerInfo(int i, String str, String str2, String str3, int i2, byte[] bArr) {
        this.type = i;
        this.address = str;
        this.name = str2;
        this.sn = str3;
        this.rssi = i2;
        this.params = bArr;
    }

    protected BleControllerInfo(Parcel parcel) {
        this.address = parcel.readString();
        this.name = parcel.readString();
        this.sn = parcel.readString();
        this.rssi = parcel.readInt();
        this.params = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleControllerInfo)) {
            return false;
        }
        BleControllerInfo bleControllerInfo = (BleControllerInfo) obj;
        if (!Objects.equals(this.address, bleControllerInfo.address) || !Objects.equals(this.name, bleControllerInfo.name) || !Objects.equals(this.sn, bleControllerInfo.sn)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.address, this.name, this.sn});
    }

    public String toString() {
        return "BleControllerInfo{type=" + this.type + ", address='" + this.address + "', name='" + this.name + "', sn='" + this.sn + "', rssi=" + this.rssi + ", params=" + Arrays.toString(this.params) + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.address);
        parcel.writeString(this.name);
        parcel.writeString(this.sn);
        parcel.writeInt(this.rssi);
        parcel.writeByteArray(this.params);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getSn() {
        return this.sn;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public int getRssi() {
        return this.rssi;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public byte[] getParams() {
        return this.params;
    }

    public void setParams(byte[] bArr) {
        this.params = bArr;
    }

    public boolean isPaired() {
        return this.isPaired;
    }

    public void setPaired(boolean z) {
        this.isPaired = z;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getCalTemp() {
        return this.calTemp;
    }

    public void setCalTemp(int i) {
        this.calTemp = i;
    }
}
