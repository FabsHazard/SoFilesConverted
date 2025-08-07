package com.microtech.aidexx.ui.main.history;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.event.DietDetail;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0005\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0006\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0007\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\b\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\t\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\n¨\u0006\u000b"}, d2 = {"getDeletable", "", "toHistoryDetailModel", "Lcom/microtech/aidexx/ui/main/history/HistoryDetailModel;", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "Lcom/microtech/aidexx/db/entity/event/DietEntity;", "Lcom/microtech/aidexx/db/entity/event/ExerciseEntity;", "Lcom/microtech/aidexx/db/entity/event/InsulinEntity;", "Lcom/microtech/aidexx/db/entity/event/MedicationEntity;", "Lcom/microtech/aidexx/db/entity/event/OthersEntity;", "app_gpGrxMmolRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryDetailModelExtentions.kt */
public final class HistoryDetailModelExtentionsKt {
    private static final boolean getDeletable() {
        return UserInfoManager.Companion.getShareUserInfo() == null;
    }

    public static final HistoryDetailModel toHistoryDetailModel(DietEntity dietEntity) {
        Intrinsics.checkNotNullParameter(dietEntity, "<this>");
        HistoryDetailModel historyDetailModel = new HistoryDetailModel((Long) null, (String) null, (List) null, (Integer) null, (Long) null, false, false, dietEntity.getClass(), 127, (DefaultConstructorMarker) null);
        historyDetailModel.setIdForRealEntity(dietEntity.getIdx());
        historyDetailModel.setTime(Long.valueOf(dietEntity.convertToCurZoneTs()));
        historyDetailModel.setResourceId(Integer.valueOf(R.drawable.ic_have_food));
        historyDetailModel.setDeletable(getDeletable());
        if (!dietEntity.getExpandList().isEmpty()) {
            String string = ExtendsKt.getContext().getString(R.string.history_board_unit_food);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            double d = Utils.DOUBLE_EPSILON;
            double d2 = 0.0d;
            double d3 = 0.0d;
            for (DietDetail dietDetail : dietEntity.getExpandList()) {
                d3 += dietDetail.getFat();
                d2 += dietDetail.getProtein();
                d += dietDetail.getCarbohydrate();
            }
            List<String> contentList = historyDetailModel.getContentList();
            String string2 = ExtendsKt.getContext().getString(R.string.history_event_carb, new Object[]{ExtendsKt.stripTrailingZeros(Double.valueOf(d), 3), string});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            contentList.add(string2);
            List<String> contentList2 = historyDetailModel.getContentList();
            String string3 = ExtendsKt.getContext().getString(R.string.history_event_protein, new Object[]{ExtendsKt.stripTrailingZeros(Double.valueOf(d2), 3), string});
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            contentList2.add(string3);
            List<String> contentList3 = historyDetailModel.getContentList();
            String string4 = ExtendsKt.getContext().getString(R.string.history_event_fat, new Object[]{ExtendsKt.stripTrailingZeros(Double.valueOf(d3), 3), string});
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            contentList3.add(string4);
        }
        historyDetailModel.setTitle(dietEntity.getEventDescription(ExtendsKt.getContext().getResources()));
        return historyDetailModel;
    }

    public static final HistoryDetailModel toHistoryDetailModel(ExerciseEntity exerciseEntity) {
        Intrinsics.checkNotNullParameter(exerciseEntity, "<this>");
        HistoryDetailModel historyDetailModel = new HistoryDetailModel((Long) null, (String) null, (List) null, (Integer) null, (Long) null, false, false, exerciseEntity.getClass(), 127, (DefaultConstructorMarker) null);
        historyDetailModel.setIdForRealEntity(exerciseEntity.getIdx());
        historyDetailModel.setTime(Long.valueOf(exerciseEntity.convertToCurZoneTs()));
        historyDetailModel.setResourceId(Integer.valueOf(R.drawable.ic_excise));
        historyDetailModel.setTitle(exerciseEntity.getEventDescription(ExtendsKt.getContext().getResources()));
        historyDetailModel.setDeletable(getDeletable());
        return historyDetailModel;
    }

