package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.dialog.standard.RemeasureTextView;

public final class StandardDialogVerticalBinding implements ViewBinding {
    public final TextView buttonCancel;
    public final TextView buttonConfirm;
    public final RemeasureTextView content;
    public final RemeasureTextView note;
    private final LinearLayout rootView;
    public final TextView stick;
    public final TextView title;

    private StandardDialogVerticalBinding(LinearLayout linearLayout, TextView textView, TextView textView2, RemeasureTextView remeasureTextView, RemeasureTextView remeasureTextView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.buttonCancel = textView;
        this.buttonConfirm = textView2;
        this.content = remeasureTextView;
        this.note = remeasureTextView2;
        this.stick = textView3;
        this.title = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StandardDialogVerticalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StandardDialogVerticalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.standard_dialog_vertical, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StandardDialogVerticalBinding bind(View view) {
        int i = R.id.button_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.button_confirm;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.content;
                RemeasureTextView remeasureTextView = (RemeasureTextView) ViewBindings.findChildViewById(view, i);
                if (remeasureTextView != null) {
                    i = R.id.note;
                    RemeasureTextView remeasureTextView2 = (RemeasureTextView) ViewBindings.findChildViewById(view, i);
                    if (remeasureTextView2 != null) {
                        i = R.id.stick;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.title;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new StandardDialogVerticalBinding((LinearLayout) view, textView, textView2, remeasureTextView, remeasureTextView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
