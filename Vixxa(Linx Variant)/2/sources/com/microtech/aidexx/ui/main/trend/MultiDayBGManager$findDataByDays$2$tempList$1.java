package com.microtech.aidexx.ui.main.trend;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.repository.CgmCalibBgRepository;
import java.util.Calendar;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.MultiDayBGManager$findDataByDays$2$tempList$1", f = "MultiDayBgManager.kt", i = {}, l = {95, 101}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MultiDayBgManager.kt */
final class MultiDayBGManager$findDataByDays$2$tempList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<RealCgmHistoryEntity>>, Object> {
    final /* synthetic */ Calendar $start;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiDayBGManager$findDataByDays$2$tempList$1(Calendar calendar, Continuation<? super MultiDayBGManager$findDataByDays$2$tempList$1> continuation) {
        super(2, continuation);
        this.$start = calendar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiDayBGManager$findDataByDays$2$tempList$1(this.$start, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<RealCgmHistoryEntity>> continuation) {
        return ((MultiDayBGManager$findDataByDays$2$tempList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (ExtendsKt.useAppTime()) {
                Date time = this.$start.getTime();
                Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
                String date2YMDByEnglish = ExtendsKt.date2YMDByEnglish(time);
                Date time2 = this.$start.getTime();
                Intrinsics.checkNotNullExpressionValue(time2, "getTime(...)");
                String date2YMDByEnglish2 = ExtendsKt.date2YMDByEnglish(new Date(ExtendsKt.getEndOfTheDay(time2).getTime() + 1));
                this.label = 1;
                obj = CgmCalibBgRepository.INSTANCE.queryCgmByPage(date2YMDByEnglish + " 00:00:00", date2YMDByEnglish2 + " 00:00:00", UserInfoManager.Companion.getCurShowUserId(), (Continuation<? super List<RealCgmHistoryEntity>>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                CgmCalibBgRepository cgmCalibBgRepository = CgmCalibBgRepository.INSTANCE;
                Date time3 = this.$start.getTime();
                Intrinsics.checkNotNullExpressionValue(time3, "getTime(...)");
                Date startOfTheDay = ExtendsKt.getStartOfTheDay(time3);
                Date time4 = this.$start.getTime();
                Intrinsics.checkNotNullExpressionValue(time4, "getTime(...)");
                this.label = 2;
                obj = cgmCalibBgRepository.queryCgmByPage(startOfTheDay, ExtendsKt.getEndOfTheDay(time4), UserInfoManager.Companion.getCurShowUserId(), (Continuation<? super List<RealCgmHistoryEntity>>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (List) obj;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return (List) obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (List) obj;
    }
}
