package com.microtech.aidexx.ui.setting.profile.health;

import com.microtech.aidexx.common.net.entity.MenuEntity;
import com.microtech.aidexx.databinding.ActivityDiabetesInfoConfigBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "entityList", "", "Lcom/microtech/aidexx/common/net/entity/MenuEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: DiabetesInfoConfigActivity.kt */
final class DiabetesInfoConfigActivity$initView$1$4$1 extends Lambda implements Function1<List<MenuEntity>, Unit> {
    final /* synthetic */ ActivityDiabetesInfoConfigBinding $this_apply;
    final /* synthetic */ DiabetesInfoConfigActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiabetesInfoConfigActivity$initView$1$4$1(DiabetesInfoConfigActivity diabetesInfoConfigActivity, ActivityDiabetesInfoConfigBinding activityDiabetesInfoConfigBinding) {
        super(1);
        this.this$0 = diabetesInfoConfigActivity;
        this.$this_apply = activityDiabetesInfoConfigBinding;
    }

    public final void invoke(List<MenuEntity> list) {
        Intrinsics.checkNotNullParameter(list, "entityList");
        Iterable iterable = list;
        this.this$0.treatment = CollectionsKt.joinToString$default(iterable, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnonymousClass1.INSTANCE, 30, (Object) null);
        this.this$0.treatmentDisplayName = CollectionsKt.joinToString$default(iterable, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnonymousClass2.INSTANCE, 30, (Object) null);
        this.$this_apply.tvTreatment.setText(this.this$0.treatmentDisplayName);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<MenuEntity>) (List) obj);
        return Unit.INSTANCE;
    }
}
