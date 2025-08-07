package com.microtech.aidexx.data;

import com.microtech.aidexx.data.DataSyncController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$Companion$downloadData$tasks$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Function1<DataSyncController.SyncStatus, Unit> $callback;
    final /* synthetic */ String $userId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$Companion$downloadData$tasks$1(String str, Function1<? super DataSyncController.SyncStatus, Unit> function1) {
        super(0);
        this.$userId = str;
        this.$callback = function1;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(DataSyncController.startDownload$default(CloudCgmHistorySync.INSTANCE, this.$userId, (CoroutineScope) null, this.$callback, 2, (Object) null));
    }
}
