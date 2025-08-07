package com.microtech.aidexx.data;

import com.microtech.aidexx.common.net.entity.BaseResponse;
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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync$upload$2$1", f = "CloudHistorySync.kt", i = {}, l = {55, 57}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$upload$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<T> $needUploadData;
    int label;
    final /* synthetic */ CloudHistorySync<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$upload$2$1(CloudHistorySync<T> cloudHistorySync, List<T> list, Continuation<? super CloudHistorySync$upload$2$1> continuation) {
        super(2, continuation);
        this.this$0 = cloudHistorySync;
        this.$needUploadData = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudHistorySync$upload$2$1(this.this$0, this.$needUploadData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudHistorySync$upload$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CloudHistorySync<T> cloudHistorySync = this.this$0;
            Pair[] pairArr = {TuplesKt.to("records", this.$needUploadData)};
            this.label = 1;
            obj = cloudHistorySync.postLocalData(MapsKt.hashMapOf(pairArr), this);
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
        this.label = 2;
        if (CloudHistorySync.replaceEventData$default(this.this$0, this.$needUploadData, (List) baseResponse.getData(), 0, (String) null, this, 12, (Object) null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
