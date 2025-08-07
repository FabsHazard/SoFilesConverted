package com.microtech.aidexx.ui.setting.share;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "item", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareFollowFragment.kt */
final class ShareFollowFragment$getData$1$1$1$1$1 extends Lambda implements Function1<ShareUserInfo, Unit> {
    final /* synthetic */ ShareFollowFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareFollowFragment$getData$1$1$1$1$1(ShareFollowFragment shareFollowFragment) {
        super(1);
        this.this$0 = shareFollowFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ShareUserInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ShareUserInfo shareUserInfo) {
        Intrinsics.checkNotNullParameter(shareUserInfo, "item");
        Intent intent = new Intent(this.this$0.getContext(), ShareAndFollowEditActivity.class);
        intent.putExtra(ShareAndFollowEditActivityKt.EDIT_FROM, this.this$0.isShare ? 1 : 2);
        intent.putExtra(ShareAndFollowEditActivityKt.EDIT_DATA, shareUserInfo);
        this.this$0.startActivity(intent);
    }
}
