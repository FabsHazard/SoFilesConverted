package com.microtech.aidexx.ui.setting;

import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.common.net.entity.AppInformation;
import com.microtech.aidexx.databinding.ActivityAppInfoBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.AppInfoActivity$setData$1$1", f = "AppInfoActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AppInfoActivity.kt */
final class AppInfoActivity$setData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInformation $it;
    int label;
    final /* synthetic */ AppInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppInfoActivity$setData$1$1(AppInfoActivity appInfoActivity, AppInformation appInformation, Continuation<? super AppInfoActivity$setData$1$1> continuation) {
        super(2, continuation);
        this.this$0 = appInfoActivity;
        this.$it = appInformation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInfoActivity$setData$1$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppInfoActivity$setData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        CharSequence charSequence5;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ViewBinding binding = this.this$0.getBinding();
            AppInformation appInformation = this.$it;
            ActivityAppInfoBinding activityAppInfoBinding = (ActivityAppInfoBinding) binding;
            TextView textView = activityAppInfoBinding.appInfoCompanyName;
            String companyName = appInformation.getCompanyName();
            textView.setText(companyName != null ? companyName : "");
            TextView textView2 = activityAppInfoBinding.appInfoCompanyAddress;
            String companyAddress = appInformation.getCompanyAddress();
            if (companyAddress != null) {
                charSequence = companyAddress;
            } else {
                charSequence = "";
            }
            textView2.setText(charSequence);
            TextView textView3 = activityAppInfoBinding.appInfoProxyName;
            String proxyName = appInformation.getProxyName();
            if (proxyName != null) {
                charSequence2 = proxyName;
            } else {
                charSequence2 = "";
            }
            textView3.setText(charSequence2);
            TextView textView4 = activityAppInfoBinding.appInfoProxyInformation;
            String proxyInformation = appInformation.getProxyInformation();
            if (proxyInformation != null) {
                charSequence3 = proxyInformation;
            } else {
                charSequence3 = "";
            }
            textView4.setText(charSequence3);
            TextView textView5 = activityAppInfoBinding.udiTv;
            String udi = appInformation.getUdi();
            if (udi != null) {
                charSequence4 = udi;
            } else {
                charSequence4 = "";
            }
            textView5.setText(charSequence4);
            TextView textView6 = activityAppInfoBinding.softwareReleaseDate;
            String releaseDate = appInformation.getReleaseDate();
            if (releaseDate != null) {
                charSequence5 = releaseDate;
            } else {
                charSequence5 = "";
            }
            textView6.setText(charSequence5);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
