package com.microtech.aidexx.ui.main.home;

import android.view.View;
import android.widget.ImageView;
import com.microtech.aidexx.databinding.FragmentHomeBinding;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.HomeFragment$checkBtState$1", f = "HomeFragment.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeFragment.kt */
final class HomeFragment$checkBtState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFragment$checkBtState$1(HomeFragment homeFragment, Continuation<? super HomeFragment$checkBtState$1> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$checkBtState$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeFragment$checkBtState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        View view;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImageView imageView = ((FragmentHomeBinding) this.this$0.getBinding()).switchUserData;
            Intrinsics.checkNotNullExpressionValue(imageView, "switchUserData");
            View view2 = imageView;
            this.L$0 = view2;
            this.label = 1;
            Object followers = this.this$0.getHomeViewModel().getFollowers(this);
            if (followers == coroutine_suspended) {
                return coroutine_suspended;
            }
            view = view2;
            obj = followers;
        } else if (i == 1) {
            view = (View) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        view.setVisibility(((Boolean) obj).booleanValue() ? 0 : 8);
        ImageView imageView2 = ((FragmentHomeBinding) this.this$0.getBinding()).welfareCenter;
        Intrinsics.checkNotNullExpressionValue(imageView2, "welfareCenter");
        imageView2.setVisibility(8);
        return Unit.INSTANCE;
    }
}
