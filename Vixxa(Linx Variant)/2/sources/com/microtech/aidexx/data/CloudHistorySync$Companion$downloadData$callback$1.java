package com.microtech.aidexx.data;

import com.microtech.aidexx.data.CloudHistorySync;
import com.microtech.aidexx.data.DataSyncController;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "it", "Lcom/microtech/aidexx/data/DataSyncController$SyncStatus;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$Companion$downloadData$callback$1 extends Lambda implements Function1<DataSyncController.SyncStatus, Unit> {
    final /* synthetic */ Ref.BooleanRef $isSuccess;
    final /* synthetic */ Ref.ObjectRef<CountDownLatch> $taskLatch;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$Companion$downloadData$callback$1(Ref.BooleanRef booleanRef, Ref.ObjectRef<CountDownLatch> objectRef) {
        super(1);
        this.$isSuccess = booleanRef;
        this.$taskLatch = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DataSyncController.SyncStatus) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DataSyncController.SyncStatus syncStatus) {
        CloudHistorySync.Companion.downloadData$updateRet(this.$isSuccess, this.$taskLatch, syncStatus);
    }
}
