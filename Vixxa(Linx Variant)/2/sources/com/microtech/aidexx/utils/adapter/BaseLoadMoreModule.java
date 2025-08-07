package com.microtech.aidexx.utils.adapter;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020 H\u0000¢\u0006\u0002\b-J\u0006\u0010.\u001a\u00020+J\u0012\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0006\u00102\u001a\u00020\u0006J\b\u00103\u001a\u00020+H\u0002J\u0010\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u000206H\u0002J\u0006\u00107\u001a\u00020+J\u0012\u00108\u001a\u00020+2\b\b\u0002\u00109\u001a\u00020\u0006H\u0007J\u0006\u0010:\u001a\u00020+J\u0006\u0010;\u001a\u00020+J\r\u0010<\u001a\u00020+H\u0000¢\u0006\u0002\b=J\u0012\u0010>\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010$H\u0016J\u0015\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020BH\u0000¢\u0006\u0002\bCR\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0011\u0010\u0014\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020 2\u0006\u0010\r\u001a\u00020 @FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010)¨\u0006D"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/BaseLoadMoreModule;", "Lcom/microtech/aidexx/utils/adapter/LoadMoreListenerImp;", "baseQuickAdapter", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "(Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;)V", "enableLoadMoreEndClick", "", "getEnableLoadMoreEndClick", "()Z", "setEnableLoadMoreEndClick", "(Z)V", "isAutoLoadMore", "setAutoLoadMore", "value", "isEnableLoadMore", "setEnableLoadMore", "isEnableLoadMoreIfNotFullPage", "setEnableLoadMoreIfNotFullPage", "<set-?>", "isLoadEndMoreGone", "isLoading", "Lcom/microtech/aidexx/utils/adapter/LoadMoreStatus;", "loadMoreStatus", "getLoadMoreStatus", "()Lcom/microtech/aidexx/utils/adapter/LoadMoreStatus;", "loadMoreView", "Lcom/microtech/aidexx/utils/adapter/BaseLoadMoreView;", "getLoadMoreView", "()Lcom/microtech/aidexx/utils/adapter/BaseLoadMoreView;", "setLoadMoreView", "(Lcom/microtech/aidexx/utils/adapter/BaseLoadMoreView;)V", "loadMoreViewPosition", "", "getLoadMoreViewPosition", "()I", "mLoadMoreListener", "Lcom/microtech/aidexx/utils/adapter/OnLoadMoreListener;", "mNextLoadEnable", "preLoadNumber", "getPreLoadNumber", "setPreLoadNumber", "(I)V", "autoLoadMore", "", "position", "autoLoadMore$app_gpGrxMmolRelease", "checkDisableLoadMoreIfNotFullPage", "getTheBiggestNumber", "numbers", "", "hasLoadMoreView", "invokeLoadMoreListener", "isFullScreen", "llm", "Landroidx/recyclerview/widget/LinearLayoutManager;", "loadMoreComplete", "loadMoreEnd", "gone", "loadMoreFail", "loadMoreToLoading", "reset", "reset$app_gpGrxMmolRelease", "setOnLoadMoreListener", "listener", "setupViewHolder", "viewHolder", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "setupViewHolder$app_gpGrxMmolRelease", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LoadMoreModule.kt */
public class BaseLoadMoreModule implements LoadMoreListenerImp {
    private final BaseQuickAdapter<?, ?> baseQuickAdapter;
    private boolean enableLoadMoreEndClick;
    private boolean isAutoLoadMore = true;
    private boolean isEnableLoadMore;
    private boolean isEnableLoadMoreIfNotFullPage = true;
    private boolean isLoadEndMoreGone;
    private LoadMoreStatus loadMoreStatus = LoadMoreStatus.Complete;
    private BaseLoadMoreView loadMoreView = LoadMoreModuleConfig.getDefLoadMoreView();
    private OnLoadMoreListener mLoadMoreListener;
    private boolean mNextLoadEnable = true;
    private int preLoadNumber = 1;

    public final void loadMoreEnd() {
        loadMoreEnd$default(this, false, 1, (Object) null);
    }

