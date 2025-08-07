package com.microtech.aidexx.ui.main.history.eventHistory;

import com.github.mikephil.charting.data.CombinedData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b7\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e¢\u0006\u0002\u0010\u0013J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\t\u00109\u001a\u00020\u000eHÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u000eHÆ\u0003J\t\u0010A\u001a\u00020\u000eHÆ\u0003J\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000eHÆ\u0001J\u0013\u0010C\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\t\u0010G\u001a\u00020\u000eHÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001a\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001f¨\u0006H"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/eventHistory/ChartModel;", "", "id", "", "combinedData", "Lcom/github/mikephil/charting/data/CombinedData;", "hasWave", "", "cgmHighestGlucose", "", "cgmHighestTime", "cgmLowestGlucose", "cgmLowestTime", "cgmHighestTitleText", "", "cgmHighestText", "cgmLowestTitleText", "cgmLowestText", "cgmWaveText", "(JLcom/github/mikephil/charting/data/CombinedData;ZFJFJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCgmHighestGlucose", "()F", "setCgmHighestGlucose", "(F)V", "getCgmHighestText", "()Ljava/lang/String;", "setCgmHighestText", "(Ljava/lang/String;)V", "getCgmHighestTime", "()J", "setCgmHighestTime", "(J)V", "getCgmHighestTitleText", "setCgmHighestTitleText", "getCgmLowestGlucose", "setCgmLowestGlucose", "getCgmLowestText", "setCgmLowestText", "getCgmLowestTime", "setCgmLowestTime", "getCgmLowestTitleText", "setCgmLowestTitleText", "getCgmWaveText", "setCgmWaveText", "getCombinedData", "()Lcom/github/mikephil/charting/data/CombinedData;", "setCombinedData", "(Lcom/github/mikephil/charting/data/CombinedData;)V", "getHasWave", "()Z", "setHasWave", "(Z)V", "getId", "setId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryChartViewHolder.kt */
public final class ChartModel {
    private float cgmHighestGlucose;
    private String cgmHighestText;
    private long cgmHighestTime;
    private String cgmHighestTitleText;
    private float cgmLowestGlucose;
    private String cgmLowestText;
    private long cgmLowestTime;
    private String cgmLowestTitleText;
    private String cgmWaveText;
    private CombinedData combinedData;
    private boolean hasWave;
    private long id;

    public static /* synthetic */ ChartModel copy$default(ChartModel chartModel, long j, CombinedData combinedData2, boolean z, float f, long j2, float f2, long j3, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        ChartModel chartModel2 = chartModel;
        int i2 = i;
        return chartModel.copy((i2 & 1) != 0 ? chartModel2.id : j, (i2 & 2) != 0 ? chartModel2.combinedData : combinedData2, (i2 & 4) != 0 ? chartModel2.hasWave : z, (i2 & 8) != 0 ? chartModel2.cgmHighestGlucose : f, (i2 & 16) != 0 ? chartModel2.cgmHighestTime : j2, (i2 & 32) != 0 ? chartModel2.cgmLowestGlucose : f2, (i2 & 64) != 0 ? chartModel2.cgmLowestTime : j3, (i2 & 128) != 0 ? chartModel2.cgmHighestTitleText : str, (i2 & 256) != 0 ? chartModel2.cgmHighestText : str2, (i2 & 512) != 0 ? chartModel2.cgmLowestTitleText : str3, (i2 & 1024) != 0 ? chartModel2.cgmLowestText : str4, (i2 & 2048) != 0 ? chartModel2.cgmWaveText : str5);
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.cgmLowestTitleText;
    }

    public final String component11() {
        return this.cgmLowestText;
    }

    public final String component12() {
        return this.cgmWaveText;
    }

    public final CombinedData component2() {
        return this.combinedData;
    }

    public final boolean component3() {
        return this.hasWave;
    }

    public final float component4() {
        return this.cgmHighestGlucose;
    }

    public final long component5() {
        return this.cgmHighestTime;
    }

    public final float component6() {
        return this.cgmLowestGlucose;
    }

    public final long component7() {
        return this.cgmLowestTime;
    }

    public final String component8() {
        return this.cgmHighestTitleText;
    }

    public final String component9() {
        return this.cgmHighestText;
    }

