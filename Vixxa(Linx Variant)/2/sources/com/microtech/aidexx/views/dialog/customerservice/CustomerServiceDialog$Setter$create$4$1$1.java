package com.microtech.aidexx.views.dialog.customerservice;

import android.content.Intent;
import android.net.Uri;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.utils.permission.PermissionGroups;
import com.microtech.aidexx.utils.permission.PermissionsUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomerServiceDialog.kt */
final class CustomerServiceDialog$Setter$create$4$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseActivity<?, ?> $activity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerServiceDialog$Setter$create$4$1$1(BaseActivity<?, ?> baseActivity) {
        super(0);
        this.$activity = baseActivity;
    }

    public final void invoke() {
        String[] callPhone = PermissionGroups.INSTANCE.getCallPhone();
        final BaseActivity<?, ?> baseActivity = this.$activity;
        PermissionsUtil.INSTANCE.checkPermissions(this.$activity, callPhone, new Function0<Unit>() {
            public final void invoke() {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:4000811831"));
                baseActivity.startActivity(intent);
            }
        });
    }
}
