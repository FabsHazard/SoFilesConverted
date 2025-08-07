package com.microtech.aidexx.ota;

import androidx.lifecycle.LifecycleOwner;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "value", "Landroidx/work/WorkInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaManager.kt */
final class OtaManager$enqueueWork$1 extends Lambda implements Function1<WorkInfo, Unit> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ OneTimeWorkRequest $worker_first;
    final /* synthetic */ OneTimeWorkRequest $worker_second;
    final /* synthetic */ OtaManager this$0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: OtaManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.work.WorkInfo$State[] r0 = androidx.work.WorkInfo.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.RUNNING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.FAILED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaManager$enqueueWork$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtaManager$enqueueWork$1(OneTimeWorkRequest oneTimeWorkRequest, OtaManager otaManager, LifecycleOwner lifecycleOwner, OneTimeWorkRequest oneTimeWorkRequest2) {
        super(1);
        this.$worker_second = oneTimeWorkRequest;
        this.this$0 = otaManager;
        this.$lifecycleOwner = lifecycleOwner;
        this.$worker_first = oneTimeWorkRequest2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WorkInfo) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c0, code lost:
        if (r0.enqueue() == null) goto L_0x00c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.work.WorkInfo r15) {
        /*
            r14 = this;
            if (r15 == 0) goto L_0x0129
            androidx.work.OneTimeWorkRequest r0 = r14.$worker_second
            com.microtech.aidexx.ota.OtaManager r1 = r14.this$0
            androidx.lifecycle.LifecycleOwner r2 = r14.$lifecycleOwner
            androidx.work.OneTimeWorkRequest r3 = r14.$worker_first
            androidx.work.WorkInfo$State r4 = r15.getState()
            int[] r5 = com.microtech.aidexx.ota.OtaManager$enqueueWork$1.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r5[r4]
            r5 = 0
            r6 = 1
            r7 = 0
            if (r4 == r6) goto L_0x00d9
            r15 = 100
            r8 = 2
            if (r4 == r8) goto L_0x007e
            r0 = 3
            if (r4 == r0) goto L_0x0027
        L_0x0023:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            goto L_0x0129
        L_0x0027:
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "OTA ----> work_first FAILED retryTimes="
            r4.<init>(r6)
            int r6 = r1.retryTimes
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            r0.eAiDEX(r4)
            int r0 = r1.retryTimes
            if (r0 <= 0) goto L_0x006b
            int r15 = r1.retryTimes
            int r15 = r15 + -1
            r1.retryTimes = r15
            androidx.lifecycle.LifecycleCoroutineScope r15 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r2)
            r8 = r15
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            kotlinx.coroutines.CoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.getIO()
            r9 = r15
            kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
            com.microtech.aidexx.ota.OtaManager$enqueueWork$1$1$5 r15 = new com.microtech.aidexx.ota.OtaManager$enqueueWork$1$1$5
            r15.<init>(r3, r7)
            r11 = r15
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 2
            r13 = 0
            r10 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)
            goto L_0x0023
        L_0x006b:
            com.microtech.aidexx.ota.OtaProgressListener r0 = r1.otaProgressListener
            if (r0 == 0) goto L_0x0074
            com.microtech.aidexx.ota.OtaProgressListener.DefaultImpls.onProgress$default(r0, r15, r7, r8, r7)
        L_0x0074:
            com.microtech.aidexx.ota.OtaProgressListener r15 = r1.otaProgressListener
            if (r15 == 0) goto L_0x0023
            r15.onFinish(r5)
            goto L_0x0023
        L_0x007e:
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "OTA ----> work_first SUCCEEDED retryTimes="
            r3.<init>(r4)
            int r4 = r1.retryTimes
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.eAiDEX(r3)
            if (r0 == 0) goto L_0x00c2
            com.microtech.aidexx.ota.OtaProgressListener r2 = r1.otaProgressListener
            if (r2 == 0) goto L_0x00a3
            r3 = 50
            com.microtech.aidexx.ota.OtaProgressListener.DefaultImpls.onProgress$default(r2, r3, r7, r8, r7)
        L_0x00a3:
            com.microtech.aidexx.AidexxApp$Companion r2 = com.microtech.aidexx.AidexxApp.Companion
            com.microtech.aidexx.AidexxApp r2 = r2.getInstance()
            android.content.Context r2 = (android.content.Context) r2
            androidx.work.WorkManager r2 = androidx.work.WorkManager.getInstance(r2)
            java.lang.String r3 = "OtaWorker"
            androidx.work.ExistingWorkPolicy r4 = androidx.work.ExistingWorkPolicy.REPLACE
            androidx.work.WorkContinuation r0 = r2.beginUniqueWork((java.lang.String) r3, (androidx.work.ExistingWorkPolicy) r4, (androidx.work.OneTimeWorkRequest) r0)
            java.lang.String r2 = "beginUniqueWork(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            androidx.work.Operation r0 = r0.enqueue()
            if (r0 != 0) goto L_0x00d6
        L_0x00c2:
            com.microtech.aidexx.ota.OtaProgressListener r0 = r1.otaProgressListener
            if (r0 == 0) goto L_0x00cb
            com.microtech.aidexx.ota.OtaProgressListener.DefaultImpls.onProgress$default(r0, r15, r7, r8, r7)
        L_0x00cb:
            com.microtech.aidexx.ota.OtaProgressListener r15 = r1.otaProgressListener
            if (r15 == 0) goto L_0x00d6
            r15.onFinish(r6)
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
        L_0x00d6:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            goto L_0x0129
        L_0x00d9:
            androidx.work.Data r2 = r15.getProgress()
            java.lang.String r3 = "progress"
            int r2 = r2.getInt(r3, r5)
            androidx.work.Data r15 = r15.getProgress()
            java.lang.String r3 = "bitrate"
            r4 = 0
            float r15 = r15.getFloat(r3, r4)
            com.microtech.aidexx.utils.LogUtil$Companion r3 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "OTA ----> work_first:"
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.eAiDEX(r4)
            if (r0 == 0) goto L_0x011a
            com.microtech.aidexx.ota.OtaProgressListener r0 = r1.otaProgressListener
            if (r0 == 0) goto L_0x0118
            float r3 = (float) r2
            r4 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 / r4
            int r3 = (int) r3
            java.lang.Float r4 = java.lang.Float.valueOf(r15)
            r0.onProgress(r3, r4)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L_0x0118:
            if (r7 != 0) goto L_0x0129
        L_0x011a:
            com.microtech.aidexx.ota.OtaProgressListener r0 = r1.otaProgressListener
            if (r0 == 0) goto L_0x0129
            java.lang.Float r15 = java.lang.Float.valueOf(r15)
            r0.onProgress(r2, r15)
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaManager$enqueueWork$1.invoke(androidx.work.WorkInfo):void");
    }
}
