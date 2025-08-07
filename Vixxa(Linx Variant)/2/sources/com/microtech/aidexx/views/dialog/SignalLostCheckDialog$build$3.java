package com.microtech.aidexx.views.dialog;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/views/dialog/SignalLostCheckDialog$build$3", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onDestroy", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SignalLostCheckDialog.kt */
public final class SignalLostCheckDialog$build$3 implements DefaultLifecycleObserver {
    final /* synthetic */ SignalLostCheckDialog this$0;

    SignalLostCheckDialog$build$3(SignalLostCheckDialog signalLostCheckDialog) {
        this.this$0 = signalLostCheckDialog;
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.this$0.dismiss();
        super.onDestroy(lifecycleOwner);
    }
}
