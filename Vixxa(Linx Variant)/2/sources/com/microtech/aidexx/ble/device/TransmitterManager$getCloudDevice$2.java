package com.microtech.aidexx.ble.device;

import com.microtech.aidexx.ble.device.entity.CloudDeviceInfo;
import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ble.device.TransmitterManager$getCloudDevice$2", f = "TransmitterManager.kt", i = {}, l = {102, 105, 112}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransmitterManager.kt */
final class TransmitterManager$getCloudDevice$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<BaseResponse<CloudDeviceInfo>, Unit> $success;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterManager$getCloudDevice$2(Function1<? super BaseResponse<CloudDeviceInfo>, Unit> function1, Continuation<? super TransmitterManager$getCloudDevice$2> continuation) {
        super(2, continuation);
        this.$success = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransmitterManager$getCloudDevice$2(this.$success, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransmitterManager$getCloudDevice$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ApiService.Companion.getInstance().getDevice(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return (Unit) obj;
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ApiResult apiResult = (ApiResult) obj;
        if (apiResult instanceof ApiResult.Success) {
            Object result = ((ApiResult.Success) apiResult).getResult();
            this.label = 2;
            obj = BuildersKt.withContext(Dispatchers.getMain(), new TransmitterManager$getCloudDevice$2$1$1(this.$success, (BaseResponse) result, (Continuation<? super TransmitterManager$getCloudDevice$2$1$1>) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (Unit) obj;
        } else if (apiResult instanceof ApiResult.Failure) {
            this.label = 3;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2((Continuation<? super AnonymousClass2>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ble.device.TransmitterManager$getCloudDevice$2$2", f = "TransmitterManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ble.device.TransmitterManager$getCloudDevice$2$2  reason: invalid class name */
    /* compiled from: TransmitterManager.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(apiResult, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LogUtil.Companion.eAiDEX("get device fail --> " + ((ApiResult.Failure) apiResult).getMsg());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
