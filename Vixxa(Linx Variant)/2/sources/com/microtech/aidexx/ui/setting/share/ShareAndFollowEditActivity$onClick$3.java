package com.microtech.aidexx.ui.setting.share;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.kongzue.dialogx.dialogs.WaitDialog;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.NetUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareAndFollowEditActivity.kt */
final class ShareAndFollowEditActivity$onClick$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ShareAndFollowEditActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareAndFollowEditActivity$onClick$3(ShareAndFollowEditActivity shareAndFollowEditActivity) {
        super(0);
        this.this$0 = shareAndFollowEditActivity;
    }

    public final void invoke() {
        if (NetUtil.isNetAvailable(this.this$0)) {
            ShareAndFollowEditActivity shareAndFollowEditActivity = this.this$0;
            WaitDialog.show((Activity) shareAndFollowEditActivity, (CharSequence) shareAndFollowEditActivity.getString(R.string.com_loading));
            final ShareAndFollowEditActivity shareAndFollowEditActivity2 = this.this$0;
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return;
        }
        String string = this.this$0.getResources().getString(R.string.com_network_unused);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ExtendsKt.toast(string);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareAndFollowEditActivity$onClick$3$1", f = "ShareAndFollowEditActivity.kt", i = {}, l = {196, 196}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.setting.share.ShareAndFollowEditActivity$onClick$3$1  reason: invalid class name */
    /* compiled from: ShareAndFollowEditActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(shareAndFollowEditActivity2, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ShareFollowViewModel access$getSfViewModel = shareAndFollowEditActivity2.getSfViewModel();
                ShareUserInfo access$getEditData$p = shareAndFollowEditActivity2.editData;
                if (access$getEditData$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editData");
                    access$getEditData$p = null;
                }
                String userAuthorizationId = access$getEditData$p.getUserAuthorizationId();
                Intrinsics.checkNotNull(userAuthorizationId);
                this.label = 1;
                obj = access$getSfViewModel.cancelShare(userAuthorizationId, this);
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
            final ShareAndFollowEditActivity shareAndFollowEditActivity = shareAndFollowEditActivity2;
            this.label = 2;
            if (((Flow) obj).collect(new FlowCollector() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    WaitDialog.dismiss();
                    if (z) {
                        shareAndFollowEditActivity.checkAndSwitchToMySelf();
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
}
