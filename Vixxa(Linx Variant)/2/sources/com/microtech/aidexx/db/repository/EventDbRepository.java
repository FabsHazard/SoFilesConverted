package com.microtech.aidexx.db.repository;

import androidx.exifinterface.media.ExifInterface;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.dao.EventDao;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.db.entity.event.UnitEntity;
import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import com.microtech.aidexx.db.entity.event.preset.BaseSysPreset;
import com.microtech.aidexx.db.entity.event.preset.DietPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.DietSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.DietSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicinePresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicineSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicineSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.MedicineUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import io.objectbox.BoxStore;
import io.objectbox.Property;
import io.objectbox.kotlin.BoxStoreKt;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u0004\u0018\u00010\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHHø\u0001\u0000¢\u0006\u0002\u0010\tJ3\u0010\u0003\u001a\u0004\u0018\u00010\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u0004\u0018\u00010\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u000eHHø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006HHø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u000eHHø\u0001\u0000¢\u0006\u0002\u0010\u000fJ#\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\b\u0002\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ#\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00132\b\b\u0002\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ#\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00132\b\b\u0002\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ#\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00132\b\b\u0002\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ#\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00132\b\b\u0002\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010'J!\u0010(\u001a\u0004\u0018\u00010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060+H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010.\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010/J\u001f\u0010-\u001a\u00020)2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0+H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001f\u00100\u001a\u00020)2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002010+H@ø\u0001\u0000¢\u0006\u0002\u0010,J!\u00102\u001a\u0004\u0018\u00010)2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002030+H@ø\u0001\u0000¢\u0006\u0002\u0010,J!\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u00132\u0006\u00105\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ;\u00106\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010+\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u00107J=\u00108\u001a\b\u0012\u0004\u0012\u0002090+2\u0006\u0010:\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u0010;\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010<J1\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060+2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010BJ1\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060+2\u0006\u0010>\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\b\b\u0002\u0010A\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010CJ/\u0010D\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0013\"\u0006\b\u0000\u0010\u0005\u0018\u00012\f\u0010E\u001a\b\u0012\u0004\u0012\u0002H\u00050FHHø\u0001\u0000¢\u0006\u0002\u0010GJ=\u0010H\u001a\b\u0012\u0004\u0012\u00020I0+2\u0006\u0010:\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u0010;\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010<J=\u0010J\u001a\b\u0012\u0004\u0012\u00020K0+2\u0006\u0010:\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u0010;\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010<J#\u0010L\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010M\u001a\u00020?H@ø\u0001\u0000¢\u0006\u0002\u0010NJ=\u0010O\u001a\b\u0012\u0004\u0012\u00020P0+2\u0006\u0010:\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u0010;\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010<J\u0013\u0010Q\u001a\u0004\u0018\u00010)H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ3\u0010R\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010S\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ3\u0010T\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010U\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010VJ)\u0010W\u001a\u00020)\"\b\b\u0000\u0010\u0005*\u0002012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010XJ1\u0010Y\u001a\u00020)\"\b\b\u0000\u0010\u0005*\u0002012\u0006\u0010Z\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001b\u0010[\u001a\u0004\u0018\u00010\u00042\u0006\u0010Z\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010\\\u001a\u0004\u0018\u00010]\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\b0+2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010_\u0002\u0004\n\u0002\b\u0019¨\u0006`"}, d2 = {"Lcom/microtech/aidexx/db/repository/EventDbRepository;", "", "()V", "findMaxEventId", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findMaxPresetId", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findMinEventId", "findMinPresetId", "getDietNeedUploadEvent", "", "Lcom/microtech/aidexx/db/entity/event/DietEntity;", "getDietNeedUploadPreset", "Lcom/microtech/aidexx/db/entity/event/preset/DietUsrPresetEntity;", "getExerciseNeedUploadEvent", "Lcom/microtech/aidexx/db/entity/event/ExerciseEntity;", "getExerciseNeedUploadPreset", "Lcom/microtech/aidexx/db/entity/event/preset/SportUsrPresetEntity;", "getInsulinNeedUploadEvent", "Lcom/microtech/aidexx/db/entity/event/InsulinEntity;", "getInsulinNeedUploadPreset", "Lcom/microtech/aidexx/db/entity/event/preset/InsulinUsrPresetEntity;", "getMedicineNeedUploadEvent", "Lcom/microtech/aidexx/db/entity/event/MedicationEntity;", "getMedicineNeedUploadPreset", "Lcom/microtech/aidexx/db/entity/event/preset/MedicineUsrPresetEntity;", "getOthersNeedUploadEvent", "Lcom/microtech/aidexx/db/entity/event/OthersEntity;", "insertEvent", "event", "(Lcom/microtech/aidexx/db/entity/BaseEventEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertEvents", "", "events", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPresetData", "data", "(Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSysPresetData", "Lcom/microtech/aidexx/db/entity/event/preset/BaseSysPreset;", "insertUnit", "Lcom/microtech/aidexx/db/entity/event/UnitEntity;", "loadUnit", "language", "queryDeletedData", "(Ljava/lang/Class;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryDietPresetByName", "Lcom/microtech/aidexx/db/entity/event/preset/DietPresetEntity;", "name", "sysPresetVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryEventByPage", "startDate", "Ljava/util/Date;", "endDate", "uid", "(Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryHistory", "timestampProperty", "Lio/objectbox/Property;", "(Lio/objectbox/Property;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryInsulinPresetByName", "Lcom/microtech/aidexx/db/entity/event/preset/InsulinPresetEntity;", "queryMedicinePresetByName", "Lcom/microtech/aidexx/db/entity/event/preset/MedicinePresetEntity;", "queryNextByTargetDate", "targetDate", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySportPresetByName", "Lcom/microtech/aidexx/db/entity/event/preset/SportPresetEntity;", "removeAllUnit", "removeEventByFrontId", "frontId", "removeEventById", "id", "(JLjava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSysPresetData", "(Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSysPresetOfOtherVersion", "exceptVersion", "removeUnitOfOtherVersion", "updateDeleteStatusByIds", "", "ids", "(Ljava/util/List;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventDbRepository.kt */
public final class EventDbRepository {
    public static final EventDbRepository INSTANCE = new EventDbRepository();

