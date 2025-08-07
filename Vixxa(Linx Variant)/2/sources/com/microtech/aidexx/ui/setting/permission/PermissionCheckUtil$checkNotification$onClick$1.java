package com.microtech.aidexx.ui.setting.permission;

import android.content.Intent;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.views.SettingItemWidget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/setting/permission/PermissionCheckUtil$checkNotification$onClick$1", "Lkotlin/Function1;", "Lcom/microtech/aidexx/views/SettingItemWidget;", "", "invoke", "p1", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionCheckUtil.kt */
public final class PermissionCheckUtil$checkNotification$onClick$1 implements Function1<SettingItemWidget, Unit> {
    final /* synthetic */ BaseActivity<?, ?> $context;

    PermissionCheckUtil$checkNotification$onClick$1(BaseActivity<?, ?> baseActivity) {
        this.$context = baseActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SettingItemWidget) obj);
        return Unit.INSTANCE;
    }

    public void invoke(SettingItemWidget settingItemWidget) {
        Intrinsics.checkNotNullParameter(settingItemWidget, "p1");
        Intent intent = new Intent();
        try {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", this.$context.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", this.$context.getApplicationInfo().uid);
            intent.putExtra("app_package", this.$context.getPackageName());
            intent.putExtra("app_uid", this.$context.getApplicationInfo().uid);
            this.$context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.putExtra(WiseOpenHianalyticsData.UNION_PACKAGE, this.$context.getPackageName());
            this.$context.startActivity(intent);
        }
    }
}
