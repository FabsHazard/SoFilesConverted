package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.repository.EventDbRepository;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$checkClosestEvent$2$taskList$3", f = "ChartViewModel.kt", i = {}, l = {735}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$checkClosestEvent$2$taskList$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BaseEventEntity>, Object> {
    final /* synthetic */ Date $maxTime;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$checkClosestEvent$2$taskList$3(Date date, Continuation<? super ChartViewModel$checkClosestEvent$2$taskList$3> continuation) {
        super(2, continuation);
        this.$maxTime = date;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewModel$checkClosestEvent$2$taskList$3(this.$maxTime, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BaseEventEntity> continuation) {
        return ((ChartViewModel$checkClosestEvent$2$taskList$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = EventDbRepository.INSTANCE.queryNextByTargetDate(UserInfoManager.Companion.getCurShowUserId(), this.$maxTime, this);
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
