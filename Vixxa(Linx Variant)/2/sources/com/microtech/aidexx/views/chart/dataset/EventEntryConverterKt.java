package com.microtech.aidexx.views.chart.dataset;

import android.graphics.drawable.Drawable;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.views.chart.ChartUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"toChartEntry", "Lcom/microtech/aidexx/views/chart/dataset/ChartEntry;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "getY", "Lkotlin/Function0;", "", "app_gpGrxMmolRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventEntryConverter.kt */
public final class EventEntryConverterKt {
    public static /* synthetic */ ChartEntry toChartEntry$default(BaseEventEntity baseEventEntity, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return toChartEntry(baseEventEntity, function0);
    }

    public static final ChartEntry toChartEntry(BaseEventEntity baseEventEntity, Function0<Float> function0) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(baseEventEntity, "<this>");
        if (baseEventEntity instanceof RealCgmHistoryEntity) {
            float millSecondToX = ChartUtil.INSTANCE.millSecondToX(baseEventEntity.convertToCurZoneTs());
            RealCgmHistoryEntity realCgmHistoryEntity = (RealCgmHistoryEntity) baseEventEntity;
            Float glucose = realCgmHistoryEntity.getGlucose();
            Intrinsics.checkNotNull(glucose);
            ChartEntry chartEntry = new ChartEntry(millSecondToX, GlucoseUtilKt.toGlucoseValue(glucose.floatValue()), baseEventEntity);
            chartEntry.setTimeOffset(realCgmHistoryEntity.getTimeOffset());
            chartEntry.setTimeZone(baseEventEntity.getAppTimeZone());
            chartEntry.setSensorId(realCgmHistoryEntity.getSensorId());
            chartEntry.setDstOffset(Intrinsics.areEqual((Object) baseEventEntity.getDstOffset(), (Object) "1") ? "3600" : baseEventEntity.getDstOffset());
            if (chartEntry.getY() < GlucoseUtilKt.toGlucoseValue(36.0f)) {
                chartEntry.setY(GlucoseUtilKt.toGlucoseValue(36.0f));
            }
            if (chartEntry.getY() <= GlucoseUtilKt.toGlucoseValue(450.0f)) {
                return chartEntry;
            }
            chartEntry.setY(GlucoseUtilKt.toGlucoseValue(450.0f));
            return chartEntry;
        } else if (baseEventEntity instanceof BloodGlucoseEntity) {
            ChartEntry chartEntry2 = new ChartEntry(ChartUtil.INSTANCE.millSecondToX(baseEventEntity.convertToCurZoneTs()), ((BloodGlucoseEntity) baseEventEntity).getGlucoseValue(), baseEventEntity);
            chartEntry2.setIcon(BgDataSet.Companion.getIcon());
            return chartEntry2;
        } else if (baseEventEntity instanceof CalibrateEntity) {
            float millSecondToX2 = ChartUtil.INSTANCE.millSecondToX(baseEventEntity.convertToCurZoneTs());
            BloodGlucoseEntity bloodGlucoseEntity = new BloodGlucoseEntity();
            bloodGlucoseEntity.setTimestamp(baseEventEntity.convertToCurZoneTs());
            bloodGlucoseEntity.setBloodGlucoseMg(GlucoseUtilKt.roundOffDecimal(((CalibrateEntity) baseEventEntity).getReferenceGlucose()));
            bloodGlucoseEntity.setAppTime(baseEventEntity.getAppTime());
            bloodGlucoseEntity.setAppTimeZone(baseEventEntity.getAppTimeZone());
            bloodGlucoseEntity.setDstOffset(baseEventEntity.getDstOffset());
            bloodGlucoseEntity.setCalibration(true);
            ChartEntry chartEntry3 = new ChartEntry(millSecondToX2, GlucoseUtilKt.toGlucoseValue(bloodGlucoseEntity.getBloodGlucoseMg()), bloodGlucoseEntity);
            chartEntry3.setIcon(CalDataSet.Companion.getIcon());
            return chartEntry3;
        } else {
            ChartEntry chartEntry4 = new ChartEntry(ChartUtil.INSTANCE.millSecondToX(baseEventEntity.convertToCurZoneTs()), function0 != null ? function0.invoke().floatValue() : GlucoseUtilKt.toGlucoseValue(90.0f), baseEventEntity);
            Class<?> cls = baseEventEntity.getClass();
            if (Intrinsics.areEqual((Object) cls, (Object) InsulinEntity.class)) {
                drawable = IconDataSet.Companion.getInsulinIcon();
            } else if (Intrinsics.areEqual((Object) cls, (Object) DietEntity.class)) {
                drawable = IconDataSet.Companion.getDietIcon();
            } else if (Intrinsics.areEqual((Object) cls, (Object) MedicationEntity.class)) {
                drawable = IconDataSet.Companion.getMedicineIcon();
            } else if (Intrinsics.areEqual((Object) cls, (Object) ExerciseEntity.class)) {
                drawable = IconDataSet.Companion.getExerciseIcon();
            } else {
                drawable = Intrinsics.areEqual((Object) cls, (Object) OthersEntity.class) ? IconDataSet.Companion.getOtherMarkIcon() : null;
            }
            chartEntry4.setIcon(drawable);
            return chartEntry4;
        }
    }
}
