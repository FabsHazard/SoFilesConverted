package com.microtech.aidexx.data.resource;

import android.os.Parcelable;
import com.microtech.aidexx.BuildConfig;
import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.PolicyUpgradeInfo;
import com.microtech.aidexx.utils.StringUtils;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/entity/PolicyUpgradeInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.PrivacyUpdateManager$checkPolicyUpdate$2", f = "PolicyUpdateManager.kt", i = {0}, l = {29}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
/* compiled from: PolicyUpdateManager.kt */
final class PrivacyUpdateManager$checkPolicyUpdate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PolicyUpgradeInfo>, Object> {
    final /* synthetic */ boolean $isForce;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrivacyUpdateManager$checkPolicyUpdate$2(boolean z, Continuation<? super PrivacyUpdateManager$checkPolicyUpdate$2> continuation) {
        super(2, continuation);
        this.$isForce = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PrivacyUpdateManager$checkPolicyUpdate$2 privacyUpdateManager$checkPolicyUpdate$2 = new PrivacyUpdateManager$checkPolicyUpdate$2(this.$isForce, continuation);
        privacyUpdateManager$checkPolicyUpdate$2.L$0 = obj;
        return privacyUpdateManager$checkPolicyUpdate$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PolicyUpgradeInfo> continuation) {
        return ((PrivacyUpdateManager$checkPolicyUpdate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Unit unit;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (!this.$isForce && !PrivacyUpdateManager.INSTANCE.needCheckNewVersion()) {
                return null;
            }
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = ApiService.Companion.getInstance().checkPrivacyUpdate(BuildConfig.FLAVOR_BRAND, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ApiResult apiResult = (ApiResult) obj;
        if (apiResult instanceof ApiResult.Success) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            List<T> list = (List) ((BaseResponse) ((ApiResult.Success) apiResult).getResult()).getData();
            if (list == null) {
                return null;
            }
            for (T t : list) {
                int policyType = t.getPolicyType();
                if (policyType == 1 || policyType == 3) {
                    MmkvManager.INSTANCE.savePolicyInfo((Parcelable) t, t.getPolicyType());
                } else {
                    PolicyUpgradeInfo policyInfo = MmkvManager.INSTANCE.getPolicyInfo(t.getPolicyType());
                    if (policyInfo != null) {
                        if (StringUtils.INSTANCE.versionCompare(policyInfo.getVersion(), t.getVersion())) {
                            objectRef.element = t;
                        } else {
                            MmkvManager.INSTANCE.savePolicyInfo((Parcelable) t, t.getPolicyType());
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        MmkvManager.INSTANCE.savePolicyInfo((Parcelable) t, t.getPolicyType());
                    }
                }
            }
            return (PolicyUpgradeInfo) objectRef.element;
        } else if (apiResult instanceof ApiResult.Failure) {
            return null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
