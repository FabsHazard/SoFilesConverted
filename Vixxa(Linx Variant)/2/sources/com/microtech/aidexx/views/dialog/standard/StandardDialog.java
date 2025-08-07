package com.microtech.aidexx.views.dialog.standard;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.microtech.aidexx.R;

public class StandardDialog extends AlertDialog {
    public static final int TYPE_STANDARD = 0;
    public static final int TYPE_VERTICAL = 1;
    private long tag;

    protected StandardDialog(Context context) {
        super(context);
    }

    protected StandardDialog(Context context, int i) {
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
        private String mContent;
        private final Context mContext;
        private int mGravity = 17;
        private String mNote;
        private StandardDialog mStandardDialog;
        private String mTitle;
        private DialogInterface.OnClickListener positiveClickListener;

        public StandardDialog create() {
            return create(0);
        }

        public StandardDialog create(int i) {
            StandardDialog standardDialog = new StandardDialog(this.mContext, R.style.StandardDialog);
            this.mStandardDialog = standardDialog;
            standardDialog.setTimeTag();
            View inflate = i == 1 ? LayoutInflater.from(this.mContext).inflate(R.layout.standard_dialog_vertical, (ViewGroup) null) : null;
            if (inflate == null) {
                inflate = LayoutInflater.from(this.mContext).inflate(R.layout.standard_dialog, (ViewGroup) null);
            }
            TextView textView = (TextView) inflate.findViewById(R.id.button_cancel);
            TextView textView2 = (TextView) inflate.findViewById(R.id.button_confirm);
            TextView textView3 = (TextView) inflate.findViewById(R.id.content);
            TextView textView4 = (TextView) inflate.findViewById(R.id.note);
            View findViewById = inflate.findViewById(R.id.stick);
            TextView textView5 = (TextView) inflate.findViewById(R.id.title);
            String str = this.mTitle;
            if (str == null) {
                textView5.setVisibility(8);
            } else {
                textView5.setText(str);
            }
            String str2 = this.mContent;
            if (str2 == null) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(str2);
            }
            String str3 = this.mNote;
            if (str3 == null) {
                textView4.setVisibility(8);
            } else {
                textView4.setText(str3);
            }
            if (this.cancelClickListener == null) {
                textView.setVisibility(8);
                findViewById.setVisibility(8);
            } else {
                textView.setText(this.mCancel);
                textView.setOnClickListener(new StandardDialog$Setter$$ExternalSyntheticLambda1(this));
            }
            if (this.positiveClickListener == null) {
                textView2.setVisibility(8);
                findViewById.setVisibility(8);
            } else {
                String str4 = this.mConfirm;
                if (str4 != null) {
                    textView2.setText(str4);
                }
                textView2.setOnClickListener(new StandardDialog$Setter$$ExternalSyntheticLambda2(this));
            }
            this.mStandardDialog.setOnDismissListener(new StandardDialog$Setter$$ExternalSyntheticLambda3(this));
            this.mStandardDialog.setView(inflate);
            this.mStandardDialog.setCanceledOnTouchOutside(false);
            this.mStandardDialog.getWindow().setGravity(this.mGravity);
            return this.mStandardDialog;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$create$0$com-microtech-aidexx-views-dialog-standard-StandardDialog$Setter  reason: not valid java name */
        public /* synthetic */ void m287lambda$create$0$commicrotechaidexxviewsdialogstandardStandardDialog$Setter(View view) {
            this.cancelClickListener.onClick(this.mStandardDialog, -2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$create$1$com-microtech-aidexx-views-dialog-standard-StandardDialog$Setter  reason: not valid java name */
        public /* synthetic */ void m288lambda$create$1$commicrotechaidexxviewsdialogstandardStandardDialog$Setter(View view) {
            this.positiveClickListener.onClick(this.mStandardDialog, -1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$create$2$com-microtech-aidexx-views-dialog-standard-StandardDialog$Setter  reason: not valid java name */
        public /* synthetic */ void m289lambda$create$2$commicrotechaidexxviewsdialogstandardStandardDialog$Setter(DialogInterface dialogInterface) {
            DialogDismissListener dialogDismissListener = this.dismissListener;
            if (dialogDismissListener != null) {
                dialogDismissListener.onDismiss();
            }
        }

        public StandardDialog create(View view) {
            StandardDialog standardDialog = new StandardDialog(this.mContext, R.style.StandardDialog);
            this.mStandardDialog = standardDialog;
            standardDialog.setTimeTag();
            this.mStandardDialog.setOnDismissListener(new StandardDialog$Setter$$ExternalSyntheticLambda0(this));
            this.mStandardDialog.setView(view);
            this.mStandardDialog.setCanceledOnTouchOutside(false);
            this.mStandardDialog.getWindow().setGravity(this.mGravity);
            return this.mStandardDialog;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$create$3$com-microtech-aidexx-views-dialog-standard-StandardDialog$Setter  reason: not valid java name */
        public /* synthetic */ void m290lambda$create$3$commicrotechaidexxviewsdialogstandardStandardDialog$Setter(DialogInterface dialogInterface) {
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

        public Setter setPositive(String str, DialogInterface.OnClickListener onClickListener) {
            if (!TextUtils.isEmpty(str)) {
                this.mConfirm = str;
            }
            this.positiveClickListener = onClickListener;
            return this;
        }

        public Setter setPositive(DialogInterface.OnClickListener onClickListener) {
            this.positiveClickListener = onClickListener;
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

        public Setter content(String str) {
            this.mContent = str;
            return this;
        }

        public Setter note(String str) {
            this.mNote = str;
            return this;
        }

        public Setter title(String str) {
            this.mTitle = str;
            return this;
        }

        public Setter confirmBtnText(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mConfirm = str;
            }
            return this;
        }

        public Setter cancelBtnText(String str) {
            this.mCancel = str;
            return this;
        }

        public Setter gravity(int i) {
            this.mGravity = i;
            return this;
        }
    }
}
