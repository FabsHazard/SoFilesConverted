package com.microtech.aidexx.ui.setting.profile.health;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.MenuEntity;
import java.util.List;
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
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.health.OtherDiseaseActivity$initEvent$1$1$1", f = "OtherDiseaseActivity.kt", i = {}, l = {54, 54}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OtherDiseaseActivity.kt */
final class OtherDiseaseActivity$initEvent$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MenuEntity> $newAddPresetList;
    int label;
    final /* synthetic */ OtherDiseaseActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtherDiseaseActivity$initEvent$1$1$1(OtherDiseaseActivity otherDiseaseActivity, List<MenuEntity> list, Continuation<? super OtherDiseaseActivity$initEvent$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = otherDiseaseActivity;
        this.$newAddPresetList = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OtherDiseaseActivity$initEvent$1$1$1(this.this$0, this.$newAddPresetList, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OtherDiseaseActivity$initEvent$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.health.OtherDiseaseActivity$initEvent$1$1$1$1", f = "OtherDiseaseActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.setting.profile.health.OtherDiseaseActivity$initEvent$1$1$1$1  reason: invalid class name */
    /* compiled from: OtherDiseaseActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends String>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(otherDiseaseActivity, continuation);
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
                if (((Number) pair.getFirst()).intValue() == 0) {
                    otherDiseaseActivity.finish();
                } else {
                    Object second = pair.getSecond();
                    Intrinsics.checkNotNullExpressionValue(second, "<get-second>(...)");
                    ExtendsKt.toast((String) second);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getPVm().saveAndUpdateOtherDiseases(this.$newAddPresetList, this.this$0.checkedData, this);
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
        final OtherDiseaseActivity otherDiseaseActivity = this.this$0;
        this.label = 2;
        if (FlowKt.collectLatest((Flow) obj, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
