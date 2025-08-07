package com.huawei.hms.scankit.aiscan.common;

import android.os.Parcel;
import android.os.Parcelable;

public enum BarcodeFormat implements Parcelable {
    AZTEC,
    CODABAR,
    CODE_39,
    CODE_93,
    CODE_128,
    DATA_MATRIX,
    EAN_8,
    EAN_13,
    ITF,
    PDF_417,
    QR_CODE,
    UPC_A,
    UPC_E,
    UPC_EAN_EXTENSION,
    NONE,
    HARMONY_CODE,
    WXCODE;
    
    public static final Parcelable.Creator<BarcodeFormat> CREATOR = null;

    class a implements Parcelable.Creator<BarcodeFormat> {
        a() {
        }

        /* renamed from: a */
        public BarcodeFormat createFromParcel(Parcel parcel) {
            return BarcodeFormat.values()[parcel.readInt()];
        }

        /* renamed from: a */
        public BarcodeFormat[] newArray(int i) {
            return new BarcodeFormat[i];
        }
    }

    static {
        CREATOR = new a();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
