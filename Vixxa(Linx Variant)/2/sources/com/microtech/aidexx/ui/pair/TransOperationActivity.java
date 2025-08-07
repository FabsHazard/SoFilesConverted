package com.microtech.aidexx.ui.pair;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.ActivityTransOperationBinding;
import com.microtech.aidexx.utils.eventbus.CgmDataState;
import com.microtech.aidexx.utils.eventbus.DataChangedType;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.controller.BleControllerInfo;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/ui/pair/TransOperationActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityTransOperationBinding;", "()V", "deleteLineHole", "", "getViewBinding", "initEvents", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransOperationActivity.kt */
public final class TransOperationActivity extends BaseActivity<BaseViewModel, ActivityTransOperationBinding> {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityTransOperationBinding) getBinding()).getRoot());
        initView();
        initEvents();
    }

    private final void initEvents() {
        EventBusManager.INSTANCE.onReceive(new String[]{EventBusKey.EVENT_PAIR_RESULT, EventBusKey.EVENT_UNPAIR_RESULT}, (LifecycleOwner) this, new TransOperationActivity$initEvents$1(this));
    }

    private final void initView() {
        ExtendsKt.setDebounceClickListener$default(((ActivityTransOperationBinding) getBinding()).actionbarTransOperation.getLeftIcon(), 0, new TransOperationActivity$$ExternalSyntheticLambda0(this), 1, (Object) null);
        LinearLayout linearLayout = ((ActivityTransOperationBinding) getBinding()).llForceDelete;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llForceDelete");
        linearLayout.setVisibility(!ExtendsKt.isGp() ? 0 : 8);
        BleControllerInfo bleControllerInfo = (BleControllerInfo) getIntent().getParcelableExtra(TransmitterActivityKt.BLE_INFO);
        ((ActivityTransOperationBinding) getBinding()).actionbarTransOperation.setTitle(bleControllerInfo != null ? bleControllerInfo.sn : null);
        int intExtra = getIntent().getIntExtra(TransmitterActivityKt.OPERATION_TYPE, 0);
        if (intExtra == 1) {
            ((ActivityTransOperationBinding) getBinding()).llUnpair.setVisibility(8);
        } else if (intExtra == 2) {
            ((ActivityTransOperationBinding) getBinding()).llPair.setVisibility(8);
        }
        TextView textView = ((ActivityTransOperationBinding) getBinding()).tvPair;
        Intrinsics.checkNotNullExpressionValue(textView, "tvPair");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new TransOperationActivity$$ExternalSyntheticLambda1(this), 1, (Object) null);
        TextView textView2 = ((ActivityTransOperationBinding) getBinding()).tvUnpair;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvUnpair");
        ExtendsKt.setDebounceClickListener$default(textView2, 0, new TransOperationActivity$$ExternalSyntheticLambda2(this), 1, (Object) null);
        TextView textView3 = ((ActivityTransOperationBinding) getBinding()).tvForceDelete;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvForceDelete");
        ExtendsKt.setDebounceClickListener$default(textView3, 0, new TransOperationActivity$$ExternalSyntheticLambda3(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(TransOperationActivity transOperationActivity, View view) {
        Intrinsics.checkNotNullParameter(transOperationActivity, "this$0");
        transOperationActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(TransOperationActivity transOperationActivity, View view) {
        Intrinsics.checkNotNullParameter(transOperationActivity, "this$0");
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        BleControllerProxy controller = deviceModel != null ? deviceModel.getController() : null;
        if (controller != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(transOperationActivity), (CoroutineContext) null, (CoroutineStart) null, new TransOperationActivity$initView$2$1$1(transOperationActivity, controller, (Continuation<? super TransOperationActivity$initView$2$1$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(TransOperationActivity transOperationActivity, View view) {
        Intrinsics.checkNotNullParameter(transOperationActivity, "this$0");
        PairUtil.INSTANCE.startUnpair(transOperationActivity, false);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$4(TransOperationActivity transOperationActivity, View view) {
        Intrinsics.checkNotNullParameter(transOperationActivity, "this$0");
        Dialogs.showWhether$default(Dialogs.INSTANCE, transOperationActivity, (String) null, transOperationActivity.getString(R.string.com_delete_confirm), new TransOperationActivity$initView$4$1(transOperationActivity), (Function0) null, (String) null, (String) null, (String) null, 0, 498, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void deleteLineHole() {
        EventBusManager.INSTANCE.send(EventBusKey.EVENT_DATA_STATE_CHANGED, new Pair(DataChangedType.DATA_STATE_DELETE, new CgmDataState((Long) null, (Float) null, UserInfoManager.Companion.instance().userId(), 3, (DefaultConstructorMarker) null)));
    }

    public ActivityTransOperationBinding getViewBinding() {
        ActivityTransOperationBinding inflate = ActivityTransOperationBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
