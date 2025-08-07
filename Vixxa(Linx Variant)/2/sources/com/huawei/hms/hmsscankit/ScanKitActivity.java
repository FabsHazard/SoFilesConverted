package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.huawei.hms.scankit.p.w7;

public class ScanKitActivity extends Activity {
    private static final String TAG = "ScanKitActivity";
    /* access modifiers changed from: private */
    public boolean errorReport = false;
    /* access modifiers changed from: private */
    public int lastRotation = Integer.MAX_VALUE;
    private OrientationEventListener mOrientationListener;
    private RemoteView remoteView;

    private void setActivityUseNotchScreen(Activity activity) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            activity.getWindow().setAttributes(attributes);
        }
    }

    private void startOrientationChangeListener() {
        AnonymousClass3 r0 = new OrientationEventListener(this) {
            public void onOrientationChanged(int i) {
                try {
                    int rotation = ScanKitActivity.this.getWindowManager().getDefaultDisplay().getRotation();
                    if (Math.abs(ScanKitActivity.this.lastRotation - rotation) == 2) {
                        ScanKitActivity.this.recreate();
                        Log.i(ScanKitActivity.TAG, "onOrientationChanged: currentRotation" + rotation);
                    }
                    int unused = ScanKitActivity.this.lastRotation = rotation;
                } catch (RuntimeException unused2) {
                    Log.e(ScanKitActivity.TAG, "onOrientationChanged: RuntimeException");
                }
            }
        };
        this.mOrientationListener = r0;
        r0.enable();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.remoteView.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
            r10 = this;
            java.lang.String r0 = "ScanKitActivity"
            super.onCreate(r11)
            r1 = 1
            r10.requestWindowFeature(r1)
            int r1 = com.huawei.hms.scankit.R.layout.scankit_layout
            r10.setContentView(r1)
            r1 = 0
            android.content.Intent r2 = r10.getIntent()     // Catch:{ NullPointerException -> 0x003d }
            if (r2 == 0) goto L_0x003a
            android.content.Intent r2 = r10.getIntent()     // Catch:{ NullPointerException -> 0x003d }
            java.lang.String r3 = "ScanFormatValue"
            int r2 = r2.getIntExtra(r3, r1)     // Catch:{ NullPointerException -> 0x003d }
            android.content.Intent r3 = r10.getIntent()     // Catch:{ NullPointerException -> 0x0037 }
            java.lang.String r4 = "ScanViewValue"
            int r3 = r3.getIntExtra(r4, r1)     // Catch:{ NullPointerException -> 0x0037 }
            android.content.Intent r4 = r10.getIntent()     // Catch:{ NullPointerException -> 0x0038 }
            java.lang.String r5 = "ScanErrorCheck"
            boolean r1 = r4.getBooleanExtra(r5, r1)     // Catch:{ NullPointerException -> 0x0038 }
            r10.errorReport = r1     // Catch:{ NullPointerException -> 0x0038 }
            r7 = r2
            goto L_0x0044
        L_0x0037:
            r3 = r1
        L_0x0038:
            r1 = r2
            goto L_0x003e
        L_0x003a:
            r7 = r1
            r9 = r7
            goto L_0x0045
        L_0x003d:
            r3 = r1
        L_0x003e:
            java.lang.String r2 = "getIntExtra can not get"
            com.huawei.hms.scankit.p.o4.c(r0, r2)
            r7 = r1
        L_0x0044:
            r9 = r3
        L_0x0045:
            com.huawei.hms.hmsscankit.RemoteView r1 = new com.huawei.hms.hmsscankit.RemoteView
            r6 = 0
            r8 = 0
            r4 = r1
            r5 = r10
            r4.<init>((android.app.Activity) r5, (boolean) r6, (int) r7, (android.graphics.Rect) r8, (int) r9)
            r10.remoteView = r1
            com.huawei.hms.hmsscankit.ScanKitActivity$1 r2 = new com.huawei.hms.hmsscankit.ScanKitActivity$1
            r2.<init>()
            r1.setOnResultCallback(r2)
            com.huawei.hms.hmsscankit.RemoteView r1 = r10.remoteView
            com.huawei.hms.hmsscankit.ScanKitActivity$2 r2 = new com.huawei.hms.hmsscankit.ScanKitActivity$2
            r2.<init>()
            r1.setOnErrorCallback(r2)
            com.huawei.hms.hmsscankit.RemoteView r1 = r10.remoteView
            r1.onCreate(r11)
            int r11 = com.huawei.hms.scankit.R.id.ll_top
            android.view.View r11 = r10.findViewById(r11)
            android.view.ViewGroup r11 = (android.view.ViewGroup) r11
            com.huawei.hms.hmsscankit.RemoteView r1 = r10.remoteView
            r11.addView(r1)
            int r11 = android.os.Build.VERSION.SDK_INT
            boolean r1 = r10.isInMultiWindowMode()
            android.view.Window r2 = r10.getWindow()
            if (r2 == 0) goto L_0x008c
            r3 = 201326592(0xc000000, float:9.8607613E-32)
            r2.addFlags(r3)
            if (r1 == 0) goto L_0x008c
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r2.clearFlags(r1)
        L_0x008c:
            r10.setActivityUseNotchScreen(r10)
            r1 = 28
            if (r11 < r1) goto L_0x0096
            r10.startOrientationChangeListener()
        L_0x0096:
            java.lang.String r11 = "ScankitActivity on create"
            android.util.Log.i(r0, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanKitActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.remoteView.onDestroy();
        w7.c = true;
        Log.i(TAG, "ScankitActivity onDestroy");
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.remoteView.onPause();
        w7.c = true;
        Log.i(TAG, "ScankitActivity onPause");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.remoteView.onRequestPermissionsResult(i, strArr, iArr, this);
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.remoteView.onResume();
        w7.c = false;
        Log.i(TAG, "ScankitActivity onResume");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.remoteView.onStart();
        w7.c = false;
        Log.i(TAG, "ScankitActivity onStart");
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.remoteView.onStop();
        w7.c = true;
        Log.i(TAG, "ScankitActivity onStop");
    }
}
