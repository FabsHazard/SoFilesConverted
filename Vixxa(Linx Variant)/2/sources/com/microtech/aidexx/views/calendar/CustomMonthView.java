package com.microtech.aidexx.views.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.internal.view.SupportMenu;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J,\u0010\u0011\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0014J4\u0010\u0012\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J8\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/microtech/aidexx/views/calendar/CustomMonthView;", "Lcom/haibin/calendarview/MonthView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mRadius", "", "mRedPaint", "Landroid/graphics/Paint;", "drawDataPoint", "", "calendar", "Lcom/haibin/calendarview/Calendar;", "x", "y", "canvas", "Landroid/graphics/Canvas;", "onDrawScheme", "onDrawSelected", "", "hasScheme", "onDrawText", "isSelected", "onPreviewHook", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomMonthView.kt */
public final class CustomMonthView extends MonthView {
    private int mRadius;
    private final Paint mRedPaint;

    public CustomMonthView(Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.mRedPaint = paint;
    }

    /* access modifiers changed from: protected */
    public void onPreviewHook() {
        this.mRadius = (Math.min(this.mItemWidth, this.mItemHeight) / 5) * 2;
        this.mSchemePaint.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public boolean onDrawSelected(Canvas canvas, Calendar calendar, int i, int i2, boolean z) {
        int i3 = i + (this.mItemWidth / 2);
        int i4 = i2 + (this.mItemHeight / 2);
        if (canvas == null) {
            return false;
        }
        canvas.drawCircle((float) i3, (float) i4, (float) this.mRadius, this.mSelectedPaint);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDrawScheme(Canvas canvas, Calendar calendar, int i, int i2) {
        int i3 = i + (this.mItemWidth / 2);
        int i4 = i2 + (this.mItemHeight / 2);
        if (canvas != null) {
            canvas.drawCircle((float) i3, (float) i4, (float) this.mRadius, this.mSchemePaint);
        }
    }

    /* access modifiers changed from: protected */
    public void onDrawText(Canvas canvas, Calendar calendar, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        float f = this.mTextBaseLine + ((float) i2);
        int i3 = (this.mItemWidth / 2) + i;
        boolean isInRange = isInRange(calendar);
        boolean onCalendarIntercept = onCalendarIntercept(calendar);
        String format = NumberFormat.getInstance(Locale.getDefault()).format(Integer.valueOf(calendar.getDay()));
        if (z2) {
            canvas.drawText(format, (float) i3, f, this.mSelectTextPaint);
        } else if (z) {
            canvas.drawText(format, (float) i3, f, calendar.isCurrentDay() ? this.mCurDayTextPaint : (!calendar.isCurrentMonth() || !isInRange || onCalendarIntercept) ? this.mOtherMonthTextPaint : this.mSchemeTextPaint);
        } else {
            canvas.drawText(format, (float) i3, f, calendar.isCurrentDay() ? this.mCurDayTextPaint : (!calendar.isCurrentMonth() || !isInRange || onCalendarIntercept) ? this.mOtherMonthTextPaint : this.mCurMonthTextPaint);
        }
        drawDataPoint(calendar, i, i2, canvas);
    }

    private final void drawDataPoint(Calendar calendar, int i, int i2, Canvas canvas) {
        if (CalendarDataCache.INSTANCE.isNeedShowDataPointInThisView()) {
            StringBuilder append = new StringBuilder().append(UserInfoManager.Companion.getCurShowUserId()).append(Soundex.SILENT_MARKER).append(calendar.getYear());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendar.getMonth())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            StringBuilder append2 = append.append(format);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendar.getDay())}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            if (CalendarDataCache.INSTANCE.getDataCache().contains(append2.append(format2).toString())) {
                canvas.drawCircle((float) (i + (this.mItemWidth / 2)), this.mTextBaseLine + ((float) i2) + ((float) ExtendsKt.dp2px((Number) 10)), 5.0f, this.mRedPaint);
            }
        }
    }
}
