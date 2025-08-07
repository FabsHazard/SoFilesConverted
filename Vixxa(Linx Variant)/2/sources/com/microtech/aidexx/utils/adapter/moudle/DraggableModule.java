package com.microtech.aidexx.utils.adapter.moudle;

import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/moudle/DraggableModule;", "", "addDraggableModule", "Lcom/microtech/aidexx/utils/adapter/moudle/BaseDraggableModule;", "baseQuickAdapter", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DraggableModule.kt */
public interface DraggableModule {
    BaseDraggableModule addDraggableModule(BaseQuickAdapter<?, ?> baseQuickAdapter);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DraggableModule.kt */
    public static final class DefaultImpls {
        public static BaseDraggableModule addDraggableModule(DraggableModule draggableModule, BaseQuickAdapter<?, ?> baseQuickAdapter) {
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "baseQuickAdapter");
            return new BaseDraggableModule(baseQuickAdapter);
        }
    }
}
