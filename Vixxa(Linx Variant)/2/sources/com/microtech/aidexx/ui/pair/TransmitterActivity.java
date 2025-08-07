package com.microtech.aidexx.ui.pair;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ble.AidexBleAdapter;
import com.microtech.aidexx.ble.MessageDistributor;
import com.microtech.aidexx.ble.PendingIntentReceiver;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityTransmitterBinding;
import com.microtech.aidexx.databinding.ScanDeviceTipDialogBinding;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.HistoryDeviceInfo;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.ui.pair.PairUtil;
import com.microtech.aidexx.utils.DensityUtils;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.utils.permission.PermissionsUtil;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.controller.BleController;
import com.microtechmd.blecomm.controller.BleControllerInfo;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import io.objectbox.Box;
import io.objectbox.reactive.DataSubscription;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020\u001bH\u0014J\b\u0010)\u001a\u00020\u001bH\u0014J\b\u0010*\u001a\u00020\u001bH\u0014J\b\u0010+\u001a\u00020\u001bH\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/microtech/aidexx/ui/pair/TransmitterActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityTransmitterBinding;", "()V", "allTransmitterList", "", "Lcom/microtechmd/blecomm/controller/BleControllerProxy;", "availableTransmitterList", "checkPass", "", "historyDevices", "Lcom/microtech/aidexx/db/entity/HistoryDeviceInfo;", "historySubscription", "Lio/objectbox/reactive/DataSubscription;", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "scanStarted", "tranSubscription", "transmitter", "Lcom/microtech/aidexx/db/entity/TransmitterEntity;", "transmitterAdapter", "Lcom/microtech/aidexx/ui/pair/TransmitterAdapter;", "transmitterHandler", "Lcom/microtech/aidexx/ui/pair/TransmitterActivity$TransmitterHandler;", "unavailableTransmitterList", "deviceDiscover", "", "doubleCheck", "controller", "executePair", "proxy", "getViewBinding", "initAnim", "initEvent", "initView", "loadSavedTransmitter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "refreshMine", "refreshTransList", "isShowingMore", "TransmitterHandler", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterActivity.kt */
public final class TransmitterActivity extends BaseActivity<BaseViewModel, ActivityTransmitterBinding> {
    private List<BleControllerProxy> allTransmitterList;
    /* access modifiers changed from: private */
    public List<BleControllerProxy> availableTransmitterList;
    /* access modifiers changed from: private */
    public boolean checkPass;
    /* access modifiers changed from: private */
    public List<HistoryDeviceInfo> historyDevices = new ArrayList();
    private DataSubscription historySubscription;
    private RotateAnimation rotateAnimation;
    /* access modifiers changed from: private */
    public boolean scanStarted;
    private DataSubscription tranSubscription;
    /* access modifiers changed from: private */
    public TransmitterEntity transmitter;
    /* access modifiers changed from: private */
    public TransmitterAdapter transmitterAdapter;
    /* access modifiers changed from: private */
    public TransmitterHandler transmitterHandler;
    /* access modifiers changed from: private */
    public List<BleControllerProxy> unavailableTransmitterList;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/ui/pair/TransmitterActivity$TransmitterHandler;", "Landroid/os/Handler;", "activity", "Lcom/microtech/aidexx/ui/pair/TransmitterActivity;", "(Lcom/microtech/aidexx/ui/pair/TransmitterActivity;)V", "getActivity", "()Lcom/microtech/aidexx/ui/pair/TransmitterActivity;", "reference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "handleMessage", "", "msg", "Landroid/os/Message;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TransmitterActivity.kt */
    public static final class TransmitterHandler extends Handler {
        private final TransmitterActivity activity;
        private final WeakReference<TransmitterActivity> reference;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransmitterHandler(TransmitterActivity transmitterActivity) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(transmitterActivity, "activity");
            this.activity = transmitterActivity;
            this.reference = new WeakReference<>(transmitterActivity);
        }

        public final TransmitterActivity getActivity() {
            return this.activity;
        }

