package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ruler.RulerWidget;

public final class LayoutRulerDialogBinding implements ViewBinding {
    public final TextView btCancel;
    public final TextView btOk;
    private final LinearLayout rootView;
    public final RulerWidget rwNumber;

    private LayoutRulerDialogBinding(LinearLayout linearLayout, TextView textView, TextView textView2, RulerWidget rulerWidget) {
        this.rootView = linearLayout;
        this.btCancel = textView;
        this.btOk = textView2;
        this.rwNumber = rulerWidget;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutRulerDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutRulerDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_ruler_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutRulerDialogBinding bind(View view) {
        int i = R.id.bt_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bt_ok;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.rw_number;
                RulerWidget rulerWidget = (RulerWidget) ViewBindings.findChildViewById(view, i);
                if (rulerWidget != null) {
                    return new LayoutRulerDialogBinding((LinearLayout) view, textView, textView2, rulerWidget);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
