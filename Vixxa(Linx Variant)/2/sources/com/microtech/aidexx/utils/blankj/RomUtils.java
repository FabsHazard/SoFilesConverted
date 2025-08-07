package com.microtech.aidexx.utils.blankj;

import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u00010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\b\u0010'\u001a\u00020\u0005H\u0002J\b\u0010(\u001a\u00020%H\u0002J1\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0002¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020*R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u001a\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/microtech/aidexx/utils/blankj/RomUtils;", "", "()V", "ROM_360", "", "", "[Ljava/lang/String;", "ROM_COOLPAD", "ROM_GIONEE", "ROM_GOOGLE", "ROM_HTC", "ROM_HUAWEI", "ROM_LEECO", "ROM_LENOVO", "ROM_LG", "ROM_MEIZU", "ROM_MOTOROLA", "ROM_NUBIA", "ROM_ONEPLUS", "ROM_OPPO", "ROM_SAMSUNG", "ROM_SMARTISAN", "ROM_SONY", "ROM_VIVO", "ROM_XIAOMI", "ROM_ZTE", "UNKNOWN", "VERSION_PROPERTY_360", "VERSION_PROPERTY_HUAWEI", "VERSION_PROPERTY_LEECO", "VERSION_PROPERTY_NUBIA", "VERSION_PROPERTY_ONEPLUS", "VERSION_PROPERTY_OPPO", "VERSION_PROPERTY_VIVO", "VERSION_PROPERTY_XIAOMI", "VERSION_PROPERTY_ZTE", "bean", "Lcom/microtech/aidexx/utils/blankj/RomUtils$RomInfo;", "getBrand", "getManufacturer", "getRomInfo", "isRightRom", "", "brand", "manufacturer", "names", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "isSamsung", "RomInfo", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RomUtils.kt */
public final class RomUtils {
    public static final RomUtils INSTANCE = new RomUtils();
    private static final String[] ROM_360 = {"360", "qiku"};
    private static final String[] ROM_COOLPAD = {"coolpad", "yulong"};
    private static final String[] ROM_GIONEE = {"gionee", "amigo"};
    private static final String[] ROM_GOOGLE = {"google"};
    private static final String[] ROM_HTC = {"htc"};
    private static final String[] ROM_HUAWEI = {"huawei"};
    private static final String[] ROM_LEECO = {"leeco", "letv"};
    private static final String[] ROM_LENOVO = {"lenovo"};
    private static final String[] ROM_LG = {"lg", "lge"};
    private static final String[] ROM_MEIZU = {"meizu"};
    private static final String[] ROM_MOTOROLA = {"motorola"};
    private static final String[] ROM_NUBIA = {"nubia"};
    private static final String[] ROM_ONEPLUS = {"oneplus"};
    private static final String[] ROM_OPPO = {"oppo"};
    private static final String[] ROM_SAMSUNG = {"samsung"};
    private static final String[] ROM_SMARTISAN = {"smartisan", "deltainno"};
    private static final String[] ROM_SONY = {"sony"};
    private static final String[] ROM_VIVO = {"vivo"};
    private static final String[] ROM_XIAOMI = {"xiaomi"};
    private static final String[] ROM_ZTE = {"zte"};
    private static final String UNKNOWN = "unknown";
    private static final String VERSION_PROPERTY_360 = "ro.build.uiversion";
    private static final String VERSION_PROPERTY_HUAWEI = "ro.build.version.emui";
    private static final String VERSION_PROPERTY_LEECO = "ro.letv.release.version";
    private static final String VERSION_PROPERTY_NUBIA = "ro.build.rom.id";
    private static final String VERSION_PROPERTY_ONEPLUS = "ro.rom.version";
    private static final String VERSION_PROPERTY_OPPO = "ro.build.version.opporom";
    private static final String VERSION_PROPERTY_VIVO = "ro.vivo.os.build.display.id";
    private static final String VERSION_PROPERTY_XIAOMI = "ro.build.version.incremental";
    private static final String VERSION_PROPERTY_ZTE = "ro.build.MiFavor_version";
    private static RomInfo bean;

    private RomUtils() {
    }

    private final RomInfo getRomInfo() {
        RomInfo romInfo = bean;
        if (romInfo != null) {
            Intrinsics.checkNotNull(romInfo);
            return romInfo;
        }
        bean = new RomInfo();
        String brand = getBrand();
        String manufacturer = getManufacturer();
        String[] strArr = ROM_SAMSUNG;
        if (isRightRom(brand, manufacturer, (String[]) Arrays.copyOf(strArr, strArr.length))) {
            RomInfo romInfo2 = bean;
            Intrinsics.checkNotNull(romInfo2);
            romInfo2.setName(strArr[0]);
        }
        RomInfo romInfo3 = bean;
        Intrinsics.checkNotNull(romInfo3);
        return romInfo3;
    }

    public final boolean isSamsung() {
        return Intrinsics.areEqual((Object) ROM_SAMSUNG[0], (Object) getRomInfo().getName());
    }

    private final boolean isRightRom(String str, String str2, String... strArr) {
        for (CharSequence charSequence : strArr) {
            if (StringsKt.contains$default((CharSequence) str, charSequence, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, charSequence, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private final String getManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return "unknown";
            }
            Intrinsics.checkNotNull(str);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private final String getBrand() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str)) {
                return "unknown";
            }
            Intrinsics.checkNotNull(str);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/utils/blankj/RomUtils$RomInfo;", "", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "version", "getVersion", "setVersion", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RomUtils.kt */
    public static final class RomInfo {
        private String name;
        private String version;

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getVersion() {
            return this.version;
        }

        public final void setVersion(String str) {
            this.version = str;
        }

        public String toString() {
            return "RomInfo{name=" + this.name + ", version=" + this.version + '}';
        }
    }
}
