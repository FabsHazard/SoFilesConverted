package com.chad.library.adapter.base.loadmore;

import android.view.View;
import android.view.ViewGroup;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.adapter.BaseLoadMoreView;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;
import com.microtech.aidexx.utils.adapter.util.AdapterUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/SimpleLoadMoreView;", "Lcom/microtech/aidexx/utils/adapter/BaseLoadMoreView;", "()V", "getLoadComplete", "Landroid/view/View;", "holder", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "getLoadEndView", "getLoadFailView", "getLoadingView", "getRootView", "parent", "Landroid/view/ViewGroup;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SimpleLoadMoreView.kt */
public final class SimpleLoadMoreView extends BaseLoadMoreView {
    public View getRootView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return AdapterUtilsKt.getItemView(viewGroup, R.layout.brvah_quick_view_load_more);
    }

    public View getLoadingView(BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.load_more_loading_view);
    }

    public View getLoadComplete(BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.load_more_load_complete_view);
    }

    public View getLoadEndView(BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.load_more_load_end_view);
    }

    public View getLoadFailView(BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.load_more_load_fail_view);
    }
}
