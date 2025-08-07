package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.ReqGetEventByPage;
import com.microtech.aidexx.common.net.entity.ReqPageInfo;
import com.microtech.aidexx.common.net.entity.ReqSysPresetExercisePageInfo;
import com.microtech.aidexx.common.net.entity.ReqSysPresetFoodPageInfo;
import com.microtech.aidexx.common.net.entity.ReqSysPresetInsulinPageInfo;
import com.microtech.aidexx.common.net.entity.ReqSysPresetMedicationPageInfo;
import com.microtech.aidexx.common.net.entity.RequestEntityKt;
import com.microtech.aidexx.common.net.entity.ResEventPresetVersion;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.DataSyncController;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import com.microtech.aidexx.db.entity.event.preset.DietSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicineSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicineUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity;
import com.microtech.aidexx.ui.main.event.viewmodels.EventType;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ/\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\n0\u00110\u00102\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015JW\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\u00110\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJW\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\n0\u00110\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJe\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\n0\u00110\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010$JY\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\n0\u00110\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJk\u0010'\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020(0\n0\u00110\u00102\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u000b2\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0\rH@ø\u0001\u0000¢\u0006\u0002\u0010*J]\u0010+\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00110\u00102\u0006\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00142\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\rH@ø\u0001\u0000¢\u0006\u0002\u0010-JY\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\n0\u00110\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJY\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\n0\u00110\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJY\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\n0\u00110\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJY\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\n0\u00110\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ9\u00106\u001a\u00020\u0006\"\n\b\u0000\u00107\u0018\u0001*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u0014HHø\u0001\u0000¢\u0006\u0002\u00109J\u0001\u0010:\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b2\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0<2:\u0010=\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020C\u0018\u00010>H@ø\u0001\u0000¢\u0006\u0002\u0010DJ3\u0010E\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\u00110\u00102\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u0010GJ=\u0010H\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00140J0I\"\n\b\u0000\u0010K\u0018\u0001*\u00020(2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010L\u001a\u00020\u0006H\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006M"}, d2 = {"Lcom/microtech/aidexx/common/net/repository/EventRepository;", "", "()V", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "deleteEventByIds", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "ids", "", "", "clazz", "Ljava/lang/Class;", "(Ljava/util/List;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPresetVersion", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "Lcom/microtech/aidexx/common/net/entity/ResEventPresetVersion;", "type", "", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBgRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "pageNum", "pageSize", "userId", "startAutoIncrementColumn", "", "endAutoIncrementColumn", "(IILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCalRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "getCgmRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "orderStrategy", "(IILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDietRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/event/DietEntity;", "getEventPresetByPageInfo", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "presetClazz", "(IILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventRecordsByPageInfo", "eventClazz", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExerciseRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/event/ExerciseEntity;", "getInsulinRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/event/InsulinEntity;", "getMedicineRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/event/MedicationEntity;", "getOthersRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/event/OthersEntity;", "getRecentData", "EVENT", "count", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pollPresetData", "pClazz", "Lkotlin/reflect/KClass;", "cb", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isDone", "pageIndex", "", "(IILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOrUpdateRecords", "data", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncEventPreset", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "P", "isPullDesc", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventRepository.kt */
public final class EventRepository {
    public static final EventRepository INSTANCE = new EventRepository();
    private static final CoroutineDispatcher dispatcher = Dispatchers.getIO();

    private EventRepository() {
    }

