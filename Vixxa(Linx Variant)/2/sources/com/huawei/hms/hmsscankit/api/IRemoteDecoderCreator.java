package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;

public interface IRemoteDecoderCreator extends IInterface {

    public static class Default implements IRemoteDecoderCreator {
        public IBinder asBinder() {
            return null;
        }

        public IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRemoteDecoderCreator {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator";
        static final int TRANSACTION_newRemoteFrameDecoderDelegate = 1;

        private static class Proxy implements IRemoteDecoderCreator {
            public static IRemoteDecoderCreator sDefaultImpl;
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

            public IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteFrameDecoderDelegate();
                    }
                    obtain2.readException();
                    IRemoteFrameDecoderDelegate asInterface = IRemoteFrameDecoderDelegate.Stub.asInterface(obtain2.readStrongBinder());
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

        public static IRemoteDecoderCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteDecoderCreator)) {
                return new Proxy(iBinder);
            }
            return (IRemoteDecoderCreator) queryLocalInterface;
        }

        public static IRemoteDecoderCreator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteDecoderCreator iRemoteDecoderCreator) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iRemoteDecoderCreator == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iRemoteDecoderCreator;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate = newRemoteFrameDecoderDelegate();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(newRemoteFrameDecoderDelegate != null ? newRemoteFrameDecoderDelegate.asBinder() : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException;
}
