package com.microtech.aidexx.ui.main.trend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.main.trend.view.DotView;
import com.microtech.aidexx.utils.ThemeManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001(B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0013H\u0007J\b\u0010\u0019\u001a\u00020\u0013H\u0007J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u0012\u001a\u00020\u0011J\u001c\u0010\u001d\u001a\u00020\u00132\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001cH\u0017J\u001c\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0017J\u0014\u0010$\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u0013J\u0006\u0010'\u001a\u00020\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000RR\u0010\f\u001a:\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/MultiDateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/microtech/aidexx/ui/main/trend/MultiDateAdapter$MultiDateViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "listOfAll", "", "Lcom/microtech/aidexx/ui/main/trend/MultiDayBgItem;", "listToShow", "onDataSetChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "list", "", "isAllChecked", "", "getOnDataSetChange", "()Lkotlin/jvm/functions/Function2;", "setOnDataSetChange", "(Lkotlin/jvm/functions/Function2;)V", "contract", "expand", "getDataSet", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshData", "selectAll", "selectDefault", "unselectAll", "MultiDateViewHolder", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MultiDateAdapter.kt */
public final class MultiDateAdapter extends RecyclerView.Adapter<MultiDateViewHolder> {
    private final Context context;
    private final List<MultiDayBgItem> listOfAll = new ArrayList();
    private final List<MultiDayBgItem> listToShow = new ArrayList();
    private Function2<? super List<MultiDayBgItem>, ? super Boolean, Unit> onDataSetChange;

    public final Context getContext() {
        return this.context;
    }

    public MultiDateAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Function2<List<MultiDayBgItem>, Boolean, Unit> getOnDataSetChange() {
        return this.onDataSetChange;
    }

    public final void setOnDataSetChange(Function2<? super List<MultiDayBgItem>, ? super Boolean, Unit> function2) {
        this.onDataSetChange = function2;
    }

    public MultiDateViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.multi_day_bg_date_item, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate);
        return new MultiDateViewHolder(this, inflate);
    }

    public void onBindViewHolder(MultiDateViewHolder multiDateViewHolder, int i) {
        Intrinsics.checkNotNullParameter(multiDateViewHolder, "holder");
        MultiDayBgItem multiDayBgItem = this.listToShow.get(i);
        multiDateViewHolder.getDateItem().setText(new SimpleDateFormat(this.context.getString(R.string.com_dateFormat_MMdd), Locale.getDefault()).format(multiDayBgItem.getDateDesc()));
        if (multiDayBgItem.getChecked()) {
            multiDateViewHolder.getDateItem().setTextColor(ContextCompat.getColor(this.context, ThemeManager.INSTANCE.isLight() ? R.color.black_33 : R.color.white));
            multiDateViewHolder.getDotView().changeColor(multiDayBgItem.getColor());
        } else {
            multiDateViewHolder.getDateItem().setTextColor(ContextCompat.getColor(this.context, R.color.gray_cc));
            multiDateViewHolder.getDotView().changeColor(ContextCompat.getColor(this.context, R.color.gray_cc));
        }
        multiDateViewHolder.getClItem().setOnClickListener(new MultiDateAdapter$$ExternalSyntheticLambda0(multiDayBgItem, this, i));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(MultiDayBgItem multiDayBgItem, MultiDateAdapter multiDateAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(multiDayBgItem, "$item");
        Intrinsics.checkNotNullParameter(multiDateAdapter, "this$0");
        boolean z = true;
        multiDayBgItem.setChecked(!multiDayBgItem.getChecked());
        multiDateAdapter.notifyItemChanged(i);
        Function1 function1 = MultiDateAdapter$onBindViewHolder$1$predicate$1.INSTANCE;
        Collection arrayList = new ArrayList();
        for (Object next : multiDateAdapter.listOfAll) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                arrayList.add(next);
            }
        }
        List mutableList = CollectionsKt.toMutableList((List) arrayList);
        Function2<? super List<MultiDayBgItem>, ? super Boolean, Unit> function2 = multiDateAdapter.onDataSetChange;
        if (function2 != null) {
            if (mutableList.size() != multiDateAdapter.listOfAll.size()) {
                z = false;
            }
            function2.invoke(mutableList, Boolean.valueOf(z));
        }
    }

    public final List<MultiDayBgItem> getDataSet() {
        Function1 function1 = MultiDateAdapter$getDataSet$predicate$1.INSTANCE;
        Collection arrayList = new ArrayList();
        for (Object next : this.listOfAll) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                arrayList.add(next);
            }
        }
        return CollectionsKt.toMutableList((List) arrayList);
    }

    public final boolean isAllChecked() {
        return getDataSet().size() == this.listOfAll.size();
    }

    public int getItemCount() {
        return this.listToShow.size();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/MultiDateAdapter$MultiDateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/microtech/aidexx/ui/main/trend/MultiDateAdapter;Landroid/view/View;)V", "clItem", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClItem", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "dateItem", "Landroid/widget/TextView;", "getDateItem", "()Landroid/widget/TextView;", "dotView", "Lcom/microtech/aidexx/ui/main/trend/view/DotView;", "getDotView", "()Lcom/microtech/aidexx/ui/main/trend/view/DotView;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MultiDateAdapter.kt */
    public final class MultiDateViewHolder extends RecyclerView.ViewHolder {
        private final ConstraintLayout clItem;
        private final TextView dateItem;
        private final DotView dotView;
        final /* synthetic */ MultiDateAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MultiDateViewHolder(MultiDateAdapter multiDateAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = multiDateAdapter;
            View findViewById = view.findViewById(R.id.date_item);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.dateItem = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.dot_view);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.dotView = (DotView) findViewById2;
            View findViewById3 = view.findViewById(R.id.cl_item);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.clItem = (ConstraintLayout) findViewById3;
        }

        public final TextView getDateItem() {
            return this.dateItem;
        }

        public final DotView getDotView() {
            return this.dotView;
        }

        public final ConstraintLayout getClItem() {
            return this.clItem;
        }
    }

    public final void refreshData(List<MultiDayBgItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.listOfAll.clear();
        this.listOfAll.addAll(list);
        contract();
    }

    public final void contract() {
        if (this.listOfAll.size() < 15) {
            this.listToShow.clear();
            this.listToShow.addAll(this.listOfAll);
            notifyDataSetChanged();
            return;
        }
        this.listToShow.clear();
        this.listToShow.addAll(this.listOfAll.subList(0, 15));
        notifyDataSetChanged();
    }

    public final void expand() {
        this.listToShow.clear();
        this.listToShow.addAll(this.listOfAll);
        notifyDataSetChanged();
    }

    public final void selectAll() {
        int i = 0;
        for (MultiDayBgItem next : this.listOfAll) {
            int i2 = i + 1;
            if (!next.getChecked()) {
                next.setChecked(true);
                notifyItemChanged(i);
            }
            i = i2;
        }
        Function2<? super List<MultiDayBgItem>, ? super Boolean, Unit> function2 = this.onDataSetChange;
        if (function2 != null) {
            function2.invoke(this.listOfAll, true);
        }
    }

    public final void unselectAll() {
        int i = 0;
        for (MultiDayBgItem next : this.listOfAll) {
            int i2 = i + 1;
            if (next.getChecked()) {
                next.setChecked(false);
                notifyItemChanged(i);
            }
            i = i2;
        }
        Function2<? super List<MultiDayBgItem>, ? super Boolean, Unit> function2 = this.onDataSetChange;
        if (function2 != null) {
            function2.invoke(new ArrayList(), false);
        }
    }

    public final void selectDefault() {
        if (this.listOfAll.size() <= 15) {
            selectAll();
            return;
        }
        int i = 0;
        for (MultiDayBgItem next : this.listOfAll) {
            int i2 = i + 1;
            if (i < 15) {
                if (!next.getChecked()) {
                    next.setChecked(true);
                    notifyItemChanged(i);
                }
            } else if (next.getChecked()) {
                next.setChecked(false);
                notifyItemChanged(i);
            }
            i = i2;
        }
        Function2<? super List<MultiDayBgItem>, ? super Boolean, Unit> function2 = this.onDataSetChange;
        if (function2 != null) {
            function2.invoke(getDataSet(), false);
        }
    }
}
