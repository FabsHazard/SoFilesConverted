package com.microtech.aidexx.data.resource;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.PolicyUpgradeInfo;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.util.Date;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/data/resource/PrivacyUpdateManager;", "", "()V", "checkPolicyUpdate", "Lcom/microtech/aidexx/common/net/entity/PolicyUpgradeInfo;", "isForce", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "needCheckNewVersion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PolicyUpdateManager.kt */
public final class PrivacyUpdateManager {
    public static final PrivacyUpdateManager INSTANCE = new PrivacyUpdateManager();

    private PrivacyUpdateManager() {
    }

    public static /* synthetic */ Object checkPolicyUpdate$default(PrivacyUpdateManager privacyUpdateManager, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return privacyUpdateManager.checkPolicyUpdate(z, continuation);
    }

    public final Object checkPolicyUpdate(boolean z, Continuation<? super PolicyUpgradeInfo> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PrivacyUpdateManager$checkPolicyUpdate$2(z, (Continuation<? super PrivacyUpdateManager$checkPolicyUpdate$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final boolean needCheckNewVersion() {
        boolean z = false;
        if (!NetUtil.isNetAvailable(ExtendsKt.getContext())) {
            return false;
        }
        if (MmkvManager.INSTANCE.getPrivacyCheckTime() == ExtendsKt.getStartOfTheDay(new Date()).getTime()) {
            z = true;
        }
        return !z;
    }
}
