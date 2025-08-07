package com.microtech.aidexx.views.calendar;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/microtech/aidexx/views/calendar/CalendarDataCache;", "", "()V", "dataCache", "", "", "getDataCache", "()Ljava/util/Set;", "isNeedShowDataPointInThisView", "", "()Z", "setNeedShowDataPointInThisView", "(Z)V", "clearCache", "", "loadThisMonthData", "year", "", "month", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CalendarDialog.kt */
public final class CalendarDataCache {
    public static final CalendarDataCache INSTANCE = new CalendarDataCache();
    private static final Set<String> dataCache = new LinkedHashSet();
    private static boolean isNeedShowDataPointInThisView;

    private CalendarDataCache() {
    }

    public final boolean isNeedShowDataPointInThisView() {
        return isNeedShowDataPointInThisView;
    }

    public final void setNeedShowDataPointInThisView(boolean z) {
        isNeedShowDataPointInThisView = z;
    }

    public final Set<String> getDataCache() {
        return dataCache;
    }

    public final void clearCache() {
        dataCache.clear();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0169 A[SYNTHETIC] */
    public final java.lang.Object loadThisMonthData(int r19, int r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r18 = this;
            r0 = r21
            boolean r1 = r0 instanceof com.microtech.aidexx.views.calendar.CalendarDataCache$loadThisMonthData$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.microtech.aidexx.views.calendar.CalendarDataCache$loadThisMonthData$1 r1 = (com.microtech.aidexx.views.calendar.CalendarDataCache$loadThisMonthData$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r18
            goto L_0x001f
        L_0x0018:
            com.microtech.aidexx.views.calendar.CalendarDataCache$loadThisMonthData$1 r1 = new com.microtech.aidexx.views.calendar.CalendarDataCache$loadThisMonthData$1
            r2 = r18
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 31
            r6 = 1
            if (r4 == 0) goto L_0x004b
            if (r4 != r6) goto L_0x0043
            int r4 = r1.I$1
            int r7 = r1.I$0
            java.lang.Object r8 = r1.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r1.L$1
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r1.L$0
            java.util.List r10 = (java.util.List) r10
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0154
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = 7
            java.lang.Integer[] r4 = new java.lang.Integer[r0]
            r7 = 0
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r4[r7] = r8
            r7 = 3
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            r4[r6] = r8
            r8 = 2
            r9 = 5
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r4[r8] = r10
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r4[r7] = r0
            r0 = 8
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r7 = 4
            r4[r7] = r0
            r0 = 10
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r4[r9] = r0
            r0 = 12
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r7 = 6
            r4[r7] = r0
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r4)
            kotlin.ranges.IntRange r4 = new kotlin.ranges.IntRange
            r4.<init>(r6, r5)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r10 = r0
            r9 = r4
            r0 = r19
            r4 = r1
            r1 = r20
        L_0x009d:
            boolean r7 = r9.hasNext()
            if (r7 == 0) goto L_0x0169
            r7 = r9
            kotlin.collections.IntIterator r7 = (kotlin.collections.IntIterator) r7
            int r7 = r7.nextInt()
            r8 = 30
            if (r7 <= r8) goto L_0x00bd
            if (r7 != r5) goto L_0x00bb
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            boolean r8 = r10.contains(r8)
            if (r8 == 0) goto L_0x00bb
            goto L_0x00bd
        L_0x00bb:
            r8 = 0
            goto L_0x00ca
        L_0x00bd:
            java.util.Calendar r8 = java.util.Calendar.getInstance()
            int r11 = r1 + -1
            r8.set(r0, r11, r7)
            java.util.Date r8 = r8.getTime()
        L_0x00ca:
            if (r8 == 0) goto L_0x009d
            long r11 = r8.getTime()
            long r13 = java.lang.System.currentTimeMillis()
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x00d9
            goto L_0x009d
        L_0x00d9:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r11 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            java.lang.String r11 = r11.getCurShowUserId()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.StringBuilder r12 = r12.append(r11)
            r13 = 45
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.StringBuilder r12 = r12.append(r0)
            kotlin.jvm.internal.StringCompanionObject r13 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.Object[] r13 = new java.lang.Object[]{r13}
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r6)
            java.lang.String r14 = "%02d"
            java.lang.String r13 = java.lang.String.format(r14, r13)
            java.lang.String r15 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r15)
            java.lang.StringBuilder r12 = r12.append(r13)
            kotlin.jvm.internal.StringCompanionObject r13 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r6)
            java.lang.String r7 = java.lang.String.format(r14, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r15)
            java.lang.StringBuilder r7 = r12.append(r7)
            java.lang.String r7 = r7.toString()
            java.util.Set<java.lang.String> r12 = dataCache
            boolean r12 = r12.contains(r7)
            if (r12 != 0) goto L_0x009d
            com.microtech.aidexx.db.repository.CgmCalibBgRepository r12 = com.microtech.aidexx.db.repository.CgmCalibBgRepository.INSTANCE
            r4.L$0 = r10
            r4.L$1 = r9
            r4.L$2 = r7
            r4.I$0 = r0
            r4.I$1 = r1
            r4.label = r6
            java.lang.Object r8 = r12.checkHasData(r8, r11, r4)
            if (r8 != r3) goto L_0x0149
            return r3
        L_0x0149:
            r16 = r7
            r7 = r0
            r0 = r8
            r8 = r16
            r17 = r4
            r4 = r1
            r1 = r17
        L_0x0154:
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r0 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r0
            if (r0 == 0) goto L_0x0161
            java.util.Set<java.lang.String> r0 = dataCache
            boolean r0 = r0.add(r8)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
        L_0x0161:
            r0 = r7
            r16 = r4
            r4 = r1
            r1 = r16
            goto L_0x009d
        L_0x0169:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.views.calendar.CalendarDataCache.loadThisMonthData(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
