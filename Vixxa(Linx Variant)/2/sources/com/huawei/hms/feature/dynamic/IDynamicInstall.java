package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

public interface IDynamicInstall extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.feature.dynamic.IDynamicInstall";

    public static class Default implements IDynamicInstall {
        public IBinder asBinder() {
            return null;
        }

        public Bundle install(IObjectWrapper iObjectWrapper, Bundle bundle) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDynamicInstall {
        public static final int a = 1;

        public static class Proxy implements IDynamicInstall {
            public static IDynamicInstall sDefaultImpl;
            public IBinder a;

            public Proxy(IBinder iBinder) {
                this.a = iBinder;
            }

            public IBinder asBinder() {
                return this.a;
            }

            public String getInterfaceDescriptor() {
                return IDynamicInstall.DESCRIPTOR;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.os.Bundle} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public android.os.Bundle install(com.huawei.hms.feature.dynamic.IObjectWrapper r7, android.os.Bundle r8) throws android.os.RemoteException {
                /*
                    r6 = this;
                    android.os.Parcel r0 = android.os.Parcel.obtain()
                    android.os.Parcel r1 = android.os.Parcel.obtain()
                    java.lang.String r2 = "com.huawei.hms.feature.dynamic.IDynamicInstall"
                    r0.writeInterfaceToken(r2)     // Catch:{ all -> 0x005d }
                    r2 = 0
                    if (r7 == 0) goto L_0x0015
                    android.os.IBinder r3 = r7.asBinder()     // Catch:{ all -> 0x005d }
                    goto L_0x0016
                L_0x0015:
                    r3 = r2
                L_0x0016:
                    r0.writeStrongBinder(r3)     // Catch:{ all -> 0x005d }
                    r3 = 1
                    r4 = 0
                    if (r8 == 0) goto L_0x0024
                    r0.writeInt(r3)     // Catch:{ all -> 0x005d }
                    r8.writeToParcel(r0, r4)     // Catch:{ all -> 0x005d }
                    goto L_0x0027
                L_0x0024:
                    r0.writeInt(r4)     // Catch:{ all -> 0x005d }
                L_0x0027:
                    android.os.IBinder r5 = r6.a     // Catch:{ all -> 0x005d }
                    boolean r3 = r5.transact(r3, r0, r1, r4)     // Catch:{ all -> 0x005d }
                    if (r3 != 0) goto L_0x0044
                    com.huawei.hms.feature.dynamic.IDynamicInstall r3 = com.huawei.hms.feature.dynamic.IDynamicInstall.Stub.getDefaultImpl()     // Catch:{ all -> 0x005d }
                    if (r3 == 0) goto L_0x0044
                    com.huawei.hms.feature.dynamic.IDynamicInstall r2 = com.huawei.hms.feature.dynamic.IDynamicInstall.Stub.getDefaultImpl()     // Catch:{ all -> 0x005d }
                    android.os.Bundle r7 = r2.install(r7, r8)     // Catch:{ all -> 0x005d }
                    r1.recycle()
                    r0.recycle()
                    return r7
                L_0x0044:
                    r1.readException()     // Catch:{ all -> 0x005d }
                    int r7 = r1.readInt()     // Catch:{ all -> 0x005d }
                    if (r7 == 0) goto L_0x0056
                    android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR     // Catch:{ all -> 0x005d }
                    java.lang.Object r7 = r7.createFromParcel(r1)     // Catch:{ all -> 0x005d }
                    r2 = r7
                    android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ all -> 0x005d }
                L_0x0056:
                    r1.recycle()
                    r0.recycle()
                    return r2
                L_0x005d:
                    r7 = move-exception
                    r1.recycle()
                    r0.recycle()
                    throw r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.IDynamicInstall.Stub.Proxy.install(com.huawei.hms.feature.dynamic.IObjectWrapper, android.os.Bundle):android.os.Bundle");
            }
        }

        public Stub() {
            attachInterface(this, IDynamicInstall.DESCRIPTOR);
        }

        public static IDynamicInstall asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDynamicInstall.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDynamicInstall)) ? new Proxy(iBinder) : (IDynamicInstall) queryLocalInterface;
        }

        public static IDynamicInstall getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDynamicInstall iDynamicInstall) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iDynamicInstall == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iDynamicInstall;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(IDynamicInstall.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel.enforceInterface(IDynamicInstall.DESCRIPTOR);
                Bundle install = install(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (install != null) {
                    parcel2.writeInt(1);
                    install.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
        }
    }

    Bundle install(IObjectWrapper iObjectWrapper, Bundle bundle) throws RemoteException;
}
