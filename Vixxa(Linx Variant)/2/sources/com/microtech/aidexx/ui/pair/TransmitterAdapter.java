package com.microtech.aidexx.ui.pair;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.ItemTransmitterBinding;
import com.microtech.aidexx.databinding.ItemTransmitterFooterBinding;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000212B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0016J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00022\u0006\u0010'\u001a\u00020%H\u0016J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020%H\u0016J\u0016\u0010.\u001a\u00020\u00172\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001300H\u0007R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0004¢\u0006\u0002\n\u0000R7\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR7\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f¨\u00063"}, d2 = {"Lcom/microtech/aidexx/ui/pair/TransmitterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "canShowMore", "getCanShowMore", "()Z", "setCanShowMore", "(Z)V", "getContext", "()Landroid/content/Context;", "isShowingMore", "setShowingMore", "mList", "", "Lcom/microtechmd/blecomm/controller/BleControllerProxy;", "mOnClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "onPairClick", "Lkotlin/ParameterName;", "name", "item", "getOnPairClick", "()Lkotlin/jvm/functions/Function1;", "setOnPairClick", "(Lkotlin/jvm/functions/Function1;)V", "onShowMoreClick", "isCheck", "getOnShowMoreClick", "setOnShowMoreClick", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshData", "list", "", "TransmitterFooterViewHolder", "TransmitterViewHolder", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterAdapter.kt */
public final class TransmitterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private boolean canShowMore;
    private final Context context;
    private boolean isShowingMore;
    /* access modifiers changed from: private */
    public List<BleControllerProxy> mList = new ArrayList();
    private final Function1<View, Unit> mOnClickListener = new TransmitterAdapter$mOnClickListener$1(this);
    private Function1<? super BleControllerProxy, Unit> onPairClick;
    private Function1<? super Boolean, Unit> onShowMoreClick;

    public TransmitterAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function1<BleControllerProxy, Unit> getOnPairClick() {
        return this.onPairClick;
    }

    public final void setOnPairClick(Function1<? super BleControllerProxy, Unit> function1) {
        this.onPairClick = function1;
    }

    public final Function1<Boolean, Unit> getOnShowMoreClick() {
        return this.onShowMoreClick;
    }

    public final void setOnShowMoreClick(Function1<? super Boolean, Unit> function1) {
        this.onShowMoreClick = function1;
    }

    public final boolean getCanShowMore() {
        return this.canShowMore;
    }

    public final void setCanShowMore(boolean z) {
        if (z != this.canShowMore) {
            notifyItemChanged(getItemCount() - 1);
        }
        this.canShowMore = z;
    }

    public final boolean isShowingMore() {
        return this.isShowingMore;
    }

    public final void setShowingMore(boolean z) {
        this.isShowingMore = z;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/ui/pair/TransmitterAdapter$TransmitterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/microtech/aidexx/ui/pair/TransmitterAdapter;Landroid/view/View;)V", "bind", "Lcom/microtech/aidexx/databinding/ItemTransmitterBinding;", "getBind", "()Lcom/microtech/aidexx/databinding/ItemTransmitterBinding;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TransmitterAdapter.kt */
    public final class TransmitterViewHolder extends RecyclerView.ViewHolder {
        private final ItemTransmitterBinding bind;
        final /* synthetic */ TransmitterAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransmitterViewHolder(TransmitterAdapter transmitterAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = transmitterAdapter;
            ItemTransmitterBinding bind2 = ItemTransmitterBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind2, "bind(...)");
            this.bind = bind2;
        }

        public final ItemTransmitterBinding getBind() {
            return this.bind;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/ui/pair/TransmitterAdapter$TransmitterFooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/microtech/aidexx/ui/pair/TransmitterAdapter;Landroid/view/View;)V", "bind", "Lcom/microtech/aidexx/databinding/ItemTransmitterFooterBinding;", "getBind", "()Lcom/microtech/aidexx/databinding/ItemTransmitterFooterBinding;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TransmitterAdapter.kt */
    public final class TransmitterFooterViewHolder extends RecyclerView.ViewHolder {
        private final ItemTransmitterFooterBinding bind;
        final /* synthetic */ TransmitterAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransmitterFooterViewHolder(TransmitterAdapter transmitterAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = transmitterAdapter;
            ItemTransmitterFooterBinding bind2 = ItemTransmitterFooterBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind2, "bind(...)");
            this.bind = bind2;
        }

        public final ItemTransmitterFooterBinding getBind() {
            return this.bind;
        }
    }

    public int getItemViewType(int i) {
        return (!this.canShowMore || i != getItemCount() - 1) ? 1 : 2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        if (i == 2) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_transmitter_footer, (ViewGroup) null);
            inflate.setLayoutParams(layoutParams);
            Intrinsics.checkNotNull(inflate);
            return new TransmitterFooterViewHolder(this, inflate);
        }
        View inflate2 = LayoutInflater.from(this.context).inflate(R.layout.item_transmitter, (ViewGroup) null);
        inflate2.setLayoutParams(layoutParams);
        Intrinsics.checkNotNull(inflate2);
        TransmitterViewHolder transmitterViewHolder = new TransmitterViewHolder(this, inflate2);
        transmitterViewHolder.getBind().transItem.setTag(transmitterViewHolder);
        transmitterViewHolder.getBind().transItem.setOnClickListener(new TransmitterAdapter$$ExternalSyntheticLambda0(this.mOnClickListener));
        return transmitterViewHolder;
    }

    /* access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$0(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(view);
    }

    public int getItemCount() {
        return this.canShowMore ? this.mList.size() + 1 : this.mList.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        Context context2;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof TransmitterViewHolder) {
            if (!this.mList.isEmpty()) {
                TransmitterViewHolder transmitterViewHolder = (TransmitterViewHolder) viewHolder;
                TextView textView = transmitterViewHolder.getBind().tvSn;
                StringBuilder sb = new StringBuilder();
                sb.append(this.mList.get(i).getName() + Soundex.SILENT_MARKER);
                sb.append(this.mList.get(i).getSn());
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                textView.setText(sb2);
                TextView textView2 = transmitterViewHolder.getBind().tvTransPairState;
                Intrinsics.checkNotNullExpressionValue(textView2, "tvTransPairState");
                textView2.setVisibility(8);
            }
        } else if (viewHolder instanceof TransmitterFooterViewHolder) {
            TransmitterFooterViewHolder transmitterFooterViewHolder = (TransmitterFooterViewHolder) viewHolder;
            CheckBox checkBox = transmitterFooterViewHolder.getBind().cbMoreDevice;
            if (this.isShowingMore) {
                context2 = this.context;
                i2 = R.string.ble_pairList_nearby_hideMore;
            } else {
                context2 = this.context;
                i2 = R.string.ble_pairList_nearby_showMore;
            }
            checkBox.setText(context2.getString(i2));
            transmitterFooterViewHolder.getBind().cbMoreDevice.setOnCheckedChangeListener(new TransmitterAdapter$$ExternalSyntheticLambda1(this, viewHolder));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(TransmitterAdapter transmitterAdapter, RecyclerView.ViewHolder viewHolder, CompoundButton compoundButton, boolean z) {
        Context context2;
        int i;
        Intrinsics.checkNotNullParameter(transmitterAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        transmitterAdapter.isShowingMore = z;
        CheckBox checkBox = ((TransmitterFooterViewHolder) viewHolder).getBind().cbMoreDevice;
        if (transmitterAdapter.isShowingMore) {
            context2 = transmitterAdapter.context;
            i = R.string.ble_pairList_nearby_hideMore;
        } else {
            context2 = transmitterAdapter.context;
            i = R.string.ble_pairList_nearby_showMore;
        }
        checkBox.setText(context2.getString(i));
        Function1<? super Boolean, Unit> function1 = transmitterAdapter.onShowMoreClick;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
    }

    public final void refreshData(List<? extends BleControllerProxy> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil(this.mList, list));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(...)");
        this.mList.clear();
        this.mList.addAll(list);
        calculateDiff.dispatchUpdatesTo((RecyclerView.Adapter) this);
    }
}
