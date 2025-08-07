package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityEditNameBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final EditText etInput;
    private final LinearLayout rootView;
    public final TextView tvInputCount;
    public final TextView tvNotice;
    public final TextView tvSave;

    private ActivityEditNameBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, EditText editText, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.etInput = editText;
        this.tvInputCount = textView;
        this.tvNotice = textView2;
        this.tvSave = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEditNameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityEditNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_edit_name, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityEditNameBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.etInput;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.tvInputCount;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tvNotice;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tvSave;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new ActivityEditNameBinding((LinearLayout) view, actionBarWidget, editText, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
