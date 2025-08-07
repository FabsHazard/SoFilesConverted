package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityOtherDiseaseBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final EditText etDiseaseName;
    private final LinearLayout rootView;
    public final RecyclerView rvDisease;
    public final TextView tvSave;

    private ActivityOtherDiseaseBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, EditText editText, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.etDiseaseName = editText;
        this.rvDisease = recyclerView;
        this.tvSave = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityOtherDiseaseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityOtherDiseaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_other_disease, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityOtherDiseaseBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.etDiseaseName;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.rvDisease;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.tvSave;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new ActivityOtherDiseaseBinding((LinearLayout) view, actionBarWidget, editText, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
