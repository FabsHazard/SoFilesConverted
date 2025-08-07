package com.microtech.aidexx.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatDelegate;
import com.kongzue.dialogx.DialogX;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.ui.setting.SettingsManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0007J\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/microtech/aidexx/utils/ThemeManager;", "", "()V", "theme", "Lcom/microtech/aidexx/utils/ThemeManager$Theme;", "getTheme", "()Lcom/microtech/aidexx/utils/ThemeManager$Theme;", "setTheme", "(Lcom/microtech/aidexx/utils/ThemeManager$Theme;)V", "applyDayNight", "", "getTypeValue", "", "context", "Landroid/content/Context;", "attr", "isLight", "themeByIndex", "index", "themeConfig", "", "updateDayNightMode", "Theme", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ThemeManager.kt */
public final class ThemeManager {
    public static final ThemeManager INSTANCE;
    private static Theme theme;

    private ThemeManager() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/utils/ThemeManager$Theme;", "", "index", "", "id", "(Ljava/lang/String;III)V", "getId", "()I", "getIndex", "DARK", "LIGHT", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ThemeManager.kt */
    public enum Theme {
        DARK(0, R.style.AppThemeDark),
        LIGHT(1, R.style.AppThemeLight);
        
        private final int id;
        private final int index;

        public static EnumEntries<Theme> getEntries() {
            return $ENTRIES;
        }

        private Theme(int i, int i2) {
            this.index = i;
            this.id = i2;
        }

        public final int getId() {
            return this.id;
        }

        public final int getIndex() {
            return this.index;
        }

        static {
            Theme[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final void themeConfig() {
        DialogX.globalTheme = isLight() ? DialogX.THEME.DARK : DialogX.THEME.LIGHT;
    }

    static {
        ThemeManager themeManager = new ThemeManager();
        INSTANCE = themeManager;
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        Intrinsics.checkNotNull(settingEntity);
        theme = themeManager.themeByIndex(settingEntity.getTheme());
    }

    public final void setTheme(Theme theme2) {
        Intrinsics.checkNotNullParameter(theme2, "theme");
        theme = theme2;
        SettingsManager.INSTANCE.setTheme(theme2.getIndex());
    }

    public final Theme getTheme() {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        Intrinsics.checkNotNull(settingEntity);
        return themeByIndex(settingEntity.getTheme());
    }

    public final boolean isLight() {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        Intrinsics.checkNotNull(settingEntity);
        return settingEntity.getTheme() == 1;
    }

    public final Theme themeByIndex(int i) {
        if (i == 0) {
            return Theme.DARK;
        }
        if (i != 1) {
            return Theme.LIGHT;
        }
        return Theme.LIGHT;
    }

    @JvmStatic
    public static final int getTypeValue(Context context, int i) {
        if (context == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme2 = context.getTheme();
        if (theme2 != null) {
            theme2.resolveAttribute(i, typedValue, true);
        }
        return typedValue.data;
    }

    public final boolean applyDayNight() {
        int i = AppCompatDelegate.getDefaultNightMode() == 1 ? 1 : 0;
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        Intrinsics.checkNotNull(settingEntity);
        if (i == settingEntity.getTheme()) {
            return false;
        }
        updateDayNightMode();
        return true;
    }

    public final void updateDayNightMode() {
        int i = 1;
        AppCompatDelegate.setDefaultNightMode(isLight() ? 1 : 2);
        if (Build.VERSION.SDK_INT > 30) {
            UiModeManager uiModeManager = (UiModeManager) ExtendsKt.getContext().getSystemService("uimode");
            if (uiModeManager != null) {
                uiModeManager.setApplicationNightMode(isLight() ? 1 : 2);
            }
            if (uiModeManager != null) {
                if (!isLight()) {
                    i = 2;
                }
                uiModeManager.setNightMode(i);
            }
        }
    }
}
