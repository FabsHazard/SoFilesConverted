package com.microtech.aidexx.common.compliance;

import android.content.Context;
import android.content.DialogInterface;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.views.dialog.standard.StandardDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/common/compliance/EnquireManager;", "", "()V", "dialog", "Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;", "getDialog", "()Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;", "setDialog", "(Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;)V", "showEnquireOrNot", "context", "Landroid/content/Context;", "title", "", "content", "onPositive", "Lkotlin/Function0;", "", "onNegative", "flag", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EnquireManager.kt */
public final class EnquireManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final EnquireManager INSTANCE = new EnquireManager();
    private StandardDialog dialog;

    private EnquireManager() {
    }

    public final StandardDialog getDialog() {
        return this.dialog;
    }

    public final void setDialog(StandardDialog standardDialog) {
        this.dialog = standardDialog;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/common/compliance/EnquireManager$Companion;", "", "()V", "INSTANCE", "Lcom/microtech/aidexx/common/compliance/EnquireManager;", "instance", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EnquireManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EnquireManager instance() {
            return EnquireManager.INSTANCE;
        }
    }

    public static /* synthetic */ StandardDialog showEnquireOrNot$default(EnquireManager enquireManager, Context context, String str, String str2, Function0 function0, Function0 function02, String str3, int i, Object obj) {
        return enquireManager.showEnquireOrNot(context, str, str2, function0, (i & 16) != 0 ? null : function02, (i & 32) != 0 ? null : str3);
    }

    public final StandardDialog showEnquireOrNot(Context context, String str, String str2, Function0<Unit> function0, Function0<Unit> function02, String str3) {
        StandardDialog standardDialog;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        if (((str3 != null && !MmkvManager.INSTANCE.getEnquireFlag(str3)) || str3 == null) && ((standardDialog = this.dialog) == null || (standardDialog != null && !standardDialog.isShowing()))) {
            StandardDialog create = new StandardDialog.Setter(context).title(str).content(str2).setPositive(context.getString(R.string.com_allow), new EnquireManager$$ExternalSyntheticLambda0(str3, function0)).setCancel(context.getString(R.string.com_disallow), new EnquireManager$$ExternalSyntheticLambda1(function02)).create(1);
            this.dialog = create;
            if (create != null) {
                create.show();
            }
            return this.dialog;
        } else if (function0 == null) {
            return null;
        } else {
            function0.invoke();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static final void showEnquireOrNot$lambda$1(String str, Function0 function0, DialogInterface dialogInterface, int i) {
        if (str != null) {
            MmkvManager.INSTANCE.saveEnquireFlag(str, true);
        }
        if (function0 != null) {
            function0.invoke();
        }
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void showEnquireOrNot$lambda$2(Function0 function0, DialogInterface dialogInterface, int i) {
        if (function0 != null) {
            function0.invoke();
        }
        dialogInterface.dismiss();
    }
}
