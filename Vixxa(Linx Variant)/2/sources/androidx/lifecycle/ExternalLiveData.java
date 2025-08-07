package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ExternalLiveData<T> extends MutableLiveData<T> {
    public static final int START_VERSION = -1;

    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        if (lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            try {
                ExternalLifecycleBoundObserver externalLifecycleBoundObserver = new ExternalLifecycleBoundObserver(lifecycleOwner, observer);
                LiveData.LifecycleBoundObserver lifecycleBoundObserver = (LiveData.LifecycleBoundObserver) callMethodPutIfAbsent(observer, externalLifecycleBoundObserver);
                if (lifecycleBoundObserver != null) {
                    if (!lifecycleBoundObserver.isAttachedTo(lifecycleOwner)) {
                        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
                    }
                }
                if (lifecycleBoundObserver == null) {
                    lifecycleOwner.getLifecycle().addObserver(externalLifecycleBoundObserver);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getVersion() {
        return super.getVersion();
    }

    /* access modifiers changed from: protected */
    public Lifecycle.State observerActiveLevel() {
        return Lifecycle.State.CREATED;
    }

    class ExternalLifecycleBoundObserver extends LiveData<T>.LifecycleBoundObserver {
        ExternalLifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(lifecycleOwner, observer);
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(ExternalLiveData.this.observerActiveLevel());
        }
    }

    private Object getFieldObservers() throws Exception {
        Field declaredField = LiveData.class.getDeclaredField("mObservers");
        declaredField.setAccessible(true);
        return declaredField.get(this);
    }

    private Object callMethodPutIfAbsent(Object obj, Object obj2) throws Exception {
        Object fieldObservers = getFieldObservers();
        Method declaredMethod = fieldObservers.getClass().getDeclaredMethod("putIfAbsent", new Class[]{Object.class, Object.class});
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(fieldObservers, new Object[]{obj, obj2});
    }
}
