package com.microtech.aidexx.ui.main.trend;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.FileProvider;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.ActivityPdfBinding;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/PdfActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityPdfBinding;", "()V", "getViewBinding", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "shareTxtFile", "filePath", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PdfActivity.kt */
public final class PdfActivity extends BaseActivity<BaseViewModel, ActivityPdfBinding> {
    public ActivityPdfBinding getViewBinding() {
        ActivityPdfBinding inflate = ActivityPdfBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityPdfBinding) getBinding()).getRoot());
        ((ActivityPdfBinding) getBinding()).actionBar.getLeftIcon().setOnClickListener(new PdfActivity$$ExternalSyntheticLambda0(this));
        String stringExtra = getIntent().getStringExtra("path");
        if (stringExtra != null) {
            ((ActivityPdfBinding) getBinding()).pvReport.fromFile(new File(stringExtra)).enableSwipe(true).load();
            ((ActivityPdfBinding) getBinding()).actionBar.getRightIcon().setOnClickListener(new PdfActivity$$ExternalSyntheticLambda1(this, stringExtra));
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(PdfActivity pdfActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfActivity, "this$0");
        pdfActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(PdfActivity pdfActivity, String str, View view) {
        Intrinsics.checkNotNullParameter(pdfActivity, "this$0");
        pdfActivity.shareTxtFile(str);
    }

    private final void shareTxtFile(String str) {
        File file = new File(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + ".FileProvider", file);
        Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.setType("application/pdf");
        intent.setFlags(268435456);
        intent.addFlags(1);
        startActivity(Intent.createChooser(intent, getString(R.string.trend_agp_report)));
    }
}
