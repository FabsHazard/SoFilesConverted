package com.microtech.aidexx.ui.qrcode;

import com.microtech.aidexx.R;
import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.repository.AccountRepository;
import com.microtech.aidexx.ui.pair.PairUtilKt;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.qrcode.QrCodeScanActivity$processWatchInfo$1$1", f = "QrCodeScanActivity.kt", i = {}, l = {168, 177}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: QrCodeScanActivity.kt */
final class QrCodeScanActivity$processWatchInfo$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $watchCodeId;
    int label;
    final /* synthetic */ QrCodeScanActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QrCodeScanActivity$processWatchInfo$1$1(int i, QrCodeScanActivity qrCodeScanActivity, Continuation<? super QrCodeScanActivity$processWatchInfo$1$1> continuation) {
        super(2, continuation);
        this.$watchCodeId = i;
        this.this$0 = qrCodeScanActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QrCodeScanActivity$processWatchInfo$1$1(this.$watchCodeId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QrCodeScanActivity$processWatchInfo$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        QrCodeScanActivity qrCodeScanActivity;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Dialogs.showWait$default(Dialogs.INSTANCE, (String) null, 1, (Object) null);
            this.label = 1;
            obj = AccountRepository.INSTANCE.scanWatchQr(this.$watchCodeId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i2 == 2) {
            ResultKt.throwOnFailure(obj);
            this.this$0.finish();
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ApiResult apiResult = (ApiResult) obj;
        if (apiResult instanceof ApiResult.Success) {
            MmkvManager.INSTANCE.bindWatch();
            Dialogs.INSTANCE.showSuccess(this.this$0.getString(R.string.scan_watch_success));
        } else if (apiResult instanceof ApiResult.Failure) {
            Dialogs dialogs = Dialogs.INSTANCE;
            if (((ApiResult.Failure) apiResult).isBizFail()) {
                qrCodeScanActivity = this.this$0;
                i = R.string.scan_watch_failure;
            } else {
                qrCodeScanActivity = this.this$0;
                i = R.string.com_network_failure;
            }
            Dialogs.showError$default(dialogs, qrCodeScanActivity.getString(i), 0, 2, (Object) null);
        }
        this.label = 2;
        if (DelayKt.delay(PairUtilKt.DELAY_A_WHILE, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.finish();
        return Unit.INSTANCE;
    }
}
