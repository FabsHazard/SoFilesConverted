package com.microtech.aidexx.ui.main;

import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.ActivityMainBinding;
import com.microtech.aidexx.ui.main.event.EventFragment;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
final class MainActivity$initView$1$3 extends Lambda implements Function1<Integer, Boolean> {
    final /* synthetic */ ActivityMainBinding $this_apply;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivity$initView$1$3(MainActivity mainActivity, ActivityMainBinding activityMainBinding) {
        super(1);
        this.this$0 = mainActivity;
        this.$this_apply = activityMainBinding;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Boolean invoke(int i) {
        LogUtil.Companion.xLogE$default(LogUtil.Companion, "GBGBGBAR onTabChange " + ((ActivityMainBinding) this.this$0.getBinding()).viewpager.getCurrentItem(), (String) null, 2, (Object) null);
        boolean z = false;
        if ((i == 3 || i == 4) && UserInfoManager.Companion.getShareUserInfo() != null) {
            String string = this.this$0.getResources().getString(R.string.share_abandon);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
        } else {
            if (this.$this_apply.viewpager.getCurrentItem() == 4) {
                RecyclerView.Adapter adapter = this.$this_apply.viewpager.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.microtech.aidexx.ui.main.MainViewPagerAdapter");
                EventFragment eventFragment = (EventFragment) ((MainViewPagerAdapter) adapter).getItem(4);
                if (!(eventFragment != null ? eventFragment.needConfirmLeave(new MainActivity$initView$1$3$hasConfirm$1(this.$this_apply, i)) : true)) {
                    this.$this_apply.viewpager.setCurrentItem(i, false);
                }
            } else {
                this.$this_apply.viewpager.setCurrentItem(i, false);
            }
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
