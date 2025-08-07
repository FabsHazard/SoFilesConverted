package com.igexin.sdk.aidl;

import android.os.IInterface;
import android.os.RemoteException;

public interface IGexinMsgService extends IInterface {
    byte[] extFunction(byte[] bArr) throws RemoteException;

    int isStarted(String str) throws RemoteException;

    int onASNLConnected(String str, String str2, String str3, long j) throws RemoteException;

    int onASNLNetworkConnected() throws RemoteException;

    int onASNLNetworkDisconnected() throws RemoteException;

    int onPSNLConnected(String str, String str2, String str3, long j) throws RemoteException;

    int receiveToPSNL(String str, String str2, byte[] bArr) throws RemoteException;

    int sendByASNL(String str, String str2, byte[] bArr) throws RemoteException;

    int setSilentTime(int i, int i2, String str) throws RemoteException;

    int startService(String str) throws RemoteException;

    int stopService(String str) throws RemoteException;
}
