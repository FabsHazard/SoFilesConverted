package com.microtech.aidexx.data;

import com.microtech.aidexx.common.net.repository.EventRepository;
import com.microtech.aidexx.data.DataSyncController;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync$Companion$downloadRecentData$2$tasks$6", f = "CloudHistorySync.kt", i = {0, 0, 0, 0}, l = {305}, m = "invokeSuspend", n = {"loginStateKey$iv", "taskItemListKey$iv", "startAutoIncrementColumn$iv", "endAutoIncrementColumn$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$Companion$downloadRecentData$2$tasks$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $isSuccess;
    final /* synthetic */ String $userId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$Companion$downloadRecentData$2$tasks$6(String str, Ref.BooleanRef booleanRef, Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$6> continuation) {
        super(2, continuation);
        this.$userId = str;
        this.$isSuccess = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudHistorySync$Companion$downloadRecentData$2$tasks$6(this.$userId, this.$isSuccess, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudHistorySync$Companion$downloadRecentData$2$tasks$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        boolean z;
        String str2;
        Object obj2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.BooleanRef booleanRef;
        Long l;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = this.$isSuccess;
            EventRepository eventRepository = EventRepository.INSTANCE;
            String str3 = this.$userId;
            Class<DietEntity> cls = DietEntity.class;
            String loginStateKey = DataSyncController.Companion.getLoginStateKey(str3, cls);
            String loginMaxIdKey = DataSyncController.Companion.getLoginMaxIdKey(str3, cls);
            str = DataSyncController.Companion.getTaskItemListKey(str3, cls);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef5 = objectRef3;
            this.L$0 = loginStateKey;
            this.L$1 = str;
            this.L$2 = objectRef5;
            Ref.ObjectRef objectRef6 = objectRef4;
            this.L$3 = objectRef6;
            this.L$4 = booleanRef2;
            z = true;
            this.label = 1;
            obj2 = BuildersKt.withContext(Dispatchers.getIO(), new CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1(loginStateKey, objectRef3, str3, loginMaxIdKey, 5000, 500, objectRef4, cls, (Continuation) null), this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
            str2 = loginStateKey;
            objectRef2 = objectRef6;
            objectRef = objectRef5;
        } else if (i == 1) {
            booleanRef = (Ref.BooleanRef) this.L$4;
            objectRef2 = (Ref.ObjectRef) this.L$3;
            objectRef = (Ref.ObjectRef) this.L$2;
            str2 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            z = true;
            str = (String) this.L$1;
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        if (booleanValue) {
            MmkvManager.INSTANCE.setLastLoginEventDownloadState(str2, z);
            if (objectRef2.element != null && ((l = (Long) objectRef2.element) == null || l.longValue() != 0)) {
                DataSyncController.SyncTaskItemList eventSyncTask = MmkvManager.INSTANCE.getEventSyncTask(str);
                if (eventSyncTask == null) {
                    eventSyncTask = new DataSyncController.SyncTaskItemList(new ArrayList());
                }
                eventSyncTask.getList().add(0, new DataSyncController.SyncTaskItem((Long) objectRef.element, (Long) objectRef2.element));
                MmkvManager.INSTANCE.setEventSyncTask(str, eventSyncTask);
                LogUtil.Companion.d("SyncTaskItemList " + str + '=' + eventSyncTask, "getRecentData");
            }
        }
        CloudHistorySync$Companion$downloadRecentData$2.invokeSuspend$updateStatus(booleanRef, booleanValue);
        return Unit.INSTANCE;
    }
}