    public BaseLoadMoreModule(BaseQuickAdapter<?, ?> baseQuickAdapter2) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter2, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter2;
    }

    public final LoadMoreStatus getLoadMoreStatus() {
        return this.loadMoreStatus;
    }

    public final boolean isLoadEndMoreGone() {
        return this.isLoadEndMoreGone;
    }

    public final BaseLoadMoreView getLoadMoreView() {
        return this.loadMoreView;
    }

    public final void setLoadMoreView(BaseLoadMoreView baseLoadMoreView) {
        Intrinsics.checkNotNullParameter(baseLoadMoreView, "<set-?>");
        this.loadMoreView = baseLoadMoreView;
    }

    public final boolean getEnableLoadMoreEndClick() {
        return this.enableLoadMoreEndClick;
    }

    public final void setEnableLoadMoreEndClick(boolean z) {
        this.enableLoadMoreEndClick = z;
    }

    public final boolean isAutoLoadMore() {
        return this.isAutoLoadMore;
    }

    public final void setAutoLoadMore(boolean z) {
        this.isAutoLoadMore = z;
    }

    public final boolean isEnableLoadMoreIfNotFullPage() {
        return this.isEnableLoadMoreIfNotFullPage;
    }

    public final void setEnableLoadMoreIfNotFullPage(boolean z) {
        this.isEnableLoadMoreIfNotFullPage = z;
    }

    public final int getPreLoadNumber() {
        return this.preLoadNumber;
    }

    public final void setPreLoadNumber(int i) {
        if (i > 1) {
            this.preLoadNumber = i;
        }
    }

    public final boolean isLoading() {
        return this.loadMoreStatus == LoadMoreStatus.Loading;
    }

    public final int getLoadMoreViewPosition() {
        if (this.baseQuickAdapter.hasEmptyView()) {
            return -1;
        }
        BaseQuickAdapter<?, ?> baseQuickAdapter2 = this.baseQuickAdapter;
        return baseQuickAdapter2.getHeaderLayoutCount() + baseQuickAdapter2.getData().size() + baseQuickAdapter2.getFooterLayoutCount();
    }

    public final boolean isEnableLoadMore() {
        return this.isEnableLoadMore;
    }

    public final void setEnableLoadMore(boolean z) {
        boolean hasLoadMoreView = hasLoadMoreView();
        this.isEnableLoadMore = z;
        boolean hasLoadMoreView2 = hasLoadMoreView();
        if (hasLoadMoreView) {
            if (!hasLoadMoreView2) {
                this.baseQuickAdapter.notifyItemRemoved(getLoadMoreViewPosition());
            }
        } else if (hasLoadMoreView2) {
            this.loadMoreStatus = LoadMoreStatus.Complete;
            this.baseQuickAdapter.notifyItemInserted(getLoadMoreViewPosition());
        }
    }

    public final void setupViewHolder$app_gpGrxMmolRelease(BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "viewHolder");
        baseViewHolder.itemView.setOnClickListener(new BaseLoadMoreModule$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public static final void setupViewHolder$lambda$1(BaseLoadMoreModule baseLoadMoreModule, View view) {
        Intrinsics.checkNotNullParameter(baseLoadMoreModule, "this$0");
        if (baseLoadMoreModule.loadMoreStatus == LoadMoreStatus.Fail) {
            baseLoadMoreModule.loadMoreToLoading();
        } else if (baseLoadMoreModule.loadMoreStatus == LoadMoreStatus.Complete) {
            baseLoadMoreModule.loadMoreToLoading();
        } else if (baseLoadMoreModule.enableLoadMoreEndClick && baseLoadMoreModule.loadMoreStatus == LoadMoreStatus.End) {
            baseLoadMoreModule.loadMoreToLoading();
        }
    }

    public final void loadMoreToLoading() {
        if (this.loadMoreStatus != LoadMoreStatus.Loading) {
            this.loadMoreStatus = LoadMoreStatus.Loading;
            this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
            invokeLoadMoreListener();
        }
    }

    public final boolean hasLoadMoreView() {
        if (this.mLoadMoreListener == null || !this.isEnableLoadMore) {
            return false;
        }
        if (this.loadMoreStatus != LoadMoreStatus.End || !this.isLoadEndMoreGone) {
            return !this.baseQuickAdapter.getData().isEmpty();
        }
        return false;
    }

    public final void autoLoadMore$app_gpGrxMmolRelease(int i) {
        if (this.isAutoLoadMore && hasLoadMoreView() && i >= this.baseQuickAdapter.getItemCount() - this.preLoadNumber && this.loadMoreStatus == LoadMoreStatus.Complete && this.loadMoreStatus != LoadMoreStatus.Loading && this.mNextLoadEnable) {
            invokeLoadMoreListener();
        }
    }

    private final void invokeLoadMoreListener() {
        this.loadMoreStatus = LoadMoreStatus.Loading;
        RecyclerView recyclerViewOrNull = this.baseQuickAdapter.getRecyclerViewOrNull();
        if (recyclerViewOrNull != null) {
            recyclerViewOrNull.post(new BaseLoadMoreModule$$ExternalSyntheticLambda0(this));
            return;
        }
        OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
        if (onLoadMoreListener != null) {
            onLoadMoreListener.onLoadMore();
        }
    }

    /* access modifiers changed from: private */
    public static final void invokeLoadMoreListener$lambda$3$lambda$2(BaseLoadMoreModule baseLoadMoreModule) {
        Intrinsics.checkNotNullParameter(baseLoadMoreModule, "this$0");
        OnLoadMoreListener onLoadMoreListener = baseLoadMoreModule.mLoadMoreListener;
        if (onLoadMoreListener != null) {
            onLoadMoreListener.onLoadMore();
        }
    }

    public final void checkDisableLoadMoreIfNotFullPage() {
        RecyclerView.LayoutManager layoutManager;
        if (!this.isEnableLoadMoreIfNotFullPage) {
            this.mNextLoadEnable = false;
            RecyclerView recyclerViewOrNull = this.baseQuickAdapter.getRecyclerViewOrNull();
            if (recyclerViewOrNull != null && (layoutManager = recyclerViewOrNull.getLayoutManager()) != null) {
                if (layoutManager instanceof LinearLayoutManager) {
                    recyclerViewOrNull.postDelayed(new BaseLoadMoreModule$$ExternalSyntheticLambda1(this, layoutManager), 50);
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    recyclerViewOrNull.postDelayed(new BaseLoadMoreModule$$ExternalSyntheticLambda2(layoutManager, this), 50);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void checkDisableLoadMoreIfNotFullPage$lambda$4(BaseLoadMoreModule baseLoadMoreModule, RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(baseLoadMoreModule, "this$0");
        Intrinsics.checkNotNullParameter(layoutManager, "$manager");
        if (baseLoadMoreModule.isFullScreen((LinearLayoutManager) layoutManager)) {
            baseLoadMoreModule.mNextLoadEnable = true;
        }
    }

    /* access modifiers changed from: private */
    public static final void checkDisableLoadMoreIfNotFullPage$lambda$5(RecyclerView.LayoutManager layoutManager, BaseLoadMoreModule baseLoadMoreModule) {
        Intrinsics.checkNotNullParameter(layoutManager, "$manager");
        Intrinsics.checkNotNullParameter(baseLoadMoreModule, "this$0");
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(iArr);
        if (baseLoadMoreModule.getTheBiggestNumber(iArr) + 1 != baseLoadMoreModule.baseQuickAdapter.getItemCount()) {
            baseLoadMoreModule.mNextLoadEnable = true;
        }
    }

    private final boolean isFullScreen(LinearLayoutManager linearLayoutManager) {
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == this.baseQuickAdapter.getItemCount() && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
            return false;
        }
        return true;
    }

    private final int getTheBiggestNumber(int[] iArr) {
        int i = -1;
        if (!(iArr == null || iArr.length == 0)) {
            for (int i2 : iArr) {
                if (i2 > i) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public static /* synthetic */ void loadMoreEnd$default(BaseLoadMoreModule baseLoadMoreModule, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            baseLoadMoreModule.loadMoreEnd(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreEnd");
    }

    public final void loadMoreEnd(boolean z) {
        if (hasLoadMoreView()) {
            this.isLoadEndMoreGone = z;
            this.loadMoreStatus = LoadMoreStatus.End;
            if (z) {
                this.baseQuickAdapter.notifyItemRemoved(getLoadMoreViewPosition());
            } else {
                this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
            }
        }
    }

    public final void loadMoreComplete() {
        if (hasLoadMoreView()) {
            this.loadMoreStatus = LoadMoreStatus.Complete;
            this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
            checkDisableLoadMoreIfNotFullPage();
        }
    }

    public final void loadMoreFail() {
        if (hasLoadMoreView()) {
            this.loadMoreStatus = LoadMoreStatus.Fail;
            this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mLoadMoreListener = onLoadMoreListener;
        setEnableLoadMore(true);
    }

    public final void reset$app_gpGrxMmolRelease() {
        if (this.mLoadMoreListener != null) {
            setEnableLoadMore(true);
            this.loadMoreStatus = LoadMoreStatus.Complete;
        }
    }
}
