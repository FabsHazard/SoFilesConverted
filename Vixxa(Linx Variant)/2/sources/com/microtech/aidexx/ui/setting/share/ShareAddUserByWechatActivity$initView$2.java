package com.microtech.aidexx.ui.setting.share;

import com.kongzue.dialogx.dialogs.WaitDialog;
import com.microtech.aidexx.common.ExtendsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareAddUserByWechatActivity$initView$2", f = "ShareAddUserByWechatActivity.kt", i = {}, l = {95, 95}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShareAddUserByWechatActivity.kt */
final class ShareAddUserByWechatActivity$initView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShareAddUserByWechatActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareAddUserByWechatActivity$initView$2(ShareAddUserByWechatActivity shareAddUserByWechatActivity, Continuation<? super ShareAddUserByWechatActivity$initView$2> continuation) {
        super(2, continuation);
        this.this$0 = shareAddUserByWechatActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareAddUserByWechatActivity$initView$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShareAddUserByWechatActivity$initView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getSfViewModel().getQrCodeToShareMySelf(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ShareAddUserByWechatActivity shareAddUserByWechatActivity = this.this$0;
        this.label = 2;
        if (((Flow) obj).collect(new FlowCollector() {
            public final Object emit(String str, Continuation<? super Unit> continuation) {
                ExtendsKt.toast("接口还没提供");
                WaitDialog.dismiss();
                shareAddUserByWechatActivity.getHandler().removeMessages(1);
                return Unit.INSTANCE;
            }
        }, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
