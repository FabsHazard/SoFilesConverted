package com.microtech.aidexx.ui.main.event.dialog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: InsulinPresetDialog.kt */
final class InsulinPresetDialog$intDeleteUI$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InsulinPresetDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InsulinPresetDialog$intDeleteUI$1$1(InsulinPresetDialog insulinPresetDialog) {
        super(0);
        this.this$0 = insulinPresetDialog;
    }

    public final void invoke() {
        this.this$0.dismiss();
        Function1 access$getOnDeleteClick$p = this.this$0.onDeleteClick;
        if (access$getOnDeleteClick$p != null) {
            access$getOnDeleteClick$p.invoke(this.this$0.oldInsulinEntity);
        }
    }
}
