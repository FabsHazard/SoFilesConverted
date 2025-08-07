package com.microtech.aidexx.ui.main.home.timetab;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.DensityUtils;
import com.microtech.aidexx.utils.ThemeManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010P\u001a\u0002092\u0006\u00108\u001a\u00020\nJ\u000e\u0010Q\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010R\u001a\u0002092\b\u0010S\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010T\u001a\u0002092\u0006\u00108\u001a\u00020\nJ\u000e\u0010U\u001a\u0002092\u0006\u00108\u001a\u00020\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001c\u00100\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u000e\u00103\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R7\u00104\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u000209\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u001c\u0010G\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010A\"\u0004\bI\u0010CR\u001a\u0010J\u001a\u00020KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006V"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/timetab/TimeTabLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgSix", "Landroid/view/View;", "getBgSix", "()Landroid/view/View;", "setBgSix", "(Landroid/view/View;)V", "bgTwelve", "getBgTwelve", "setBgTwelve", "bgTwentyFour", "getBgTwentyFour", "setBgTwentyFour", "canChangeTab", "Lkotlin/Function0;", "", "getCanChangeTab", "()Lkotlin/jvm/functions/Function0;", "setCanChangeTab", "(Lkotlin/jvm/functions/Function0;)V", "currentSelect", "getCurrentSelect", "()I", "setCurrentSelect", "(I)V", "lastSelect", "getLastSelect", "setLastSelect", "layoutSix", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutSix", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setLayoutSix", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "layoutTwelve", "getLayoutTwelve", "setLayoutTwelve", "layoutTwentyFour", "getLayoutTwentyFour", "setLayoutTwentyFour", "mContext", "onTabChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pos", "", "getOnTabChange", "()Lkotlin/jvm/functions/Function1;", "setOnTabChange", "(Lkotlin/jvm/functions/Function1;)V", "tvSix", "Landroid/widget/TextView;", "getTvSix", "()Landroid/widget/TextView;", "setTvSix", "(Landroid/widget/TextView;)V", "tvTwelve", "getTvTwelve", "setTvTwelve", "tvTwentyFour", "getTvTwentyFour", "setTvTwentyFour", "upLiftPx", "", "getUpLiftPx", "()F", "setUpLiftPx", "(F)V", "changeWithoutTabChangeListener", "init", "onClick", "v", "select", "unselect", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeTabLayout.kt */
public final class TimeTabLayout extends LinearLayoutCompat implements View.OnClickListener {
    private View bgSix;
    private View bgTwelve;
    private View bgTwentyFour;
    private Function0<Boolean> canChangeTab;
    private int currentSelect;
    private int lastSelect;
    private ConstraintLayout layoutSix;
    private ConstraintLayout layoutTwelve;
    private ConstraintLayout layoutTwentyFour;
    /* access modifiers changed from: private */
    public Context mContext;
    private Function1<? super Integer, Unit> onTabChange;
    private TextView tvSix;
    private TextView tvTwelve;
    private TextView tvTwentyFour;
    private float upLiftPx;

    public final int getCurrentSelect() {
        return this.currentSelect;
    }

    public final void setCurrentSelect(int i) {
        this.currentSelect = i;
    }

    public final int getLastSelect() {
        return this.lastSelect;
    }

    public final void setLastSelect(int i) {
        this.lastSelect = i;
    }

    public final ConstraintLayout getLayoutSix() {
        return this.layoutSix;
    }

    public final void setLayoutSix(ConstraintLayout constraintLayout) {
        this.layoutSix = constraintLayout;
    }

    public final ConstraintLayout getLayoutTwelve() {
        return this.layoutTwelve;
    }

    public final void setLayoutTwelve(ConstraintLayout constraintLayout) {
        this.layoutTwelve = constraintLayout;
    }

    public final ConstraintLayout getLayoutTwentyFour() {
        return this.layoutTwentyFour;
    }

    public final void setLayoutTwentyFour(ConstraintLayout constraintLayout) {
        this.layoutTwentyFour = constraintLayout;
    }

    public final TextView getTvTwentyFour() {
        return this.tvTwentyFour;
    }

    public final void setTvTwentyFour(TextView textView) {
        this.tvTwentyFour = textView;
    }

    public final TextView getTvTwelve() {
        return this.tvTwelve;
    }

    public final void setTvTwelve(TextView textView) {
        this.tvTwelve = textView;
    }

    public final TextView getTvSix() {
        return this.tvSix;
    }

