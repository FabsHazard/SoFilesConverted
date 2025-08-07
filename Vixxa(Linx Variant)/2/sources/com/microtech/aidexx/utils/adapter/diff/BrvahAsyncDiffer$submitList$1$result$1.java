package com.microtech.aidexx.utils.adapter.diff;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/microtech/aidexx/utils/adapter/diff/BrvahAsyncDiffer$submitList$1$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BrvahAsyncDiffer.kt */
public final class BrvahAsyncDiffer$submitList$1$result$1 extends DiffUtil.Callback {
    final /* synthetic */ List<T> $newList;
    final /* synthetic */ List<T> $oldList;
    final /* synthetic */ BrvahAsyncDiffer<T> this$0;

    BrvahAsyncDiffer$submitList$1$result$1(List<? extends T> list, List<T> list2, BrvahAsyncDiffer<T> brvahAsyncDiffer) {
        this.$oldList = list;
        this.$newList = list2;
        this.this$0 = brvahAsyncDiffer;
    }

    public int getOldListSize() {
        return this.$oldList.size();
    }

    public int getNewListSize() {
        return this.$newList.size();
    }

    public boolean areItemsTheSame(int i, int i2) {
        T t = this.$oldList.get(i);
        T t2 = this.$newList.get(i2);
        if (t == null || t2 == null) {
            return t == null && t2 == null;
        }
        return this.this$0.config.getDiffCallback().areItemsTheSame(t, t2);
    }

    public boolean areContentsTheSame(int i, int i2) {
        T t = this.$oldList.get(i);
        T t2 = this.$newList.get(i2);
        if (t != null && t2 != null) {
            return this.this$0.config.getDiffCallback().areContentsTheSame(t, t2);
        }
        if (t == null && t2 == null) {
            return true;
        }
        throw new AssertionError();
    }

    public Object getChangePayload(int i, int i2) {
        T t = this.$oldList.get(i);
        T t2 = this.$newList.get(i2);
        if (t != null && t2 != null) {
            return this.this$0.config.getDiffCallback().getChangePayload(t, t2);
        }
        throw new AssertionError();
    }
}
