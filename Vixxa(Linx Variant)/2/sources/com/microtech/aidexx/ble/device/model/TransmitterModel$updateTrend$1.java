package com.microtech.aidexx.ble.device.model;

import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtechmd.blecomm.parser.AidexXAbstractEntity;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ble.device.model.TransmitterModel$updateTrend$1", f = "TransmitterModel.kt", i = {}, l = {784}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$updateTrend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AidexXAbstractEntity $entity;
    final /* synthetic */ Float $glucose;
    final /* synthetic */ Date $historyDate;
    final /* synthetic */ int $status;
    final /* synthetic */ int $trendValue;
    int label;
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$updateTrend$1(Date date, Float f, TransmitterModel transmitterModel, int i, AidexXAbstractEntity aidexXAbstractEntity, int i2, Continuation<? super TransmitterModel$updateTrend$1> continuation) {
        super(2, continuation);
        this.$historyDate = date;
        this.$glucose = f;
        this.this$0 = transmitterModel;
        this.$trendValue = i;
        this.$entity = aidexXAbstractEntity;
        this.$status = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransmitterModel$updateTrend$1(this.$historyDate, this.$glucose, this.this$0, this.$trendValue, this.$entity, this.$status, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransmitterModel$updateTrend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String formatWithoutZone = ExtendsKt.formatWithoutZone(this.$historyDate);
            String id = TimeZone.getDefault().getID();
            String str = TimeZone.getDefault().getDSTSavings() > 0 ? "1" : "0";
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            Float f = this.$glucose;
            map.put("bloodGlucose", Boxing.boxFloat(f != null ? f.floatValue() : 0.0f));
            map.put("appTime", formatWithoutZone);
            DeviceModel.GlucoseTrend glucoseTrend = this.this$0.getGlucoseTrend();
            map.put("trend", glucoseTrend != null ? Boxing.boxInt(glucoseTrend.getIndex()) : null);
            map.put("trendValue", Boxing.boxInt(this.$trendValue));
            map.put("appTimeZone", id);
            map.put("dstOffset", str);
            map.put("userId", UserInfoManager.Companion.instance().userId());
            map.put(NotificationCompat.CATEGORY_STATUS, Boxing.boxInt(this.$entity.status));
            map.put("calTemp", Boxing.boxInt(this.$entity.calTemp));
            map.put("historyStatus", Boxing.boxInt(this.$status));
            this.label = 1;
            if (ApiService.Companion.getInstance().postGlucoseTrend(hashMap, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
