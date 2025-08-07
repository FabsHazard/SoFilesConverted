package com.microtech.aidexx.ble.device;

import com.microtech.aidexx.ble.device.entity.CloudDeviceInfo;
import com.microtech.aidexx.ble.device.model.DeviceModelKt;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.HistoryDeviceInfo;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import io.objectbox.Box;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "response", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "Lcom/microtech/aidexx/ble/device/entity/CloudDeviceInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterManager.kt */
final class TransmitterManager$loadTransmitter$2 extends Lambda implements Function1<BaseResponse<CloudDeviceInfo>, Unit> {
    final /* synthetic */ TransmitterManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterManager$loadTransmitter$2(TransmitterManager transmitterManager) {
        super(1);
        this.this$0 = transmitterManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BaseResponse<CloudDeviceInfo>) (BaseResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BaseResponse<CloudDeviceInfo> baseResponse) {
        Intrinsics.checkNotNullParameter(baseResponse, "response");
        CloudDeviceInfo data = baseResponse.getData();
        if (data != null) {
            TransmitterManager transmitterManager = this.this$0;
            HistoryDeviceInfo deviceInfo = data.getDeviceInfo();
            if (deviceInfo != null) {
                TransmitterEntity transmitterEntity = new TransmitterEntity();
                transmitterEntity.setIdx(1L);
                transmitterEntity.setId(deviceInfo.getDeviceId());
                transmitterEntity.setDeviceModel(deviceInfo.getDeviceModel());
                transmitterEntity.setDeviceSn(deviceInfo.getDeviceSn());
                transmitterEntity.setDeviceMac(deviceInfo.getDeviceMac());
                transmitterEntity.setDeviceKey(deviceInfo.getDeviceKey());
                transmitterEntity.setEt(deviceInfo.getEt());
                transmitterEntity.setDeviceType(2);
                String name = deviceInfo.getName();
                if (name == null) {
                    name = DeviceModelKt.NAME_LINX;
                }
                transmitterEntity.setDeviceName(name);
                ObjectBox.runAsync$default(ObjectBox.INSTANCE, new TransmitterManager$loadTransmitter$2$$ExternalSyntheticLambda0(transmitterEntity), new TransmitterManager$loadTransmitter$2$1$1$2(transmitterEntity, transmitterManager), (Function1) null, 4, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1$lambda$0(TransmitterEntity transmitterEntity) {
        Intrinsics.checkNotNullParameter(transmitterEntity, "$newEntity");
        Box<TransmitterEntity> transmitterBox = ObjectBox.INSTANCE.getTransmitterBox();
        Intrinsics.checkNotNull(transmitterBox);
        transmitterBox.put(transmitterEntity);
    }
}
