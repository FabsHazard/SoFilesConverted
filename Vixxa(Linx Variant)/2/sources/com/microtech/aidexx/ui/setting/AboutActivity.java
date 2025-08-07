package com.microtech.aidexx.ui.setting;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.IntentKey;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.Constants;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityAboutBinding;
import com.microtech.aidexx.ui.web.WebActivity;
import com.microtech.aidexx.views.SettingItemWidget;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/ui/setting/AboutActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityAboutBinding;", "()V", "getLauncher", "Landroid/graphics/drawable/Drawable;", "getViewBinding", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AboutActivity.kt */
public final class AboutActivity extends BaseActivity<BaseViewModel, ActivityAboutBinding> {
    public ActivityAboutBinding getViewBinding() {
        ActivityAboutBinding inflate = ActivityAboutBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityAboutBinding) getBinding()).getRoot());
        ActivityAboutBinding activityAboutBinding = (ActivityAboutBinding) getBinding();
        activityAboutBinding.actionBar.getLeftIcon().setOnClickListener(new AboutActivity$$ExternalSyntheticLambda0(this));
        activityAboutBinding.launcher.setImageDrawable(getLauncher());
        SettingItemWidget settingItemWidget = activityAboutBinding.settingSoftVersion;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget, "settingSoftVersion");
        int i = 0;
        settingItemWidget.setVisibility(!ExtendsKt.isGp() ? 0 : 8);
        activityAboutBinding.settingSoftVersion.setValue("v1.7.1");
        SettingItemWidget settingItemWidget2 = activityAboutBinding.settingName;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget2, "settingName");
        settingItemWidget2.setVisibility(!ExtendsKt.isGp() ? 0 : 8);
        activityAboutBinding.settingName.setValue(getString(R.string.about_name_value));
        SettingItemWidget settingItemWidget3 = activityAboutBinding.settingOpenVersion;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget3, "settingOpenVersion");
        settingItemWidget3.setVisibility(!ExtendsKt.isGp() ? 0 : 8);
        activityAboutBinding.settingOpenVersion.setValue("v1");
        SettingItemWidget settingItemWidget4 = activityAboutBinding.settingType;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget4, "settingType");
        View view = settingItemWidget4;
        if (ExtendsKt.isGp()) {
            i = 8;
        }
        view.setVisibility(i);
        activityAboutBinding.settingType.setValue("AiDEX-X");
        activityAboutBinding.settingService.setOnClickListener(new AboutActivity$$ExternalSyntheticLambda1(this));
        activityAboutBinding.settingCheckVersion.setOnClickListener(new AboutActivity$$ExternalSyntheticLambda2(this));
        activityAboutBinding.settingProtocal.setOnClickListener(new AboutActivity$$ExternalSyntheticLambda3(this));
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new AboutActivity$onCreate$2(this, (Continuation<? super AboutActivity$onCreate$2>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$4$lambda$0(AboutActivity aboutActivity, View view) {
        Intrinsics.checkNotNullParameter(aboutActivity, "this$0");
        aboutActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$4$lambda$1(AboutActivity aboutActivity, View view) {
        Intrinsics.checkNotNullParameter(aboutActivity, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString(IntentKey.WEB_URL, Constants.INSTANCE.getUserServicePolicyUrl());
        bundle.putString(IntentKey.WEB_TITLE, aboutActivity.getResources().getString(R.string.about_servicePolicy));
        aboutActivity.startActivity(bundle, WebActivity.class);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$4$lambda$2(AboutActivity aboutActivity, View view) {
        Intrinsics.checkNotNullParameter(aboutActivity, "this$0");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(aboutActivity), (CoroutineContext) null, (CoroutineStart) null, new AboutActivity$onCreate$1$3$1(aboutActivity, (Continuation<? super AboutActivity$onCreate$1$3$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$4$lambda$3(AboutActivity aboutActivity, View view) {
        Intrinsics.checkNotNullParameter(aboutActivity, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString(IntentKey.WEB_URL, Constants.INSTANCE.getPrivacyPolicyUrl());
        bundle.putString(IntentKey.WEB_TITLE, aboutActivity.getResources().getString(R.string.about_privatePolicy));
        aboutActivity.startActivity(bundle, WebActivity.class);
    }

    private final Drawable getLauncher() {
        try {
            return getPackageManager().getApplicationIcon(getApplicationInfo());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
