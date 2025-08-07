package com.microtech.aidexx.views.chart;

import com.microtech.aidexx.utils.TimeUtils;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/microtech/aidexx/views/chart/ChartUtil;", "", "()V", "timeZero", "", "dateToX", "", "date", "Ljava/util/Date;", "millSecondToX", "millSecond", "secondToX", "second", "xToSecond", "x", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartUtil.kt */
public final class ChartUtil {
    public static final ChartUtil INSTANCE = new ChartUtil();
    private static final long timeZero = TimeUtils.INSTANCE.zeroOfDay(new Date().getTime() / ((long) 1000));

    private ChartUtil() {
    }

    public final float dateToX(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return secondToX(date.getTime() / ((long) 1000));
    }

    public final float secondToX(long j) {
        return ((float) (j - timeZero)) / ((float) TimeUtils.oneHourSeconds);
    }

    public final float millSecondToX(long j) {
        return ((float) ((j / ((long) 1000)) - timeZero)) / ((float) TimeUtils.oneHourSeconds);
    }

    public final long xToSecond(float f) {
        float f2 = f * ((float) 60);
        if (Float.isNaN(f2)) {
            return new Date().getTime() / ((long) 1000);
        }
        return (MathKt.roundToLong(f2) * ((long) 60)) + timeZero;
    }
}
