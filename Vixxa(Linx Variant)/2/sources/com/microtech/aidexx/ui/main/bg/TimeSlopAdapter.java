package com.microtech.aidexx.ui.main.bg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.ThemeManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0011J\b\u0010\u0017\u001a\u00020\rH\u0016J\u001c\u0010\u0018\u001a\u00020\u00112\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\rH\u0017J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R7\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/microtech/aidexx/ui/main/bg/TimeSlopAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/microtech/aidexx/ui/main/bg/TimeSlopAdapter$TimeSlopViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mList", "", "Lcom/microtech/aidexx/ui/main/bg/TimeSlotInfo;", "onSelect", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getOnSelect", "()Lkotlin/jvm/functions/Function1;", "setOnSelect", "(Lkotlin/jvm/functions/Function1;)V", "clearCheck", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "TimeSlopViewHolder", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeSlopAdapter.kt */
public final class TimeSlopAdapter extends RecyclerView.Adapter<TimeSlopViewHolder> {
    private final Context context;
    private final List<TimeSlotInfo> mList;
    private Function1<? super Integer, Unit> onSelect;

    public TimeSlopAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        String string = context2.getString(R.string.glucose_slot_emptyStomach);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context2.getString(R.string.glucose_slot_afterBreakfast);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context2.getString(R.string.glucose_slot_beforeLunch);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = context2.getString(R.string.glucose_slot_afterLunch);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = context2.getString(R.string.glucose_slot_beforeDinner);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        String string6 = context2.getString(R.string.glucose_slot_afterDinner);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        String string7 = context2.getString(R.string.glucose_slot_beforeSleep);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        String string8 = context2.getString(R.string.glucose_slot_beforeDawn);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        String string9 = context2.getString(R.string.glucose_slot_randomTime);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        this.mList = CollectionsKt.mutableListOf(new TimeSlotInfo(string, false), new TimeSlotInfo(string2, false), new TimeSlotInfo(string3, false), new TimeSlotInfo(string4, false), new TimeSlotInfo(string5, false), new TimeSlotInfo(string6, false), new TimeSlotInfo(string7, false), new TimeSlotInfo(string8, false), new TimeSlotInfo(string9, false));
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function1<Integer, Unit> getOnSelect() {
        return this.onSelect;
    }

    public final void setOnSelect(Function1<? super Integer, Unit> function1) {
        this.onSelect = function1;
    }

    public TimeSlopViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.time_slop_item, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate);
        return new TimeSlopViewHolder(this, inflate);
    }

    public void onBindViewHolder(TimeSlopViewHolder timeSlopViewHolder, int i) {
        Intrinsics.checkNotNullParameter(timeSlopViewHolder, "holder");
        timeSlopViewHolder.getTimeSlotItem().setText(this.mList.get(i).getName());
        if (ThemeManager.INSTANCE.isLight()) {
            timeSlopViewHolder.getTimeSlotItem().setTextColor(ContextCompat.getColor(this.context, R.color.black_33));
        } else {
            timeSlopViewHolder.getTimeSlotItem().setTextColor(ContextCompat.getColor(this.context, R.color.white));
        }
        if (this.mList.get(i).isChecked()) {
            if (ThemeManager.INSTANCE.isLight()) {
                timeSlopViewHolder.getTimeSlotItem().setBackground(ContextCompat.getDrawable(this.context, R.drawable.bg_time_slop_checked_light));
                timeSlopViewHolder.getTimeSlotItem().setTextColor(ContextCompat.getColor(this.context, R.color.light_colorAccent));
            } else {
                timeSlopViewHolder.getTimeSlotItem().setBackground(ContextCompat.getDrawable(this.context, R.drawable.bg_time_slop_checked));
                timeSlopViewHolder.getTimeSlotItem().setTextColor(ContextCompat.getColor(this.context, R.color.colorAccent));
            }
        } else if (ThemeManager.INSTANCE.isLight()) {
            timeSlopViewHolder.getTimeSlotItem().setBackground(ContextCompat.getDrawable(this.context, R.drawable.bg_time_slop_unchecked_light));
            timeSlopViewHolder.getTimeSlotItem().setTextColor(ContextCompat.getColor(this.context, R.color.gray_1d));
        } else {
            timeSlopViewHolder.getTimeSlotItem().setBackground(ContextCompat.getDrawable(this.context, R.drawable.bg_time_slop_unchecked));
            timeSlopViewHolder.getTimeSlotItem().setTextColor(ContextCompat.getColor(this.context, R.color.white));
        }
        timeSlopViewHolder.getTimeSlotItem().setOnClickListener(new TimeSlopAdapter$$ExternalSyntheticLambda0(this, i));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(TimeSlopAdapter timeSlopAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(timeSlopAdapter, "this$0");
        int i2 = 0;
        for (TimeSlotInfo next : timeSlopAdapter.mList) {
            int i3 = i2 + 1;
            next.setChecked(i2 == i);
            if (next.isChecked()) {
                if (i2 != 8) {
                    Function1<? super Integer, Unit> function1 = timeSlopAdapter.onSelect;
                    if (function1 != null) {
                        function1.invoke(Integer.valueOf(i3));
                    }
                } else {
                    Function1<? super Integer, Unit> function12 = timeSlopAdapter.onSelect;
                    if (function12 != null) {
                        function12.invoke(99);
                    }
                }
            }
            i2 = i3;
        }
        timeSlopAdapter.notifyDataSetChanged();
    }

    public final void clearCheck() {
        int i = 0;
        for (TimeSlotInfo next : this.mList) {
            int i2 = i + 1;
            if (next.isChecked()) {
                next.setChecked(false);
                notifyItemChanged(i);
            }
            i = i2;
        }
    }

    public int getItemCount() {
        return this.mList.size();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/ui/main/bg/TimeSlopAdapter$TimeSlopViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/microtech/aidexx/ui/main/bg/TimeSlopAdapter;Landroid/view/View;)V", "timeSlotItem", "Landroid/widget/TextView;", "getTimeSlotItem", "()Landroid/widget/TextView;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TimeSlopAdapter.kt */
    public final class TimeSlopViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ TimeSlopAdapter this$0;
        private final TextView timeSlotItem;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TimeSlopViewHolder(TimeSlopAdapter timeSlopAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = timeSlopAdapter;
            View findViewById = view.findViewById(R.id.slot_item);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.timeSlotItem = (TextView) findViewById;
        }

        public final TextView getTimeSlotItem() {
            return this.timeSlotItem;
        }
    }
}
