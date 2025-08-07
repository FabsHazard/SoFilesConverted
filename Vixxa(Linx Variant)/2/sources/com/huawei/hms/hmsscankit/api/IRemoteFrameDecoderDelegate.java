package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.scankit.p.s6;

public interface IRemoteFrameDecoderDelegate extends IInterface {

    public static class Default implements IRemoteFrameDecoderDelegate {
        public IBinder asBinder() {
            return null;
        }

        public s6[] decode(byte[] bArr, int i, int i2, int i3, int i4, IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRemoteFrameDecoderDelegate {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate";
        static final int TRANSACTION_decode = 1;

        private static class Proxy implements IRemoteFrameDecoderDelegate {
            public static IRemoteFrameDecoderDelegate sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public s6[] decode(byte[] bArr, int i, int i2, int i3, int i4, IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    byte[] bArr2 = bArr;
                    obtain.writeByteArray(bArr);
                    int i5 = i;
                    obtain.writeInt(i);
                    int i6 = i2;
                    obtain.writeInt(i2);
                    int i7 = i3;
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    try {
                        if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            s6[] s6VarArr = (s6[]) obtain2.createTypedArray(s6.CREATOR);
                            obtain2.recycle();
                            obtain.recycle();
                            return s6VarArr;
                        }
                        s6[] decode = Stub.getDefaultImpl().decode(bArr, i, i2, i3, i4, iObjectWrapper);
                        obtain2.recycle();
                        obtain.recycle();
                        return decode;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteFrameDecoderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteFrameDecoderDelegate)) {
                return new Proxy(iBinder);
            }
            return (IRemoteFrameDecoderDelegate) queryLocalInterface;
        }

        public static IRemoteFrameDecoderDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteFrameDecoderDelegate iRemoteFrameDecoderDelegate) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iRemoteFrameDecoderDelegate == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iRemoteFrameDecoderDelegate;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                s6[] decode = decode(parcel.createByteArray(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeTypedArray(decode, 1);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    s6[] decode(byte[] bArr, int i, int i2, int i3, int i4, IObjectWrapper iObjectWrapper) throws RemoteException;
}
