package com.microtech.aidexx.db.entity.event.preset;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.event.DietDetail;
import com.microtech.aidexx.db.entity.event.ExerciseDetail;
import com.microtech.aidexx.db.entity.event.InsulinDetail;
import com.microtech.aidexx.db.entity.event.MedicationDetail;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b¨\u0006\f"}, d2 = {"toDietDetailEntity", "Lcom/microtech/aidexx/db/entity/event/DietDetail;", "Lcom/microtech/aidexx/db/entity/event/preset/DietPresetEntity;", "toExerciseDetailEntity", "Lcom/microtech/aidexx/db/entity/event/ExerciseDetail;", "Lcom/microtech/aidexx/db/entity/event/preset/SportPresetEntity;", "toInsulinDetailEntity", "Lcom/microtech/aidexx/db/entity/event/InsulinDetail;", "Lcom/microtech/aidexx/db/entity/event/preset/InsulinPresetEntity;", "toMedicineDetailEntity", "Lcom/microtech/aidexx/db/entity/event/MedicationDetail;", "Lcom/microtech/aidexx/db/entity/event/preset/MedicinePresetEntity;", "app_gpGrxMmolRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: PresetExtentions.kt */
public final class PresetExtentionsKt {
    public static final DietDetail toDietDetailEntity(DietPresetEntity dietPresetEntity) {
        Intrinsics.checkNotNullParameter(dietPresetEntity, "<this>");
        DietDetail dietDetail = new DietDetail((String) null, (String) null, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, (String) null, 255, (DefaultConstructorMarker) null);
        dietDetail.setFoodPresetId(dietPresetEntity.getPresetId());
        dietDetail.setName(dietPresetEntity.getName());
        dietDetail.setPresetType(dietPresetEntity.isUserPreset() ? 1 : 0);
        dietDetail.setCarbohydrate(dietPresetEntity.getCarbohydrate());
        dietDetail.setProtein(dietPresetEntity.getProtein());
        dietDetail.setUnit(dietPresetEntity.getUnit());
        dietDetail.setFat(dietPresetEntity.getFat());
        dietDetail.setQuantity(dietPresetEntity.getQuantity());
        return dietDetail;
    }

    public static final ExerciseDetail toExerciseDetailEntity(SportPresetEntity sportPresetEntity) {
        Intrinsics.checkNotNullParameter(sportPresetEntity, "<this>");
        ExerciseDetail exerciseDetail = new ExerciseDetail((Long) null, (String) null, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 0, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
        exerciseDetail.setExercisePresetId(sportPresetEntity.getPresetId());
        exerciseDetail.setName(sportPresetEntity.getName());
        exerciseDetail.setPresetType(sportPresetEntity.isUserPreset() ? 1 : 0);
        exerciseDetail.setIntensity_category_name(sportPresetEntity.getIntensityCategoryName());
        exerciseDetail.setHour_kcal_per_kg(sportPresetEntity.getHourKcalPerKg());
        return exerciseDetail;
    }

    public static final MedicationDetail toMedicineDetailEntity(MedicinePresetEntity medicinePresetEntity) {
        Intrinsics.checkNotNullParameter(medicinePresetEntity, "<this>");
        MedicationDetail medicationDetail = new MedicationDetail((String) null, (String) null, (String) null, (String) null, Utils.DOUBLE_EPSILON, 0, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
        medicationDetail.setMedicationPresetId(medicinePresetEntity.getPresetId());
        medicationDetail.setName(medicinePresetEntity.getName());
        medicationDetail.setPresetType(medicinePresetEntity.isUserPreset() ? 1 : 0);
        medicationDetail.setCategory_name(medicinePresetEntity.getCategoryName());
        medicationDetail.setEnglish_name(medicinePresetEntity.getEnglishName());
        String manufacturer = medicinePresetEntity.getManufacturer();
        String str = "";
        if (manufacturer == null) {
            manufacturer = str;
        }
        medicationDetail.setManufacturer(manufacturer);
        String tradeName = medicinePresetEntity.getTradeName();
        if (tradeName != null) {
            str = tradeName;
        }
        medicationDetail.setTradeName(str);
        return medicationDetail;
    }

    public static final InsulinDetail toInsulinDetailEntity(InsulinPresetEntity insulinPresetEntity) {
        Intrinsics.checkNotNullParameter(insulinPresetEntity, "<this>");
        InsulinDetail insulinDetail = new InsulinDetail((String) null, (String) null, (String) null, (String) null, (String) null, Utils.DOUBLE_EPSILON, 0, 0, (String) null, (Date) null, (String) null, 2047, (DefaultConstructorMarker) null);
        insulinDetail.setInsulinPresetId(insulinPresetEntity.getPresetId());
        insulinDetail.setName(insulinPresetEntity.getName());
        insulinDetail.setPresetType(insulinPresetEntity.isUserPreset() ? 1 : 0);
        String categoryName = insulinPresetEntity.getCategoryName();
        String str = "";
        if (categoryName == null) {
            categoryName = str;
        }
        insulinDetail.setCategoryName(categoryName);
        String manufacturer = insulinPresetEntity.getManufacturer();
        if (manufacturer == null) {
            manufacturer = str;
        }
        insulinDetail.setManufacturer(manufacturer);
        String tradeName = insulinPresetEntity.getTradeName();
        if (tradeName != null) {
            str = tradeName;
        }
        insulinDetail.setTradeName(str);
        insulinDetail.setComment(insulinPresetEntity.getComment());
        return insulinDetail;
    }
}
