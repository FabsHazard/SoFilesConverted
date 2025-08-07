package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IObjectWrapper extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.feature.dynamic.IObjectWrapper";

    public static class Default implements IObjectWrapper {
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IObjectWrapper {

        public static class Proxy implements IObjectWrapper {
            public static IObjectWrapper sDefaultImpl;
            public IBinder a;

            public Proxy(IBinder iBinder) {
                this.a = iBinder;
            }

            public IBinder asBinder() {
                return this.a;
            }

            public String getInterfaceDescriptor() {
                return IObjectWrapper.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IObjectWrapper.DESCRIPTOR);
        }

        public static IObjectWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IObjectWrapper.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IObjectWrapper)) ? new Proxy(iBinder) : (IObjectWrapper) queryLocalInterface;
        }

        public static IObjectWrapper getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IObjectWrapper iObjectWrapper) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iObjectWrapper == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iObjectWrapper;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(IObjectWrapper.DESCRIPTOR);
            return true;
        }
    }
}
