package com.microtech.aidexx.ui.main.bg.history;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.ui.main.bg.BgRepositoryApi;
import java.util.Collection;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.bg.history.BloodGlucoseHistoryActivity$updateBgHistory$1", f = "BloodGlucoseHistoryActivity.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BloodGlucoseHistoryActivity.kt */
final class BloodGlucoseHistoryActivity$updateBgHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Date $endDate;
    final /* synthetic */ Date $startDate;
    Object L$0;
    int label;
    final /* synthetic */ BloodGlucoseHistoryActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BloodGlucoseHistoryActivity$updateBgHistory$1(BloodGlucoseHistoryActivity bloodGlucoseHistoryActivity, Date date, Date date2, Continuation<? super BloodGlucoseHistoryActivity$updateBgHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = bloodGlucoseHistoryActivity;
        this.$startDate = date;
        this.$endDate = date2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BloodGlucoseHistoryActivity$updateBgHistory$1(this.this$0, this.$startDate, this.$endDate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BloodGlucoseHistoryActivity$updateBgHistory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        BloodGlucoseHistoryAdapter bloodGlucoseHistoryAdapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BloodGlucoseHistoryAdapter historyAdapter = this.this$0.getHistoryAdapter();
            this.L$0 = historyAdapter;
            this.label = 1;
            Object bloodGlucoseHistory = BgRepositoryApi.INSTANCE.getBloodGlucoseHistory(this.$startDate, this.$endDate, UserInfoManager.Companion.getCurShowUserId(), this);
            if (bloodGlucoseHistory == coroutine_suspended) {
                return coroutine_suspended;
            }
            bloodGlucoseHistoryAdapter = historyAdapter;
            obj = bloodGlucoseHistory;
        } else if (i == 1) {
            bloodGlucoseHistoryAdapter = (BloodGlucoseHistoryAdapter) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        bloodGlucoseHistoryAdapter.setList((Collection) obj);
        return Unit.INSTANCE;
    }
}