    public final Object saveOrUpdateRecords(List<? extends Object> list, Continuation<? super ApiResult<? extends BaseResponse<? extends List<? extends Object>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$saveOrUpdateRecords$2(list, (Continuation<? super EventRepository$saveOrUpdateRecords$2>) null), continuation);
    }

    public static /* synthetic */ Object getEventRecordsByPageInfo$default(EventRepository eventRepository, String str, int i, Long l, Long l2, Class cls, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 500;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            l = null;
        }
        return eventRepository.getEventRecordsByPageInfo(str, i3, l, l2, cls, continuation);
    }

    public final Object getEventRecordsByPageInfo(String str, int i, Long l, Long l2, Class<? extends BaseEventEntity> cls, Continuation<? super ApiResult<? extends BaseResponse<? extends List<? extends BaseEventEntity>>>> continuation) {
        Class<? extends BaseEventEntity> cls2 = cls;
        if (Intrinsics.areEqual((Object) cls2, (Object) RealCgmHistoryEntity.class)) {
            Object cgmRecordsByPageInfo$default = getCgmRecordsByPageInfo$default(this, 0, i, str, l, l2, (String) null, continuation, 33, (Object) null);
            return cgmRecordsByPageInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? cgmRecordsByPageInfo$default : (ApiResult) cgmRecordsByPageInfo$default;
        } else if (Intrinsics.areEqual((Object) cls2, (Object) CalibrateEntity.class)) {
            Object calRecordsByPageInfo$default = getCalRecordsByPageInfo$default(this, 0, i, str, l, l2, continuation, 1, (Object) null);
            return calRecordsByPageInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? calRecordsByPageInfo$default : (ApiResult) calRecordsByPageInfo$default;
        } else if (Intrinsics.areEqual((Object) cls2, (Object) BloodGlucoseEntity.class)) {
            Object bgRecordsByPageInfo$default = getBgRecordsByPageInfo$default(this, 0, i, str, l, l2, continuation, 1, (Object) null);
            return bgRecordsByPageInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bgRecordsByPageInfo$default : (ApiResult) bgRecordsByPageInfo$default;
        } else if (Intrinsics.areEqual((Object) cls2, (Object) DietEntity.class)) {
            Object dietRecordsByPageInfo$default = getDietRecordsByPageInfo$default(this, 0, i, str, l, l2, continuation, 1, (Object) null);
            return dietRecordsByPageInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dietRecordsByPageInfo$default : (ApiResult) dietRecordsByPageInfo$default;
        } else if (Intrinsics.areEqual((Object) cls2, (Object) ExerciseEntity.class)) {
            Object exerciseRecordsByPageInfo$default = getExerciseRecordsByPageInfo$default(this, 0, i, str, l, l2, continuation, 1, (Object) null);
            return exerciseRecordsByPageInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? exerciseRecordsByPageInfo$default : (ApiResult) exerciseRecordsByPageInfo$default;
        } else if (Intrinsics.areEqual((Object) cls2, (Object) MedicationEntity.class)) {
            Object medicineRecordsByPageInfo$default = getMedicineRecordsByPageInfo$default(this, 0, i, str, l, l2, continuation, 1, (Object) null);
            return medicineRecordsByPageInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? medicineRecordsByPageInfo$default : (ApiResult) medicineRecordsByPageInfo$default;
        } else if (Intrinsics.areEqual((Object) cls2, (Object) InsulinEntity.class)) {
            Object insulinRecordsByPageInfo$default = getInsulinRecordsByPageInfo$default(this, 0, i, str, l, l2, continuation, 1, (Object) null);
            return insulinRecordsByPageInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insulinRecordsByPageInfo$default : (ApiResult) insulinRecordsByPageInfo$default;
        } else if (Intrinsics.areEqual((Object) cls2, (Object) OthersEntity.class)) {
            Object othersRecordsByPageInfo$default = getOthersRecordsByPageInfo$default(this, 0, i, str, l, l2, continuation, 1, (Object) null);
            return othersRecordsByPageInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? othersRecordsByPageInfo$default : (ApiResult) othersRecordsByPageInfo$default;
        } else {
            LogUtil.Companion.xLogE$default(LogUtil.Companion, "不支持当前类型下载数据 clazz=" + cls.getSimpleName(), (String) null, 2, (Object) null);
            return new ApiResult.Failure("3", "not support");
        }
    }

    public static /* synthetic */ Object getRecentData$default(EventRepository eventRepository, String str, int i, int i2, Continuation continuation, int i3, Object obj) {
        Long l;
        String str2 = str;
        int i4 = (i3 & 2) != 0 ? 5000 : i;
        int i5 = (i3 & 4) != 0 ? 500 : i2;
        Intrinsics.reifiedOperationMarker(4, "EVENT");
        Class<BaseEventEntity> cls = BaseEventEntity.class;
        Class cls2 = cls;
        String loginStateKey = DataSyncController.Companion.getLoginStateKey(str2, cls);
        String loginMaxIdKey = DataSyncController.Companion.getLoginMaxIdKey(str2, cls);
        String taskItemListKey = DataSyncController.Companion.getTaskItemListKey(str2, cls);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Intrinsics.needClassReification();
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new EventRepository$getRecentData$result$1(loginStateKey, objectRef, str, loginMaxIdKey, i4, i5, objectRef2, cls, (Continuation<? super EventRepository$getRecentData$result$1>) null), continuation);
        InlineMarker.mark(1);
        boolean booleanValue = ((Boolean) withContext).booleanValue();
        if (booleanValue) {
            MmkvManager.INSTANCE.setLastLoginEventDownloadState(loginStateKey, true);
            if (objectRef2.element != null && ((l = (Long) objectRef2.element) == null || l.longValue() != 0)) {
                DataSyncController.SyncTaskItemList eventSyncTask = MmkvManager.INSTANCE.getEventSyncTask(taskItemListKey);
                if (eventSyncTask == null) {
                    eventSyncTask = new DataSyncController.SyncTaskItemList(new ArrayList());
                }
                eventSyncTask.getList().add(0, new DataSyncController.SyncTaskItem((Long) objectRef.element, (Long) objectRef2.element));
                MmkvManager.INSTANCE.setEventSyncTask(taskItemListKey, eventSyncTask);
                LogUtil.Companion.d("SyncTaskItemList " + taskItemListKey + '=' + eventSyncTask, "getRecentData");
            }
        }
        return Boolean.valueOf(booleanValue);
    }

    public final /* synthetic */ <EVENT extends BaseEventEntity> Object getRecentData(String str, int i, int i2, Continuation<? super Boolean> continuation) {
        Long l;
        String str2 = str;
        Intrinsics.reifiedOperationMarker(4, "EVENT");
        Class<BaseEventEntity> cls = BaseEventEntity.class;
        Class cls2 = cls;
        String loginStateKey = DataSyncController.Companion.getLoginStateKey(str2, cls);
        String loginMaxIdKey = DataSyncController.Companion.getLoginMaxIdKey(str2, cls);
        String taskItemListKey = DataSyncController.Companion.getTaskItemListKey(str2, cls);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Intrinsics.needClassReification();
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new EventRepository$getRecentData$result$1(loginStateKey, objectRef, str2, loginMaxIdKey, i, i2, objectRef2, cls, (Continuation<? super EventRepository$getRecentData$result$1>) null), continuation);
        InlineMarker.mark(1);
        boolean booleanValue = ((Boolean) withContext).booleanValue();
        if (booleanValue) {
            MmkvManager.INSTANCE.setLastLoginEventDownloadState(loginStateKey, true);
            if (objectRef2.element != null && ((l = (Long) objectRef2.element) == null || l.longValue() != 0)) {
                DataSyncController.SyncTaskItemList eventSyncTask = MmkvManager.INSTANCE.getEventSyncTask(taskItemListKey);
                if (eventSyncTask == null) {
                    eventSyncTask = new DataSyncController.SyncTaskItemList(new ArrayList());
                }
                eventSyncTask.getList().add(0, new DataSyncController.SyncTaskItem((Long) objectRef.element, (Long) objectRef2.element));
                MmkvManager.INSTANCE.setEventSyncTask(taskItemListKey, eventSyncTask);
                LogUtil.Companion.d("SyncTaskItemList " + taskItemListKey + '=' + eventSyncTask, "getRecentData");
            }
        }
        return Boolean.valueOf(booleanValue);
    }

    static /* synthetic */ Object getCgmRecordsByPageInfo$default(EventRepository eventRepository, int i, int i2, String str, Long l, Long l2, String str2, Continuation continuation, int i3, Object obj) {
        return eventRepository.getCgmRecordsByPageInfo((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 500 : i2, (i3 & 4) != 0 ? UserInfoManager.Companion.instance().userId() : str, (i3 & 8) != 0 ? null : l, (i3 & 16) != 0 ? null : l2, (i3 & 32) != 0 ? null : str2, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getCgmRecordsByPageInfo(int i, int i2, String str, Long l, Long l2, String str2, Continuation<? super ApiResult<BaseResponse<List<RealCgmHistoryEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$getCgmRecordsByPageInfo$2(l, l2, str2, i, i2, str, (Continuation<? super EventRepository$getCgmRecordsByPageInfo$2>) null), continuation);
    }

    static /* synthetic */ Object getBgRecordsByPageInfo$default(EventRepository eventRepository, int i, int i2, String str, Long l, Long l2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        int i4 = i;
        if ((i3 & 2) != 0) {
            i2 = 500;
        }
        int i5 = i2;
        if ((i3 & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            l = null;
        }
        return eventRepository.getBgRecordsByPageInfo(i4, i5, str2, l, l2, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getBgRecordsByPageInfo(int i, int i2, String str, Long l, Long l2, Continuation<? super ApiResult<BaseResponse<List<BloodGlucoseEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$getBgRecordsByPageInfo$2(l, l2, i, i2, str, (Continuation<? super EventRepository$getBgRecordsByPageInfo$2>) null), continuation);
    }

    static /* synthetic */ Object getCalRecordsByPageInfo$default(EventRepository eventRepository, int i, int i2, String str, Long l, Long l2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        int i4 = i;
        if ((i3 & 2) != 0) {
            i2 = 500;
        }
        int i5 = i2;
        if ((i3 & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            l = null;
        }
        return eventRepository.getCalRecordsByPageInfo(i4, i5, str2, l, l2, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getCalRecordsByPageInfo(int i, int i2, String str, Long l, Long l2, Continuation<? super ApiResult<BaseResponse<List<CalibrateEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$getCalRecordsByPageInfo$2(l, l2, i, i2, str, (Continuation<? super EventRepository$getCalRecordsByPageInfo$2>) null), continuation);
    }

    static /* synthetic */ Object getDietRecordsByPageInfo$default(EventRepository eventRepository, int i, int i2, String str, Long l, Long l2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        int i4 = i;
        if ((i3 & 2) != 0) {
            i2 = 500;
        }
        int i5 = i2;
        if ((i3 & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventRepository.getDietRecordsByPageInfo(i4, i5, str, (i3 & 8) != 0 ? null : l, (i3 & 16) != 0 ? null : l2, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getDietRecordsByPageInfo(int i, int i2, String str, Long l, Long l2, Continuation<? super ApiResult<BaseResponse<List<DietEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$getDietRecordsByPageInfo$2(l, l2, i, i2, str, (Continuation<? super EventRepository$getDietRecordsByPageInfo$2>) null), continuation);
    }

    static /* synthetic */ Object getExerciseRecordsByPageInfo$default(EventRepository eventRepository, int i, int i2, String str, Long l, Long l2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        int i4 = i;
        if ((i3 & 2) != 0) {
            i2 = 500;
        }
        int i5 = i2;
        if ((i3 & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventRepository.getExerciseRecordsByPageInfo(i4, i5, str, (i3 & 8) != 0 ? null : l, (i3 & 16) != 0 ? null : l2, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getExerciseRecordsByPageInfo(int i, int i2, String str, Long l, Long l2, Continuation<? super ApiResult<BaseResponse<List<ExerciseEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$getExerciseRecordsByPageInfo$2(l, l2, i, i2, str, (Continuation<? super EventRepository$getExerciseRecordsByPageInfo$2>) null), continuation);
    }

    static /* synthetic */ Object getInsulinRecordsByPageInfo$default(EventRepository eventRepository, int i, int i2, String str, Long l, Long l2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        int i4 = i;
        if ((i3 & 2) != 0) {
            i2 = 500;
        }
        int i5 = i2;
        if ((i3 & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventRepository.getInsulinRecordsByPageInfo(i4, i5, str, (i3 & 8) != 0 ? null : l, (i3 & 16) != 0 ? null : l2, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getInsulinRecordsByPageInfo(int i, int i2, String str, Long l, Long l2, Continuation<? super ApiResult<BaseResponse<List<InsulinEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$getInsulinRecordsByPageInfo$2(l, l2, i, i2, str, (Continuation<? super EventRepository$getInsulinRecordsByPageInfo$2>) null), continuation);
    }

    static /* synthetic */ Object getMedicineRecordsByPageInfo$default(EventRepository eventRepository, int i, int i2, String str, Long l, Long l2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        int i4 = i;
        if ((i3 & 2) != 0) {
            i2 = 500;
        }
        int i5 = i2;
        if ((i3 & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventRepository.getMedicineRecordsByPageInfo(i4, i5, str, (i3 & 8) != 0 ? null : l, (i3 & 16) != 0 ? null : l2, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getMedicineRecordsByPageInfo(int i, int i2, String str, Long l, Long l2, Continuation<? super ApiResult<BaseResponse<List<MedicationEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$getMedicineRecordsByPageInfo$2(l, l2, i, i2, str, (Continuation<? super EventRepository$getMedicineRecordsByPageInfo$2>) null), continuation);
    }

    static /* synthetic */ Object getOthersRecordsByPageInfo$default(EventRepository eventRepository, int i, int i2, String str, Long l, Long l2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        int i4 = i;
        if ((i3 & 2) != 0) {
            i2 = 500;
        }
        int i5 = i2;
        if ((i3 & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return eventRepository.getOthersRecordsByPageInfo(i4, i5, str, (i3 & 8) != 0 ? null : l, (i3 & 16) != 0 ? null : l2, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getOthersRecordsByPageInfo(int i, int i2, String str, Long l, Long l2, Continuation<? super ApiResult<BaseResponse<List<OthersEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$getOthersRecordsByPageInfo$2(l, l2, i, i2, str, (Continuation<? super EventRepository$getOthersRecordsByPageInfo$2>) null), continuation);
    }

    public final Object fetchPresetVersion(@EventType Integer num, Continuation<? super ApiResult<BaseResponse<List<ResEventPresetVersion>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$fetchPresetVersion$2(num, (Continuation<? super EventRepository$fetchPresetVersion$2>) null), continuation);
    }

    public static /* synthetic */ Flow syncEventPreset$default(EventRepository eventRepository, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        if ((i & 2) != 0) {
            z = true;
        }
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.needClassReification();
        return FlowKt.flowOn(FlowKt.callbackFlow(new EventRepository$syncEventPreset$1(z, str, (Continuation<? super EventRepository$syncEventPreset$1>) null)), Dispatchers.getIO());
    }

    public final /* synthetic */ <P extends BasePresetEntity> Flow<Pair<Boolean, Integer>> syncEventPreset(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.needClassReification();
        return FlowKt.flowOn(FlowKt.callbackFlow(new EventRepository$syncEventPreset$1(z, str, (Continuation<? super EventRepository$syncEventPreset$1>) null)), Dispatchers.getIO());
    }

    public static /* synthetic */ Object pollPresetData$default(EventRepository eventRepository, int i, int i2, String str, Long l, Long l2, String str2, KClass kClass, Function2 function2, Continuation continuation, int i3, Object obj) {
        return eventRepository.pollPresetData((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 500 : i2, (i3 & 4) != 0 ? UserInfoManager.Companion.instance().userId() : str, (i3 & 8) != 0 ? null : l, (i3 & 16) != 0 ? null : l2, (i3 & 32) != 0 ? null : str2, kClass, function2, continuation);
    }

    public final Object pollPresetData(int i, int i2, String str, Long l, Long l2, String str2, KClass<? extends BasePresetEntity> kClass, Function2<? super Boolean, ? super Integer, Unit> function2, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$pollPresetData$2(i, i2, str, l, l2, str2, kClass, function2, (Continuation<? super EventRepository$pollPresetData$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final Object getEventPresetByPageInfo(int i, int i2, String str, Long l, Long l2, String str2, Class<? extends BasePresetEntity> cls, Continuation<? super ApiResult<? extends BaseResponse<? extends List<? extends BasePresetEntity>>>> continuation) {
        boolean z;
        boolean z2;
        ReqPageInfo reqPageInfo;
        Unit unit;
        ApiService instance = ApiService.Companion.getInstance();
        boolean z3 = true;
        if (Intrinsics.areEqual((Object) cls, (Object) SportUsrPresetEntity.class)) {
            z = true;
        } else {
            z = Intrinsics.areEqual((Object) cls, (Object) DietUsrPresetEntity.class);
        }
        if (z) {
            z2 = true;
        } else {
            z2 = Intrinsics.areEqual((Object) cls, (Object) InsulinUsrPresetEntity.class);
        }
        if (!z2) {
            z3 = Intrinsics.areEqual((Object) cls, (Object) MedicineUsrPresetEntity.class);
        }
        if (z3) {
            reqPageInfo = new ReqGetEventByPage(l, l2, str2);
        } else if (Intrinsics.areEqual((Object) cls, (Object) SportSysPresetEntity.class)) {
            reqPageInfo = new ReqSysPresetExercisePageInfo(l2);
        } else if (Intrinsics.areEqual((Object) cls, (Object) DietSysPresetEntity.class)) {
            reqPageInfo = new ReqSysPresetFoodPageInfo(l2);
        } else if (Intrinsics.areEqual((Object) cls, (Object) InsulinSysPresetEntity.class)) {
            reqPageInfo = new ReqSysPresetInsulinPageInfo(l2);
        } else if (Intrinsics.areEqual((Object) cls, (Object) MedicineSysPresetEntity.class)) {
            reqPageInfo = new ReqSysPresetMedicationPageInfo(l2);
        } else {
            LogUtil.Companion.xLogE$default(LogUtil.Companion, "不支持当前类型下载数据 clazz=" + cls.getSimpleName(), (String) null, 2, (Object) null);
            reqPageInfo = null;
        }
        if (reqPageInfo != null) {
            reqPageInfo.setPageNum(i);
            reqPageInfo.setPageSize(i2);
            reqPageInfo.setUserId(str);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            EventRepository eventRepository = this;
            return new ApiResult.Failure("3", "not support");
        }
        Map<String, String> queryMap = RequestEntityKt.toQueryMap(reqPageInfo);
        if (Intrinsics.areEqual((Object) cls, (Object) SportUsrPresetEntity.class)) {
            Object exerciseUserPresetList = instance.getExerciseUserPresetList(queryMap, continuation);
            return exerciseUserPresetList == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? exerciseUserPresetList : (ApiResult) exerciseUserPresetList;
        } else if (Intrinsics.areEqual((Object) cls, (Object) DietUsrPresetEntity.class)) {
            Object foodUserPresetList = instance.getFoodUserPresetList(queryMap, continuation);
            return foodUserPresetList == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? foodUserPresetList : (ApiResult) foodUserPresetList;
        } else if (Intrinsics.areEqual((Object) cls, (Object) MedicineUsrPresetEntity.class)) {
            Object medicineUserPresetList = instance.getMedicineUserPresetList(queryMap, continuation);
            return medicineUserPresetList == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? medicineUserPresetList : (ApiResult) medicineUserPresetList;
        } else if (Intrinsics.areEqual((Object) cls, (Object) InsulinUsrPresetEntity.class)) {
            Object insulinUserPresetList = instance.getInsulinUserPresetList(queryMap, continuation);
            return insulinUserPresetList == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insulinUserPresetList : (ApiResult) insulinUserPresetList;
        } else {
            LogUtil.Companion.xLogE$default(LogUtil.Companion, "不支持当前类型下载数据 clazz=" + cls.getSimpleName(), (String) null, 2, (Object) null);
            return new ApiResult.Failure("3", "not support");
        }
    }

    public final <T extends BaseEventEntity> Object deleteEventByIds(List<String> list, Class<T> cls, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(dispatcher, new EventRepository$deleteEventByIds$2(list, cls, (Continuation<? super EventRepository$deleteEventByIds$2>) null), continuation);
    }
}
