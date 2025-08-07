package com.microtech.aidexx.ui.setting.share;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStoreOwner;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareFollowFragment.kt */
final class ShareFollowFragment$sfViewModel$2 extends Lambda implements Function0<ViewModelStoreOwner> {
    final /* synthetic */ ShareFollowFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareFollowFragment$sfViewModel$2(ShareFollowFragment shareFollowFragment) {
        super(0);
        this.this$0 = shareFollowFragment;
    }

    public final ViewModelStoreOwner invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        return requireActivity;
    }
}
