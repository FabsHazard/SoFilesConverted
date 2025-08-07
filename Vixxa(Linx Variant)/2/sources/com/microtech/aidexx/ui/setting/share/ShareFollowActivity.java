package com.microtech.aidexx.ui.setting.share;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.ActivityShareBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareFollowActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityShareBinding;", "()V", "frgShareAuthor", "Lcom/microtech/aidexx/ui/setting/share/ShareFollowFragment;", "frgShareFollow", "tagFollow", "", "tagShare", "getViewBinding", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "replaceFragment", "tag", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareFollowActivity.kt */
public final class ShareFollowActivity extends BaseActivity<BaseViewModel, ActivityShareBinding> {
    private ShareFollowFragment frgShareAuthor;
    private ShareFollowFragment frgShareFollow;
    /* access modifiers changed from: private */
    public final String tagFollow = "follow";
    /* access modifiers changed from: private */
    public final String tagShare = "share";

    public ActivityShareBinding getViewBinding() {
        ActivityShareBinding inflate = ActivityShareBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityShareBinding) getBinding()).getRoot());
        List mutableListOf = CollectionsKt.mutableListOf(getString(R.string.share_manager_share), getString(R.string.share_manager_follow));
        ((ActivityShareBinding) getBinding()).actionBar.getLeftIcon().setOnClickListener(new ShareFollowActivity$$ExternalSyntheticLambda0(this));
        this.frgShareAuthor = ShareFollowFragment.Companion.getShareInstance();
        replaceFragment(this.tagShare);
        ActivityShareBinding activityShareBinding = (ActivityShareBinding) getBinding();
        activityShareBinding.shareNav.setTitles(mutableListOf);
        activityShareBinding.shareNav.setOnTabListener(new ShareFollowActivity$onCreate$2$1(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(ShareFollowActivity shareFollowActivity, View view) {
        Intrinsics.checkNotNullParameter(shareFollowActivity, "this$0");
        shareFollowActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void replaceFragment(String str) {
        ShareFollowFragment shareFollowFragment;
        if (Intrinsics.areEqual((Object) str, (Object) this.tagFollow)) {
            if (this.frgShareFollow == null) {
                this.frgShareFollow = ShareFollowFragment.Companion.getFollowInstance();
            }
            shareFollowFragment = this.frgShareFollow;
        } else {
            shareFollowFragment = this.frgShareAuthor;
            if (shareFollowFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frgShareAuthor");
                shareFollowFragment = null;
            }
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        int i = R.id.frg_share;
        Intrinsics.checkNotNull(shareFollowFragment, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        beginTransaction.replace(i, (Fragment) shareFollowFragment, str);
        beginTransaction.commitAllowingStateLoss();
    }
}
