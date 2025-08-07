package com.microtech.aidexx.ui.welcome;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.StringUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0014J\u0006\u0010 \u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/ui/welcome/UserAgreeView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btCancel", "Landroid/widget/TextView;", "btOk", "onClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "tvContent", "tvTitle", "initView", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "removeClick", "resetText", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UserAgreeView.kt */
public final class UserAgreeView extends RelativeLayout {
    private TextView btCancel;
    private TextView btOk;
    private Function1<? super Boolean, Unit> onClick;
    private TextView tvContent;
    private TextView tvTitle;

    public UserAgreeView(Context context) {
        super(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        super.onVisibilityChanged(view, i);
        TextView textView = this.tvContent;
        if (textView != null) {
            StringUtils stringUtils = StringUtils.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(StringUtils.initProtocol$default(stringUtils, context, 1, (String) null, (String) null, 12, (Object) null));
        }
        TextView textView2 = this.tvContent;
        if (textView2 != null) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private final void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_user_agree, this, true);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        this.tvContent = textView;
        if (textView != null) {
            textView.setText(StringUtils.initProtocol$default(StringUtils.INSTANCE, context, 1, (String) null, (String) null, 12, (Object) null));
        }
        TextView textView2 = this.tvContent;
        if (textView2 != null) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView textView3 = (TextView) inflate.findViewById(R.id.bt_ok);
        this.btOk = textView3;
        if (textView3 != null) {
            textView3.setOnClickListener(new UserAgreeView$$ExternalSyntheticLambda0(this));
        }
        TextView textView4 = (TextView) inflate.findViewById(R.id.bt_cancel);
        this.btCancel = textView4;
        if (textView4 != null) {
            textView4.setOnClickListener(new UserAgreeView$$ExternalSyntheticLambda1(this));
        }
        this.tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(UserAgreeView userAgreeView, View view) {
        Intrinsics.checkNotNullParameter(userAgreeView, "this$0");
        Function1<? super Boolean, Unit> function1 = userAgreeView.onClick;
        if (function1 != null) {
            function1.invoke(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(UserAgreeView userAgreeView, View view) {
        Intrinsics.checkNotNullParameter(userAgreeView, "this$0");
        Function1<? super Boolean, Unit> function1 = userAgreeView.onClick;
        if (function1 != null) {
            function1.invoke(false);
        }
    }

    public final void resetText() {
        TextView textView = this.tvContent;
        if (textView != null) {
            StringUtils stringUtils = StringUtils.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(StringUtils.initProtocol$default(stringUtils, context, 1, (String) null, (String) null, 12, (Object) null));
        }
        TextView textView2 = this.tvContent;
        if (textView2 != null) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView textView3 = this.btCancel;
        if (textView3 != null) {
            textView3.setText(getContext().getString(R.string.com_disagree));
        }
        TextView textView4 = this.btOk;
        if (textView4 != null) {
            textView4.setText(getContext().getString(R.string.com_agree));
        }
        TextView textView5 = this.tvTitle;
        if (textView5 != null) {
            textView5.setText(getContext().getString(R.string.user_sign_serviceAndPrivatePolicy));
        }
    }

    public final Function1<Boolean, Unit> getOnClick() {
        return this.onClick;
    }

    public final void setOnClick(Function1<? super Boolean, Unit> function1) {
        this.onClick = function1;
    }

    public final void removeClick() {
        this.onClick = null;
    }
}