    private EventDbRepository() {
    }

    public static /* synthetic */ Object queryEventByPage$default(EventDbRepository eventDbRepository, Date date, Date date2, String str, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventDbRepository.queryEventByPage(date, date2, str, (Continuation<? super List<? extends BaseEventEntity>>) continuation);
    }

    public final Object queryEventByPage(Date date, Date date2, String str, Continuation<? super List<? extends BaseEventEntity>> continuation) {
        return EventDao.INSTANCE.query(date, date2, str, continuation);
    }

    public static /* synthetic */ Object queryEventByPage$default(EventDbRepository eventDbRepository, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = UserInfoManager.Companion.instance().userId();
        }
        return eventDbRepository.queryEventByPage(str, str2, str3, (Continuation<? super List<? extends BaseEventEntity>>) continuation);
    }

    public final Object queryEventByPage(String str, String str2, String str3, Continuation<? super List<? extends BaseEventEntity>> continuation) {
        return EventDao.INSTANCE.query(str, str2, str3, continuation);
    }

    public final Object queryNextByTargetDate(String str, Date date, Continuation<? super BaseEventEntity> continuation) {
        return EventDao.INSTANCE.queryNextByTargetDate(str, date, continuation);
    }

    public final Object insertPresetData(List<? extends BasePresetEntity> list, Continuation<? super Unit> continuation) {
        if (list.isEmpty()) {
            return Unit.INSTANCE;
        }
        Object insertPresetData = EventDao.INSTANCE.insertPresetData(list, continuation);
        return insertPresetData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insertPresetData : Unit.INSTANCE;
    }

    public final Object insertSysPresetData(List<? extends BaseSysPreset> list, Continuation<? super Unit> continuation) {
        if (list.isEmpty()) {
            return Unit.INSTANCE;
        }
        Object insertSysPresetData = EventDao.INSTANCE.insertSysPresetData(list, continuation);
        return insertSysPresetData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insertSysPresetData : Unit.INSTANCE;
    }

    public final <T extends BaseSysPreset> Object removeSysPresetOfOtherVersion(String str, Class<T> cls, Continuation<? super Unit> continuation) {
        Property property;
        if (Intrinsics.areEqual((Object) cls, (Object) DietSysPresetEntity.class)) {
            property = DietSysPresetEntity_.version;
        } else if (Intrinsics.areEqual((Object) cls, (Object) SportSysPresetEntity.class)) {
            property = SportSysPresetEntity_.version;
        } else if (Intrinsics.areEqual((Object) cls, (Object) MedicineSysPresetEntity.class)) {
            property = MedicineSysPresetEntity_.version;
        } else {
            property = Intrinsics.areEqual((Object) cls, (Object) InsulinSysPresetEntity.class) ? InsulinSysPresetEntity_.version : null;
        }
        if (property == null) {
            return Unit.INSTANCE;
        }
        Object removeSysPresetOfOtherVersion = EventDao.INSTANCE.removeSysPresetOfOtherVersion(str, cls, property, continuation);
        return removeSysPresetOfOtherVersion == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? removeSysPresetOfOtherVersion : Unit.INSTANCE;
    }

    public final <T extends BaseSysPreset> Object removeSysPresetData(Class<T> cls, Continuation<? super Unit> continuation) {
        return EventDao.INSTANCE.removeSysPresetData(cls, continuation);
    }

    public final Object insertPresetData(BasePresetEntity basePresetEntity, Continuation<? super Long> continuation) {
        return EventDao.INSTANCE.insertSysPresetData(basePresetEntity, continuation);
    }

    public final /* synthetic */ <T extends BasePresetEntity> Object findMaxPresetId(Continuation<? super Long> continuation) {
        EventDao eventDao = EventDao.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BasePresetEntity> cls = BasePresetEntity.class;
        Class cls2 = cls;
        Property<? extends BasePresetEntity> presetIdPropertyByClazz = eventDao.getPresetIdPropertyByClazz(cls);
        if (presetIdPropertyByClazz != null) {
            ObjectBox objectBox = ObjectBox.INSTANCE;
            Intrinsics.needClassReification();
            BoxStore store = objectBox.getStore();
            InlineMarker.mark(0);
            Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDbRepository$findMaxPresetId$$inlined$findMaxPresetId$1(presetIdPropertyByClazz), continuation);
            InlineMarker.mark(1);
            return awaitCallInTx;
        }
        EventDao eventDao2 = eventDao;
        return null;
    }

    public final /* synthetic */ <T extends BasePresetEntity> Object findMinPresetId(Continuation<? super Long> continuation) {
        EventDao eventDao = EventDao.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BasePresetEntity> cls = BasePresetEntity.class;
        Class cls2 = cls;
        Property<? extends BasePresetEntity> presetIdPropertyByClazz = eventDao.getPresetIdPropertyByClazz(cls);
        if (presetIdPropertyByClazz != null) {
            ObjectBox objectBox = ObjectBox.INSTANCE;
            Intrinsics.needClassReification();
            BoxStore store = objectBox.getStore();
            InlineMarker.mark(0);
            Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDbRepository$findMinPresetId$$inlined$findMinPresetId$1(presetIdPropertyByClazz), continuation);
            InlineMarker.mark(1);
            return awaitCallInTx;
        }
        EventDao eventDao2 = eventDao;
        return null;
    }

    public final /* synthetic */ <T extends BaseEventEntity> Object findMaxEventId(String str, Continuation<? super Long> continuation) {
        EventDao eventDao = EventDao.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BaseEventEntity> cls = BaseEventEntity.class;
        Class cls2 = cls;
        Property<? extends BaseEventEntity> eventIdPropertyByClazz = eventDao.getEventIdPropertyByClazz(cls);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BaseEventEntity> cls3 = BaseEventEntity.class;
        Class cls4 = cls3;
        Property<? extends BaseEventEntity> userIdPropertyByClazz = eventDao.getUserIdPropertyByClazz(cls3);
        if (eventIdPropertyByClazz == null || userIdPropertyByClazz == null) {
            return null;
        }
        ObjectBox objectBox = ObjectBox.INSTANCE;
        Intrinsics.needClassReification();
        BoxStore store = objectBox.getStore();
        InlineMarker.mark(0);
        Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDbRepository$findMaxEventId$$inlined$findMaxEventId$1(eventIdPropertyByClazz, userIdPropertyByClazz, str), continuation);
        InlineMarker.mark(1);
        return awaitCallInTx;
    }

    public final <T extends BaseEventEntity> Object findMaxEventId(String str, Class<T> cls, Continuation<? super Long> continuation) {
        return EventDao.INSTANCE.findMaxEventId(str, cls, continuation);
    }

    public final /* synthetic */ <T extends BaseEventEntity> Object findMinEventId(Continuation<? super Long> continuation) {
        EventDao eventDao = EventDao.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BaseEventEntity> cls = BaseEventEntity.class;
        Class cls2 = cls;
        Property<? extends BaseEventEntity> eventIdPropertyByClazz = eventDao.getEventIdPropertyByClazz(cls);
        if (eventIdPropertyByClazz != null) {
            ObjectBox objectBox = ObjectBox.INSTANCE;
            Intrinsics.needClassReification();
            BoxStore store = objectBox.getStore();
            InlineMarker.mark(0);
            Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDbRepository$findMinEventId$$inlined$findMinEventId$1(eventIdPropertyByClazz), continuation);
            InlineMarker.mark(1);
            return awaitCallInTx;
        }
        EventDao eventDao2 = eventDao;
        return null;
    }

    public static /* synthetic */ Object queryDietPresetByName$default(EventDbRepository eventDbRepository, String str, String str2, String str3, String str4, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = UserInfoManager.Companion.instance().userId();
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = LanguageResourceManager.INSTANCE.getCurLanguageTag();
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = MmkvManager.INSTANCE.getEventSysPresetVersion(DietSysPresetEntity.class);
        }
        return eventDbRepository.queryDietPresetByName(str, str5, str6, str4, continuation);
    }

    public final Object queryDietPresetByName(String str, String str2, String str3, String str4, Continuation<? super List<? extends DietPresetEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EventDbRepository$queryDietPresetByName$2(str, str3, str4, str2, (Continuation<? super EventDbRepository$queryDietPresetByName$2>) null), continuation);
    }

    public static /* synthetic */ Object queryMedicinePresetByName$default(EventDbRepository eventDbRepository, String str, String str2, String str3, String str4, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = UserInfoManager.Companion.instance().userId();
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = LanguageResourceManager.INSTANCE.getCurLanguageTag();
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = MmkvManager.INSTANCE.getEventSysPresetVersion(MedicineSysPresetEntity.class);
        }
        return eventDbRepository.queryMedicinePresetByName(str, str5, str6, str4, continuation);
    }

    public final Object queryMedicinePresetByName(String str, String str2, String str3, String str4, Continuation<? super List<? extends MedicinePresetEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EventDbRepository$queryMedicinePresetByName$2(str, str3, str4, str2, (Continuation<? super EventDbRepository$queryMedicinePresetByName$2>) null), continuation);
    }

    public static /* synthetic */ Object queryInsulinPresetByName$default(EventDbRepository eventDbRepository, String str, String str2, String str3, String str4, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = UserInfoManager.Companion.instance().userId();
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = LanguageResourceManager.INSTANCE.getCurLanguageTag();
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = MmkvManager.INSTANCE.getEventSysPresetVersion(InsulinSysPresetEntity.class);
        }
        return eventDbRepository.queryInsulinPresetByName(str, str5, str6, str4, continuation);
    }

    public final Object queryInsulinPresetByName(String str, String str2, String str3, String str4, Continuation<? super List<? extends InsulinPresetEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EventDbRepository$queryInsulinPresetByName$2(str, str3, str4, str2, (Continuation<? super EventDbRepository$queryInsulinPresetByName$2>) null), continuation);
    }

    public static /* synthetic */ Object querySportPresetByName$default(EventDbRepository eventDbRepository, String str, String str2, String str3, String str4, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = UserInfoManager.Companion.instance().userId();
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = LanguageResourceManager.INSTANCE.getCurLanguageTag();
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = MmkvManager.INSTANCE.getEventSysPresetVersion(SportSysPresetEntity.class);
        }
        return eventDbRepository.querySportPresetByName(str, str5, str6, str4, continuation);
    }

    public final Object querySportPresetByName(String str, String str2, String str3, String str4, Continuation<? super List<? extends SportPresetEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EventDbRepository$querySportPresetByName$2(str, str3, str4, str2, (Continuation<? super EventDbRepository$querySportPresetByName$2>) null), continuation);
    }

    public final /* synthetic */ <T> Object queryHistory(Property<T> property, Continuation<? super List<T>> continuation) {
        EventDao eventDao = EventDao.INSTANCE;
        ObjectBox objectBox = ObjectBox.INSTANCE;
        Intrinsics.needClassReification();
        BoxStore store = objectBox.getStore();
        InlineMarker.mark(0);
        Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDbRepository$queryHistory$$inlined$queryLatestHistory$default$1(15, property), continuation);
        InlineMarker.mark(1);
        return awaitCallInTx;
    }

    public final Object insertEvent(BaseEventEntity baseEventEntity, Continuation<? super Long> continuation) {
        return EventDao.INSTANCE.insertEvent(baseEventEntity, continuation);
    }

    public final Object insertEvents(List<? extends BaseEventEntity> list, Continuation<? super Unit> continuation) {
        return EventDao.INSTANCE.insertEvents(list, continuation);
    }

    public final Object loadUnit(String str, Continuation<? super List<UnitEntity>> continuation) {
        return EventDao.INSTANCE.loadUnit(str, continuation);
    }

    public final Object insertUnit(List<UnitEntity> list, Continuation<? super Unit> continuation) {
        return EventDao.INSTANCE.insertUnit(list, continuation);
    }

    public final Object removeUnitOfOtherVersion(String str, Continuation<? super Long> continuation) {
        return EventDao.INSTANCE.removeUnitOfOtherVersion(str, continuation);
    }

    public final Object removeAllUnit(Continuation<? super Unit> continuation) {
        return EventDao.INSTANCE.removeAllUnit(continuation);
    }

    public static /* synthetic */ Object getDietNeedUploadEvent$default(EventDbRepository eventDbRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventDbRepository.getDietNeedUploadEvent(str, continuation);
    }

    public final Object getDietNeedUploadEvent(String str, Continuation<? super List<DietEntity>> continuation) {
        return EventDao.INSTANCE.getDietNeedUploadEvent(str, continuation);
    }

    public static /* synthetic */ Object getExerciseNeedUploadEvent$default(EventDbRepository eventDbRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventDbRepository.getExerciseNeedUploadEvent(str, continuation);
    }

    public final Object getExerciseNeedUploadEvent(String str, Continuation<? super List<ExerciseEntity>> continuation) {
        return EventDao.INSTANCE.getExerciseNeedUploadEvent(str, continuation);
    }

    public static /* synthetic */ Object getMedicineNeedUploadEvent$default(EventDbRepository eventDbRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventDbRepository.getMedicineNeedUploadEvent(str, continuation);
    }

    public final Object getMedicineNeedUploadEvent(String str, Continuation<? super List<MedicationEntity>> continuation) {
        return EventDao.INSTANCE.getMedicineNeedUploadEvent(str, continuation);
    }

    public static /* synthetic */ Object getInsulinNeedUploadEvent$default(EventDbRepository eventDbRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventDbRepository.getInsulinNeedUploadEvent(str, continuation);
    }

    public final Object getInsulinNeedUploadEvent(String str, Continuation<? super List<InsulinEntity>> continuation) {
        return EventDao.INSTANCE.getInsulinNeedUploadEvent(str, continuation);
    }

    public static /* synthetic */ Object getOthersNeedUploadEvent$default(EventDbRepository eventDbRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventDbRepository.getOthersNeedUploadEvent(str, continuation);
    }

    public final Object getOthersNeedUploadEvent(String str, Continuation<? super List<OthersEntity>> continuation) {
        return EventDao.INSTANCE.getOthersNeedUploadEvent(str, continuation);
    }

    public final Object getDietNeedUploadPreset(Continuation<? super List<DietUsrPresetEntity>> continuation) {
        return EventDao.INSTANCE.getDietNeedUploadPreset(continuation);
    }

    public final Object getExerciseNeedUploadPreset(Continuation<? super List<SportUsrPresetEntity>> continuation) {
        return EventDao.INSTANCE.getExerciseNeedUploadPreset(continuation);
    }

    public final Object getMedicineNeedUploadPreset(Continuation<? super List<MedicineUsrPresetEntity>> continuation) {
        return EventDao.INSTANCE.getMedicineNeedUploadPreset(continuation);
    }

    public final Object getInsulinNeedUploadPreset(Continuation<? super List<InsulinUsrPresetEntity>> continuation) {
        return EventDao.INSTANCE.getInsulinNeedUploadPreset(continuation);
    }

    public final <T extends BaseEventEntity> Object removeEventById(long j, Class<T> cls, Continuation<? super T> continuation) {
        return EventDao.INSTANCE.removeEventById(j, cls, continuation);
    }

    public final <T extends BaseEventEntity> Object removeEventByFrontId(String str, Class<T> cls, Continuation<? super T> continuation) {
        return EventDao.INSTANCE.removeEventByFrontId(str, cls, continuation);
    }

    public static /* synthetic */ Object queryDeletedData$default(EventDbRepository eventDbRepository, Class cls, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventDbRepository.queryDeletedData(cls, str, continuation);
    }

    public final <T extends BaseEventEntity> Object queryDeletedData(Class<T> cls, String str, Continuation<? super List<String>> continuation) {
        return EventDao.INSTANCE.queryDeletedData(str, cls, continuation);
    }

    public final <T extends BaseEventEntity> Object updateDeleteStatusByIds(List<String> list, Class<T> cls, Continuation<? super Boolean> continuation) {
        return EventDao.INSTANCE.updateDeleteStatusByIds(list, cls, continuation);
    }
}
