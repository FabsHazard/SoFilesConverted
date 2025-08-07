package com.microtech.aidexx.common.net.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011¨\u0006#"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/VersionData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "configId", "", "getConfigId", "()I", "setConfigId", "(I)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "downloadpath", "getDownloadpath", "setDownloadpath", "force", "getForce", "setForce", "sha256", "getSha256", "setSha256", "version", "getVersion", "setVersion", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class VersionData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private int configId;
    private String description;
    private String downloadpath;
    private int force;
    private String sha256;
    private String version;

    public int describeContents() {
        return 0;
    }

    public VersionData() {
        this.version = "";
        this.downloadpath = "";
        this.description = "";
        this.sha256 = "";
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getDownloadpath() {
        return this.downloadpath;
    }

    public final void setDownloadpath(String str) {
        this.downloadpath = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final int getForce() {
        return this.force;
    }

    public final void setForce(int i) {
        this.force = i;
    }

    public final int getConfigId() {
        return this.configId;
    }

    public final void setConfigId(int i) {
        this.configId = i;
    }

    public final String getSha256() {
        return this.sha256;
    }

    public final void setSha256(String str) {
        this.sha256 = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VersionData(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.version = parcel.readString();
        this.downloadpath = parcel.readString();
        this.description = parcel.readString();
        this.force = parcel.readInt();
        this.configId = parcel.readInt();
        this.sha256 = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.version);
        parcel.writeString(this.downloadpath);
        parcel.writeString(this.description);
        parcel.writeInt(this.force);
        parcel.writeInt(this.configId);
        parcel.writeString(this.sha256);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/VersionData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microtech/aidexx/common/net/entity/VersionData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microtech/aidexx/common/net/entity/VersionData;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<VersionData> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public VersionData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VersionData(parcel);
        }

        public VersionData[] newArray(int i) {
            return new VersionData[i];
        }
    }
}
