package com.microtech.aidexx.ui.setting.profile.health;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.DialogMenuListBinding;
import com.microtech.aidexx.ui.setting.profile.health.MenuCheckItem;
import com.microtech.aidexx.views.dialog.bottom.BaseBottomDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003BJ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012'\u0010\n\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0002\u0010\u0011J\u0012\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\tH\u0002J\u0014\u0010*\u001a\u00020\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\fJ\f\u0010,\u001a\u00020\u0010*\u00020 H\u0002R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR2\u0010\n\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006-"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/health/MenuListDialog;", "T", "Lcom/microtech/aidexx/ui/setting/profile/health/MenuCheckItem;", "Lcom/microtech/aidexx/views/dialog/bottom/BaseBottomDialog;", "myContext", "Landroid/content/Context;", "dialogTitle", "", "multiSelectEnable", "", "onConfirmClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "selectData", "", "(Landroid/content/Context;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "data", "getDialogTitle", "()Ljava/lang/String;", "setDialogTitle", "(Ljava/lang/String;)V", "menuListAdapter", "Lcom/microtech/aidexx/ui/setting/profile/health/MenuListAdapter;", "getMultiSelectEnable", "()Z", "setMultiSelectEnable", "(Z)V", "getOnConfirmClick", "()Lkotlin/jvm/functions/Function1;", "viewBinding", "Lcom/microtech/aidexx/databinding/DialogMenuListBinding;", "getViewBinding", "()Lcom/microtech/aidexx/databinding/DialogMenuListBinding;", "setViewBinding", "(Lcom/microtech/aidexx/databinding/DialogMenuListBinding;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setAdapterCheckChange", "value", "setData", "newData", "initView", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MenuListDialog.kt */
public final class MenuListDialog<T extends MenuCheckItem> extends BaseBottomDialog {
    private final List<T> data;
    private String dialogTitle;
    /* access modifiers changed from: private */
    public final MenuListAdapter<T> menuListAdapter;
    private boolean multiSelectEnable;
    private final Function1<List<T>, Unit> onConfirmClick;
    public DialogMenuListBinding viewBinding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MenuListDialog(Context context, String str, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? true : z, function1);
    }

    public final String getDialogTitle() {
        return this.dialogTitle;
    }

    public final void setDialogTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dialogTitle = str;
    }

    public final boolean getMultiSelectEnable() {
        return this.multiSelectEnable;
    }

    public final void setMultiSelectEnable(boolean z) {
        this.multiSelectEnable = z;
    }

    public final Function1<List<T>, Unit> getOnConfirmClick() {
        return this.onConfirmClick;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuListDialog(Context context, String str, boolean z, Function1<? super List<T>, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "myContext");
        Intrinsics.checkNotNullParameter(str, "dialogTitle");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        this.dialogTitle = str;
        this.multiSelectEnable = z;
        this.onConfirmClick = function1;
        List<T> arrayList = new ArrayList<>();
        this.data = arrayList;
        this.menuListAdapter = new MenuListAdapter<>(arrayList);
    }

    private final void setAdapterCheckChange(boolean z) {
        if (z) {
            this.menuListAdapter.setOnCheckChange(new MenuListDialog$setAdapterCheckChange$1(this));
        } else {
            this.menuListAdapter.setOnCheckChange(new MenuListDialog$setAdapterCheckChange$2(this));
        }
    }

    public final DialogMenuListBinding getViewBinding() {
        DialogMenuListBinding dialogMenuListBinding = this.viewBinding;
        if (dialogMenuListBinding != null) {
            return dialogMenuListBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        return null;
    }

    public final void setViewBinding(DialogMenuListBinding dialogMenuListBinding) {
        Intrinsics.checkNotNullParameter(dialogMenuListBinding, "<set-?>");
        this.viewBinding = dialogMenuListBinding;
    }

    public final void setData(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "newData");
        this.data.clear();
        this.data.addAll(list);
        if (this.viewBinding != null) {
            this.menuListAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogMenuListBinding inflate = DialogMenuListBinding.inflate(getLayoutInflater());
        setContentView(inflate.getRoot());
        Intrinsics.checkNotNull(inflate);
        initView(inflate);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.windowAnimations = 16973910;
        }
    }

    private final void initView(DialogMenuListBinding dialogMenuListBinding) {
        CharSequence charSequence;
        dialogMenuListBinding.rvMenuList.setLayoutManager(new LinearLayoutManager(getContext()));
        dialogMenuListBinding.rvMenuList.setAdapter(this.menuListAdapter);
        dialogMenuListBinding.btnCancel.setOnClickListener(new MenuListDialog$$ExternalSyntheticLambda0(this));
        dialogMenuListBinding.btnOk.setOnClickListener(new MenuListDialog$$ExternalSyntheticLambda1(this));
        setAdapterCheckChange(this.multiSelectEnable);
        TextView textView = dialogMenuListBinding.tvMultiSelectEnable;
        if (this.multiSelectEnable) {
            charSequence = getContext().getString(R.string.com_selection_mul);
        } else {
            charSequence = getContext().getString(R.string.com_selection_single);
        }
        textView.setText(charSequence);
        dialogMenuListBinding.tvTitleName.setText(this.dialogTitle);
        dialogMenuListBinding.btnCancel.setText(getContext().getString(R.string.com_action_cancel));
        dialogMenuListBinding.btnOk.setText(getContext().getString(R.string.com_action_sure));
        dialogMenuListBinding.viWhiteSpace.setOnClickListener(new MenuListDialog$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(MenuListDialog menuListDialog, View view) {
        Intrinsics.checkNotNullParameter(menuListDialog, "this$0");
        menuListDialog.cancel();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(MenuListDialog menuListDialog, View view) {
        Intrinsics.checkNotNullParameter(menuListDialog, "this$0");
        menuListDialog.cancel();
        Function1<List<T>, Unit> function1 = menuListDialog.onConfirmClick;
        Collection arrayList = new ArrayList();
        for (Object next : menuListDialog.data) {
            if (((MenuCheckItem) next).getCheck()) {
                arrayList.add(next);
            }
        }
        function1.invoke(CollectionsKt.toMutableList((List) arrayList));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$4(MenuListDialog menuListDialog, View view) {
        Intrinsics.checkNotNullParameter(menuListDialog, "this$0");
        menuListDialog.cancel();
    }
}
