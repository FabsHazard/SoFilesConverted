package com.microtech.aidexx.ui.setting.timezonehistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.databinding.ItemTimezoneHistoryBinding;
import com.microtech.aidexx.db.entity.TimezoneHistoryEntity;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R4\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/ui/setting/timezonehistory/TimeZoneHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/microtech/aidexx/ui/setting/timezonehistory/TimeZoneHistoryAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "value", "", "Lcom/microtech/aidexx/db/entity/TimezoneHistoryEntity;", "data", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeZoneHistoryAdapter.kt */
public final class TimeZoneHistoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private List<TimezoneHistoryEntity> data;

    public TimeZoneHistoryAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<TimezoneHistoryEntity> getData() {
        return this.data;
    }

    public final void setData(List<TimezoneHistoryEntity> list) {
        if (list != null) {
            if (this.data == null) {
                this.data = new ArrayList();
            }
            List<TimezoneHistoryEntity> list2 = this.data;
            Intrinsics.checkNotNull(list2);
            list2.clear();
            List<TimezoneHistoryEntity> list3 = this.data;
            Intrinsics.checkNotNull(list3);
            list3.addAll(list);
            LogUtil.Companion.d$default(LogUtil.Companion, String.valueOf(this.data), (String) null, 2, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/microtech/aidexx/ui/setting/timezonehistory/TimeZoneHistoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "vb", "Lcom/microtech/aidexx/databinding/ItemTimezoneHistoryBinding;", "(Landroid/content/Context;Lcom/microtech/aidexx/databinding/ItemTimezoneHistoryBinding;)V", "getContext", "()Landroid/content/Context;", "simpleDateFormat", "Ljava/text/SimpleDateFormat;", "bind", "", "item", "Lcom/microtech/aidexx/db/entity/TimezoneHistoryEntity;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TimeZoneHistoryAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm yyyy/MM/dd 'UTC' Z", Locale.getDefault());
        private final ItemTimezoneHistoryBinding vb;

        public final Context getContext() {
            return this.context;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(Context context2, ItemTimezoneHistoryBinding itemTimezoneHistoryBinding) {
            super(itemTimezoneHistoryBinding.getRoot());
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(itemTimezoneHistoryBinding, "vb");
            this.context = context2;
            this.vb = itemTimezoneHistoryBinding;
        }

        public final void bind(TimezoneHistoryEntity timezoneHistoryEntity) {
            Intrinsics.checkNotNullParameter(timezoneHistoryEntity, "item");
            ItemTimezoneHistoryBinding itemTimezoneHistoryBinding = this.vb;
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
            instance.setTimeInMillis(timezoneHistoryEntity.getTimestamp());
            TimeZone timeZone = TimeZone.getTimeZone(timezoneHistoryEntity.getFrom());
            Intrinsics.checkNotNullExpressionValue(timeZone, "getTimeZone(...)");
            TimeZone timeZone2 = TimeZone.getTimeZone(timezoneHistoryEntity.getTo());
            Intrinsics.checkNotNullExpressionValue(timeZone2, "getTimeZone(...)");
            if (!Intrinsics.areEqual((Object) timeZone.getID(), (Object) timeZone2.getID()) || !timeZone.useDaylightTime()) {
                this.simpleDateFormat.setTimeZone(timeZone);
                CharSequence format = this.simpleDateFormat.format(instance.getTime());
                itemTimezoneHistoryBinding.fromTime.setText(format);
                itemTimezoneHistoryBinding.timezoneHistoryCreateTime.setText(format);
                this.simpleDateFormat.setTimeZone(timeZone2);
                itemTimezoneHistoryBinding.toTime.setText(this.simpleDateFormat.format(instance.getTime()));
                return;
            }
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            String id = timeZone.getID();
            Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
            Date nextTransaction = timeUtils.getNextTransaction(id, new Date(timezoneHistoryEntity.getTimestamp()));
            if (nextTransaction != null) {
                this.simpleDateFormat.setTimeZone(timeZone);
                String format2 = this.simpleDateFormat.format(nextTransaction);
                Intrinsics.checkNotNull(format2);
                String substring = format2.substring(17, format2.length());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String format3 = this.simpleDateFormat.format(instance.getTime());
                Intrinsics.checkNotNull(format3);
                String substring2 = format3.substring(0, 16);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                TextView textView = itemTimezoneHistoryBinding.fromTime;
                String str = substring2 + " " + substring;
                Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
                textView.setText(str);
                itemTimezoneHistoryBinding.timezoneHistoryCreateTime.setText(format3);
                this.simpleDateFormat.setTimeZone(timeZone2);
                itemTimezoneHistoryBinding.toTime.setText(this.simpleDateFormat.format(instance.getTime()));
            }
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemTimezoneHistoryBinding inflate = ItemTimezoneHistoryBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this.context, inflate);
    }

    public int getItemCount() {
        List<TimezoneHistoryEntity> list = this.data;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        List<TimezoneHistoryEntity> list = this.data;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            viewHolder.bind(list.get(i));
        }
    }
}
