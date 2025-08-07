package com.microtech.aidexx.ui.main.trend;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.model.DeviceModelKt;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThresholdManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0013\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020%@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R$\u00104\u001a\u00020%2\u0006\u0010$\u001a\u00020%@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010*R\u001a\u00107\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001a\u0010:\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001a\u0010=\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\"\u0010C\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010J\u001a\u00020%2\u0006\u0010$\u001a\u00020%@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010(\"\u0004\bL\u0010*R\u001a\u0010M\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u0010\bR\u001a\u0010P\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0006\"\u0004\bR\u0010\bR\u001c\u0010S\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0006\"\u0004\bU\u0010\bR\u001a\u0010V\u001a\u00020WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010\\\u001a\u00020WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010Y\"\u0004\b^\u0010[R\u001a\u0010_\u001a\u00020WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010Y\"\u0004\ba\u0010[R\u001a\u0010b\u001a\u00020WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010Y\"\u0004\bd\u0010[R\u001a\u0010e\u001a\u00020WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010Y\"\u0004\bg\u0010[R\u001a\u0010h\u001a\u00020WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010Y\"\u0004\bj\u0010[R\u0011\u0010k\u001a\u00020W8F¢\u0006\u0006\u001a\u0004\bl\u0010Y¨\u0006m"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/TrendsInfo;", "", "()V", "coverTime", "", "getCoverTime", "()Ljava/lang/String;", "setCoverTime", "(Ljava/lang/String;)V", "dailyP10", "", "getDailyP10", "()[D", "setDailyP10", "([D)V", "dailyP25", "getDailyP25", "setDailyP25", "dailyP50", "getDailyP50", "setDailyP50", "dailyP75", "getDailyP75", "setDailyP75", "dailyP90", "getDailyP90", "setDailyP90", "eHbA1c", "getEHbA1c", "setEHbA1c", "glucoseSize", "", "getGlucoseSize", "()I", "setGlucoseSize", "(I)V", "value", "", "highPercent", "getHighPercent", "()D", "setHighPercent", "(D)V", "highPercentDesc", "getHighPercentDesc", "setHighPercentDesc", "highPercentDisplay", "getHighPercentDisplay", "setHighPercentDisplay", "lbgi", "getLbgi", "setLbgi", "lowPercent", "getLowPercent", "setLowPercent", "lowPercentDesc", "getLowPercentDesc", "setLowPercentDesc", "lowPercentDisplay", "getLowPercentDisplay", "setLowPercentDisplay", "mbg", "getMbg", "setMbg", "monitorTimes", "getMonitorTimes", "setMonitorTimes", "multiDayHistory", "", "Lcom/microtech/aidexx/ui/main/trend/MultiDayBgItem;", "getMultiDayHistory", "()Ljava/util/List;", "setMultiDayHistory", "(Ljava/util/List;)V", "normalPercent", "getNormalPercent", "setNormalPercent", "normalPercentDesc", "getNormalPercentDesc", "setNormalPercentDesc", "normalPercentDisplay", "getNormalPercentDisplay", "setNormalPercentDisplay", "pageTitle", "getPageTitle", "setPageTitle", "showEhbA1cTrend", "", "getShowEhbA1cTrend", "()Z", "setShowEhbA1cTrend", "(Z)V", "showEhbA1cUnit", "getShowEhbA1cUnit", "setShowEhbA1cUnit", "showHighPercentTrend", "getShowHighPercentTrend", "setShowHighPercentTrend", "showLowPercentTrend", "getShowLowPercentTrend", "setShowLowPercentTrend", "showMbgTrend", "getShowMbgTrend", "setShowMbgTrend", "showMbgUnit", "getShowMbgUnit", "setShowMbgUnit", "showPieNoData", "getShowPieNoData", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsInfo.kt */
public final class TrendsInfo {
    private String coverTime;
    private double[] dailyP10;
    private double[] dailyP25;
    private double[] dailyP50;
    private double[] dailyP75;
    private double[] dailyP90;
    private String eHbA1c;
    private int glucoseSize;
    private double highPercent;
    private String highPercentDesc;
    private String highPercentDisplay;
    private double lbgi;
    private double lowPercent;
    private String lowPercentDesc;
    private String lowPercentDisplay = "--%";
    private String mbg;
    private String monitorTimes;
    private List<MultiDayBgItem> multiDayHistory;
    private double normalPercent;
    private String normalPercentDesc;
    private String normalPercentDisplay;
    private String pageTitle;
    private boolean showEhbA1cTrend;
    private boolean showEhbA1cUnit;
    private boolean showHighPercentTrend;
    private boolean showLowPercentTrend;
    private boolean showMbgTrend;
    private boolean showMbgUnit;

    public TrendsInfo() {
        String format = ExtendsKt.getNumberFormatWithLocale().format(0);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        this.coverTime = format;
        String format2 = ExtendsKt.getNumberFormatWithLocale().format(0);
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        this.monitorTimes = format2;
        String string = ExtendsKt.getContext().getResources().getString(R.string.com_unknown);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.eHbA1c = string;
        String string2 = ExtendsKt.getContext().getResources().getString(R.string.com_unknown);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.mbg = string2;
        String str = " < " + GlucoseUtilKt.toGlucoseStringWithUnit(ThresholdManager.INSTANCE.getCurUserHypo());
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        this.lowPercentDesc = str;
        this.normalPercentDisplay = "--%";
        String str2 = GlucoseUtilKt.toGlucoseString(ThresholdManager.INSTANCE.getCurUserHypo()) + " - " + GlucoseUtilKt.toGlucoseStringWithUnit(ThresholdManager.INSTANCE.getCurUserHyper());
        Intrinsics.checkNotNullExpressionValue(str2, "toString(...)");
        this.normalPercentDesc = str2;
        this.highPercentDisplay = "--%";
        String str3 = " > " + GlucoseUtilKt.toGlucoseStringWithUnit(ThresholdManager.INSTANCE.getCurUserHyper());
        Intrinsics.checkNotNullExpressionValue(str3, "toString(...)");
        this.highPercentDesc = str3;
        this.dailyP10 = new double[DeviceModelKt.GLUCOSE_NUM_ONE_DAY];
        this.dailyP25 = new double[DeviceModelKt.GLUCOSE_NUM_ONE_DAY];
        this.dailyP50 = new double[DeviceModelKt.GLUCOSE_NUM_ONE_DAY];
        this.dailyP75 = new double[DeviceModelKt.GLUCOSE_NUM_ONE_DAY];
        this.dailyP90 = new double[DeviceModelKt.GLUCOSE_NUM_ONE_DAY];
    }

    public final int getGlucoseSize() {
        return this.glucoseSize;
    }

    public final void setGlucoseSize(int i) {
        this.glucoseSize = i;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final void setPageTitle(String str) {
        this.pageTitle = str;
    }

    public final String getCoverTime() {
        return this.coverTime;
    }

    public final void setCoverTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverTime = str;
    }

    public final String getMonitorTimes() {
        return this.monitorTimes;
    }

    public final void setMonitorTimes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.monitorTimes = str;
    }

    public final String getEHbA1c() {
        return this.eHbA1c;
    }

    public final void setEHbA1c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eHbA1c = str;
    }

    public final boolean getShowEhbA1cUnit() {
        return this.showEhbA1cUnit;
    }

    public final void setShowEhbA1cUnit(boolean z) {
        this.showEhbA1cUnit = z;
    }

    public final boolean getShowEhbA1cTrend() {
        return this.showEhbA1cTrend;
    }

    public final void setShowEhbA1cTrend(boolean z) {
        this.showEhbA1cTrend = z;
    }

    public final String getMbg() {
        return this.mbg;
    }

    public final void setMbg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mbg = str;
    }

    public final boolean getShowMbgUnit() {
        return this.showMbgUnit;
    }

    public final void setShowMbgUnit(boolean z) {
        this.showMbgUnit = z;
    }

    public final boolean getShowMbgTrend() {
        return this.showMbgTrend;
    }

    public final void setShowMbgTrend(boolean z) {
        this.showMbgTrend = z;
    }

    public final double getLowPercent() {
        return this.lowPercent;
    }

    public final void setLowPercent(double d) {
        this.lowPercent = d;
        if (d >= 4.0d) {
            this.showLowPercentTrend = true;
        }
        this.lowPercentDisplay = ExtendsKt.getNumberFormatWithLocale().format(d) + '%';
    }

    public final String getLowPercentDisplay() {
        return this.lowPercentDisplay;
    }

    public final void setLowPercentDisplay(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lowPercentDisplay = str;
    }

    public final String getLowPercentDesc() {
        return this.lowPercentDesc;
    }

    public final void setLowPercentDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lowPercentDesc = str;
    }

    public final boolean getShowLowPercentTrend() {
        return this.showLowPercentTrend;
    }

    public final void setShowLowPercentTrend(boolean z) {
        this.showLowPercentTrend = z;
    }

    public final double getNormalPercent() {
        return this.normalPercent;
    }

    public final void setNormalPercent(double d) {
        this.normalPercent = d;
        this.normalPercentDisplay = ExtendsKt.getNumberFormatWithLocale().format(d) + '%';
    }

    public final String getNormalPercentDisplay() {
        return this.normalPercentDisplay;
    }

    public final void setNormalPercentDisplay(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.normalPercentDisplay = str;
    }

    public final String getNormalPercentDesc() {
        return this.normalPercentDesc;
    }

    public final void setNormalPercentDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.normalPercentDesc = str;
    }

    public final double getHighPercent() {
        return this.highPercent;
    }

    public final void setHighPercent(double d) {
        this.highPercent = d;
        if (d >= 25.0d) {
            this.showHighPercentTrend = true;
        }
        this.highPercentDisplay = ExtendsKt.getNumberFormatWithLocale().format(d) + '%';
    }

    public final String getHighPercentDisplay() {
        return this.highPercentDisplay;
    }

    public final void setHighPercentDisplay(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.highPercentDisplay = str;
    }

    public final String getHighPercentDesc() {
        return this.highPercentDesc;
    }

    public final void setHighPercentDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.highPercentDesc = str;
    }

    public final boolean getShowHighPercentTrend() {
        return this.showHighPercentTrend;
    }

    public final void setShowHighPercentTrend(boolean z) {
        this.showHighPercentTrend = z;
    }

    public final boolean getShowPieNoData() {
        return this.lowPercent == Utils.DOUBLE_EPSILON && this.normalPercent == Utils.DOUBLE_EPSILON && this.highPercent == Utils.DOUBLE_EPSILON;
    }

    public final double[] getDailyP10() {
        return this.dailyP10;
    }

    public final void setDailyP10(double[] dArr) {
        this.dailyP10 = dArr;
    }

    public final double[] getDailyP25() {
        return this.dailyP25;
    }

    public final void setDailyP25(double[] dArr) {
        this.dailyP25 = dArr;
    }

    public final double[] getDailyP50() {
        return this.dailyP50;
    }

    public final void setDailyP50(double[] dArr) {
        this.dailyP50 = dArr;
    }

    public final double[] getDailyP75() {
        return this.dailyP75;
    }

    public final void setDailyP75(double[] dArr) {
        this.dailyP75 = dArr;
    }

    public final double[] getDailyP90() {
        return this.dailyP90;
    }

    public final void setDailyP90(double[] dArr) {
        this.dailyP90 = dArr;
    }

    public final double getLbgi() {
        return this.lbgi;
    }

    public final void setLbgi(double d) {
        this.lbgi = d;
    }

    public final List<MultiDayBgItem> getMultiDayHistory() {
        return this.multiDayHistory;
    }

    public final void setMultiDayHistory(List<MultiDayBgItem> list) {
        this.multiDayHistory = list;
    }
}
