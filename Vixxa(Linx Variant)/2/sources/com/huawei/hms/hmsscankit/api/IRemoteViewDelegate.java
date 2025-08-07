package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.ml.scan.HmsScan;

public interface IRemoteViewDelegate extends IInterface {

    public static class Default implements IRemoteViewDelegate {
        public IBinder asBinder() {
            return null;
        }

        public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }

        public boolean getLightStatus() throws RemoteException {
            return false;
        }

        public IObjectWrapper getView() throws RemoteException {
            return null;
        }

        public void onCreate(Bundle bundle) throws RemoteException {
        }

        public void onDestroy() throws RemoteException {
        }

        public void onPause() throws RemoteException {
        }

        public void onResume() throws RemoteException {
        }

        public void onStart() throws RemoteException {
        }

        public void onStop() throws RemoteException {
        }

        public void pauseContinuouslyScan() throws RemoteException {
        }

        public void resumeContinuouslyScan() throws RemoteException {
        }

        public void setOnClickListener(IObjectWrapper iObjectWrapper) throws RemoteException {
        }

        public void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException {
        }

        public void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException {
        }

        public void setOnResultCallback(IOnResultCallback iOnResultCallback) throws RemoteException {
        }

        public void turnOffLight() throws RemoteException {
        }

