package com.microtech.aidexx.base;

import com.microtech.aidexx.utils.BleUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseActivity.kt */
final class BaseActivity$enableBluetooth$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseActivity<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseActivity$enableBluetooth$1(BaseActivity<VM, VB> baseActivity) {
        super(0);
        this.this$0 = baseActivity;
    }

    public final void invoke() {
        BleUtil.enableBluetooth(this.this$0, 12345);
    }
}
