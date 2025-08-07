package com.microtech.aidexx.ui.setting.profile.health;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.ui.setting.profile.health.MenuCheckItem;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0017RL\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/health/MenuListAdapter;", "T", "Lcom/microtech/aidexx/ui/setting/profile/health/MenuCheckItem;", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "onCheckChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "", "getOnCheckChange", "()Lkotlin/jvm/functions/Function2;", "setOnCheckChange", "(Lkotlin/jvm/functions/Function2;)V", "convert", "", "holder", "item", "(Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;Lcom/microtech/aidexx/ui/setting/profile/health/MenuCheckItem;)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MenuListAdapter.kt */
public final class MenuListAdapter<T extends MenuCheckItem> extends BaseQuickAdapter<T, BaseViewHolder> {
    private Function2<? super Integer, ? super T, Boolean> onCheckChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuListAdapter(List<T> list) {
        super(R.layout.item_check_menu, list);
        Intrinsics.checkNotNullParameter(list, "data");
    }

    public final Function2<Integer, T, Boolean> getOnCheckChange() {
        return this.onCheckChange;
    }

    public final void setOnCheckChange(Function2<? super Integer, ? super T, Boolean> function2) {
        this.onCheckChange = function2;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, T t) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(t, "item");
        baseViewHolder.setText(R.id.tvItemName, (CharSequence) t.getItemName());
        CheckBox checkBox = (CheckBox) baseViewHolder.getView(R.id.cbItem);
        checkBox.setOnCheckedChangeListener(new MenuListAdapter$$ExternalSyntheticLambda0(t, this, baseViewHolder, checkBox));
        View view = baseViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        ExtendsKt.setDebounceClickListener$default(view, 0, new MenuListAdapter$$ExternalSyntheticLambda1(checkBox), 1, (Object) null);
        checkBox.setChecked(t.getCheck());
        int i = R.id.viDivider;
        boolean z = true;
        if (baseViewHolder.getAdapterPosition() != getData().size() - 1) {
            z = false;
        }
        baseViewHolder.setGone(i, z);
    }

    /* access modifiers changed from: private */
    public static final void convert$lambda$2$lambda$0(MenuCheckItem menuCheckItem, MenuListAdapter menuListAdapter, BaseViewHolder baseViewHolder, CheckBox checkBox, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(menuCheckItem, "$item");
        Intrinsics.checkNotNullParameter(menuListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseViewHolder, "$this_apply");
        Intrinsics.checkNotNullParameter(checkBox, "$cbItem");
        if (menuCheckItem.getCheck() != z) {
            Function2<? super Integer, ? super T, Boolean> function2 = menuListAdapter.onCheckChange;
            if (function2 == null || function2.invoke(Integer.valueOf(baseViewHolder.getAdapterPosition()), menuCheckItem).booleanValue()) {
                menuCheckItem.setCheck(z);
            } else {
                checkBox.setChecked(!z);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void convert$lambda$2$lambda$1(CheckBox checkBox, View view) {
        Intrinsics.checkNotNullParameter(checkBox, "$cbItem");
        checkBox.toggle();
    }
}