        public void turnOnLight() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRemoteViewDelegate {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteViewDelegate";
        static final int TRANSACTION_decodeWithBitmap = 12;
        static final int TRANSACTION_getLightStatus = 14;
        static final int TRANSACTION_getView = 1;
        static final int TRANSACTION_onCreate = 2;
        static final int TRANSACTION_onDestroy = 3;
        static final int TRANSACTION_onPause = 4;
        static final int TRANSACTION_onResume = 5;
        static final int TRANSACTION_onStart = 6;
        static final int TRANSACTION_onStop = 7;
        static final int TRANSACTION_pauseContinuouslyScan = 16;
        static final int TRANSACTION_resumeContinuouslyScan = 15;
        static final int TRANSACTION_setOnClickListener = 9;
        static final int TRANSACTION_setOnErrorCallback = 17;
        static final int TRANSACTION_setOnLightVisbleCallBack = 13;
        static final int TRANSACTION_setOnResultCallback = 8;
        static final int TRANSACTION_turnOffLight = 11;
        static final int TRANSACTION_turnOnLight = 10;

        private static class Proxy implements IRemoteViewDelegate {
            public static IRemoteViewDelegate sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
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
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
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

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public boolean getLightStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightStatus();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IObjectWrapper getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getView();
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

            public void onCreate(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onCreate(bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDestroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onDestroy();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onPause();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onResume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onResume();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStart() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onStart();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onStop();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pauseContinuouslyScan() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().pauseContinuouslyScan();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resumeContinuouslyScan() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().resumeContinuouslyScan();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnClickListener(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setOnClickListener(iObjectWrapper);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOnErrorCallback != null ? iOnErrorCallback.asBinder() : null);
                    if (this.mRemote.transact(17, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setOnErrorCallback(iOnErrorCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOnLightCallback != null ? iOnLightCallback.asBinder() : null);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setOnLightVisbleCallBack(iOnLightCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnResultCallback(IOnResultCallback iOnResultCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOnResultCallback != null ? iOnResultCallback.asBinder() : null);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setOnResultCallback(iOnResultCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void turnOffLight() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().turnOffLight();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void turnOnLight() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().turnOnLight();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteViewDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteViewDelegate)) {
                return new Proxy(iBinder);
            }
            return (IRemoteViewDelegate) queryLocalInterface;
        }

        public static IRemoteViewDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteViewDelegate iRemoteViewDelegate) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iRemoteViewDelegate == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iRemoteViewDelegate;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v2, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v7 */
        /* JADX WARNING: type inference failed for: r0v8 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "com.huawei.hms.hmsscankit.api.IRemoteViewDelegate"
                if (r4 == r0) goto L_0x010c
                r0 = 0
                switch(r4) {
                    case 1: goto L_0x00f8;
                    case 2: goto L_0x00df;
                    case 3: goto L_0x00d5;
                    case 4: goto L_0x00cb;
                    case 5: goto L_0x00c1;
                    case 6: goto L_0x00b7;
                    case 7: goto L_0x00ad;
                    case 8: goto L_0x009b;
                    case 9: goto L_0x0089;
                    case 10: goto L_0x007f;
                    case 11: goto L_0x0075;
                    case 12: goto L_0x0057;
                    case 13: goto L_0x0045;
                    case 14: goto L_0x0037;
                    case 15: goto L_0x002d;
                    case 16: goto L_0x0023;
                    case 17: goto L_0x0011;
                    default: goto L_0x000c;
                }
            L_0x000c:
                boolean r4 = super.onTransact(r4, r5, r6, r7)
                return r4
            L_0x0011:
                r5.enforceInterface(r2)
                android.os.IBinder r4 = r5.readStrongBinder()
                com.huawei.hms.hmsscankit.api.IOnErrorCallback r4 = com.huawei.hms.hmsscankit.api.IOnErrorCallback.Stub.asInterface(r4)
                r3.setOnErrorCallback(r4)
                r6.writeNoException()
                return r1
            L_0x0023:
                r5.enforceInterface(r2)
                r3.pauseContinuouslyScan()
                r6.writeNoException()
                return r1
            L_0x002d:
                r5.enforceInterface(r2)
                r3.resumeContinuouslyScan()
                r6.writeNoException()
                return r1
            L_0x0037:
                r5.enforceInterface(r2)
                boolean r4 = r3.getLightStatus()
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x0045:
                r5.enforceInterface(r2)
                android.os.IBinder r4 = r5.readStrongBinder()
                com.huawei.hms.hmsscankit.api.IOnLightCallback r4 = com.huawei.hms.hmsscankit.api.IOnLightCallback.Stub.asInterface(r4)
                r3.setOnLightVisbleCallBack(r4)
                r6.writeNoException()
                return r1
            L_0x0057:
                r5.enforceInterface(r2)
                android.os.IBinder r4 = r5.readStrongBinder()
                com.huawei.hms.feature.dynamic.IObjectWrapper r4 = com.huawei.hms.feature.dynamic.IObjectWrapper.Stub.asInterface(r4)
                android.os.IBinder r5 = r5.readStrongBinder()
                com.huawei.hms.feature.dynamic.IObjectWrapper r5 = com.huawei.hms.feature.dynamic.IObjectWrapper.Stub.asInterface(r5)
                com.huawei.hms.ml.scan.HmsScan[] r4 = r3.decodeWithBitmap(r4, r5)
                r6.writeNoException()
                r6.writeTypedArray(r4, r1)
                return r1
            L_0x0075:
                r5.enforceInterface(r2)
                r3.turnOffLight()
                r6.writeNoException()
                return r1
            L_0x007f:
                r5.enforceInterface(r2)
                r3.turnOnLight()
                r6.writeNoException()
                return r1
            L_0x0089:
                r5.enforceInterface(r2)
                android.os.IBinder r4 = r5.readStrongBinder()
                com.huawei.hms.feature.dynamic.IObjectWrapper r4 = com.huawei.hms.feature.dynamic.IObjectWrapper.Stub.asInterface(r4)
                r3.setOnClickListener(r4)
                r6.writeNoException()
                return r1
            L_0x009b:
                r5.enforceInterface(r2)
                android.os.IBinder r4 = r5.readStrongBinder()
                com.huawei.hms.hmsscankit.api.IOnResultCallback r4 = com.huawei.hms.hmsscankit.api.IOnResultCallback.Stub.asInterface(r4)
                r3.setOnResultCallback(r4)
                r6.writeNoException()
                return r1
            L_0x00ad:
                r5.enforceInterface(r2)
                r3.onStop()
                r6.writeNoException()
                return r1
            L_0x00b7:
                r5.enforceInterface(r2)
                r3.onStart()
                r6.writeNoException()
                return r1
            L_0x00c1:
                r5.enforceInterface(r2)
                r3.onResume()
                r6.writeNoException()
                return r1
            L_0x00cb:
                r5.enforceInterface(r2)
                r3.onPause()
                r6.writeNoException()
                return r1
            L_0x00d5:
                r5.enforceInterface(r2)
                r3.onDestroy()
                r6.writeNoException()
                return r1
            L_0x00df:
                r5.enforceInterface(r2)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00f1
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r0 = r4
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x00f1:
                r3.onCreate(r0)
                r6.writeNoException()
                return r1
            L_0x00f8:
                r5.enforceInterface(r2)
                com.huawei.hms.feature.dynamic.IObjectWrapper r4 = r3.getView()
                r6.writeNoException()
                if (r4 == 0) goto L_0x0108
                android.os.IBinder r0 = r4.asBinder()
            L_0x0108:
                r6.writeStrongBinder(r0)
                return r1
            L_0x010c:
                r6.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.api.IRemoteViewDelegate.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    boolean getLightStatus() throws RemoteException;

    IObjectWrapper getView() throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;

    void pauseContinuouslyScan() throws RemoteException;

    void resumeContinuouslyScan() throws RemoteException;

    void setOnClickListener(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException;

    void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException;

    void setOnResultCallback(IOnResultCallback iOnResultCallback) throws RemoteException;

    void turnOffLight() throws RemoteException;

    void turnOnLight() throws RemoteException;
}
