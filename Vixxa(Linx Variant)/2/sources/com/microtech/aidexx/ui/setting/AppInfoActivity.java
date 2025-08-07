package com.microtech.aidexx.ui.setting;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.AppInformation;
import com.microtech.aidexx.databinding.ActivityAppInfoBinding;
import com.microtech.aidexx.ui.web.WebActivity;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.StringUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\tH\u0014J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/microtech/aidexx/ui/setting/AppInfoActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityAppInfoBinding;", "()V", "hasLoadedData", "", "getViewBinding", "initData", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setData", "appInformation", "Lcom/microtech/aidexx/common/net/entity/AppInformation;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AppInfoActivity.kt */
public final class AppInfoActivity extends BaseActivity<BaseViewModel, ActivityAppInfoBinding> {
    private boolean hasLoadedData;

    public ActivityAppInfoBinding getViewBinding() {
        ActivityAppInfoBinding inflate = ActivityAppInfoBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityAppInfoBinding) getBinding()).getRoot());
        ActivityAppInfoBinding activityAppInfoBinding = (ActivityAppInfoBinding) getBinding();
        activityAppInfoBinding.softwareCompleteVersion.setText("V 1.7.1");
        TextView textView = activityAppInfoBinding.appInfoCompanyLink;
        Intrinsics.checkNotNullExpressionValue(textView, "appInfoCompanyLink");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new AppInfoActivity$$ExternalSyntheticLambda0(this), 1, (Object) null);
        String string = getString(R.string.appInfo_instructions_url);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.appInfo_instructions, new Object[]{string});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CharSequence charSequence = string2;
        SpannableString spannableString = new SpannableString(charSequence);
        int indexOf$default = StringsKt.indexOf$default(charSequence, string, 0, false, 6, (Object) null);
        spannableString.setSpan(new StringUtils.CustomHyperText(this, string, "https://" + string, 1, getColor(R.color.green_65)), indexOf$default, string.length() + indexOf$default, 33);
        activityAppInfoBinding.appInfoGuideLink.setText(spannableString);
        activityAppInfoBinding.appInfoGuideLink.setMovementMethod(LinkMovementMethod.getInstance());
        ExtendsKt.setDebounceClickListener$default(activityAppInfoBinding.actionBar.getLeftIcon(), 0, new AppInfoActivity$$ExternalSyntheticLambda1(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$0(AppInfoActivity appInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(appInfoActivity, "this$0");
        WebActivity.Companion.loadWeb$default(WebActivity.Companion, appInfoActivity, (String) null, "https://" + appInfoActivity.getString(R.string.appInfo_company_url), false, (String) null, 26, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(AppInfoActivity appInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(appInfoActivity, "this$0");
        appInfoActivity.finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.hasLoadedData) {
            initData();
        }
    }

    private final void initData() {
        if (!NetUtil.isNetAvailable(this)) {
            String string = getString(R.string.com_network_unused);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new AppInfoActivity$initData$1(this, (Continuation<? super AppInfoActivity$initData$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void setData(AppInformation appInformation) {
        if (appInformation != null) {
            this.hasLoadedData = true;
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), (CoroutineStart) null, new AppInfoActivity$setData$1$1(this, appInformation, (Continuation<? super AppInfoActivity$setData$1$1>) null), 2, (Object) null);
        }
    }
}
