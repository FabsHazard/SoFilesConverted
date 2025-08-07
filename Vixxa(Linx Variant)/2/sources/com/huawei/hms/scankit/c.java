package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.contrarywind.timer.MessageHandler;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.g0;
import com.huawei.hms.scankit.p.i8;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.k0;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.m0;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.s6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.y6;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeHandler */
final class c extends Handler {
    /* access modifiers changed from: private */
    public static a j;
    private static long k;
    private final Context a;
    private final j0 b;
    private final a c;
    private boolean d = true;
    private int e = 50;
    private Rect f;
    private int g;
    private IRemoteFrameDecoderDelegate h;
    private boolean i = false;

    /* compiled from: DecodeHandler */
    private static class a extends AsyncTask<Object, Object, Object> {
        private WeakReference<c> a;
        private boolean b = true;
        /* access modifiers changed from: private */
        public boolean c = false;
        private int d = 0;
        private List<k0.a> e;
        private List<k0.a> f;
        private int g = 0;
        private int h = 0;

        public a(c cVar) {
            this.a = new WeakReference<>(cVar);
        }

        public void b(int i) {
            this.h = i;
            c cVar = (c) this.a.get();
            if (cVar != null) {
                try {
                    cVar.a(this.h, this.f);
                    o4.c("DecodeHandler", "ScanCode handle global value" + this.h);
                } catch (RuntimeException e2) {
                    o4.b("DecodeHandler", "RuntimeException: " + e2.getMessage());
                } catch (Exception unused) {
                    o4.b("DecodeHandler", "Exception");
                }
            }
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object... objArr) {
            Log.i("ScankitDecode", "doInBackground: ");
            if (c.j.isCancelled()) {
                return null;
            }
            while (!this.c) {
                if (this.b) {
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException unused) {
                        o4.c("ScankitDecode", "doInBackground  get InterruptedException  error!!!");
                    }
                    this.b = false;
                } else {
                    c cVar = (c) this.a.get();
                    int i = this.g;
                    if (i == 0) {
                        this.b = true;
                    } else if (cVar != null) {
                        try {
                            cVar.a(this.d / i, this.e);
                            o4.c("DecodeHandler", "ScanCode handle auto value" + (this.d / this.g));
                            a();
                            this.b = true;
                        } catch (RuntimeException e2) {
                            o4.b("DecodeHandler", "RuntimeException: " + e2.getMessage());
                        } catch (Exception unused2) {
                            o4.b("DecodeHandler", "Exception");
                        }
                    }
                }
            }
            return null;
        }

        public void a(int i) {
            this.d += i;
            this.g++;
        }

        public void a(List<Rect> list, int i, int i2, boolean z) {
            if (list == null) {
                o4.a("ScankitDecode", "areas is null");
            } else if (list.size() == 0) {
                this.f = Collections.singletonList(new k0.a(new Rect(-100, -100, 100, 100), 1000));
            } else {
                this.f = new ArrayList();
                for (Rect next : list) {
                    int centerX = ((next.centerX() * MessageHandler.WHAT_SMOOTH_SCROLL) / i) - 1000;
                    int centerY = ((next.centerY() * MessageHandler.WHAT_SMOOTH_SCROLL) / i2) - 1000;
                    int width = ((next.width() * MessageHandler.WHAT_SMOOTH_SCROLL) / i) / 2;
                    int height = ((next.height() * MessageHandler.WHAT_SMOOTH_SCROLL) / i2) / 2;
                    this.f.add(new k0.a(new Rect(centerX - (width / 2), centerY - (height / 2), centerX + width, centerY + height), 1000 / list.size()));
                }
                list.clear();
            }
        }

        public void b(List<Rect> list, int i, int i2, boolean z) {
            if (list == null) {
                o4.a("ScankitDecode", "areas is null");
            } else if (list.size() == 0) {
                this.e = Collections.singletonList(new k0.a(new Rect(-100, -100, 100, 100), 1000));
            } else {
                this.e = new ArrayList();
                if (z) {
                    int i3 = (i2 > i ? i2 - i : i - i2) >> 1;
                    for (Rect next : list) {
                        int centerY = (((next.centerY() + i3) * MessageHandler.WHAT_SMOOTH_SCROLL) / i) - 1000;
                        int centerX = ((next.centerX() * MessageHandler.WHAT_SMOOTH_SCROLL) / i2) - 1000;
                        int height = ((next.height() * MessageHandler.WHAT_SMOOTH_SCROLL) / i) / 2;
                        int width = ((next.width() * MessageHandler.WHAT_SMOOTH_SCROLL) / i2) / 2;
                        this.e.add(new k0.a(new Rect(centerY - (height / 2), centerX - (width / 2), centerY + height, centerX + width), 1000 / list.size()));
                    }
                    return;
                }
                for (Rect next2 : list) {
                    int centerX2 = ((next2.centerX() * MessageHandler.WHAT_SMOOTH_SCROLL) / i) - 1000;
                    int centerY2 = ((next2.centerY() * MessageHandler.WHAT_SMOOTH_SCROLL) / i2) - 1000;
                    int width2 = ((next2.width() * MessageHandler.WHAT_SMOOTH_SCROLL) / i) / 2;
                    int height2 = ((next2.height() * MessageHandler.WHAT_SMOOTH_SCROLL) / i2) / 2;
                    this.e.add(new k0.a(new Rect(centerX2 - (width2 / 2), centerY2 - (height2 / 2), centerX2 + width2, centerY2 + height2), 1000 / list.size()));
                }
                list.clear();
            }
        }

