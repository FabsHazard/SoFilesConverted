package com.microtech.aidexx.ui.main.home.customerservice;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.ActivityCustomServiceBinding;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\"\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\"\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000b\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/customerservice/CustomServiceActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityCustomServiceBinding;", "()V", "FILE_CHOOSER_RESULT_CODE", "", "uploadMessage", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "uploadMessageAboveL", "", "clearMessage", "", "getViewBinding", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onActivityResultAboveL", "intent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomServiceActivity.kt */
public final class CustomServiceActivity extends BaseActivity<BaseViewModel, ActivityCustomServiceBinding> {
    private final int FILE_CHOOSER_RESULT_CODE = 10000;
    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> uploadMessageAboveL;

    private final void clearMessage() {
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(View view) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityCustomServiceBinding) getBinding()).getRoot());
        clearMessage();
        ((ActivityCustomServiceBinding) getBinding()).actionBar.getLeftIcon().setOnClickListener(new CustomServiceActivity$$ExternalSyntheticLambda0());
        ((ActivityCustomServiceBinding) getBinding()).actionBar.setTitle(getString(R.string.service_online));
    }

    public ActivityCustomServiceBinding getViewBinding() {
        ActivityCustomServiceBinding inflate = ActivityCustomServiceBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        clearMessage();
        ((ActivityCustomServiceBinding) getBinding()).webCustomerService.mWebView.destroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == this.FILE_CHOOSER_RESULT_CODE) {
            ValueCallback<Uri[]> valueCallback = ((ActivityCustomServiceBinding) getBinding()).webCustomerService.uploadMessageAboveL;
            this.uploadMessageAboveL = valueCallback;
            if (valueCallback != null) {
                onActivityResultAboveL(i, i2, intent);
            }
        }
    }

    private final void onActivityResultAboveL(int i, int i2, Intent intent) {
        Uri[] uriArr;
        Uri parse;
        ValueCallback<Uri[]> valueCallback = ((ActivityCustomServiceBinding) getBinding()).webCustomerService.uploadMessageAboveL;
        this.uploadMessageAboveL = valueCallback;
        if (i == this.FILE_CHOOSER_RESULT_CODE && valueCallback != null) {
            if (i2 != -1 || intent == null) {
                uriArr = null;
            } else {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    uriArr = new Uri[0];
                    int itemCount = clipData.getItemCount();
                    for (int i3 = 0; i3 < itemCount; i3++) {
                        Uri uri = clipData.getItemAt(i3).getUri();
                        Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
                        ArraysKt.plus((T[]) (Object[]) uriArr, uri);
                    }
                } else {
                    uriArr = null;
                }
                if (!(dataString == null || (parse = Uri.parse(dataString)) == null)) {
                    uriArr = new Uri[]{parse};
                }
            }
            ValueCallback<Uri[]> valueCallback2 = this.uploadMessageAboveL;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(uriArr);
            }
            ((ActivityCustomServiceBinding) getBinding()).webCustomerService.uploadMessageAboveL = null;
            this.uploadMessageAboveL = null;
        }
    }
}
