package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanResult;

public interface IRemoteDecoderDelegate extends IInterface {

    public static class Default implements IRemoteDecoderDelegate {
        public IBinder asBinder() {
            return null;
        }

        public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }

        public void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException {
        }

        public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }

        public HmsScanResult decodeWithBuffer(byte[] bArr, int i, int i2, IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }

        public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRemoteDecoderDelegate {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate";
        static final int TRANSACTION_buildBitmap = 4;
        static final int TRANSACTION_buildBitmapLog = 3;
        static final int TRANSACTION_decodeWithBitmap = 1;
        static final int TRANSACTION_decodeWithBuffer = 2;
        static final int TRANSACTION_queryDeepLinkInfo = 5;

        private static class Proxy implements IRemoteDecoderDelegate {
            public static IRemoteDecoderDelegate sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().buildBitmap(iObjectWrapper);
                    }
                    obtain2.readException();
                    IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().buildBitmapLog(iObjectWrapper);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
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
                        return Stub.getDefaultImpl().decodeWithBitmap(iObjectWrapper, iObjectWrapper2);
                    }
                    obtain2.readException();
                    HmsScan[] hmsScanArr = (HmsScan[]) obtain2.createTypedArray(HmsScan.CREATOR);
                    obtain2.recycle();
                    obtain.recycle();
                    return hmsScanArr;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public HmsScanResult decodeWithBuffer(byte[] bArr, int i, int i2, IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    HmsScanResult hmsScanResult = null;
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().decodeWithBuffer(bArr, i, i2, iObjectWrapper);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        hmsScanResult = HmsScanResult.CREATOR.createFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return hmsScanResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().queryDeepLinkInfo(iObjectWrapper);
                    }
                    obtain2.readException();
                    IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
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

        public static IRemoteDecoderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteDecoderDelegate)) {
                return new Proxy(iBinder);
            }
            return (IRemoteDecoderDelegate) queryLocalInterface;
        }

        public static IRemoteDecoderDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteDecoderDelegate iRemoteDecoderDelegate) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iRemoteDecoderDelegate == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iRemoteDecoderDelegate;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                HmsScan[] decodeWithBitmap = decodeWithBitmap(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeTypedArray(decodeWithBitmap, 1);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                HmsScanResult decodeWithBuffer = decodeWithBuffer(parcel.createByteArray(), parcel.readInt(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (decodeWithBuffer != null) {
                    parcel2.writeInt(1);
                    decodeWithBuffer.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 3) {
                IBinder iBinder = null;
                if (i == 4) {
                    parcel.enforceInterface(DESCRIPTOR);
                    IObjectWrapper buildBitmap = buildBitmap(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (buildBitmap != null) {
                        iBinder = buildBitmap.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                } else if (i != 5) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    parcel.enforceInterface(DESCRIPTOR);
                    IObjectWrapper queryDeepLinkInfo = queryDeepLinkInfo(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (queryDeepLinkInfo != null) {
                        iBinder = queryDeepLinkInfo.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                buildBitmapLog(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }
    }

    IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException;

    void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException;

    HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    HmsScanResult decodeWithBuffer(byte[] bArr, int i, int i2, IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException;
}
