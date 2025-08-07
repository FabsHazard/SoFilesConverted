package com.microtech.aidexx.ui.upgrade;

import android.widget.ScrollView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.net.entity.UpgradeInfo;
import com.microtech.aidexx.common.net.entity.VersionInfo;
import com.microtech.aidexx.data.resource.AppUpgradeManager;
import com.microtech.aidexx.databinding.DialogAppUpdateBinding;
import com.microtech.aidexx.utils.ToastUtil;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.upgrade.AppUpdateFragment$onViewCreated$1", f = "AppUpdateFragment.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AppUpdateFragment.kt */
final class AppUpdateFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppUpdateFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppUpdateFragment$onViewCreated$1(AppUpdateFragment appUpdateFragment, Continuation<? super AppUpdateFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = appUpdateFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppUpdateFragment$onViewCreated$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppUpdateFragment$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<Pair<Integer, String>> upgradeProgressFlow = AppUpgradeManager.INSTANCE.getUpgradeProgressFlow();
            final AppUpdateFragment appUpdateFragment = this.this$0;
            this.label = 1;
            if (upgradeProgressFlow.collect(new FlowCollector() {
                public final Object emit(Pair<Integer, String> pair, Continuation<? super Unit> continuation) {
                    if (pair != null) {
                        AppUpdateFragment appUpdateFragment = appUpdateFragment;
                        int intValue = pair.getFirst().intValue();
                        if (intValue == -1) {
                            ToastUtil.INSTANCE.showLong("升级失败,请重试");
                            DialogAppUpdateBinding binding = appUpdateFragment.getBinding();
                            ScrollView scrollView = binding.slContent;
                            Intrinsics.checkNotNullExpressionValue(scrollView, "slContent");
                            scrollView.setVisibility(0);
                            binding.llDownload.setVisibility(0);
                            binding.txtUpdateProgress.setVisibility(8);
                            binding.txtUpdateProgress.setText(appUpdateFragment.getString(R.string.app_download, "0%"));
                        } else if (intValue != 100) {
                            DialogAppUpdateBinding binding2 = appUpdateFragment.getBinding();
                            ScrollView scrollView2 = binding2.slContent;
                            Intrinsics.checkNotNullExpressionValue(scrollView2, "slContent");
                            scrollView2.setVisibility(8);
                            binding2.llDownload.setVisibility(8);
                            binding2.txtUpdateProgress.setVisibility(0);
                            binding2.txtUpdateProgress.setText(appUpdateFragment.getString(R.string.app_download, new StringBuilder().append(pair.getFirst().intValue()).append('%').toString()));
                        } else {
                            UpgradeInfo access$getUpdateInfo$p = appUpdateFragment.updateInfo;
                            VersionInfo appUpdateInfo = access$getUpdateInfo$p != null ? access$getUpdateInfo$p.getAppUpdateInfo() : null;
                            Intrinsics.checkNotNull(appUpdateInfo);
                            if (!appUpdateInfo.isForce()) {
                                appUpdateFragment.dismiss();
                            } else {
                                DialogAppUpdateBinding binding3 = appUpdateFragment.getBinding();
                                ScrollView scrollView3 = binding3.slContent;
                                Intrinsics.checkNotNullExpressionValue(scrollView3, "slContent");
                                scrollView3.setVisibility(0);
                                binding3.llDownload.setVisibility(0);
                                binding3.txtUpdateProgress.setVisibility(8);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
