package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.DeferredLifecycleHelper;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.OnDelegateCreatedListener;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w7;
import com.huawei.hms.scankit.p.y3;

public class RemoteView extends FrameLayout {
    public static final int REQUEST_CODE_PHOTO = 4371;
    private static final String TAG = "ScanKitRemoteView";
    /* access modifiers changed from: private */
    public static boolean flagForGallery = false;
    /* access modifiers changed from: private */
    public static boolean isOnStop = true;
    private static a mRemoteHelper;
    /* access modifiers changed from: private */
    public Context mContext;
    private boolean mContinuouslyScan = true;
    private OnErrorCallback mOnErrorCallback = null;
    private boolean mReturnedBitmap = false;

    public static class Builder {
        Activity mContext;
        boolean mContinuouslyScan = true;
        HmsScanAnalyzerOptions mFormat;
        boolean mIsCustomed = true;
        Rect mRect;
        boolean mReturnedBitmap = false;

        public RemoteView build() {
            Activity activity = this.mContext;
            boolean z = this.mIsCustomed;
            HmsScanAnalyzerOptions hmsScanAnalyzerOptions = this.mFormat;
            return new RemoteView(activity, z, hmsScanAnalyzerOptions == null ? 0 : hmsScanAnalyzerOptions.mode, this.mRect).setContinuouslyScan(this.mContinuouslyScan).enableReturnBitmap(this.mReturnedBitmap);
        }

        public Builder enableReturnBitmap() {
            this.mReturnedBitmap = true;
            return this;
        }

        public Builder setBoundingBox(Rect rect) {
            this.mRect = rect;
            return this;
        }

        public Builder setContext(Activity activity) {
            this.mContext = activity;
            return this;
        }

        public Builder setContinuouslyScan(boolean z) {
            this.mContinuouslyScan = z;
            return this;
        }

        public Builder setFormat(int i, int... iArr) {
            this.mFormat = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(i, iArr).create();
            return this;
        }
    }

    private class a extends DeferredLifecycleHelper<b> {
        private ViewGroup a;
        public Activity b;
        private OnDelegateCreatedListener<b> c;
        private IRemoteViewDelegate d;
        private IOnResultCallback e = null;
        private boolean f;
        private boolean g;
        private int h;
        private IOnLightCallback i;
        private Rect j;
        private Bundle k;
        private boolean l;
        private boolean m;
        private int n;

        /* renamed from: com.huawei.hms.hmsscankit.RemoteView$a$a  reason: collision with other inner class name */
        class C0003a implements View.OnClickListener {
            C0003a() {
            }

            public void onClick(View view) {
                a aVar = a.this;
                Activity activity = aVar.b;
                if (activity != null) {
                    RemoteView.this.startPhotoCode(activity);
                }
            }
        }

        class b implements View.OnClickListener {
            b() {
            }

            public void onClick(View view) {
                a aVar = a.this;
                Activity activity = aVar.b;
                if (activity != null) {
                    RemoteView.this.startPhotoCode(activity);
                }
            }
        }

        a(Activity activity, ViewGroup viewGroup, boolean z, int i2, Rect rect) {
            this.a = viewGroup;
            this.b = activity;
            this.f = z;
            this.h = i2;
            this.j = rect;
        }

        /* access modifiers changed from: private */
        public boolean g() {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOnLight();
                return true;
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
                return false;
            }
        }

