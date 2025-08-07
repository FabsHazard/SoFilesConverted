package com.microtech.aidexx.utils;

import com.microtech.aidexx.BuildConfig;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.ui.setting.SettingsManager;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0006\u0010\u0012\u001a\u00020\nR&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/microtech/aidexx/utils/UnitManager;", "", "()V", "glucoseUnit", "Lcom/microtech/aidexx/utils/UnitManager$GlucoseUnit;", "getGlucoseUnit", "()Lcom/microtech/aidexx/utils/UnitManager$GlucoseUnit;", "setGlucoseUnit", "(Lcom/microtech/aidexx/utils/UnitManager$GlucoseUnit;)V", "formatterUnitByIndex", "Ljava/text/DecimalFormat;", "getDisplayUnit", "", "getUnit", "", "getUnitByIndex", "index", "glucoseUnitByIndex", "unitFormat", "GlucoseUnit", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UnitManager.kt */
public final class UnitManager {
    public static final UnitManager INSTANCE;
    private static GlucoseUnit glucoseUnit;

    private UnitManager() {
    }

    public final int getUnit() {
        ExtendsKt.isGp();
        return 0;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fj\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/utils/UnitManager$GlucoseUnit;", "", "index", "", "text", "", "unit", "formatter", "Ljava/text/DecimalFormat;", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/text/DecimalFormat;)V", "getFormatter", "()Ljava/text/DecimalFormat;", "getIndex", "()I", "getText", "()Ljava/lang/String;", "getUnit", "MMOL_PER_L", "MG_PER_DL", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UnitManager.kt */
    public enum GlucoseUnit {
        MMOL_PER_L(0, "mmol/L", BuildConfig.FLAVOR_GLUCOSE_UNIT, new DecimalFormat("0.0")),
        MG_PER_DL(1, "mg/dL", "mg", new DecimalFormat("0"));
        
        private final DecimalFormat formatter;
        private final int index;
        private final String text;
        private final String unit;

        public static EnumEntries<GlucoseUnit> getEntries() {
            return $ENTRIES;
        }

        private GlucoseUnit(int i, String str, String str2, DecimalFormat decimalFormat) {
            this.index = i;
            this.text = str;
            this.unit = str2;
            this.formatter = decimalFormat;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getText() {
            return this.text;
        }

        public final String getUnit() {
            return this.unit;
        }

        public final DecimalFormat getFormatter() {
            return this.formatter;
        }

        static {
            GlucoseUnit[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final String getDisplayUnit() {
        if (Intrinsics.areEqual((Object) getGlucoseUnit().getText(), (Object) "mg/dL")) {
            String string = ExtendsKt.getContext().getString(R.string.cgm_unit_mg);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        String string2 = ExtendsKt.getContext().getString(R.string.cgm_unit_mmol);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    static {
        UnitManager unitManager = new UnitManager();
        INSTANCE = unitManager;
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        Intrinsics.checkNotNull(settingEntity);
        glucoseUnit = unitManager.glucoseUnitByIndex(settingEntity.getUnit());
    }

    public final void setGlucoseUnit(GlucoseUnit glucoseUnit2) {
        Intrinsics.checkNotNullParameter(glucoseUnit2, "glucoseUnit");
        glucoseUnit = glucoseUnit2;
        SettingsManager.INSTANCE.setUnit(glucoseUnit2.getIndex());
    }

    public final GlucoseUnit getGlucoseUnit() {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        Intrinsics.checkNotNull(settingEntity);
        return glucoseUnitByIndex(settingEntity.getUnit());
    }

    private final GlucoseUnit glucoseUnitByIndex(int i) {
        if (i == GlucoseUnit.MMOL_PER_L.getIndex()) {
            return GlucoseUnit.MMOL_PER_L;
        }
        if (i == GlucoseUnit.MG_PER_DL.getIndex()) {
            return GlucoseUnit.MG_PER_DL;
        }
        return GlucoseUnit.MMOL_PER_L;
    }

    public final DecimalFormat formatterUnitByIndex() {
        int index = getGlucoseUnit().getIndex();
        if (index == 0) {
            return new DecimalFormat("0.0");
        }
        if (index != 1) {
            return new DecimalFormat("0");
        }
        return new DecimalFormat("0");
    }

    public final GlucoseUnit getUnitByIndex(int i) {
        if (i == GlucoseUnit.MMOL_PER_L.getIndex()) {
            return GlucoseUnit.MMOL_PER_L;
        }
        if (i == GlucoseUnit.MG_PER_DL.getIndex()) {
            return GlucoseUnit.MG_PER_DL;
        }
        return GlucoseUnit.MMOL_PER_L;
    }

    public final DecimalFormat unitFormat() {
        DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(ExtendsKt.getLocale());
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalFormatSymbols(instance);
        int index = getGlucoseUnit().getIndex();
        if (index == 0) {
            decimalFormat.applyPattern("0.0");
        } else if (index != 1) {
            decimalFormat.applyPattern("0.0");
        } else {
            decimalFormat.applyPattern("0");
        }
        return decimalFormat;
    }
}
