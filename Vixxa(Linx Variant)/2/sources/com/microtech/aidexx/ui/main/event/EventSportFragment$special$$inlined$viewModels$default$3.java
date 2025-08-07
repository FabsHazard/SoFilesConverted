package com.microtech.aidexx.ui.main.event;

import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$6"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: FragmentViewModelLazy.kt */
public final class EventSportFragment$special$$inlined$viewModels$default$3 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ Lazy $owner$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventSportFragment$special$$inlined$viewModels$default$3(Lazy lazy) {
        super(0);
        this.$owner$delegate = lazy;
    }

    public final ViewModelStore invoke() {
        return FragmentViewModelLazyKt.m55viewModels$lambda1(this.$owner$delegate).getViewModelStore();
    }
}
