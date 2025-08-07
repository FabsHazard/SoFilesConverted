package com.microtech.aidexx.ui.main.history;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.history.HistoryViewModel$loadAndCalculateData$2", f = "HistoryViewModel.kt", i = {0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6}, l = {124, 126, 194, 197, 199, 202, 204, 208}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "countDataModel", "proportionDataModel", "chartModel", "records", "alerts", "proportionDataModel", "chartModel", "records", "alerts", "proportionDataModel", "records", "alerts", "records", "alerts", "alerts"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$1", "L$2", "L$3", "L$4", "L$1", "L$2", "L$3", "L$1", "L$2", "L$1"})
/* compiled from: HistoryViewModel.kt */
final class HistoryViewModel$loadAndCalculateData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ HistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HistoryViewModel$loadAndCalculateData$2(HistoryViewModel historyViewModel, Continuation<? super HistoryViewModel$loadAndCalculateData$2> continuation) {
        super(2, continuation);
        this.this$0 = historyViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HistoryViewModel$loadAndCalculateData$2 historyViewModel$loadAndCalculateData$2 = new HistoryViewModel$loadAndCalculateData$2(this.this$0, continuation);
        historyViewModel$loadAndCalculateData$2.L$0 = obj;
        return historyViewModel$loadAndCalculateData$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HistoryViewModel$loadAndCalculateData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x010e, code lost:
        r2 = (java.util.List) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0110, code lost:
        r11 = r5;
        r10 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0129, code lost:
        r2 = (java.util.List) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x012c, code lost:
        r12 = new com.microtech.aidexx.ui.main.history.eventHistory.CountModel(0, false, (java.lang.Double) null, (java.lang.Double) null, (java.lang.Double) null, (java.lang.Double) null, (java.lang.Double) null, (java.lang.Double) null, 255, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r24 = new com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel(0, false, 0, 0, 0, 0, 0, (java.lang.String) null, (java.lang.String) null, 0, (java.lang.String) null, (java.lang.String) null, 0, (java.lang.String) null, (java.lang.String) null, 32767, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0172, code lost:
        if (r10.combinedData != null) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0174, code lost:
        r10.combinedData = new com.github.mikephil.charting.data.CombinedData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x017d, code lost:
        r10.resetChartData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0180, code lost:
        r5 = r10.combinedData;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0186, code lost:
        if (r5 != null) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0188, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("combinedData");
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x018f, code lost:
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0190, code lost:
        r12 = new com.microtech.aidexx.ui.main.history.eventHistory.ChartModel(0, r15, false, 0.0f, 0, 0.0f, 0, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, 4093, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r6 = new java.util.concurrent.CopyOnWriteArrayList();
        r5 = new kotlin.jvm.internal.Ref.ObjectRef();
        r5.element = kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true), new java.util.ArrayList());
        r2 = r2;
        r3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, 10));
        r2 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01e0, code lost:
        if (r2.hasNext() == false) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01e2, code lost:
        r3.add(kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r11, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new com.microtech.aidexx.ui.main.history.HistoryViewModel$loadAndCalculateData$2$1$1$1((java.util.List) r2.next(), r7, r10, r8, r5, r9, r6, (kotlin.coroutines.Continuation<? super com.microtech.aidexx.ui.main.history.HistoryViewModel$loadAndCalculateData$2$1$1$1>) null), 3, (java.lang.Object) null));
        r5 = r5;
        r9 = r9;
        r10 = r10;
        r7 = r7;
        r6 = r6;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0224, code lost:
        r4 = r5;
        r15 = r7;
        r12 = r9;
        r13 = r10;
        r0.L$0 = r13;
        r0.L$1 = r12;
        r2 = r8;
        r0.L$2 = r2;
        r0.L$3 = r15;
        r5 = r6;
        r0.L$4 = r5;
        r0.L$5 = r4;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0247, code lost:
        if (kotlinx.coroutines.AwaitKt.awaitAll((java.util.List) r3, r0) != r1) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0249, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x024a, code lost:
        r6 = r2;
        r2 = r4;
        r3 = r5;
        r7 = r12;
        r8 = r13;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0254, code lost:
        if (r7.getDirty() != false) goto L_0x0273;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0256, code lost:
        r4 = r8._countModel;
        r0.L$0 = r8;
        r0.L$1 = r6;
        r0.L$2 = r5;
        r0.L$3 = r3;
        r0.L$4 = r2;
        r0.L$5 = null;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x026e, code lost:
        if (r4.emit(r7, r0) != r1) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0270, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0271, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0272, code lost:
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0273, code lost:
        r0.L$0 = r8;
        r0.L$1 = r6;
        r0.L$2 = r3;
        r0.L$3 = r2;
        r0.L$4 = null;
        r0.L$5 = null;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0287, code lost:
        if (r8.notifyRefreshChart(r5, r0) != r1) goto L_0x028a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0289, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x028a, code lost:
        r5 = r6;
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0290, code lost:
        if (r5.getDirty() != false) goto L_0x02ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0292, code lost:
        r4 = r6._proportionModel;
        r0.L$0 = r6;
        r0.L$1 = r3;
        r0.L$2 = r2;
        r0.L$3 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x02a6, code lost:
        if (r4.emit(r5, r0) != r1) goto L_0x02a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x02a8, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x02a9, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x02aa, code lost:
        r4 = r3;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x02ad, code lost:
        r4 = r3;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x02af, code lost:
        r5 = r3._recordsModel;
        r4 = kotlin.collections.CollectionsKt.sortedWith(r4, new com.microtech.aidexx.ui.main.history.HistoryViewModel$loadAndCalculateData$2$invokeSuspend$lambda$2$$inlined$sortedByDescending$1());
        r0.L$0 = r3;
        r0.L$1 = r2;
        r6 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x02d0, code lost:
        if (r5.emit(r4, r0) != r1) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x02d2, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x02d3, code lost:
        r3 = r3._alertModel;
        r2 = r2.element.getSecond();
        r0.L$0 = r6;
        r0.L$1 = r6;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x02eb, code lost:
        if (r3.emit(r2, r0) != r1) goto L_0x02ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02ed, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x02f0, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r46) {
        /*
            r45 = this;
            r0 = r45
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x00a2;
                case 1: goto L_0x0093;
                case 2: goto L_0x0083;
                case 3: goto L_0x0066;
                case 4: goto L_0x004d;
                case 5: goto L_0x0038;
                case 6: goto L_0x0027;
                case 7: goto L_0x0019;
                case 8: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0014:
            kotlin.ResultKt.throwOnFailure(r46)
            goto L_0x02ee
        L_0x0019:
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r0.L$0
            com.microtech.aidexx.ui.main.history.HistoryViewModel r3 = (com.microtech.aidexx.ui.main.history.HistoryViewModel) r3
            kotlin.ResultKt.throwOnFailure(r46)
            r6 = 0
            goto L_0x02d3
        L_0x0027:
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r0.L$1
            java.util.concurrent.CopyOnWriteArrayList r3 = (java.util.concurrent.CopyOnWriteArrayList) r3
            java.lang.Object r5 = r0.L$0
            com.microtech.aidexx.ui.main.history.HistoryViewModel r5 = (com.microtech.aidexx.ui.main.history.HistoryViewModel) r5
            kotlin.ResultKt.throwOnFailure(r46)
            goto L_0x02aa
        L_0x0038:
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r0.L$2
            java.util.concurrent.CopyOnWriteArrayList r3 = (java.util.concurrent.CopyOnWriteArrayList) r3
            java.lang.Object r5 = r0.L$1
            com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel r5 = (com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel) r5
            java.lang.Object r6 = r0.L$0
            com.microtech.aidexx.ui.main.history.HistoryViewModel r6 = (com.microtech.aidexx.ui.main.history.HistoryViewModel) r6
            kotlin.ResultKt.throwOnFailure(r46)
            goto L_0x028c
        L_0x004d:
            java.lang.Object r2 = r0.L$4
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r0.L$3
            java.util.concurrent.CopyOnWriteArrayList r3 = (java.util.concurrent.CopyOnWriteArrayList) r3
            java.lang.Object r5 = r0.L$2
            com.microtech.aidexx.ui.main.history.eventHistory.ChartModel r5 = (com.microtech.aidexx.ui.main.history.eventHistory.ChartModel) r5
            java.lang.Object r6 = r0.L$1
            com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel r6 = (com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel) r6
            java.lang.Object r7 = r0.L$0
            com.microtech.aidexx.ui.main.history.HistoryViewModel r7 = (com.microtech.aidexx.ui.main.history.HistoryViewModel) r7
            kotlin.ResultKt.throwOnFailure(r46)
            goto L_0x0272
        L_0x0066:
            java.lang.Object r2 = r0.L$5
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r0.L$4
            java.util.concurrent.CopyOnWriteArrayList r3 = (java.util.concurrent.CopyOnWriteArrayList) r3
            java.lang.Object r5 = r0.L$3
            com.microtech.aidexx.ui.main.history.eventHistory.ChartModel r5 = (com.microtech.aidexx.ui.main.history.eventHistory.ChartModel) r5
            java.lang.Object r6 = r0.L$2
            com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel r6 = (com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel) r6
            java.lang.Object r7 = r0.L$1
            com.microtech.aidexx.ui.main.history.eventHistory.CountModel r7 = (com.microtech.aidexx.ui.main.history.eventHistory.CountModel) r7
            java.lang.Object r8 = r0.L$0
            com.microtech.aidexx.ui.main.history.HistoryViewModel r8 = (com.microtech.aidexx.ui.main.history.HistoryViewModel) r8
            kotlin.ResultKt.throwOnFailure(r46)
            goto L_0x0250
        L_0x0083:
            java.lang.Object r2 = r0.L$1
            com.microtech.aidexx.ui.main.history.HistoryViewModel r2 = (com.microtech.aidexx.ui.main.history.HistoryViewModel) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r46)
            r6 = r2
            r2 = r46
            goto L_0x0129
        L_0x0093:
            java.lang.Object r2 = r0.L$1
            com.microtech.aidexx.ui.main.history.HistoryViewModel r2 = (com.microtech.aidexx.ui.main.history.HistoryViewModel) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r46)
            r6 = r2
            r2 = r46
            goto L_0x010e
        L_0x00a2:
            kotlin.ResultKt.throwOnFailure(r46)
            java.lang.Object r2 = r0.L$0
            r5 = r2
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            com.microtech.aidexx.ui.main.history.HistoryViewModel r2 = r0.this$0
            kotlinx.coroutines.flow.MutableStateFlow r2 = r2._curDate
            java.lang.Object r2 = r2.getValue()
            java.util.Date r2 = (java.util.Date) r2
            if (r2 != 0) goto L_0x00bd
            java.util.Date r2 = new java.util.Date
            r2.<init>()
        L_0x00bd:
            com.microtech.aidexx.ui.main.history.HistoryViewModel r6 = r0.this$0
            boolean r7 = com.microtech.aidexx.common.ExtendsKt.useAppTime()
            if (r7 == 0) goto L_0x0113
            java.lang.String r7 = com.microtech.aidexx.common.ExtendsKt.date2YMDByEnglish(r2)
            java.util.Date r8 = new java.util.Date
            java.util.Date r2 = com.microtech.aidexx.common.ExtendsKt.getEndOfTheDay(r2)
            long r9 = r2.getTime()
            r11 = 1
            long r9 = r9 + r11
            r8.<init>(r9)
            java.lang.String r2 = com.microtech.aidexx.common.ExtendsKt.date2YMDByEnglish(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r7 = r8.append(r7)
            java.lang.String r8 = " 00:00:00"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r2 = r9.append(r2)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r2 = r6.loadCurDateAllData((java.lang.String) r7, (java.lang.String) r2, (kotlin.coroutines.Continuation<? super java.util.List<? extends java.util.List<? extends com.microtech.aidexx.db.entity.BaseEventEntity>>>) r0)
            if (r2 != r1) goto L_0x010e
            return r1
        L_0x010e:
            java.util.List r2 = (java.util.List) r2
        L_0x0110:
            r11 = r5
            r10 = r6
            goto L_0x012c
        L_0x0113:
            java.util.Date r7 = com.microtech.aidexx.common.ExtendsKt.getStartOfTheDay(r2)
            java.util.Date r2 = com.microtech.aidexx.common.ExtendsKt.getEndOfTheDay(r2)
            r0.L$0 = r5
            r0.L$1 = r6
            r8 = 2
            r0.label = r8
            java.lang.Object r2 = r6.loadCurDateAllData((java.util.Date) r7, (java.util.Date) r2, (kotlin.coroutines.Continuation<? super java.util.List<? extends java.util.List<? extends com.microtech.aidexx.db.entity.BaseEventEntity>>>) r0)
            if (r2 != r1) goto L_0x0129
            return r1
        L_0x0129:
            java.util.List r2 = (java.util.List) r2
            goto L_0x0110
        L_0x012c:
            com.microtech.aidexx.ui.main.history.eventHistory.CountModel r9 = new com.microtech.aidexx.ui.main.history.eventHistory.CountModel
            r22 = 255(0xff, float:3.57E-43)
            r23 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r12 = r9
            r12.<init>(r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel r8 = new com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel
            r24 = r8
            r41 = 32767(0x7fff, float:4.5916E-41)
            r42 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r24.<init>(r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            com.github.mikephil.charting.data.CombinedData r5 = r10.combinedData
            if (r5 != 0) goto L_0x017d
            com.github.mikephil.charting.data.CombinedData r5 = new com.github.mikephil.charting.data.CombinedData
            r5.<init>()
            r10.combinedData = r5
            goto L_0x0180
        L_0x017d:
            r10.resetChartData()
        L_0x0180:
            com.microtech.aidexx.ui.main.history.eventHistory.ChartModel r7 = new com.microtech.aidexx.ui.main.history.eventHistory.ChartModel
            com.github.mikephil.charting.data.CombinedData r5 = r10.combinedData
            if (r5 != 0) goto L_0x018f
            java.lang.String r5 = "combinedData"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r15 = 0
            goto L_0x0190
        L_0x018f:
            r15 = r5
        L_0x0190:
            r28 = 4093(0xffd, float:5.736E-42)
            r29 = 0
            r13 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r12 = r7
            r12.<init>(r13, r15, r16, r17, r18, r20, r21, r23, r24, r25, r26, r27, r28, r29)
            java.util.concurrent.CopyOnWriteArrayList r6 = new java.util.concurrent.CopyOnWriteArrayList
            r6.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r12 = (java.util.List) r12
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r12)
            r5.element = r3
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r12 = 10
            int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r12)
            r3.<init>(r12)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x01dc:
            boolean r12 = r2.hasNext()
            if (r12 == 0) goto L_0x0224
            java.lang.Object r12 = r2.next()
            r13 = r12
            java.util.List r13 = (java.util.List) r13
            com.microtech.aidexx.ui.main.history.HistoryViewModel$loadAndCalculateData$2$1$1$1 r21 = new com.microtech.aidexx.ui.main.history.HistoryViewModel$loadAndCalculateData$2$1$1$1
            r20 = 0
            r12 = r21
            r14 = r7
            r15 = r10
            r16 = r8
            r17 = r5
            r18 = r9
            r19 = r6
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
            r12 = r21
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r4 = r5
            r5 = r11
            r43 = r6
            r6 = r15
            r15 = r7
            r7 = r16
            r44 = r8
            r8 = r12
            r12 = r9
            r9 = r13
            r13 = r10
            r10 = r14
            kotlinx.coroutines.Deferred r5 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r5, r6, r7, r8, r9, r10)
            r3.add(r5)
            r5 = r4
            r9 = r12
            r10 = r13
            r7 = r15
            r6 = r43
            r8 = r44
            goto L_0x01dc
        L_0x0224:
            r4 = r5
            r43 = r6
            r15 = r7
            r44 = r8
            r12 = r9
            r13 = r10
            java.util.List r3 = (java.util.List) r3
            java.util.Collection r3 = (java.util.Collection) r3
            r0.L$0 = r13
            r0.L$1 = r12
            r2 = r44
            r0.L$2 = r2
            r0.L$3 = r15
            r5 = r43
            r0.L$4 = r5
            r0.L$5 = r4
            r6 = 3
            r0.label = r6
            java.lang.Object r3 = kotlinx.coroutines.AwaitKt.awaitAll(r3, r0)
            if (r3 != r1) goto L_0x024a
            return r1
        L_0x024a:
            r6 = r2
            r2 = r4
            r3 = r5
            r7 = r12
            r8 = r13
            r5 = r15
        L_0x0250:
            boolean r4 = r7.getDirty()
            if (r4 != 0) goto L_0x0273
            kotlinx.coroutines.flow.MutableStateFlow r4 = r8._countModel
            r0.L$0 = r8
            r0.L$1 = r6
            r0.L$2 = r5
            r0.L$3 = r3
            r0.L$4 = r2
            r9 = 0
            r0.L$5 = r9
            r9 = 4
            r0.label = r9
            java.lang.Object r4 = r4.emit(r7, r0)
            if (r4 != r1) goto L_0x0271
            return r1
        L_0x0271:
            r7 = r8
        L_0x0272:
            r8 = r7
        L_0x0273:
            r0.L$0 = r8
            r0.L$1 = r6
            r0.L$2 = r3
            r0.L$3 = r2
            r4 = 0
            r0.L$4 = r4
            r0.L$5 = r4
            r4 = 5
            r0.label = r4
            java.lang.Object r4 = r8.notifyRefreshChart(r5, r0)
            if (r4 != r1) goto L_0x028a
            return r1
        L_0x028a:
            r5 = r6
            r6 = r8
        L_0x028c:
            boolean r4 = r5.getDirty()
            if (r4 != 0) goto L_0x02ad
            kotlinx.coroutines.flow.MutableStateFlow r4 = r6._proportionModel
            r0.L$0 = r6
            r0.L$1 = r3
            r0.L$2 = r2
            r7 = 0
            r0.L$3 = r7
            r7 = 6
            r0.label = r7
            java.lang.Object r4 = r4.emit(r5, r0)
            if (r4 != r1) goto L_0x02a9
            return r1
        L_0x02a9:
            r5 = r6
        L_0x02aa:
            r4 = r3
            r3 = r5
            goto L_0x02af
        L_0x02ad:
            r4 = r3
            r3 = r6
        L_0x02af:
            kotlinx.coroutines.flow.MutableStateFlow r5 = r3._recordsModel
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            com.microtech.aidexx.ui.main.history.HistoryViewModel$loadAndCalculateData$2$invokeSuspend$lambda$2$$inlined$sortedByDescending$1 r6 = new com.microtech.aidexx.ui.main.history.HistoryViewModel$loadAndCalculateData$2$invokeSuspend$lambda$2$$inlined$sortedByDescending$1
            r6.<init>()
            java.util.Comparator r6 = (java.util.Comparator) r6
            java.util.List r4 = kotlin.collections.CollectionsKt.sortedWith(r4, r6)
            r0.L$0 = r3
            r0.L$1 = r2
            r6 = 0
            r0.L$2 = r6
            r0.L$3 = r6
            r7 = 7
            r0.label = r7
            java.lang.Object r4 = r5.emit(r4, r0)
            if (r4 != r1) goto L_0x02d3
            return r1
        L_0x02d3:
            kotlinx.coroutines.flow.MutableStateFlow r3 = r3._alertModel
            T r2 = r2.element
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r2 = r2.getSecond()
            r0.L$0 = r6
            r0.L$1 = r6
            r4 = 8
            r0.label = r4
            java.lang.Object r2 = r3.emit(r2, r0)
            if (r2 != r1) goto L_0x02ee
            return r1
        L_0x02ee:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.history.HistoryViewModel$loadAndCalculateData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
