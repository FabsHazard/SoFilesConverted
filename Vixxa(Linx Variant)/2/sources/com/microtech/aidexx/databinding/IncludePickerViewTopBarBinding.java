package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class IncludePickerViewTopBarBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnSubmit;
    public final RelativeLayout rlTopBar;
    private final RelativeLayout rootView;
    public final TextView tvTitle;

    private IncludePickerViewTopBarBinding(RelativeLayout relativeLayout, Button button, Button button2, RelativeLayout relativeLayout2, TextView textView) {
        this.rootView = relativeLayout;
        this.btnCancel = button;
        this.btnSubmit = button2;
        this.rlTopBar = relativeLayout2;
        this.tvTitle = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IncludePickerViewTopBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IncludePickerViewTopBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.include_picker_view_top_bar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IncludePickerViewTopBarBinding bind(View view) {
        int i = R.id.btnCancel;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btnSubmit;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = R.id.tvTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new IncludePickerViewTopBarBinding(relativeLayout, button, button2, relativeLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
