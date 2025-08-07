package com.microtech.aidexx.ui.welcome.guide;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.ActivityGuidanceBinding;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.ui.main.home.UnitChoseFragment;
import com.microtech.aidexx.ui.welcome.guide.fragment.GuideBaseFragment;
import com.microtech.aidexx.utils.ActivityUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/GuidanceActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityGuidanceBinding;", "()V", "currentPosition", "", "getViewBinding", "goBack", "", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GuidanceActivity.kt */
public final class GuidanceActivity extends BaseActivity<BaseViewModel, ActivityGuidanceBinding> {
    /* access modifiers changed from: private */
    public int currentPosition;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityGuidanceBinding) getBinding()).getRoot());
        initView();
    }

    private final void initView() {
        UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
        if (userEntity != null && userEntity.isUnitGuide() == 0) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
            beginTransaction.add((Fragment) new UnitChoseFragment(), UnitChoseFragment.TAG);
            beginTransaction.commitAllowingStateLoss();
        }
        GuideViewPagerAdapter guideViewPagerAdapter = new GuideViewPagerAdapter(this);
        ActivityGuidanceBinding activityGuidanceBinding = (ActivityGuidanceBinding) getBinding();
        ExtendsKt.setDebounceClickListener$default(activityGuidanceBinding.actionbarGuide.getLeftIcon(), 0, new GuidanceActivity$$ExternalSyntheticLambda0(this), 1, (Object) null);
        TextView textView = activityGuidanceBinding.tvNextStep;
        Intrinsics.checkNotNullExpressionValue(textView, "tvNextStep");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new GuidanceActivity$$ExternalSyntheticLambda1(guideViewPagerAdapter, this, activityGuidanceBinding), 1, (Object) null);
        ViewPager2 viewPager2 = activityGuidanceBinding.viewpagerGuide;
        viewPager2.setOffscreenPageLimit(8);
        viewPager2.setAdapter(guideViewPagerAdapter);
        viewPager2.setUserInputEnabled(false);
        viewPager2.setCurrentItem(GuidePages.PERMISSION_CHECK.ordinal(), false);
        viewPager2.registerOnPageChangeCallback(new GuidanceActivity$initView$1$3$1(guideViewPagerAdapter, activityGuidanceBinding, this));
        activityGuidanceBinding.viewpagerGuide.getViewTreeObserver().addOnGlobalLayoutListener(new GuidanceActivity$initView$1$4(guideViewPagerAdapter, activityGuidanceBinding, this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$0(GuidanceActivity guidanceActivity, View view) {
        Intrinsics.checkNotNullParameter(guidanceActivity, "this$0");
        guidanceActivity.goBack();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$1(GuideViewPagerAdapter guideViewPagerAdapter, GuidanceActivity guidanceActivity, ActivityGuidanceBinding activityGuidanceBinding, View view) {
        Intrinsics.checkNotNullParameter(guideViewPagerAdapter, "$viewPagerAdapter");
        Intrinsics.checkNotNullParameter(guidanceActivity, "this$0");
        Intrinsics.checkNotNullParameter(activityGuidanceBinding, "$this_apply");
        GuideBaseFragment<?, ?> item = guideViewPagerAdapter.getItem(guidanceActivity.currentPosition);
        if (item != null) {
            item.onNextClick();
        }
        if (guidanceActivity.currentPosition < guideViewPagerAdapter.getItemCount() - 1) {
            ViewPager2 viewPager2 = activityGuidanceBinding.viewpagerGuide;
            int i = guidanceActivity.currentPosition + 1;
            guidanceActivity.currentPosition = i;
            viewPager2.setCurrentItem(i);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(guidanceActivity), (CoroutineContext) null, (CoroutineStart) null, new GuidanceActivity$initView$1$2$1(guidanceActivity, (Continuation<? super GuidanceActivity$initView$1$2$1>) null), 3, (Object) null);
    }

    private final void goBack() {
        if (this.currentPosition == 0) {
            ActivityUtil.INSTANCE.toSystemHome(this);
            return;
        }
        ViewPager2 viewPager2 = ((ActivityGuidanceBinding) getBinding()).viewpagerGuide;
        int i = this.currentPosition - 1;
        this.currentPosition = i;
        viewPager2.setCurrentItem(i);
    }

    public void onBackPressed() {
        goBack();
    }

    public ActivityGuidanceBinding getViewBinding() {
        ActivityGuidanceBinding inflate = ActivityGuidanceBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
