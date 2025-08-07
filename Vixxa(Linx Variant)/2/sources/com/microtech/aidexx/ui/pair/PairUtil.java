package com.microtech.aidexx.ui.pair;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.MessageDistributor;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.ble.device.model.DeviceModelKt;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.controller.BleController;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002-.B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001fJ\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J!\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020(H@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010+\u001a\u00020\fJ\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/microtech/aidexx/ui/pair/PairUtil;", "", "()V", "DISMISS_DIALOG", "", "TIMEOUT_MILLIS", "", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "isBonding", "", "isForceDelete", "()Z", "setForceDelete", "(Z)V", "operation", "Lcom/microtech/aidexx/ui/pair/PairUtil$Operation;", "getOperation", "()Lcom/microtech/aidexx/ui/pair/PairUtil$Operation;", "setOperation", "(Lcom/microtech/aidexx/ui/pair/PairUtil$Operation;)V", "receiver", "Landroid/content/BroadcastReceiver;", "transmitterOperateComplete", "checkSn", "sn", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeMessage", "", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "operationFail", "registerBondStateChangeReceiver", "startPair", "proxy", "Lcom/microtechmd/blecomm/controller/BleControllerProxy;", "(Landroid/content/Context;Lcom/microtechmd/blecomm/controller/BleControllerProxy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUnpair", "isForce", "unregisterBondStateChangeReceiver", "BondStateReceiver", "Operation", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairUtil.kt */
public final class PairUtil {
    public static final int DISMISS_DIALOG = 1;
    public static final PairUtil INSTANCE = new PairUtil();
    private static final long TIMEOUT_MILLIS = 30000;
    private static final Handler handler = new PairUtil$handler$1(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static boolean isBonding;
    private static boolean isForceDelete;
    private static Operation operation;
    private static BroadcastReceiver receiver;
    /* access modifiers changed from: private */
    public static boolean transmitterOperateComplete;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairUtil.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.microtech.aidexx.ui.pair.PairUtil$Operation[] r0 = com.microtech.aidexx.ui.pair.PairUtil.Operation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.ui.pair.PairUtil$Operation r1 = com.microtech.aidexx.ui.pair.PairUtil.Operation.PAIR     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.ui.pair.PairUtil$Operation r1 = com.microtech.aidexx.ui.pair.PairUtil.Operation.UNPAIR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.pair.PairUtil.WhenMappings.<clinit>():void");
        }
    }

    private PairUtil() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/ui/pair/PairUtil$Operation;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "PAIR", "UNPAIR", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairUtil.kt */
    public enum Operation {
        PAIR("Pair"),
        UNPAIR("Unpair");
        
        private final String desc;

        public static EnumEntries<Operation> getEntries() {
            return $ENTRIES;
        }

        static {
            Operation[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }

        private Operation(String str) {
            this.desc = str;
        }

        public final String getDesc() {
            return this.desc;
        }
    }

    public final Operation getOperation() {
        return operation;
    }

    public final void setOperation(Operation operation2) {
        operation = operation2;
    }

    public final Handler getHandler() {
        return handler;
    }

    public final boolean isForceDelete() {
        return isForceDelete;
    }

    public final void setForceDelete(boolean z) {
        isForceDelete = z;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/ui/pair/PairUtil$BondStateReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairUtil.kt */
    public static final class BondStateReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            BleController controller;
            if (StringsKt.equals$default(intent != null ? intent.getAction() : null, "android.bluetooth.device.action.BOND_STATE_CHANGED", false, 2, (Object) null)) {
                Intrinsics.checkNotNull(intent);
                switch (intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) {
                    case 10:
                        if (PairUtil.isBonding) {
                            DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
                            if (!(deviceModel == null || (controller = deviceModel.getController()) == null)) {
                                controller.disconnect();
                            }
                            LogUtil.Companion.eAiDEX("BluetoothDevice.BOND_NONE dismissWait");
                            PairUtil pairUtil = PairUtil.INSTANCE;
                            PairUtil.isBonding = false;
                            return;
                        }
                        return;
                    case 11:
                        PairUtil pairUtil2 = PairUtil.INSTANCE;
                        PairUtil.isBonding = true;
                        return;
                    case 12:
                        PairUtil pairUtil3 = PairUtil.INSTANCE;
                        PairUtil.isBonding = false;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void operationFail() {
        handler.removeMessages(1);
        Operation operation2 = operation;
        int i = operation2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[operation2.ordinal()];
        if (i == 1) {
            EventBusManager.INSTANCE.send(EventBusKey.EVENT_PAIR_RESULT, false);
        } else if (i == 2) {
            EventBusManager.INSTANCE.send(EventBusKey.EVENT_UNPAIR_RESULT, false);
        }
    }

    public final void observeMessage(Context context, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        MessageDistributor.Companion.instance().observerAndIntercept(new PairUtil$observeMessage$1(context, coroutineScope));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkSn(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.ui.pair.PairUtil$checkSn$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.ui.pair.PairUtil$checkSn$1 r0 = (com.microtech.aidexx.ui.pair.PairUtil$checkSn$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.pair.PairUtil$checkSn$1 r0 = new com.microtech.aidexx.ui.pair.PairUtil$checkSn$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.common.net.ApiService$Companion r6 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r6 = r6.getInstance()
            r0.label = r3
            java.lang.Object r6 = r6.checkSN(r5, r0)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r0 = 0
            if (r5 == 0) goto L_0x0067
            com.microtech.aidexx.common.net.ApiResult$Success r6 = (com.microtech.aidexx.common.net.ApiResult.Success) r6
            java.lang.Object r5 = r6.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r5 = (com.microtech.aidexx.common.net.entity.BaseResponse) r5
            java.lang.Object r6 = r5.getData()
            if (r6 == 0) goto L_0x006b
            java.lang.Object r5 = r5.getData()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            r0 = r5
            goto L_0x006b
        L_0x0067:
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r5 == 0) goto L_0x0070
        L_0x006b:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r5
        L_0x0070:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.pair.PairUtil.checkSn(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object startPair(Context context, BleControllerProxy bleControllerProxy, Continuation<? super Unit> continuation) {
        transmitterOperateComplete = false;
        if (!NetUtil.isNetAvailable(context)) {
            String string = context.getString(R.string.com_network_unused);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toastShort(string);
            return Unit.INSTANCE;
        }
        bleControllerProxy.getName().equals(DeviceModelKt.NAME_AIDEXX);
        DeviceModel pair = TransmitterManager.Companion.instance().getPair();
        BleController controller = pair != null ? pair.getController() : null;
        if (controller != null) {
            controller.setKey((byte[]) null);
        }
        operation = Operation.PAIR;
        isForceDelete = false;
        Dialogs.INSTANCE.showWait(context.getString(R.string.com_actionState_doing, new Object[]{context.getString(R.string.com_action_pair)}));
        Handler handler2 = handler;
        handler2.removeMessages(1);
        handler2.sendEmptyMessageDelayed(1, 30000);
        DeviceModel buildModel = TransmitterManager.Companion.instance().buildModel(bleControllerProxy, context);
        if (buildModel != null) {
            BleControllerProxy controller2 = buildModel.getController();
            if (controller2 != null) {
                Boxing.boxInt(controller2.pair());
            }
            BleControllerProxy controller3 = buildModel.getController();
            if (controller3 != null) {
                controller3.getTransInfo();
            }
            BleControllerProxy controller4 = buildModel.getController();
            if (controller4 != null) {
                controller4.startTime();
            }
        }
        return Unit.INSTANCE;
    }

    public final void startUnpair(Context context, boolean z) {
        BleControllerProxy controller;
        Intrinsics.checkNotNullParameter(context, "context");
        transmitterOperateComplete = false;
        if (!NetUtil.isNetAvailable(context)) {
            String string = context.getString(R.string.com_network_unused);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toastShort(string);
            LogUtil.Companion.eAiDEX("Network unavailable, can't unpair");
            return;
        }
        if (!z) {
            Dialogs.INSTANCE.showWait(context.getString(R.string.com_actionState_doing, new Object[]{context.getString(R.string.com_action_unpair)}));
            Handler handler2 = handler;
            handler2.removeMessages(1);
            handler2.sendEmptyMessageDelayed(1, 30000);
        }
        operation = Operation.UNPAIR;
        isForceDelete = z;
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel != null && (controller = deviceModel.getController()) != null) {
            controller.clearPair();
        }
    }

    public final void registerBondStateChangeReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        receiver = new BondStateReceiver();
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED");
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(receiver, intentFilter, 4);
        } else {
            context.registerReceiver(receiver, intentFilter);
        }
    }

    public final void unregisterBondStateChangeReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BroadcastReceiver broadcastReceiver = receiver;
        if (broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
                receiver = null;
                Unit unit = Unit.INSTANCE;
            } catch (Exception e) {
                String message = e.getMessage();
                if (message != null) {
                    LogUtil.Companion.eAiDEX(message);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }
}
