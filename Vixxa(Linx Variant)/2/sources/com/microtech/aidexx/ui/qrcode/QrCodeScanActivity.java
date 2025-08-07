package com.microtech.aidexx.ui.qrcode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.huawei.hms.hmsscankit.RemoteView;
import com.huawei.hms.ml.scan.HmsScan;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.ActivityQrCodeScanBinding;
import com.microtech.aidexx.ota.OtaManagerKt;
import com.microtech.aidexx.utils.permission.PermissionGroups;
import com.microtech.aidexx.utils.permission.PermissionsUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u0003H\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\bH\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0014J\b\u0010\u0016\u001a\u00020\u000fH\u0014J\b\u0010\u0017\u001a\u00020\u000fH\u0014J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/microtech/aidexx/ui/qrcode/QrCodeScanActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityQrCodeScanBinding;", "()V", "frameLayout", "Landroid/widget/FrameLayout;", "mScreenHeight", "", "mScreenWidth", "remoteView", "Lcom/huawei/hms/hmsscankit/RemoteView;", "resultType", "getViewBinding", "initView", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "processWatchInfo", "", "watchCodeId", "cgmType", "", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: QrCodeScanActivity.kt */
public final class QrCodeScanActivity extends BaseActivity<BaseViewModel, ActivityQrCodeScanBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String RESULT_TYPE = "resultType";
    private static final int RESULT_TYPE_SN = 1;
    public static final int RESULT_TYPE_USER_CENTER = 2;
    private FrameLayout frameLayout;
    private int mScreenHeight;
    private int mScreenWidth;
    private RemoteView remoteView;
    /* access modifiers changed from: private */
    public int resultType = -1;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/ui/qrcode/QrCodeScanActivity$Companion;", "", "()V", "RESULT_TYPE", "", "RESULT_TYPE_SN", "", "RESULT_TYPE_USER_CENTER", "start", "", "mContext", "Landroid/content/Context;", "resultType", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: QrCodeScanActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 1;
            }
            companion.start(context, i);
        }

        public final void start(Context context, int i) {
            Intrinsics.checkNotNullParameter(context, "mContext");
            Intent intent = new Intent(context, QrCodeScanActivity.class);
            intent.putExtra("resultType", i);
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityQrCodeScanBinding) getBinding()).getRoot());
        ((ActivityQrCodeScanBinding) getBinding()).actionBar.getLeftIcon().setOnClickListener(new QrCodeScanActivity$$ExternalSyntheticLambda2(this));
        this.resultType = getIntent().getIntExtra("resultType", -1);
        PermissionsUtil.INSTANCE.checkAndRequestPermissions(this, PermissionGroups.INSTANCE.getCamera(), new QrCodeScanActivity$onCreate$2(this, bundle));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(QrCodeScanActivity qrCodeScanActivity, View view) {
        Intrinsics.checkNotNullParameter(qrCodeScanActivity, "this$0");
        qrCodeScanActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void initView(Bundle bundle, int i) {
        getWindow().addFlags(128);
        this.frameLayout = ((ActivityQrCodeScanBinding) getBinding()).layoutScan;
        float f = getResources().getDisplayMetrics().density;
        this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        this.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        Rect rect = new Rect();
        int i2 = ((int) (((float) 300) * f)) / 2;
        rect.left = (this.mScreenWidth / 2) - i2;
        rect.right = (this.mScreenWidth / 2) + i2;
        rect.top = (this.mScreenHeight / 2) - i2;
        rect.bottom = (this.mScreenHeight / 2) + i2;
        RemoteView build = new RemoteView.Builder().setContext(this).setBoundingBox(rect).setContinuouslyScan(false).setFormat(HmsScan.QRCODE_SCAN_TYPE, HmsScan.DATAMATRIX_SCAN_TYPE).build();
        this.remoteView = build;
        if (build != null) {
            build.onCreate(bundle);
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        RemoteView remoteView2 = this.remoteView;
        if (remoteView2 != null) {
            remoteView2.setOnResultCallback(new QrCodeScanActivity$$ExternalSyntheticLambda0(booleanRef, i, this));
        }
        ((ActivityQrCodeScanBinding) getBinding()).flashSwitch.setOnCheckedChangeListener(new QrCodeScanActivity$$ExternalSyntheticLambda1(this));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(3000);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(1);
        translateAnimation.setInterpolator(new LinearInterpolator());
        ((ActivityQrCodeScanBinding) getBinding()).animationLine.startAnimation(translateAnimation);
        FrameLayout frameLayout2 = this.frameLayout;
        if (frameLayout2 != null) {
            frameLayout2.addView(this.remoteView, layoutParams);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void initView$lambda$2(kotlin.jvm.internal.Ref.BooleanRef r16, int r17, com.microtech.aidexx.ui.qrcode.QrCodeScanActivity r18, com.huawei.hms.ml.scan.HmsScan[] r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.String r3 = "$already"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r19)
            int r3 = r2.length
            r4 = 0
            r5 = r4
        L_0x0016:
            if (r5 >= r3) goto L_0x00ed
            r6 = r2[r5]
            java.lang.String r6 = r6.getOriginalValue()
            java.lang.String r6 = r6.toString()
            com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "content="
            r8.<init>(r9)
            java.lang.StringBuilder r8 = r8.append(r6)
            java.lang.String r8 = r8.toString()
            r9 = 0
            r10 = 2
            com.microtech.aidexx.utils.LogUtil.Companion.xLogI$default(r7, r8, r9, r10, r9)
            boolean r7 = r0.element
            if (r7 != 0) goto L_0x00e7
            r7 = 1
            r0.element = r7
            r8 = r17
            if (r8 != r10) goto L_0x00c3
            com.microtech.aidexx.utils.StringUtils r11 = com.microtech.aidexx.utils.StringUtils.INSTANCE
            r12 = r6
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r11 = r11.isURI(r12)
            if (r11 == 0) goto L_0x0092
            android.net.Uri r11 = android.net.Uri.parse(r6)
            java.lang.String r12 = r11.getHost()
            if (r12 == 0) goto L_0x0066
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.String r13 = "watch.microtechmd.com"
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r12 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r12, (java.lang.CharSequence) r13, (boolean) r4, (int) r10, (java.lang.Object) r9)
            if (r12 != r7) goto L_0x0066
            r12 = r7
            goto L_0x0067
        L_0x0066:
            r12 = r4
        L_0x0067:
            if (r12 == 0) goto L_0x0092
            java.lang.String r12 = "watchCodeId"
            java.lang.String r12 = r11.getQueryParameter(r12)
            if (r12 == 0) goto L_0x007a
            int r12 = java.lang.Integer.parseInt(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x007b
        L_0x007a:
            r12 = r9
        L_0x007b:
            java.lang.String r13 = "cgmType"
            java.lang.String r11 = r11.getQueryParameter(r13)
            if (r12 == 0) goto L_0x0093
            r7 = r12
            java.lang.Number r7 = (java.lang.Number) r7
            r7.intValue()
            int r7 = r12.intValue()
            boolean r7 = r1.processWatchInfo(r7, r11)
            goto L_0x0093
        L_0x0092:
            r7 = r4
        L_0x0093:
            if (r7 != 0) goto L_0x00e9
            com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "scan ret="
            r11.<init>(r12)
            java.lang.StringBuilder r6 = r11.append(r6)
            java.lang.String r6 = r6.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r7, r6, r9, r10, r9)
            r6 = r1
            androidx.lifecycle.LifecycleOwner r6 = (androidx.lifecycle.LifecycleOwner) r6
            androidx.lifecycle.LifecycleCoroutineScope r6 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r6)
            r10 = r6
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            com.microtech.aidexx.ui.qrcode.QrCodeScanActivity$initView$1$2 r6 = new com.microtech.aidexx.ui.qrcode.QrCodeScanActivity$initView$1$2
            r6.<init>(r1, r9)
            r13 = r6
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r14 = 3
            r15 = 0
            r11 = 0
            r12 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, r11, r12, r13, r14, r15)
            goto L_0x00e9
        L_0x00c3:
            int r7 = r6.length()
            r9 = 10
            if (r7 != r9) goto L_0x00e9
            androidx.viewbinding.ViewBinding r7 = r18.getBinding()
            com.microtech.aidexx.databinding.ActivityQrCodeScanBinding r7 = (com.microtech.aidexx.databinding.ActivityQrCodeScanBinding) r7
            android.widget.ImageView r7 = r7.animationLine
            r7.clearAnimation()
            java.lang.String r7 = "RESULT_SCAN"
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            com.jeremyliao.liveeventbus.core.Observable r7 = com.jeremyliao.liveeventbus.LiveEventBus.get(r7, r9)
            r9 = 500(0x1f4, double:2.47E-321)
            r7.postDelay(r6, r9)
            r18.finish()
            goto L_0x00e9
        L_0x00e7:
            r8 = r17
        L_0x00e9:
            int r5 = r5 + 1
            goto L_0x0016
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.qrcode.QrCodeScanActivity.initView$lambda$2(kotlin.jvm.internal.Ref$BooleanRef, int, com.microtech.aidexx.ui.qrcode.QrCodeScanActivity, com.huawei.hms.ml.scan.HmsScan[]):void");
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(QrCodeScanActivity qrCodeScanActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(qrCodeScanActivity, "this$0");
        RemoteView remoteView2 = qrCodeScanActivity.remoteView;
        if (remoteView2 != null) {
            remoteView2.switchLight();
        }
    }

    private final boolean processWatchInfo(int i, String str) {
        if (str == null || !Intrinsics.areEqual((Object) str, (Object) OtaManagerKt.AIDEX_VERSION)) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new QrCodeScanActivity$processWatchInfo$1$1(i, this, (Continuation<? super QrCodeScanActivity$processWatchInfo$1$1>) null), 3, (Object) null);
        return true;
    }

    public ActivityQrCodeScanBinding getViewBinding() {
        ActivityQrCodeScanBinding inflate = ActivityQrCodeScanBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        RemoteView remoteView2 = this.remoteView;
        if (remoteView2 != null) {
            remoteView2.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        RemoteView remoteView2 = this.remoteView;
        if (remoteView2 != null) {
            remoteView2.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        RemoteView remoteView2 = this.remoteView;
        if (remoteView2 != null) {
            remoteView2.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        RemoteView remoteView2 = this.remoteView;
        if (remoteView2 != null) {
            remoteView2.onStop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        RemoteView remoteView2 = this.remoteView;
        if (remoteView2 != null) {
            remoteView2.onDestroy();
        }
    }
}
