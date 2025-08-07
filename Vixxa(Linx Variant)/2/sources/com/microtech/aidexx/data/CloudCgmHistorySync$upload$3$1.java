package com.microtech.aidexx.data;

import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudCgmHistorySync$upload$3$1", f = "CloudCgmHistorySync.kt", i = {}, l = {124, 127}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CloudCgmHistorySync.kt */
final class CloudCgmHistorySync$upload$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RealCgmHistoryEntity> $list;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudCgmHistorySync$upload$3$1(List<RealCgmHistoryEntity> list, Continuation<? super CloudCgmHistorySync$upload$3$1> continuation) {
        super(2, continuation);
        this.$list = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudCgmHistorySync$upload$3$1(this.$list, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudCgmHistorySync$upload$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CloudCgmHistorySync cloudCgmHistorySync = CloudCgmHistorySync.INSTANCE;
            Pair[] pairArr = {TuplesKt.to("records", this.$list)};
            this.label = 1;
            obj = cloudCgmHistorySync.updateHistory(MapsKt.hashMapOf(pairArr), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BaseResponse baseResponse = (BaseResponse) obj;
        if (baseResponse == null) {
            return null;
        }
        List<RealCgmHistoryEntity> list = this.$list;
        List list2 = (List) baseResponse.getData();
        if (list2 == null) {
            return null;
        }
        this.label = 2;
        if (CloudHistorySync.replaceEventData$default(CloudCgmHistorySync.INSTANCE, list, list2, 2, (String) null, this, 8, (Object) null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
