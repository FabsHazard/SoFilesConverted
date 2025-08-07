package com.microtech.aidexx.views.chart;

import com.github.mikephil.charting.formatter.ValueFormatter;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.views.chart.GlucoseChart;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"com/microtech/aidexx/views/chart/GlucoseChart$initChartAxisX$1", "Lcom/github/mikephil/charting/formatter/ValueFormatter;", "mFormatToHHmm", "Ljava/text/SimpleDateFormat;", "mFormatToHHmmnMMdd", "minTs", "", "getMinTs", "()J", "setMinTs", "(J)V", "timezone", "Ljava/util/TimeZone;", "getTimezone", "()Ljava/util/TimeZone;", "getFormattedValue", "", "value", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucoseChart.kt */
public final class GlucoseChart$initChartAxisX$1 extends ValueFormatter {
    private SimpleDateFormat mFormatToHHmm;
    private SimpleDateFormat mFormatToHHmmnMMdd;
    private long minTs = Long.MAX_VALUE;
    final /* synthetic */ GlucoseChart this$0;
    private final TimeZone timezone = TimeUtils.INSTANCE.getCDFTimezone();

    GlucoseChart$initChartAxisX$1(GlucoseChart glucoseChart) {
        this.this$0 = glucoseChart;
        this.mFormatToHHmm = new SimpleDateFormat(glucoseChart.getResources().getString(R.string.com_dateFormat_HHmm), Locale.getDefault());
        this.mFormatToHHmmnMMdd = new SimpleDateFormat(glucoseChart.getResources().getString(R.string.com_dateFormat_HHmmMMdd), Locale.getDefault());
    }

    public final long getMinTs() {
        return this.minTs;
    }

    public final void setMinTs(long j) {
        this.minTs = j;
    }

    public final TimeZone getTimezone() {
        return this.timezone;
    }

    public String getFormattedValue(float f) {
        String str;
        String str2;
        Function2<Integer, Object, Unit> onChartEvent;
        this.mFormatToHHmm.setTimeZone(this.timezone);
        this.mFormatToHHmmnMMdd.setTimeZone(this.timezone);
        long xToSecond = ChartUtil.INSTANCE.xToSecond(f);
        if (xToSecond < this.minTs) {
            this.minTs = xToSecond;
            GlucoseChart.ExtraParams extraParams = this.this$0.getExtraParams();
            if (!(extraParams == null || (onChartEvent = extraParams.getOnChartEvent()) == null)) {
                onChartEvent.invoke(1, Long.valueOf(this.minTs));
            }
        }
        long timeZoneOffsetSeconds = ((TimeUtils.INSTANCE.timeZoneOffsetSeconds() + xToSecond) % TimeUtils.oneDaySeconds) / TimeUtils.oneHourSeconds;
        if (timeZoneOffsetSeconds == 0) {
            GlucoseChart.ExtraParams extraParams2 = this.this$0.getExtraParams();
            if (extraParams2 == null || extraParams2.getYAxisStyle() != 1) {
                str2 = this.mFormatToHHmm.format(new Date(xToSecond * ((long) 1000)));
            } else {
                String format = this.mFormatToHHmmnMMdd.format(new Date(xToSecond * ((long) 1000)));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                str2 = StringsKt.replace$default(format, "{+}", "\n{+}", false, 4, (Object) null);
            }
            Intrinsics.checkNotNull(str2);
            return str2;
        } else if (f - this.this$0.getLowestVisibleX() >= this.this$0.getXAxis().getGranularity() || ((float) (timeZoneOffsetSeconds % ((long) 24))) >= ((float) 24) - (this.this$0.getXAxis().getGranularity() * ((float) 5))) {
            String format2 = this.mFormatToHHmm.format(new Date(xToSecond * ((long) 1000)));
            Intrinsics.checkNotNull(format2);
            return format2;
        } else {
            GlucoseChart.ExtraParams extraParams3 = this.this$0.getExtraParams();
            if (extraParams3 == null || extraParams3.getYAxisStyle() != 1) {
                str = this.mFormatToHHmm.format(new Date(xToSecond * ((long) 1000)));
            } else {
                String format3 = this.mFormatToHHmmnMMdd.format(new Date(xToSecond * ((long) 1000)));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                str = StringsKt.replace$default(format3, "{+}", "\n{f+}", false, 4, (Object) null);
            }
            Intrinsics.checkNotNull(str);
            return str;
        }
    }
}