    public static final HistoryDetailModel toHistoryDetailModel(MedicationEntity medicationEntity) {
        Intrinsics.checkNotNullParameter(medicationEntity, "<this>");
        HistoryDetailModel historyDetailModel = new HistoryDetailModel((Long) null, (String) null, (List) null, (Integer) null, (Long) null, false, false, medicationEntity.getClass(), 127, (DefaultConstructorMarker) null);
        historyDetailModel.setIdForRealEntity(medicationEntity.getIdx());
        historyDetailModel.setTime(Long.valueOf(medicationEntity.convertToCurZoneTs()));
        historyDetailModel.setResourceId(Integer.valueOf(R.drawable.ic_use_medical));
        historyDetailModel.setTitle(medicationEntity.getEventDescription(ExtendsKt.getContext().getResources()));
        historyDetailModel.setDeletable(getDeletable());
        return historyDetailModel;
    }

    public static final HistoryDetailModel toHistoryDetailModel(InsulinEntity insulinEntity) {
        Intrinsics.checkNotNullParameter(insulinEntity, "<this>");
        HistoryDetailModel historyDetailModel = new HistoryDetailModel((Long) null, (String) null, (List) null, (Integer) null, (Long) null, false, false, insulinEntity.getClass(), 127, (DefaultConstructorMarker) null);
        historyDetailModel.setIdForRealEntity(insulinEntity.getIdx());
        historyDetailModel.setResourceId(Integer.valueOf(R.drawable.ic_yds));
        historyDetailModel.setTime(Long.valueOf(insulinEntity.convertToCurZoneTs()));
        historyDetailModel.setTitle(insulinEntity.getEventDescription(ExtendsKt.getContext().getResources()));
        historyDetailModel.setDeletable(getDeletable());
        return historyDetailModel;
    }

    public static final HistoryDetailModel toHistoryDetailModel(OthersEntity othersEntity) {
        Intrinsics.checkNotNullParameter(othersEntity, "<this>");
        HistoryDetailModel historyDetailModel = new HistoryDetailModel((Long) null, (String) null, (List) null, (Integer) null, (Long) null, false, false, othersEntity.getClass(), 127, (DefaultConstructorMarker) null);
        historyDetailModel.setIdForRealEntity(othersEntity.getIdx());
        historyDetailModel.setTime(Long.valueOf(othersEntity.convertToCurZoneTs()));
        historyDetailModel.setResourceId(Integer.valueOf(R.drawable.ic_other_mark));
        historyDetailModel.setTitle(othersEntity.getContent());
        historyDetailModel.setDeletable(getDeletable());
        return historyDetailModel;
    }

    public static final HistoryDetailModel toHistoryDetailModel(RealCgmHistoryEntity realCgmHistoryEntity) {
        Intrinsics.checkNotNullParameter(realCgmHistoryEntity, "<this>");
        HistoryDetailModel historyDetailModel = new HistoryDetailModel((Long) null, (String) null, (List) null, (Integer) null, (Long) null, false, false, realCgmHistoryEntity.getClass(), 127, (DefaultConstructorMarker) null);
        historyDetailModel.setIdForRealEntity(realCgmHistoryEntity.getIdx());
        historyDetailModel.setTime(Long.valueOf(realCgmHistoryEntity.convertToCurZoneTs()));
        historyDetailModel.setDeletable(false);
        int eventWarning = realCgmHistoryEntity.getEventWarning();
        if (eventWarning == 1) {
            historyDetailModel.setResourceId(Integer.valueOf(R.drawable.ic_yellow_alert));
        } else if (eventWarning == 2 || eventWarning == 3) {
            historyDetailModel.setResourceId(Integer.valueOf(R.drawable.ic_red_alert));
        }
        historyDetailModel.setTitle(realCgmHistoryEntity.getEventWarningTip(ExtendsKt.getContext().getResources()));
        return historyDetailModel;
    }

    public static final HistoryDetailModel toHistoryDetailModel(BloodGlucoseEntity bloodGlucoseEntity) {
        Intrinsics.checkNotNullParameter(bloodGlucoseEntity, "<this>");
        HistoryDetailModel historyDetailModel = new HistoryDetailModel((Long) null, (String) null, (List) null, (Integer) null, (Long) null, false, false, bloodGlucoseEntity.getClass(), 127, (DefaultConstructorMarker) null);
        historyDetailModel.setIdForRealEntity(bloodGlucoseEntity.getIdx());
        historyDetailModel.setTime(Long.valueOf(bloodGlucoseEntity.convertToCurZoneTs()));
        historyDetailModel.setResourceId(Integer.valueOf(R.drawable.ic_bg_cal));
        historyDetailModel.setDeletable(getDeletable());
        String str = bloodGlucoseEntity.getEventDescription(ExtendsKt.getContext().getResources()) + " " + bloodGlucoseEntity.getValueDescription(ExtendsKt.getContext().getResources());
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        historyDetailModel.setTitle(str);
        return historyDetailModel;
    }
}
