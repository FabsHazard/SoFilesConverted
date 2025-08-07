package com.microtech.aidexx.ui.setting.share;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragShareOrFollowBinding;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareFollowFragment$getData$1", f = "ShareFollowFragment.kt", i = {}, l = {77, 77}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShareFollowFragment.kt */
final class ShareFollowFragment$getData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShareFollowFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareFollowFragment$getData$1(ShareFollowFragment shareFollowFragment, Continuation<? super ShareFollowFragment$getData$1> continuation) {
        super(2, continuation);
        this.this$0 = shareFollowFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareFollowFragment$getData$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShareFollowFragment$getData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!NetUtil.isNetAvailable(this.this$0.requireContext())) {
                ((FragShareOrFollowBinding) this.this$0.getBinding()).shareRefreshLayout.finishRefresh();
                String string = this.this$0.getString(R.string.com_network_unused);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ExtendsKt.toast(string);
                LogUtil.Companion companion = LogUtil.Companion;
                String access$getTAG$cp = ShareFollowFragment.TAG;
                Intrinsics.checkNotNullExpressionValue(access$getTAG$cp, "access$getTAG$cp(...)");
                companion.xLogE("no net", access$getTAG$cp);
                return Unit.INSTANCE;
            }
            this.label = 1;
            obj = this.this$0.getSfViewModel().loadData(this.this$0.isShare, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ShareFollowFragment shareFollowFragment = this.this$0;
        this.label = 2;
        if (((Flow) obj).collect(new FlowCollector() {
            public final Object emit(List<ShareUserInfo> list, Continuation<? super Unit> continuation) {
                LogUtil.Companion companion = LogUtil.Companion;
                String access$getTAG$cp = ShareFollowFragment.TAG;
                Intrinsics.checkNotNullExpressionValue(access$getTAG$cp, "access$getTAG$cp(...)");
                companion.xLogE("loadData collect", access$getTAG$cp);
                ViewBinding binding = shareFollowFragment.getBinding();
                ShareFollowFragment shareFollowFragment = shareFollowFragment;
                FragShareOrFollowBinding fragShareOrFollowBinding = (FragShareOrFollowBinding) binding;
                fragShareOrFollowBinding.shareRefreshLayout.finishRefresh();
                RecyclerView recyclerView = fragShareOrFollowBinding.listShare;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "listShare");
                View view = recyclerView;
                int i = 0;
                if (!(list != null ? !list.isEmpty() : false)) {
                    i = 8;
                }
                view.setVisibility(i);
                if (list != null) {
                    if (!list.isEmpty()) {
                        fragShareOrFollowBinding.listShare.setLayoutManager(new LinearLayoutManager(shareFollowFragment.getContext()));
                        shareFollowFragment.listAdapter = new ShareFollowListAdapter();
                        ShareFollowListAdapter access$getListAdapter$p = shareFollowFragment.listAdapter;
                        Intrinsics.checkNotNull(access$getListAdapter$p);
                        access$getListAdapter$p.setOnItemClickListener(new ShareFollowFragment$getData$1$1$1$1$1(shareFollowFragment));
                        fragShareOrFollowBinding.listShare.setAdapter(shareFollowFragment.listAdapter);
                        ShareFollowListAdapter access$getListAdapter$p2 = shareFollowFragment.listAdapter;
                        Intrinsics.checkNotNull(access$getListAdapter$p2);
                        access$getListAdapter$p2.setData(list);
                        ShareFollowListAdapter access$getListAdapter$p3 = shareFollowFragment.listAdapter;
                        Intrinsics.checkNotNull(access$getListAdapter$p3);
                        access$getListAdapter$p3.notifyDataSetChanged();
                    }
                    if (!shareFollowFragment.isShare) {
                        EventBusManager.INSTANCE.send(EventBusKey.EVENT_FOLLOWERS_UPDATED, list);
                    }
                }
                return Unit.INSTANCE;
            }
        }, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
