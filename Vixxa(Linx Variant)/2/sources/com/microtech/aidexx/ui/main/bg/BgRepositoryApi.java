package com.microtech.aidexx.ui.main.bg;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity_;
import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/ui/main/bg/BgRepositoryApi;", "", "()V", "getBloodGlucoseHistory", "", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "timeFrom", "Ljava/util/Date;", "timeTo", "authorId", "", "(Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastGlucoseHistory", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BgRepositoryApi.kt */
public final class BgRepositoryApi {
    public static final BgRepositoryApi INSTANCE = new BgRepositoryApi();

    private BgRepositoryApi() {
    }

    public final BloodGlucoseEntity getLastGlucoseHistory() {
        Box<BloodGlucoseEntity> bgHistoryBox = ObjectBox.INSTANCE.getBgHistoryBox();
        Intrinsics.checkNotNull(bgHistoryBox);
        return bgHistoryBox.query().equal(BloodGlucoseEntity_.userId, UserInfoManager.Companion.instance().userId(), QueryBuilder.StringOrder.CASE_INSENSITIVE).equal(BloodGlucoseEntity_.deleteStatus, 0).orderDesc(BloodGlucoseEntity_.appCreateTime).build().findFirst();
    }

    public static /* synthetic */ Object getBloodGlucoseHistory$default(BgRepositoryApi bgRepositoryApi, Date date, Date date2, String str, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return bgRepositoryApi.getBloodGlucoseHistory(date, date2, str, continuation);
    }

    public final Object getBloodGlucoseHistory(Date date, Date date2, String str, Continuation<? super List<BloodGlucoseEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BgRepositoryApi$getBloodGlucoseHistory$2(str, date, date2, (Continuation<? super BgRepositoryApi$getBloodGlucoseHistory$2>) null), continuation);
    }
}
