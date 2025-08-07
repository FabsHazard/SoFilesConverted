package com.microtech.aidexx.ui.main.trend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.LayoutExpandableGridBinding;
import com.microtech.aidexx.ui.main.trend.MultiDateAdapter;
import com.microtech.aidexx.ui.main.trend.MultiDayBgItem;
import com.microtech.aidexx.utils.ThemeManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\u0014\u0010$\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R=\u0010\u000f\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/view/ExpandableGrid;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentDataState", "currentState", "multiDateAdapter", "Lcom/microtech/aidexx/ui/main/trend/MultiDateAdapter;", "onDataChange", "Lkotlin/Function1;", "", "Lcom/microtech/aidexx/ui/main/trend/MultiDayBgItem;", "Lkotlin/ParameterName;", "name", "list", "", "getOnDataChange", "()Lkotlin/jvm/functions/Function1;", "setOnDataChange", "(Lkotlin/jvm/functions/Function1;)V", "vb", "Lcom/microtech/aidexx/databinding/LayoutExpandableGridBinding;", "getVb", "()Lcom/microtech/aidexx/databinding/LayoutExpandableGridBinding;", "setVb", "(Lcom/microtech/aidexx/databinding/LayoutExpandableGridBinding;)V", "executeContract", "getDataSet", "init", "refreshData", "switchOff", "switchOn", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ExpandableGrid.kt */
public final class ExpandableGrid extends ConstraintLayout {
    private int currentDataState;
    private int currentState;
    private MultiDateAdapter multiDateAdapter;
    private Function1<? super List<MultiDayBgItem>, Unit> onDataChange;
    public LayoutExpandableGridBinding vb;

    public final Function1<List<MultiDayBgItem>, Unit> getOnDataChange() {
        return this.onDataChange;
    }

    public final void setOnDataChange(Function1<? super List<MultiDayBgItem>, Unit> function1) {
        this.onDataChange = function1;
    }

    public final LayoutExpandableGridBinding getVb() {
        LayoutExpandableGridBinding layoutExpandableGridBinding = this.vb;
        if (layoutExpandableGridBinding != null) {
            return layoutExpandableGridBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vb");
        return null;
    }

    public final void setVb(LayoutExpandableGridBinding layoutExpandableGridBinding) {
        Intrinsics.checkNotNullParameter(layoutExpandableGridBinding, "<set-?>");
        this.vb = layoutExpandableGridBinding;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExpandableGrid(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExpandableGrid(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandableGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentState = 1;
        this.currentDataState = 4;
        init(context);
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutExpandableGridBinding bind = LayoutExpandableGridBinding.bind(((LayoutInflater) systemService).inflate(R.layout.layout_expandable_grid, this, true));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        setVb(bind);
        getVb().rvDates.setLayoutManager(new GridLayoutManager(context, 3));
        this.multiDateAdapter = new MultiDateAdapter(context);
        getVb().rvDates.setAdapter(this.multiDateAdapter);
        getVb().stateSwitch.setOnClickListener(new ExpandableGrid$$ExternalSyntheticLambda0(this, context));
        MultiDateAdapter multiDateAdapter2 = this.multiDateAdapter;
        if (multiDateAdapter2 != null) {
            multiDateAdapter2.setOnDataSetChange(new ExpandableGrid$init$2(this, context));
        }
        getVb().btSelectAll.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_bt_unchecked));
        getVb().btSelectAll.setOnClickListener(new ExpandableGrid$$ExternalSyntheticLambda1(this, context));
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$0(ExpandableGrid expandableGrid, Context context, View view) {
        Intrinsics.checkNotNullParameter(expandableGrid, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (expandableGrid.currentState == 1) {
            MultiDateAdapter multiDateAdapter2 = expandableGrid.multiDateAdapter;
            if (multiDateAdapter2 != null) {
                multiDateAdapter2.expand();
            }
            expandableGrid.currentState = 2;
            expandableGrid.getVb().stateSwitch.setRotation(180.0f);
            return;
        }
        expandableGrid.executeContract(context);
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$1(ExpandableGrid expandableGrid, Context context, View view) {
        Intrinsics.checkNotNullParameter(expandableGrid, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (expandableGrid.currentDataState == 4) {
            expandableGrid.switchOn(context);
            MultiDateAdapter multiDateAdapter2 = expandableGrid.multiDateAdapter;
            if (multiDateAdapter2 != null) {
                multiDateAdapter2.selectAll();
                return;
            }
            return;
        }
        expandableGrid.switchOff(context);
        MultiDateAdapter multiDateAdapter3 = expandableGrid.multiDateAdapter;
        if (multiDateAdapter3 != null) {
            multiDateAdapter3.unselectAll();
        }
    }

    private final void executeContract(Context context) {
        MultiDateAdapter multiDateAdapter2 = this.multiDateAdapter;
        if (multiDateAdapter2 != null) {
            multiDateAdapter2.contract();
        }
        this.currentState = 1;
        getVb().stateSwitch.setRotation(0.0f);
    }

    /* access modifiers changed from: private */
    public final void switchOff(Context context) {
        getVb().btSelectAll.setTextColor(ContextCompat.getColor(context, ThemeManager.INSTANCE.isLight() ? R.color.light_colorAccent : R.color.colorAccent));
        getVb().btSelectAll.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_bt_unchecked));
        this.currentDataState = 4;
    }

    /* access modifiers changed from: private */
    public final void switchOn(Context context) {
        getVb().btSelectAll.setTextColor(ContextCompat.getColor(context, R.color.white));
        getVb().btSelectAll.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_bt_checked));
        this.currentDataState = 3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getDataSet();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.microtech.aidexx.ui.main.trend.MultiDayBgItem> getDataSet() {
        /*
            r1 = this;
            com.microtech.aidexx.ui.main.trend.MultiDateAdapter r0 = r1.multiDateAdapter
            if (r0 == 0) goto L_0x000a
            java.util.List r0 = r0.getDataSet()
            if (r0 != 0) goto L_0x0011
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.view.ExpandableGrid.getDataSet():java.util.List");
    }

    public final void refreshData(List<MultiDayBgItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!((MultiDayBgItem) next).getChecked()) {
                arrayList.add(next);
            }
        }
        if (((List) arrayList).isEmpty()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            switchOn(context);
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            switchOff(context2);
        }
        MultiDateAdapter multiDateAdapter2 = this.multiDateAdapter;
        if (multiDateAdapter2 != null) {
            multiDateAdapter2.refreshData(list);
        }
        MultiDateAdapter multiDateAdapter3 = this.multiDateAdapter;
        if (multiDateAdapter3 != null) {
            multiDateAdapter3.selectDefault();
        }
        if (list.size() <= 15) {
            getVb().stateSwitch.setVisibility(8);
            getVb().edgeWithoutArrow.setVisibility(0);
        } else {
            getVb().stateSwitch.setVisibility(0);
            getVb().edgeWithoutArrow.setVisibility(8);
        }
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        executeContract(context3);
    }
}
