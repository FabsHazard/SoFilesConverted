package com.microtech.aidexx.ui.pair;

import com.microtechmd.blecomm.controller.BleControllerInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/microtechmd/blecomm/controller/BleControllerInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterActivity.kt */
final class TransmitterActivity$deviceDiscover$1 extends Lambda implements Function1<BleControllerInfo, Unit> {
    final /* synthetic */ TransmitterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterActivity$deviceDiscover$1(TransmitterActivity transmitterActivity) {
        super(1);
        this.this$0 = transmitterActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BleControllerInfo) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x016b, code lost:
        if (r1.isEmpty() != false) goto L_0x016f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.microtechmd.blecomm.controller.BleControllerInfo r11) {
        /*
            r10 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r0 = r11.type
            r1 = 3
            if (r0 == r1) goto L_0x018c
            r2 = 4
            if (r0 == r2) goto L_0x000f
            goto L_0x0191
        L_0x000f:
            java.lang.String r0 = r11.sn
            com.microtechmd.blecomm.controller.AidexXController r3 = com.microtechmd.blecomm.controller.AidexXController.getInstance(r11)
            com.microtech.aidexx.ui.pair.TransmitterActivity r4 = r10.this$0
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r4.transmitter
            r5 = 0
            if (r4 == 0) goto L_0x0032
            com.microtech.aidexx.ui.pair.TransmitterActivity r4 = r10.this$0
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r4.transmitter
            if (r4 == 0) goto L_0x002b
            java.lang.String r4 = r4.getDeviceSn()
            goto L_0x002c
        L_0x002b:
            r4 = r5
        L_0x002c:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r4 != 0) goto L_0x0191
        L_0x0032:
            com.microtech.aidexx.ui.pair.TransmitterActivity r4 = r10.this$0
            java.util.List r4 = r4.availableTransmitterList
            java.lang.String r6 = "availableTransmitterList"
            if (r4 != 0) goto L_0x0040
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r4 = r5
        L_0x0040:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r7 = r4 instanceof java.util.Collection
            r8 = 1
            if (r7 == 0) goto L_0x0051
            r7 = r4
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0051
            goto L_0x006d
        L_0x0051:
            java.util.Iterator r4 = r4.iterator()
        L_0x0055:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x006d
            java.lang.Object r7 = r4.next()
            com.microtechmd.blecomm.controller.BleControllerProxy r7 = (com.microtechmd.blecomm.controller.BleControllerProxy) r7
            java.lang.String r7 = r7.getSn()
            boolean r7 = kotlin.text.StringsKt.equals(r7, r0, r8)
            if (r7 == 0) goto L_0x0055
            goto L_0x0191
        L_0x006d:
            com.microtech.aidexx.ui.pair.TransmitterActivity r4 = r10.this$0
            java.util.List r4 = r4.unavailableTransmitterList
            java.lang.String r7 = "unavailableTransmitterList"
            if (r4 != 0) goto L_0x007b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r4 = r5
        L_0x007b:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r9 = r4 instanceof java.util.Collection
            if (r9 == 0) goto L_0x008b
            r9 = r4
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x008b
            goto L_0x00a7
        L_0x008b:
            java.util.Iterator r4 = r4.iterator()
        L_0x008f:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x00a7
            java.lang.Object r9 = r4.next()
            com.microtechmd.blecomm.controller.BleControllerProxy r9 = (com.microtechmd.blecomm.controller.BleControllerProxy) r9
            java.lang.String r9 = r9.getSn()
            boolean r9 = kotlin.text.StringsKt.equals(r9, r0, r8)
            if (r9 == 0) goto L_0x008f
            goto L_0x0191
        L_0x00a7:
            int r0 = r11.type
            if (r0 == r1) goto L_0x0191
            int r0 = r11.type
            if (r0 != r2) goto L_0x0191
            int r0 = r3.isBleNativePaired()
            if (r0 != r8) goto L_0x00e8
            com.microtech.aidexx.ui.pair.TransmitterActivity r0 = r10.this$0
            java.util.List r0 = r0.historyDevices
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x00cb
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00cb
            goto L_0x00e8
        L_0x00cb:
            java.util.Iterator r0 = r0.iterator()
        L_0x00cf:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00e8
            java.lang.Object r1 = r0.next()
            com.microtech.aidexx.db.entity.HistoryDeviceInfo r1 = (com.microtech.aidexx.db.entity.HistoryDeviceInfo) r1
            java.lang.String r2 = r11.sn
            java.lang.String r1 = r1.getDeviceSn()
            boolean r1 = kotlin.text.StringsKt.equals(r2, r1, r8)
            if (r1 == 0) goto L_0x00cf
            goto L_0x00ee
        L_0x00e8:
            int r11 = r3.isBleNativePaired()
            if (r11 == r8) goto L_0x0101
        L_0x00ee:
            com.microtech.aidexx.ui.pair.TransmitterActivity r11 = r10.this$0
            java.util.List r11 = r11.availableTransmitterList
            if (r11 != 0) goto L_0x00fa
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r11 = r5
        L_0x00fa:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r11.add(r3)
            goto L_0x0113
        L_0x0101:
            com.microtech.aidexx.ui.pair.TransmitterActivity r11 = r10.this$0
            java.util.List r11 = r11.unavailableTransmitterList
            if (r11 != 0) goto L_0x010d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r11 = r5
        L_0x010d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r11.add(r3)
        L_0x0113:
            com.microtech.aidexx.ui.pair.TransmitterActivity r11 = r10.this$0
            com.microtech.aidexx.ui.pair.TransmitterAdapter r11 = r11.transmitterAdapter
            java.lang.String r0 = "transmitterAdapter"
            if (r11 != 0) goto L_0x0121
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r11 = r5
        L_0x0121:
            com.microtech.aidexx.ui.pair.TransmitterActivity r1 = r10.this$0
            java.util.List r1 = r1.unavailableTransmitterList
            if (r1 != 0) goto L_0x012d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r5
        L_0x012d:
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r8
            r11.setCanShowMore(r1)
            com.microtech.aidexx.ui.pair.TransmitterActivity r11 = r10.this$0
            androidx.viewbinding.ViewBinding r11 = r11.getBinding()
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r11 = (com.microtech.aidexx.databinding.ActivityTransmitterBinding) r11
            android.widget.TextView r11 = r11.noDevice
            java.lang.String r1 = "noDevice"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            android.view.View r11 = (android.view.View) r11
            com.microtech.aidexx.ui.pair.TransmitterActivity r1 = r10.this$0
            java.util.List r1 = r1.availableTransmitterList
            if (r1 != 0) goto L_0x0154
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r1 = r5
        L_0x0154:
            boolean r1 = r1.isEmpty()
            r2 = 0
            if (r1 == 0) goto L_0x016e
            com.microtech.aidexx.ui.pair.TransmitterActivity r1 = r10.this$0
            java.util.List r1 = r1.unavailableTransmitterList
            if (r1 != 0) goto L_0x0167
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r5
        L_0x0167:
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x016e
            goto L_0x016f
        L_0x016e:
            r8 = r2
        L_0x016f:
            if (r8 == 0) goto L_0x0172
            goto L_0x0174
        L_0x0172:
            r2 = 8
        L_0x0174:
            r11.setVisibility(r2)
            com.microtech.aidexx.ui.pair.TransmitterActivity r11 = r10.this$0
            com.microtech.aidexx.ui.pair.TransmitterAdapter r1 = r11.transmitterAdapter
            if (r1 != 0) goto L_0x0183
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x0184
        L_0x0183:
            r5 = r1
        L_0x0184:
            boolean r0 = r5.isShowingMore()
            r11.refreshTransList(r0)
            goto L_0x0191
        L_0x018c:
            com.microtechmd.blecomm.controller.CgmController r11 = new com.microtechmd.blecomm.controller.CgmController
            r11.<init>()
        L_0x0191:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.pair.TransmitterActivity$deviceDiscover$1.invoke(com.microtechmd.blecomm.controller.BleControllerInfo):void");
    }
}
