package com.microtech.aidexx.common;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.utils.LocalManageUtil;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.ToastUtil;
import com.microtech.aidexx.utils.UnitManager;
import io.objectbox.Property;
import io.objectbox.query.QueryBuilder;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.apache.commons.codec.language.Soundex;
import org.joda.time.DateTimeConstants;

@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0006\u0010\f\u001a\u00020\r\u001a\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0019\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013\"\u0006\b\u0000\u0010\u0015\u0018\u0001H\b\u001a\u000e\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0006\u0010\u0019\u001a\u00020\u001a\u001a\b\u0010\u001b\u001a\u00020\u0018H\u0007\u001a\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0006\u0010\u001e\u001a\u00020\u001d\u001a\u000e\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0006\u0010 \u001a\u00020\u001d\u001a\n\u0010!\u001a\u00020\u0001*\u00020\u0001\u001a\u0011\u0010\"\u001a\u0004\u0018\u00010#*\u00020\u0001¢\u0006\u0002\u0010$\u001a\f\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020&\u001a\f\u0010'\u001a\u0004\u0018\u00010\u0001*\u00020&\u001a\u0016\u0010(\u001a\u0004\u0018\u00010\u0001*\u00020&2\b\b\u0002\u0010)\u001a\u00020\u0001\u001a\u0016\u0010*\u001a\u0004\u0018\u00010\u0001*\u00020&2\b\b\u0002\u0010)\u001a\u00020\u0001\u001a\u0016\u0010+\u001a\u0004\u0018\u00010\u0001*\u00020&2\b\b\u0002\u0010)\u001a\u00020\u0001\u001a\u0016\u0010,\u001a\u0004\u0018\u00010\u0001*\u00020&2\b\b\u0002\u0010)\u001a\u00020\u0001\u001a\u0016\u0010,\u001a\u0004\u0018\u00010&*\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u0001\u001a\f\u0010-\u001a\u0004\u0018\u00010\u0001*\u00020&\u001a\f\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020&\u001a\f\u0010/\u001a\u00020\u0018*\u000200H\u0000\u001a2\u00101\u001a\b\u0012\u0004\u0012\u0002H\u001502\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u0015022\f\u00103\u001a\b\u0012\u0004\u0012\u0002H\u0015042\u0006\u0010\u0017\u001a\u00020\u0001\u001a\u0014\u00105\u001a\u000206*\u0002062\b\b\u0002\u00107\u001a\u00020\u0018\u001a\n\u00108\u001a\u00020\u0001*\u000209\u001a\f\u0010:\u001a\u0004\u0018\u00010\u0001*\u00020&\u001a\f\u0010;\u001a\u0004\u0018\u00010\u0001*\u00020&\u001a\f\u0010<\u001a\u0004\u0018\u00010\u0001*\u00020&\u001a\f\u0010=\u001a\u0004\u0018\u00010\u0001*\u00020&\u001a\f\u0010>\u001a\u0004\u0018\u00010\u0001*\u00020&\u001a\f\u0010?\u001a\u0004\u0018\u00010\u0001*\u00020&\u001a\n\u0010@\u001a\u00020\u0001*\u00020&\u001a\n\u0010A\u001a\u00020B*\u00020&\u001a\n\u0010C\u001a\u00020&*\u00020&\u001a\n\u0010D\u001a\u00020B*\u00020&\u001a\n\u0010E\u001a\u00020&*\u00020&\u001a\u0016\u0010F\u001a\u0004\u0018\u00010\u0001*\u00020#2\b\b\u0002\u0010)\u001a\u00020\u0001\u001a\n\u0010G\u001a\u00020\u001d*\u00020\u0001\u001a\u0014\u0010H\u001a\u00020\u001d*\u00020&2\b\u0010I\u001a\u0004\u0018\u00010&\u001a\n\u0010J\u001a\u00020\u0018*\u00020#\u001a\u0012\u0010K\u001a\u00020\u0018*\u00020#2\u0006\u0010L\u001a\u00020M\u001a\n\u0010N\u001a\u00020\u0018*\u00020#\u001a\n\u0010O\u001a\u00020\u0018*\u00020#\u001a\n\u0010P\u001a\u00020#*\u00020#\u001a\n\u0010Q\u001a\u00020#*\u00020\u0018\u001a\f\u0010R\u001a\u0004\u0018\u000100*\u00020\u0001\u001a\f\u0010S\u001a\u0004\u0018\u000100*\u00020\u0001\u001a#\u0010T\u001a\u0004\u0018\u00010#*\u00020\u00012\u0006\u0010U\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u0001¢\u0006\u0002\u0010V\u001a\n\u0010W\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010X\u001a\u000209*\u000209\u001a\u001c\u0010Y\u001a\u00020Z*\u00020[2\b\b\u0002\u0010\\\u001a\u00020#2\u0006\u0010]\u001a\u00020^\u001a\u001c\u0010_\u001a\u00020\u0001*\u0002002\u0006\u00107\u001a\u00020\u00182\b\b\u0002\u0010`\u001a\u00020\u001d\u001a\u0012\u0010a\u001a\u00020\u0001*\u0002002\u0006\u00107\u001a\u00020\u0018\u001a\u001d\u0010b\u001a\u00020\u0001*\u0004\u0018\u0001002\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010c\u001a\u001b\u0010d\u001a\u00020\u0001*\u0002002\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010c\u001a\u0012\u0010e\u001a\u00020\u0018*\u00020\u00182\u0006\u0010f\u001a\u00020g\u001a\n\u0010h\u001a\u00020\u0001*\u000209\u001a\u0012\u0010i\u001a\u00020&*\u00020\u00182\u0006\u0010j\u001a\u00020&\u001a\n\u0010k\u001a\u00020\u0018*\u00020l\u001a\n\u0010m\u001a\u00020\u0018*\u00020l\u001a\n\u0010n\u001a\u00020l*\u00020\u0018\u001a\n\u0010o\u001a\u00020Z*\u00020\u0001\u001a\n\u0010p\u001a\u00020Z*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006q"}, d2 = {"DATE_FORMAT_HM", "", "DATE_FORMAT_YMDHM", "DATE_FORMAT_YMDHMS", "DATE_FORMAT_YMDHMSZ", "DATE_FORMAT_YMDHMS_WITHOUTSPACE", "baseUuid", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/app/Application;", "getIoScope", "(Landroid/app/Application;)Lkotlinx/coroutines/CoroutineScope;", "getContext", "Lcom/microtech/aidexx/AidexxApp;", "getDecimalFormatWithLocale", "Ljava/text/DecimalFormat;", "getLocale", "Ljava/util/Locale;", "getMutableListType", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "T", "getNumberFormatStr", "value", "", "getNumberFormatWithLocale", "Ljava/text/NumberFormat;", "getStatusBarHeight", "isGp", "", "isMainThread", "setYearFormat", "useAppTime", "convertPointer", "convertToCurZoneTs", "", "(Ljava/lang/String;)Ljava/lang/Long;", "date2YMD", "Ljava/util/Date;", "date2YMDByEnglish", "date2ymdhm", "pattern", "dateAndTimeHour", "dateAndTimeS", "dateAndYM", "dateTimeWithoutSpace", "dateTimeWithoutSpaceByEnglish", "dp2px", "", "equal", "Lio/objectbox/query/QueryBuilder;", "property", "Lio/objectbox/Property;", "format", "", "scale", "formatNumberBaseLanguage", "", "formatToHHmm", "formatToMd", "formatToMdhm", "formatToYM", "formatToYMd", "formatToYMdHm", "formatWithoutZone", "getEnd", "Ljava/util/Calendar;", "getEndOfTheDay", "getStart", "getStartOfTheDay", "hourMinute", "isNumber", "isSameDay", "other", "millisToDays", "millisToHours", "roundingMode", "Ljava/math/RoundingMode;", "millisToIntSeconds", "millisToMinutes", "millisToSeconds", "minutesToMillis", "parseToNumber", "parseToNumberByEnglish", "parseToTimestamp", "timeZoneId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "processPoint", "roundTwoDigits", "setDebounceClickListener", "", "Landroid/view/View;", "time", "listener", "Landroid/view/View$OnClickListener;", "setScale", "localSymbols", "setScaleHalfEven", "stripTrailingZeros", "(Ljava/lang/Number;Ljava/lang/Integer;)Ljava/lang/String;", "stripTrailingZerosWithoutPointer", "toColor", "context", "Landroid/content/Context;", "toGlucoseString2", "toHistoryDate", "sensorStartTime", "toIntBigEndian", "Ljava/util/UUID;", "toIntLittleEndian", "toUuid", "toast", "toastShort", "app_gpGrxMmolRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: Extends.kt */
public final class ExtendsKt {
    public static final String DATE_FORMAT_HM = "HH:mm";
    public static final String DATE_FORMAT_YMDHM = "yyyy/MM/dd HH:mm";
    public static final String DATE_FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_YMDHMSZ = "yyyy-MM-dd HH:mm:ssZ";
    public static final String DATE_FORMAT_YMDHMS_WITHOUTSPACE = "yyyyMMddHHmmss";
    public static final String baseUuid = "00000000-0000-1000-8000-00805F9B34FB";

    public static final boolean isGp() {
        return true;
    }

    public static final long minutesToMillis(int i) {
        return ((long) (i * 60)) * 1000;
    }

    public static final boolean useAppTime() {
        return true;
    }

    public static final String date2YMD(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
    }

    public static final String date2YMDByEnglish(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(date);
    }

    public static final String formatToYMdHm(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return new SimpleDateFormat(getContext().getString(R.string.com_dateFormat_yyyyMMddHHmm), Locale.getDefault()).format(date);
    }

    public static final String formatToYMd(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return new SimpleDateFormat(getContext().getString(R.string.com_dateFormat_yyyyMMdd), Locale.getDefault()).format(date);
    }

    public static final String formatToYM(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return new SimpleDateFormat(getContext().getString(R.string.com_dateFormat_yyyyMM), Locale.getDefault()).format(date);
    }

    public static final String formatToMd(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getContext().getString(R.string.com_dateFormat_MM_dd), Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeUtils.INSTANCE.getCDFTimezone());
        return simpleDateFormat.format(date);
    }

    public static final String formatToMdhm(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return new SimpleDateFormat(getContext().getString(R.string.com_dateFormat_MMddHHmm), Locale.getDefault()).format(date);
    }

    public static final String formatToHHmm(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return new SimpleDateFormat(getContext().getString(R.string.com_dateFormat_HHmm), Locale.getDefault()).format(date);
    }

    public static final float roundTwoDigits(float f) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(LocalManageUtil.getSetLanguageLocale(AidexxApp.Companion.getInstance())));
        decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
        String format = decimalFormat.format(Float.valueOf(f));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return Float.parseFloat(format);
    }

    public static final Date toHistoryDate(int i, Date date) {
        Intrinsics.checkNotNullParameter(date, "sensorStartTime");
        return new Date(date.getTime() + ((long) (i * DateTimeConstants.MILLIS_PER_MINUTE)));
    }

    public static final UUID toUuid(int i) {
        String hexString = Integer.toHexString(i);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
        String upperCase = hexString.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (upperCase.length() < 4) {
            StringBuilder sb = new StringBuilder();
            int length = 4 - upperCase.length();
            for (int i2 = 0; i2 < length; i2++) {
                sb.append("0");
            }
            sb.append(upperCase);
            upperCase = sb.toString();
            Intrinsics.checkNotNullExpressionValue(upperCase, "toString(...)");
        }
        UUID fromString = UUID.fromString(StringsKt.replaceRange((CharSequence) baseUuid, 4, 8, (CharSequence) upperCase).toString());
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(...)");
        return fromString;
    }

    public static final int toIntLittleEndian(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<this>");
        String uuid2 = uuid.toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "toString(...)");
        String substring = uuid2.substring(5, 9);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        int parseInt = Integer.parseInt(substring, 16);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.asIntBuffer().put(parseInt);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate.asIntBuffer().get();
    }

    public static final int toColor(int i, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.getColor(context, i);
    }

    public static final int toIntBigEndian(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<this>");
        String uuid2 = uuid.toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "toString(...)");
        String substring = uuid2.substring(4, 8);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return Integer.parseInt(substring, 16);
    }

    public static final int millisToMinutes(long j) {
        return new BigDecimal(j).divide(new BigDecimal(DateTimeConstants.MILLIS_PER_MINUTE), RoundingMode.HALF_UP).intValue();
    }

    public static final long millisToSeconds(long j) {
        return new BigDecimal(j).divide(new BigDecimal(1000), RoundingMode.HALF_UP).longValue();
    }

    public static final int millisToIntSeconds(long j) {
        return new BigDecimal(j).divide(new BigDecimal(1000), RoundingMode.HALF_UP).intValue();
    }

    public static final int millisToHours(long j, RoundingMode roundingMode) {
        Intrinsics.checkNotNullParameter(roundingMode, "roundingMode");
        return new BigDecimal(j).divide(new BigDecimal(DateTimeConstants.MILLIS_PER_HOUR), roundingMode).intValue();
    }

    public static final int millisToDays(long j) {
        return new BigDecimal(j).divide(new BigDecimal(86400000), RoundingMode.CEILING).intValue();
    }

    public static /* synthetic */ String date2ymdhm$default(Date date, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = DATE_FORMAT_YMDHM;
        }
        return date2ymdhm(date, str);
    }

    public static final String date2ymdhm(Date date, String str) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(str, "pattern");
        return new SimpleDateFormat(str, Locale.getDefault()).format(date);
    }

    public static /* synthetic */ String dateAndTimeHour$default(Date date, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = DATE_FORMAT_HM;
        }
        return dateAndTimeHour(date, str);
    }

    public static final String dateAndTimeHour(Date date, String str) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(str, "pattern");
        return new SimpleDateFormat(str, Locale.ENGLISH).format(date);
    }

    public static /* synthetic */ String hourMinute$default(long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = DATE_FORMAT_HM;
        }
        return hourMinute(j, str);
    }

    public static final String hourMinute(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "pattern");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeUtils.INSTANCE.getCDFTimezone());
        return simpleDateFormat.format(Long.valueOf(j));
    }

    public static /* synthetic */ String dateAndYM$default(Date date, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "yyyy-MM";
        }
        return dateAndYM(date, str);
    }

    public static final String dateAndYM(Date date, String str) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(str, "pattern");
        try {
            return new SimpleDateFormat(str, Locale.getDefault()).format(date);
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ Date dateAndYM$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "yyyy-MM";
        }
        return dateAndYM(str, str2);
    }

    public static final Date dateAndYM(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "pattern");
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Date getStartOfTheDay(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        Date time = instance.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        return time;
    }

    public static final Calendar getStart(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        Intrinsics.checkNotNull(instance);
        return instance;
    }

    public static final Date getEndOfTheDay(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        Date time = instance.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        return time;
    }

    public static final Calendar getEnd(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        Intrinsics.checkNotNull(instance);
        return instance;
    }

    public static final boolean isSameDay(Date date, Date date2) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        if (date2 != null) {
            return Intrinsics.areEqual((Object) getStartOfTheDay(date), (Object) getStartOfTheDay(date2));
        }
        return false;
    }

    public static /* synthetic */ Long parseToTimestamp$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = DATE_FORMAT_YMDHMS;
        }
        return parseToTimestamp(str, str2, str3);
    }

    public static final Long parseToTimestamp(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "timeZoneId");
        Intrinsics.checkNotNullParameter(str3, "pattern");
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            charSequence = null;
        }
        String str4 = (String) charSequence;
        if (str4 == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str2));
        Date parse = simpleDateFormat.parse(str4);
        if (parse != null) {
            return Long.valueOf(parse.getTime());
        }
        return null;
    }

    public static /* synthetic */ String dateAndTimeS$default(Date date, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = DATE_FORMAT_YMDHMSZ;
        }
        return dateAndTimeS(date, str);
    }

    public static final String dateAndTimeS(Date date, String str) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(str, "pattern");
        return new SimpleDateFormat(str, Locale.getDefault()).format(date);
    }

    public static final String dateTimeWithoutSpace(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return new SimpleDateFormat(DATE_FORMAT_YMDHMS_WITHOUTSPACE, Locale.getDefault()).format(date);
    }

    public static final String dateTimeWithoutSpaceByEnglish(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return new SimpleDateFormat(DATE_FORMAT_YMDHMS_WITHOUTSPACE, Locale.ENGLISH).format(date);
    }

    public static final String formatWithoutZone(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        String format = new SimpleDateFormat(DATE_FORMAT_YMDHMS, Locale.ENGLISH).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final <T> QueryBuilder<T> equal(QueryBuilder<T> queryBuilder, Property<T> property, String str) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(str, "value");
        QueryBuilder<T> equal = queryBuilder.equal(property, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(...)");
        return equal;
    }

    public static final String toGlucoseString2(float f) {
        if (f <= 36.0f) {
            return "LO";
        }
        if (f >= 450.0f) {
            return "HI";
        }
        String format = UnitManager.INSTANCE.formatterUnitByIndex().format(Float.valueOf(f));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String convertPointer(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String valueOf = String.valueOf(DecimalFormatSymbols.getInstance(LocalManageUtil.getSetLanguageLocale(AidexxApp.Companion.getInstance())).getDecimalSeparator());
        return StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(str, ",", valueOf, false, 4, (Object) null), ".", valueOf, false, 4, (Object) null);
    }

    public static final boolean isNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static final boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static final Locale getLocale() {
        List split$default = StringsKt.split$default((CharSequence) LanguageResourceManager.INSTANCE.getCurLanguageTag(), new char[]{Soundex.SILENT_MARKER}, false, 0, 6, (Object) null);
        if (split$default.size() > 1) {
            return new Locale((String) split$default.get(0), (String) split$default.get(1));
        }
        return new Locale((String) split$default.get(0));
    }

    public static final DecimalFormat getDecimalFormatWithLocale() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(getLocale()));
        return decimalFormat;
    }

    public static final NumberFormat getNumberFormatWithLocale() {
        NumberFormat instance = NumberFormat.getInstance(getLocale());
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        return instance;
    }

    public static final Number parseToNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return getNumberFormatWithLocale().parse(str);
    }

    public static final Number parseToNumberByEnglish(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return NumberFormat.getInstance(Locale.ENGLISH).parse(str);
    }

    public static final String formatNumberBaseLanguage(float f) {
        Locale locale;
        List split$default = StringsKt.split$default((CharSequence) LanguageResourceManager.INSTANCE.getCurLanguageTag(), new char[]{Soundex.SILENT_MARKER}, false, 0, 6, (Object) null);
        if (split$default.size() > 1) {
            locale = new Locale((String) split$default.get(0), (String) split$default.get(1));
        } else {
            locale = new Locale((String) split$default.get(0));
        }
        String format = NumberFormat.getInstance(locale).format(Float.valueOf(f));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final void toast(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (isMainThread()) {
            ToastUtil.INSTANCE.showLong(str);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new ExtendsKt$toast$1(str, (Continuation<? super ExtendsKt$toast$1>) null), 2, (Object) null);
        }
    }

    public static final void toastShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (isMainThread()) {
            ToastUtil.INSTANCE.showShort(str);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new ExtendsKt$toastShort$1(str, (Continuation<? super ExtendsKt$toastShort$1>) null), 2, (Object) null);
        }
    }

    public static /* synthetic */ String setScale$default(Number number, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return setScale(number, i, z);
    }

    public static final String setScale(Number number, int i, boolean z) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        BigDecimal scale = new BigDecimal(number.toString()).setScale(i, RoundingMode.HALF_DOWN);
        DecimalFormat decimalFormat = i == 0 ? new DecimalFormat("#") : new DecimalFormat("#.#");
        if (z) {
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(getLocale()));
        }
        String format = decimalFormat.format(scale);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String setScaleHalfEven(Number number, int i) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        String plainString = new BigDecimal(number.toString()).setScale(i, RoundingMode.HALF_EVEN).toPlainString();
        Intrinsics.checkNotNullExpressionValue(plainString, "toPlainString(...)");
        return plainString;
    }

    public static /* synthetic */ String stripTrailingZeros$default(Number number, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return stripTrailingZeros(number, num);
    }

    public static final String stripTrailingZeros(Number number, Integer num) {
        if (number == null) {
            return "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(getLocale()));
        if (num != null) {
            String format = decimalFormat.format(ExtendsKt$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(number.toString()).setScale(num.intValue(), RoundingMode.HALF_DOWN)));
            Intrinsics.checkNotNull(format);
            return format;
        }
        String format2 = decimalFormat.format(ExtendsKt$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(number.toString())));
        Intrinsics.checkNotNull(format2);
        return format2;
    }

    public static /* synthetic */ String stripTrailingZerosWithoutPointer$default(Number number, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return stripTrailingZerosWithoutPointer(number, num);
    }

    public static final String stripTrailingZerosWithoutPointer(Number number, Integer num) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        if (num != null) {
            String plainString = ExtendsKt$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(number.toString()).setScale(num.intValue(), 5)).toPlainString();
            Intrinsics.checkNotNull(plainString);
            return plainString;
        }
        String plainString2 = ExtendsKt$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(number.toString())).toPlainString();
        Intrinsics.checkNotNull(plainString2);
        return plainString2;
    }

    public static /* synthetic */ double format$default(double d, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 3;
        }
        return format(d, i);
    }

    public static final double format(double d, int i) {
        return ExtendsKt$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(String.valueOf(d)).setScale(i, 5)).doubleValue();
    }

    public static final String setYearFormat(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(getLocale()));
        String format = decimalFormat.format(Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String getNumberFormatStr(int i) {
        String format = NumberFormat.getInstance(Locale.getDefault()).format(Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final AidexxApp getContext() {
        return AidexxApp.Companion.getInstance();
    }

    public static final int dp2px(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return (int) ((number.floatValue() * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final CoroutineScope getIoScope(Application application) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    }

    public static /* synthetic */ void setDebounceClickListener$default(View view, long j, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1500;
        }
        setDebounceClickListener(view, j, onClickListener);
    }

    public static final void setDebounceClickListener(View view, long j, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        view.setOnClickListener(new ExtendsKt$$ExternalSyntheticLambda1(new Ref.LongRef(), j, onClickListener));
    }

    /* access modifiers changed from: private */
    public static final void setDebounceClickListener$lambda$3(Ref.LongRef longRef, long j, View.OnClickListener onClickListener, View view) {
        Intrinsics.checkNotNullParameter(longRef, "$lastClick");
        Intrinsics.checkNotNullParameter(onClickListener, "$listener");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - longRef.element > j) {
            onClickListener.onClick(view);
            longRef.element = elapsedRealtime;
        }
    }

    public static final int getStatusBarHeight() {
        int identifier = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getContext().getResources().getDimensionPixelSize(identifier);
        }
        return 36;
    }

    public static final String processPoint(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.replace$default(str, ',', '.', false, 4, (Object) null);
    }

    public static final Long convertToCurZoneTs(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_YMDHMS, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeUtils.INSTANCE.getCDFTimezone());
            Date parse = simpleDateFormat.parse(str);
            Intrinsics.checkNotNull(parse);
            return Long.valueOf(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
