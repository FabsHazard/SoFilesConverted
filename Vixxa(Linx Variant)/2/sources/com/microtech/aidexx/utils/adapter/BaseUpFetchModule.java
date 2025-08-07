package com.microtech.aidexx.utils.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0017J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/BaseUpFetchModule;", "Lcom/microtech/aidexx/utils/adapter/UpFetchListenerImp;", "baseQuickAdapter", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "(Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;)V", "isUpFetchEnable", "", "()Z", "setUpFetchEnable", "(Z)V", "isUpFetching", "setUpFetching", "mUpFetchListener", "Lcom/microtech/aidexx/utils/adapter/OnUpFetchListener;", "startUpFetchPosition", "", "getStartUpFetchPosition", "()I", "setStartUpFetchPosition", "(I)V", "autoUpFetch", "", "position", "autoUpFetch$app_gpGrxMmolRelease", "setOnUpFetchListener", "listener", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UpFetchModule.kt */
public class BaseUpFetchModule implements UpFetchListenerImp {
    private final BaseQuickAdapter<?, ?> baseQuickAdapter;
    private boolean isUpFetchEnable;
    private boolean isUpFetching;
    private OnUpFetchListener mUpFetchListener;
    private int startUpFetchPosition = 1;

    public BaseUpFetchModule(BaseQuickAdapter<?, ?> baseQuickAdapter2) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter2, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter2;
    }

    public final boolean isUpFetchEnable() {
        return this.isUpFetchEnable;
    }

    public final void setUpFetchEnable(boolean z) {
        this.isUpFetchEnable = z;
    }

    public final boolean isUpFetching() {
        return this.isUpFetching;
    }

    public final void setUpFetching(boolean z) {
        this.isUpFetching = z;
    }

    public final int getStartUpFetchPosition() {
        return this.startUpFetchPosition;
    }

    public final void setStartUpFetchPosition(int i) {
        this.startUpFetchPosition = i;
    }

    public final void autoUpFetch$app_gpGrxMmolRelease(int i) {
        OnUpFetchListener onUpFetchListener;
        if (this.isUpFetchEnable && !this.isUpFetching && i <= this.startUpFetchPosition && (onUpFetchListener = this.mUpFetchListener) != null) {
            onUpFetchListener.onUpFetch();
        }
    }

    public void setOnUpFetchListener(OnUpFetchListener onUpFetchListener) {
        this.mUpFetchListener = onUpFetchListener;
    }
}
