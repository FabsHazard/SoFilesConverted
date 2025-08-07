package com.microtech.aidexx.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.net.UriKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.kongzue.dialogx.dialogs.WaitDialog;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.Constants;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.compliance.EnquireManager;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.databinding.ActivitySettingBinding;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.ui.pair.TransmitterActivity;
import com.microtech.aidexx.ui.qrcode.QrCodeScanActivity;
import com.microtech.aidexx.ui.setting.alert.AlertSettingsActivity;
import com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity;
import com.microtech.aidexx.ui.setting.profile.ProfileSettingsActivity;
import com.microtech.aidexx.ui.setting.share.ShareFollowActivity;
import com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryActivity;
import com.microtech.aidexx.ui.web.WebActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.FileUtils;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.utils.permission.PermissionGroups;
import com.microtech.aidexx.utils.permission.PermissionsUtil;
import com.microtech.aidexx.views.SettingItemWidget;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/microtech/aidexx/ui/setting/SettingActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivitySettingBinding;", "()V", "REQUEST_CODE_GALLERY", "", "units", "", "", "genAvatarFile", "Landroid/net/Uri;", "getViewBinding", "initView", "", "loadAvatar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingActivity.kt */
public final class SettingActivity extends BaseActivity<BaseViewModel, ActivitySettingBinding> {
    /* access modifiers changed from: private */
    public final int REQUEST_CODE_GALLERY = 16;
    /* access modifiers changed from: private */
    public final List<String> units = CollectionsKt.listOf(ExtendsKt.getContext().getString(R.string.cgm_unit_mmol), ExtendsKt.getContext().getString(R.string.cgm_unit_mg));

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivitySettingBinding) getBinding()).getRoot());
        initView();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str;
        Drawable drawable;
        TransmitterEntity entity;
        super.onResume();
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        ActivitySettingBinding activitySettingBinding = (ActivitySettingBinding) getBinding();
        SettingItemWidget settingItemWidget = activitySettingBinding.settingTrans;
        if (deviceModel == null || (entity = deviceModel.getEntity()) == null || (str = entity.getDeviceSn()) == null) {
            str = "";
        }
        settingItemWidget.setValue(str);
        activitySettingBinding.userName.setText(UserInfoManager.Companion.instance().getDisplayName());
        UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
        if (userEntity != null) {
            TextView textView = activitySettingBinding.userName;
            Integer gender = userEntity.getGender();
            if (gender != null && gender.intValue() == 1) {
                drawable = ContextCompat.getDrawable(this, R.drawable.ic_male);
            } else {
                drawable = (gender != null && gender.intValue() == 2) ? ContextCompat.getDrawable(this, R.drawable.ic_female) : null;
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    private final void initView() {
        loadAvatar();
        ActivitySettingBinding activitySettingBinding = (ActivitySettingBinding) getBinding();
        ImageView imageView = activitySettingBinding.ivSettingBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivSettingBack");
        ExtendsKt.setDebounceClickListener$default(imageView, 0, new SettingActivity$$ExternalSyntheticLambda0(this), 1, (Object) null);
        ImageView imageView2 = activitySettingBinding.ivSettingScan;
        Intrinsics.checkNotNullExpressionValue(imageView2, "ivSettingScan");
        ExtendsKt.setDebounceClickListener$default(imageView2, 0, new SettingActivity$$ExternalSyntheticLambda2(this), 1, (Object) null);
        ImageView imageView3 = activitySettingBinding.ivSettingAvatar;
        Intrinsics.checkNotNullExpressionValue(imageView3, "ivSettingAvatar");
        ExtendsKt.setDebounceClickListener$default(imageView3, 0, new SettingActivity$$ExternalSyntheticLambda3(this), 1, (Object) null);
        LinearLayout linearLayout = activitySettingBinding.settingEditProfileLl;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "settingEditProfileLl");
        ExtendsKt.setDebounceClickListener$default(linearLayout, 0, new SettingActivity$$ExternalSyntheticLambda4(this), 1, (Object) null);
        TextView textView = activitySettingBinding.tvWelfare;
        Intrinsics.checkNotNullExpressionValue(textView, "tvWelfare");
        int i = 8;
        textView.setVisibility(8);
        TextView textView2 = activitySettingBinding.tvWelfare;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvWelfare");
        ExtendsKt.setDebounceClickListener$default(textView2, 0, new SettingActivity$$ExternalSyntheticLambda5(this), 1, (Object) null);
        TextView textView3 = activitySettingBinding.tvHelp;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvHelp");
        ExtendsKt.setDebounceClickListener$default(textView3, 0, new SettingActivity$$ExternalSyntheticLambda6(this), 1, (Object) null);
        SettingItemWidget settingItemWidget = activitySettingBinding.settingTrans;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget, "settingTrans");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget, 0, new SettingActivity$$ExternalSyntheticLambda7(this), 1, (Object) null);
        SettingItemWidget settingItemWidget2 = activitySettingBinding.settingAlert;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget2, "settingAlert");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget2, 0, new SettingActivity$$ExternalSyntheticLambda8(this), 1, (Object) null);
        TextView textView4 = activitySettingBinding.tvShare;
        Intrinsics.checkNotNullExpressionValue(textView4, "tvShare");
        ExtendsKt.setDebounceClickListener$default(textView4, 0, new SettingActivity$$ExternalSyntheticLambda9(this), 1, (Object) null);
        activitySettingBinding.clSettingHeader.setBackground(ContextCompat.getDrawable(this, ThemeManager.INSTANCE.isLight() ? R.drawable.bg_setting_header_light : R.drawable.bg_setting_header_dark));
        SettingItemWidget settingItemWidget3 = activitySettingBinding.settingTrans;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget3, "settingTrans");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget3, 0, new SettingActivity$$ExternalSyntheticLambda10(this), 1, (Object) null);
        SettingItemWidget settingItemWidget4 = activitySettingBinding.settingAlert;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget4, "settingAlert");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget4, 0, new SettingActivity$$ExternalSyntheticLambda11(this), 1, (Object) null);
        activitySettingBinding.settingAlert.hasNext(ExtendsKt.isGp());
        SettingItemWidget settingItemWidget5 = activitySettingBinding.settingUnit;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget5, "settingUnit");
        settingItemWidget5.setVisibility(ExtendsKt.isGp() ? 0 : 8);
        activitySettingBinding.settingUnit.setValue(UnitManager.INSTANCE.getDisplayUnit());
        SettingItemWidget settingItemWidget6 = activitySettingBinding.settingUnit;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget6, "settingUnit");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget6, 0, new SettingActivity$$ExternalSyntheticLambda12(this, activitySettingBinding), 1, (Object) null);
        SettingItemWidget settingItemWidget7 = activitySettingBinding.settingTimezoneHistory;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget7, "settingTimezoneHistory");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget7, 0, new SettingActivity$$ExternalSyntheticLambda13(this), 1, (Object) null);
        List listOf = CollectionsKt.listOf(getString(R.string.theme_dark), getString(R.string.theme_light));
        activitySettingBinding.settingTheme.setValue((String) listOf.get(ThemeManager.INSTANCE.getTheme().getIndex()));
        SettingItemWidget settingItemWidget8 = activitySettingBinding.settingTheme;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget8, "settingTheme");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget8, 0, new SettingActivity$$ExternalSyntheticLambda14(this, listOf, activitySettingBinding), 1, (Object) null);
        SettingItemWidget settingItemWidget9 = activitySettingBinding.settingPermission;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget9, "settingPermission");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget9, 0, new SettingActivity$$ExternalSyntheticLambda15(this), 1, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new SettingActivity$initView$1$16(activitySettingBinding, (Continuation<? super SettingActivity$initView$1$16>) null), 3, (Object) null);
        SettingItemWidget settingItemWidget10 = activitySettingBinding.settingLanguage;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget10, "settingLanguage");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget10, 0, new SettingActivity$$ExternalSyntheticLambda16(this, activitySettingBinding), 1, (Object) null);
        SettingItemWidget settingItemWidget11 = activitySettingBinding.settingAccountSecurity;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget11, "settingAccountSecurity");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget11, 0, new SettingActivity$$ExternalSyntheticLambda17(this), 1, (Object) null);
        SettingItemWidget settingItemWidget12 = activitySettingBinding.settingAbout;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget12, "settingAbout");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget12, 0, new SettingActivity$$ExternalSyntheticLambda18(this), 1, (Object) null);
        SettingItemWidget settingItemWidget13 = activitySettingBinding.settingAppInfo;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget13, "settingAppInfo");
        View view = settingItemWidget13;
        if (ExtendsKt.isGp()) {
            i = 0;
        }
        view.setVisibility(i);
        SettingItemWidget settingItemWidget14 = activitySettingBinding.settingAppInfo;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget14, "settingAppInfo");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget14, 0, new SettingActivity$$ExternalSyntheticLambda19(this), 1, (Object) null);
        SettingItemWidget settingItemWidget15 = activitySettingBinding.settingUploadLog;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget15, "settingUploadLog");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget15, 0, new SettingActivity$$ExternalSyntheticLambda1(this), 1, (Object) null);
        TextView textView5 = activitySettingBinding.txtVersion;
        Intrinsics.checkNotNullExpressionValue("Version 1.7.1", "toString(...)");
        textView5.setText("Version 1.7.1");
        TextView textView6 = activitySettingBinding.txtTrademark;
        String str = "Copyright ©2011-" + Calendar.getInstance().get(1);
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        textView6.setText(str);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$2(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        settingActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$3(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        Context context = settingActivity;
        if (settingActivity.checkSelfPermission(context, PermissionGroups.INSTANCE.getCamera()) == null) {
            QrCodeScanActivity.Companion.start(context, 2);
            return;
        }
        EnquireManager instance = EnquireManager.Companion.instance();
        String string = settingActivity.getString(R.string.permission_camera_title_ph, new Object[]{settingActivity.getString(R.string.app_name)});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = settingActivity.getString(R.string.permission_camera_desc);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        EnquireManager.showEnquireOrNot$default(instance, context, string, string2, new SettingActivity$initView$1$2$1(settingActivity), (Function0) null, (String) null, 16, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$4(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        try {
            PermissionsUtil.INSTANCE.checkAndRequestPermissions(settingActivity, PermissionGroups.INSTANCE.getStorage(), new SettingActivity$initView$1$3$1(settingActivity));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$5(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        ActivityUtil.INSTANCE.toActivity(settingActivity, ProfileSettingsActivity.class);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$6(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        WebActivity.Companion.loadWeb$default(WebActivity.Companion, settingActivity, (String) null, SettingActivityKt.getWelfareCenterUrl(), true, "welfare_center", 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$7(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        String curLanguageTag = LanguageResourceManager.INSTANCE.getCurLanguageTag();
        int i = ThemeManager.INSTANCE.getTheme() == ThemeManager.Theme.LIGHT ? 1 : 2;
        String string = settingActivity.getString(R.string.help);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        WebActivity.Companion.loadWeb(settingActivity, string, Constants.INSTANCE.getURL_HELPER_CENTER() + "?language=" + curLanguageTag + "&theme=" + i + "&brand=aidex-x", true, "help_center");
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$8(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        settingActivity.startActivity(new Intent(settingActivity, TransmitterActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$9(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        settingActivity.startActivity(new Intent(settingActivity, AlertSettingsActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$10(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        settingActivity.startActivity(new Intent(settingActivity, ShareFollowActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$11(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        settingActivity.startActivity(new Intent(settingActivity, TransmitterActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$12(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        settingActivity.startActivity(new Intent(settingActivity, AlertSettingsActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$13(SettingActivity settingActivity, ActivitySettingBinding activitySettingBinding, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        Intrinsics.checkNotNullParameter(activitySettingBinding, "$this_apply");
        new Dialogs.Picker(settingActivity).singlePick(settingActivity.units, UnitManager.INSTANCE.getGlucoseUnit().getIndex(), new SettingActivity$initView$1$12$1(activitySettingBinding, settingActivity));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$14(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        settingActivity.startActivity(new Intent(settingActivity, TimezoneHistoryActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$15(SettingActivity settingActivity, List list, ActivitySettingBinding activitySettingBinding, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        Intrinsics.checkNotNullParameter(list, "$themes");
        Intrinsics.checkNotNullParameter(activitySettingBinding, "$this_apply");
        new Dialogs.Picker(settingActivity).singlePick(list, ThemeManager.INSTANCE.getTheme().getIndex(), new SettingActivity$initView$1$14$1(activitySettingBinding, list));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$16(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        ActivityUtil.INSTANCE.toActivity(settingActivity, PermissionCheckActivity.class);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$17(SettingActivity settingActivity, ActivitySettingBinding activitySettingBinding, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        Intrinsics.checkNotNullParameter(activitySettingBinding, "$this_apply");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(settingActivity), (CoroutineContext) null, (CoroutineStart) null, new SettingActivity$initView$1$17$1(settingActivity, activitySettingBinding, (Continuation<? super SettingActivity$initView$1$17$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$18(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        settingActivity.startActivity(new Intent(settingActivity, AccountSecurityActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$19(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        settingActivity.startActivity(new Intent(settingActivity, AboutActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$20(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        settingActivity.startActivity(new Intent(settingActivity, AppInfoActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$24$lambda$21(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        if (NetUtil.isNetAvailable(settingActivity)) {
            Dialogs.INSTANCE.showWait(settingActivity.getString(R.string.com_actionState_doing, new Object[]{settingActivity.getString(R.string.com_action_upload)}));
            LogUtil.Companion.uploadLog(LifecycleOwnerKt.getLifecycleScope(settingActivity), false);
            return;
        }
        String string = settingActivity.getString(R.string.com_network_unused);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ExtendsKt.toastShort(string);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Uri uri = null;
        if (i2 == -1) {
            if (i == this.REQUEST_CODE_GALLERY) {
                Uri genAvatarFile = genAvatarFile();
                UCrop.Options options = new UCrop.Options();
                options.setCompressionQuality(100);
                options.setActiveControlsWidgetColor(getColor(R.color.green_65));
                options.setLogoColor(getColor(R.color.green_65));
                if (intent != null) {
                    uri = intent.getData();
                }
                Intrinsics.checkNotNull(uri);
                UCrop.of(uri, genAvatarFile).withAspectRatio(1.0f, 1.0f).withMaxResultSize(200, 200).withOptions(options).start(this);
            } else if (i == 69 && intent != null) {
                Uri output = UCrop.getOutput(intent);
                LogUtil.Companion.d$default(LogUtil.Companion, "剪裁结果 : " + output, (String) null, 2, (Object) null);
                if (output != null) {
                    File file = UriKt.toFile(output);
                    if (!file.exists() || !file.isFile() || file.length() <= 5242880) {
                        WaitDialog.show((Activity) this, (CharSequence) getString(R.string.com_loading));
                        if (BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new SettingActivity$onActivityResult$2$1$1(output, this, (Continuation<? super SettingActivity$onActivityResult$2$1$1>) null), 3, (Object) null) != null) {
                            return;
                        }
                    } else {
                        String string = getString(R.string.com_photoPicker_pictureTooLarge);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        ExtendsKt.toast(string);
                        return;
                    }
                }
                String string2 = getString(R.string.com_state_failure);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                ExtendsKt.toast(string2);
                Unit unit = Unit.INSTANCE;
            }
        } else if (i == 69 && i2 == 96 && intent != null) {
            LogUtil.Companion.xLogE$default(LogUtil.Companion, "图片裁剪出错：" + UCrop.getError(intent), (String) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void loadAvatar() {
        String avatar;
        UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
        if (userEntity != null && (avatar = userEntity.getAvatar()) != null) {
            ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(avatar).placeholder(R.drawable.ic_default_avatar)).error(R.drawable.ic_default_avatar)).apply((BaseRequestOptions<?>) RequestOptions.circleCropTransform()).into(((ActivitySettingBinding) getBinding()).ivSettingAvatar);
        }
    }

    private final Uri genAvatarFile() {
        File file = new File(FileUtils.INSTANCE.getDownloadDir("avatar"), "avatar.jpg");
        FileUtils.INSTANCE.delete(file);
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(...)");
        return fromFile;
    }

    public ActivitySettingBinding getViewBinding() {
        ActivitySettingBinding inflate = ActivitySettingBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
