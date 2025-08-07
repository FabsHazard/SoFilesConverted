package com.microtech.aidexx.ui.setting.profile.health;

import com.microtech.aidexx.common.net.entity.MenuEntity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/microtech/aidexx/common/net/entity/MenuEntity;", "invoke", "(Lcom/microtech/aidexx/common/net/entity/MenuEntity;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtherDiseaseActivity.kt */
final class OtherDiseaseActivity$initEvent$1$2$1 extends Lambda implements Function1<MenuEntity, Boolean> {
    public static final OtherDiseaseActivity$initEvent$1$2$1 INSTANCE = new OtherDiseaseActivity$initEvent$1$2$1();

    OtherDiseaseActivity$initEvent$1$2$1() {
        super(1);
    }

    public final Boolean invoke(MenuEntity menuEntity) {
        Intrinsics.checkNotNullParameter(menuEntity, "it");
        return Boolean.valueOf(!menuEntity.getCheck() && menuEntity.getDictionaryId() == null);
    }
}
