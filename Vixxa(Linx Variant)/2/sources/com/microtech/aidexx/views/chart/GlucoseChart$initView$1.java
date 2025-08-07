package com.microtech.aidexx.views.chart;

import android.view.View;
import android.widget.TextView;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.microtech.aidexx.views.chart.GlucoseChart;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/microtech/aidexx/views/chart/GlucoseChart$initView$1", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "onNothingSelected", "", "onValueSelected", "e", "Lcom/github/mikephil/charting/data/Entry;", "h", "Lcom/github/mikephil/charting/highlight/Highlight;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucoseChart.kt */
public final class GlucoseChart$initView$1 implements OnChartValueSelectedListener {
    final /* synthetic */ GlucoseChart this$0;

    GlucoseChart$initView$1(GlucoseChart glucoseChart) {
        this.this$0 = glucoseChart;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ca, code lost:
        if ((((kotlin.Pair) r0).getSecond() instanceof java.lang.Float) != false) goto L_0x02fa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x034f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0370  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onValueSelected(com.github.mikephil.charting.data.Entry r13, com.github.mikephil.charting.highlight.Highlight r14) {
        /*
            r12 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "h"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.Object r0 = r13.getData()
            r1 = 0
            if (r0 == 0) goto L_0x002d
            boolean r2 = r0 instanceof kotlin.Pair
            if (r2 == 0) goto L_0x001e
            kotlin.Pair r0 = (kotlin.Pair) r0
            java.lang.Object r0 = r0.getFirst()
            java.lang.Long r0 = (java.lang.Long) r0
            goto L_0x002e
        L_0x001e:
            boolean r2 = r0 instanceof com.microtech.aidexx.db.entity.BaseEventEntity
            if (r2 == 0) goto L_0x002d
            com.microtech.aidexx.db.entity.BaseEventEntity r0 = (com.microtech.aidexx.db.entity.BaseEventEntity) r0
            long r2 = r0.convertToCurZoneTs()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            goto L_0x002e
        L_0x002d:
            r0 = r1
        L_0x002e:
            java.util.Date r2 = new java.util.Date
            if (r0 == 0) goto L_0x0037
            long r3 = r0.longValue()
            goto L_0x0045
        L_0x0037:
            com.microtech.aidexx.views.chart.ChartUtil r0 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
            float r3 = r14.getX()
            long r3 = r0.xToSecond(r3)
            r0 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r0
            long r3 = r3 * r5
        L_0x0045:
            r2.<init>(r3)
            com.microtech.aidexx.views.chart.GlucoseChart r0 = r12.this$0
            java.text.SimpleDateFormat r0 = r0.getFormat()
            com.microtech.aidexx.utils.TimeUtils r3 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            java.util.TimeZone r3 = r3.getCDFTimezone()
            r0.setTimeZone(r3)
            com.microtech.aidexx.views.chart.GlucoseChart r0 = r12.this$0
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r0 = r0.getExtraParams()
            if (r0 == 0) goto L_0x0064
            android.widget.TextView r0 = r0.getOuterDescriptionX()
            goto L_0x0065
        L_0x0064:
            r0 = r1
        L_0x0065:
            if (r0 != 0) goto L_0x0068
            goto L_0x0077
        L_0x0068:
            com.microtech.aidexx.views.chart.GlucoseChart r3 = r12.this$0
            java.text.SimpleDateFormat r3 = r3.getFormat()
            java.lang.String r2 = r3.format(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0077:
            com.microtech.aidexx.utils.ThemeManager r0 = com.microtech.aidexx.utils.ThemeManager.INSTANCE
            boolean r0 = r0.isLight()
            if (r0 == 0) goto L_0x0093
            com.microtech.aidexx.views.chart.GlucoseChart r0 = r12.this$0
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r0 = r0.getExtraParams()
            if (r0 == 0) goto L_0x00a6
            android.view.View r0 = r0.getOuterDescriptionView()
            if (r0 == 0) goto L_0x00a6
            int r2 = com.microtech.aidexx.R.drawable.bg_desc_light
            r0.setBackgroundResource(r2)
            goto L_0x00a6
        L_0x0093:
            com.microtech.aidexx.views.chart.GlucoseChart r0 = r12.this$0
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r0 = r0.getExtraParams()
            if (r0 == 0) goto L_0x00a6
            android.view.View r0 = r0.getOuterDescriptionView()
            if (r0 == 0) goto L_0x00a6
            int r2 = com.microtech.aidexx.R.drawable.bg_desc_dark
            r0.setBackgroundResource(r2)
        L_0x00a6:
            java.lang.Object r0 = r13.getData()
            java.lang.String r2 = "toString(...)"
            java.lang.String r3 = "getResources(...)"
            r4 = 0
            if (r0 == 0) goto L_0x02fa
            java.lang.Object r0 = r13.getData()
            boolean r0 = r0 instanceof kotlin.Pair
            if (r0 == 0) goto L_0x00ce
            java.lang.Object r0 = r13.getData()
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Pair<*, *>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            java.lang.Object r0 = r0.getSecond()
            boolean r0 = r0 instanceof java.lang.Float
            if (r0 == 0) goto L_0x00ce
            goto L_0x02fa
        L_0x00ce:
            java.lang.Object r13 = r13.getData()
            r0 = 1
            java.lang.String r5 = "--"
            if (r13 == 0) goto L_0x02c1
            com.microtech.aidexx.views.chart.GlucoseChart r13 = r12.this$0
            com.github.mikephil.charting.data.ChartData r13 = r13.getData()
            com.github.mikephil.charting.data.CombinedData r13 = (com.github.mikephil.charting.data.CombinedData) r13
            if (r13 == 0) goto L_0x018f
            com.github.mikephil.charting.data.LineData r13 = r13.getLineData()
            if (r13 == 0) goto L_0x018f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.util.List r13 = r13.getDataSets()
            if (r13 == 0) goto L_0x018f
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r13 = r13.iterator()
        L_0x00fd:
            boolean r7 = r13.hasNext()
            if (r7 == 0) goto L_0x011a
            java.lang.Object r7 = r13.next()
            r8 = r7
            com.github.mikephil.charting.interfaces.datasets.ILineDataSet r8 = (com.github.mikephil.charting.interfaces.datasets.ILineDataSet) r8
            boolean r9 = r8 instanceof com.microtech.aidexx.views.chart.dataset.CurrentGlucoseDataSet
            if (r9 != 0) goto L_0x0116
            boolean r9 = r8 instanceof com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine
            if (r9 != 0) goto L_0x0116
            boolean r8 = r8 instanceof com.microtech.aidexx.views.chart.dataset.GlucoseDataSet
            if (r8 == 0) goto L_0x00fd
        L_0x0116:
            r6.add(r7)
            goto L_0x00fd
        L_0x011a:
            java.util.List r6 = (java.util.List) r6
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r13 = r6.isEmpty()
            if (r13 == 0) goto L_0x0125
            r6 = r1
        L_0x0125:
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x018f
            java.util.Iterator r13 = r6.iterator()
            r6 = r1
        L_0x012e:
            boolean r7 = r13.hasNext()
            if (r7 == 0) goto L_0x0190
            java.lang.Object r7 = r13.next()
            com.github.mikephil.charting.interfaces.datasets.ILineDataSet r7 = (com.github.mikephil.charting.interfaces.datasets.ILineDataSet) r7
            float r8 = r14.getX()
            r9 = 1008981770(0x3c23d70a, float:0.01)
            float r8 = r8 - r9
            float r10 = r14.getX()
            float r10 = r10 + r9
            java.util.List r7 = r7.getEntriesForXRange(r8, r10)
            if (r7 == 0) goto L_0x012e
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x0156
            r7 = r1
        L_0x0156:
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x012e
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0160:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x012e
            java.lang.Object r8 = r7.next()
            com.github.mikephil.charting.data.Entry r8 = (com.github.mikephil.charting.data.Entry) r8
            if (r6 != 0) goto L_0x016f
            goto L_0x018d
        L_0x016f:
            float r9 = r14.getX()
            float r10 = r8.getX()
            float r9 = r9 - r10
            float r9 = java.lang.Math.abs(r9)
            float r10 = r14.getX()
            float r11 = r6.getX()
            float r10 = r10 - r11
            float r10 = java.lang.Math.abs(r10)
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 >= 0) goto L_0x0160
        L_0x018d:
            r6 = r8
            goto L_0x0160
        L_0x018f:
            r6 = r1
        L_0x0190:
            if (r6 == 0) goto L_0x0282
            com.microtech.aidexx.views.chart.GlucoseChart r13 = r12.this$0
            java.lang.Object r7 = r6.getData()
            if (r7 == 0) goto L_0x01df
            java.lang.Object r7 = r6.getData()
            boolean r7 = r7 instanceof java.lang.Float
            if (r7 != 0) goto L_0x01df
            java.lang.Object r7 = r6.getData()
            boolean r7 = r7 instanceof com.microtech.aidexx.utils.eventbus.CgmDataState
            if (r7 == 0) goto L_0x01ab
            goto L_0x01df
        L_0x01ab:
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r14 = r13.getExtraParams()
            if (r14 == 0) goto L_0x01b6
            android.widget.TextView r14 = r14.getOuterDescriptionY()
            goto L_0x01b7
        L_0x01b6:
            r14 = r1
        L_0x01b7:
            if (r14 != 0) goto L_0x01ba
            goto L_0x01c0
        L_0x01ba:
            r2 = r5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r14.setText(r2)
        L_0x01c0:
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r14 = r13.getExtraParams()
            if (r14 == 0) goto L_0x01cb
            android.widget.TextView r14 = r14.getOuterDescriptionUnit()
            goto L_0x01cc
        L_0x01cb:
            r14 = r1
        L_0x01cc:
            if (r14 != 0) goto L_0x01cf
            goto L_0x01da
        L_0x01cf:
            com.microtech.aidexx.utils.UnitManager r2 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            java.lang.String r2 = r2.getDisplayUnit()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r14.setText(r2)
        L_0x01da:
            r13.isValueNull = r0
            goto L_0x027f
        L_0x01df:
            java.lang.Object r7 = r6.getData()
            if (r7 == 0) goto L_0x022c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.Object r7 = r6.getData()
            boolean r7 = r7 instanceof com.microtech.aidexx.utils.eventbus.CgmDataState
            if (r7 == 0) goto L_0x0210
            java.lang.Object r6 = r6.getData()
            java.lang.String r7 = "null cannot be cast to non-null type com.microtech.aidexx.utils.eventbus.CgmDataState"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            com.microtech.aidexx.utils.eventbus.CgmDataState r6 = (com.microtech.aidexx.utils.eventbus.CgmDataState) r6
            java.lang.Float r6 = r6.getGlucoseValueMg()
            if (r6 == 0) goto L_0x020e
            float r6 = r6.floatValue()
            float r6 = com.microtech.aidexx.utils.GlucoseUtilKt.toGlucoseValue((float) r6)
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            goto L_0x0225
        L_0x020e:
            r6 = r1
            goto L_0x0225
        L_0x0210:
            java.lang.Object r6 = r6.getData()
            java.lang.Float r6 = (java.lang.Float) r6
            if (r6 == 0) goto L_0x021d
            float r6 = r6.floatValue()
            goto L_0x0221
        L_0x021d:
            float r6 = r14.getY()
        L_0x0221:
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
        L_0x0225:
            if (r6 == 0) goto L_0x022c
            float r14 = r6.floatValue()
            goto L_0x0230
        L_0x022c:
            float r14 = r14.getY()
        L_0x0230:
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r6 = r13.getExtraParams()
            if (r6 == 0) goto L_0x023b
            android.widget.TextView r6 = r6.getOuterDescriptionY()
            goto L_0x023c
        L_0x023b:
            r6 = r1
        L_0x023c:
            if (r6 != 0) goto L_0x023f
            goto L_0x0262
        L_0x023f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            float r14 = com.microtech.aidexx.utils.GlucoseUtilKt.fromGlucoseValue(r14)
            android.content.res.Resources r8 = r13.getResources()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            java.lang.String r14 = com.microtech.aidexx.utils.GlucoseUtilKt.toGlucoseStringWithLowAndHigh(r14, r8)
            r7.append(r14)
            java.lang.String r14 = r7.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r2)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r6.setText(r14)
        L_0x0262:
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r14 = r13.getExtraParams()
            if (r14 == 0) goto L_0x026d
            android.widget.TextView r14 = r14.getOuterDescriptionUnit()
            goto L_0x026e
        L_0x026d:
            r14 = r1
        L_0x026e:
            if (r14 != 0) goto L_0x0271
            goto L_0x027c
        L_0x0271:
            com.microtech.aidexx.utils.UnitManager r2 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            java.lang.String r2 = r2.getDisplayUnit()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r14.setText(r2)
        L_0x027c:
            r13.isValueNull = r4
        L_0x027f:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            goto L_0x0283
        L_0x0282:
            r13 = r1
        L_0x0283:
            if (r13 != 0) goto L_0x0368
            com.microtech.aidexx.views.chart.GlucoseChart r13 = r12.this$0
            r14 = r12
            com.microtech.aidexx.views.chart.GlucoseChart$initView$1 r14 = (com.microtech.aidexx.views.chart.GlucoseChart$initView$1) r14
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r14 = r13.getExtraParams()
            if (r14 == 0) goto L_0x0295
            android.widget.TextView r14 = r14.getOuterDescriptionY()
            goto L_0x0296
        L_0x0295:
            r14 = r1
        L_0x0296:
            if (r14 != 0) goto L_0x0299
            goto L_0x029e
        L_0x0299:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r14.setText(r5)
        L_0x029e:
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r14 = r13.getExtraParams()
            if (r14 == 0) goto L_0x02a9
            android.widget.TextView r14 = r14.getOuterDescriptionUnit()
            goto L_0x02aa
        L_0x02a9:
            r14 = r1
        L_0x02aa:
            if (r14 != 0) goto L_0x02ad
            goto L_0x02bc
        L_0x02ad:
            com.microtech.aidexx.utils.UnitManager r2 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            com.microtech.aidexx.utils.UnitManager$GlucoseUnit r2 = r2.getGlucoseUnit()
            java.lang.String r2 = r2.getText()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r14.setText(r2)
        L_0x02bc:
            r13.isValueNull = r0
            goto L_0x0368
        L_0x02c1:
            com.microtech.aidexx.views.chart.GlucoseChart r13 = r12.this$0
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r13 = r13.getExtraParams()
            if (r13 == 0) goto L_0x02ce
            android.widget.TextView r13 = r13.getOuterDescriptionY()
            goto L_0x02cf
        L_0x02ce:
            r13 = r1
        L_0x02cf:
            if (r13 != 0) goto L_0x02d2
            goto L_0x02d7
        L_0x02d2:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r13.setText(r5)
        L_0x02d7:
            com.microtech.aidexx.views.chart.GlucoseChart r13 = r12.this$0
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r13 = r13.getExtraParams()
            if (r13 == 0) goto L_0x02e4
            android.widget.TextView r13 = r13.getOuterDescriptionUnit()
            goto L_0x02e5
        L_0x02e4:
            r13 = r1
        L_0x02e5:
            if (r13 != 0) goto L_0x02e8
            goto L_0x02f3
        L_0x02e8:
            com.microtech.aidexx.utils.UnitManager r14 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            java.lang.String r14 = r14.getDisplayUnit()
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r13.setText(r14)
        L_0x02f3:
            com.microtech.aidexx.views.chart.GlucoseChart r13 = r12.this$0
            r13.isValueNull = r0
            goto L_0x0368
        L_0x02fa:
            java.lang.Object r13 = r13.getData()
            if (r13 == 0) goto L_0x030d
            kotlin.Pair r13 = (kotlin.Pair) r13
            java.lang.Object r13 = r13.getSecond()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            goto L_0x0311
        L_0x030d:
            float r13 = r14.getY()
        L_0x0311:
            com.microtech.aidexx.views.chart.GlucoseChart r14 = r12.this$0
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r14 = r14.getExtraParams()
            if (r14 == 0) goto L_0x031e
            android.widget.TextView r14 = r14.getOuterDescriptionY()
            goto L_0x031f
        L_0x031e:
            r14 = r1
        L_0x031f:
            if (r14 != 0) goto L_0x0322
            goto L_0x0347
        L_0x0322:
            com.microtech.aidexx.views.chart.GlucoseChart r0 = r12.this$0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            float r13 = com.microtech.aidexx.utils.GlucoseUtilKt.fromGlucoseValue(r13)
            android.content.res.Resources r0 = r0.getResources()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.String r13 = com.microtech.aidexx.utils.GlucoseUtilKt.toGlucoseStringWithLowAndHigh(r13, r0)
            r5.append(r13)
            java.lang.String r13 = r5.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r2)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r14.setText(r13)
        L_0x0347:
            com.microtech.aidexx.views.chart.GlucoseChart r13 = r12.this$0
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r13 = r13.getExtraParams()
            if (r13 == 0) goto L_0x0354
            android.widget.TextView r13 = r13.getOuterDescriptionUnit()
            goto L_0x0355
        L_0x0354:
            r13 = r1
        L_0x0355:
            if (r13 != 0) goto L_0x0358
            goto L_0x0363
        L_0x0358:
            com.microtech.aidexx.utils.UnitManager r14 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            java.lang.String r14 = r14.getDisplayUnit()
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r13.setText(r14)
        L_0x0363:
            com.microtech.aidexx.views.chart.GlucoseChart r13 = r12.this$0
            r13.isValueNull = r4
        L_0x0368:
            com.microtech.aidexx.views.chart.GlucoseChart r13 = r12.this$0
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r13 = r13.getExtraParams()
            if (r13 == 0) goto L_0x0374
            android.view.View r1 = r13.getOuterDescriptionView()
        L_0x0374:
            if (r1 != 0) goto L_0x0377
            goto L_0x037a
        L_0x0377:
            r1.setVisibility(r4)
        L_0x037a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.views.chart.GlucoseChart$initView$1.onValueSelected(com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.highlight.Highlight):void");
    }

    public void onNothingSelected() {
        this.this$0.isValueNull = true;
        GlucoseChart.ExtraParams extraParams = this.this$0.getExtraParams();
        View view = null;
        TextView outerDescriptionUnit = extraParams != null ? extraParams.getOuterDescriptionUnit() : null;
        if (outerDescriptionUnit != null) {
            outerDescriptionUnit.setText("");
        }
        GlucoseChart.ExtraParams extraParams2 = this.this$0.getExtraParams();
        TextView outerDescriptionX = extraParams2 != null ? extraParams2.getOuterDescriptionX() : null;
        if (outerDescriptionX != null) {
            outerDescriptionX.setText("");
        }
        GlucoseChart.ExtraParams extraParams3 = this.this$0.getExtraParams();
        TextView outerDescriptionY = extraParams3 != null ? extraParams3.getOuterDescriptionY() : null;
        if (outerDescriptionY != null) {
            outerDescriptionY.setText("");
        }
        GlucoseChart.ExtraParams extraParams4 = this.this$0.getExtraParams();
        TextView outerDescriptionUnit2 = extraParams4 != null ? extraParams4.getOuterDescriptionUnit() : null;
        if (outerDescriptionUnit2 != null) {
            outerDescriptionUnit2.setText("");
        }
        GlucoseChart.ExtraParams extraParams5 = this.this$0.getExtraParams();
        if (extraParams5 != null) {
            view = extraParams5.getOuterDescriptionView();
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