    public final ChartModel copy(long j, CombinedData combinedData2, boolean z, float f, long j2, float f2, long j3, String str, String str2, String str3, String str4, String str5) {
        CombinedData combinedData3 = combinedData2;
        Intrinsics.checkNotNullParameter(combinedData3, "combinedData");
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "cgmHighestTitleText");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "cgmHighestText");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "cgmLowestTitleText");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "cgmLowestText");
        Intrinsics.checkNotNullParameter(str5, "cgmWaveText");
        return new ChartModel(j, combinedData3, z, f, j2, f2, j3, str6, str7, str8, str9, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChartModel)) {
            return false;
        }
        ChartModel chartModel = (ChartModel) obj;
        return this.id == chartModel.id && Intrinsics.areEqual((Object) this.combinedData, (Object) chartModel.combinedData) && this.hasWave == chartModel.hasWave && Float.compare(this.cgmHighestGlucose, chartModel.cgmHighestGlucose) == 0 && this.cgmHighestTime == chartModel.cgmHighestTime && Float.compare(this.cgmLowestGlucose, chartModel.cgmLowestGlucose) == 0 && this.cgmLowestTime == chartModel.cgmLowestTime && Intrinsics.areEqual((Object) this.cgmHighestTitleText, (Object) chartModel.cgmHighestTitleText) && Intrinsics.areEqual((Object) this.cgmHighestText, (Object) chartModel.cgmHighestText) && Intrinsics.areEqual((Object) this.cgmLowestTitleText, (Object) chartModel.cgmLowestTitleText) && Intrinsics.areEqual((Object) this.cgmLowestText, (Object) chartModel.cgmLowestText) && Intrinsics.areEqual((Object) this.cgmWaveText, (Object) chartModel.cgmWaveText);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.combinedData.hashCode()) * 31;
        boolean z = this.hasWave;
        if (z) {
            z = true;
        }
        return ((((((((((((((((((hashCode + (z ? 1 : 0)) * 31) + Float.hashCode(this.cgmHighestGlucose)) * 31) + Long.hashCode(this.cgmHighestTime)) * 31) + Float.hashCode(this.cgmLowestGlucose)) * 31) + Long.hashCode(this.cgmLowestTime)) * 31) + this.cgmHighestTitleText.hashCode()) * 31) + this.cgmHighestText.hashCode()) * 31) + this.cgmLowestTitleText.hashCode()) * 31) + this.cgmLowestText.hashCode()) * 31) + this.cgmWaveText.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChartModel(id=");
        sb.append(this.id).append(", combinedData=").append(this.combinedData).append(", hasWave=").append(this.hasWave).append(", cgmHighestGlucose=").append(this.cgmHighestGlucose).append(", cgmHighestTime=").append(this.cgmHighestTime).append(", cgmLowestGlucose=").append(this.cgmLowestGlucose).append(", cgmLowestTime=").append(this.cgmLowestTime).append(", cgmHighestTitleText=").append(this.cgmHighestTitleText).append(", cgmHighestText=").append(this.cgmHighestText).append(", cgmLowestTitleText=").append(this.cgmLowestTitleText).append(", cgmLowestText=").append(this.cgmLowestText).append(", cgmWaveText=");
        sb.append(this.cgmWaveText).append(')');
        return sb.toString();
    }

    public ChartModel(long j, CombinedData combinedData2, boolean z, float f, long j2, float f2, long j3, String str, String str2, String str3, String str4, String str5) {
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        Intrinsics.checkNotNullParameter(combinedData2, "combinedData");
        Intrinsics.checkNotNullParameter(str6, "cgmHighestTitleText");
        Intrinsics.checkNotNullParameter(str7, "cgmHighestText");
        Intrinsics.checkNotNullParameter(str8, "cgmLowestTitleText");
        Intrinsics.checkNotNullParameter(str9, "cgmLowestText");
        Intrinsics.checkNotNullParameter(str10, "cgmWaveText");
        this.id = j;
        this.combinedData = combinedData2;
        this.hasWave = z;
        this.cgmHighestGlucose = f;
        this.cgmHighestTime = j2;
        this.cgmLowestGlucose = f2;
        this.cgmLowestTime = j3;
        this.cgmHighestTitleText = str6;
        this.cgmHighestText = str7;
        this.cgmLowestTitleText = str8;
        this.cgmLowestText = str9;
        this.cgmWaveText = str10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChartModel(long r20, com.github.mikephil.charting.data.CombinedData r22, boolean r23, float r24, long r25, float r27, long r28, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
        /*
            r19 = this;
            r0 = r35
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            long r1 = java.lang.System.currentTimeMillis()
            r4 = r1
            goto L_0x000e
        L_0x000c:
            r4 = r20
        L_0x000e:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0015
            r1 = 0
            r7 = r1
            goto L_0x0017
        L_0x0015:
            r7 = r23
        L_0x0017:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x001e
            r8 = r2
            goto L_0x0020
        L_0x001e:
            r8 = r24
        L_0x0020:
            r1 = r0 & 16
            r9 = 0
            if (r1 == 0) goto L_0x0028
            r11 = r9
            goto L_0x002a
        L_0x0028:
            r11 = r25
        L_0x002a:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r2 = r27
        L_0x0031:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0037
            r13 = r9
            goto L_0x0039
        L_0x0037:
            r13 = r28
        L_0x0039:
            r1 = r0 & 128(0x80, float:1.794E-43)
            java.lang.String r3 = "getString(...)"
            if (r1 == 0) goto L_0x004d
            com.microtech.aidexx.AidexxApp r1 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r6 = com.microtech.aidexx.R.string.history_chart_max
            java.lang.String r1 = r1.getString(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            goto L_0x004f
        L_0x004d:
            r1 = r30
        L_0x004f:
            r6 = r0 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x0062
            com.microtech.aidexx.AidexxApp r6 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r9 = com.microtech.aidexx.R.string.history_chartHint
            java.lang.String r6 = r6.getString(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            r15 = r6
            goto L_0x0064
        L_0x0062:
            r15 = r31
        L_0x0064:
            r6 = r0 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x0078
            com.microtech.aidexx.AidexxApp r6 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r9 = com.microtech.aidexx.R.string.history_chart_min
            java.lang.String r6 = r6.getString(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            r16 = r6
            goto L_0x007a
        L_0x0078:
            r16 = r32
        L_0x007a:
            r6 = r0 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x008e
            com.microtech.aidexx.AidexxApp r6 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r9 = com.microtech.aidexx.R.string.history_chartHint
            java.lang.String r6 = r6.getString(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            r17 = r6
            goto L_0x0090
        L_0x008e:
            r17 = r33
        L_0x0090:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x00a4
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r6 = com.microtech.aidexx.R.string.history_chartHint
            java.lang.String r0 = r0.getString(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r18 = r0
            goto L_0x00a6
        L_0x00a4:
            r18 = r34
        L_0x00a6:
            r3 = r19
            r6 = r22
            r9 = r11
            r11 = r2
            r12 = r13
            r14 = r1
            r3.<init>(r4, r6, r7, r8, r9, r11, r12, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.history.eventHistory.ChartModel.<init>(long, com.github.mikephil.charting.data.CombinedData, boolean, float, long, float, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final CombinedData getCombinedData() {
        return this.combinedData;
    }

    public final void setCombinedData(CombinedData combinedData2) {
        Intrinsics.checkNotNullParameter(combinedData2, "<set-?>");
        this.combinedData = combinedData2;
    }

    public final boolean getHasWave() {
        return this.hasWave;
    }

    public final void setHasWave(boolean z) {
        this.hasWave = z;
    }

    public final float getCgmHighestGlucose() {
        return this.cgmHighestGlucose;
    }

    public final void setCgmHighestGlucose(float f) {
        this.cgmHighestGlucose = f;
    }

    public final long getCgmHighestTime() {
        return this.cgmHighestTime;
    }

    public final void setCgmHighestTime(long j) {
        this.cgmHighestTime = j;
    }

    public final float getCgmLowestGlucose() {
        return this.cgmLowestGlucose;
    }

    public final void setCgmLowestGlucose(float f) {
        this.cgmLowestGlucose = f;
    }

    public final long getCgmLowestTime() {
        return this.cgmLowestTime;
    }

    public final void setCgmLowestTime(long j) {
        this.cgmLowestTime = j;
    }

    public final String getCgmHighestTitleText() {
        return this.cgmHighestTitleText;
    }

    public final void setCgmHighestTitleText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cgmHighestTitleText = str;
    }

    public final String getCgmHighestText() {
        return this.cgmHighestText;
    }

    public final void setCgmHighestText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cgmHighestText = str;
    }

    public final String getCgmLowestTitleText() {
        return this.cgmLowestTitleText;
    }

    public final void setCgmLowestTitleText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cgmLowestTitleText = str;
    }

    public final String getCgmLowestText() {
        return this.cgmLowestText;
    }

    public final void setCgmLowestText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cgmLowestText = str;
    }

    public final String getCgmWaveText() {
        return this.cgmWaveText;
    }

    public final void setCgmWaveText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cgmWaveText = str;
    }
}
