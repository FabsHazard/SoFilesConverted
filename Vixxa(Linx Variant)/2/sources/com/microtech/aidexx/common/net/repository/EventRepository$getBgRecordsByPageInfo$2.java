package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.ReqGetEventByPage;
import com.microtech.aidexx.common.net.entity.RequestEntityKt;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001*\u00020\u0005H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.EventRepository$getBgRecordsByPageInfo$2", f = "EventRepository.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EventRepository.kt */
final class EventRepository$getBgRecordsByPageInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends BaseResponse<List<? extends BloodGlucoseEntity>>>>, Object> {
    final /* synthetic */ Long $endAutoIncrementColumn;
    final /* synthetic */ int $pageNum;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ Long $startAutoIncrementColumn;
    final /* synthetic */ String $userId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventRepository$getBgRecordsByPageInfo$2(Long l, Long l2, int i, int i2, String str, Continuation<? super EventRepository$getBgRecordsByPageInfo$2> continuation) {
        super(2, continuation);
        this.$startAutoIncrementColumn = l;
        this.$endAutoIncrementColumn = l2;
        this.$pageNum = i;
        this.$pageSize = i2;
        this.$userId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventRepository$getBgRecordsByPageInfo$2(this.$startAutoIncrementColumn, this.$endAutoIncrementColumn, this.$pageNum, this.$pageSize, this.$userId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<BaseResponse<List<BloodGlucoseEntity>>>> continuation) {
        return ((EventRepository$getBgRecordsByPageInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReqGetEventByPage reqGetEventByPage = new ReqGetEventByPage(this.$startAutoIncrementColumn, this.$endAutoIncrementColumn, (String) null);
            int i2 = this.$pageNum;
            int i3 = this.$pageSize;
            String str = this.$userId;
            reqGetEventByPage.setPageNum(i2);
            reqGetEventByPage.setPageSize(i3);
            reqGetEventByPage.setUserId(str);
            this.label = 1;
            obj = ApiService.Companion.getInstance().getBloodGlucoseRecordsByPageInfo(RequestEntityKt.toQueryMap(reqGetEventByPage), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
