package com.microtech.aidexx.service;

import android.content.Intent;
import com.microtech.aidexx.ble.AidexBleAdapter;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeChangeReceiver.kt */
final class TimeChangeReceiver$onReceive$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Intent $intent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimeChangeReceiver$onReceive$1(Intent intent) {
        super(0);
        this.$intent = intent;
    }

    public final void invoke() {
        Intent intent = this.$intent;
        if (Intrinsics.areEqual((Object) intent != null ? intent.getAction() : null, (Object) "android.intent.action.TIME_SET") && !AidexBleAdapter.Companion.getInstance().isOnConnectState()) {
            LogUtil.Companion.eAiDEX("System time modified, restart ble scan");
            AidexBleAdapter.Companion.getInstance().executeStopScan();
        }
        TimeZone timeZone = TimeZone.getDefault();
        String timezone = SettingsManager.INSTANCE.getTimezone();
        if (timezone != null) {
            String timezoneOffset$default = TimeUtils.getTimezoneOffset$default(TimeUtils.INSTANCE, timezone, 0, 2, (Object) null);
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            String id = timeZone.getID();
            Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
            if (!Intrinsics.areEqual((Object) timezoneOffset$default, (Object) TimeUtils.getTimezoneOffset$default(timeUtils, id, 0, 2, (Object) null))) {
                TimezoneHistoryManager timezoneHistoryManager = TimezoneHistoryManager.INSTANCE;
                String id2 = timeZone.getID();
                Intrinsics.checkNotNullExpressionValue(id2, "getID(...)");
                timezoneHistoryManager.createTimezoneHistory(timezone, id2, false, timeZone.getDSTSavings() / 1000);
                SettingsManager settingsManager = SettingsManager.INSTANCE;
                String id3 = timeZone.getID();
                Intrinsics.checkNotNullExpressionValue(id3, "getID(...)");
                settingsManager.setTimezone(id3);
                SettingsManager.INSTANCE.setInDaylightTime(timeZone.inDaylightTime(new Date()));
                TimezoneHistoryManager.INSTANCE.setNeedRefreshChart(new Pair(true, true));
                EventBusManager.INSTANCE.send(EventBusKey.DST_CHANGE, true);
                return;
            }
            boolean inDaylightTime = timeZone.inDaylightTime(new Date());
            Boolean inDaylightTime2 = SettingsManager.INSTANCE.inDaylightTime();
            if (inDaylightTime2 != null) {
                if (inDaylightTime != inDaylightTime2.booleanValue()) {
                    if (timeZone.getRawOffset() == TimeZone.getTimeZone(timezone).getRawOffset()) {
                        TimezoneHistoryManager timezoneHistoryManager2 = TimezoneHistoryManager.INSTANCE;
                        String id4 = timeZone.getID();
                        Intrinsics.checkNotNullExpressionValue(id4, "getID(...)");
                        timezoneHistoryManager2.createTimezoneHistory(timezone, id4, true, timeZone.getDSTSavings() / 1000);
                        SettingsManager settingsManager2 = SettingsManager.INSTANCE;
                        String id5 = timeZone.getID();
                        Intrinsics.checkNotNullExpressionValue(id5, "getID(...)");
                        settingsManager2.setTimezone(id5);
                        SettingsManager.INSTANCE.setInDaylightTime(inDaylightTime);
                        TimezoneHistoryManager.INSTANCE.setNeedRefreshChart(new Pair(true, true));
                        EventBusManager.INSTANCE.send(EventBusKey.DST_CHANGE, true);
                    } else {
                        SettingsManager settingsManager3 = SettingsManager.INSTANCE;
                        String id6 = timeZone.getID();
                        Intrinsics.checkNotNullExpressionValue(id6, "getID(...)");
                        settingsManager3.setTimezone(id6);
                        SettingsManager.INSTANCE.setInDaylightTime(inDaylightTime);
                        TimezoneHistoryManager.INSTANCE.setNeedRefreshChart(new Pair(true, false));
                        EventBusManager.INSTANCE.send(EventBusKey.DST_CHANGE, true);
                    }
                }
                Unit unit = Unit.INSTANCE;
                return;
            }
            new TimeChangeReceiver$onReceive$1$1$2(inDaylightTime);
        }
    }
}
