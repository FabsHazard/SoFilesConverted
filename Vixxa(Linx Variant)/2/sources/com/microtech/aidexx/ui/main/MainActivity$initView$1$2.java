package com.microtech.aidexx.ui.main;

import android.view.ViewTreeObserver;
import com.microtech.aidexx.databinding.ActivityMainBinding;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/microtech/aidexx/ui/main/MainActivity$initView$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity$initView$1$2 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ MainActivity this$0;

    MainActivity$initView$1$2(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public void onGlobalLayout() {
        LogUtil.Companion.xLogE$default(LogUtil.Companion, "GBGBGBAR onGlobalLayout " + ((ActivityMainBinding) this.this$0.getBinding()).viewpager.getCurrentItem(), (String) null, 2, (Object) null);
        ((ActivityMainBinding) this.this$0.getBinding()).mainTabView.check(((ActivityMainBinding) this.this$0.getBinding()).viewpager.getCurrentItem());
        ((ActivityMainBinding) this.this$0.getBinding()).viewpager.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
