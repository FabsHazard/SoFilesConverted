package com.microtech.aidexx.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.WidgetSettingItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0015J\u0010\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u001d\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u001e\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/microtech/aidexx/views/SettingItemWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "settingItemBinding", "Lcom/microtech/aidexx/databinding/WidgetSettingItemBinding;", "getLeftImage", "Landroid/widget/ImageView;", "getRightImage", "getSecondTextView", "Landroid/widget/TextView;", "getSwitch", "Landroidx/appcompat/widget/SwitchCompat;", "getValue", "", "hasNext", "", "", "initLayout", "setDividerState", "isEnabled", "setEnable", "enable", "setSecondValue", "str", "setTitle", "setValue", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingItemWidget.kt */
public final class SettingItemWidget extends ConstraintLayout {
    private WidgetSettingItemBinding settingItemBinding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingItemWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initLayout();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingItemWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        initLayout();
        int i = 0;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SettingItemWidget, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        WidgetSettingItemBinding widgetSettingItemBinding2 = null;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        widgetSettingItemBinding.tvTitle.setText(obtainStyledAttributes.getString(R.styleable.SettingItemWidget_title));
        WidgetSettingItemBinding widgetSettingItemBinding3 = this.settingItemBinding;
        if (widgetSettingItemBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding3 = null;
        }
        widgetSettingItemBinding3.tvValue.setText(obtainStyledAttributes.getString(R.styleable.SettingItemWidget_value));
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SettingItemWidget_icon, 0);
        if (resourceId != 0) {
            WidgetSettingItemBinding widgetSettingItemBinding4 = this.settingItemBinding;
            if (widgetSettingItemBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
                widgetSettingItemBinding4 = null;
            }
            widgetSettingItemBinding4.ivIconLeft.setImageResource(resourceId);
        } else {
            WidgetSettingItemBinding widgetSettingItemBinding5 = this.settingItemBinding;
            if (widgetSettingItemBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
                widgetSettingItemBinding5 = null;
            }
            widgetSettingItemBinding5.ivIconLeft.setVisibility(8);
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SettingItemWidget_has_switch, false);
        WidgetSettingItemBinding widgetSettingItemBinding6 = this.settingItemBinding;
        if (widgetSettingItemBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding6 = null;
        }
        widgetSettingItemBinding6.swOn.setVisibility(z ? 0 : 8);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SettingItemWidget_has_next, false);
        WidgetSettingItemBinding widgetSettingItemBinding7 = this.settingItemBinding;
        if (widgetSettingItemBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding7 = null;
        }
        widgetSettingItemBinding7.tvNext.setVisibility(z2 ? 0 : 8);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.SettingItemWidget_has_down, false);
        WidgetSettingItemBinding widgetSettingItemBinding8 = this.settingItemBinding;
        if (widgetSettingItemBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding8 = null;
        }
        widgetSettingItemBinding8.tvDown.setVisibility(z3 ? 0 : 8);
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.SettingItemWidget_has_line, true);
        WidgetSettingItemBinding widgetSettingItemBinding9 = this.settingItemBinding;
        if (widgetSettingItemBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
        } else {
            widgetSettingItemBinding2 = widgetSettingItemBinding9;
        }
        widgetSettingItemBinding2.viewLine.setVisibility(!z4 ? 8 : i);
    }

    public final void hasNext(boolean z) {
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        widgetSettingItemBinding.viewLine.setVisibility(z ? 0 : 8);
    }

    private final void initLayout() {
        Object systemService = getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        WidgetSettingItemBinding bind = WidgetSettingItemBinding.bind(((LayoutInflater) systemService).inflate(R.layout.widget_setting_item, this, true));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.settingItemBinding = bind;
    }

    public final ImageView getLeftImage() {
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        ImageView imageView = widgetSettingItemBinding.ivIconLeft;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivIconLeft");
        return imageView;
    }

    public final ImageView getRightImage() {
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        ImageView imageView = widgetSettingItemBinding.tvNext;
        Intrinsics.checkNotNullExpressionValue(imageView, "tvNext");
        return imageView;
    }

    public final void setDividerState(boolean z) {
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        View view = widgetSettingItemBinding.viewLine;
        Intrinsics.checkNotNullExpressionValue(view, "viewLine");
        view.setVisibility(z ? 0 : 8);
    }

    public final void setTitle(String str) {
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        widgetSettingItemBinding.tvTitle.setText(str);
    }

    public final void setValue(String str) {
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        widgetSettingItemBinding.tvValue.setText(str);
    }

    public final void setSecondValue(String str) {
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        widgetSettingItemBinding.txtSecondValue.setText(str);
    }

    public final TextView getSecondTextView() {
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        TextView textView = widgetSettingItemBinding.txtSecondValue;
        Intrinsics.checkNotNullExpressionValue(textView, "txtSecondValue");
        return textView;
    }

    public final void setEnable(boolean z) {
        int i;
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        WidgetSettingItemBinding widgetSettingItemBinding2 = null;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        TextView textView = widgetSettingItemBinding.tvValue;
        Context context = getContext();
        if (z) {
            i = R.color.white;
        } else {
            i = R.color.white80;
        }
        textView.setTextColor(ContextCompat.getColor(context, i));
        WidgetSettingItemBinding widgetSettingItemBinding3 = this.settingItemBinding;
        if (widgetSettingItemBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
        } else {
            widgetSettingItemBinding2 = widgetSettingItemBinding3;
        }
        widgetSettingItemBinding2.tvDown.setImageResource(z ? R.drawable.ic_next_down : R.drawable.ic_next_down_eighty);
    }

    public final String getValue() {
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        return widgetSettingItemBinding.tvValue.getText().toString();
    }

    public final SwitchCompat getSwitch() {
        WidgetSettingItemBinding widgetSettingItemBinding = this.settingItemBinding;
        if (widgetSettingItemBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingItemBinding");
            widgetSettingItemBinding = null;
        }
        SwitchCompat switchCompat = widgetSettingItemBinding.swOn;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "swOn");
        return switchCompat;
    }
}
