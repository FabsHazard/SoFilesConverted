package com.microtech.aidexx.ui.main.home;

import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.ui.setting.profile.ProfileViewModel;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.UnitChoseFragment$onViewCreated$1$2$1", f = "UnitChoseFragment.kt", i = {}, l = {70, 70}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: UnitChoseFragment.kt */
final class UnitChoseFragment$onViewCreated$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<UnitManager.GlucoseUnit> $glucoseTempUnit;
    int label;
    final /* synthetic */ UnitChoseFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UnitChoseFragment$onViewCreated$1$2$1(UnitChoseFragment unitChoseFragment, Ref.ObjectRef<UnitManager.GlucoseUnit> objectRef, Continuation<? super UnitChoseFragment$onViewCreated$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = unitChoseFragment;
        this.$glucoseTempUnit = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnitChoseFragment$onViewCreated$1$2$1(this.this$0, this.$glucoseTempUnit, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnitChoseFragment$onViewCreated$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H@"}, d2 = {"<anonymous>", "", "ret", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.home.UnitChoseFragment$onViewCreated$1$2$1$1", f = "UnitChoseFragment.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.home.UnitChoseFragment$onViewCreated$1$2$1$1  reason: invalid class name */
    /* compiled from: UnitChoseFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends String>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(objectRef, unitChoseFragment, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(Pair<Integer, String> pair, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Dialogs.INSTANCE.dismissWait();
                if (((Number) ((Pair) this.L$0).getFirst()).intValue() == 0) {
                    UnitManager.INSTANCE.setGlucoseUnit((UnitManager.GlucoseUnit) objectRef.element);
                    EventBusManager.INSTANCE.send(EventBusKey.EVENT_UNIT_CHANGE, Boxing.boxBoolean(true));
                    EventBusManager.INSTANCE.send(EventBusKey.UPDATE_NOTIFICATION, Boxing.boxBoolean(true));
                    this.label = 1;
                    if (UserInfoManager.updateProfile$default(UserInfoManager.Companion.instance(), (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, Boxing.boxInt(1), (Boolean) null, this, 1572863, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    String string = unitChoseFragment.getString(R.string.com_state_failure);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    ExtendsKt.toast(string);
                    return Unit.INSTANCE;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            unitChoseFragment.dismissAllowingStateLoss();
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj2 = ProfileViewModel.modifyProfileInfo$default(this.this$0.getPVm(), (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Boxing.boxInt(1), (Integer) null, (Integer) null, this, 458751, (Object) null);
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
        final Ref.ObjectRef<UnitManager.GlucoseUnit> objectRef = this.$glucoseTempUnit;
        final UnitChoseFragment unitChoseFragment = this.this$0;
        this.label = 2;
        if (FlowKt.collectLatest((Flow) obj2, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
