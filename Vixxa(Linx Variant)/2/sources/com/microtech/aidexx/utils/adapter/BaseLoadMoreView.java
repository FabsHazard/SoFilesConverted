package com.microtech.aidexx.utils.adapter;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/BaseLoadMoreView;", "", "()V", "convert", "", "holder", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "position", "", "loadMoreStatus", "Lcom/microtech/aidexx/utils/adapter/LoadMoreStatus;", "getLoadComplete", "Landroid/view/View;", "getLoadEndView", "getLoadFailView", "getLoadingView", "getRootView", "parent", "Landroid/view/ViewGroup;", "isVisible", "visible", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseLoadMoreView.kt */
public abstract class BaseLoadMoreView {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseLoadMoreView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.microtech.aidexx.utils.adapter.LoadMoreStatus[] r0 = com.microtech.aidexx.utils.adapter.LoadMoreStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.utils.adapter.LoadMoreStatus r1 = com.microtech.aidexx.utils.adapter.LoadMoreStatus.Complete     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.utils.adapter.LoadMoreStatus r1 = com.microtech.aidexx.utils.adapter.LoadMoreStatus.Loading     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.microtech.aidexx.utils.adapter.LoadMoreStatus r1 = com.microtech.aidexx.utils.adapter.LoadMoreStatus.Fail     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.microtech.aidexx.utils.adapter.LoadMoreStatus r1 = com.microtech.aidexx.utils.adapter.LoadMoreStatus.End     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.adapter.BaseLoadMoreView.WhenMappings.<clinit>():void");
        }
    }

    public abstract View getLoadComplete(BaseViewHolder baseViewHolder);

    public abstract View getLoadEndView(BaseViewHolder baseViewHolder);

    public abstract View getLoadFailView(BaseViewHolder baseViewHolder);

    public abstract View getLoadingView(BaseViewHolder baseViewHolder);

    public abstract View getRootView(ViewGroup viewGroup);

    public void convert(BaseViewHolder baseViewHolder, int i, LoadMoreStatus loadMoreStatus) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(loadMoreStatus, "loadMoreStatus");
        int i2 = WhenMappings.$EnumSwitchMapping$0[loadMoreStatus.ordinal()];
        if (i2 == 1) {
            isVisible(getLoadingView(baseViewHolder), false);
            isVisible(getLoadComplete(baseViewHolder), true);
            isVisible(getLoadFailView(baseViewHolder), false);
            isVisible(getLoadEndView(baseViewHolder), false);
        } else if (i2 == 2) {
            isVisible(getLoadingView(baseViewHolder), true);
            isVisible(getLoadComplete(baseViewHolder), false);
            isVisible(getLoadFailView(baseViewHolder), false);
            isVisible(getLoadEndView(baseViewHolder), false);
        } else if (i2 == 3) {
            isVisible(getLoadingView(baseViewHolder), false);
            isVisible(getLoadComplete(baseViewHolder), false);
            isVisible(getLoadFailView(baseViewHolder), true);
            isVisible(getLoadEndView(baseViewHolder), false);
        } else if (i2 == 4) {
            isVisible(getLoadingView(baseViewHolder), false);
            isVisible(getLoadComplete(baseViewHolder), false);
            isVisible(getLoadFailView(baseViewHolder), false);
            isVisible(getLoadEndView(baseViewHolder), true);
        }
    }

    private final void isVisible(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }
}
