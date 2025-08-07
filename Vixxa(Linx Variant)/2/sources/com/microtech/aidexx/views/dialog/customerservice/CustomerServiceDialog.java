package com.microtech.aidexx.views.dialog.customerservice;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.common.compliance.EnquireFlags;
import com.microtech.aidexx.common.compliance.EnquireManager;
import com.microtech.aidexx.ui.main.home.customerservice.CustomServiceActivity;
import com.microtech.aidexx.utils.DensityUtils;
import com.microtech.aidexx.utils.ThemeManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\rB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/views/dialog/customerservice/CustomerServiceDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "cancelable", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V", "Setter", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomerServiceDialog.kt */
public final class CustomerServiceDialog extends Dialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerServiceDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerServiceDialog(Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerServiceDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010J\b\u0010\u0011\u001a\u00020\u0005H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/views/dialog/customerservice/CustomerServiceDialog$Setter;", "", "()V", "clearMessage", "Lkotlin/Function0;", "", "getClearMessage", "()Lkotlin/jvm/functions/Function0;", "mCustomerServiceDialog", "Lcom/microtech/aidexx/views/dialog/customerservice/CustomerServiceDialog;", "setMessage", "getSetMessage", "tvUnread", "Landroid/widget/TextView;", "create", "activity", "Lcom/microtech/aidexx/base/BaseActivity;", "setDialogMessageCount", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomerServiceDialog.kt */
    public static final class Setter {
        private final Function0<Unit> clearMessage = new CustomerServiceDialog$Setter$clearMessage$1(this);
        private CustomerServiceDialog mCustomerServiceDialog;
        private final Function0<Unit> setMessage = new CustomerServiceDialog$Setter$setMessage$1(this);
        private TextView tvUnread;

        public final Function0<Unit> getSetMessage() {
            return this.setMessage;
        }

        public final Function0<Unit> getClearMessage() {
            return this.clearMessage;
        }

        public final CustomerServiceDialog create(BaseActivity<?, ?> baseActivity) {
            Drawable drawable;
            Intrinsics.checkNotNullParameter(baseActivity, "activity");
            Context context = baseActivity;
            CustomerServiceDialog customerServiceDialog = new CustomerServiceDialog(context, R.style.BottomDialog);
            this.mCustomerServiceDialog = customerServiceDialog;
            customerServiceDialog.setOnDismissListener(new CustomerServiceDialog$Setter$$ExternalSyntheticLambda0(this));
            WindowManager.LayoutParams layoutParams = null;
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_customer_service_dialog, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.iv_close_service_dialog)).setOnClickListener(new CustomerServiceDialog$Setter$$ExternalSyntheticLambda1(this));
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.cl_online_service);
            View findViewById = inflate.findViewById(R.id.tv_dialog_message_unread);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.tvUnread = (TextView) findViewById;
            setDialogMessageCount();
            ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.cl_tel_service);
            if (constraintLayout != null) {
                constraintLayout.setOnClickListener(new CustomerServiceDialog$Setter$$ExternalSyntheticLambda2(this, baseActivity));
            }
            MessageManager.Companion.instance().setClearMessageListener(this.clearMessage);
            MessageManager.Companion.instance().setAddMessageListener(this.setMessage);
            if (constraintLayout2 != null) {
                constraintLayout2.setOnClickListener(new CustomerServiceDialog$Setter$$ExternalSyntheticLambda3(this, baseActivity));
            }
            CustomerServiceDialog customerServiceDialog2 = this.mCustomerServiceDialog;
            if (customerServiceDialog2 != null) {
                customerServiceDialog2.setContentView(inflate);
            }
            CustomerServiceDialog customerServiceDialog3 = this.mCustomerServiceDialog;
            if (customerServiceDialog3 != null) {
                customerServiceDialog3.setCanceledOnTouchOutside(true);
            }
            CustomerServiceDialog customerServiceDialog4 = this.mCustomerServiceDialog;
            Window window = customerServiceDialog4 != null ? customerServiceDialog4.getWindow() : null;
            if (window != null) {
                layoutParams = window.getAttributes();
            }
            if (layoutParams != null) {
                layoutParams.gravity = 80;
            }
            if (layoutParams != null) {
                layoutParams.width = -1;
            }
            int windowHeight = DensityUtils.getWindowHeight(baseActivity);
            if (layoutParams != null) {
                layoutParams.height = (int) (((double) windowHeight) * 0.5d);
            }
            if (window != null) {
                window.setAttributes(layoutParams);
            }
            if (window != null) {
                if (ThemeManager.INSTANCE.isLight()) {
                    drawable = ContextCompat.getDrawable(context, R.drawable.bg_follow_list_dialog_light);
                } else {
                    drawable = ContextCompat.getDrawable(context, R.drawable.bg_follow_list_dialog_dark);
                }
                window.setBackgroundDrawable(drawable);
            }
            return this.mCustomerServiceDialog;
        }

        /* access modifiers changed from: private */
        public static final void create$lambda$0(Setter setter, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(setter, "this$0");
            MessageManager.Companion.instance().removeAddMessageListener(setter.setMessage);
            MessageManager.Companion.instance().removeClearMessageListener(setter.clearMessage);
        }

        /* access modifiers changed from: private */
        public static final void create$lambda$1(Setter setter, View view) {
            Intrinsics.checkNotNullParameter(setter, "this$0");
            CustomerServiceDialog customerServiceDialog = setter.mCustomerServiceDialog;
            if (customerServiceDialog != null) {
                customerServiceDialog.dismiss();
            }
        }

        /* access modifiers changed from: private */
        public static final void create$lambda$2(Setter setter, BaseActivity baseActivity, View view) {
            Intrinsics.checkNotNullParameter(setter, "this$0");
            Intrinsics.checkNotNullParameter(baseActivity, "$activity");
            MessageManager.Companion.instance().clearMessage();
            CustomerServiceDialog customerServiceDialog = setter.mCustomerServiceDialog;
            if (customerServiceDialog != null) {
                customerServiceDialog.dismiss();
            }
            baseActivity.startActivity(new Intent(baseActivity, CustomServiceActivity.class));
        }

        /* access modifiers changed from: private */
        public static final void create$lambda$4(Setter setter, BaseActivity baseActivity, View view) {
            Intrinsics.checkNotNullParameter(setter, "this$0");
            Intrinsics.checkNotNullParameter(baseActivity, "$activity");
            CustomerServiceDialog customerServiceDialog = setter.mCustomerServiceDialog;
            if (customerServiceDialog != null) {
                customerServiceDialog.dismiss();
            }
            String string = baseActivity.getString(R.string.permission_tel_title_ph, new Object[]{baseActivity.getString(R.string.app_name)});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = baseActivity.getString(R.string.permission_tel_desc);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            EnquireManager.Companion.instance().showEnquireOrNot(baseActivity, string, string2, new CustomerServiceDialog$Setter$create$4$1$1(baseActivity), CustomerServiceDialog$Setter$create$4$1$2.INSTANCE, EnquireFlags.CUSTOMER_SERVICE_PHONE_CALL_ENQUIRE);
        }

        /* access modifiers changed from: private */
        public final void setDialogMessageCount() {
            CharSequence messageCountStr = MessageManager.Companion.instance().getMessageCountStr();
            TextView textView = null;
            if (messageCountStr.length() == 0) {
                TextView textView2 = this.tvUnread;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvUnread");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(8);
                return;
            }
            TextView textView3 = this.tvUnread;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvUnread");
                textView3 = null;
            }
            textView3.setText(messageCountStr);
            TextView textView4 = this.tvUnread;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvUnread");
            } else {
                textView = textView4;
            }
            textView.setVisibility(0);
        }
    }
}
