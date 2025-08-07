package com.huawei.hms.feature.dynamic;

import android.os.IBinder;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

public class ObjectWrapper<T> extends IObjectWrapper.Stub {
    public final T a;

    public ObjectWrapper(T t) {
        this.a = t;
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).a;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        int i = 0;
        for (Field isSynthetic : declaredFields) {
            if (!isSynthetic.isSynthetic()) {
                i++;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException("Got " + declaredFields.length + " fields, The number of field number should be 1.");
        } else if (!declaredFields[0].isAccessible()) {
            declaredFields[0].setAccessible(true);
            try {
                return declaredFields[0].get(asBinder);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Get binder failed: null or not permitted.");
            }
        } else {
            throw new IllegalArgumentException("The field is accessible.");
        }
    }

    public static <T> IObjectWrapper wrap(T t) {
        return new ObjectWrapper(t);
    }
}
