package com.microtech.aidexx.ui.main.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.FragmentHistoryEventBinding;
import com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryChartViewHolder;
import com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryCountViewHolder;
import com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryProportionViewHolder;
import com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/EventHistoryFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentHistoryEventBinding;", "()V", "initViewHolders", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventHistoryFragment.kt */
public final class EventHistoryFragment extends BaseFragment<BaseViewModel, FragmentHistoryEventBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final EventHistoryFragment newInstance() {
        return Companion.newInstance();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentHistoryEventBinding inflate = FragmentHistoryEventBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        initViewHolders();
        LinearLayout root = ((FragmentHistoryEventBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initViewHolders() {
        new EventHistoryCountViewHolder(this);
        new EventHistoryChartViewHolder(this);
        new EventHistoryProportionViewHolder(this);
        new EventHistoryRecordsViewHolder(this);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/EventHistoryFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/main/history/EventHistoryFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EventHistoryFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final EventHistoryFragment newInstance() {
            return new EventHistoryFragment();
        }
    }
}
