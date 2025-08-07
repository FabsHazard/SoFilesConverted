package com.microtech.aidexx.ui.main.trend;

import com.microtech.aidexx.ble.device.model.DeviceModelKt;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtechmd.cgat.CGA;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsViewModel$runCgat$2$1", f = "TrendsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TrendsViewModel.kt */
final class TrendsViewModel$runCgat$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DataInfoForTrends $it;
    final /* synthetic */ TrendsInfo $trendsInfo;
    int label;
    final /* synthetic */ TrendsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsViewModel$runCgat$2$1(DataInfoForTrends dataInfoForTrends, TrendsInfo trendsInfo, TrendsViewModel trendsViewModel, Continuation<? super TrendsViewModel$runCgat$2$1> continuation) {
        super(2, continuation);
        this.$it = dataInfoForTrends;
        this.$trendsInfo = trendsInfo;
        this.this$0 = trendsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrendsViewModel$runCgat$2$1(this.$it, this.$trendsInfo, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrendsViewModel$runCgat$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CGA cga = new CGA(this.$it.getGlucoseArray());
            double[] periodNUM = cga.getPeriodNUM();
            Intrinsics.checkNotNullExpressionValue(periodNUM, "getPeriodNUM(...)");
            int last = (int) ArraysKt.last(periodNUM);
            double hba1c = cga.getHBA1C();
            double[] periodMBG = cga.getPeriodMBG();
            Intrinsics.checkNotNullExpressionValue(periodMBG, "getPeriodMBG(...)");
            double last2 = ArraysKt.last(periodMBG);
            this.$trendsInfo.setMonitorTimes(String.valueOf(this.$it.getTotalHistory()));
            TrendsInfo trendsInfo = this.$trendsInfo;
            String format = ExtendsKt.getNumberFormatWithLocale().format(Boxing.boxInt(MathKt.roundToInt((((float) last) * 100.0f) / ((float) (this.$it.getMultiDayBgItemList().size() * DeviceModelKt.GLUCOSE_NUM_ONE_DAY)))));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            trendsInfo.setCoverTime(format);
            if (!Double.isNaN(hba1c)) {
                TrendsInfo trendsInfo2 = this.$trendsInfo;
                String format2 = this.this$0.oneDigitFormatWithLocale.format(hba1c);
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                trendsInfo2.setEHbA1c(format2);
                this.$trendsInfo.setShowEhbA1cTrend(hba1c >= 7.0d);
            }
            if (last > 288) {
                this.$trendsInfo.setMbg(GlucoseUtilKt.mmolValueDisplay((float) last2));
                this.$trendsInfo.setShowMbgUnit(true);
                if (!Double.isNaN(last2) && (last2 > 6.6d || last2 < 4.3d)) {
                    this.$trendsInfo.setShowMbgTrend(true);
                }
                float f = (float) 18;
                double[][] periodPT = cga.getPeriodPT(new double[]{0.0d, (double) (ThresholdManager.INSTANCE.getCurUserHypo() / f), (double) (ThresholdManager.INSTANCE.getCurUserHyper() / f), 30.0d});
                TrendsInfo trendsInfo3 = this.$trendsInfo;
                Object[] objArr = (Object[]) periodPT;
                String format3 = this.this$0.oneDigitFormat.format(periodPT[objArr.length - 1][0]);
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                trendsInfo3.setLowPercent(Double.parseDouble(format3));
                TrendsInfo trendsInfo4 = this.$trendsInfo;
                String format4 = this.this$0.oneDigitFormat.format(periodPT[objArr.length - 1][2]);
                Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                trendsInfo4.setHighPercent(Double.parseDouble(format4));
                TrendsInfo trendsInfo5 = this.$trendsInfo;
                trendsInfo5.setNormalPercent(ExtendsKt.format((100.0d - trendsInfo5.getLowPercent()) - this.$trendsInfo.getHighPercent(), 1));
                this.$trendsInfo.setLbgi(cga.getLBGI());
                if (this.$it.getHistoryCount() > 1440) {
                    TrendsViewModel trendsViewModel = this.this$0;
                    double[] dailyTrendPrctile = cga.getDailyTrendPrctile(10.0d);
                    Intrinsics.checkNotNullExpressionValue(dailyTrendPrctile, "getDailyTrendPrctile(...)");
                    double[] validArray$default = TrendsViewModel.getValidArray$default(trendsViewModel, dailyTrendPrctile, (Float) null, 2, (Object) null);
                    TrendsViewModel trendsViewModel2 = this.this$0;
                    double[] dailyTrendPrctile2 = cga.getDailyTrendPrctile(25.0d);
                    Intrinsics.checkNotNullExpressionValue(dailyTrendPrctile2, "getDailyTrendPrctile(...)");
                    double[] validArray$default2 = TrendsViewModel.getValidArray$default(trendsViewModel2, dailyTrendPrctile2, (Float) null, 2, (Object) null);
                    TrendsViewModel trendsViewModel3 = this.this$0;
                    double[] dailyTrendPrctile3 = cga.getDailyTrendPrctile(50.0d);
                    Intrinsics.checkNotNullExpressionValue(dailyTrendPrctile3, "getDailyTrendPrctile(...)");
                    double[] validArray$default3 = TrendsViewModel.getValidArray$default(trendsViewModel3, dailyTrendPrctile3, (Float) null, 2, (Object) null);
                    TrendsViewModel trendsViewModel4 = this.this$0;
                    double[] dailyTrendPrctile4 = cga.getDailyTrendPrctile(75.0d);
                    Intrinsics.checkNotNullExpressionValue(dailyTrendPrctile4, "getDailyTrendPrctile(...)");
                    double[] validArray$default4 = TrendsViewModel.getValidArray$default(trendsViewModel4, dailyTrendPrctile4, (Float) null, 2, (Object) null);
                    TrendsViewModel trendsViewModel5 = this.this$0;
                    double[] dailyTrendPrctile5 = cga.getDailyTrendPrctile(90.0d);
                    Intrinsics.checkNotNullExpressionValue(dailyTrendPrctile5, "getDailyTrendPrctile(...)");
                    double[] validArray$default5 = TrendsViewModel.getValidArray$default(trendsViewModel5, dailyTrendPrctile5, (Float) null, 2, (Object) null);
                    this.$trendsInfo.setDailyP10(validArray$default);
                    this.$trendsInfo.setDailyP25(validArray$default2);
                    this.$trendsInfo.setDailyP50(validArray$default3);
                    this.$trendsInfo.setDailyP75(validArray$default4);
                    this.$trendsInfo.setDailyP90(validArray$default5);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
