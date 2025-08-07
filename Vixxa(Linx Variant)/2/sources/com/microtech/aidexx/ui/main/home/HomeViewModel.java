package com.microtech.aidexx.ui.main.home;

import androidx.lifecycle.ViewModelKt;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.net.entity.WelfareInfo;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/HomeViewModel;", "Lcom/microtech/aidexx/base/BaseViewModel;", "()V", "mFollowers", "", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "getMFollowers", "()Ljava/util/List;", "getActivities", "Lcom/microtech/aidexx/common/net/entity/WelfareInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFollowers", "", "switchUser", "", "userId", "", "updateFollowers", "data", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeViewModel.kt */
public final class HomeViewModel extends BaseViewModel {
    private final List<ShareUserInfo> mFollowers = new ArrayList();

    public final List<ShareUserInfo> getMFollowers() {
        return this.mFollowers;
    }

    public final void updateFollowers(List<ShareUserInfo> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.mFollowers.clear();
        this.mFollowers.addAll(list);
    }

    public final Object getFollowers(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HomeViewModel$getFollowers$2(this, (Continuation<? super HomeViewModel$getFollowers$2>) null), continuation);
    }

    public final void switchUser(String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new HomeViewModel$switchUser$1(str, (Continuation<? super HomeViewModel$switchUser$1>) null), 3, (Object) null);
    }

    public final Object getActivities(Continuation<? super WelfareInfo> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HomeViewModel$getActivities$2((Continuation<? super HomeViewModel$getActivities$2>) null), continuation);
    }
}
