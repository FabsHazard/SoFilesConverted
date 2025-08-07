package com.microtech.aidexx.ui.main.event.viewmodels;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.resource.EventUnitManager;
import com.microtech.aidexx.db.entity.event.MedicationDetail;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicinePresetEntity;
import com.microtech.aidexx.db.repository.EventDbRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\r\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/viewmodels/MedicineViewModel;", "Lcom/microtech/aidexx/ui/main/event/viewmodels/BaseEventViewModel;", "Lcom/microtech/aidexx/db/entity/event/MedicationEntity;", "Lcom/microtech/aidexx/db/entity/event/MedicationDetail;", "Lcom/microtech/aidexx/db/entity/event/preset/MedicinePresetEntity;", "()V", "genEventEntityWhenSave", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "genNewPreset", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetailHistory", "", "getEventSlotType", "", "()Ljava/lang/Integer;", "queryPresetByName", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MedicineViewModel.kt */
public final class MedicineViewModel extends BaseEventViewModel<MedicationEntity, MedicationDetail, MedicinePresetEntity> {
    public Integer getEventSlotType() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public Object queryPresetByName(String str, Continuation<? super List<? extends MedicinePresetEntity>> continuation) {
        return EventDbRepository.queryMedicinePresetByName$default(EventDbRepository.INSTANCE, str, (String) null, (String) null, (String) null, continuation, 14, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Object genNewPreset(String str, Continuation<? super MedicinePresetEntity> continuation) {
        MedicinePresetEntity medicinePresetEntity = new MedicinePresetEntity();
        medicinePresetEntity.setName(str);
        medicinePresetEntity.setUserInputType(true);
        return medicinePresetEntity;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getDetailHistory(kotlin.coroutines.Continuation<? super java.util.List<com.microtech.aidexx.db.entity.event.MedicationDetail>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.microtech.aidexx.ui.main.event.viewmodels.MedicineViewModel$getDetailHistory$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.microtech.aidexx.ui.main.event.viewmodels.MedicineViewModel$getDetailHistory$1 r0 = (com.microtech.aidexx.ui.main.event.viewmodels.MedicineViewModel$getDetailHistory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.main.event.viewmodels.MedicineViewModel$getDetailHistory$1 r0 = new com.microtech.aidexx.ui.main.event.viewmodels.MedicineViewModel$getDetailHistory$1
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
            io.objectbox.Property<com.microtech.aidexx.db.entity.event.MedicationEntity> r8 = com.microtech.aidexx.db.entity.event.MedicationEntity_.timestamp
            java.lang.String r2 = "timestamp"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            com.microtech.aidexx.db.dao.EventDao r2 = com.microtech.aidexx.db.dao.EventDao.INSTANCE
            com.microtech.aidexx.db.ObjectBox r2 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            com.microtech.aidexx.ui.main.event.viewmodels.MedicineViewModel$getDetailHistory$$inlined$queryHistory$1 r4 = new com.microtech.aidexx.ui.main.event.viewmodels.MedicineViewModel$getDetailHistory$$inlined$queryHistory$1
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
            if (r8 == 0) goto L_0x0082
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r8 = r8.iterator()
        L_0x0069:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x007f
            java.lang.Object r1 = r8.next()
            com.microtech.aidexx.db.entity.event.MedicationEntity r1 = (com.microtech.aidexx.db.entity.event.MedicationEntity) r1
            java.util.List r1 = r1.getExpandList()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            kotlin.collections.CollectionsKt.addAll(r0, r1)
            goto L_0x0069
        L_0x007f:
            java.util.List r0 = (java.util.List) r0
            goto L_0x0086
        L_0x0082:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0086:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.event.viewmodels.MedicineViewModel.getDetailHistory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Object genEventEntityWhenSave(Continuation<? super MedicationEntity> continuation) {
        MedicationEntity medicationEntity = new MedicationEntity();
        medicationEntity.setUploadState(1);
        medicationEntity.setTakenTime(getEventTime());
        List<MedicationDetail> expandList = medicationEntity.getExpandList();
        Iterable<MedicationDetail> toSaveDetailList = getToSaveDetailList();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(toSaveDetailList, 10));
        for (MedicationDetail medicationDetail : toSaveDetailList) {
            medicationDetail.setUnitStr(EventUnitManager.INSTANCE.getMedicationUnit(medicationDetail.getUnit()));
            medicationDetail.setMedicationId(medicationEntity.getMedicationId());
            arrayList.add(medicationDetail);
        }
        expandList.addAll((List) arrayList);
        medicationEntity.setMoment(getEventMomentTypeIndex());
        MedicationDetail medicationDetail2 = (MedicationDetail) CollectionsKt.last(CollectionsKt.sortedWith(getToSaveDetailList(), new MedicineViewModel$genEventEntityWhenSave$$inlined$sortedBy$1()));
        medicationEntity.setMedicineName(medicationDetail2.getName());
        medicationEntity.setMedicineDosage(Boxing.boxFloat((float) medicationDetail2.getQuantity()));
        medicationEntity.setUserId(UserInfoManager.Companion.instance().userId());
        return medicationEntity;
    }
}
