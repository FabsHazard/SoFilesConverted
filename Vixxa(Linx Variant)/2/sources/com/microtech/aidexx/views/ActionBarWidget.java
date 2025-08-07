package com.microtech.aidexx.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.WidgetActionBarBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/microtech/aidexx/views/ActionBarWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ivRightIcon", "Landroid/view/View;", "getIvRightIcon", "()Landroid/view/View;", "setIvRightIcon", "(Landroid/view/View;)V", "mViewBinding", "Lcom/microtech/aidexx/databinding/WidgetActionBarBinding;", "getMViewBinding", "()Lcom/microtech/aidexx/databinding/WidgetActionBarBinding;", "setMViewBinding", "(Lcom/microtech/aidexx/databinding/WidgetActionBarBinding;)V", "getLeftIcon", "Landroid/widget/ImageView;", "getRightIcon", "getRightTitleIcon", "getStatusBarHeight", "", "getTitle", "Landroid/widget/TextView;", "initLayout", "", "setTitle", "title", "", "setTitleRightIcon", "res", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ActionBarWidget.kt */
public class ActionBarWidget extends ConstraintLayout {
    private View ivRightIcon;
    public WidgetActionBarBinding mViewBinding;

    public final View getIvRightIcon() {
        return this.ivRightIcon;
    }

    public final void setIvRightIcon(View view) {
        this.ivRightIcon = view;
    }

    public final WidgetActionBarBinding getMViewBinding() {
        WidgetActionBarBinding widgetActionBarBinding = this.mViewBinding;
        if (widgetActionBarBinding != null) {
            return widgetActionBarBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        return null;
    }

    public final void setMViewBinding(WidgetActionBarBinding widgetActionBarBinding) {
        Intrinsics.checkNotNullParameter(widgetActionBarBinding, "<set-?>");
        this.mViewBinding = widgetActionBarBinding;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionBarWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initLayout();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        initLayout();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ActionBarWidget, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        getMViewBinding().tvTitle.setText(obtainStyledAttributes.getString(R.styleable.ActionBarWidget_titleText));
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ActionBarWidget_leftIcon, 0);
        if (resourceId != 0) {
            getMViewBinding().ivLeft.setImageResource(resourceId);
        } else {
            getMViewBinding().ivLeft.setVisibility(4);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ActionBarWidget_rightIcon, 0);
        if (resourceId2 != 0) {
            getMViewBinding().ivRight.setImageResource(resourceId2);
        } else {
            getMViewBinding().ivRight.setVisibility(4);
        }
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ActionBarWidget_titleRightIcon, 0);
        if (resourceId3 != 0) {
            getMViewBinding().ivTitleRight.setImageResource(resourceId3);
        } else {
            getMViewBinding().ivTitleRight.setVisibility(8);
        }
    }

    public final void setTitleRightIcon(int i) {
        getMViewBinding().ivTitleRight.setVisibility(i == 1 ? 0 : 8);
    }

    private final void initLayout() {
        Object systemService = getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.widget_action_bar, this, true);
        inflate.setPadding(0, getStatusBarHeight() + ExtendsKt.dp2px((Number) 10), ExtendsKt.dp2px((Number) 8), ExtendsKt.dp2px((Number) 8));
        WidgetActionBarBinding bind = WidgetActionBarBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        setMViewBinding(bind);
        this.ivRightIcon = inflate.findViewById(R.id.iv_right);
        setBackgroundColor(getResources().getColor(R.color.bg_nav_bar, getContext().getTheme()));
    }

    private final int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return ExtendsKt.dp2px((Number) 36);
    }

    public final ImageView getLeftIcon() {
        ImageView imageView = getMViewBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivLeft");
        return imageView;
    }

    public final ImageView getRightIcon() {
        ImageView imageView = getMViewBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivRight");
        return imageView;
    }

    public final View getRightTitleIcon() {
        return this.ivRightIcon;
    }

    public final TextView getTitle() {
        TextView textView = getMViewBinding().tvTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTitle");
        return textView;
    }

    public final void setTitle(String str) {
        if (str != null) {
            getMViewBinding().tvTitle.setText(str);
        }
    }
}
