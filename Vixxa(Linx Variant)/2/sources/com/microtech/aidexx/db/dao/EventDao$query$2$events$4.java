package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity_;
import io.objectbox.Box;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a$\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00040\u0001*\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lcom/microtech/aidexx/db/entity/event/InsulinEntity;", "kotlin.jvm.PlatformType", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.db.dao.EventDao$query$2$events$4", f = "EventDao.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EventDao.kt */
final class EventDao$query$2$events$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<InsulinEntity>>, Object> {
    final /* synthetic */ Date $endDate;
    final /* synthetic */ Date $startDate;
    final /* synthetic */ String $userId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventDao$query$2$events$4(Date date, Date date2, String str, Continuation<? super EventDao$query$2$events$4> continuation) {
        super(2, continuation);
        this.$startDate = date;
        this.$endDate = date2;
        this.$userId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventDao$query$2$events$4(this.$startDate, this.$endDate, this.$userId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<InsulinEntity>> continuation) {
        return ((EventDao$query$2$events$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Box access$getInsulinBox = EventDao.INSTANCE.getInsulinBox();
            Date date = this.$startDate;
            Date date2 = this.$endDate;
            String str = this.$userId;
            QueryBuilder query = access$getInsulinBox.query();
            Intrinsics.checkNotNullExpressionValue(query, "builder");
            query.between(InsulinEntity_.timestamp, date.getTime(), date2.getTime());
            query.equal(InsulinEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
            query.equal(InsulinEntity_.deleteStatus, 0);
            Query build = query.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            return build.find();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
