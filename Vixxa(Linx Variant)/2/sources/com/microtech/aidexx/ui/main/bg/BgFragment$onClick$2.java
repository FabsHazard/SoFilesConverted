package com.microtech.aidexx.ui.main.bg;

import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.MessageDistributor;
import com.microtech.aidexx.ble.device.entity.CalibrationInfo;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.parser.AidexXHistoryEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BgFragment.kt */
final class BgFragment$onClick$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Float $glucoseValue;
    final /* synthetic */ DeviceModel $model;
    final /* synthetic */ BgFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BgFragment$onClick$2(BgFragment bgFragment, Float f, DeviceModel deviceModel) {
        super(0);
        this.this$0 = bgFragment;
        this.$glucoseValue = f;
        this.$model = deviceModel;
    }

    public final void invoke() {
        float f;
        Dialogs.INSTANCE.showWait(this.this$0.getString(R.string.com_actionState_doing, this.this$0.getString(R.string.com_action_calibration)));
        if (UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L) {
            f = this.$glucoseValue.floatValue() * 18.0f;
        } else {
            f = this.$glucoseValue.floatValue();
        }
        int roundToInt = MathKt.roundToInt(f);
        MessageDistributor.Companion.instance().observer(this.this$0.mObserver);
        DeviceModel deviceModel = this.$model;
        AidexXHistoryEntity latestHistory = this.$model.getLatestHistory();
        Intrinsics.checkNotNull(latestHistory);
        deviceModel.calibration(new CalibrationInfo(roundToInt, latestHistory.timeOffset));
    }
}
