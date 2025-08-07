package com.microtech.aidexx.ui.main.home.followers;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Looper;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ble.MessageDistributor;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.ActivityFollowListBinding;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.ui.setting.share.CgmDevice;
import com.microtech.aidexx.ui.setting.share.ShareFollowActivity;
import com.microtech.aidexx.ui.setting.share.ShareFollowViewModel;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import com.microtech.aidexx.ui.setting.share.UserTrendInfo;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0010\u0013\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0003H\u0016J\u0016\u0010)\u001a\u00020$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\b\u0010-\u001a\u00020$H\u0002J\u0012\u0010.\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020$H\u0014J\b\u00102\u001a\u00020$H\u0014J\u0017\u00103\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0002\u00105J\b\u00106\u001a\u00020$H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/followers/FollowSwitchActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityFollowListBinding;", "()V", "countTimer", "Landroid/os/CountDownTimer;", "getCountTimer", "()Landroid/os/CountDownTimer;", "setCountTimer", "(Landroid/os/CountDownTimer;)V", "fixedRateToGetFollowListJob", "Lkotlinx/coroutines/Job;", "followListAdapter", "Lcom/microtech/aidexx/ui/main/home/followers/FollowListAdapter;", "handler", "com/microtech/aidexx/ui/main/home/followers/FollowSwitchActivity$handler$1", "Lcom/microtech/aidexx/ui/main/home/followers/FollowSwitchActivity$handler$1;", "mObserver", "com/microtech/aidexx/ui/main/home/followers/FollowSwitchActivity$mObserver$1", "Lcom/microtech/aidexx/ui/main/home/followers/FollowSwitchActivity$mObserver$1;", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "getRotateAnimation", "()Landroid/view/animation/RotateAnimation;", "setRotateAnimation", "(Landroid/view/animation/RotateAnimation;)V", "shareVm", "Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "getShareVm", "()Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "shareVm$delegate", "Lkotlin/Lazy;", "timer", "Ljava/util/Timer;", "clearWarmUpState", "", "createTimer", "remain", "", "getViewBinding", "initData", "dataList", "", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "initEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "startWarmUpAnim", "timeOffset", "(Ljava/lang/Integer;)V", "updateMySelfInfo", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FollowSwitchActivity.kt */
public final class FollowSwitchActivity extends BaseActivity<BaseViewModel, ActivityFollowListBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_LIST_DATA = "EXTRA_LIST_DATA";
    private CountDownTimer countTimer;
    private Job fixedRateToGetFollowListJob;
    /* access modifiers changed from: private */
    public FollowListAdapter followListAdapter;
    /* access modifiers changed from: private */
    public final FollowSwitchActivity$handler$1 handler = new FollowSwitchActivity$handler$1(this, Looper.getMainLooper());
    private final FollowSwitchActivity$mObserver$1 mObserver = new FollowSwitchActivity$mObserver$1(this);
    private RotateAnimation rotateAnimation;
    private final Lazy shareVm$delegate;
    private Timer timer;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: FollowSwitchActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend[] r0 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.FAST_UP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.UP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.SLOW_UP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity.WhenMappings.<clinit>():void");
        }
    }

    public FollowSwitchActivity() {
        ComponentActivity componentActivity = this;
        this.shareVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ShareFollowViewModel.class), new FollowSwitchActivity$special$$inlined$viewModels$default$2(componentActivity), new FollowSwitchActivity$special$$inlined$viewModels$default$1(componentActivity), new FollowSwitchActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/followers/FollowSwitchActivity$Companion;", "", "()V", "EXTRA_LIST_DATA", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: FollowSwitchActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final ShareFollowViewModel getShareVm() {
        return (ShareFollowViewModel) this.shareVm$delegate.getValue();
    }

    public ActivityFollowListBinding getViewBinding() {
        ActivityFollowListBinding inflate = ActivityFollowListBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        if (((java.util.ArrayList) r1) == null) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            androidx.viewbinding.ViewBinding r5 = r4.getBinding()
            com.microtech.aidexx.databinding.ActivityFollowListBinding r5 = (com.microtech.aidexx.databinding.ActivityFollowListBinding) r5
            androidx.constraintlayout.widget.ConstraintLayout r5 = r5.getRoot()
            android.view.View r5 = (android.view.View) r5
            r4.setContentView((android.view.View) r5)
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            java.lang.String r1 = "EXTRA_LIST_DATA"
            if (r5 < r0) goto L_0x0025
            android.content.Intent r5 = r4.getIntent()
            java.lang.Class<com.microtech.aidexx.ui.setting.share.ShareUserInfo> r0 = com.microtech.aidexx.ui.setting.share.ShareUserInfo.class
            java.util.ArrayList r5 = r5.getParcelableArrayListExtra(r1, r0)
            goto L_0x002d
        L_0x0025:
            android.content.Intent r5 = r4.getIntent()
            java.util.ArrayList r5 = r5.getParcelableArrayListExtra(r1)
        L_0x002d:
            r0 = 0
            if (r5 == 0) goto L_0x003e
            r1 = r5
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x003a
            r1 = r0
        L_0x003a:
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            if (r1 != 0) goto L_0x0043
        L_0x003e:
            r4.finish()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0043:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.List r5 = kotlin.collections.CollectionsKt.toList(r5)
            r4.initData(r5)
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            r1 = 0
            java.util.Timer r0 = kotlin.concurrent.TimersKt.timer(r0, r1)
            com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity$onCreate$$inlined$fixedRateTimer$default$1 r1 = new com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity$onCreate$$inlined$fixedRateTimer$default$1
            r1.<init>(r4)
            java.util.TimerTask r1 = (java.util.TimerTask) r1
            r2 = 60000(0xea60, double:2.9644E-319)
            r0.scheduleAtFixedRate(r1, r5, r2)
            r4.timer = r0
            r4.initEvent()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MessageDistributor.Companion.instance().observer(this.mObserver);
        Job job = this.fixedRateToGetFollowListJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.fixedRateToGetFollowListJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new FollowSwitchActivity$onResume$1(this, (Continuation<? super FollowSwitchActivity$onResume$1>) null), 3, (Object) null);
        ActivityFollowListBinding activityFollowListBinding = (ActivityFollowListBinding) getBinding();
        if (!MmkvManager.INSTANCE.isAlreadyShowFollowersGuide()) {
            ((ActivityFollowListBinding) getBinding()).clShadow.setVisibility(0);
            activityFollowListBinding.clShadow.setOnClickListener(new FollowSwitchActivity$$ExternalSyntheticLambda3(activityFollowListBinding));
            MmkvManager.INSTANCE.setAlreadyShowFollowersGuide();
            return;
        }
        activityFollowListBinding.clShadow.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$3$lambda$2(ActivityFollowListBinding activityFollowListBinding, View view) {
        Intrinsics.checkNotNullParameter(activityFollowListBinding, "$this_apply");
        activityFollowListBinding.clShadow.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Timer timer2 = this.timer;
        if (timer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
            timer2 = null;
        }
        timer2.cancel();
        CountDownTimer countDownTimer = this.countTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        ((ActivityFollowListBinding) getBinding()).myCountInfo.bgPanelWarmUp.clearAnimation();
        MessageDistributor.Companion.instance().removeObserver(this.mObserver);
    }

    private final void initData(List<ShareUserInfo> list) {
        Context context = this;
        FollowListAdapter followListAdapter2 = new FollowListAdapter(context);
        this.followListAdapter = followListAdapter2;
        followListAdapter2.setOnSelectChange(new FollowSwitchActivity$initData$1(this));
        ActivityFollowListBinding activityFollowListBinding = (ActivityFollowListBinding) getBinding();
        activityFollowListBinding.actionBar.getLeftIcon().setOnClickListener(new FollowSwitchActivity$$ExternalSyntheticLambda0(this));
        updateMySelfInfo();
        ConstraintLayout root = activityFollowListBinding.myCountInfo.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ExtendsKt.setDebounceClickListener$default(root, 0, new FollowSwitchActivity$$ExternalSyntheticLambda1(this), 1, (Object) null);
        ImageButton imageButton = activityFollowListBinding.ibToShareFollowPage;
        Intrinsics.checkNotNullExpressionValue(imageButton, "ibToShareFollowPage");
        ExtendsKt.setDebounceClickListener$default(imageButton, 0, new FollowSwitchActivity$$ExternalSyntheticLambda2(this), 1, (Object) null);
        activityFollowListBinding.rvFollowList.setLayoutManager(new LinearLayoutManager(context));
        activityFollowListBinding.rvFollowList.addItemDecoration(new FollowSwitchActivity$initData$2$4());
        RecyclerView recyclerView = activityFollowListBinding.rvFollowList;
        FollowListAdapter followListAdapter3 = this.followListAdapter;
        FollowListAdapter followListAdapter4 = null;
        if (followListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followListAdapter");
            followListAdapter3 = null;
        }
        recyclerView.setAdapter(followListAdapter3);
        FollowListAdapter followListAdapter5 = this.followListAdapter;
        if (followListAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followListAdapter");
        } else {
            followListAdapter4 = followListAdapter5;
        }
        followListAdapter4.refreshData(list);
    }

    /* access modifiers changed from: private */
    public static final void initData$lambda$7$lambda$4(FollowSwitchActivity followSwitchActivity, View view) {
        Intrinsics.checkNotNullParameter(followSwitchActivity, "this$0");
        followSwitchActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initData$lambda$7$lambda$5(FollowSwitchActivity followSwitchActivity, View view) {
        FollowSwitchActivity followSwitchActivity2 = followSwitchActivity;
        Intrinsics.checkNotNullParameter(followSwitchActivity2, "this$0");
        if (UserInfoManager.Companion.getShareUserInfo() != null) {
            FollowListAdapter followListAdapter2 = null;
            UserInfoManager.Companion.setShareUserInfo((ShareUserInfo) null);
            ShareUserInfo shareUserInfo = new ShareUserInfo((String) null, (UserTrendInfo) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (UserEntity) null, (CgmDevice) null, (SettingsEntity) null, 32767, (DefaultConstructorMarker) null);
            shareUserInfo.setDataProviderId(UserInfoManager.Companion.instance().userId());
            EventBusManager.INSTANCE.send(EventBusKey.EVENT_SWITCH_USER, shareUserInfo);
            FollowListAdapter followListAdapter3 = followSwitchActivity2.followListAdapter;
            if (followListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("followListAdapter");
            } else {
                followListAdapter2 = followListAdapter3;
            }
            followListAdapter2.unselectAll();
            followSwitchActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void initData$lambda$7$lambda$6(FollowSwitchActivity followSwitchActivity, View view) {
        Intrinsics.checkNotNullParameter(followSwitchActivity, "this$0");
        ActivityUtil.INSTANCE.toActivity(followSwitchActivity, ShareFollowActivity.class);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02d3, code lost:
        if (r1 == null) goto L_0x02d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0141, code lost:
        if (r9 != null) goto L_0x014e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateMySelfInfo() {
        /*
            r14 = this;
            androidx.viewbinding.ViewBinding r0 = r14.getBinding()
            com.microtech.aidexx.databinding.ActivityFollowListBinding r0 = (com.microtech.aidexx.databinding.ActivityFollowListBinding) r0
            com.microtech.aidexx.databinding.LayoutFollowListItemBinding r0 = r0.myCountInfo
            android.widget.TextView r1 = r0.userName
            com.microtech.aidexx.common.user.UserInfoManager$Companion r2 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r2 = r2.instance()
            java.lang.String r2 = r2.getDisplayName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            android.widget.ImageView r1 = r0.ivSelected
            java.lang.String r2 = "ivSelected"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.view.View r1 = (android.view.View) r1
            com.microtech.aidexx.common.user.UserInfoManager$Companion r2 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.ui.setting.share.ShareUserInfo r2 = r2.getShareUserInfo()
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x002e
            r2 = r4
            goto L_0x002f
        L_0x002e:
            r2 = r3
        L_0x002f:
            r5 = 8
            if (r2 == 0) goto L_0x0035
            r2 = r3
            goto L_0x0036
        L_0x0035:
            r2 = r5
        L_0x0036:
            r1.setVisibility(r2)
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r1 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r1 = r1.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r1 = r1.getDefault()
            r2 = 0
            if (r1 == 0) goto L_0x004b
            java.lang.Integer r6 = r1.getMinutesAgo()
            goto L_0x004c
        L_0x004b:
            r6 = r2
        L_0x004c:
            r7 = 2
            if (r6 == 0) goto L_0x00e5
            java.lang.Integer r6 = r1.getMinutesAgo()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r6 = r6.intValue()
            if (r6 < 0) goto L_0x00e5
            r8 = 16
            if (r6 >= r8) goto L_0x00e5
            boolean r6 = r1.isWarmingUp()
            if (r6 == 0) goto L_0x007f
            com.microtechmd.blecomm.parser.AidexXHistoryEntity r6 = r1.getLatestHistory()
            if (r6 == 0) goto L_0x0073
            int r6 = r6.timeOffset
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x0074
        L_0x0073:
            r6 = r2
        L_0x0074:
            r14.startWarmUpAnim(r6)
            int r6 = com.microtech.aidexx.R.string.ble_state_sensor_warming
            java.lang.String r6 = r14.getString(r6)
            goto L_0x00e6
        L_0x007f:
            java.util.List r6 = r1.getMalFunctionList()
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x00be
            java.util.List r6 = r1.getMalFunctionList()
            java.lang.Object r6 = r6.get(r3)
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r6 == r7) goto L_0x00b3
            if (r6 == r5) goto L_0x00a8
            r8 = 32
            if (r6 == r8) goto L_0x00a8
            int r6 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r6 = r14.getString(r6)
            goto L_0x00e6
        L_0x00a8:
            android.content.res.Resources r6 = r14.getResources()
            int r8 = com.microtech.aidexx.R.string.ble_state_sensor_error
            java.lang.String r6 = r6.getString(r8)
            goto L_0x00e6
        L_0x00b3:
            android.content.res.Resources r6 = r14.getResources()
            int r8 = com.microtech.aidexx.R.string.ble_state_sensor_batteryLow
            java.lang.String r6 = r6.getString(r8)
            goto L_0x00e6
        L_0x00be:
            com.microtechmd.blecomm.parser.AidexXHistoryEntity r6 = r1.getLatestHistory()
            if (r6 == 0) goto L_0x00e5
            int r8 = r6.isValid
            if (r8 != r4) goto L_0x00e5
            int r6 = r6.status
            if (r6 == r4) goto L_0x00da
            if (r6 == r7) goto L_0x00cf
            goto L_0x00e5
        L_0x00cf:
            android.content.res.Resources r6 = r14.getResources()
            int r8 = com.microtech.aidexx.R.string.ble_state_sensor_error
            java.lang.String r6 = r6.getString(r8)
            goto L_0x00e6
        L_0x00da:
            android.content.res.Resources r6 = r14.getResources()
            int r8 = com.microtech.aidexx.R.string.ble_state_sensor_invalid
            java.lang.String r6 = r6.getString(r8)
            goto L_0x00e6
        L_0x00e5:
            r6 = r2
        L_0x00e6:
            if (r1 == 0) goto L_0x00ef
            boolean r8 = r1.isWarmingUp()
            if (r8 != r4) goto L_0x00ef
            goto L_0x00f2
        L_0x00ef:
            r14.clearWarmUpState()
        L_0x00f2:
            android.widget.TextView r8 = r0.latestValueTime
            if (r6 == 0) goto L_0x00fb
            r9 = r6
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r10 = r3
            goto L_0x015b
        L_0x00fb:
            if (r1 == 0) goto L_0x014c
            java.lang.Integer r9 = r1.getMinutesAgo()
            if (r9 == 0) goto L_0x0144
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            if (r9 != 0) goto L_0x0117
            android.content.res.Resources r9 = r14.getResources()
            int r10 = com.microtech.aidexx.R.string.com_time_ago_justNow
            java.lang.String r9 = r9.getString(r10)
        L_0x0115:
            r10 = r3
            goto L_0x0141
        L_0x0117:
            long r10 = (long) r9
            r12 = 60000(0xea60, double:2.9644E-319)
            long r10 = r10 * r12
            com.microtech.aidexx.ui.setting.alert.AlertUtil r12 = com.microtech.aidexx.ui.setting.alert.AlertUtil.INSTANCE
            long r12 = r12.getAlertFrequency()
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x012e
            int r9 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r9 = r14.getString(r9)
            r10 = r4
            goto L_0x0141
        L_0x012e:
            android.content.res.Resources r10 = r14.getResources()
            int r11 = com.microtech.aidexx.R.string.com_time_ago_minute
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            java.lang.String r9 = r10.getString(r11, r9)
            goto L_0x0115
        L_0x0141:
            if (r9 != 0) goto L_0x014e
            goto L_0x0145
        L_0x0144:
            r10 = r3
        L_0x0145:
            int r9 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r9 = r14.getString(r9)
            goto L_0x014e
        L_0x014c:
            r9 = r2
            r10 = r3
        L_0x014e:
            if (r9 == 0) goto L_0x0153
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            goto L_0x015b
        L_0x0153:
            int r9 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r9 = r14.getString(r9)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
        L_0x015b:
            r8.setText(r9)
            if (r10 != 0) goto L_0x016e
            if (r6 != 0) goto L_0x016e
            if (r1 == 0) goto L_0x0169
            boolean r6 = r1.isWarmingUp()
            goto L_0x016a
        L_0x0169:
            r6 = r3
        L_0x016a:
            if (r6 != 0) goto L_0x016e
            r6 = r4
            goto L_0x016f
        L_0x016e:
            r6 = r3
        L_0x016f:
            android.view.View r8 = r0.bgPanelWarmUp
            java.lang.String r9 = "bgPanelWarmUp"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            int r8 = r8.getVisibility()
            java.lang.String r9 = "getString(...)"
            if (r8 != 0) goto L_0x017f
            goto L_0x01b0
        L_0x017f:
            android.widget.TextView r8 = r0.tvGlucoseValue
            if (r6 == 0) goto L_0x01a5
            if (r1 == 0) goto L_0x0199
            java.lang.Float r10 = r1.getGlucose()
            if (r10 == 0) goto L_0x0199
            float r10 = r10.floatValue()
            android.content.res.Resources r11 = r14.getResources()
            java.lang.String r10 = com.microtech.aidexx.utils.GlucoseUtilKt.toGlucoseStringWithLowAndHigh(r10, r11)
            if (r10 != 0) goto L_0x01a2
        L_0x0199:
            int r10 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r10 = r14.getString(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r9)
        L_0x01a2:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            goto L_0x01ad
        L_0x01a5:
            int r10 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r10 = r14.getString(r10)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
        L_0x01ad:
            r8.setText(r10)
        L_0x01b0:
            android.widget.TextView r8 = r0.tvUnit
            java.lang.String r10 = "tvUnit"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            android.view.View r8 = (android.view.View) r8
            r8.setVisibility(r5)
            android.widget.TextView r5 = r0.tvUnit
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)
            android.view.View r5 = (android.view.View) r5
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L_0x01ca
            r3 = r4
        L_0x01ca:
            if (r3 == 0) goto L_0x01d9
            android.widget.TextView r3 = r0.tvUnit
            com.microtech.aidexx.utils.UnitManager r5 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            java.lang.String r5 = r5.getDisplayUnit()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setText(r5)
        L_0x01d9:
            r3 = -1
            r5 = 0
            if (r6 == 0) goto L_0x0234
            if (r1 == 0) goto L_0x021c
            android.view.View r6 = r0.bgPanel
            com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r8 = r1.getGlucoseTrend()
            if (r8 != 0) goto L_0x01e9
            r8 = r3
            goto L_0x01f1
        L_0x01e9:
            int[] r10 = com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r10[r8]
        L_0x01f1:
            if (r8 == r4) goto L_0x01fd
            if (r8 == r7) goto L_0x01fd
            r7 = 3
            if (r8 == r7) goto L_0x01fa
            r7 = r5
            goto L_0x01ff
        L_0x01fa:
            r7 = -1028390912(0xffffffffc2b40000, float:-90.0)
            goto L_0x01ff
        L_0x01fd:
            r7 = 1127481344(0x43340000, float:180.0)
        L_0x01ff:
            r6.setRotation(r7)
            android.view.View r6 = r0.bgPanel
            com.microtech.aidexx.ui.main.home.HomeBackGroundSelector$Companion r7 = com.microtech.aidexx.ui.main.home.HomeBackGroundSelector.Companion
            com.microtech.aidexx.ui.main.home.HomeBackGroundSelector r7 = r7.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r8 = r1.getGlucoseTrend()
            com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel r10 = r1.getGlucoseLevel()
            int r7 = r7.getBgForTrend(r8, r10)
            r6.setBackgroundResource(r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            goto L_0x021d
        L_0x021c:
            r6 = r2
        L_0x021d:
            if (r6 != 0) goto L_0x0248
            android.view.View r6 = r0.bgPanel
            r6.setRotation(r5)
            android.view.View r5 = r0.bgPanel
            com.microtech.aidexx.ui.main.home.HomeBackGroundSelector$Companion r6 = com.microtech.aidexx.ui.main.home.HomeBackGroundSelector.Companion
            com.microtech.aidexx.ui.main.home.HomeBackGroundSelector r6 = r6.instance()
            int r2 = r6.getBgForTrend(r2, r2)
            r5.setBackgroundResource(r2)
            goto L_0x0248
        L_0x0234:
            android.view.View r6 = r0.bgPanel
            r6.setRotation(r5)
            android.view.View r5 = r0.bgPanel
            com.microtech.aidexx.ui.main.home.HomeBackGroundSelector$Companion r6 = com.microtech.aidexx.ui.main.home.HomeBackGroundSelector.Companion
            com.microtech.aidexx.ui.main.home.HomeBackGroundSelector r6 = r6.instance()
            int r2 = r6.getBgForTrend(r2, r2)
            r5.setBackgroundResource(r2)
        L_0x0248:
            android.widget.TextView r0 = r0.leftTime
            if (r1 == 0) goto L_0x02f8
            boolean r2 = r1.isPaired()
            if (r2 != 0) goto L_0x0254
            goto L_0x02f8
        L_0x0254:
            java.lang.Integer r2 = r1.getSensorRemainingTime()
            java.lang.String r5 = "format(...)"
            if (r2 == 0) goto L_0x02d5
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r2 != r3) goto L_0x026f
            android.content.res.Resources r1 = r14.getResources()
            int r2 = com.microtech.aidexx.R.string.ble_state_sensor_expired
            java.lang.String r1 = r1.getString(r2)
            goto L_0x02d3
        L_0x026f:
            com.microtech.aidexx.db.entity.TransmitterEntity r1 = r1.getEntity()
            int r1 = r1.getExpirationTime()
            r3 = 24
            int r1 = r1 * r3
            if (r2 > r1) goto L_0x02b3
            java.math.BigDecimal r1 = new java.math.BigDecimal
            r1.<init>(r2)
            java.math.BigDecimal r2 = new java.math.BigDecimal
            r2.<init>(r3)
            java.math.RoundingMode r3 = java.math.RoundingMode.CEILING
            java.math.BigDecimal r1 = r1.divide(r2, r3)
            int r1 = r1.intValue()
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            android.content.res.Resources r2 = r14.getResources()
            int r3 = com.microtech.aidexx.R.string.com_time_remain_day
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r4)
            java.lang.String r1 = java.lang.String.format(r2, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            goto L_0x02d3
        L_0x02b3:
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            int r1 = com.microtech.aidexx.R.string.com_time_remain_day
            java.lang.String r1 = r14.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)
            int r2 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r2 = r14.getString(r2)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)
            java.lang.String r1 = java.lang.String.format(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
        L_0x02d3:
            if (r1 != 0) goto L_0x02f5
        L_0x02d5:
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            int r1 = com.microtech.aidexx.R.string.com_time_remain_day
            java.lang.String r1 = r14.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)
            int r2 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r2 = r14.getString(r2)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)
            java.lang.String r1 = java.lang.String.format(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
        L_0x02f5:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x0300
        L_0x02f8:
            int r1 = com.microtech.aidexx.R.string.ble_state_unpaired
            java.lang.String r1 = r14.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0300:
            r0.setText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity.updateMySelfInfo():void");
    }

    private final void initEvent() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new FollowSwitchActivity$initEvent$1(this, (Continuation<? super FollowSwitchActivity$initEvent$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void createTimer(int i) {
        if (i > 1) {
            long minutesToMillis = ExtendsKt.minutesToMillis(i);
            CountDownTimer countDownTimer = this.countTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            CountDownTimer followSwitchActivity$createTimer$1 = new FollowSwitchActivity$createTimer$1(minutesToMillis, this);
            this.countTimer = followSwitchActivity$createTimer$1;
            followSwitchActivity$createTimer$1.start();
            return;
        }
        CountDownTimer countDownTimer2 = this.countTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
    }

    private final void clearWarmUpState() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new FollowSwitchActivity$clearWarmUpState$1(this, (Continuation<? super FollowSwitchActivity$clearWarmUpState$1>) null), 3, (Object) null);
    }

    public final CountDownTimer getCountTimer() {
        return this.countTimer;
    }

    public final void setCountTimer(CountDownTimer countDownTimer) {
        this.countTimer = countDownTimer;
    }

    public final RotateAnimation getRotateAnimation() {
        return this.rotateAnimation;
    }

    public final void setRotateAnimation(RotateAnimation rotateAnimation2) {
        this.rotateAnimation = rotateAnimation2;
    }

    /* access modifiers changed from: private */
    public final void startWarmUpAnim(Integer num) {
        View view = ((ActivityFollowListBinding) getBinding()).myCountInfo.bgPanelWarmUp;
        Intrinsics.checkNotNullExpressionValue(view, "bgPanelWarmUp");
        if (view.getVisibility() == 0) {
            if (num != null) {
                ((ActivityFollowListBinding) getBinding()).myCountInfo.tvGlucoseValue.setText(String.valueOf(60 - num.intValue()));
            }
        } else if (num != null) {
            int intValue = num.intValue();
            RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.rotateAnimation = rotateAnimation2;
            rotateAnimation2.setDuration(1500);
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
                rotateAnimation5.setFillAfter(true);
            }
            ((ActivityFollowListBinding) getBinding()).myCountInfo.bgPanelWarmUp.startAnimation(this.rotateAnimation);
            ((ActivityFollowListBinding) getBinding()).myCountInfo.tvGlucoseValue.setText(String.valueOf(60 - intValue));
            View view2 = ((ActivityFollowListBinding) getBinding()).myCountInfo.bgPanelWarmUp;
            Intrinsics.checkNotNullExpressionValue(view2, "bgPanelWarmUp");
            view2.setVisibility(0);
        }
    }
}
