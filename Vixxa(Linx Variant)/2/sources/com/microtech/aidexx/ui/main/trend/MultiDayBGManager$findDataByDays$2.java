package com.microtech.aidexx.ui.main.trend;

import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/ui/main/trend/DataInfoForTrends;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.MultiDayBGManager$findDataByDays$2", f = "MultiDayBgManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {89}, m = "invokeSuspend", n = {"dayIndex", "arrayIndex", "glucoseArray", "start", "end", "dayCount", "historyCount", "totalHistory"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"})
/* compiled from: MultiDayBgManager.kt */
final class MultiDayBGManager$findDataByDays$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DataInfoForTrends>, Object> {
    final /* synthetic */ Date $endDate;
    final /* synthetic */ Date $startDate;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ MultiDayBGManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiDayBGManager$findDataByDays$2(MultiDayBGManager multiDayBGManager, Date date, Date date2, Continuation<? super MultiDayBGManager$findDataByDays$2> continuation) {
        super(2, continuation);
        this.this$0 = multiDayBGManager;
        this.$endDate = date;
        this.$startDate = date2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiDayBGManager$findDataByDays$2(this.this$0, this.$endDate, this.$startDate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DataInfoForTrends> continuation) {
        return ((MultiDayBGManager$findDataByDays$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0214  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            r24 = this;
            r0 = r24
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 288(0x120, float:4.04E-43)
            r5 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r5) goto L_0x0030
            int r2 = r0.I$2
            int r6 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$4
            java.util.Calendar r8 = (java.util.Calendar) r8
            java.lang.Object r9 = r0.L$3
            java.util.Calendar r9 = (java.util.Calendar) r9
            java.lang.Object r10 = r0.L$2
            double[][] r10 = (double[][]) r10
            java.lang.Object r11 = r0.L$1
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r12 = (kotlin.jvm.internal.Ref.IntRef) r12
            kotlin.ResultKt.throwOnFailure(r25)
            r13 = r25
            goto L_0x00b4
        L_0x0030:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r25)
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager r2 = r0.this$0
            java.util.List r2 = r2.getMutableListOf()
            r2.clear()
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef
            r6.<init>()
            java.util.Date r7 = r0.$endDate
            long r7 = r7.getTime()
            java.util.Date r9 = r0.$startDate
            long r9 = r9.getTime()
            long r7 = r7 - r9
            int r7 = com.microtech.aidexx.common.ExtendsKt.millisToDays(r7)
            double[][] r8 = new double[r7][]
            r9 = 0
        L_0x0062:
            if (r9 >= r7) goto L_0x006b
            double[] r10 = new double[r3]
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x0062
        L_0x006b:
            java.util.Date r9 = r0.$startDate
            java.util.Calendar r9 = com.microtech.aidexx.common.ExtendsKt.getStart(r9)
            java.util.Date r10 = r0.$endDate
            java.util.Calendar r10 = com.microtech.aidexx.common.ExtendsKt.getStart(r10)
            r12 = r2
            r11 = r6
            r2 = 0
            r6 = 0
            r22 = r10
            r10 = r8
            r8 = r22
        L_0x0080:
            boolean r13 = r8.after(r9)
            if (r13 == 0) goto L_0x0214
            int r13 = r12.element
            if (r13 >= r7) goto L_0x0214
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r13 = (kotlin.coroutines.CoroutineContext) r13
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager$findDataByDays$2$tempList$1 r14 = new com.microtech.aidexx.ui.main.trend.MultiDayBGManager$findDataByDays$2$tempList$1
            r15 = 0
            r14.<init>(r9, r15)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r15 = r0
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r10
            r0.L$3 = r9
            r0.L$4 = r8
            r0.I$0 = r7
            r0.I$1 = r6
            r0.I$2 = r2
            r0.label = r5
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r13, r14, r15)
            if (r13 != r1) goto L_0x00b4
            return r1
        L_0x00b4:
            java.util.List r13 = (java.util.List) r13
            if (r13 != 0) goto L_0x00bc
            java.util.List r13 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00bc:
            r14 = r13
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager$findDataByDays$2$invokeSuspend$$inlined$sortedBy$1 r15 = new com.microtech.aidexx.ui.main.trend.MultiDayBGManager$findDataByDays$2$invokeSuspend$$inlined$sortedBy$1
            r15.<init>()
            java.util.Comparator r15 = (java.util.Comparator) r15
            kotlin.collections.CollectionsKt.sortedWith(r14, r15)
            int r14 = r13.size()
            int r2 = r2 + r14
            java.util.LinkedHashMap r14 = new java.util.LinkedHashMap
            r14.<init>()
            java.util.Map r14 = (java.util.Map) r14
            java.util.Iterator r13 = r13.iterator()
            r15 = 0
        L_0x00db:
            boolean r17 = r13.hasNext()
            if (r17 == 0) goto L_0x0191
            java.lang.Object r17 = r13.next()
            r4 = r17
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r4 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r4
            java.lang.String r3 = r4.getSensorId()
            if (r3 == 0) goto L_0x0116
            java.util.Set r5 = r14.keySet()
            boolean r5 = r5.contains(r3)
            if (r5 == 0) goto L_0x0109
            java.lang.Object r3 = r14.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0116
            boolean r3 = r3.add(r4)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            goto L_0x0116
        L_0x0109:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            r5.add(r4)
            r14.put(r3, r5)
        L_0x0116:
            long r18 = r4.getTimestamp()
            long r18 = r18 - r15
            r3 = 5
            long r20 = com.microtech.aidexx.common.ExtendsKt.minutesToMillis(r3)
            int r3 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r3 >= 0) goto L_0x0129
            r3 = 288(0x120, float:4.04E-43)
            r5 = 1
            goto L_0x00db
        L_0x0129:
            java.lang.Float r3 = r4.getGlucose()
            if (r3 == 0) goto L_0x017a
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            int r5 = r11.element
            r15 = 288(0x120, float:4.04E-43)
            if (r5 >= r15) goto L_0x017a
            r5 = 1099956224(0x41900000, float:18.0)
            float r3 = r3 / r5
            r5 = 1103626240(0x41c80000, float:25.0)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0153
            int r3 = r12.element
            r3 = r10[r3]
            int r5 = r11.element
            int r15 = r5 + 1
            r11.element = r15
            r15 = 4627730092099895296(0x4039000000000000, double:25.0)
            r3[r5] = r15
            goto L_0x017a
        L_0x0153:
            r5 = 1073741824(0x40000000, float:2.0)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0168
            int r3 = r12.element
            r3 = r10[r3]
            int r5 = r11.element
            int r15 = r5 + 1
            r11.element = r15
            r15 = 4611686018427387904(0x4000000000000000, double:2.0)
            r3[r5] = r15
            goto L_0x017a
        L_0x0168:
            int r5 = r12.element
            r5 = r10[r5]
            int r15 = r11.element
            r16 = r1
            int r1 = r15 + 1
            r11.element = r1
            r18 = r2
            double r1 = (double) r3
            r5[r15] = r1
            goto L_0x017e
        L_0x017a:
            r16 = r1
            r18 = r2
        L_0x017e:
            int r6 = r6 + 1
            long r1 = r4.getTimestamp()
            r3 = 288(0x120, float:4.04E-43)
            r5 = 1
            r22 = r1
            r1 = r16
            r15 = r22
            r2 = r18
            goto L_0x00db
        L_0x0191:
            r16 = r1
            r18 = r2
            com.microtech.aidexx.ui.main.trend.MultiDayBgItem r1 = new com.microtech.aidexx.ui.main.trend.MultiDayBgItem
            java.util.Date r2 = r9.getTime()
            java.lang.String r3 = "getTime(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager r3 = r0.this$0
            java.util.List r3 = r3.getMutableListOf()
            int r3 = r3.size()
            r4 = 32
            if (r3 >= r4) goto L_0x01c3
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager r3 = r0.this$0
            java.util.List r3 = r3.colorSet
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager r4 = r0.this$0
            java.util.List r4 = r4.getMutableListOf()
            int r4 = r4.size()
            java.lang.Object r3 = r3.get(r4)
            goto L_0x01d8
        L_0x01c3:
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager r3 = r0.this$0
            java.util.List r3 = r3.colorSet
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager r5 = r0.this$0
            java.util.List r5 = r5.getMutableListOf()
            int r5 = r5.size()
            int r5 = r5 % r4
            java.lang.Object r3 = r3.get(r5)
        L_0x01d8:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = android.graphics.Color.parseColor(r3)
            r4 = 0
            r1.<init>(r2, r4, r14, r3)
            java.util.Collection r2 = r14.values()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager$findDataByDays$2$invokeSuspend$$inlined$compareBy$1 r3 = new com.microtech.aidexx.ui.main.trend.MultiDayBGManager$findDataByDays$2$invokeSuspend$$inlined$compareBy$1
            r3.<init>()
            java.util.Comparator r3 = (java.util.Comparator) r3
            java.lang.Object r2 = kotlin.collections.CollectionsKt.maxWithOrNull(r2, r3)
            java.util.List r2 = (java.util.List) r2
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager r2 = r0.this$0
            java.util.List r2 = r2.getMutableListOf()
            r2.add(r1)
            r1 = 5
            r3 = 1
            r9.add(r1, r3)
            int r1 = r12.element
            int r1 = r1 + r3
            r12.element = r1
            r1 = 0
            r11.element = r1
            r5 = r3
            r1 = r16
            r2 = r18
            r3 = 288(0x120, float:4.04E-43)
            goto L_0x0080
        L_0x0214:
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager r1 = r0.this$0
            java.util.List r1 = r1.getMutableListOf()
            kotlin.collections.CollectionsKt.reverse(r1)
            com.microtech.aidexx.ui.main.trend.DataInfoForTrends r1 = new com.microtech.aidexx.ui.main.trend.DataInfoForTrends
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager r3 = r0.this$0
            java.util.List r3 = r3.getMutableListOf()
            r1.<init>(r3, r10, r6, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.MultiDayBGManager$findDataByDays$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