        private void a() {
            this.d = 0;
            this.g = 0;
        }
    }

    c(Context context, j0 j0Var, a aVar, Map<l1, Object> map, Rect rect, boolean z) {
        this.a = context;
        this.b = j0Var;
        this.c = aVar;
        this.f = rect;
        if (j == null) {
            a aVar2 = new a(this);
            j = aVar2;
            aVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
        this.g = 0;
        this.i = z;
        a(context);
    }

    private boolean d() {
        Context context = this.a;
        if (context == null) {
            return true;
        }
        Object systemService = context.getSystemService("window");
        if (systemService instanceof WindowManager) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            if (point.x < point.y) {
                return true;
            }
            return false;
        }
        o4.c("ScankitDecode", "isScreenPortrait  getSystemService  WINDOW_SERVICE  error!!!");
        return true;
    }

    public boolean b(float f2) {
        boolean z;
        a aVar = this.c;
        if (aVar != null && aVar.a()) {
            return false;
        }
        try {
            m0 g2 = this.b.g();
            if (g2 == null) {
                o4.c("ScankitDecode", "Zoom not supported,data is null");
                return false;
            }
            int c2 = g2.c();
            int b2 = g2.b();
            List<Integer> a2 = g2.a();
            float intValue = ((((float) a2.get(b2).intValue()) * 1.0f) / 100.0f) * f2;
            if (((int) (intValue * 100.0f)) > a2.get(c2).intValue()) {
                intValue = (((float) c2) * 1.0f) / 100.0f;
            }
            if (this.b.j()) {
                int a3 = a(intValue);
                if (a3 > b2) {
                    this.b.d(a3);
                    z = true;
                } else {
                    this.b.d(b2);
                    z = false;
                }
                this.b.a((List<k0.a>) Collections.singletonList(new k0.a(new Rect(-150, -150, 150, 150), 1000)));
                return z;
            }
            o4.c("ScankitDecode", "Zoom not supported");
            return false;
        } catch (RuntimeException unused) {
            o4.b("ScankitDecode", "Zoom not supported,RuntimeException happen");
            return false;
        } catch (Exception unused2) {
            o4.b("ScankitDecode", "Zoom not supported,Exception happen");
            return false;
        }
    }

    public float c() {
        List<Integer> b2 = b();
        if (b2 == null) {
            return 1.0f;
        }
        return (float) Math.round(((float) b2.get(b2.size() - 1).intValue()) / 100.0f);
    }

    public void handleMessage(Message message) {
        if (message != null && this.d) {
            int i2 = message.what;
            if (i2 == R.id.scankit_decode) {
                int i3 = this.g;
                if (i3 <= 1) {
                    this.g = i3 + 1;
                    this.c.sendEmptyMessage(R.id.scankit_decode_failed);
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof byte[]) {
                    a((byte[]) obj, d());
                }
            } else if (i2 == R.id.scankit_quit) {
                this.d = false;
                a aVar = j;
                if (aVar != null) {
                    boolean unused = aVar.c = true;
                    j.cancel(true);
                }
                Looper.myLooper().quit();
            } else {
                o4.c("ScankitDecode", "handleMessage  message.what:" + message.what);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049 A[Catch:{ RemoteException -> 0x0061 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A[Catch:{ RemoteException -> 0x0061 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "ScankitDecode"
            boolean r1 = r3.i     // Catch:{ IllegalAccessException -> 0x003f, ClassNotFoundException -> 0x0039, InstantiationException -> 0x0033 }
            if (r1 == 0) goto L_0x0012
            java.lang.String r4 = "use local decoder"
            android.util.Log.d(r0, r4)     // Catch:{ IllegalAccessException -> 0x003f, ClassNotFoundException -> 0x0039, InstantiationException -> 0x0033 }
            java.lang.Class<com.huawei.hms.scankit.DecoderCreator> r4 = com.huawei.hms.scankit.DecoderCreator.class
            java.lang.Object r4 = r4.newInstance()     // Catch:{ IllegalAccessException -> 0x003f, ClassNotFoundException -> 0x0039, InstantiationException -> 0x0033 }
            goto L_0x0045
        L_0x0012:
            java.lang.String r1 = "use remote decoder"
            android.util.Log.d(r0, r1)     // Catch:{ IllegalAccessException -> 0x003f, ClassNotFoundException -> 0x0039, InstantiationException -> 0x0033 }
            android.content.Context r4 = com.huawei.hms.hmsscankit.f.e(r4)     // Catch:{ NoSuchMethodException | InvocationTargetException -> 0x001b }
        L_0x001b:
            java.lang.ClassLoader r1 = r4.getClassLoader()     // Catch:{ IllegalAccessException -> 0x003f, ClassNotFoundException -> 0x0039, InstantiationException -> 0x0033 }
            java.lang.String r2 = "com.huawei.hms.scankit.DecoderCreator"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ IllegalAccessException -> 0x003f, ClassNotFoundException -> 0x0039, InstantiationException -> 0x0033 }
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ IllegalAccessException -> 0x003f, ClassNotFoundException -> 0x0039, InstantiationException -> 0x0033 }
            java.lang.String r2 = "com.huawei.hms.scankit.aiscan.common.BarcodeFormat"
            r4.loadClass(r2)     // Catch:{ IllegalAccessException -> 0x003f, ClassNotFoundException -> 0x0039, InstantiationException -> 0x0033 }
            java.lang.Object r4 = r1.newInstance()     // Catch:{ IllegalAccessException -> 0x003f, ClassNotFoundException -> 0x0039, InstantiationException -> 0x0033 }
            goto L_0x0045
        L_0x0033:
            java.lang.String r4 = "InstantiationException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r0, (java.lang.String) r4)
            goto L_0x0044
        L_0x0039:
            java.lang.String r4 = "ClassNotFoundException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r0, (java.lang.String) r4)
            goto L_0x0044
        L_0x003f:
            java.lang.String r4 = "IllegalAccessException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r0, (java.lang.String) r4)
        L_0x0044:
            r4 = 0
        L_0x0045:
            boolean r1 = r4 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0061 }
            if (r1 == 0) goto L_0x0056
            android.os.IBinder r4 = (android.os.IBinder) r4     // Catch:{ RemoteException -> 0x0061 }
            com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator r4 = com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator.Stub.asInterface(r4)     // Catch:{ RemoteException -> 0x0061 }
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r4 = r4.newRemoteFrameDecoderDelegate()     // Catch:{ RemoteException -> 0x0061 }
            r3.h = r4     // Catch:{ RemoteException -> 0x0061 }
            return
        L_0x0056:
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r4 = r3.h     // Catch:{ RemoteException -> 0x0061 }
            if (r4 != 0) goto L_0x0066
            com.huawei.hms.scankit.p.h4 r4 = com.huawei.hms.scankit.p.h4.a()     // Catch:{ RemoteException -> 0x0061 }
            r3.h = r4     // Catch:{ RemoteException -> 0x0061 }
            goto L_0x0066
        L_0x0061:
            java.lang.String r4 = "RemoteException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r0, (java.lang.String) r4)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.c.a(android.content.Context):void");
    }

    public List<Integer> b() {
        return this.b.g().a();
    }

    private void a(byte[] bArr, boolean z) {
        s6[] s6VarArr;
        int i2 = this.b.e().x;
        int i3 = this.b.e().y;
        Context context = this.a;
        int rotation = (context == null || !(context instanceof Activity)) ? 0 : ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        if (this.c != null) {
            w3.c a2 = b.I != null ? b.I.a(false, i2 * i3) : null;
            Bundle bundle = new Bundle();
            bundle.putParcelable("Rect", this.f);
            Point b2 = i8.b(this.a);
            if (b2 != null) {
                bundle.putParcelable("Screen", b2);
            }
            try {
                if (b.H != null) {
                    b.H.a(System.currentTimeMillis());
                }
                s6VarArr = this.h.decode(bArr, i2, i3, rotation, this.c.b(), ObjectWrapper.wrap(bundle));
            } catch (RemoteException unused) {
                Log.e("ScankitDecode", "RemoteException");
                s6VarArr = null;
            }
            if (s6VarArr == null || s6VarArr.length <= 0 || s6VarArr[0] == null) {
                this.c.sendEmptyMessage(R.id.scankit_decode_failed);
                if (b.I != null) {
                    b.I.a((HmsScan[]) null, a2);
                    return;
                }
                return;
            }
            if (this.c.d() && s6VarArr[0].l() != 1.0f && System.currentTimeMillis() - k > 1000) {
                o4.c("ScankitDecode", "need to zoom" + s6VarArr[0].l());
                if (a(s6VarArr[0].l(), s6VarArr, a2)) {
                    k = System.currentTimeMillis();
                    return;
                }
            }
            if (s6VarArr[0].k() == null) {
                if (s6VarArr[0].o()) {
                    o4.c("ScankitDecode", "ScanCode need to focus area");
                    a(s6VarArr[0].d().get(0), z);
                } else if (s6VarArr[0].n()) {
                    o4.c("ScankitDecode", "ScanCode need to globalexposure" + s6VarArr[0].h());
                    j.a(s6VarArr[0].g(), i2, i3, false);
                    j.b(s6VarArr[0].h());
                } else {
                    o4.c("ScankitDecode", "ScanCode need to exposure" + s6VarArr[0].f());
                    j.a(s6VarArr[0].f());
                    j.b(s6VarArr[0].d(), i2, i3, z);
                }
            }
            a(s6VarArr, bArr, i2, i3, a2);
        }
    }

    private boolean a(float f2, s6[] s6VarArr, w3.c cVar) {
        if (!b(f2)) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.what = R.id.scankit_decode_succeeded;
        HmsScan[] a2 = y6.a(s6VarArr);
        obtain.obj = a2;
        if (b.I != null) {
            b.I.a(a2, cVar);
        }
        this.c.sendMessage(obtain);
        return true;
    }

    private void a(s6[] s6VarArr, byte[] bArr, int i2, int i3, w3.c cVar) {
        if (this.c != null) {
            Message obtain = Message.obtain(this.c, R.id.scankit_decode_succeeded, y6.a(s6VarArr));
            Log.d("ScankitDecode", "scankit decode succeed msg SCAN_MODE: FULLSDK VERSION_CODE: 21100300 VERSION_NAME: 2.11.0.300");
            try {
                if (b.H != null) {
                    b.H.a(s6VarArr[0].e(), s6VarArr[0].b(), s6VarArr[0].m());
                }
            } catch (Exception unused) {
                Log.d("ScankitDecode", "ha is null");
            }
            if (this.c.c()) {
                Bundle bundle = new Bundle();
                a(bArr, i2, i3, bundle);
                obtain.setData(bundle);
            }
            obtain.sendToTarget();
        }
    }

    private static void a(byte[] bArr, int i2, int i3, Bundle bundle) {
        if (bArr != null && bArr.length != 0) {
            YuvImage yuvImage = new YuvImage(bArr, 17, i2, i3, (int[]) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i2, i3), 100, byteArrayOutputStream);
            bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
            bundle.putFloat("barcode_scaled_factor", 1.0f);
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
                Log.e("ScankitDecode", "RemoteException");
            }
        }
    }

    public void a(Rect rect, boolean z) {
        a aVar = this.c;
        if (aVar == null || !aVar.a()) {
            this.b.a(rect, z);
        }
    }

    public void a(int i2, List<k0.a> list) {
        g0 b2 = this.b.b();
        int b3 = b2.b();
        int c2 = b2.c();
        int a2 = b2.a();
        if (i2 != 0) {
            int i3 = a2 + i2;
            if (i3 <= b3) {
                b3 = i3 < c2 ? c2 : i3;
            }
            this.b.c(b3);
            k0 c3 = this.b.c();
            Rect b4 = c3.b();
            if (c3.a() <= 0) {
                return;
            }
            if (c3.a() == 1) {
                int centerX = b4.centerX();
                int centerY = b4.centerY();
                if (Math.sqrt((double) ((float) (((centerX - list.get(0).a.centerX()) * (centerX - list.get(0).a.centerX())) + (centerY - list.get(0).a.centerY()) + (centerY - list.get(0).a.centerY())))) > ((double) this.e)) {
                    list.set(0, new k0.a(list.get(0).a, 1000));
                    this.b.a(list.subList(0, 1));
                    return;
                }
                return;
            }
            this.b.a(list);
        }
    }

    public int a(float f2) {
        List<Integer> b2 = b();
        if (b2 == null) {
            return -3;
        }
        if (b2.size() <= 0) {
            return -4;
        }
        if (Math.abs(f2 - 1.0f) < 1.0E-6f) {
            return 0;
        }
        if (f2 == c()) {
            return b2.size() - 1;
        }
        for (int i2 = 1; i2 < b2.size(); i2++) {
            float f3 = 100.0f * f2;
            if (((float) b2.get(i2).intValue()) >= f3 && ((float) b2.get(i2 - 1).intValue()) <= f3) {
                return i2;
            }
        }
        return -1;
    }
}
