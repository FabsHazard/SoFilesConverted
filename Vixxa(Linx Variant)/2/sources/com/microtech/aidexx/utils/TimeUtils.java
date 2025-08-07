package com.microtech.aidexx.utils;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.microtech.aidexx.common.ExtendsKt;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.joda.time.DateTimeConstants;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\fJ\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\nJ\u0010\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020\u0014J\u0018\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0004J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0014H\u0002J\b\u0010+\u001a\u0004\u0018\u00010\u0014J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\fJ\u0006\u0010/\u001a\u00020\fJ\u000e\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fJ\u0014\u00102\u001a\u00020\u0014*\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u0014R\u001c\u0010\u0003\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\f8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/microtech/aidexx/utils/TimeUtils;", "", "()V", "currentDate", "Ljava/util/Date;", "getCurrentDate", "()Ljava/util/Date;", "setCurrentDate", "(Ljava/util/Date;)V", "currentStandardTimezone", "Ljava/util/TimeZone;", "currentTimeMillis", "", "getCurrentTimeMillis", "()J", "setCurrentTimeMillis", "(J)V", "currentTimezone", "noDstTimezone", "", "", "oneDayHour", "", "oneDayMillis", "oneDaySeconds", "oneHourSeconds", "oneMinuteMillis", "calTimestamp", "yyyyMMddHHmmss", "timeZone", "useDaylightTime", "", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Long;", "genRandomLoadingTime", "getCDFTimezone", "getCDFTimezoneById", "getDstEndDate", "timeZoneId", "getDstStartDate", "getNextTransaction", "time", "getStandardTimezone", "id", "getTimeZoneId", "getTimezoneOffset", "timezoneId", "timestamp", "timeZoneOffsetSeconds", "zeroOfDay", "second", "dateHourMinute", "pattern", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeUtils.kt */
public final class TimeUtils {
    public static final TimeUtils INSTANCE = new TimeUtils();
    private static Date currentDate = new Date();
    private static TimeZone currentStandardTimezone = null;
    private static long currentTimeMillis = 0;
    private static TimeZone currentTimezone = null;
    private static final Map<String, String> noDstTimezone = MapsKt.mapOf(TuplesKt.to("UTC-1200", "Etc/GMT+12"), TuplesKt.to("UTC-1100", "Pacific/Midway"), TuplesKt.to("UTC-1000", "Pacific/Tahiti"), TuplesKt.to("UTC-0930", "Pacific/Marquesas"), TuplesKt.to("UTC-0900", "Pacific/Gambier"), TuplesKt.to("UTC-0800", "Pacific/Pitcairn"), TuplesKt.to("UTC-0700", "Etc/GMT+7"), TuplesKt.to("UTC-0600", "America/Guatemala"), TuplesKt.to("UTC-0500", "America/Jamaica"), TuplesKt.to("UTC-0400", "America/Aruba"), TuplesKt.to("UTC-0330", "America/St_Johns"), TuplesKt.to("UTC-0300", "America/Paramaribo"), TuplesKt.to("UTC-0200", "Etc/GMT+2"), TuplesKt.to("UTC-0100", "Atlantic/Cape_Verde"), TuplesKt.to("UTC-0000", "Etc/GMT"), TuplesKt.to("UTC+0100", "Africa/Lagos"), TuplesKt.to("UTC+0200", "Africa/Johannesburg"), TuplesKt.to("UTC+0300", "Africa/Nairobi"), TuplesKt.to("UTC+0330", "Asia/Tehran"), TuplesKt.to("UTC+0400", "Asia/Dubai"), TuplesKt.to("UTC+0430", "Asia/Kabul"), TuplesKt.to("UTC+0500", "Asia/Karachi"), TuplesKt.to("UTC+0530", "Asia/Colombo"), TuplesKt.to("UTC+0545", "Asia/Kathmandu"), TuplesKt.to("UTC+0600", "Asia/Dhaka"), TuplesKt.to("UTC+0630", "Asia/Yangon"), TuplesKt.to("UTC+0700", "Asia/Bangkok"), TuplesKt.to("UTC+0800", "Asia/Shanghai"), TuplesKt.to("UTC+0830", "Asia/Pyongyang"), TuplesKt.to("UTC+0845", "Australia/Eucla"), TuplesKt.to("UTC+0900", "Asia/Tokyo"), TuplesKt.to("UTC+0930", "Australia/Darwin"), TuplesKt.to("UTC+1000", "Australia/Brisbane"), TuplesKt.to("UTC+1030", "Australia/Lord_Howe"), TuplesKt.to("UTC+1100", "Pacific/Noumea"), TuplesKt.to("UTC+1200", "Pacific/Tarawa"), TuplesKt.to("UTC+1300", "Pacific/Tongatapu"), TuplesKt.to("UTC+1400", "Pacific/Kiritimati"));
    public static final int oneDayHour = 24;
    public static final long oneDayMillis = 86400000;
    public static final long oneDaySeconds = 86400;
    public static final long oneHourSeconds = 3600;
    public static final long oneMinuteMillis = 60000;

