package com.microtech.aidexx.ui.pair;

import android.content.Intent;
import android.view.View;
import com.microtech.aidexx.views.HyperLinkText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/pair/TransmitterActivity$initView$1", "Lcom/microtech/aidexx/views/HyperLinkText;", "onClick", "", "widget", "Landroid/view/View;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterActivity.kt */
public final class TransmitterActivity$initView$1 extends HyperLinkText {
    final /* synthetic */ TransmitterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterActivity$initView$1(TransmitterActivity transmitterActivity, int i) {
        super(i);
        this.this$0 = transmitterActivity;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        this.this$0.startActivity(new Intent(this.this$0, PairedHistoryActivity.class));
    }
}
