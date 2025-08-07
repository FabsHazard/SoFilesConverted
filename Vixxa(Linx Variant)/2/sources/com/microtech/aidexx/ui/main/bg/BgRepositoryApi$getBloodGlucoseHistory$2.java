package com.microtech.aidexx.ui.main.bg;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity_;
import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.bg.BgRepositoryApi$getBloodGlucoseHistory$2", f = "BgRepositoryApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BgRepositoryApi.kt */
final class BgRepositoryApi$getBloodGlucoseHistory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<BloodGlucoseEntity>>, Object> {
    final /* synthetic */ String $authorId;
    final /* synthetic */ Date $timeFrom;
    final /* synthetic */ Date $timeTo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BgRepositoryApi$getBloodGlucoseHistory$2(String str, Date date, Date date2, Continuation<? super BgRepositoryApi$getBloodGlucoseHistory$2> continuation) {
        super(2, continuation);
        this.$authorId = str;
        this.$timeFrom = date;
        this.$timeTo = date2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BgRepositoryApi$getBloodGlucoseHistory$2(this.$authorId, this.$timeFrom, this.$timeTo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<BloodGlucoseEntity>> continuation) {
        return ((BgRepositoryApi$getBloodGlucoseHistory$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List arrayList = new ArrayList();
            Box<BloodGlucoseEntity> bgHistoryBox = ObjectBox.INSTANCE.getBgHistoryBox();
            Intrinsics.checkNotNull(bgHistoryBox);
            List<BloodGlucoseEntity> find = bgHistoryBox.query().equal(BloodGlucoseEntity_.userId, this.$authorId, QueryBuilder.StringOrder.CASE_INSENSITIVE).equal(BloodGlucoseEntity_.deleteStatus, 0).notEqual(BloodGlucoseEntity_.state, 1).between(BloodGlucoseEntity_.timestamp, this.$timeFrom.getTime(), this.$timeTo.getTime()).orderDesc(BloodGlucoseEntity_.timestamp).build().find();
            Intrinsics.checkNotNullExpressionValue(find, "find(...)");
            arrayList.addAll(find);
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
