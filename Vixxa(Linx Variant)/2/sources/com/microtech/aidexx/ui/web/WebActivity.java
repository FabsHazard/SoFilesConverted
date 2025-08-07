package com.microtech.aidexx.ui.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.webkit.WebView;
import androidx.core.content.IntentCompat;
import com.microtech.aidexx.IntentKey;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityWebBinding;
import com.microtech.aidexx.utils.ProcessUtil;
import com.microtech.aidexx.utils.ToastUtil;
import com.microtech.aidexx.views.ActionBarWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/ui/web/WebActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityWebBinding;", "()V", "fitWebOrientation", "", "orientation", "", "getViewBinding", "load", "", "it", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "shareLink", "link", "wxAvailable", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: WebActivity.kt */
public final class WebActivity extends BaseActivity<BaseViewModel, ActivityWebBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public ActivityWebBinding getViewBinding() {
        ActivityWebBinding inflate = ActivityWebBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityWebBinding) getBinding()).getRoot());
        ((ActivityWebBinding) getBinding()).actionBar.getLeftIcon().setOnClickListener(new WebActivity$$ExternalSyntheticLambda0(this));
        ((ActivityWebBinding) getBinding()).actionBar.setTitle(getIntent().getStringExtra(IntentKey.WEB_TITLE));
        ((ActivityWebBinding) getBinding()).webBase.setFullscreenContainer(((ActivityWebBinding) getBinding()).fullscreenContainer);
        ((ActivityWebBinding) getBinding()).webBase.loadUrl(getIntent().getStringExtra(IntentKey.WEB_URL));
        String stringExtra = getIntent().getStringExtra(IntentKey.WHERE_FROM);
        if (getIntent().getBooleanExtra(IntentKey.IS_FULL_SCREEN, false)) {
            ((ActivityWebBinding) getBinding()).actionBar.setVisibility(8);
        }
        ActionBarWidget actionBarWidget = ((ActivityWebBinding) getBinding()).actionBar;
        Intrinsics.checkNotNullExpressionValue(actionBarWidget, "actionBar");
        if (actionBarWidget.getVisibility() != 0) {
            ((ActivityWebBinding) getBinding()).webBase.setPadding(0, ExtendsKt.getStatusBarHeight(), 0, 0);
        }
        ((ActivityWebBinding) getBinding()).webBase.setOnLoadingUrlListener(new WebActivity$$ExternalSyntheticLambda1(stringExtra, this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(WebActivity webActivity, View view) {
        Intrinsics.checkNotNullParameter(webActivity, "this$0");
        webActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final boolean onCreate$lambda$1(String str, WebActivity webActivity, String str2) {
        Intrinsics.checkNotNullParameter(webActivity, "this$0");
        if ((str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "welfare_center", false, 2, (Object) null)) || ((str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "third-part", false, 2, (Object) null)) || (str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "help_center", false, 2, (Object) null)))) {
            Uri parse = Uri.parse(str2);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            String scheme = parse.getScheme();
            Intrinsics.checkNotNull(str2);
            if (StringsKt.endsWith$default(str2, "close", false, 2, (Object) null)) {
                webActivity.finish();
                return true;
            }
            CharSequence charSequence = str2;
            if (StringsKt.contains$default(charSequence, (CharSequence) "https://m.tb.cn", false, 2, (Object) null)) {
                return webActivity.load(str2);
            }
            if (StringsKt.contains$default(charSequence, (CharSequence) "https://item.m.jd.com", false, 2, (Object) null)) {
                return webActivity.load(str2);
            }
            if (StringsKt.contains$default(charSequence, (CharSequence) "https://tuicashier.youzan.com", false, 2, (Object) null)) {
                return webActivity.load(str2);
            }
            if (StringsKt.equals$default(scheme, "weixin", false, 2, (Object) null)) {
                if (webActivity.wxAvailable()) {
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(268435456);
                    webActivity.startActivity(intent);
                    return true;
                }
                ToastUtil.INSTANCE.showShort("此设备未安装微信");
                return true;
            } else if (StringsKt.equals$default(scheme, "weitai", false, 2, (Object) null) && StringsKt.contains$default(charSequence, (CharSequence) "sharefromapp", false, 2, (Object) null)) {
                String queryParameter = parse.getQueryParameter("url");
                String str3 = "";
                if (queryParameter == null) {
                    queryParameter = str3;
                }
                String queryParameter2 = parse.getQueryParameter("title");
                if (queryParameter2 != null) {
                    str3 = queryParameter2;
                }
                if (queryParameter.length() <= 0 || str3.length() <= 0) {
                    return true;
                }
                webActivity.shareLink("【微泰医疗】" + queryParameter + " 【" + str3 + "】\n点击链接直接打开");
                return true;
            }
        }
        return false;
    }

    private final void shareLink(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra(IntentCompat.EXTRA_HTML_TEXT, Html.fromHtml(str));
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/html");
        intent.setFlags(268435456);
        startActivity(Intent.createChooser(intent, getString(R.string.share_file_title)));
    }

    private final boolean wxAvailable() {
        return ProcessUtil.isInstalled(this, "com.tencent.mm");
    }

    private final boolean load(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return false;
        }
        ((ActivityWebBinding) getBinding()).webBase.loadUrl(str);
        return true;
    }

    public void onBackPressed() {
        WebView webView = ((ActivityWebBinding) getBinding()).webBase.mWebView;
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
    }

    public final void fitWebOrientation(int i) {
        Window window = getWindow();
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        if (i == 2) {
            if (Build.VERSION.SDK_INT >= 30) {
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    insetsController.hide(WindowInsets.Type.statusBars());
                    insetsController.hide(WindowInsets.Type.navigationBars());
                    insetsController.setSystemBarsBehavior(2);
                    return;
                }
                return;
            }
            decorView.setSystemUiVisibility(5894);
        } else if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false);
            window.setStatusBarColor(0);
            WindowInsetsController insetsController2 = window.getInsetsController();
            if (insetsController2 != null) {
                insetsController2.show(WindowInsets.Type.statusBars());
                insetsController2.show(WindowInsets.Type.navigationBars());
            }
        } else {
            decorView.setSystemUiVisibility(0);
            window.setStatusBarColor(0);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 1280);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/ui/web/WebActivity$Companion;", "", "()V", "loadWeb", "", "context", "Landroid/content/Context;", "title", "", "url", "fullScreen", "", "from", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: WebActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void loadWeb$default(Companion companion, Context context, String str, String str2, boolean z, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "";
            }
            String str4 = str;
            if ((i & 8) != 0) {
                z = false;
            }
            boolean z2 = z;
            if ((i & 16) != 0) {
                str3 = null;
            }
            companion.loadWeb(context, str4, str2, z2, str3);
        }

        public final void loadWeb(Context context, String str, String str2, boolean z, String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "url");
            Intent intent = new Intent(context, WebActivity.class);
            intent.putExtra(IntentKey.WEB_TITLE, str);
            intent.putExtra(IntentKey.WEB_URL, str2);
            intent.putExtra(IntentKey.IS_FULL_SCREEN, z);
            intent.putExtra(IntentKey.WHERE_FROM, str3);
            context.startActivity(intent);
        }
    }
}
