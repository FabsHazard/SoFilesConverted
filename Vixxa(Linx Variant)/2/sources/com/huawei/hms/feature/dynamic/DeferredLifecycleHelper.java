package com.huawei.hms.feature.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    public static final int STATUS_ONCREATED = 1;
    public static final int STATUS_ONCREATEVIEW = 2;
    public static final int STATUS_ONINFLATE = 0;
    public static final int STATUS_ONRESUME = 5;
    public static final int STATUS_ONSTART = 4;
    public static final String e = "DeferredLifecycleHelper";
    public T a;
    public Bundle b;
    public LinkedList<g> c;
    public OnDelegateCreatedListener<T> d = new a();

    public class a implements OnDelegateCreatedListener<T> {
        public a() {
        }

        public void onDelegateCreated(T t) {
            LifecycleDelegate unused = DeferredLifecycleHelper.this.a = t;
            Iterator it = DeferredLifecycleHelper.this.c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(DeferredLifecycleHelper.this.a);
            }
            DeferredLifecycleHelper.this.c.clear();
            Bundle unused2 = DeferredLifecycleHelper.this.b = null;
        }
    }

    public class b implements g {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ Bundle c;

        public b(Activity activity, Bundle bundle, Bundle bundle2) {
            this.a = activity;
            this.b = bundle;
            this.c = bundle2;
        }

        public int a() {
            return 0;
        }

        public void a(LifecycleDelegate lifecycleDelegate) {
            DeferredLifecycleHelper.this.a.onInflate(this.a, this.b, this.c);
        }
    }

    public class c implements g {
        public final /* synthetic */ Bundle a;

        public c(Bundle bundle) {
            this.a = bundle;
        }

        public int a() {
            return 1;
        }

        public void a(LifecycleDelegate lifecycleDelegate) {
            Log.d(DeferredLifecycleHelper.e, "IDelegateLifeCycleCall onCreate:");
            lifecycleDelegate.onCreate(this.a);
        }
    }

    public class d implements g {
        public final /* synthetic */ FrameLayout a;
        public final /* synthetic */ LayoutInflater b;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ Bundle d;

        public d(FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.a = frameLayout;
            this.b = layoutInflater;
            this.c = viewGroup;
            this.d = bundle;
        }

        public int a() {
            return 2;
        }

        public void a(LifecycleDelegate lifecycleDelegate) {
            this.a.removeAllViews();
            this.a.addView(DeferredLifecycleHelper.this.a.onCreateView(this.b, this.c, this.d));
        }
    }

    public class e implements g {
        public e() {
        }

        public int a() {
            return 4;
        }

        public void a(LifecycleDelegate lifecycleDelegate) {
            Log.d(DeferredLifecycleHelper.e, "IDelegateLifeCycleCall onStart:");
            lifecycleDelegate.onStart();
        }
    }

    public class f implements g {
        public f() {
        }

        public int a() {
            return 5;
        }

        public void a(LifecycleDelegate lifecycleDelegate) {
            Log.d(DeferredLifecycleHelper.e, "IDelegateLifeCycleCall onResume:");
            lifecycleDelegate.onResume();
        }
    }

    public interface g {
        int a();

        void a(LifecycleDelegate lifecycleDelegate);
    }

    private void a(int i) {
        while (!this.c.isEmpty() && this.c.getLast().a() >= i) {
            this.c.removeLast();
        }
    }

    private void a(Bundle bundle, g gVar) {
        T t = this.a;
        if (t != null) {
            gVar.a(t);
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList<>();
        }
        this.c.add(gVar);
        if (bundle != null) {
            Bundle bundle2 = this.b;
            if (bundle2 == null) {
                Object clone = bundle.clone();
                if (clone != null && (clone instanceof Bundle)) {
                    this.b = (Bundle) clone;
                }
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.d);
    }

    public abstract void createDelegate(OnDelegateCreatedListener<T> onDelegateCreatedListener);

    public T getDelegate() {
        return this.a;
    }

    public void onCreate(Bundle bundle) {
        a(bundle, (g) new c(bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, (g) new d(frameLayout, layoutInflater, viewGroup, bundle));
        return frameLayout;
    }

    public void onDestroy() {
        T t = this.a;
        if (t != null) {
            t.onDestroy();
        } else {
            a(0);
        }
    }

    public void onDestroyView() {
        T t = this.a;
        if (t != null) {
            t.onDestroyView();
        } else {
            a(1);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        a(bundle2, (g) new b(activity, bundle, bundle2));
    }

    public void onLowMemory() {
        T t = this.a;
        if (t != null) {
            t.onLowMemory();
        }
    }

    public void onPause() {
        T t = this.a;
        if (t != null) {
            t.onPause();
        } else {
            a(5);
        }
    }

    public void onResume() {
        a((Bundle) null, (g) new f());
    }

    public void onSaveInstanceState(Bundle bundle) {
        T t = this.a;
        if (t != null) {
            t.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        a((Bundle) null, (g) new e());
    }

    public void onStop() {
        T t = this.a;
        if (t != null) {
            t.onStop();
        } else {
            a(4);
        }
    }
}
