package com.microtech.aidexx.ui.setting.profile.health;

import com.microtech.aidexx.common.net.entity.MenuEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "data", "Lcom/microtech/aidexx/common/net/entity/MenuEntity;", "invoke", "(ILcom/microtech/aidexx/common/net/entity/MenuEntity;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtherDiseaseActivity.kt */
final class OtherDiseaseActivity$initView$2 extends Lambda implements Function2<Integer, MenuEntity, Boolean> {
    final /* synthetic */ OtherDiseaseActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtherDiseaseActivity$initView$2(OtherDiseaseActivity otherDiseaseActivity) {
        super(2);
        this.this$0 = otherDiseaseActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (MenuEntity) obj2);
    }

    public final Boolean invoke(int i, MenuEntity menuEntity) {
        Intrinsics.checkNotNullParameter(menuEntity, "data");
        if (!menuEntity.getCheck()) {
            if (menuEntity.isExclusive()) {
                this.this$0.uncheckedData.addAll(this.this$0.checkedData);
                this.this$0.checkedData.clear();
                for (MenuEntity menuEntity2 : this.this$0.otherDiseaseAdapter.getData()) {
                    menuEntity2.setCheck(Intrinsics.areEqual((Object) menuEntity2, (Object) menuEntity));
                }
                this.this$0.otherDiseaseAdapter.notifyDataSetChanged();
            } else {
                OtherDiseaseActivity otherDiseaseActivity = this.this$0;
                boolean z = false;
                for (MenuEntity menuEntity3 : this.this$0.otherDiseaseAdapter.getData()) {
                    if (menuEntity3.isExclusive()) {
                        otherDiseaseActivity.checkedData.remove(menuEntity3);
                        if (!otherDiseaseActivity.uncheckedData.contains(menuEntity3)) {
                            otherDiseaseActivity.uncheckedData.add(menuEntity3);
                        }
                        menuEntity3.setCheck(false);
                        z = true;
                    }
                }
                this.this$0.otherDiseaseAdapter.notifyDataSetChanged();
                if (!z) {
                    OtherDiseaseActivity otherDiseaseActivity2 = this.this$0;
                    for (MenuEntity menuEntity4 : this.this$0.checkedData) {
                        if (menuEntity4.isExclusive()) {
                            otherDiseaseActivity2.checkedData.remove(menuEntity4);
                            if (!otherDiseaseActivity2.uncheckedData.contains(menuEntity4)) {
                                otherDiseaseActivity2.uncheckedData.add(menuEntity4);
                            }
                            menuEntity4.setCheck(false);
                        }
                    }
                }
            }
            if (!this.this$0.checkedData.contains(menuEntity)) {
                this.this$0.checkedData.add(menuEntity);
            }
            this.this$0.uncheckedData.remove(menuEntity);
        } else {
            this.this$0.checkedData.remove(menuEntity);
            String dictionaryId = menuEntity.getDictionaryId();
            if (dictionaryId == null || dictionaryId.length() != 32) {
                if (!this.this$0.uncheckedData.contains(menuEntity)) {
                    this.this$0.uncheckedData.add(menuEntity);
                }
                List access$getUncheckedData$p = this.this$0.uncheckedData;
                if (access$getUncheckedData$p.size() > 1) {
                    CollectionsKt.sortWith(access$getUncheckedData$p, new OtherDiseaseActivity$initView$2$invoke$$inlined$sortBy$1());
                }
            }
        }
        return true;
    }
}
