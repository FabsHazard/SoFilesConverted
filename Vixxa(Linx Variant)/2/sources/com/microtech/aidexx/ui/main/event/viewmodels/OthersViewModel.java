package com.microtech.aidexx.ui.main.event.viewmodels;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.event.BaseEventDetail;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000f\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/viewmodels/OthersViewModel;", "Lcom/microtech/aidexx/ui/main/event/viewmodels/BaseEventViewModel;", "Lcom/microtech/aidexx/db/entity/event/OthersEntity;", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "genEventEntityWhenSave", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "genNewPreset", "name", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetailHistory", "", "getEventSlotType", "", "()Ljava/lang/Integer;", "queryPresetByName", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OthersViewModel.kt */
public final class OthersViewModel extends BaseEventViewModel<OthersEntity, BaseEventDetail, BasePresetEntity> {
    private String content = "";

    public Integer getEventSlotType() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Object queryPresetByName(String str, Continuation<? super List<? extends BasePresetEntity>> continuation) {
        return CollectionsKt.emptyList();
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    /* access modifiers changed from: protected */
    public Object genNewPreset(String str, Continuation<? super BasePresetEntity> continuation) {
        return new BasePresetEntity();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getDetailHistory(kotlin.coroutines.Continuation<? super java.util.List<? extends com.microtech.aidexx.db.entity.event.BaseEventDetail>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel$getDetailHistory$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel$getDetailHistory$1 r0 = (com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel$getDetailHistory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel$getDetailHistory$1 r0 = new com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel$getDetailHistory$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0058
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            com.microtech.aidexx.db.repository.EventDbRepository r8 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            io.objectbox.Property<com.microtech.aidexx.db.entity.event.OthersEntity> r8 = com.microtech.aidexx.db.entity.event.OthersEntity_.timestamp
            java.lang.String r2 = "timestamp"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            com.microtech.aidexx.db.dao.EventDao r2 = com.microtech.aidexx.db.dao.EventDao.INSTANCE
            com.microtech.aidexx.db.ObjectBox r2 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel$getDetailHistory$$inlined$queryHistory$1 r4 = new com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel$getDetailHistory$$inlined$queryHistory$1
            r5 = 15
            r4.<init>(r5, r8)
            java.util.concurrent.Callable r4 = (java.util.concurrent.Callable) r4
            io.objectbox.BoxStore r8 = r2.getStore()
            r0.label = r3
            java.lang.Object r8 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r8, r4, r0)
            if (r8 != r1) goto L_0x0058
            return r1
        L_0x0058:
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L_0x008e
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r8 = r8.iterator()
        L_0x006f:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x008b
            java.lang.Object r1 = r8.next()
            com.microtech.aidexx.db.entity.event.OthersEntity r1 = (com.microtech.aidexx.db.entity.event.OthersEntity) r1
            com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel$getDetailHistory$2$1$1 r2 = new com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel$getDetailHistory$2$1$1
            r2.<init>()
            java.lang.String r1 = r1.getContent()
            r2.setName(r1)
            r0.add(r2)
            goto L_0x006f
        L_0x008b:
            java.util.List r0 = (java.util.List) r0
            goto L_0x0092
        L_0x008e:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0092:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel.getDetailHistory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Object genEventEntityWhenSave(Continuation<? super OthersEntity> continuation) {
        OthersEntity othersEntity = new OthersEntity();
        othersEntity.setUploadState(1);
        othersEntity.setContent(this.content);
        othersEntity.setUserId(UserInfoManager.Companion.instance().userId());
        othersEntity.setTimeInfo(getEventTime());
        return othersEntity;
    }
}
