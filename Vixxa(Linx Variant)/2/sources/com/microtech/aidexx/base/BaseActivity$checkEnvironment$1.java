package com.microtech.aidexx.base;

import com.microtech.aidexx.R;
import com.microtech.aidexx.common.compliance.EnquireManager;
import com.microtech.aidexx.utils.permission.PermissionGroups;
import com.microtech.aidexx.utils.permission.PermissionsUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseActivity.kt */
final class BaseActivity$checkEnvironment$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.BooleanRef $needBtPermission;
    final /* synthetic */ BaseActivity<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseActivity$checkEnvironment$1(Ref.BooleanRef booleanRef, BaseActivity<VM, VB> baseActivity) {
        super(0);
        this.$needBtPermission = booleanRef;
        this.this$0 = baseActivity;
    }

    public final void invoke() {
        this.$needBtPermission.element = true;
        EnquireManager instance = EnquireManager.Companion.instance();
        BaseActivity<VM, VB> baseActivity = this.this$0;
        String string = baseActivity.getString(R.string.permission_ble_title_ph, new Object[]{this.this$0.getString(R.string.app_name)});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.this$0.getString(R.string.permission_ble_desc);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        final BaseActivity<VM, VB> baseActivity2 = this.this$0;
        EnquireManager.showEnquireOrNot$default(instance, baseActivity, string, string2, new Function0<Unit>() {
            public final void invoke() {
                PermissionsUtil.requestPermissions$default(PermissionsUtil.INSTANCE, baseActivity2, PermissionGroups.INSTANCE.getBluetooth(), (Function0) null, 4, (Object) null);
            }
        }, (Function0) null, (String) null, 16, (Object) null);
    }
}
