package com.microtech.aidexx.ui.setting.share;

import com.kongzue.dialogx.dialogs.WaitDialog;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareAndFollowEditActivity$onClick$2", f = "ShareAndFollowEditActivity.kt", i = {}, l = {161, 168}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShareAndFollowEditActivity.kt */
final class ShareAndFollowEditActivity$onClick$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $alias;
    int label;
    final /* synthetic */ ShareAndFollowEditActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareAndFollowEditActivity$onClick$2(ShareAndFollowEditActivity shareAndFollowEditActivity, String str, Continuation<? super ShareAndFollowEditActivity$onClick$2> continuation) {
        super(2, continuation);
        this.this$0 = shareAndFollowEditActivity;
        this.$alias = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareAndFollowEditActivity$onClick$2(this.this$0, this.$alias, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShareAndFollowEditActivity$onClick$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ShareFollowViewModel access$getSfViewModel = this.this$0.getSfViewModel();
            String str = this.$alias;
            ShareUserInfo access$getEditData$p = this.this$0.editData;
            ShareUserInfo shareUserInfo = null;
            if (access$getEditData$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editData");
                access$getEditData$p = null;
            }
            String readerAlias = access$getEditData$p.getReaderAlias();
            Integer boxInt = Boxing.boxInt(Intrinsics.areEqual((Object) this.this$0.hideState, (Object) Boxing.boxBoolean(true)) ? 1 : 0);
            Integer boxInt2 = Boxing.boxInt(Intrinsics.areEqual((Object) this.this$0.emergePush, (Object) Boxing.boxBoolean(true)) ? 1 : 0);
            Integer boxInt3 = Boxing.boxInt(Intrinsics.areEqual((Object) this.this$0.normalPush, (Object) Boxing.boxBoolean(true)) ? 1 : 0);
            ShareUserInfo access$getEditData$p2 = this.this$0.editData;
            if (access$getEditData$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editData");
            } else {
                shareUserInfo = access$getEditData$p2;
            }
            String userAuthorizationId = shareUserInfo.getUserAuthorizationId();
            Intrinsics.checkNotNull(userAuthorizationId);
            this.label = 1;
            obj = access$getSfViewModel.modifyFollowUser(str, readerAlias, boxInt, boxInt2, boxInt3, userAuthorizationId, this);
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
        final ShareAndFollowEditActivity shareAndFollowEditActivity = this.this$0;
        this.label = 2;
        if (((Flow) obj).collect(new FlowCollector() {
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
            }

            public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                WaitDialog.dismiss();
                if (z) {
                    if (Intrinsics.areEqual((Object) shareAndFollowEditActivity.hideState, (Object) Boxing.boxBoolean(true))) {
                        shareAndFollowEditActivity.checkAndSwitchToMySelf();
                    }
                    shareAndFollowEditActivity.finish();
                } else {
                    String string = shareAndFollowEditActivity.getString(R.string.com_state_failure);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    ExtendsKt.toast(string);
                }
                return Unit.INSTANCE;
            }
        }, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
