package com.microtech.aidexx.ui.main;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.ThemeManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010R\u001a\u00020S2\u0006\u0010%\u001a\u00020\tJ\b\u0010T\u001a\u00020SH\u0002J\b\u0010U\u001a\u00020SH\u0002J\b\u0010V\u001a\u00020SH\u0002J\b\u0010W\u001a\u00020SH\u0002J\b\u0010X\u001a\u00020SH\u0002J\b\u0010Y\u001a\u00020SH\u0002J\b\u0010Z\u001a\u00020SH\u0002J\b\u0010[\u001a\u00020SH\u0002J\b\u0010\\\u001a\u00020SH\u0002J\b\u0010]\u001a\u00020SH\u0002J\u0010\u0010^\u001a\u00020S2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010_\u001a\u00020SH\u0002J\b\u0010`\u001a\u00020SH\u0002J\b\u0010a\u001a\u00020SH\u0002J\b\u0010b\u001a\u00020SH\u0002J\b\u0010c\u001a\u00020SH\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R7\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001a\u00103\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001a\u00106\u001a\u000207X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010-\"\u0004\b>\u0010/R\u001a\u0010?\u001a\u00020@X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020@X.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR\u001a\u0010H\u001a\u00020@X.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010B\"\u0004\bJ\u0010DR\u001a\u0010K\u001a\u00020@X.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010B\"\u0004\bM\u0010DR\u001a\u0010N\u001a\u00020@X.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010B\"\u0004\bP\u0010DR\u000e\u0010Q\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/microtech/aidexx/ui/main/MainTabView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "black4b", "currentSelect", "grayD8", "green65", "ivTabBg", "Landroid/widget/ImageView;", "getIvTabBg", "()Landroid/widget/ImageView;", "setIvTabBg", "(Landroid/widget/ImageView;)V", "ivTabEvent", "getIvTabEvent", "setIvTabEvent", "ivTabHistory", "getIvTabHistory", "setIvTabHistory", "ivTabHome", "getIvTabHome", "setIvTabHome", "ivTabTrend", "getIvTabTrend", "setIvTabTrend", "onTabChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pos", "", "getOnTabChange", "()Lkotlin/jvm/functions/Function1;", "setOnTabChange", "(Lkotlin/jvm/functions/Function1;)V", "tabRootBg", "getTabRootBg", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setTabRootBg", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "tabRootEvent", "getTabRootEvent", "setTabRootEvent", "tabRootHistory", "getTabRootHistory", "setTabRootHistory", "tabRootHome", "Landroid/widget/RelativeLayout;", "getTabRootHome", "()Landroid/widget/RelativeLayout;", "setTabRootHome", "(Landroid/widget/RelativeLayout;)V", "tabRootTrend", "getTabRootTrend", "setTabRootTrend", "tvTabBg", "Landroid/widget/TextView;", "getTvTabBg", "()Landroid/widget/TextView;", "setTvTabBg", "(Landroid/widget/TextView;)V", "tvTabEvent", "getTvTabEvent", "setTvTabEvent", "tvTabHistory", "getTvTabHistory", "setTvTabHistory", "tvTabHome", "getTvTabHome", "setTvTabHome", "tvTabTrend", "getTvTabTrend", "setTvTabTrend", "white", "check", "", "check0", "check1", "check2", "check3", "check4", "checkBg", "checkEvent", "checkHistory", "checkHome", "checkTrend", "init", "uncheckBg", "uncheckEvent", "uncheckHistory", "uncheckHome", "uncheckTrend", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainTabView.kt */
public final class MainTabView extends ConstraintLayout {
    private final int black4b;
    private int currentSelect;
    private final int grayD8;
    private final int green65;
    public ImageView ivTabBg;
    public ImageView ivTabEvent;
    public ImageView ivTabHistory;
    public ImageView ivTabHome;
    public ImageView ivTabTrend;
    private Function1<? super Integer, Boolean> onTabChange;
    public ConstraintLayout tabRootBg;
    public ConstraintLayout tabRootEvent;
    public ConstraintLayout tabRootHistory;
    public RelativeLayout tabRootHome;
    public ConstraintLayout tabRootTrend;
    public TextView tvTabBg;
    public TextView tvTabEvent;
    public TextView tvTabHistory;
    public TextView tvTabHome;
    public TextView tvTabTrend;
    private final int white;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MainTabView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MainTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.grayD8 = ContextCompat.getColor(getContext(), R.color.gray_d8);
        this.black4b = ContextCompat.getColor(getContext(), R.color.black_4b);
        this.green65 = ContextCompat.getColor(getContext(), R.color.green_65);
        this.white = ContextCompat.getColor(getContext(), R.color.white);
        this.currentSelect = 2;
        init(context);
    }

    public final ConstraintLayout getTabRootTrend() {
        ConstraintLayout constraintLayout = this.tabRootTrend;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabRootTrend");
        return null;
    }

    public final void setTabRootTrend(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.tabRootTrend = constraintLayout;
    }

    public final ConstraintLayout getTabRootHistory() {
        ConstraintLayout constraintLayout = this.tabRootHistory;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabRootHistory");
        return null;
    }

    public final void setTabRootHistory(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.tabRootHistory = constraintLayout;
    }

    public final ConstraintLayout getTabRootBg() {
        ConstraintLayout constraintLayout = this.tabRootBg;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabRootBg");
        return null;
    }

    public final void setTabRootBg(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.tabRootBg = constraintLayout;
    }

    public final ConstraintLayout getTabRootEvent() {
        ConstraintLayout constraintLayout = this.tabRootEvent;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabRootEvent");
        return null;
    }

    public final void setTabRootEvent(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.tabRootEvent = constraintLayout;
    }

    public final RelativeLayout getTabRootHome() {
        RelativeLayout relativeLayout = this.tabRootHome;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabRootHome");
        return null;
    }

    public final void setTabRootHome(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.tabRootHome = relativeLayout;
    }

    public final TextView getTvTabHome() {
        TextView textView = this.tvTabHome;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTabHome");
        return null;
    }

    public final void setTvTabHome(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTabHome = textView;
    }

    public final ImageView getIvTabHome() {
        ImageView imageView = this.ivTabHome;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivTabHome");
        return null;
    }

    public final void setIvTabHome(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivTabHome = imageView;
    }

    public final ImageView getIvTabHistory() {
        ImageView imageView = this.ivTabHistory;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivTabHistory");
        return null;
    }

    public final void setIvTabHistory(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivTabHistory = imageView;
    }

    public final TextView getTvTabHistory() {
        TextView textView = this.tvTabHistory;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTabHistory");
        return null;
    }

    public final void setTvTabHistory(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTabHistory = textView;
    }

    public final ImageView getIvTabTrend() {
        ImageView imageView = this.ivTabTrend;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivTabTrend");
        return null;
    }

    public final void setIvTabTrend(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivTabTrend = imageView;
    }

    public final TextView getTvTabTrend() {
        TextView textView = this.tvTabTrend;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTabTrend");
        return null;
    }

    public final void setTvTabTrend(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTabTrend = textView;
    }

    public final ImageView getIvTabBg() {
        ImageView imageView = this.ivTabBg;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivTabBg");
        return null;
    }

    public final void setIvTabBg(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivTabBg = imageView;
    }

    public final TextView getTvTabBg() {
        TextView textView = this.tvTabBg;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTabBg");
        return null;
    }

    public final void setTvTabBg(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTabBg = textView;
    }

    public final ImageView getIvTabEvent() {
        ImageView imageView = this.ivTabEvent;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivTabEvent");
        return null;
    }

    public final void setIvTabEvent(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivTabEvent = imageView;
    }

    public final TextView getTvTabEvent() {
        TextView textView = this.tvTabEvent;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTabEvent");
        return null;
    }

    public final void setTvTabEvent(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTabEvent = textView;
    }

    public final Function1<Integer, Boolean> getOnTabChange() {
        return this.onTabChange;
    }

    public final void setOnTabChange(Function1<? super Integer, Boolean> function1) {
        this.onTabChange = function1;
    }

    public final void check(int i) {
        if (this.currentSelect == i) {
            return;
        }
        if (i == 0) {
            check0();
            this.currentSelect = 0;
        } else if (i == 1) {
            check1();
            this.currentSelect = 1;
        } else if (i == 2) {
            check2();
            this.currentSelect = 2;
        } else if (i == 3) {
            check3();
            this.currentSelect = 3;
        } else if (i == 4) {
            check4();
            this.currentSelect = 4;
        }
    }

    private final void init(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.main_tab_view, this, true);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.tab_history);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.tab_trend);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) inflate.findViewById(R.id.tab_bg);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) inflate.findViewById(R.id.tab_event);
        View findViewById = constraintLayout.findViewById(R.id.tab_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        setTabRootHistory((ConstraintLayout) findViewById);
        getTabRootHistory().setOnClickListener(new MainTabView$$ExternalSyntheticLambda0(this));
        View findViewById2 = constraintLayout.findViewById(R.id.iv_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        setIvTabHistory((ImageView) findViewById2);
        View findViewById3 = constraintLayout.findViewById(R.id.tv_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        setTvTabHistory((TextView) findViewById3);
        getTvTabHistory().setText(context.getString(R.string.history));
        View findViewById4 = constraintLayout2.findViewById(R.id.tab_root);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        setTabRootTrend((ConstraintLayout) findViewById4);
        getTabRootTrend().setOnClickListener(new MainTabView$$ExternalSyntheticLambda1(this));
        View findViewById5 = constraintLayout2.findViewById(R.id.iv_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        setIvTabTrend((ImageView) findViewById5);
        View findViewById6 = constraintLayout2.findViewById(R.id.tv_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        setTvTabTrend((TextView) findViewById6);
        getTvTabTrend().setText(context.getString(R.string.trend));
        View findViewById7 = constraintLayout3.findViewById(R.id.tab_root);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        setTabRootBg((ConstraintLayout) findViewById7);
        getTabRootBg().setOnClickListener(new MainTabView$$ExternalSyntheticLambda2(this));
        View findViewById8 = constraintLayout3.findViewById(R.id.iv_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        setIvTabBg((ImageView) findViewById8);
        View findViewById9 = constraintLayout3.findViewById(R.id.tv_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        setTvTabBg((TextView) findViewById9);
        getTvTabBg().setText(context.getString(R.string.glucose));
        View findViewById10 = constraintLayout4.findViewById(R.id.tab_root);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        setTabRootEvent((ConstraintLayout) findViewById10);
        getTabRootEvent().setOnClickListener(new MainTabView$$ExternalSyntheticLambda3(this));
        View findViewById11 = constraintLayout4.findViewById(R.id.iv_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        setIvTabEvent((ImageView) findViewById11);
        View findViewById12 = constraintLayout4.findViewById(R.id.tv_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        setTvTabEvent((TextView) findViewById12);
        getTvTabEvent().setText(context.getString(R.string.event));
        View findViewById13 = findViewById(R.id.tab_home);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        setTabRootHome((RelativeLayout) findViewById13);
        getTabRootHome().setOnClickListener(new MainTabView$$ExternalSyntheticLambda4(this));
        View findViewById14 = findViewById(R.id.iv_home);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        setIvTabHome((ImageView) findViewById14);
        View findViewById15 = findViewById(R.id.tv_home);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        setTvTabHome((TextView) findViewById15);
        getTvTabHome().setText(context.getString(R.string.home));
        check2();
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$0(MainTabView mainTabView, View view) {
        Intrinsics.checkNotNullParameter(mainTabView, "this$0");
        Function1<? super Integer, Boolean> function1 = mainTabView.onTabChange;
        if (Intrinsics.areEqual((Object) function1 != null ? function1.invoke(0) : null, (Object) true) && mainTabView.currentSelect != 0) {
            mainTabView.check0();
            mainTabView.currentSelect = 0;
        }
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$1(MainTabView mainTabView, View view) {
        Intrinsics.checkNotNullParameter(mainTabView, "this$0");
        Function1<? super Integer, Boolean> function1 = mainTabView.onTabChange;
        if (Intrinsics.areEqual((Object) function1 != null ? function1.invoke(1) : null, (Object) true) && mainTabView.currentSelect != 1) {
            mainTabView.check1();
            mainTabView.currentSelect = 1;
        }
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$2(MainTabView mainTabView, View view) {
        Intrinsics.checkNotNullParameter(mainTabView, "this$0");
        Function1<? super Integer, Boolean> function1 = mainTabView.onTabChange;
        if (Intrinsics.areEqual((Object) function1 != null ? function1.invoke(3) : null, (Object) true) && mainTabView.currentSelect != 3) {
            mainTabView.check3();
            mainTabView.currentSelect = 3;
        }
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$3(MainTabView mainTabView, View view) {
        Intrinsics.checkNotNullParameter(mainTabView, "this$0");
        Function1<? super Integer, Boolean> function1 = mainTabView.onTabChange;
        if (Intrinsics.areEqual((Object) function1 != null ? function1.invoke(4) : null, (Object) true) && mainTabView.currentSelect != 4) {
            mainTabView.check4();
            mainTabView.currentSelect = 4;
        }
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$4(MainTabView mainTabView, View view) {
        Intrinsics.checkNotNullParameter(mainTabView, "this$0");
        Function1<? super Integer, Boolean> function1 = mainTabView.onTabChange;
        if (Intrinsics.areEqual((Object) function1 != null ? function1.invoke(2) : null, (Object) true) && mainTabView.currentSelect != 2) {
            mainTabView.check2();
            mainTabView.currentSelect = 2;
        }
    }

    private final void check2() {
        uncheckHistory();
        uncheckTrend();
        uncheckBg();
        uncheckEvent();
        checkHome();
    }

    private final void check4() {
        uncheckHistory();
        uncheckTrend();
        uncheckBg();
        checkEvent();
        uncheckHome();
    }

    private final void check3() {
        uncheckHistory();
        uncheckTrend();
        checkBg();
        uncheckEvent();
        uncheckHome();
    }

    private final void check1() {
        uncheckHistory();
        checkTrend();
        uncheckBg();
        uncheckEvent();
        uncheckHome();
    }

    private final void check0() {
        checkHistory();
        uncheckTrend();
        uncheckBg();
        uncheckEvent();
        uncheckHome();
    }

    private final void uncheckHistory() {
        getIvTabHistory().setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_history_uncheck));
        getTvTabHistory().setTextColor(ThemeManager.INSTANCE.isLight() ? this.black4b : this.grayD8);
        getTvTabHistory().setTypeface(Typeface.DEFAULT);
    }

    private final void checkHistory() {
        int i;
        TextView textView;
        getIvTabHistory().setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_history_checked));
        if (ThemeManager.INSTANCE.isLight()) {
            textView = getTvTabHistory();
            i = this.green65;
        } else {
            textView = getTvTabHistory();
            i = this.white;
        }
        textView.setTextColor(i);
        getTvTabHistory().setTypeface(Typeface.DEFAULT_BOLD);
    }

    private final void uncheckTrend() {
        getIvTabTrend().setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_trend_uncheck));
        getTvTabTrend().setTextColor(ThemeManager.INSTANCE.isLight() ? this.black4b : this.grayD8);
        getTvTabTrend().setTypeface(Typeface.DEFAULT);
    }

    private final void checkTrend() {
        int i;
        TextView textView;
        getIvTabTrend().setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_trend_checked));
        if (ThemeManager.INSTANCE.isLight()) {
            textView = getTvTabTrend();
            i = this.green65;
        } else {
            textView = getTvTabTrend();
            i = this.white;
        }
        textView.setTextColor(i);
        getTvTabTrend().setTypeface(Typeface.DEFAULT_BOLD);
    }

    private final void uncheckBg() {
        getIvTabBg().setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_bg_uncheck));
        getTvTabBg().setTextColor(ThemeManager.INSTANCE.isLight() ? this.black4b : this.grayD8);
        getTvTabBg().setTypeface(Typeface.DEFAULT);
    }

    private final void checkBg() {
        int i;
        TextView textView;
        getIvTabBg().setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_bg_checked));
        if (ThemeManager.INSTANCE.isLight()) {
            textView = getTvTabBg();
            i = this.green65;
        } else {
            textView = getTvTabBg();
            i = this.white;
        }
        textView.setTextColor(i);
        getTvTabBg().setTypeface(Typeface.DEFAULT_BOLD);
    }

    private final void uncheckEvent() {
        getIvTabEvent().setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_event_uncheck));
        getTvTabEvent().setTextColor(ThemeManager.INSTANCE.isLight() ? this.black4b : this.grayD8);
        getTvTabEvent().setTypeface(Typeface.DEFAULT);
    }

    private final void checkEvent() {
        int i;
        TextView textView;
        getIvTabEvent().setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_event_checked));
        if (ThemeManager.INSTANCE.isLight()) {
            textView = getTvTabEvent();
            i = this.green65;
        } else {
            textView = getTvTabEvent();
            i = this.white;
        }
        textView.setTextColor(i);
        getTvTabEvent().setTypeface(Typeface.DEFAULT_BOLD);
    }

    private final void uncheckHome() {
        getIvTabHome().setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_home_uncheck));
        getTvTabHome().setTextColor(ThemeManager.INSTANCE.isLight() ? this.black4b : this.grayD8);
        getTvTabHome().setTypeface(Typeface.DEFAULT);
    }

    private final void checkHome() {
        int i;
        TextView textView;
        getIvTabHome().setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_home_checked));
        if (ThemeManager.INSTANCE.isLight()) {
            textView = getTvTabHome();
            i = this.green65;
        } else {
            textView = getTvTabHome();
            i = this.white;
        }
        textView.setTextColor(i);
        getTvTabHome().setTypeface(Typeface.DEFAULT_BOLD);
    }
}
