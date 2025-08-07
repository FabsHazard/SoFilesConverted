package com.microtech.aidexx.ui.setting.profile;

import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.EditNameActivity$initView$1$2$1", f = "EditNameActivity.kt", i = {}, l = {79, 82}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EditNameActivity.kt */
final class EditNameActivity$initView$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $type;
    final /* synthetic */ String $value;
    int label;
    final /* synthetic */ EditNameActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditNameActivity$initView$1$2$1(EditNameActivity editNameActivity, int i, String str, Continuation<? super EditNameActivity$initView$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = editNameActivity;
        this.$type = i;
        this.$value = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditNameActivity$initView$1$2$1(this.this$0, this.$type, this.$value, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditNameActivity$initView$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Dialogs.showWait$default(Dialogs.INSTANCE, (String) null, 1, (Object) null);
            ProfileViewModel access$getPVm = this.this$0.getPVm();
            int i2 = this.$type;
            String str2 = i2 == 0 ? this.$value : null;
            if (i2 == 0) {
                str = null;
            } else {
                str = this.$value;
            }
            this.label = 1;
            obj2 = ProfileViewModel.modifyProfileInfo$default(access$getPVm, str2, str, (Integer) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, this, 524284, (Object) null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final EditNameActivity editNameActivity = this.this$0;
        this.label = 2;
        if (FlowKt.collectLatest((Flow) obj2, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.EditNameActivity$initView$1$2$1$1", f = "EditNameActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.setting.profile.EditNameActivity$initView$1$2$1$1  reason: invalid class name */
    /* compiled from: EditNameActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends String>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(editNameActivity, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(Pair<Integer, String> pair, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                Dialogs.INSTANCE.dismissWait();
                if (((Number) pair.getFirst()).intValue() == 0) {
                    String string = editNameActivity.getString(R.string.com_state_success);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    ExtendsKt.toast(string);
                    editNameActivity.finish();
                } else {
                    ExtendsKt.toast((String) pair.getSecond());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
