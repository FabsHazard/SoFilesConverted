package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.EventActions;
import java.util.Date;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010)\u001a\u00020\u001bJ\b\u0010*\u001a\u00020\u001bH\u0016J\u000f\u0010+\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\u0016J\u0017\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u001bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u001b8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001a\u0010&\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001f¨\u00063"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lcom/microtech/aidexx/db/entity/event/EventActions;", "()V", "createTime", "Ljava/util/Date;", "getCreateTime", "()Ljava/util/Date;", "setCreateTime", "(Ljava/util/Date;)V", "deleteFlag", "", "getDeleteFlag", "()I", "setDeleteFlag", "(I)V", "idx", "", "getIdx", "()J", "setIdx", "(J)V", "isUserInputType", "", "()Z", "setUserInputType", "(Z)V", "language", "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "name", "getName", "setName", "updateTime", "getUpdateTime", "setUpdateTime", "userId", "getUserId", "setUserId", "genUuid", "getPresetId", "getServerPresetId", "()Ljava/lang/Long;", "isUserPreset", "setServerPresetId", "", "serverId", "(Ljava/lang/Long;)V", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MPresetEntity.kt */
public class BasePresetEntity implements EventActions {
    private transient Date createTime = new Date();
    private int deleteFlag;
    private long idx;
    private transient boolean isUserInputType;
    private String language = "";
    private String name = "";
    private transient Date updateTime = new Date();
    private String userId = "";

    public Long getServerPresetId() {
        return null;
    }

    public void setServerPresetId(Long l) {
    }

    public String getEventDesc(String str) {
        return EventActions.DefaultImpls.getEventDesc(this, str);
    }

    public long getIdx() {
        return this.idx;
    }

    public void setIdx(long j) {
        this.idx = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public int getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(int i) {
        this.deleteFlag = i;
    }

    public final boolean isUserInputType() {
        return this.isUserInputType;
    }

    public final void setUserInputType(boolean z) {
        this.isUserInputType = z;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.createTime = date;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.updateTime = date;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.language = str;
    }

    public String toString() {
        return "idx=" + getIdx() + ", name=" + getName() + ", delete_flag=" + getDeleteFlag() + ", create_time=" + getCreateTime() + ", update_time=" + getUpdateTime();
    }

    public final String genUuid() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null);
    }

    public final boolean isUserPreset() {
        return !(this instanceof BaseSysPreset);
    }

    public String getPresetId() {
        if (!isUserPreset()) {
            return String.valueOf(getServerPresetId());
        }
        return "";
    }
}
