package com.microtech.aidexx.ui.pair;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.pair.TransmitterActivity$refreshMine$1", f = "TransmitterActivity.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransmitterActivity.kt */
final class TransmitterActivity$refreshMine$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TransmitterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterActivity$refreshMine$1(TransmitterActivity transmitterActivity, Continuation<? super TransmitterActivity$refreshMine$1> continuation) {
        super(2, continuation);
        this.this$0 = transmitterActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransmitterActivity$refreshMine$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransmitterActivity$refreshMine$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d1, code lost:
        if (r3 == null) goto L_0x01d3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            java.lang.Object r0 = r7.L$0
            com.microtech.aidexx.ui.pair.TransmitterActivity r0 = (com.microtech.aidexx.ui.pair.TransmitterActivity) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0036
        L_0x0013:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r8)
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r1 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r1 = r1.instance()
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r1 = r1.queryTransmitter(r3)
            if (r1 != r0) goto L_0x0034
            return r0
        L_0x0034:
            r0 = r8
            r8 = r1
        L_0x0036:
            com.microtech.aidexx.db.entity.TransmitterEntity r8 = (com.microtech.aidexx.db.entity.TransmitterEntity) r8
            r0.transmitter = r8
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            com.microtech.aidexx.db.entity.TransmitterEntity r8 = r8.transmitter
            r0 = 8
            r1 = 0
            r3 = 0
            if (r8 != 0) goto L_0x0067
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            androidx.viewbinding.ViewBinding r8 = r8.getBinding()
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r8 = (com.microtech.aidexx.databinding.ActivityTransmitterBinding) r8
            android.widget.TextView r8 = r8.tvPlsSelectTrans
            r8.setVisibility(r1)
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            androidx.viewbinding.ViewBinding r8 = r8.getBinding()
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r8 = (com.microtech.aidexx.databinding.ActivityTransmitterBinding) r8
            com.microtech.aidexx.databinding.ItemTransmitterBinding r8 = r8.layoutMyTrans
            androidx.constraintlayout.widget.ConstraintLayout r8 = r8.getRoot()
            r8.setVisibility(r0)
            goto L_0x01bd
        L_0x0067:
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            java.util.List r8 = r8.availableTransmitterList
            java.lang.String r4 = "availableTransmitterList"
            if (r8 != 0) goto L_0x0075
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r8 = r3
        L_0x0075:
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x010c
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            java.util.List r8 = r8.availableTransmitterList
            if (r8 != 0) goto L_0x0089
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r8 = r3
        L_0x0089:
            java.util.Iterator r8 = r8.iterator()
        L_0x008d:
            boolean r5 = r8.hasNext()
            if (r5 == 0) goto L_0x00b5
            java.lang.Object r5 = r8.next()
            com.microtechmd.blecomm.controller.BleControllerProxy r5 = (com.microtechmd.blecomm.controller.BleControllerProxy) r5
            java.lang.String r5 = r5.getSn()
            com.microtech.aidexx.ui.pair.TransmitterActivity r6 = r7.this$0
            com.microtech.aidexx.db.entity.TransmitterEntity r6 = r6.transmitter
            if (r6 == 0) goto L_0x00aa
            java.lang.String r6 = r6.getDeviceSn()
            goto L_0x00ab
        L_0x00aa:
            r6 = r3
        L_0x00ab:
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x008d
            r8.remove()
            goto L_0x008d
        L_0x00b5:
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            com.microtech.aidexx.ui.pair.TransmitterAdapter r5 = r8.transmitterAdapter
            if (r5 != 0) goto L_0x00c3
            java.lang.String r5 = "transmitterAdapter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r5 = r3
        L_0x00c3:
            boolean r5 = r5.isShowingMore()
            r8.refreshTransList(r5)
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            androidx.viewbinding.ViewBinding r8 = r8.getBinding()
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r8 = (com.microtech.aidexx.databinding.ActivityTransmitterBinding) r8
            android.widget.TextView r8 = r8.noDevice
            java.lang.String r5 = "noDevice"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            android.view.View r8 = (android.view.View) r8
            com.microtech.aidexx.ui.pair.TransmitterActivity r5 = r7.this$0
            java.util.List r5 = r5.availableTransmitterList
            if (r5 != 0) goto L_0x00e7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r5 = r3
        L_0x00e7:
            boolean r4 = r5.isEmpty()
            if (r4 == 0) goto L_0x0103
            com.microtech.aidexx.ui.pair.TransmitterActivity r4 = r7.this$0
            java.util.List r4 = r4.unavailableTransmitterList
            if (r4 != 0) goto L_0x00fb
            java.lang.String r4 = "unavailableTransmitterList"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r3
        L_0x00fb:
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0103
            r4 = r2
            goto L_0x0104
        L_0x0103:
            r4 = r1
        L_0x0104:
            if (r4 == 0) goto L_0x0108
            r4 = r1
            goto L_0x0109
        L_0x0108:
            r4 = r0
        L_0x0109:
            r8.setVisibility(r4)
        L_0x010c:
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            androidx.viewbinding.ViewBinding r8 = r8.getBinding()
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r8 = (com.microtech.aidexx.databinding.ActivityTransmitterBinding) r8
            android.widget.TextView r8 = r8.tvPlsSelectTrans
            r8.setVisibility(r0)
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            androidx.viewbinding.ViewBinding r8 = r8.getBinding()
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r8 = (com.microtech.aidexx.databinding.ActivityTransmitterBinding) r8
            com.microtech.aidexx.databinding.ItemTransmitterBinding r8 = r8.layoutMyTrans
            androidx.constraintlayout.widget.ConstraintLayout r8 = r8.getRoot()
            r8.setVisibility(r1)
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            androidx.viewbinding.ViewBinding r8 = r8.getBinding()
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r8 = (com.microtech.aidexx.databinding.ActivityTransmitterBinding) r8
            com.microtech.aidexx.databinding.ItemTransmitterBinding r8 = r8.layoutMyTrans
            android.widget.TextView r8 = r8.tvSn
            com.microtech.aidexx.ui.pair.TransmitterActivity r0 = r7.this$0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.microtech.aidexx.db.entity.TransmitterEntity r5 = r0.transmitter
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.String r5 = r5.getDeviceName()
            r4.append(r5)
            java.lang.String r5 = "-"
            r4.append(r5)
            com.microtech.aidexx.db.entity.TransmitterEntity r0 = r0.transmitter
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getDeviceSn()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r4 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            androidx.viewbinding.ViewBinding r8 = r8.getBinding()
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r8 = (com.microtech.aidexx.databinding.ActivityTransmitterBinding) r8
            com.microtech.aidexx.databinding.ItemTransmitterBinding r8 = r8.layoutMyTrans
            android.widget.TextView r8 = r8.tvTransPairState
            r8.setVisibility(r1)
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            com.microtech.aidexx.db.entity.TransmitterEntity r8 = r8.transmitter
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            byte[] r8 = r8.getEncryptionKey()
            if (r8 != 0) goto L_0x01a4
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            androidx.viewbinding.ViewBinding r8 = r8.getBinding()
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r8 = (com.microtech.aidexx.databinding.ActivityTransmitterBinding) r8
            com.microtech.aidexx.databinding.ItemTransmitterBinding r8 = r8.layoutMyTrans
            android.widget.TextView r8 = r8.tvTransPairState
            com.microtech.aidexx.ui.pair.TransmitterActivity r0 = r7.this$0
            int r1 = com.microtech.aidexx.R.string.ble_state_unpaired
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
            goto L_0x01bd
        L_0x01a4:
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            androidx.viewbinding.ViewBinding r8 = r8.getBinding()
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r8 = (com.microtech.aidexx.databinding.ActivityTransmitterBinding) r8
            com.microtech.aidexx.databinding.ItemTransmitterBinding r8 = r8.layoutMyTrans
            android.widget.TextView r8 = r8.tvTransPairState
            com.microtech.aidexx.ui.pair.TransmitterActivity r0 = r7.this$0
            int r1 = com.microtech.aidexx.R.string.ble_state_paired
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x01bd:
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            com.microtech.aidexx.db.entity.TransmitterEntity r8 = r8.transmitter
            if (r8 == 0) goto L_0x01d3
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            com.microtech.aidexx.db.entity.TransmitterEntity r8 = r8.transmitter
            if (r8 == 0) goto L_0x01d1
            byte[] r3 = r8.getEncryptionKey()
        L_0x01d1:
            if (r3 != 0) goto L_0x01e9
        L_0x01d3:
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            boolean r8 = r8.scanStarted
            if (r8 != 0) goto L_0x01e9
            com.microtech.aidexx.ble.AidexBleAdapter$Companion r8 = com.microtech.aidexx.ble.AidexBleAdapter.Companion
            com.microtech.aidexx.ble.AidexBleAdapter r8 = r8.getInstance()
            r8.startBtScan((boolean) r2)
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            r8.scanStarted = r2
        L_0x01e9:
            com.microtech.aidexx.ui.pair.TransmitterActivity r8 = r7.this$0
            r8.deviceDiscover()
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.pair.TransmitterActivity$refreshMine$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
