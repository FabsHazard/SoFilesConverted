package com.microtech.aidexx.ui.pair;

import android.content.Intent;
import android.view.View;
import com.microtech.aidexx.ui.qrcode.QrCodeScanActivity;
import com.microtech.aidexx.views.HyperLinkText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/pair/PairCheckDialog$build$1", "Lcom/microtech/aidexx/views/HyperLinkText;", "onClick", "", "widget", "Landroid/view/View;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairCheckDialog.kt */
public final class PairCheckDialog$build$1 extends HyperLinkText {
    final /* synthetic */ PairCheckDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PairCheckDialog$build$1(PairCheckDialog pairCheckDialog, int i) {
        super(i);
        this.this$0 = pairCheckDialog;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        this.this$0.mContext.startActivity(new Intent(this.this$0.mContext, QrCodeScanActivity.class));
    }
}