    public final void setTvSix(TextView textView) {
        this.tvSix = textView;
    }

    public final View getBgTwentyFour() {
        return this.bgTwentyFour;
    }

    public final void setBgTwentyFour(View view) {
        this.bgTwentyFour = view;
    }

    public final View getBgTwelve() {
        return this.bgTwelve;
    }

    public final void setBgTwelve(View view) {
        this.bgTwelve = view;
    }

    public final View getBgSix() {
        return this.bgSix;
    }

    public final void setBgSix(View view) {
        this.bgSix = view;
    }

    public final float getUpLiftPx() {
        return this.upLiftPx;
    }

    public final void setUpLiftPx(float f) {
        this.upLiftPx = f;
    }

    public final Function1<Integer, Unit> getOnTabChange() {
        return this.onTabChange;
    }

    public final void setOnTabChange(Function1<? super Integer, Unit> function1) {
        this.onTabChange = function1;
    }

    public final Function0<Boolean> getCanChangeTab() {
        return this.canChangeTab;
    }

    public final void setCanChangeTab(Function0<Boolean> function0) {
        this.canChangeTab = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimeTabLayout(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimeTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.layout_time_tab, this, true);
        this.layoutSix = (ConstraintLayout) inflate.findViewById(R.id.layout_six);
        this.layoutTwelve = (ConstraintLayout) inflate.findViewById(R.id.layout_twelve);
        this.layoutTwentyFour = (ConstraintLayout) inflate.findViewById(R.id.layout_twenty_four);
        this.bgSix = inflate.findViewById(R.id.bg_six);
        this.bgTwelve = inflate.findViewById(R.id.bg_twelve);
        this.bgTwentyFour = inflate.findViewById(R.id.bg_twenty_four);
        this.tvSix = (TextView) inflate.findViewById(R.id.tv_six);
        this.tvTwelve = (TextView) inflate.findViewById(R.id.tv_twelve);
        this.tvTwentyFour = (TextView) inflate.findViewById(R.id.tv_twenty_four);
        this.upLiftPx = DensityUtils.dp2pix(context, 15.0f);
        ConstraintLayout constraintLayout = this.layoutSix;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(this);
        }
        ConstraintLayout constraintLayout2 = this.layoutTwelve;
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(this);
        }
        ConstraintLayout constraintLayout3 = this.layoutTwentyFour;
        if (constraintLayout3 != null) {
            constraintLayout3.setOnClickListener(this);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{AnimatorManager.Companion.instance().createTransAnimator(this.layoutSix, -this.upLiftPx, 50), AnimatorManager.Companion.instance().createAlphaAnimator(this.bgSix, 0.0f, 1.0f)});
        animatorSet.start();
        TextView textView = this.tvSix;
        if (textView != null) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        Context context2 = null;
        if (ThemeManager.INSTANCE.isLight()) {
            TextView textView2 = this.tvSix;
            if (textView2 != null) {
                Context context3 = this.mContext;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context2 = context3;
                }
                textView2.setTextColor(ContextCompat.getColor(context2, R.color.green_65));
                return;
            }
            return;
        }
        TextView textView3 = this.tvSix;
        if (textView3 != null) {
            Context context4 = this.mContext;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context2 = context4;
            }
            textView3.setTextColor(ContextCompat.getColor(context2, R.color.gray_e6));
        }
    }

    public void onClick(View view) {
        Function1<? super Integer, Unit> function1;
        Function0<Boolean> function0 = this.canChangeTab;
        if (function0 != null && function0.invoke().booleanValue()) {
            this.lastSelect = this.currentSelect;
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            int i = R.id.layout_six;
            if (valueOf != null && valueOf.intValue() == i) {
                select(0);
                this.currentSelect = 0;
            } else {
                int i2 = R.id.layout_twelve;
                if (valueOf != null && valueOf.intValue() == i2) {
                    select(1);
                    this.currentSelect = 1;
                } else {
                    int i3 = R.id.layout_twenty_four;
                    if (valueOf != null && valueOf.intValue() == i3) {
                        select(2);
                        this.currentSelect = 2;
                    }
                }
            }
            unselect(this.lastSelect);
            int i4 = this.lastSelect;
            int i5 = this.currentSelect;
            if (i4 != i5 && (function1 = this.onTabChange) != null) {
                function1.invoke(Integer.valueOf(i5));
            }
        }
    }

    public final void changeWithoutTabChangeListener(int i) {
        this.lastSelect = this.currentSelect;
        select(i);
        this.currentSelect = i;
        unselect(this.lastSelect);
    }

    public final void select(int i) {
        ConstraintLayout constraintLayout;
        View view;
        int i2;
        if (i != this.currentSelect) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Context context = null;
            if (i == 0) {
                constraintLayout = this.layoutSix;
                view = this.bgSix;
                objectRef.element = this.tvSix;
            } else if (i == 1) {
                constraintLayout = this.layoutTwelve;
                view = this.bgTwelve;
                objectRef.element = this.tvTwelve;
            } else if (i != 2) {
                constraintLayout = null;
                view = null;
            } else {
                constraintLayout = this.layoutTwentyFour;
                view = this.bgTwentyFour;
                objectRef.element = this.tvTwentyFour;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator createTransAnimator = AnimatorManager.Companion.instance().createTransAnimator(constraintLayout, -this.upLiftPx, 200);
            ObjectAnimator createAlphaAnimator = AnimatorManager.Companion.instance().createAlphaAnimator(view, 0.0f, 1.0f);
            AnimatorManager instance = AnimatorManager.Companion.instance();
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context2 = null;
            }
            int color = ContextCompat.getColor(context2, R.color.gray_d8);
            if (ThemeManager.INSTANCE.isLight()) {
                Context context3 = this.mContext;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = context3;
                }
                i2 = ContextCompat.getColor(context, R.color.green_65);
            } else {
                Context context4 = this.mContext;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = context4;
                }
                i2 = ContextCompat.getColor(context, R.color.gray_e6);
            }
            ValueAnimator createArgbAnimator = instance.createArgbAnimator(color, i2, 200);
            createArgbAnimator.addUpdateListener(new TimeTabLayout$$ExternalSyntheticLambda0(objectRef));
            animatorSet.playTogether(new Animator[]{createTransAnimator, createAlphaAnimator, createArgbAnimator});
            animatorSet.addListener(new TimeTabLayout$select$2(objectRef, this));
            animatorSet.start();
        }
    }

    /* access modifiers changed from: private */
    public static final void select$lambda$0(Ref.ObjectRef objectRef, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(objectRef, "$tvTarget");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        TextView textView = (TextView) objectRef.element;
        if (textView != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            textView.setTextColor(((Integer) animatedValue).intValue());
        }
    }

    public final void unselect(int i) {
        ConstraintLayout constraintLayout;
        View view;
        int i2;
        if (i != this.currentSelect) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Context context = null;
            if (i == 0) {
                constraintLayout = this.layoutSix;
                view = this.bgSix;
                objectRef.element = this.tvSix;
            } else if (i == 1) {
                constraintLayout = this.layoutTwelve;
                view = this.bgTwelve;
                objectRef.element = this.tvTwelve;
            } else if (i != 2) {
                constraintLayout = null;
                view = null;
            } else {
                constraintLayout = this.layoutTwentyFour;
                view = this.bgTwentyFour;
                objectRef.element = this.tvTwentyFour;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator createTransAnimator = AnimatorManager.Companion.instance().createTransAnimator(constraintLayout, 0.0f, 200);
            ObjectAnimator createAlphaAnimator = AnimatorManager.Companion.instance().createAlphaAnimator(view, 1.0f, 0.0f);
            AnimatorManager instance = AnimatorManager.Companion.instance();
            if (ThemeManager.INSTANCE.isLight()) {
                Context context2 = this.mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context2 = null;
                }
                i2 = ContextCompat.getColor(context2, R.color.green_65);
            } else {
                Context context3 = this.mContext;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context3 = null;
                }
                i2 = ContextCompat.getColor(context3, R.color.gray_e6);
            }
            Context context4 = this.mContext;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context4;
            }
            ValueAnimator createArgbAnimator = instance.createArgbAnimator(i2, ContextCompat.getColor(context, R.color.gray_d8), 200);
            createArgbAnimator.addUpdateListener(new TimeTabLayout$$ExternalSyntheticLambda1(objectRef));
            animatorSet.playTogether(new Animator[]{createTransAnimator, createAlphaAnimator, createArgbAnimator});
            animatorSet.addListener(new TimeTabLayout$unselect$2(objectRef, this));
            animatorSet.start();
        }
    }

    /* access modifiers changed from: private */
    public static final void unselect$lambda$1(Ref.ObjectRef objectRef, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(objectRef, "$tvTarget");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        TextView textView = (TextView) objectRef.element;
        if (textView != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            textView.setTextColor(((Integer) animatedValue).intValue());
        }
    }
}
