package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity_;
import io.objectbox.kotlin.BoxStoreKt;
import io.objectbox.query.QueryBuilder;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/db/entity/event/InsulinEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.db.dao.EventDao$queryNextByTargetDate$2$events$4", f = "EventDao.kt", i = {}, l = {753}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EventDao.kt */
final class EventDao$queryNextByTargetDate$2$events$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InsulinEntity>, Object> {
    final /* synthetic */ Date $targetDate;
    final /* synthetic */ String $userId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventDao$queryNextByTargetDate$2$events$4(String str, Date date, Continuation<? super EventDao$queryNextByTargetDate$2$events$4> continuation) {
        super(2, continuation);
        this.$userId = str;
        this.$targetDate = date;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventDao$queryNextByTargetDate$2$events$4(this.$userId, this.$targetDate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InsulinEntity> continuation) {
        return ((EventDao$queryNextByTargetDate$2$events$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ObjectBox objectBox = ObjectBox.INSTANCE;
            EventDao$queryNextByTargetDate$2$events$4$$ExternalSyntheticLambda0 eventDao$queryNextByTargetDate$2$events$4$$ExternalSyntheticLambda0 = new EventDao$queryNextByTargetDate$2$events$4$$ExternalSyntheticLambda0(this.$userId, this.$targetDate);
            this.label = 1;
            obj = BoxStoreKt.awaitCallInTx(objectBox.getStore(), eventDao$queryNextByTargetDate$2$events$4$$ExternalSyntheticLambda0, this);
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

    /* access modifiers changed from: private */
    public static final InsulinEntity invokeSuspend$lambda$0(String str, Date date) {
        return (InsulinEntity) EventDao.INSTANCE.getInsulinBox().query().equal(InsulinEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE).equal(InsulinEntity_.deleteStatus, 0).less(InsulinEntity_.timestamp, date.getTime()).orderDesc(InsulinEntity_.timestamp).build().findFirst();
    }
}
