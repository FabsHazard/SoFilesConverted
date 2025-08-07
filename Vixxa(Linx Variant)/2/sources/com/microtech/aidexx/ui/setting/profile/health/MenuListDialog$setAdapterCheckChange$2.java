package com.microtech.aidexx.ui.setting.profile.health;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/ui/setting/profile/health/MenuCheckItem;", "position", "", "item", "invoke", "(ILcom/microtech/aidexx/ui/setting/profile/health/MenuCheckItem;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: MenuListDialog.kt */
final class MenuListDialog$setAdapterCheckChange$2 extends Lambda implements Function2<Integer, T, Boolean> {
    final /* synthetic */ MenuListDialog<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MenuListDialog$setAdapterCheckChange$2(MenuListDialog<T> menuListDialog) {
        super(2);
        this.this$0 = menuListDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (MenuCheckItem) obj2);
    }

    public final Boolean invoke(int i, T t) {
        Intrinsics.checkNotNullParameter(t, "item");
        boolean z = false;
        if (!((MenuCheckItem) this.this$0.menuListAdapter.getData().get(i)).getCheck()) {
            MenuListDialog<T> menuListDialog = this.this$0;
            int i2 = 0;
            for (Object next : this.this$0.menuListAdapter.getData()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                MenuCheckItem menuCheckItem = (MenuCheckItem) next;
                if (i2 != i) {
                    menuCheckItem.setCheck(false);
                    menuListDialog.menuListAdapter.notifyItemChanged(i2);
                }
                i2 = i3;
            }
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
