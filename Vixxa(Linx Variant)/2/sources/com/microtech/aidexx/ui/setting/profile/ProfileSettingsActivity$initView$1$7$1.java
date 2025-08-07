package com.microtech.aidexx.ui.setting.profile;

import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.databinding.ActivitySettingsProfileBinding;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ProfileSettingsActivity.kt */
final class ProfileSettingsActivity$initView$1$7$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ActivitySettingsProfileBinding $this_apply;
    final /* synthetic */ ProfileSettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileSettingsActivity$initView$1$7$1(ProfileSettingsActivity profileSettingsActivity, ActivitySettingsProfileBinding activitySettingsProfileBinding) {
        super(1);
        this.this$0 = profileSettingsActivity;
        this.$this_apply = activitySettingsProfileBinding;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ProfileSettingsActivity$initView$1$7$1$1", f = "ProfileSettingsActivity.kt", i = {}, l = {162, 162}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.setting.profile.ProfileSettingsActivity$initView$1$7$1$1  reason: invalid class name */
    /* compiled from: ProfileSettingsActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(profileSettingsActivity, i, activitySettingsProfileBinding, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj2 = ProfileViewModel.modifyProfileInfo$default(profileSettingsActivity.getPVm(), (String) null, (String) null, (Integer) null, (Integer) null, Boxing.boxInt(i + 1), (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, this, 524271, (Object) null);
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
            final ProfileSettingsActivity profileSettingsActivity = profileSettingsActivity;
            final ActivitySettingsProfileBinding activitySettingsProfileBinding = activitySettingsProfileBinding;
            final int i2 = i;
            this.label = 2;
            if (FlowKt.collectLatest((Flow) obj2, new Function2<Pair<? extends Integer, ? extends String>, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                /* synthetic */ Object L$0;
                int label;

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 r0 = 

                    public final void invoke(final int i) {
                        Dialogs.showWait$default(Dialogs.INSTANCE, (String) null, 1, (Object) null);
                        final ProfileSettingsActivity profileSettingsActivity = this.this$0;
                        final ActivitySettingsProfileBinding activitySettingsProfileBinding = this.$this_apply;
                        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                    }
                }
