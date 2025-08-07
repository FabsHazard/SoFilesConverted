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
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareAddUserActivity$onCreate$1$2$1", f = "ShareAddUserActivity.kt", i = {}, l = {41, 41}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShareAddUserActivity.kt */
final class ShareAddUserActivity$onCreate$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $account;
    final /* synthetic */ String $alias;
    int label;
    final /* synthetic */ ShareAddUserActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareAddUserActivity$onCreate$1$2$1(ShareAddUserActivity shareAddUserActivity, String str, String str2, Continuation<? super ShareAddUserActivity$onCreate$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = shareAddUserActivity;
        this.$account = str;
        this.$alias = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareAddUserActivity$onCreate$1$2$1(this.this$0, this.$account, this.$alias, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShareAddUserActivity$onCreate$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getSfViewModel().shareMyselfToOther(this.$account, this.$alias, this);
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
        final ShareAddUserActivity shareAddUserActivity = this.this$0;
        this.label = 2;
        if (((Flow) obj).collect(new FlowCollector() {
            public final Object emit(String str, Continuation<? super Unit> continuation) {
                Unit unit;
                WaitDialog.dismiss();
                if (str != null) {
                    ExtendsKt.toast(str);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    shareAddUserActivity.finish();
                }
                return Unit.INSTANCE;
            }
        }, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
