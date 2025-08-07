package com.huawei.hms.scankit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.e5;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.r6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import kotlinx.coroutines.DebugKt;

/* compiled from: IRemoteCustomedViewDelegateImpl */
public class e extends IRemoteViewDelegate.Stub implements e5, SensorEventListener {
    private static final String y = "e";
    protected static boolean z = false;
    private volatile w3 a = null;
    protected int b = 0;
    protected Context c;
    protected ProviderRemoteView d;
    protected TextureView e;
    protected b f;
    protected IOnResultCallback g;
    protected SensorManager h;
    protected View.OnClickListener i;
    protected boolean j = false;
    protected final Float k = Float.valueOf(40.0f);
    protected Boolean l;
    protected AlertDialog m;
    protected Rect n;
    private IObjectWrapper o;
    protected boolean p = false;
    private OrientationEventListener q;
    private boolean r;
    protected boolean s;
    protected boolean t = true;
    private Point u = null;
    protected IOnLightCallback v;
    protected LinearLayout w;
    boolean x = false;

    /* compiled from: IRemoteCustomedViewDelegateImpl */
    class a implements View.OnTouchListener {
        a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            e.this.f.b(motionEvent);
            return true;
        }
    }

    /* compiled from: IRemoteCustomedViewDelegateImpl */
    class b extends OrientationEventListener {
        b(Context context) {
            super(context);
        }

        public void onOrientationChanged(int i) {
            int rotation = ((Activity) e.this.c).getWindowManager().getDefaultDisplay().getRotation();
            boolean b = w7.b();
            boolean d = w7.d();
            if (w7.d(e.this.c) && !b) {
                e.this.a(90);
            } else if (w7.b((Activity) e.this.c) && !d) {
                e.this.a(90);
            } else if (rotation == 0) {
                e.this.a(90);
            } else if (rotation == 1) {
                e.this.a(0);
            } else if (rotation == 2) {
                e.this.a(270);
            } else if (rotation == 3) {
                e.this.a(180);
            }
        }
    }

    /* compiled from: IRemoteCustomedViewDelegateImpl */
    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            e.this.m.dismiss();
        }
    }

    public e(Context context, int i2, Object obj, IObjectWrapper iObjectWrapper, boolean z2, boolean z3, boolean z4) {
        this.c = context;
        this.b = i2;
        this.o = iObjectWrapper;
        if (obj instanceof Rect) {
            this.n = (Rect) obj;
        } else {
            this.n = null;
        }
        this.p = z2;
        this.r = z3;
        this.s = z4;
    }

    /* access modifiers changed from: protected */
    public void b(Point point, boolean z2) {
        int i2;
        int i3;
        float f2;
        float f3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.e.getLayoutParams();
        float f4 = (float) point.x;
        float f5 = (float) point.y;
        boolean b2 = w7.b();
        o4.c(y, "initSurfaceViewSize: isPortraitScreen: " + w7.c((Activity) this.c) + " inMultiWindow: " + w7.e(this.c) + " isInMultiWindowFreeform: " + w7.b((Activity) this.c) + " isPadOrFold: " + w7.i(this.c) + " isFoldStateExpand: " + w7.g(this.c) + " isPad: " + w7.h(this.c) + " inMagicWindow: " + w7.d(this.c) + " ignore: " + b2 + " screen: " + point.toString() + " width: " + layoutParams.width + " height: " + layoutParams.height + " inMagicWindow " + w7.d(this.c) + " ignore " + b2 + " isInit " + z2 + " isSpecialExpectSize " + this.f.b());
        if (w7.c((Activity) this.c) || (w7.d(this.c) && (!w7.d(this.c) || !b2))) {
            z = false;
            int i4 = 1280;
            if ("ceres-c3".equals(Build.DEVICE)) {
                i2 = 1280;
                i3 = 1280;
            } else {
                i2 = 1080;
                i3 = 1920;
            }
            if (z2 && (w7.e(this.c) || w7.b((Activity) this.c) || w7.d(this.c))) {
                i2 = 1280;
                i3 = 1280;
            }
            if (this.f.b()) {
                i3 = 1280;
            } else {
                i4 = i2;
            }
            float f6 = (float) i4;
            float f7 = f4 / f6;
            float f8 = (float) i3;
            float f9 = f5 / f8;
            if (f7 > f9) {
                layoutParams.width = -1;
                layoutParams.height = (int) (f8 * f7);
                layoutParams.gravity = 17;
            } else {
                layoutParams.height = -1;
                layoutParams.width = (int) (f6 * f9);
                layoutParams.gravity = 17;
            }
        } else {
            z = true;
            float f10 = 1280.0f;
            if (!z2 || (!w7.e(this.c) && !w7.b((Activity) this.c) && !w7.d(this.c))) {
                f2 = 1920.0f;
                f3 = 1080.0f;
            } else {
                f2 = 1280.0f;
                f3 = 1280.0f;
            }
            if (this.f.b()) {
                f3 = 1280.0f;
            } else {
                f10 = f2;
            }
            float f11 = f4 / f10;
            float f12 = f5 / f3;
            if (f11 > f12) {
                layoutParams.width = -1;
                layoutParams.height = (int) (f3 * f11);
                layoutParams.gravity = 17;
            } else {
                layoutParams.height = -1;
                layoutParams.width = (int) (f10 * f12);
                layoutParams.gravity = 17;
            }
        }
        this.e.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void c() {
        Object systemService = this.c.getSystemService("sensor");
        if (systemService instanceof SensorManager) {
            SensorManager sensorManager = (SensorManager) systemService;
            this.h = sensorManager;
            for (Sensor type : sensorManager.getSensorList(-1)) {
                if (5 == type.getType()) {
                    this.j = true;
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.c : DynamicModuleInitializer.getContext(), true);
    }

    public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle bundle;
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            bundle = new Bundle();
        } else {
            bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (this.a == null) {
            try {
                this.a = new w3(bundle, DetailRect.PHOTO_MODE);
            } catch (RuntimeException unused) {
                o4.b(y, "RuntimeException");
            } catch (Exception unused2) {
                o4.b(y, "Exception");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    /* access modifiers changed from: protected */
    public void e() {
        ProviderRemoteView d2 = d();
        this.d = d2;
        this.e = (TextureView) d2.findViewById(R.id.surfaceView);
        b bVar = new b(this.c, this.e, (ViewfinderView) null, this.n, this.b, this.o, this.p, "CustomizedView", true);
        this.f = bVar;
        bVar.b(this.s);
        c();
        a((Point) null, true);
    }

    /* access modifiers changed from: protected */
    public void f() {
        try {
            b bVar = this.f;
            if (bVar != null && bVar.a() != null) {
                this.f.a().a(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            }
        } catch (RuntimeException unused) {
            o4.b(y, "offFlashRuntimeException");
        } catch (Exception unused2) {
            o4.b(y, "offFlashException");
        }
    }

    public void g() {
        try {
            b bVar = this.f;
            if (bVar != null && bVar.a() != null) {
                this.f.a().a("torch");
            }
        } catch (RuntimeException unused) {
            o4.b(y, "openFlashRuntimeException");
        } catch (Exception unused2) {
            o4.b(y, "openFlashException");
        }
    }

    public boolean getLightStatus() throws RemoteException {
        return b();
    }

    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.d);
    }

    /* access modifiers changed from: protected */
    public void h() {
        AlertDialog create = new AlertDialog.Builder(this.c).create();
        this.m = create;
        create.show();
        View inflate = LayoutInflater.from(DynamicModuleInitializer.getContext() == null ? this.c : DynamicModuleInitializer.getContext()).inflate(R.layout.scankit_dialog_layout, (ViewGroup) null);
        Window window = this.m.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = 60;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setContentView(inflate);
        window.setGravity(80);
        inflate.findViewById(R.id.dialog_sure_btn).setOnClickListener(new c());
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onCreate(Bundle bundle) {
        Context context = this.c;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.c).getWindow().setFlags(16777216, 16777216);
        }
        Context context2 = this.c;
        if (!(context2 == null || context2.getPackageManager() == null)) {
            this.t = this.c.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
            o4.c("Scankit", "initlight hasFlash " + this.t);
        }
        e();
        this.f.a((e5) this);
        this.d.setOnTouchListener(new a());
        IOnResultCallback iOnResultCallback = this.g;
        if (iOnResultCallback != null) {
            this.f.a(iOnResultCallback);
        }
        this.f.a(this.r);
        this.f.c();
        b bVar = new b(this.c);
        this.q = bVar;
        if (bVar.canDetectOrientation()) {
            this.q.enable();
        } else {
            this.q.disable();
        }
    }

    public void onDestroy() {
        try {
            this.f.d();
            OrientationEventListener orientationEventListener = this.q;
            if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
                this.q.disable();
            }
            if (this.c != null) {
                this.c = null;
            }
            AlertDialog alertDialog = this.m;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.m.dismiss();
                this.m = null;
            }
        } catch (RuntimeException unused) {
            o4.b(y, "onDestroyRuntimeException");
        } catch (Exception unused2) {
            o4.b(y, "onDestroyException");
        }
    }

    public void onPause() {
        try {
            this.f.e();
            this.h.unregisterListener(this);
        } catch (RuntimeException unused) {
            o4.b(y, "onPauseRuntimeException");
        } catch (Exception unused2) {
            o4.b(y, "onPauseException");
        }
    }

    public void onResume() {
        try {
            this.f.f();
            SensorManager sensorManager = this.h;
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
        } catch (RuntimeException unused) {
            o4.b(y, "onResumeRuntimeException");
        } catch (Exception unused2) {
            o4.b(y, "onResumeException");
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.j && sensorEvent.sensor.getType() == 5 && this.t) {
            Boolean valueOf = Boolean.valueOf(sensorEvent.values[0] > this.k.floatValue());
            this.l = valueOf;
            if (!valueOf.booleanValue()) {
                if (this.w != null) {
                    o4.c("Scankit", "initlight onSensorChanged open");
                    this.w.setVisibility(0);
                }
                IOnLightCallback iOnLightCallback = this.v;
                if (iOnLightCallback != null) {
                    try {
                        iOnLightCallback.onVisibleChanged(true);
                    } catch (RemoteException unused) {
                        o4.d(y, "onSensorChanged RemoteException");
                    }
                }
            } else if (sensorEvent.values[0] > 600.0f) {
                if (this.w != null && !b()) {
                    this.w.setVisibility(8);
                }
                IOnLightCallback iOnLightCallback2 = this.v;
                if (iOnLightCallback2 != null) {
                    try {
                        iOnLightCallback2.onVisibleChanged(false);
                    } catch (RemoteException unused2) {
                        o4.d(y, "onSensorChanged RemoteException");
                    }
                }
            }
        }
    }

    public void onStart() {
        try {
            this.f.g();
        } catch (RuntimeException unused) {
            o4.b(y, "onStartRuntimeException");
        } catch (Exception unused2) {
            o4.b(y, "onStartException");
        }
    }

    public void onStop() {
        try {
            this.f.h();
        } catch (RuntimeException unused) {
            o4.b(y, "onStopRuntimeException");
        } catch (Exception unused2) {
            o4.b(y, "onStopException");
        }
    }

    public void pauseContinuouslyScan() throws RemoteException {
        b bVar = this.f;
        if (bVar != null) {
            bVar.i();
        }
        this.x = true;
    }

    public void resumeContinuouslyScan() throws RemoteException {
        this.x = false;
    }

    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.i = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException {
        b bVar = this.f;
        if (bVar != null) {
            bVar.a(iOnErrorCallback);
        }
    }

    public void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException {
        this.v = iOnLightCallback;
    }

    public void setOnResultCallback(IOnResultCallback iOnResultCallback) {
        this.g = iOnResultCallback;
        b bVar = this.f;
        if (bVar != null) {
            bVar.a(iOnResultCallback);
        }
    }

    public void turnOffLight() throws RemoteException {
        f();
    }

    public void turnOnLight() throws RemoteException {
        g();
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        b bVar = this.f;
        if (bVar != null && bVar.a() != null) {
            try {
                Point a2 = a(this.c);
                if (i2 != this.f.a().d()) {
                    this.f.a().b(i2);
                }
                if (this.f.a().i()) {
                    Point point = this.u;
                    if (point == null || point.x != a2.x) {
                        a(a2, false);
                    }
                }
            } catch (NullPointerException unused) {
                o4.d(y, "adjustCameraOrientation: nullpoint");
            } catch (Exception unused2) {
                o4.d(y, "adjustCameraOrientation: Exception");
            }
        }
    }

    private static Point a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (w7.e(context) || w7.d(context)) {
            Log.i(y, "initSurfaceView: is in MultiWindowMode");
            defaultDisplay.getSize(point);
        } else {
            defaultDisplay.getRealSize(point);
        }
        return point;
    }

    /* access modifiers changed from: protected */
    public void a(Point point, boolean z2) {
        try {
            if (this.c.getSystemService("window") != null) {
                if (point == null) {
                    point = a(this.c);
                }
                this.u = point;
                b(point, z2);
            }
        } catch (NullPointerException unused) {
            o4.d(y, "initSurfaceView: nullpoint");
        } catch (Exception unused2) {
            o4.d(y, "initSurfaceView: Exception");
        }
    }

    public boolean a(HmsScan[] hmsScanArr) {
        AlertDialog alertDialog;
        if (hmsScanArr == null || hmsScanArr.length <= 0 || (alertDialog = this.m) == null || !alertDialog.isShowing()) {
            return false;
        }
        this.m.dismiss();
        return false;
    }

    public boolean a() {
        return this.x;
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z2;
        int i2;
        if (iObjectWrapper == null) {
            o4.b("ScankitRemoteS", "bitmap is null");
            return new HmsScan[0];
        }
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z2 = false;
            i2 = 0;
        } else {
            i2 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            int i3 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i3;
            z2 = i3 >= 2;
            if (z2) {
                i2 = w7.b(i2);
            }
        }
        HmsScan[] b2 = r6.a().b((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), i2, true, this.a);
        if (!z2) {
            b2 = w7.a(b2);
        }
        if (b2.length == 0) {
            h();
        } else {
            HmsScan hmsScan = b2[0];
            if (hmsScan != null && TextUtils.isEmpty(hmsScan.originalValue)) {
                h();
            }
        }
        return b2;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        try {
            return this.f.a().h().equals("torch");
        } catch (RuntimeException unused) {
            o4.b(y, "getFlashStatusRuntimeException");
            return false;
        } catch (Exception unused2) {
            o4.b(y, "getFlashStatusException");
            return false;
        }
    }
}
