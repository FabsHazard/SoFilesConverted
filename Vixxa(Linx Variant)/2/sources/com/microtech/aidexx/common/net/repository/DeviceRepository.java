package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.ble.device.entity.CloudDeviceInfo;
import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.DeviceHeartBeat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\n\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/common/net/repository/DeviceRepository;", "", "()V", "deviceHeartBeat", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "Lcom/microtech/aidexx/common/net/entity/DeviceHeartBeat;", "(Lcom/microtech/aidexx/common/net/entity/DeviceHeartBeat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceHeartBeat", "sensorId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceInfo", "Lcom/microtech/aidexx/ble/device/entity/CloudDeviceInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceRepository.kt */
public final class DeviceRepository {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<DeviceRepository> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DeviceRepository$Companion$instance$2.INSTANCE);

    public /* synthetic */ DeviceRepository(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeviceRepository() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/common/net/repository/DeviceRepository$Companion;", "", "()V", "instance", "Lcom/microtech/aidexx/common/net/repository/DeviceRepository;", "getInstance", "()Lcom/microtech/aidexx/common/net/repository/DeviceRepository;", "instance$delegate", "Lkotlin/Lazy;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceRepository getInstance() {
            return (DeviceRepository) DeviceRepository.instance$delegate.getValue();
        }
    }

    public final Object deviceHeartBeat(DeviceHeartBeat deviceHeartBeat, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return ApiService.Companion.getInstance().deviceHeartBeat(deviceHeartBeat, continuation);
    }

    public final Object getDeviceHeartBeat(String str, Continuation<? super ApiResult<BaseResponse<DeviceHeartBeat>>> continuation) {
        return ApiService.Companion.getInstance().getDeviceHeartBeat(str, continuation);
    }

    public final Object getDeviceInfo(Continuation<? super ApiResult<BaseResponse<CloudDeviceInfo>>> continuation) {
        return ApiService.Companion.getInstance().getDevice(continuation);
    }
}
