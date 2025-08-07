package com.microtech.aidexx.ota;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.microtech.aidexx.R;

public class OtaDialog extends AlertDialog {
    public static final int STATE_COMPLETE = 2;
    public static final int STATE_FAIL = 3;
    public static final int STATE_UPDATING = 1;
    private int currentStates;
    /* access modifiers changed from: private */
    public Setter setter;

    protected OtaDialog(Context context) {
        super(context);
        this.setter = null;
    }

    protected OtaDialog(Context context, int i, Setter setter2) {
        super(context, i);
        this.setter = setter2;
    }

    private void setProgress(int i) {
        this.setter.pbUpdate.setProgress(i);
    }

    public int getState() {
        return this.currentStates;
    }

    public OtaDialog changeState(int i, int i2, float f, Boolean bool) {
        this.currentStates = i;
        if (i == 1) {
            this.setter.layoutUpdating.setVisibility(0);
            this.setter.layoutComplete.setVisibility(8);
            setProgress(i2);
        } else if (i == 2 || i == 3) {
            showComplete(bool.booleanValue());
        } else {
            throw new IllegalArgumentException("please use argument defined in" + getClass().getName());
        }
        return this;
    }

    private void showComplete(final boolean z) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.setter.pbUpdate.getProgress(), 100});
        ofInt.setDuration(3000);
        ofInt.addUpdateListener(new OtaDialog$$ExternalSyntheticLambda0(this));
        ofInt.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                OtaDialog.this.setter.layoutUpdating.setVisibility(8);
                OtaDialog.this.setter.layoutComplete.setVisibility(0);
                if (z) {
                    OtaDialog.this.setter.tvReboot.setVisibility(0);
                } else {
                    OtaDialog.this.setter.tvReboot.setVisibility(8);
                }
            }
        });
        ofInt.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$showComplete$0$com-microtech-aidexx-ota-OtaDialog  reason: not valid java name */
    public /* synthetic */ void m180lambda$showComplete$0$commicrotechaidexxotaOtaDialog(ValueAnimator valueAnimator) {
        this.setter.pbUpdate.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    public static class Setter {
        public TextView idHead;
        public ConstraintLayout layoutComplete;
        public ConstraintLayout layoutUpdating;
        private final Context mContext;
        private OtaDialog mStandardDialog;
        public HorizonProgressBar pbUpdate;
        private DialogInterface.OnClickListener positiveClickListener;
        public TextView tvReboot;

        public OtaDialog create() {
            this.mStandardDialog = new OtaDialog(this.mContext, R.style.StandardDialog, this);
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.transmitter_update_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.button_confirm);
            this.pbUpdate = (HorizonProgressBar) inflate.findViewById(R.id.pb_update);
            this.layoutUpdating = (ConstraintLayout) inflate.findViewById(R.id.layout_updating);
            this.tvReboot = (TextView) inflate.findViewById(R.id.tv_reboot);
            this.idHead = (TextView) inflate.findViewById(R.id.id_head);
            this.layoutComplete = (ConstraintLayout) inflate.findViewById(R.id.layout_complete);
            if (this.positiveClickListener != null) {
                textView.setOnClickListener(new OtaDialog$Setter$$ExternalSyntheticLambda0(this));
            }
            this.mStandardDialog.setView(inflate);
            this.mStandardDialog.setCancelable(false);
            return this.mStandardDialog;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$create$0$com-microtech-aidexx-ota-OtaDialog$Setter  reason: not valid java name */
        public /* synthetic */ void m181lambda$create$0$commicrotechaidexxotaOtaDialog$Setter(View view) {
            this.positiveClickListener.onClick(this.mStandardDialog, -1);
        }

        public Setter(Context context) {
            this.mContext = context;
        }

        public Setter setPositive(DialogInterface.OnClickListener onClickListener) {
            this.positiveClickListener = onClickListener;
            return this;
        }
    }
}
