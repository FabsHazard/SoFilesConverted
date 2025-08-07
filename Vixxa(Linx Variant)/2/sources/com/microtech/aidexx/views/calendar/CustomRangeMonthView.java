package com.microtech.aidexx.views.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.internal.view.SupportMenu;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.RangeMonthView;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J0\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J@\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0014J8\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0019\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/microtech/aidexx/views/calendar/CustomRangeMonthView;", "Lcom/haibin/calendarview/RangeMonthView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mRadius", "", "mRedPaint", "Landroid/graphics/Paint;", "drawDataPoint", "", "calendar", "Lcom/haibin/calendarview/Calendar;", "x", "y", "canvas", "Landroid/graphics/Canvas;", "onDrawScheme", "isSelected", "", "onDrawSelected", "hasScheme", "isSelectedPre", "isSelectedNext", "onDrawText", "onPreviewHook", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomRangeMonthView.kt */
public final class CustomRangeMonthView extends RangeMonthView {
    private int mRadius;
    private final Paint mRedPaint;

    public CustomRangeMonthView(Context context) {
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
    public boolean onDrawSelected(Canvas canvas, Calendar calendar, int i, int i2, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        int i3 = (this.mItemWidth / 2) + i;
        int i4 = i2 + (this.mItemHeight / 2);
        if (!z2) {
            if (z3) {
                float f = (float) i4;
                canvas.drawRect((float) i3, f - ((float) this.mRadius), ((float) i) + ((float) this.mItemWidth), f + ((float) this.mRadius), this.mSelectedPaint);
            }
            canvas.drawCircle((float) i3, (float) i4, (float) this.mRadius, this.mSelectedPaint);
            return false;
        } else if (z3) {
            float f2 = (float) i;
            float f3 = (float) i4;
            canvas.drawRect(f2, f3 - ((float) this.mRadius), f2 + ((float) this.mItemWidth), f3 + ((float) this.mRadius), this.mSelectedPaint);
            return false;
        } else {
            float f4 = (float) i4;
            int i5 = this.mRadius;
            float f5 = (float) i3;
            canvas.drawRect((float) i, f4 - ((float) i5), f5, f4 + ((float) i5), this.mSelectedPaint);
            canvas.drawCircle(f5, f4, (float) this.mRadius, this.mSelectedPaint);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDrawScheme(Canvas canvas, Calendar calendar, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        canvas.drawCircle((float) (i + (this.mItemWidth / 2)), (float) (i2 + (this.mItemHeight / 2)), (float) this.mRadius, this.mSchemePaint);
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
