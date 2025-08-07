package com.microtech.aidexx.db.entity;

import android.content.res.Resources;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.TimeUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010C\u001a\u00020\u001bJ\u0006\u0010D\u001a\u00020EJ\b\u0010F\u001a\u00020GH\u0002J\u0006\u0010H\u001a\u00020\u0014J\u001a\u0010I\u001a\u00020\n2\b\b\u0002\u0010J\u001a\u00020\n2\b\b\u0002\u0010K\u001a\u00020GJ\u0010\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020NH&J\u0010\u0010O\u001a\u00020\n2\u0006\u0010M\u001a\u00020NH&J\u000e\u0010P\u001a\u00020E2\u0006\u0010Q\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u001b8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR\u001c\u0010#\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\"\u0010&\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010)\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001c\u0010/\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\"\u00102\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001e\u00105\u001a\u00020\u001b8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR\u001e\u00108\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001d\"\u0004\b?\u0010\u001fR \u0010@\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u000f¨\u0006R"}, d2 = {"Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "", "()V", "appCreateTime", "Ljava/util/Date;", "getAppCreateTime", "()Ljava/util/Date;", "setAppCreateTime", "(Ljava/util/Date;)V", "value", "", "appTime", "getAppTime", "()Ljava/lang/String;", "setAppTime", "(Ljava/lang/String;)V", "appTimeZone", "getAppTimeZone", "setAppTimeZone", "autoIncrementColumn", "", "getAutoIncrementColumn", "()Ljava/lang/Long;", "setAutoIncrementColumn", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "deleteStatus", "", "getDeleteStatus", "()I", "setDeleteStatus", "(I)V", "dstOffset", "getDstOffset", "setDstOffset", "id", "getId", "setId", "idx", "getIdx", "setIdx", "language", "getLanguage", "setLanguage", "moment", "getMoment", "setMoment", "recordId", "getRecordId", "setRecordId", "recordIndex", "getRecordIndex", "setRecordIndex", "state", "getState", "setState", "timestamp", "getTimestamp", "()J", "setTimestamp", "(J)V", "uploadState", "getUploadState", "setUploadState", "userId", "getUserId", "setUserId", "calDstOffset", "calTimestamp", "", "canCalTimestamp", "", "convertToCurZoneTs", "getDisplayTime", "formatStr", "useDeviceTimeZone", "getEventDescription", "res", "Landroid/content/res/Resources;", "getValueDescription", "setTimeInfo", "date", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventEntity.kt */
public abstract class BaseEventEntity {
    private Date appCreateTime = new Date();
    private String appTime;
    private String appTimeZone;
    private Long autoIncrementColumn;
    private int deleteStatus;
    private String dstOffset;
    private String id;
    private Long idx;
    private String language = "";
    private int moment;
    private String recordId;
    private Long recordIndex;
    private int state;
    private long timestamp;
    private int uploadState;
    private String userId;

    public abstract String getEventDescription(Resources resources);

    public abstract String getValueDescription(Resources resources);

    public Long getIdx() {
        return this.idx;
    }

    public void setIdx(Long l) {
        this.idx = l;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public Long getRecordIndex() {
        return this.recordIndex;
    }

    public void setRecordIndex(Long l) {
        this.recordIndex = l;
    }

    public Date getAppCreateTime() {
        return this.appCreateTime;
    }

    public void setAppCreateTime(Date date) {
        this.appCreateTime = date;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(String str) {
        this.recordId = str;
    }

    public int getDeleteStatus() {
        return this.deleteStatus;
    }

    public void setDeleteStatus(int i) {
        this.deleteStatus = i;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.language = str;
    }

    public int getUploadState() {
        return this.uploadState;
    }

    public void setUploadState(int i) {
        this.uploadState = i;
    }

    public final Long getAutoIncrementColumn() {
        return this.autoIncrementColumn;
    }

    public final void setAutoIncrementColumn(Long l) {
        this.autoIncrementColumn = l;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final int getMoment() {
        return this.moment;
    }

    public final void setMoment(int i) {
        this.moment = i;
    }

    public final String getAppTime() {
        return this.appTime;
    }

    public final void setAppTime(String str) {
        this.appTime = str;
        calTimestamp();
    }

    public final String getAppTimeZone() {
        return this.appTimeZone;
    }

    public final void setAppTimeZone(String str) {
        this.appTimeZone = str;
        calTimestamp();
    }

    public final String getDstOffset() {
        return this.dstOffset;
    }

    public final void setDstOffset(String str) {
        this.dstOffset = str;
        calTimestamp();
    }

    public final int calDstOffset() {
        TimeZone timeZone = TimeZone.getDefault();
        if (timeZone.inDaylightTime(new Date())) {
            return timeZone.getDSTSavings() / 1000;
        }
        return 0;
    }

    public static /* synthetic */ String getDisplayTime$default(BaseEventEntity baseEventEntity, String str, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = ExtendsKt.DATE_FORMAT_HM;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return baseEventEntity.getDisplayTime(str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDisplayTime");
    }

    public final String getDisplayTime(String str, boolean z) {
        TimeZone timeZone;
        Intrinsics.checkNotNullParameter(str, "formatStr");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        if (z) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = TimeZone.getTimeZone(this.appTimeZone);
        }
        simpleDateFormat.setTimeZone(timeZone);
        try {
            String format = simpleDateFormat.format(Long.valueOf(this.timestamp));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } catch (Exception unused) {
            LogUtil.Companion.e$default(LogUtil.Companion, "getDisplayTime error " + this.timestamp + " f=" + str + " useDeviceTimeZone=" + z, (String) null, 2, (Object) null);
            return "";
        }
    }

    public final void setTimeInfo(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        setAppTime(ExtendsKt.formatWithoutZone(date));
        setAppTimeZone(TimeZone.getDefault().getID());
        setDstOffset(String.valueOf(calDstOffset()));
    }

    public final void calTimestamp() {
        long j;
        if (canCalTimestamp()) {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            String str = this.appTime;
            Intrinsics.checkNotNull(str);
            String str2 = this.appTimeZone;
            Intrinsics.checkNotNull(str2);
            Long calTimestamp = timeUtils.calTimestamp(str, str2, Intrinsics.areEqual((Object) this.dstOffset, (Object) "1"));
            if (calTimestamp != null) {
                j = calTimestamp.longValue();
            } else {
                BaseEventEntity baseEventEntity = this;
                LogUtil.Companion.d$default(LogUtil.Companion, "calTimestamp error=> " + this.appTime + ' ' + this.appTimeZone + ' ' + this.dstOffset, (String) null, 2, (Object) null);
                j = System.currentTimeMillis();
            }
            this.timestamp = j;
        }
    }

    private final boolean canCalTimestamp() {
        return (this.appTime == null || this.appTimeZone == null || this.dstOffset == null) ? false : true;
    }

    public final long convertToCurZoneTs() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ExtendsKt.DATE_FORMAT_YMDHMS, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeUtils.INSTANCE.getCDFTimezone());
            String str = this.appTime;
            Intrinsics.checkNotNull(str);
            Date parse = simpleDateFormat.parse(str);
            Intrinsics.checkNotNull(parse);
            return parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return this.timestamp;
        }
    }
}