        public void createDelegate(OnDelegateCreatedListener<b> onDelegateCreatedListener) {
            this.c = onDelegateCreatedListener;
            if (onDelegateCreatedListener != null && getDelegate() == null) {
                this.d = null;
                try {
                    Bundle bundle = new Bundle();
                    boolean z = this.f;
                    if (!z && this.h == 0 && this.j == null) {
                        o4.c(RemoteView.TAG, "!mCustomed && mFormatValue == 0 && mRect == null");
                    } else {
                        bundle.putBoolean(DetailRect.CUSTOMED_FLAG, z);
                        bundle.putInt(DetailRect.FORMAT_FLAG, this.h);
                        Rect rect = this.j;
                        if (rect != null) {
                            bundle.putParcelable(DetailRect.RECT_FLAG, rect);
                        }
                    }
                    boolean z2 = this.l;
                    if (z2) {
                        bundle.putBoolean(DetailRect.SCAN_OFFSCEEN_FLAG, z2);
                    }
                    boolean z3 = this.g;
                    if (z3) {
                        bundle.putBoolean(DetailRect.DEEPLINK_JUMP_FLAG, z3);
                        bundle.putAll(this.k);
                    }
                    bundle.putInt(DetailRect.TYPE_TRANS, 3);
                    bundle.putBoolean(DetailRect.RETURN_BITMAP, this.m);
                    bundle.putAll(y3.a(this.b));
                    bundle.putBoolean(DetailRect.SCAN_NEW_UI, true);
                    bundle.putInt(DetailRect.SCAN_VIEWTYPE_FLAG, this.n);
                    IRemoteCreator d2 = f.d(this.b);
                    if (d2 != null) {
                        this.d = d2.newRemoteViewDelegate(ObjectWrapper.wrap(this.b), ObjectWrapper.wrap(bundle));
                        IRemoteViewDelegate iRemoteViewDelegate = this.d;
                        if (iRemoteViewDelegate != null) {
                            try {
                                IOnResultCallback iOnResultCallback = this.e;
                                if (iOnResultCallback != null) {
                                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                                    this.d.setOnClickListener(ObjectWrapper.wrap(new C0003a()));
                                }
                                this.d.setOnClickListener(ObjectWrapper.wrap(new b()));
                                IOnLightCallback iOnLightCallback = this.i;
                                if (iOnLightCallback != null) {
                                    this.d.setOnLightVisbleCallBack(iOnLightCallback);
                                }
                            } catch (RemoteException unused) {
                                o4.b("exception", "RemoteException");
                            }
                            this.c.onDelegateCreated(new b(this.a, this.d));
                        }
                    }
                } catch (RemoteException unused2) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* access modifiers changed from: private */
        public void d() {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.pauseContinuouslyScan();
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* access modifiers changed from: private */
        public void e() {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.resumeContinuouslyScan();
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* access modifiers changed from: private */
        public boolean f() {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOffLight();
                return true;
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
                return false;
            }
        }

        public void b(boolean z) {
            this.l = z;
        }

        public void c(boolean z) {
            this.m = z;
        }

        /* access modifiers changed from: private */
        public void b() {
            if (this.b != null) {
                this.b = null;
            }
            if (this.a != null) {
                this.a = null;
            }
        }

        /* access modifiers changed from: private */
        public boolean c() {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                return iRemoteViewDelegate.getLightStatus();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
                return false;
            }
        }

        /* access modifiers changed from: private */
        public void a(boolean z) {
            this.g = z;
        }

        /* access modifiers changed from: private */
        public void a(Bundle bundle) {
            this.k = bundle;
        }

        /* access modifiers changed from: private */
        public void a(IOnResultCallback iOnResultCallback) {
            this.e = iOnResultCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* access modifiers changed from: private */
        public void a(IOnErrorCallback iOnErrorCallback) {
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnErrorCallback(iOnErrorCallback);
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        a(Activity activity, ViewGroup viewGroup, boolean z, int i2, Rect rect, int i3) {
            this.a = viewGroup;
            this.b = activity;
            this.f = z;
            this.h = i2;
            this.j = rect;
            this.n = i3;
        }

        /* access modifiers changed from: private */
        public void a(IOnLightCallback iOnLightCallback) {
            this.i = iOnLightCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnLightVisbleCallBack(iOnLightCallback);
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* access modifiers changed from: private */
        public void a(int i2, int i3, Intent intent) {
            if (i3 == -1 && intent != null && i2 == 4371) {
                try {
                    HmsScan[] decodeWithBitmap = ScanUtil.decodeWithBitmap(RemoteView.this.mContext, w7.a(RemoteView.this.mContext, intent), new HmsScanAnalyzerOptions.Creator().setPhotoMode(true).create());
                    IOnResultCallback iOnResultCallback = this.e;
                    if (iOnResultCallback != null) {
                        iOnResultCallback.onResult(decodeWithBitmap);
                    }
                } catch (IllegalStateException unused) {
                    o4.b(RemoteView.TAG, "IllegalStateException in remoteview");
                } catch (RemoteException unused2) {
                    o4.b(RemoteView.TAG, "RemoteException in remoteview");
                } catch (Exception unused3) {
                    o4.b(RemoteView.TAG, "Exception in remoteview");
                } catch (Error unused4) {
                    o4.b(RemoteView.TAG, "Exception in error");
                }
            }
        }
    }

    private static class b implements LifecycleDelegate {
        private ViewGroup a;
        private View b;
        private IRemoteViewDelegate c;

        b(ViewGroup viewGroup, IRemoteViewDelegate iRemoteViewDelegate) {
            this.a = viewGroup;
            this.c = iRemoteViewDelegate;
        }

        public void onCreate(Bundle bundle) {
            try {
                this.c.onCreate(bundle);
                this.b = (View) ObjectWrapper.unwrap(this.c.getView());
                this.a.removeAllViews();
                this.a.addView(this.b);
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return new View((Context) null);
        }

        public void onDestroy() {
            try {
                this.c.onDestroy();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.c.onPause();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        public void onResume() {
            try {
                if (RemoteView.isOnStop) {
                    this.c.onResume();
                } else if (RemoteView.flagForGallery) {
                    this.c.onStart();
                } else {
                    this.c.onResume();
                }
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
        }

        public void onStart() {
            try {
                this.c.onStart();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        public void onStop() {
            try {
                this.c.onStop();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }
    }

    RemoteView(Activity activity, boolean z, int i, Rect rect) {
        super(activity);
        this.mContext = activity;
        mRemoteHelper = new a(activity, this, z, i, rect);
    }

    private boolean checkPhotoPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= 33) {
            if (w7.a((Context) activity) || activity.checkPermission("android.permission.READ_MEDIA_IMAGES", Process.myPid(), Process.myUid()) == 0) {
                return true;
            }
            return false;
        } else if (w7.a((Context) activity) || activity.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPhotoPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= 33) {
            activity.requestPermissions(new String[]{"android.permission.READ_MEDIA_IMAGES"}, REQUEST_CODE_PHOTO);
            return;
        }
        activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, REQUEST_CODE_PHOTO);
    }

    private void startActivityForGallery(Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (w7.f(activity)) {
                if (w7.a(new Intent(), "com.android.gallery3d", activity) != null && w7.a("com.android.gallery3d", activity)) {
                    o4.c(TAG, "Start Gallery:com.android.gallery3d");
                    intent.setPackage("com.android.gallery3d");
                } else if (w7.a(new Intent(), "com.huawei.photos", activity) != null && w7.a("com.huawei.photos", activity)) {
                    intent.setPackage("com.huawei.photos");
                    o4.c(TAG, "Start Gallery:com.huawei.photos");
                }
            }
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            flagForGallery = true;
            activity.startActivityForResult(intent, REQUEST_CODE_PHOTO);
        } catch (Exception unused) {
            o4.b(TAG, "startPhotoCode Exception");
        }
    }

    /* access modifiers changed from: private */
    public void startPhotoCode(Activity activity) {
        if (checkPhotoPermission(activity)) {
            startActivityForGallery(activity);
            return;
        }
        o4.c(TAG, "no photo permission");
        if (this.mOnErrorCallback == null) {
            requestPhotoPermission(activity);
            return;
        }
        o4.b(TAG, "no photo permission, report error2");
        this.mOnErrorCallback.onError(2);
    }

    /* access modifiers changed from: package-private */
    public RemoteView enableReturnBitmap(boolean z) {
        this.mReturnedBitmap = z;
        mRemoteHelper.c(z);
        return this;
    }

    public boolean getLightStatus() {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            return aVar.c();
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i(TAG, "onActivityResult: ");
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Log.i(TAG, "onCreate:");
        Context context = this.mContext;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.mContext).getWindow().setFlags(16777216, 16777216);
        }
        mRemoteHelper.onCreate(bundle);
    }

    public final void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.onDestroy();
            mRemoteHelper.b();
            mRemoteHelper = null;
        }
    }

    public final void onPause() {
        Log.i(TAG, "onPause: ");
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.onPause();
        }
        a aVar2 = mRemoteHelper;
        if (aVar2 != null && flagForGallery) {
            aVar2.onStop();
        }
        isOnStop = false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr, Activity activity) {
        if (i == 4371 && iArr.length == 1 && iArr[0] == 0) {
            startPhotoCode(activity);
        }
    }

    public final void onResume() {
        Log.i(TAG, "onResume: ");
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.onResume();
        }
        flagForGallery = false;
    }

    public final void onStart() {
        Log.i(TAG, "onStart: ");
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.onStart();
        }
        flagForGallery = false;
    }

