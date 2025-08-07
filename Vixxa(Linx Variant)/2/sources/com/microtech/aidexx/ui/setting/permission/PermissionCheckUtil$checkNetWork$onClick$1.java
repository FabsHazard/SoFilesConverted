package com.microtech.aidexx.ui.setting.permission;

import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.common.compliance.EnquireManager;
import com.microtech.aidexx.views.SettingItemWidget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/setting/permission/PermissionCheckUtil$checkNetWork$onClick$1", "Lkotlin/Function1;", "Lcom/microtech/aidexx/views/SettingItemWidget;", "", "invoke", "p1", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionCheckUtil.kt */
public final class PermissionCheckUtil$checkNetWork$onClick$1 implements Function1<SettingItemWidget, Unit> {
    final /* synthetic */ BaseActivity<?, ?> $context;

    PermissionCheckUtil$checkNetWork$onClick$1(BaseActivity<?, ?> baseActivity) {
        this.$context = baseActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SettingItemWidget) obj);
        return Unit.INSTANCE;
    }

    public void invoke(SettingItemWidget settingItemWidget) {
        Intrinsics.checkNotNullParameter(settingItemWidget, "p1");
        EnquireManager instance = EnquireManager.Companion.instance();
        BaseActivity<?, ?> baseActivity = this.$context;
        String string = baseActivity.getString(R.string.permission_camera_title_ph, new Object[]{this.$context.getString(R.string.app_name)});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.$context.getString(R.string.permission_camera_desc);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        EnquireManager.showEnquireOrNot$default(instance, baseActivity, string, string2, new PermissionCheckUtil$checkNetWork$onClick$1$invoke$1(this.$context), (Function0) null, (String) null, 16, (Object) null);
    }
}
