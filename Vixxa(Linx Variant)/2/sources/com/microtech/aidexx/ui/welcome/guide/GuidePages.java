package com.microtech.aidexx.ui.welcome.guide;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/GuidePages;", "", "(Ljava/lang/String;I)V", "PERMISSION_CHECK", "DO_NOT_DISTURB", "ATTENTION_ALERT", "LOW_THRESHOLD_SET", "HIGH_THRESHOLD_SET", "TREND_INTRODUCE", "BG_INTRODUCE", "SENSOR_INSERT", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GuideViewPagerAdapter.kt */
public enum GuidePages {
    PERMISSION_CHECK,
    DO_NOT_DISTURB,
    ATTENTION_ALERT,
    LOW_THRESHOLD_SET,
    HIGH_THRESHOLD_SET,
    TREND_INTRODUCE,
    BG_INTRODUCE,
    SENSOR_INSERT;

    public static EnumEntries<GuidePages> getEntries() {
        return $ENTRIES;
    }

    static {
        GuidePages[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
