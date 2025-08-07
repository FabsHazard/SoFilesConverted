package com.microtech.aidexx.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.microtech.aidexx.utils.UnitManager;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b4\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 ]2\u00020\u0001:\u0001]B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010X\u001a\u00020\u0007H\u0016J\b\u0010Y\u001a\u00020&H\u0016J\u0018\u0010Z\u001a\u00020[2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u000bR\u001a\u0010.\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR\u001a\u00101\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\t\"\u0004\b3\u0010\u000bR\u001a\u00104\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\t\"\u0004\b6\u0010\u000bR\u001a\u00107\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\t\"\u0004\b9\u0010\u000bR\u001a\u0010:\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\t\"\u0004\b<\u0010\u000bR\u001c\u0010=\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010(\"\u0004\b?\u0010*R\u001a\u0010@\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\t\"\u0004\bB\u0010\u000bR\u001a\u0010C\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\t\"\u0004\bE\u0010\u000bR\u001a\u0010F\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\t\"\u0004\bH\u0010\u000bR\u001a\u0010I\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\t\"\u0004\bK\u0010\u000bR\u001a\u0010L\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001b\"\u0004\bN\u0010\u001dR\u001c\u0010O\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010(\"\u0004\bQ\u0010*R\u001c\u0010R\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010(\"\u0004\bT\u0010*R\u001a\u0010U\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\t\"\u0004\bW\u0010\u000b¨\u0006^"}, d2 = {"Lcom/microtech/aidexx/db/entity/SettingsEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "alertRate", "", "getAlertRate", "()I", "setAlertRate", "(I)V", "alertType", "getAlertType", "setAlertType", "fastDownSwitch", "getFastDownSwitch", "setFastDownSwitch", "fastUpSwitch", "getFastUpSwitch", "setFastUpSwitch", "highAlertSwitch", "getHighAlertSwitch", "setHighAlertSwitch", "highLimitMg", "", "getHighLimitMg", "()F", "setHighLimitMg", "(F)V", "inDaylightTime", "", "getInDaylightTime", "()Ljava/lang/Boolean;", "setInDaylightTime", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "language", "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "lowAlertSwitch", "getLowAlertSwitch", "setLowAlertSwitch", "lowLimitMg", "getLowLimitMg", "setLowLimitMg", "signalMissingAlertRate", "getSignalMissingAlertRate", "setSignalMissingAlertRate", "signalMissingAlertType", "getSignalMissingAlertType", "setSignalMissingAlertType", "signalMissingSwitch", "getSignalMissingSwitch", "setSignalMissingSwitch", "theme", "getTheme", "setTheme", "timeZone", "getTimeZone", "setTimeZone", "unit", "getUnit", "setUnit", "urgentAlertRate", "getUrgentAlertRate", "setUrgentAlertRate", "urgentAlertType", "getUrgentAlertType", "setUrgentAlertType", "urgentLowAlertSwitch", "getUrgentLowAlertSwitch", "setUrgentLowAlertSwitch", "urgentLowMg", "getUrgentLowMg", "setUrgentLowMg", "userId", "getUserId", "setUserId", "userSettingId", "getUserSettingId", "setUserSettingId", "version", "getVersion", "setVersion", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingsEntity.kt */
public final class SettingsEntity implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private int alertRate;
    private int alertType;
    private int fastDownSwitch;
    private int fastUpSwitch;
    private int highAlertSwitch;
    private float highLimitMg;
    private Boolean inDaylightTime;
    private String language;
    private int lowAlertSwitch;
    private float lowLimitMg;
    private int signalMissingAlertRate;
    private int signalMissingAlertType;
    private int signalMissingSwitch;
    private int theme;
    private String timeZone;
    private int unit;
    private int urgentAlertRate;
    private int urgentAlertType;
    private int urgentLowAlertSwitch;
    private float urgentLowMg;
    private String userId;
    private String userSettingId;
    private int version;

    public int describeContents() {
        return 0;
    }

    public SettingsEntity() {
        this.inDaylightTime = Boolean.valueOf(TimeZone.getDefault().inDaylightTime(new Date()));
        this.unit = UnitManager.INSTANCE.getUnit();
        this.theme = 1;
        this.alertType = 3;
        this.alertRate = 30;
        this.lowLimitMg = 70.200005f;
        this.highLimitMg = 180.0f;
        this.urgentLowMg = 54.0f;
        this.urgentAlertType = 3;
        this.urgentAlertRate = 5;
        this.signalMissingAlertType = 3;
        this.signalMissingAlertRate = 15;
    }

    public final Boolean getInDaylightTime() {
        return this.inDaylightTime;
    }

    public final void setInDaylightTime(Boolean bool) {
        this.inDaylightTime = bool;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final void setTimeZone(String str) {
        this.timeZone = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final int getUnit() {
        return this.unit;
    }

    public final void setUnit(int i) {
        this.unit = i;
    }

    public final int getTheme() {
        return this.theme;
    }

    public final void setTheme(int i) {
        this.theme = i;
    }

    public final String getUserSettingId() {
        return this.userSettingId;
    }

    public final void setUserSettingId(String str) {
        this.userSettingId = str;
    }

    public final int getAlertType() {
        return this.alertType;
    }

    public final void setAlertType(int i) {
        this.alertType = i;
    }

    public final int getAlertRate() {
        return this.alertRate;
    }

    public final void setAlertRate(int i) {
        this.alertRate = i;
    }

    public final int getLowAlertSwitch() {
        return this.lowAlertSwitch;
    }

    public final void setLowAlertSwitch(int i) {
        this.lowAlertSwitch = i;
    }

    public final float getLowLimitMg() {
        return this.lowLimitMg;
    }

    public final void setLowLimitMg(float f) {
        this.lowLimitMg = f;
    }

    public final int getHighAlertSwitch() {
        return this.highAlertSwitch;
    }

    public final void setHighAlertSwitch(int i) {
        this.highAlertSwitch = i;
    }

    public final float getHighLimitMg() {
        return this.highLimitMg;
    }

    public final void setHighLimitMg(float f) {
        this.highLimitMg = f;
    }

    public final int getFastUpSwitch() {
        return this.fastUpSwitch;
    }

    public final void setFastUpSwitch(int i) {
        this.fastUpSwitch = i;
    }

    public final int getFastDownSwitch() {
        return this.fastDownSwitch;
    }

    public final void setFastDownSwitch(int i) {
        this.fastDownSwitch = i;
    }

    public final int getUrgentLowAlertSwitch() {
        return this.urgentLowAlertSwitch;
    }

    public final void setUrgentLowAlertSwitch(int i) {
        this.urgentLowAlertSwitch = i;
    }

    public final float getUrgentLowMg() {
        return this.urgentLowMg;
    }

    public final void setUrgentLowMg(float f) {
        this.urgentLowMg = f;
    }

    public final int getUrgentAlertType() {
        return this.urgentAlertType;
    }

    public final void setUrgentAlertType(int i) {
        this.urgentAlertType = i;
    }

    public final int getUrgentAlertRate() {
        return this.urgentAlertRate;
    }

    public final void setUrgentAlertRate(int i) {
        this.urgentAlertRate = i;
    }

    public final int getSignalMissingSwitch() {
        return this.signalMissingSwitch;
    }

    public final void setSignalMissingSwitch(int i) {
        this.signalMissingSwitch = i;
    }

    public final int getSignalMissingAlertType() {
        return this.signalMissingAlertType;
    }

    public final void setSignalMissingAlertType(int i) {
        this.signalMissingAlertType = i;
    }

    public final int getSignalMissingAlertRate() {
        return this.signalMissingAlertRate;
    }

    public final void setSignalMissingAlertRate(int i) {
        this.signalMissingAlertRate = i;
    }

    public final int getVersion() {
        return this.version;
    }

    public final void setVersion(int i) {
        this.version = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SettingsEntity(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.language = parcel.readString();
        this.timeZone = parcel.readString();
        this.unit = parcel.readInt();
        this.theme = parcel.readInt();
        this.userSettingId = parcel.readString();
        this.alertType = parcel.readInt();
        this.alertRate = parcel.readInt();
        this.lowAlertSwitch = parcel.readInt();
        this.lowLimitMg = parcel.readFloat();
        this.highAlertSwitch = parcel.readInt();
        this.highLimitMg = parcel.readFloat();
        this.fastUpSwitch = parcel.readInt();
        this.fastDownSwitch = parcel.readInt();
        this.urgentLowAlertSwitch = parcel.readInt();
        this.urgentLowMg = parcel.readFloat();
        this.urgentAlertType = parcel.readInt();
        this.urgentAlertRate = parcel.readInt();
        this.signalMissingSwitch = parcel.readInt();
        this.signalMissingAlertType = parcel.readInt();
        this.signalMissingAlertRate = parcel.readInt();
        this.version = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.language);
        parcel.writeString(this.timeZone);
        parcel.writeInt(this.unit);
        parcel.writeInt(this.theme);
        parcel.writeString(this.userSettingId);
        parcel.writeInt(this.alertType);
        parcel.writeInt(this.alertRate);
        parcel.writeInt(this.lowAlertSwitch);
        parcel.writeFloat(this.lowLimitMg);
        parcel.writeInt(this.highAlertSwitch);
        parcel.writeFloat(this.highLimitMg);
        parcel.writeInt(this.fastUpSwitch);
        parcel.writeInt(this.fastDownSwitch);
        parcel.writeInt(this.urgentLowAlertSwitch);
        parcel.writeFloat(this.urgentLowMg);
        parcel.writeInt(this.urgentAlertType);
        parcel.writeInt(this.urgentAlertRate);
        parcel.writeInt(this.signalMissingSwitch);
        parcel.writeInt(this.signalMissingAlertType);
        parcel.writeInt(this.signalMissingAlertRate);
        parcel.writeInt(this.version);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SettingsEntity(language=");
        sb.append(this.language).append(", timeZone=").append(this.timeZone).append(", userId=").append(this.userId).append(", unit=").append(this.unit).append(", theme=").append(this.theme).append(", userSettingId=").append(this.userSettingId).append(", alertType=").append(this.alertType).append(", alertRate=").append(this.alertRate).append(", lowAlertSwitch=").append(this.lowAlertSwitch).append(", lowLimitMg=").append(this.lowLimitMg).append(", highAlertSwitch=").append(this.highAlertSwitch).append(", highLimitMg=");
        sb.append(this.highLimitMg).append(", fastUpSwitch=").append(this.fastUpSwitch).append(", fastDownSwitch=").append(this.fastDownSwitch).append(", urgentLowAlertSwitch=").append(this.urgentLowAlertSwitch).append(", urgentLowMg=").append(this.urgentLowMg).append(", urgentAlertType=").append(this.urgentAlertType).append(", urgentAlertRate=").append(this.urgentAlertRate).append(", signalMissingSwitch=").append(this.signalMissingSwitch).append(", signalMissingAlertType=").append(this.signalMissingAlertType).append(", signalMissingAlertRate=").append(this.signalMissingAlertRate).append(", version=").append(this.version).append(')');
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/db/entity/SettingsEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microtech/aidexx/db/entity/SettingsEntity;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microtech/aidexx/db/entity/SettingsEntity;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingsEntity.kt */
    public static final class CREATOR implements Parcelable.Creator<SettingsEntity> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public SettingsEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SettingsEntity(parcel);
        }

        public SettingsEntity[] newArray(int i) {
            return new SettingsEntity[i];
        }
    }
}
