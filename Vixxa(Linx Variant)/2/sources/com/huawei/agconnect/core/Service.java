package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

public class Service {
    private final Class<?> a;
    private final Class<?> b;
    private final Object c;
    /* access modifiers changed from: private */
    public boolean d;
    /* access modifiers changed from: private */
    public boolean e;
    /* access modifiers changed from: private */
    public boolean f;

    public static class Builder {
        Class<?> a;
        Class<?> b;
        Object c;
        private boolean d;
        private boolean e;
        private boolean f;

        public Service build() {
            if (this.a != null) {
                Class<?> cls = this.b;
                if (cls != null) {
                    if (cls.isInterface() || !Modifier.isPublic(this.b.getModifiers())) {
                        throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
                    }
                    Service service = new Service((Class) this.a, (Class) this.b);
                    boolean unused = service.d = this.d;
                    boolean unused2 = service.e = this.e;
                    boolean unused3 = service.f = this.f;
                    return service;
                } else if (this.c != null) {
                    Service service2 = new Service((Class) this.a, this.c);
                    boolean unused4 = service2.d = this.d;
                    return service2;
                } else {
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                }
            } else {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            }
        }

        public Builder isAutoCreated(boolean z) {
            this.f = z;
            return this;
        }

        public Builder isSharedInstance(boolean z) {
            this.e = z;
            return this;
        }

        public Builder isSingleton(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.a = cls;
        this.b = cls2;
        this.c = null;
    }

    private Service(Class<?> cls, Object obj) {
        this.a = cls;
        this.b = null;
        this.c = obj;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.c;
    }

    public Class<?> getInterface() {
        return this.a;
    }

    public Class<?> getType() {
        return this.b;
    }

    public boolean isAutoCreated() {
        return this.f;
    }

    public boolean isSharedInstance() {
        return this.e;
    }

    public boolean isSingleton() {
        return this.d;
    }
}
