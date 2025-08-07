package com.microtech.aidexx.utils;

import android.content.res.Resources;
import com.microtech.aidexx.R;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\b\u001a\u00020\u0005*\u00020\t\u001a\n\u0010\b\u001a\u00020\u0005*\u00020\u0001\u001a\u0012\u0010\n\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u001a\n\u0010\r\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u000f\u001a\n\u0010\u0010\u001a\u00020\u0005*\u00020\u0001¨\u0006\u0011"}, d2 = {"roundOffDecimal", "", "number", "fromGlucoseValue", "mmolValueDisplay", "", "toCgat", "toCgatInt", "toGlucoseString", "", "toGlucoseStringWithLowAndHigh", "context", "Landroid/content/res/Resources;", "toGlucoseStringWithUnit", "toGlucoseValue", "", "toStringWithLoAndHi", "app_gpGrxMmolRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucoseUtil.kt */
public final class GlucoseUtilKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GlucoseUtil.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit[] r0 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit r1 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.MMOL_PER_L     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit r1 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.MG_PER_DL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.GlucoseUtilKt.WhenMappings.<clinit>():void");
        }
    }

    public static final float toGlucoseValue(float f) {
        int i = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
        if (i == 1) {
            return roundOffDecimal(f / 18.0f);
        }
        if (i == 2) {
            return f;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final float toGlucoseValue(double d) {
        int i = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
        if (i == 1) {
            return roundOffDecimal((float) (d / ((double) 18.0f)));
        }
        if (i == 2) {
            return (float) d;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final float toGlucoseValue(int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
        if (i2 == 1) {
            return ((float) i) / 18.0f;
        }
        if (i2 == 2) {
            return (float) i;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final float fromGlucoseValue(float f) {
        int i = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
        if (i == 1) {
            return f * 18.0f;
        }
        if (i == 2) {
            return f;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String mmolValueDisplay(float f) {
        int i = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
        if (i == 1) {
            String format = UnitManager.INSTANCE.unitFormat().format(Float.valueOf(f));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } else if (i == 2) {
            String format2 = UnitManager.INSTANCE.unitFormat().format(Float.valueOf(f * 18.0f));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final String toCgatInt(float f) {
        String plainString = new BigDecimal(String.valueOf(toGlucoseValue(f))).setScale(0, RoundingMode.DOWN).toPlainString();
        Intrinsics.checkNotNullExpressionValue(plainString, "toPlainString(...)");
        return plainString;
    }

    public static final String toCgat(float f) {
        String format = new DecimalFormat("0.0").format(Float.valueOf(toGlucoseValue(f)));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String toGlucoseString(float f) {
        String format = UnitManager.INSTANCE.unitFormat().format(Float.valueOf(toGlucoseValue(f)));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String toGlucoseString(double d) {
        String format = UnitManager.INSTANCE.unitFormat().format(Float.valueOf(toGlucoseValue(d)));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String toGlucoseStringWithLowAndHigh(float f, Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "context");
        if (f <= 36.0f) {
            String string = resources.getString(R.string.cgm_error_min);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (f >= 450.0f) {
            String string2 = resources.getString(R.string.cgm_error_max);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else {
            String format = UnitManager.INSTANCE.unitFormat().format(Float.valueOf(toGlucoseValue(f)));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
    }

    public static final String toStringWithLoAndHi(float f) {
        if (f <= 36.0f) {
            return "LO";
        }
        if (f >= 450.0f) {
            return "HI";
        }
        String format = UnitManager.INSTANCE.unitFormat().format(Float.valueOf(f));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String toGlucoseStringWithUnit(float f) {
        return toGlucoseString(f) + ' ' + UnitManager.INSTANCE.getDisplayUnit();
    }

    public static final float roundOffDecimal(float f) {
        return new BigDecimal(String.valueOf(f)).setScale(1, RoundingMode.HALF_EVEN).floatValue();
    }
}