    private TimeUtils() {
    }

    public final void setCurrentTimeMillis(long j) {
        currentTimeMillis = j;
    }

    public final long getCurrentTimeMillis() {
        long time = new Date().getTime();
        currentTimeMillis = time;
        return time;
    }

    public final void setCurrentDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        currentDate = date;
    }

    public final Date getCurrentDate() {
        Date date = new Date();
        currentDate = date;
        return date;
    }

    public final long zeroOfDay(long j) {
        long timeZoneOffsetSeconds = timeZoneOffsetSeconds();
        return (((j + timeZoneOffsetSeconds) / oneDaySeconds) * oneDaySeconds) - timeZoneOffsetSeconds;
    }

    public final long timeZoneOffsetSeconds() {
        return ((long) TimeZone.getDefault().getRawOffset()) / 1000;
    }

    public static /* synthetic */ String dateHourMinute$default(TimeUtils timeUtils, Date date, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "MM-dd HH:mm";
        }
        return timeUtils.dateHourMinute(date, str);
    }

    public final String dateHourMinute(Date date, String str) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(str, "pattern");
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String getTimeZoneId() {
        return TimeZone.getDefault().getID();
    }

    public final Long calTimestamp(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, ExtendsKt.DATE_FORMAT_YMDHMS_WITHOUTSPACE);
        Intrinsics.checkNotNullParameter(str2, "timeZone");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ExtendsKt.DATE_FORMAT_YMDHMS, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str2));
        Date parse = simpleDateFormat.parse(str);
        if (parse != null) {
            return Long.valueOf(parse.getTime());
        }
        return null;
    }

    public final TimeZone getCDFTimezoneById() {
        TimeZone timeZone = TimeZone.getDefault();
        int offset = timeZone.getOffset(Calendar.getInstance(timeZone).getTimeInMillis());
        int i = offset / DateTimeConstants.MILLIS_PER_HOUR;
        int i2 = (offset % DateTimeConstants.MILLIS_PER_HOUR) / DateTimeConstants.MILLIS_PER_MINUTE;
        StringBuilder sb = new StringBuilder("UTC");
        sb.append(i > 0 ? "+" : "-");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(i))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        sb.append(format);
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(i2))}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        sb.append(format2);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        String str = noDstTimezone.get(sb2);
        LogUtil.Companion.eAiDEX("Get standard timeZone : " + str);
        TimeZone timeZone2 = TimeZone.getTimeZone(str);
        Intrinsics.checkNotNullExpressionValue(timeZone2, "getTimeZone(...)");
        return timeZone2;
    }

    public final TimeZone getCDFTimezone() {
        TimeZone timeZone;
        TimeZone timeZone2;
        if (currentStandardTimezone == null || (timeZone2 = currentTimezone) == null || !Intrinsics.areEqual((Object) timeZone2, (Object) TimeZone.getDefault())) {
            TimeZone timeZone3 = TimeZone.getDefault();
            currentTimezone = timeZone3;
            int offset = timeZone3.getOffset(Calendar.getInstance(timeZone3).getTimeInMillis());
            int i = offset / DateTimeConstants.MILLIS_PER_HOUR;
            int i2 = (offset % DateTimeConstants.MILLIS_PER_HOUR) / DateTimeConstants.MILLIS_PER_MINUTE;
            String str = "+";
            if (i2 == 0) {
                StringBuilder sb = new StringBuilder("GMT");
                if (i < 0) {
                    str = "";
                }
                timeZone = TimeZone.getTimeZone(sb.append(str).append(i).append(":00").toString());
            } else {
                StringBuilder sb2 = new StringBuilder("GMT");
                if (i < 0) {
                    str = "";
                }
                sb2.append(str);
                sb2.append(i);
                sb2.append(":");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(i2))}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                sb2.append(format);
                String sb3 = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
                timeZone = TimeZone.getTimeZone(sb3);
            }
            LogUtil.Companion.eAiDEX("Get standard timeZone : " + timeZone.getID());
            currentStandardTimezone = timeZone;
            Intrinsics.checkNotNull(timeZone);
            return timeZone;
        }
        TimeZone timeZone4 = currentStandardTimezone;
        Intrinsics.checkNotNull(timeZone4);
        return timeZone4;
    }

    private final TimeZone getStandardTimezone(String str) {
        TimeZone timeZone;
        TimeZone timeZone2 = TimeZone.getTimeZone(str);
        int offset = timeZone2.getOffset(Calendar.getInstance(timeZone2).getTimeInMillis());
        int i = offset / DateTimeConstants.MILLIS_PER_HOUR;
        int i2 = (offset % DateTimeConstants.MILLIS_PER_HOUR) / DateTimeConstants.MILLIS_PER_MINUTE;
        String str2 = "+";
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder("GMT");
            if (i < 0) {
                str2 = "";
            }
            timeZone = TimeZone.getTimeZone(sb.append(str2).append(i).append(":00").toString());
        } else {
            StringBuilder sb2 = new StringBuilder("GMT");
            if (i < 0) {
                str2 = "";
            }
            sb2.append(str2);
            sb2.append(i);
            sb2.append(":");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(i2))}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            sb2.append(format);
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            timeZone = TimeZone.getTimeZone(sb3);
        }
        Intrinsics.checkNotNull(timeZone);
        return timeZone;
    }

    public final long genRandomLoadingTime() {
        return (long) ((Math.random() * ((double) 1000)) + ((double) 500));
    }

    public static /* synthetic */ String getTimezoneOffset$default(TimeUtils timeUtils, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        return timeUtils.getTimezoneOffset(str, j);
    }

    public final String getTimezoneOffset(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "timezoneId");
        long offset = (long) getStandardTimezone(str).getOffset(j);
        long j2 = (long) DateTimeConstants.MILLIS_PER_HOUR;
        long j3 = offset / j2;
        long j4 = (offset % j2) / ((long) DateTimeConstants.MILLIS_PER_MINUTE);
        String str2 = j3 < 0 ? "-" : "+";
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%02d%02d", Arrays.copyOf(new Object[]{Long.valueOf(Math.abs(j3)), Long.valueOf(Math.abs(j4))}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return "UTC" + str2 + format;
    }

    public final Date getDstStartDate(String str) {
        long j;
        Intrinsics.checkNotNullParameter(str, "timeZoneId");
        TimeZone timeZone = TimeZone.getTimeZone(str);
        if (!timeZone.useDaylightTime()) {
            return null;
        }
        int i = Calendar.getInstance().get(1);
        Calendar instance = Calendar.getInstance(timeZone);
        instance.set(i, 0, 1);
        while (true) {
            if (instance.get(1) != i) {
                j = 0;
                break;
            } else if (timeZone.inDaylightTime(instance.getTime())) {
                j = instance.getTimeInMillis();
                break;
            } else {
                instance.add(5, 1);
            }
        }
        return new Date(j);
    }

    public final Date getDstEndDate(String str) {
        long j;
        Intrinsics.checkNotNullParameter(str, "timeZoneId");
        TimeZone timeZone = TimeZone.getTimeZone(str);
        if (!timeZone.useDaylightTime()) {
            return null;
        }
        int i = Calendar.getInstance().get(1);
        Calendar instance = Calendar.getInstance(timeZone);
        instance.set(i, 11, 31);
        while (true) {
            if (instance.get(1) != i) {
                j = 0;
                break;
            } else if (!timeZone.inDaylightTime(instance.getTime())) {
                j = instance.getTimeInMillis();
                break;
            } else {
                instance.add(5, -1);
            }
        }
        return new Date(j);
    }

    public final Date getNextTransaction(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "timeZoneId");
        Intrinsics.checkNotNullParameter(date, CrashHianalyticsData.TIME);
        TimeZone timeZone = TimeZone.getTimeZone(str);
        if (!timeZone.useDaylightTime()) {
            return null;
        }
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTimeZone(timeZone);
        instance.setTime(date);
        boolean inDaylightTime = timeZone.inDaylightTime(instance.getTime());
        while (timeZone.inDaylightTime(instance.getTime()) == inDaylightTime) {
            instance.add(5, 1);
        }
        return instance.getTime();
    }
}
