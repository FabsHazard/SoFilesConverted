package com.microtech.aidexx.ui.main.event;

import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$7"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: FragmentViewModelLazy.kt */
public final class EventMedicineFragment$special$$inlined$viewModels$default$4 extends Lambda implements Function0<CreationExtras> {
    final /* synthetic */ Function0 $extrasProducer;
    final /* synthetic */ Lazy $owner$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventMedicineFragment$special$$inlined$viewModels$default$4(Function0 function0, Lazy lazy) {
        super(0);
        this.$extrasProducer = function0;
        this.$owner$delegate = lazy;
    }

    public final CreationExtras invoke() {
        CreationExtras creationExtras;
        Function0 function0 = this.$extrasProducer;
        if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
            return creationExtras;
        }
        ViewModelStoreOwner r0 = FragmentViewModelLazyKt.m55viewModels$lambda1(this.$owner$delegate);
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = r0 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) r0 : null;
        if (hasDefaultViewModelProviderFactory != null) {
            return hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras();
        }
        return CreationExtras.Empty.INSTANCE;
    }
}
