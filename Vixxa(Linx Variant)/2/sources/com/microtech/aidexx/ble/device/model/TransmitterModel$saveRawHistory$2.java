package com.microtech.aidexx.ble.device.model;

import android.os.SystemClock;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.utils.LogUtil;
import com.microtechmd.blecomm.parser.AidexXRawHistoryEntity;
import io.objectbox.Box;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$saveRawHistory$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $now;
    final /* synthetic */ List<AidexXRawHistoryEntity> $rawHistories;
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$saveRawHistory$2(TransmitterModel transmitterModel, List<? extends AidexXRawHistoryEntity> list, long j) {
        super(0);
        this.this$0 = transmitterModel;
        this.$rawHistories = list;
        this.$now = j;
    }

    public final void invoke() {
        if (this.this$0.tempRawList.isEmpty() || this.this$0.tempRawList.size() != this.$rawHistories.size()) {
            LogUtil.Companion.eAiDEX("Save raw history fail --> Some data cannot be matched");
        } else {
            LogUtil.Companion.eAiDEX("Save raw history " + ((RealCgmHistoryEntity) CollectionsKt.first(this.this$0.tempRawList)).getTimeOffset() + Soundex.SILENT_MARKER + ((RealCgmHistoryEntity) CollectionsKt.last(this.this$0.tempRawList)).getTimeOffset() + " takes : " + (SystemClock.elapsedRealtime() - this.$now) + " ms");
            this.this$0.getEntity().setFullEventIndex(((AidexXRawHistoryEntity) CollectionsKt.last(this.$rawHistories)).timeOffset);
            TransmitterModel transmitterModel = this.this$0;
            transmitterModel.setNextFullEventIndex(transmitterModel.getEntity().getFullEventIndex() + 1);
            Box<TransmitterEntity> transmitterBox = ObjectBox.INSTANCE.getTransmitterBox();
            Intrinsics.checkNotNull(transmitterBox);
            transmitterBox.put(this.this$0.getEntity());
            this.this$0.continueRawFetch();
        }
        this.this$0.tempRawList.clear();
    }
}
