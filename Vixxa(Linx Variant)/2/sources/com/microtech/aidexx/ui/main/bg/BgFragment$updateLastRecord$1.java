package com.microtech.aidexx.ui.main.bg;

import android.content.res.Resources;
import android.widget.TextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.FragmentBgBinding;
import com.microtech.aidexx.databinding.ItemGlucoseHistoryBgBinding;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.bg.BgFragment$updateLastRecord$1", f = "BgFragment.kt", i = {0}, l = {278}, m = "invokeSuspend", n = {"lastGlucoseRecord"}, s = {"L$0"})
/* compiled from: BgFragment.kt */
final class BgFragment$updateLastRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ BgFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BgFragment$updateLastRecord$1(BgFragment bgFragment, Continuation<? super BgFragment$updateLastRecord$1> continuation) {
        super(2, continuation);
        this.this$0 = bgFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BgFragment$updateLastRecord$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BgFragment$updateLastRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            this.L$0 = objectRef2;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else if (i == 1) {
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (objectRef.element == null) {
            ((FragmentBgBinding) this.this$0.getBinding()).tvMoreHistory.setVisibility(4);
            ((FragmentBgBinding) this.this$0.getBinding()).llBgRecode.llContainer.setVisibility(4);
            ((FragmentBgBinding) this.this$0.getBinding()).tvNoneRecord.setVisibility(0);
        } else {
            ((FragmentBgBinding) this.this$0.getBinding()).tvMoreHistory.setVisibility(0);
            ItemGlucoseHistoryBgBinding itemGlucoseHistoryBgBinding = ((FragmentBgBinding) this.this$0.getBinding()).llBgRecode;
            BgFragment bgFragment = this.this$0;
            itemGlucoseHistoryBgBinding.llContainer.setVisibility(0);
            TextView textView = itemGlucoseHistoryBgBinding.tvGlucoseTime;
            String string = bgFragment.getString(R.string.com_dateFormat_yyyyMMddHHmm);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(BaseEventEntity.getDisplayTime$default((BaseEventEntity) objectRef.element, string, false, 2, (Object) null));
            Resources resources = bgFragment.requireContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            String tagText = ((BloodGlucoseEntity) objectRef.element).getTagText(resources);
            CharSequence charSequence = tagText;
            if (charSequence == null || charSequence.length() == 0) {
                tagText = "— —";
            }
            itemGlucoseHistoryBgBinding.tvGlucoseDescribe.setText(tagText);
            TextView textView2 = itemGlucoseHistoryBgBinding.tvGlucoseRecordValue;
            Resources resources2 = bgFragment.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            textView2.setText(((BloodGlucoseEntity) objectRef.element).getValueDescription(resources2));
            itemGlucoseHistoryBgBinding.glucoseHistoryDivider.setVisibility(8);
            ((FragmentBgBinding) this.this$0.getBinding()).tvNoneRecord.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.bg.BgFragment$updateLastRecord$1$1", f = "BgFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.bg.BgFragment$updateLastRecord$1$1  reason: invalid class name */
    /* compiled from: BgFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(objectRef2, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef2.element = BgRepositoryApi.INSTANCE.getLastGlucoseHistory();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
