package com.microtech.aidexx.common.net.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0012H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/VersionInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "info", "Lcom/microtech/aidexx/common/net/entity/VersionData;", "getInfo", "()Lcom/microtech/aidexx/common/net/entity/VersionData;", "setInfo", "(Lcom/microtech/aidexx/common/net/entity/VersionData;)V", "isForce", "", "()Z", "setForce", "(Z)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class VersionInfo implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private VersionData info;
    private boolean isForce;

    public int describeContents() {
        return 0;
    }

    public VersionInfo() {
    }

    public final boolean isForce() {
        return this.isForce;
    }

    public final void setForce(boolean z) {
        this.isForce = z;
    }

    public final VersionData getInfo() {
        return this.info;
    }

    public final void setInfo(VersionData versionData) {
        this.info = versionData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VersionInfo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.isForce = parcel.readByte() != 0;
        this.info = (VersionData) parcel.readParcelable(VersionData.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.isForce ? (byte) 1 : 0);
        parcel.writeParcelable(this.info, i);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/VersionInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microtech/aidexx/common/net/entity/VersionInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microtech/aidexx/common/net/entity/VersionInfo;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<VersionInfo> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public VersionInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VersionInfo(parcel);
        }

        public VersionInfo[] newArray(int i) {
            return new VersionInfo[i];
        }
    }
}
