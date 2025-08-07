package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventDao$$ExternalSyntheticLambda13 implements Callable {
    public final /* synthetic */ BasePresetEntity f$0;

    public /* synthetic */ EventDao$$ExternalSyntheticLambda13(BasePresetEntity basePresetEntity) {
        this.f$0 = basePresetEntity;
    }

    public final Object call() {
        return EventDao.insertSysPresetData$lambda$2(this.f$0);
    }
}
