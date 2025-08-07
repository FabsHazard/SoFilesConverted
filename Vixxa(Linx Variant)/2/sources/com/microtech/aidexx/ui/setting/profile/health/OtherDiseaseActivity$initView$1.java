package com.microtech.aidexx.ui.setting.profile.health;

import com.microtech.aidexx.common.net.entity.MenuEntity;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.ui.setting.profile.DiabetesEnum;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.health.OtherDiseaseActivity$initView$1", f = "OtherDiseaseActivity.kt", i = {}, l = {123, 123}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OtherDiseaseActivity.kt */
final class OtherDiseaseActivity$initView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OtherDiseaseActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtherDiseaseActivity$initView$1(OtherDiseaseActivity otherDiseaseActivity, Continuation<? super OtherDiseaseActivity$initView$1> continuation) {
        super(2, continuation);
        this.this$0 = otherDiseaseActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OtherDiseaseActivity$initView$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OtherDiseaseActivity$initView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.userEntity = UserInfoManager.Companion.instance().getUserEntity();
            this.label = 1;
            obj = this.this$0.getPVm().getAllOtherDiabetes(this);
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

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lcom/microtech/aidexx/ui/setting/profile/DiabetesEnum;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.health.OtherDiseaseActivity$initView$1$1", f = "OtherDiseaseActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.setting.profile.health.OtherDiseaseActivity$initView$1$1  reason: invalid class name */
    /* compiled from: OtherDiseaseActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<DiabetesEnum, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(otherDiseaseActivity, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(DiabetesEnum diabetesEnum, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(diabetesEnum, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            List list;
            String otherDiseases;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DiabetesEnum diabetesEnum = (DiabetesEnum) this.L$0;
                if (diabetesEnum != null) {
                    OtherDiseaseActivity otherDiseaseActivity = otherDiseaseActivity;
                    otherDiseaseActivity.uncheckedData.clear();
                    UserEntity access$getUserEntity$p = otherDiseaseActivity.userEntity;
                    if (access$getUserEntity$p == null || (otherDiseases = access$getUserEntity$p.getOtherDiseases()) == null) {
                        list = null;
                    } else {
                        list = StringsKt.split$default((CharSequence) otherDiseases, new String[]{","}, false, 0, 6, (Object) null);
                    }
                    List access$getCheckedData$p = otherDiseaseActivity.checkedData;
                    Collection arrayList = new ArrayList();
                    for (Object next : diabetesEnum.getOtherDiabetesType()) {
                        MenuEntity menuEntity = (MenuEntity) next;
                        if (list == null || !list.contains(String.valueOf(menuEntity.getDictionaryId()))) {
                            otherDiseaseActivity.uncheckedData.add(menuEntity);
                        } else {
                            menuEntity.setCheck(true);
                            arrayList.add(next);
                        }
                    }
                    access$getCheckedData$p.addAll((List) arrayList);
                    List arrayList2 = new ArrayList();
                    arrayList2.addAll(CollectionsKt.sortedWith(otherDiseaseActivity.checkedData, new OtherDiseaseActivity$initView$1$1$invokeSuspend$lambda$3$$inlined$sortedByDescending$1()));
                    arrayList2.addAll(CollectionsKt.sortedWith(otherDiseaseActivity.uncheckedData, new OtherDiseaseActivity$initView$1$1$invokeSuspend$lambda$3$$inlined$sortedByDescending$2()));
                    otherDiseaseActivity.otherDiseaseAdapter.setNewInstance(arrayList2);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
