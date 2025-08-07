package com.microtech.aidexx.ble.device.model;

import com.microtech.aidexx.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$onMessage$4$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$onMessage$4$2(TransmitterModel transmitterModel) {
        super(0);
        this.this$0 = transmitterModel;
    }

    public final void invoke() {
        Boolean bool = BuildConfig.keepAlive;
        Intrinsics.checkNotNullExpressionValue(bool, "keepAlive");
        if (bool.booleanValue()) {
            this.this$0.startLongConnect();
        }
    }
}
