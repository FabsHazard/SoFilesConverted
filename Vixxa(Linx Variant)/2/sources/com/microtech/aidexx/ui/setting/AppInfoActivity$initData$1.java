package com.microtech.aidexx.ui.setting;

import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.AppInformation;
import com.microtech.aidexx.common.net.entity.BaseResponse;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.AppInfoActivity$initData$1", f = "AppInfoActivity.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AppInfoActivity.kt */
final class AppInfoActivity$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppInfoActivity$initData$1(AppInfoActivity appInfoActivity, Continuation<? super AppInfoActivity$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = appInfoActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInfoActivity$initData$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppInfoActivity$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ApiService instance = ApiService.Companion.getInstance();
            String string = this.this$0.getString(R.string.gpSoftWareModel);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.label = 1;
            obj = instance.getAppInformation("1.7.1", string, this);
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
            this.this$0.setData((AppInformation) ((BaseResponse) ((ApiResult.Success) apiResult).getResult()).getData());
        } else if (apiResult instanceof ApiResult.Failure) {
            String string2 = this.this$0.getString(R.string.com_network_failure);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExtendsKt.toast(string2);
        }
        return Unit.INSTANCE;
    }
}
