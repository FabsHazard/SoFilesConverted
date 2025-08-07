package com.microtech.aidexx.ui.setting.timezonehistory;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.TimezoneHistoryEntity;
import io.objectbox.Box;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$createTimezoneHistory$1", f = "TimezoneHistoryManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TimezoneHistoryManager.kt */
final class TimezoneHistoryManager$createTimezoneHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $from;
    final /* synthetic */ boolean $isDstChange;
    final /* synthetic */ String $to;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimezoneHistoryManager$createTimezoneHistory$1(String str, String str2, boolean z, Continuation<? super TimezoneHistoryManager$createTimezoneHistory$1> continuation) {
        super(2, continuation);
        this.$from = str;
        this.$to = str2;
        this.$isDstChange = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TimezoneHistoryManager$createTimezoneHistory$1(this.$from, this.$to, this.$isDstChange, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TimezoneHistoryManager$createTimezoneHistory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0040, code lost:
        r0 = r0.getEntity();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.label
            if (r0 != 0) goto L_0x009d
            kotlin.ResultKt.throwOnFailure(r5)
            com.microtech.aidexx.db.entity.TimezoneHistoryEntity r5 = new com.microtech.aidexx.db.entity.TimezoneHistoryEntity
            r5.<init>()
            java.lang.String r0 = r4.$from
            r5.setFrom(r0)
            java.lang.String r0 = r4.$to
            r5.setTo(r0)
            boolean r0 = r4.$isDstChange
            r5.setDstChange(r0)
            com.microtech.aidexx.utils.TimeUtils r0 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r0 = r0.getCurrentTimeMillis()
            r5.setTimestamp(r0)
            com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r0 = r0.instance()
            java.lang.String r0 = r0.userId()
            r5.setUserId(r0)
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r0 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r0 = r0.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r0 = r0.getDefault()
            if (r0 == 0) goto L_0x004b
            com.microtech.aidexx.db.entity.TransmitterEntity r0 = r0.getEntity()
            if (r0 == 0) goto L_0x004b
            java.lang.String r0 = r0.getSensorId()
            goto L_0x004c
        L_0x004b:
            r0 = 0
        L_0x004c:
            r5.setSensorId(r0)
            com.microtech.aidexx.utils.EncryptUtils$Companion r0 = com.microtech.aidexx.utils.EncryptUtils.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r5.getSensorId()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r5.getFrom()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r5.getTo()
            java.lang.StringBuilder r1 = r1.append(r2)
            long r2 = r5.getTimestamp()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.md5(r1)
            r5.setFrontRecordId(r0)
            r0 = 1
            r5.setUploadState(r0)
            com.microtech.aidexx.db.ObjectBox r0 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$createTimezoneHistory$1$$ExternalSyntheticLambda0 r1 = new com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$createTimezoneHistory$1$$ExternalSyntheticLambda0
            r1.<init>(r5)
            com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$createTimezoneHistory$1$2 r2 = new com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$createTimezoneHistory$1$2
            r2.<init>(r5)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$createTimezoneHistory$1$3 r5 = com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$createTimezoneHistory$1.AnonymousClass3.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r0.runAsync(r1, r2, r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x009d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$createTimezoneHistory$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(TimezoneHistoryEntity timezoneHistoryEntity) {
        Box<TimezoneHistoryEntity> timeZoneHistoryBox = ObjectBox.INSTANCE.getTimeZoneHistoryBox();
        Intrinsics.checkNotNull(timeZoneHistoryBox);
        timeZoneHistoryBox.put(timezoneHistoryEntity);
    }
}
