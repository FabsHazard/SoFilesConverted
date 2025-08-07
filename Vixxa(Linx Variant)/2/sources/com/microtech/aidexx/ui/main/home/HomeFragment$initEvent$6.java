package com.microtech.aidexx.ui.main.home;

import android.widget.ImageView;
import com.microtech.aidexx.databinding.FragmentHomeBinding;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeFragment.kt */
final class HomeFragment$initEvent$6 extends Lambda implements Function1<List<ShareUserInfo>, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFragment$initEvent$6(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<ShareUserInfo>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ShareUserInfo> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        this.this$0.getHomeViewModel().updateFollowers(list);
        ImageView imageView = ((FragmentHomeBinding) this.this$0.getBinding()).switchUserData;
        Intrinsics.checkNotNullExpressionValue(imageView, "switchUserData");
        imageView.setVisibility(!this.this$0.getHomeViewModel().getMFollowers().isEmpty() ? 0 : 8);
    }
}
