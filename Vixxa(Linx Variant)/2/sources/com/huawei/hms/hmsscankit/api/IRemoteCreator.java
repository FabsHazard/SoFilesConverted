package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;

public interface IRemoteCreator extends IInterface {

    public static class Default implements IRemoteCreator {
        public IBinder asBinder() {
            return null;
        }

        public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
            return null;
        }

        public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
            return null;
        }

        public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRemoteCreator {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteCreator";
        static final int TRANSACTION_newRemoteDecoderDelegate = 2;
        static final int TRANSACTION_newRemoteHmsDecoderDelegate = 3;
        static final int TRANSACTION_newRemoteViewDelegate = 1;

        private static class Proxy implements IRemoteCreator {
            public static IRemoteCreator sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteDecoderDelegate();
                    }
                    obtain2.readException();
                    IRemoteDecoderDelegate asInterface = IRemoteDecoderDelegate.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteHmsDecoderDelegate();
                    }
                    obtain2.readException();
                    IRemoteHmsDecoderDelegate asInterface = IRemoteHmsDecoderDelegate.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (iObjectWrapper2 != null) {
                        iBinder = iObjectWrapper2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteViewDelegate(iObjectWrapper, iObjectWrapper2);
                    }
                    obtain2.readException();
                    IRemoteViewDelegate asInterface = IRemoteViewDelegate.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteCreator)) {
                return new Proxy(iBinder);
            }
            return (IRemoteCreator) queryLocalInterface;
        }

        public static IRemoteCreator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteCreator iRemoteCreator) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iRemoteCreator == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iRemoteCreator;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                IRemoteViewDelegate newRemoteViewDelegate = newRemoteViewDelegate(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (newRemoteViewDelegate != null) {
                    iBinder = newRemoteViewDelegate.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                IRemoteDecoderDelegate newRemoteDecoderDelegate = newRemoteDecoderDelegate();
                parcel2.writeNoException();
                if (newRemoteDecoderDelegate != null) {
                    iBinder = newRemoteDecoderDelegate.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate = newRemoteHmsDecoderDelegate();
                parcel2.writeNoException();
                if (newRemoteHmsDecoderDelegate != null) {
                    iBinder = newRemoteHmsDecoderDelegate.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException;

    IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException;

    IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