    public final void onStop() {
        Log.i(TAG, "onStop: ");
        a aVar = mRemoteHelper;
        if (aVar != null && !flagForGallery) {
            aVar.onStop();
        }
        isOnStop = true;
    }

    public void pauseContinuouslyScan() {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void resumeContinuouslyScan() {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void selectPictureFromLocalFile() {
        startPhotoCode((Activity) this.mContext);
    }

    /* access modifiers changed from: package-private */
    public RemoteView setContinuouslyScan(boolean z) {
        this.mContinuouslyScan = z;
        return this;
    }

    public void setOnErrorCallback(OnErrorCallback onErrorCallback) {
        this.mOnErrorCallback = onErrorCallback;
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.a((IOnErrorCallback) new b(this.mOnErrorCallback));
        }
    }

    public void setOnLightVisibleCallback(OnLightVisibleCallBack onLightVisibleCallBack) {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.a((IOnLightCallback) new c(onLightVisibleCallBack));
        }
    }

    public void setOnResultCallback(OnResultCallback onResultCallback) {
        a aVar = mRemoteHelper;
        if (aVar != null) {
            aVar.a((IOnResultCallback) new d(onResultCallback, this.mContinuouslyScan));
        }
    }

    public boolean switchLight() {
        if (mRemoteHelper == null) {
            return false;
        }
        if (!getLightStatus()) {
            return mRemoteHelper.g();
        }
        return mRemoteHelper.f();
    }

    RemoteView(Activity activity, boolean z, int i, Rect rect, int i2) {
        super(activity);
        this.mContext = activity;
        mRemoteHelper = new a(activity, this, z, i, rect, i2);
    }

    RemoteView(Activity activity, boolean z, int i, Rect rect, boolean z2) {
        super(activity);
        this.mContext = activity;
        a aVar = new a(activity, this, z, i, rect);
        mRemoteHelper = aVar;
        aVar.b(z2);
    }

    RemoteView(Activity activity, boolean z, Bundle bundle) {
        super(activity);
        this.mContext = activity;
        a aVar = new a(activity, this, false, 0, (Rect) null);
        mRemoteHelper = aVar;
        aVar.a(z);
        mRemoteHelper.a(bundle);
    }
}
