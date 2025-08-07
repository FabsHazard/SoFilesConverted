package com.microtech.aidexx.common.net.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/UpgradeInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appUpdateInfo", "Lcom/microtech/aidexx/common/net/entity/VersionInfo;", "getAppUpdateInfo", "()Lcom/microtech/aidexx/common/net/entity/VersionInfo;", "setAppUpdateInfo", "(Lcom/microtech/aidexx/common/net/entity/VersionInfo;)V", "resourceUpdateInfo", "getResourceUpdateInfo", "setResourceUpdateInfo", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class UpgradeInfo implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private VersionInfo appUpdateInfo;
    private VersionInfo resourceUpdateInfo;

    public int describeContents() {
        return 0;
    }

    public UpgradeInfo() {
    }

    public final VersionInfo getAppUpdateInfo() {
        return this.appUpdateInfo;
    }

    public final void setAppUpdateInfo(VersionInfo versionInfo) {
        this.appUpdateInfo = versionInfo;
    }

    public final VersionInfo getResourceUpdateInfo() {
        return this.resourceUpdateInfo;
    }

    public final void setResourceUpdateInfo(VersionInfo versionInfo) {
        this.resourceUpdateInfo = versionInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UpgradeInfo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.appUpdateInfo = (VersionInfo) parcel.readParcelable(VersionInfo.class.getClassLoader());
        this.resourceUpdateInfo = (VersionInfo) parcel.readParcelable(VersionInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.appUpdateInfo, i);
        parcel.writeParcelable(this.resourceUpdateInfo, i);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/UpgradeInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microtech/aidexx/common/net/entity/UpgradeInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microtech/aidexx/common/net/entity/UpgradeInfo;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<UpgradeInfo> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public UpgradeInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UpgradeInfo(parcel);
        }

        public UpgradeInfo[] newArray(int i) {
            return new UpgradeInfo[i];
        }
    }
}
