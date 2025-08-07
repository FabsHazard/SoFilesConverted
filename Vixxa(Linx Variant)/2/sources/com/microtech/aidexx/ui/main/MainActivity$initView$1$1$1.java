package com.microtech.aidexx.ui.main;

import androidx.viewpager2.widget.ViewPager2;
import com.microtech.aidexx.databinding.ActivityMainBinding;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/main/MainActivity$initView$1$1$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity$initView$1$1$1 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ MainActivity this$0;

    MainActivity$initView$1$1$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public void onPageSelected(int i) {
        ((ActivityMainBinding) this.this$0.getBinding()).mainTabView.check(i);
    }
}
