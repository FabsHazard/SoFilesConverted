package com.microtech.aidexx.ui.setting.share;

import android.view.View;
import com.microtech.aidexx.views.tab.ScrollTab;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/microtech/aidexx/ui/setting/share/ShareFollowActivity$onCreate$2$1", "Lcom/microtech/aidexx/views/tab/ScrollTab$OnTabListener;", "onChange", "", "position", "", "v", "Landroid/view/View;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareFollowActivity.kt */
public final class ShareFollowActivity$onCreate$2$1 implements ScrollTab.OnTabListener {
    final /* synthetic */ ShareFollowActivity this$0;

    ShareFollowActivity$onCreate$2$1(ShareFollowActivity shareFollowActivity) {
        this.this$0 = shareFollowActivity;
    }

    public boolean onChange(int i, View view) {
        ShareFollowActivity shareFollowActivity = this.this$0;
        shareFollowActivity.replaceFragment(i == 0 ? shareFollowActivity.tagShare : shareFollowActivity.tagFollow);
        return true;
    }
}
