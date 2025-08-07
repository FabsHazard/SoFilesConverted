package com.microtech.aidexx.views.dialog.standard;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.microtech.aidexx.R;

public class StandardInputDialog extends AlertDialog {
    private long tag;

    protected StandardInputDialog(Context context) {
        super(context);
    }

    protected StandardInputDialog(Context context, int i) {
        super(context, i);
    }

    public void setTimeTag() {
        this.tag = System.currentTimeMillis();
    }

    public long getTag() {
        return this.tag;
    }

    public static class Setter {
        private DialogInterface.OnClickListener cancelClickListener;
        private DialogDismissListener dismissListener;
        private String mCancel;
        private String mConfirm;
        private final Context mContext;
        private int mGravity = 17;
        private String mHint;
        private int mInputType;
        private StandardInputDialog mStandardDialog;
        private String mTitle;
        private InputCompleteListener positiveClickListener;

        public StandardInputDialog create() {
            StandardInputDialog standardInputDialog = new StandardInputDialog(this.mContext, R.style.StandardDialog);
            this.mStandardDialog = standardInputDialog;
            standardInputDialog.setTimeTag();
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.layout_dialog_input, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.input_dialog_et);
            TextView textView = (TextView) inflate.findViewById(R.id.dialog_input_cancel);
            TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_input_confirm);
            View findViewById = inflate.findViewById(R.id.input_dialog_stick);
            TextView textView3 = (TextView) inflate.findViewById(R.id.input_dialog_title);
            String str = this.mHint;
            if (str != null) {
                editText.setHint(str);
            }
            String str2 = this.mTitle;
            if (str2 == null) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(str2);
            }
            if (this.cancelClickListener == null) {
                textView.setVisibility(8);
                findViewById.setVisibility(8);
            } else {
                textView.setText(this.mCancel);
                textView.setOnClickListener(new StandardInputDialog$Setter$$ExternalSyntheticLambda0(this));
            }
            if (this.positiveClickListener == null) {
                textView2.setVisibility(8);
                findViewById.setVisibility(8);
            } else {
                textView2.setText(this.mConfirm);
                textView2.setOnClickListener(new StandardInputDialog$Setter$$ExternalSyntheticLambda1(this, editText));
            }
            this.mStandardDialog.setOnDismissListener(new StandardInputDialog$Setter$$ExternalSyntheticLambda2(this));
            this.mStandardDialog.setView(inflate);
            this.mStandardDialog.setCanceledOnTouchOutside(false);
            this.mStandardDialog.getWindow().setGravity(this.mGravity);
            return this.mStandardDialog;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$create$0$com-microtech-aidexx-views-dialog-standard-StandardInputDialog$Setter  reason: not valid java name */
        public /* synthetic */ void m291lambda$create$0$commicrotechaidexxviewsdialogstandardStandardInputDialog$Setter(View view) {
            this.cancelClickListener.onClick(this.mStandardDialog, -2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$create$1$com-microtech-aidexx-views-dialog-standard-StandardInputDialog$Setter  reason: not valid java name */
        public /* synthetic */ void m292lambda$create$1$commicrotechaidexxviewsdialogstandardStandardInputDialog$Setter(EditText editText, View view) {
            this.positiveClickListener.onInputComplete(this.mStandardDialog, -1, editText.getText().toString());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$create$2$com-microtech-aidexx-views-dialog-standard-StandardInputDialog$Setter  reason: not valid java name */
        public /* synthetic */ void m293lambda$create$2$commicrotechaidexxviewsdialogstandardStandardInputDialog$Setter(DialogInterface dialogInterface) {
            DialogDismissListener dialogDismissListener = this.dismissListener;
            if (dialogDismissListener != null) {
                dialogDismissListener.onDismiss();
            }
        }

        public Setter(Context context) {
            this.mContext = context;
            this.mConfirm = context.getString(R.string.com_action_sure);
            this.mCancel = context.getString(R.string.com_action_cancel);
        }

        public Setter setOnDismissListener(DialogDismissListener dialogDismissListener) {
            this.dismissListener = dialogDismissListener;
            return this;
        }

        public Setter setPositive(String str, InputCompleteListener inputCompleteListener) {
            if (!TextUtils.isEmpty(str)) {
                this.mConfirm = str;
            }
            this.positiveClickListener = inputCompleteListener;
            return this;
        }

        public Setter setPositive(InputCompleteListener inputCompleteListener) {
            this.positiveClickListener = inputCompleteListener;
            return this;
        }

        public Setter setCancel(String str, DialogInterface.OnClickListener onClickListener) {
            if (!TextUtils.isEmpty(str)) {
                this.mCancel = str;
            }
            this.cancelClickListener = onClickListener;
            return this;
        }

        public Setter setCancel(DialogInterface.OnClickListener onClickListener) {
            this.cancelClickListener = onClickListener;
            return this;
        }

        public Setter hint(String str) {
            this.mHint = str;
            return this;
        }

        public Setter inputType(int i) {
            this.mInputType = i;
            return this;
        }

        public Setter title(String str) {
            this.mTitle = str;
            return this;
        }

        public Setter gravity(int i) {
            this.mGravity = i;
            return this;
        }
    }
}
