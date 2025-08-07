package com.microtech.aidexx.service;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/microtech/aidexx/service/DataService$scheduleTask$1", "Ljava/util/TimerTask;", "run", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DataService.kt */
public final class DataService$scheduleTask$1 extends TimerTask {
    final /* synthetic */ Ref.IntRef $count;
    final /* synthetic */ DataService this$0;

    DataService$scheduleTask$1(Ref.IntRef intRef, DataService dataService) {
        this.$count = intRef;
        this.this$0 = dataService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        r1 = r0.getEntity();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r0 = r0.instance()
            boolean r0 = r0.isLogin()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            kotlin.jvm.internal.Ref$IntRef r0 = r9.$count
            int r0 = r0.element
            r1 = 18
            r2 = 0
            if (r0 != r1) goto L_0x001a
            kotlin.jvm.internal.Ref$IntRef r0 = r9.$count
            r0.element = r2
        L_0x001a:
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r0 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r0 = r0.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r0 = r0.getDefault()
            if (r0 == 0) goto L_0x0030
            boolean r1 = r0.isGettingTransmitterData()
            if (r1 == 0) goto L_0x0030
            r0.setGettingTransmitterData(r2)
            return
        L_0x0030:
            kotlin.jvm.internal.Ref$IntRef r1 = r9.$count
            int r1 = r1.element
            int r1 = r1 % 3
            r2 = 0
            if (r1 != 0) goto L_0x007e
            com.microtech.aidexx.service.DataService r1 = r9.this$0
            kotlinx.coroutines.CoroutineScope r3 = r1.serviceMainScope
            if (r3 == 0) goto L_0x0050
            com.microtech.aidexx.service.DataService$scheduleTask$1$run$1 r1 = new com.microtech.aidexx.service.DataService$scheduleTask$1$run$1
            r1.<init>(r2)
            r6 = r1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 3
            r8 = 0
            r4 = 0
            r5 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
        L_0x0050:
            com.microtech.aidexx.service.DataService r1 = r9.this$0
            kotlinx.coroutines.CoroutineScope r3 = r1.serviceMainScope
            if (r3 == 0) goto L_0x0067
            com.microtech.aidexx.service.DataService$scheduleTask$1$run$2 r1 = new com.microtech.aidexx.service.DataService$scheduleTask$1$run$2
            r1.<init>(r2)
            r6 = r1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 3
            r8 = 0
            r4 = 0
            r5 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
        L_0x0067:
            com.microtech.aidexx.service.DataService r1 = r9.this$0
            kotlinx.coroutines.CoroutineScope r3 = r1.serviceMainScope
            if (r3 == 0) goto L_0x007e
            com.microtech.aidexx.service.DataService$scheduleTask$1$run$3 r1 = new com.microtech.aidexx.service.DataService$scheduleTask$1$run$3
            r1.<init>(r2)
            r6 = r1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 3
            r8 = 0
            r4 = 0
            r5 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
        L_0x007e:
            kotlin.jvm.internal.Ref$IntRef r1 = r9.$count
            int r1 = r1.element
            int r1 = r1 % 6
            if (r1 != 0) goto L_0x00b5
            if (r0 == 0) goto L_0x0093
            com.microtech.aidexx.db.entity.TransmitterEntity r1 = r0.getEntity()
            if (r1 == 0) goto L_0x0093
            java.util.Date r1 = r1.getSensorStartTime()
            goto L_0x0094
        L_0x0093:
            r1 = r2
        L_0x0094:
            if (r1 == 0) goto L_0x00b5
            com.microtech.aidexx.db.entity.TransmitterEntity r1 = r0.getEntity()
            java.lang.String r1 = r1.getId()
            if (r1 != 0) goto L_0x00b5
            com.microtech.aidexx.AidexxApp$Companion r1 = com.microtech.aidexx.AidexxApp.Companion
            kotlinx.coroutines.CoroutineScope r3 = r1.getMainScope()
            com.microtech.aidexx.service.DataService$scheduleTask$1$run$4 r1 = new com.microtech.aidexx.service.DataService$scheduleTask$1$run$4
            r1.<init>(r0, r2)
            r6 = r1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 3
            r8 = 0
            r4 = 0
            r5 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
        L_0x00b5:
            kotlin.jvm.internal.Ref$IntRef r0 = r9.$count
            int r0 = r0.element
            kotlin.jvm.internal.Ref$IntRef r1 = r9.$count
            int r0 = r0 + 1
            r1.element = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.service.DataService$scheduleTask$1.run():void");
    }
}
