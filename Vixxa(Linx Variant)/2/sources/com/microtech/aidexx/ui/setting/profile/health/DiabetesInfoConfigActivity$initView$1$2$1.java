package com.microtech.aidexx.ui.setting.profile.health;

import com.microtech.aidexx.R;
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
final class DiabetesInfoConfigActivity$initView$1$2$1 extends Lambda implements Function1<List<MenuEntity>, Unit> {
    final /* synthetic */ ActivityDiabetesInfoConfigBinding $this_apply;
    final /* synthetic */ DiabetesInfoConfigActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiabetesInfoConfigActivity$initView$1$2$1(ActivityDiabetesInfoConfigBinding activityDiabetesInfoConfigBinding, DiabetesInfoConfigActivity diabetesInfoConfigActivity) {
        super(1);
        this.$this_apply = activityDiabetesInfoConfigBinding;
        this.this$0 = diabetesInfoConfigActivity;
    }

    public final void invoke(List<MenuEntity> list) {
        Integer access$getDiabetesTypeValue$p;
        Intrinsics.checkNotNullParameter(list, "entityList");
        if (!list.isEmpty()) {
            this.$this_apply.tvDiagnosisType.setText(CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnonymousClass1.INSTANCE, 30, (Object) null));
            this.this$0.diabetesTypeByDId = ((MenuEntity) CollectionsKt.first(list)).getDictionaryId();
            this.this$0.diabetesTypeValue = ((MenuEntity) CollectionsKt.first(list)).getValue();
            this.this$0.diabetesTypeDisplayName = ((MenuEntity) CollectionsKt.first(list)).getDisplayName();
        } else {
            this.$this_apply.tvDiagnosisType.setText(this.this$0.getString(R.string.com_inputHint, new Object[]{this.this$0.getString(R.string.user_info_diabetesType)}));
            this.this$0.diabetesTypeByDId = "";
            this.this$0.diabetesTypeValue = -1;
            this.this$0.diabetesTypeDisplayName = "";
        }
        DiabetesInfoConfigActivity diabetesInfoConfigActivity = this.this$0;
        diabetesInfoConfigActivity.setInfoUiVisible(diabetesInfoConfigActivity.diabetesTypeValue);
        Integer access$getDiabetesTypeValue$p2 = this.this$0.diabetesTypeValue;
        if ((access$getDiabetesTypeValue$p2 != null ? access$getDiabetesTypeValue$p2.intValue() : 0) == 0 || ((access$getDiabetesTypeValue$p = this.this$0.diabetesTypeValue) != null && access$getDiabetesTypeValue$p.intValue() == -1)) {
            this.this$0.diagnosisDate = "";
            this.this$0.complications = "";
            this.this$0.complicationsDisplayName = "";
            this.this$0.treatment = "";
            this.this$0.treatmentDisplayName = "";
            this.this$0.setProfileUi();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<MenuEntity>) (List) obj);
        return Unit.INSTANCE;
    }
}
