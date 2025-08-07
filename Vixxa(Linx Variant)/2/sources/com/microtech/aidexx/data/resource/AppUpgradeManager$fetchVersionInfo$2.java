package com.microtech.aidexx.data.resource;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.UpgradeInfo;
import com.microtech.aidexx.common.net.entity.VersionData;
import com.microtech.aidexx.common.net.entity.VersionInfo;
import com.microtech.aidexx.common.net.repository.ApiRepository;
import com.microtech.aidexx.utils.StringUtils;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/entity/UpgradeInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.AppUpgradeManager$fetchVersionInfo$2", f = "AppUpgradeManager.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AppUpgradeManager.kt */
final class AppUpgradeManager$fetchVersionInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UpgradeInfo>, Object> {
    final /* synthetic */ boolean $isManual;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppUpgradeManager$fetchVersionInfo$2(boolean z, Continuation<? super AppUpgradeManager$fetchVersionInfo$2> continuation) {
        super(2, continuation);
        this.$isManual = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppUpgradeManager$fetchVersionInfo$2(this.$isManual, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UpgradeInfo> continuation) {
        return ((AppUpgradeManager$fetchVersionInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        VersionInfo appUpdateInfo;
        VersionData info;
        VersionInfo appUpdateInfo2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!AppUpgradeManager.INSTANCE.needCheckNewVersion(this.$isManual)) {
                return null;
            }
            this.label = 1;
            obj = ApiRepository.INSTANCE.checkAppUpdate(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ApiResult apiResult = (ApiResult) obj;
        if (apiResult instanceof ApiResult.Success) {
            BaseResponse baseResponse = (BaseResponse) ((ApiResult.Success) apiResult).getResult();
            UpgradeInfo upgradeInfo = (UpgradeInfo) baseResponse.getData();
            if (!(upgradeInfo == null || (appUpdateInfo2 = upgradeInfo.getAppUpdateInfo()) == null || appUpdateInfo2.isForce())) {
                MmkvManager.updateAppCheckVersionTime$default(MmkvManager.INSTANCE, 0, 1, (Object) null);
            }
            StringUtils stringUtils = StringUtils.INSTANCE;
            UpgradeInfo upgradeInfo2 = (UpgradeInfo) baseResponse.getData();
            if (upgradeInfo2 == null || (appUpdateInfo = upgradeInfo2.getAppUpdateInfo()) == null || (info = appUpdateInfo.getInfo()) == null || (str = info.getVersion()) == null) {
                str = "";
            }
            if (stringUtils.versionCompare("1.7.1", str)) {
                return (UpgradeInfo) baseResponse.getData();
            }
            UpgradeInfo upgradeInfo3 = (UpgradeInfo) baseResponse.getData();
            VersionInfo resourceUpdateInfo = upgradeInfo3 != null ? upgradeInfo3.getResourceUpdateInfo() : null;
            if (resourceUpdateInfo == null || resourceUpdateInfo.getInfo() == null) {
                return null;
            }
            LocalResourceManager.INSTANCE.startUpgrade(resourceUpdateInfo);
            return null;
        } else if (apiResult instanceof ApiResult.Failure) {
            return null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
