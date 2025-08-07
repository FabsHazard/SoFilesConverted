package com.microtech.aidexx.data;

import com.microtech.aidexx.utils.LogUtil;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CoroutineExceptionHandler.kt */
public final class DataSyncController$special$$inlined$CoroutineExceptionHandler$3 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ DataSyncController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataSyncController$special$$inlined$CoroutineExceptionHandler$3(CoroutineExceptionHandler.Key key, DataSyncController dataSyncController) {
        super(key);
        this.this$0 = dataSyncController;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        LogUtil.Companion.xLogE(this.this$0 + " share数据同步异常 \n " + ExceptionsKt.stackTraceToString(th), "DataSyncController");
        this.this$0.stopDownloadShareUserData(true);
    }
}