        public void handleMessage(Message message) {
            Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
            TransmitterActivity transmitterActivity = (TransmitterActivity) this.reference.get();
            if (transmitterActivity != null && !transmitterActivity.isFinishing() && message.what == 2004) {
                Dialogs.INSTANCE.dismissWait();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PairUtil.INSTANCE.observeMessage(this, AidexxApp.Companion.getMainScope());
        PairUtil.INSTANCE.setOperation((PairUtil.Operation) null);
        this.checkPass = false;
        setContentView((View) ((ActivityTransmitterBinding) getBinding()).getRoot());
        this.availableTransmitterList = new ArrayList();
        this.unavailableTransmitterList = new ArrayList();
        this.allTransmitterList = new ArrayList();
        this.transmitterHandler = new TransmitterHandler(this);
        initView();
        initEvent();
    }

    private final void initEvent() {
        DeviceModel deviceModel;
        BleController controller;
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_PAIR_RESULT, (LifecycleOwner) this, new TransmitterActivity$initEvent$1(this));
        DeviceModel deviceModel2 = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel2 != null && deviceModel2.isPaired() && AidexBleAdapter.Companion.getInstance().isOnConnectState() && (deviceModel = TransmitterManager.Companion.instance().getDefault()) != null && (controller = deviceModel.getController()) != null) {
            controller.disconnect();
        }
    }

    /* access modifiers changed from: private */
    public final void deviceDiscover() {
        AidexBleAdapter.Companion.getInstance().setOnDeviceDiscover(new TransmitterActivity$deviceDiscover$1(this));
    }

    /* access modifiers changed from: private */
    public final void initAnim() {
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.rotateAnimation = rotateAnimation2;
        rotateAnimation2.setFillAfter(true);
        RotateAnimation rotateAnimation3 = this.rotateAnimation;
        if (rotateAnimation3 != null) {
            rotateAnimation3.setInterpolator(new LinearInterpolator());
        }
        RotateAnimation rotateAnimation4 = this.rotateAnimation;
        if (rotateAnimation4 != null) {
            rotateAnimation4.setRepeatCount(-1);
        }
        RotateAnimation rotateAnimation5 = this.rotateAnimation;
        if (rotateAnimation5 != null) {
            rotateAnimation5.setRepeatMode(1);
        }
        RotateAnimation rotateAnimation6 = this.rotateAnimation;
        if (rotateAnimation6 != null) {
            rotateAnimation6.setDuration(1500);
        }
        ((ActivityTransmitterBinding) getBinding()).ivRefreshScan.startAnimation(this.rotateAnimation);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.checkPass && !PermissionsUtil.INSTANCE.getGoSystemSettingShowing()) {
            checkEnvironment(new TransmitterActivity$onResume$1(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    private final void initView() {
        String string = getString(R.string.ble_history);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.ble_pairList_my_history, new Object[]{string});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CharSequence charSequence = string2;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(getColor(R.color.green_65)), indexOf$default, string.length() + indexOf$default, 33);
        spannableString.setSpan(new AbsoluteSizeSpan((int) DensityUtils.sp2px(15.0f)), indexOf$default, string.length() + indexOf$default, 33);
        spannableString.setSpan(new TransmitterActivity$initView$1(this, getColor(R.color.green_65)), indexOf$default, string.length() + indexOf$default, 33);
        ((ActivityTransmitterBinding) getBinding()).tvHistoryDevice.setText(spannableString);
        ((ActivityTransmitterBinding) getBinding()).tvHistoryDevice.setMovementMethod(LinkMovementMethod.getInstance());
        int i = 0;
        ((ActivityTransmitterBinding) getBinding()).tvHistoryDevice.setHighlightColor(0);
        ExtendsKt.setDebounceClickListener$default(((ActivityTransmitterBinding) getBinding()).actionbarTransmitter.getLeftIcon(), 0, new TransmitterActivity$$ExternalSyntheticLambda2(this), 1, (Object) null);
        Context context = this;
        ((ActivityTransmitterBinding) getBinding()).rvOtherTrans.setLayoutManager(new NoCrashLinerLayoutManager(context));
        TransmitterAdapter transmitterAdapter2 = null;
        ((ActivityTransmitterBinding) getBinding()).rvOtherTrans.setItemAnimator((RecyclerView.ItemAnimator) null);
        TransmitterAdapter transmitterAdapter3 = new TransmitterAdapter(context);
        this.transmitterAdapter = transmitterAdapter3;
        transmitterAdapter3.setOnShowMoreClick(new TransmitterActivity$initView$3(this));
        TransmitterAdapter transmitterAdapter4 = this.transmitterAdapter;
        if (transmitterAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transmitterAdapter");
            transmitterAdapter4 = null;
        }
        transmitterAdapter4.setOnPairClick(new TransmitterActivity$initView$4(this));
        LinearLayout linearLayout = ((ActivityTransmitterBinding) getBinding()).layoutMyTrans.transItem;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "transItem");
        ExtendsKt.setDebounceClickListener$default(linearLayout, 0, new TransmitterActivity$$ExternalSyntheticLambda3(this), 1, (Object) null);
        RecyclerView recyclerView = ((ActivityTransmitterBinding) getBinding()).rvOtherTrans;
        TransmitterAdapter transmitterAdapter5 = this.transmitterAdapter;
        if (transmitterAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transmitterAdapter");
        } else {
            transmitterAdapter2 = transmitterAdapter5;
        }
        recyclerView.setAdapter(transmitterAdapter2);
        ImageView imageView = ((ActivityTransmitterBinding) getBinding()).ivScanningTip;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivScanningTip");
        View view = imageView;
        if (!ExtendsKt.isGp()) {
            i = 8;
        }
        view.setVisibility(i);
        ImageView imageView2 = ((ActivityTransmitterBinding) getBinding()).ivScanningTip;
        Intrinsics.checkNotNullExpressionValue(imageView2, "ivScanningTip");
        ExtendsKt.setDebounceClickListener$default(imageView2, 0, new TransmitterActivity$$ExternalSyntheticLambda4(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(TransmitterActivity transmitterActivity, View view) {
        Intrinsics.checkNotNullParameter(transmitterActivity, "this$0");
        transmitterActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$4(TransmitterActivity transmitterActivity, View view) {
        Intrinsics.checkNotNullParameter(transmitterActivity, "this$0");
        if (transmitterActivity.transmitter != null) {
            Intent intent = new Intent(transmitterActivity, TransOperationActivity.class);
            TransmitterEntity transmitterEntity = transmitterActivity.transmitter;
            if (transmitterEntity != null) {
                intent.putExtra(TransmitterActivityKt.BLE_INFO, new BleControllerInfo(transmitterEntity.getDeviceType(), transmitterEntity.getDeviceMac(), transmitterEntity.getDeviceName(), transmitterEntity.getDeviceSn()));
                TransmitterEntity transmitterEntity2 = transmitterActivity.transmitter;
                if ((transmitterEntity2 != null ? transmitterEntity2.getEncryptionKey() : null) == null) {
                    intent.putExtra(TransmitterActivityKt.OPERATION_TYPE, 1);
                } else {
                    intent.putExtra(TransmitterActivityKt.OPERATION_TYPE, 2);
                }
                transmitterActivity.startActivity(intent);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5(TransmitterActivity transmitterActivity, View view) {
        Intrinsics.checkNotNullParameter(transmitterActivity, "this$0");
        ScanDeviceTipDialogBinding inflate = ScanDeviceTipDialogBinding.inflate(transmitterActivity.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        ConstraintLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        Dialogs.showDialogWithView$default(Dialogs.INSTANCE, transmitterActivity, root, inflate.buttonConfirm, (View) null, 8, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void doubleCheck(BleControllerProxy bleControllerProxy) {
        List<BleControllerProxy> list = this.availableTransmitterList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("availableTransmitterList");
            list = null;
        }
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!((BleControllerProxy) next).isNativePaired()) {
                arrayList.add(next);
            }
        }
        if (((List) arrayList).size() > 1) {
            PairCheckDialog build = new PairCheckDialog(this).build(bleControllerProxy);
            build.setOnPass(new TransmitterActivity$doubleCheck$2(this));
            build.show();
            return;
        }
        executePair(bleControllerProxy);
    }

    /* access modifiers changed from: private */
    public final void executePair(BleControllerProxy bleControllerProxy) {
        TransmitterEntity transmitterEntity = this.transmitter;
        if (transmitterEntity != null) {
            Integer valueOf = transmitterEntity != null ? Integer.valueOf(transmitterEntity.getDeviceType()) : null;
            if ((valueOf == null || valueOf.intValue() != 1) && valueOf != null && valueOf.intValue() == 2) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new TransmitterActivity$executePair$1(this, bleControllerProxy, (Continuation<? super TransmitterActivity$executePair$1>) null), 3, (Object) null);
                return;
            }
            return;
        }
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new TransmitterActivity$executePair$2(this, bleControllerProxy, (Continuation<? super TransmitterActivity$executePair$2>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        RotateAnimation rotateAnimation2 = this.rotateAnimation;
        if (rotateAnimation2 != null) {
            rotateAnimation2.cancel();
        }
        PairUtil.INSTANCE.unregisterBondStateChangeReceiver(this);
        TransmitterHandler transmitterHandler2 = null;
        PairUtil.INSTANCE.getHandler().removeCallbacksAndMessages((Object) null);
        MessageDistributor.Companion.instance().removeObserver();
        ((ActivityTransmitterBinding) getBinding()).ivRefreshScan.clearAnimation();
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if ((deviceModel == null || !deviceModel.isPaired()) && this.scanStarted) {
            AidexBleAdapter.Companion.getInstance().stopBtScan(false);
        }
        TransmitterHandler transmitterHandler3 = this.transmitterHandler;
        if (transmitterHandler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transmitterHandler");
        } else {
            transmitterHandler2 = transmitterHandler3;
        }
        transmitterHandler2.removeMessages(PendingIntentReceiver.REQUEST_CODE);
        DataSubscription dataSubscription = this.tranSubscription;
        if (dataSubscription != null) {
            dataSubscription.cancel();
        }
        DataSubscription dataSubscription2 = this.historySubscription;
        if (dataSubscription2 != null) {
            dataSubscription2.cancel();
        }
        AidexBleAdapter.Companion.getInstance().removeDiscoverCallback();
    }

    public ActivityTransmitterBinding getViewBinding() {
        ActivityTransmitterBinding inflate = ActivityTransmitterBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: private */
    public final void loadSavedTransmitter() {
        this.tranSubscription = ObjectBox.INSTANCE.getStore().subscribe(TransmitterEntity.class).observer(new TransmitterActivity$$ExternalSyntheticLambda0(this));
        Box<HistoryDeviceInfo> historyDeviceBox = ObjectBox.INSTANCE.getHistoryDeviceBox();
        Intrinsics.checkNotNull(historyDeviceBox);
        this.historySubscription = historyDeviceBox.query().build().subscribe().observer(new TransmitterActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void loadSavedTransmitter$lambda$7(TransmitterActivity transmitterActivity, Class cls) {
        Intrinsics.checkNotNullParameter(transmitterActivity, "this$0");
        transmitterActivity.refreshMine();
    }

    /* access modifiers changed from: private */
    public static final void loadSavedTransmitter$lambda$8(TransmitterActivity transmitterActivity, List list) {
        Intrinsics.checkNotNullParameter(transmitterActivity, "this$0");
        Intrinsics.checkNotNull(list);
        transmitterActivity.historyDevices = list;
    }

    private final void refreshMine() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new TransmitterActivity$refreshMine$1(this, (Continuation<? super TransmitterActivity$refreshMine$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void refreshTransList(boolean z) {
        List<BleControllerProxy> list = null;
        if (z) {
            List<BleControllerProxy> list2 = this.allTransmitterList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("allTransmitterList");
                list2 = null;
            }
            list2.clear();
            List<BleControllerProxy> list3 = this.allTransmitterList;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("allTransmitterList");
                list3 = null;
            }
            List<BleControllerProxy> list4 = this.availableTransmitterList;
            if (list4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("availableTransmitterList");
                list4 = null;
            }
            list3.addAll(list4);
            List<BleControllerProxy> list5 = this.allTransmitterList;
            if (list5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("allTransmitterList");
                list5 = null;
            }
            List<BleControllerProxy> list6 = this.unavailableTransmitterList;
            if (list6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unavailableTransmitterList");
                list6 = null;
            }
            list5.addAll(list6);
            TransmitterAdapter transmitterAdapter2 = this.transmitterAdapter;
            if (transmitterAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("transmitterAdapter");
                transmitterAdapter2 = null;
            }
            List<BleControllerProxy> list7 = this.allTransmitterList;
            if (list7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("allTransmitterList");
            } else {
                list = list7;
            }
            transmitterAdapter2.refreshData(list);
            return;
        }
        TransmitterAdapter transmitterAdapter3 = this.transmitterAdapter;
        if (transmitterAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transmitterAdapter");
            transmitterAdapter3 = null;
        }
        List<BleControllerProxy> list8 = this.availableTransmitterList;
        if (list8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("availableTransmitterList");
        } else {
            list = list8;
        }
        transmitterAdapter3.refreshData(list);
    }
}
