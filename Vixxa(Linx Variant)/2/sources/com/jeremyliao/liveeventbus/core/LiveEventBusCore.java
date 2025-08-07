package com.jeremyliao.liveeventbus.core;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ExternalLiveData;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;
import com.jeremyliao.liveeventbus.ipc.core.ProcessorManager;
import com.jeremyliao.liveeventbus.ipc.receiver.LebIpcReceiver;
import com.jeremyliao.liveeventbus.logger.DefaultLogger;
import com.jeremyliao.liveeventbus.logger.Logger;
import com.jeremyliao.liveeventbus.logger.LoggerManager;
import com.jeremyliao.liveeventbus.utils.AppUtils;
import com.jeremyliao.liveeventbus.utils.ThreadUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public final class LiveEventBusCore {
    /* access modifiers changed from: private */
    public boolean autoClear;
    /* access modifiers changed from: private */
    public final Map<String, LiveEvent<Object>> bus;
    private final Config config;
    final InnerConsole console;
    /* access modifiers changed from: private */
    public boolean isRegisterReceiver;
    /* access modifiers changed from: private */
    public boolean lifecycleObserverAlwaysActive;
    /* access modifiers changed from: private */
    public LoggerManager logger;
    /* access modifiers changed from: private */
    public final Map<String, ObservableConfig> observableConfigs;
    private LebIpcReceiver receiver;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final LiveEventBusCore DEFAULT_BUS = new LiveEventBusCore();

        private SingletonHolder() {
        }
    }

    public static LiveEventBusCore get() {
        return SingletonHolder.DEFAULT_BUS;
    }

    private LiveEventBusCore() {
        this.config = new Config();
        this.isRegisterReceiver = false;
        this.console = new InnerConsole();
        this.bus = new HashMap();
        this.observableConfigs = new HashMap();
        this.lifecycleObserverAlwaysActive = true;
        this.autoClear = false;
        this.logger = new LoggerManager(new DefaultLogger());
        this.receiver = new LebIpcReceiver();
        registerReceiver();
    }

    public synchronized <T> Observable<T> with(String str, Class<T> cls) {
        if (!this.bus.containsKey(str)) {
            this.bus.put(str, new LiveEvent(str));
        }
        return this.bus.get(str);
    }

    public Config config() {
        return this.config;
    }

    public ObservableConfig config(String str) {
        if (!this.observableConfigs.containsKey(str)) {
            this.observableConfigs.put(str, new ObservableConfig());
        }
        return this.observableConfigs.get(str);
    }

    /* access modifiers changed from: package-private */
    public void setLogger(Logger logger2) {
        this.logger.setLogger(logger2);
    }

    /* access modifiers changed from: package-private */
    public void enableLogger(boolean z) {
        this.logger.setEnable(z);
    }

    /* access modifiers changed from: package-private */
    public void registerReceiver() {
        Application app;
        if (!this.isRegisterReceiver && (app = AppUtils.getApp()) != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IpcConst.ACTION);
            if (Build.VERSION.SDK_INT >= 26) {
                app.registerReceiver(this.receiver, intentFilter, 2);
            } else {
                app.registerReceiver(this.receiver, intentFilter);
            }
            this.isRegisterReceiver = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void setLifecycleObserverAlwaysActive(boolean z) {
        this.lifecycleObserverAlwaysActive = z;
    }

    /* access modifiers changed from: package-private */
    public void setAutoClear(boolean z) {
        this.autoClear = z;
    }

    private class LiveEvent<T> implements Observable<T> {
        private final String key;
        /* access modifiers changed from: private */
        public final LiveEvent<T>.LifecycleLiveData<T> liveData;
        private final Handler mainHandler = new Handler(Looper.getMainLooper());
        private final Map<Observer, ObserverWrapper<T>> observerMap = new HashMap();

        LiveEvent(String str) {
            this.key = str;
            this.liveData = new LifecycleLiveData<>(str);
        }

        public void post(T t) {
            if (ThreadUtils.isMainThread()) {
                postInternal(t);
            } else {
                this.mainHandler.post(new PostValueTask(t));
            }
        }

        public void postAcrossProcess(T t) {
            broadcast(t, false, true);
        }

        public void postAcrossApp(T t) {
            broadcast(t, false, false);
        }

        public void postDelay(T t, long j) {
            this.mainHandler.postDelayed(new PostValueTask(t), j);
        }

        public void postDelay(LifecycleOwner lifecycleOwner, T t, long j) {
            this.mainHandler.postDelayed(new PostLifeValueTask(t, lifecycleOwner), j);
        }

        public void postOrderly(T t) {
            this.mainHandler.post(new PostValueTask(t));
        }

        @Deprecated
        public void broadcast(T t) {
            broadcast(t, false, false);
        }

        public void broadcast(final T t, final boolean z, final boolean z2) {
            if (AppUtils.getApp() == null) {
                post(t);
            } else if (ThreadUtils.isMainThread()) {
                broadcastInternal(t, z, z2);
            } else {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        LiveEvent.this.broadcastInternal(t, z, z2);
                    }
                });
            }
        }

        public void observe(final LifecycleOwner lifecycleOwner, final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeInternal(lifecycleOwner, observer);
            } else {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        LiveEvent.this.observeInternal(lifecycleOwner, observer);
                    }
                });
            }
        }

        public void observeSticky(final LifecycleOwner lifecycleOwner, final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeStickyInternal(lifecycleOwner, observer);
            } else {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        LiveEvent.this.observeStickyInternal(lifecycleOwner, observer);
                    }
                });
            }
        }

        public void observeForever(final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeForeverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        LiveEvent.this.observeForeverInternal(observer);
                    }
                });
            }
        }

        public void observeStickyForever(final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeStickyForeverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        LiveEvent.this.observeStickyForeverInternal(observer);
                    }
                });
            }
        }

        public void removeObserver(final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                removeObserverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        LiveEvent.this.removeObserverInternal(observer);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void postInternal(T t) {
            LiveEventBusCore.this.logger.log(Level.INFO, "post: " + t + " with key: " + this.key);
            this.liveData.setValue(t);
        }

        /* access modifiers changed from: private */
        public void broadcastInternal(T t, boolean z, boolean z2) {
            LiveEventBusCore.this.logger.log(Level.INFO, "broadcast: " + t + " foreground: " + z + " with key: " + this.key);
            Application app = AppUtils.getApp();
            if (app == null) {
                LiveEventBusCore.this.logger.log(Level.WARNING, "application is null, you can try setContext() when config");
                return;
            }
            Intent intent = new Intent(IpcConst.ACTION);
            if (z) {
                intent.addFlags(268435456);
            }
            if (z2) {
                intent.setPackage(app.getPackageName());
            }
            intent.putExtra(IpcConst.KEY, this.key);
            if (ProcessorManager.getManager().writeTo(intent, t)) {
                try {
                    app.sendBroadcast(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* access modifiers changed from: private */
        public void observeInternal(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            ObserverWrapper observerWrapper = new ObserverWrapper(observer);
            boolean unused = observerWrapper.preventNextEvent = this.liveData.getVersion() > -1;
            this.liveData.observe(lifecycleOwner, observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe observer: " + observerWrapper + "(" + observer + ") on owner: " + lifecycleOwner + " with key: " + this.key);
        }

        /* access modifiers changed from: private */
        public void observeStickyInternal(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            ObserverWrapper observerWrapper = new ObserverWrapper(observer);
            this.liveData.observe(lifecycleOwner, observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe sticky observer: " + observerWrapper + "(" + observer + ") on owner: " + lifecycleOwner + " with key: " + this.key);
        }

        /* access modifiers changed from: private */
        public void observeForeverInternal(Observer<T> observer) {
            ObserverWrapper observerWrapper = new ObserverWrapper(observer);
            boolean unused = observerWrapper.preventNextEvent = this.liveData.getVersion() > -1;
            this.observerMap.put(observer, observerWrapper);
            this.liveData.observeForever(observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe forever observer: " + observerWrapper + "(" + observer + ") with key: " + this.key);
        }

        /* access modifiers changed from: private */
        public void observeStickyForeverInternal(Observer<T> observer) {
            ObserverWrapper observerWrapper = new ObserverWrapper(observer);
            this.observerMap.put(observer, observerWrapper);
            this.liveData.observeForever(observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe sticky forever observer: " + observerWrapper + "(" + observer + ") with key: " + this.key);
        }

        /* access modifiers changed from: private */
        public void removeObserverInternal(Observer<T> observer) {
            if (this.observerMap.containsKey(observer)) {
                observer = this.observerMap.remove(observer);
            }
            this.liveData.removeObserver(observer);
        }

        private class LifecycleLiveData<T> extends ExternalLiveData<T> {
            private final String key;

            public LifecycleLiveData(String str) {
                this.key = str;
            }

            /* access modifiers changed from: protected */
            public Lifecycle.State observerActiveLevel() {
                return lifecycleObserverAlwaysActive() ? Lifecycle.State.CREATED : Lifecycle.State.STARTED;
            }

            public void removeObserver(Observer<? super T> observer) {
                super.removeObserver(observer);
                if (autoClear() && !LiveEvent.this.liveData.hasObservers()) {
                    LiveEventBusCore.get().bus.remove(this.key);
                }
                LiveEventBusCore.this.logger.log(Level.INFO, "observer removed: " + observer);
            }

            private boolean lifecycleObserverAlwaysActive() {
                if (LiveEventBusCore.this.observableConfigs.containsKey(this.key)) {
                    ObservableConfig observableConfig = (ObservableConfig) LiveEventBusCore.this.observableConfigs.get(this.key);
                    if (observableConfig.lifecycleObserverAlwaysActive != null) {
                        return observableConfig.lifecycleObserverAlwaysActive.booleanValue();
                    }
                }
                return LiveEventBusCore.this.lifecycleObserverAlwaysActive;
            }

            private boolean autoClear() {
                if (LiveEventBusCore.this.observableConfigs.containsKey(this.key)) {
                    ObservableConfig observableConfig = (ObservableConfig) LiveEventBusCore.this.observableConfigs.get(this.key);
                    if (observableConfig.autoClear != null) {
                        return observableConfig.autoClear.booleanValue();
                    }
                }
                return LiveEventBusCore.this.autoClear;
            }
        }

        private class PostValueTask implements Runnable {
            private Object newValue;

            public PostValueTask(Object obj) {
                this.newValue = obj;
            }

            public void run() {
                LiveEvent.this.postInternal(this.newValue);
            }
        }

        private class PostLifeValueTask implements Runnable {
            private Object newValue;
            private LifecycleOwner owner;

            public PostLifeValueTask(Object obj, LifecycleOwner lifecycleOwner) {
                this.newValue = obj;
                this.owner = lifecycleOwner;
            }

            public void run() {
                LifecycleOwner lifecycleOwner = this.owner;
                if (lifecycleOwner != null && lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    LiveEvent.this.postInternal(this.newValue);
                }
            }
        }
    }

    private class ObserverWrapper<T> implements Observer<T> {
        private final Observer<T> observer;
        /* access modifiers changed from: private */
        public boolean preventNextEvent = false;

        ObserverWrapper(Observer<T> observer2) {
            this.observer = observer2;
        }

        public void onChanged(T t) {
            if (this.preventNextEvent) {
                this.preventNextEvent = false;
                return;
            }
            LiveEventBusCore.this.logger.log(Level.INFO, "message received: " + t);
            try {
                this.observer.onChanged(t);
            } catch (ClassCastException e) {
                LiveEventBusCore.this.logger.log(Level.WARNING, "class cast error on message received: " + t, e);
            } catch (Exception e2) {
                LiveEventBusCore.this.logger.log(Level.WARNING, "error on message received: " + t, e2);
            }
        }
    }

    class InnerConsole {
        InnerConsole() {
        }

        /* access modifiers changed from: package-private */
        public String getConsoleInfo() {
            return "*********Base info*********\n" + getBaseInfo() + "*********Event info*********\n" + getBusInfo();
        }

        /* access modifiers changed from: package-private */
        public String getBaseInfo() {
            StringBuilder sb = new StringBuilder("lifecycleObserverAlwaysActive: ");
            sb.append(LiveEventBusCore.this.lifecycleObserverAlwaysActive).append("\nautoClear: ").append(LiveEventBusCore.this.autoClear).append("\nlogger enable: ").append(LiveEventBusCore.this.logger.isEnable()).append("\nlogger: ").append(LiveEventBusCore.this.logger.getLogger()).append("\nReceiver register: ").append(LiveEventBusCore.this.isRegisterReceiver).append("\nApplication: ").append(AppUtils.getApp()).append("\n");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public String getBusInfo() {
            StringBuilder sb = new StringBuilder();
            for (String str : LiveEventBusCore.this.bus.keySet()) {
                sb.append("Event name: " + str).append("\n");
                LiveEvent.LifecycleLiveData access$1000 = ((LiveEvent) LiveEventBusCore.this.bus.get(str)).liveData;
                sb.append("\tversion: " + access$1000.getVersion()).append("\n");
                sb.append("\thasActiveObservers: " + access$1000.hasActiveObservers()).append("\n");
                sb.append("\thasObservers: " + access$1000.hasObservers()).append("\n");
                sb.append("\tActiveCount: " + getActiveCount(access$1000)).append("\n");
                sb.append("\tObserverCount: " + getObserverCount(access$1000)).append("\n\tObservers: \n");
                sb.append("\t\t" + getObserverInfo(access$1000)).append("\n");
            }
            return sb.toString();
        }

        private int getActiveCount(LiveData liveData) {
            try {
                Field declaredField = LiveData.class.getDeclaredField("mActiveCount");
                declaredField.setAccessible(true);
                return ((Integer) declaredField.get(liveData)).intValue();
            } catch (Exception unused) {
                return -1;
            }
        }

        private int getObserverCount(LiveData liveData) {
            try {
                Field declaredField = LiveData.class.getDeclaredField("mObservers");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(liveData);
                Method declaredMethod = obj.getClass().getDeclaredMethod("size", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(obj, new Object[0])).intValue();
            } catch (Exception unused) {
                return -1;
            }
        }

        private String getObserverInfo(LiveData liveData) {
            try {
                Field declaredField = LiveData.class.getDeclaredField("mObservers");
                declaredField.setAccessible(true);
                return declaredField.get(liveData).toString();
            } catch (Exception unused) {
                return "";
            }
        }
    }
}
