package com.igexin.push.core;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.a.a.c.b;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.core.a.e;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class r extends Handler implements ServiceConnection {
    private static volatile r b;
    private final ConcurrentLinkedQueue<Intent> a;
    /* access modifiers changed from: private */
    public final t c;
    private boolean d;
    private volatile Messenger e;
    private final IBinder.DeathRecipient f = new s(this);

    private r() {
        super(Looper.getMainLooper());
        t tVar = new t(this);
        this.c = tVar;
        this.a = new ConcurrentLinkedQueue<>();
        Message.obtain(tVar.a(), 3, 1, 0).sendToTarget();
    }

    public static r a() {
        if (b == null) {
            synchronized (r.class) {
                if (b == null) {
                    b = new r();
                }
            }
        }
        return b;
    }

    private void a(String str, String str2, String str3, byte[] bArr) {
        Intent intent = new Intent();
        intent.addFlags(32);
        intent.setAction("com.igexin.sdk.action." + str3);
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_MSG_DATA);
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, str3);
        bundle.putString("payloadid", str2 + ":" + str);
        bundle.putString("packagename", d.c);
        bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, bArr);
        intent.putExtras(bundle);
        intent.setPackage(d.e.getPackageName());
        d.e.sendBroadcast(intent, d.az);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z && this.e != null) {
            try {
                this.e.getBinder().unlinkToDeath(this.f, 0);
            } catch (Throwable unused) {
            }
            this.d = false;
            this.e = null;
        }
        if (!this.d) {
            e();
            this.d = true;
        }
    }

    /* access modifiers changed from: private */
    public boolean a(IBinder iBinder) {
        if (iBinder == null) {
            return false;
        }
        this.e = new Messenger(iBinder);
        try {
            iBinder.linkToDeath(this.f, 0);
            return true;
        } catch (Exception e2) {
            b.a("MsgServerSender|linkToDeath to iservice ex = " + e2.toString(), new Object[0]);
            return true;
        }
    }

    private void b(Intent intent) {
        if (intent != null) {
            if (this.e == null) {
                b.a("MsgServerSender|realSend, remoteMessenger is null", new Object[0]);
            }
            Bundle extras = intent.getExtras();
            if (extras != null && extras.get(PushConsts.CMD_ACTION) != null && (extras.get(PushConsts.CMD_ACTION) instanceof Integer)) {
                b.a("MsgServerSender|realSend action = " + extras.getInt(PushConsts.CMD_ACTION), new Object[0]);
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = intent;
                try {
                    this.e.send(obtain);
                } catch (Exception e2) {
                    b.a("MsgServerSender|realSend iservice error = " + e2.toString(), new Object[0]);
                    if (e2 instanceof DeadObjectException) {
                        Message.obtain(this.c.a(), 2, 0, 0).sendToTarget();
                    }
                }
            }
        }
    }

    private void e() {
        b.a("MsgServerSender|try to bind iservice", new Object[0]);
        try {
            Intent intent = new Intent(d.e, d());
            intent.setType(d.e.getPackageName());
            d.e.bindService(intent, this, 1);
        } catch (Exception e2) {
            Log.e("MsgServerSender", "bind iservice error = " + e2.toString());
            b.a("MsgServerSender|bind iservice error = " + e2.toString(), new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        while (!this.a.isEmpty()) {
            Intent poll = this.a.poll();
            if (poll != null) {
                b(poll);
            }
        }
    }

    private Intent g() {
        Intent intent = new Intent();
        intent.addFlags(32);
        intent.setAction("com.igexin.sdk.action." + d.a);
        intent.setPackage(d.e.getPackageName());
        return intent;
    }

    public void a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_SDKSERVICEPID);
        bundle.putInt(PushConsts.KEY_SERVICE_PIT, i);
        a(bundle);
    }

    public void a(Intent intent) {
        if (this.e != null) {
            b(intent);
        } else {
            this.a.add(intent);
        }
    }

    public void a(Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(intent);
    }

    public void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_DEVICETOKEN);
        bundle.putString(PushConsts.KEY_DEVICE_TOKEN, str);
        a(bundle);
    }

    public void a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new SetTagCmdMessage(str, str2, PushConsts.SET_TAG_RESULT));
        a(bundle);
    }

    public void a(String str, String str2, String str3, String str4) {
        byte[] bArr;
        b.a("startapp|broadcastPayload", new Object[0]);
        if (str4 != null) {
            bArr = str4.getBytes();
        } else {
            PushTaskBean pushTaskBean = d.ac.get(e.a().a(str, str2));
            bArr = pushTaskBean != null ? pushTaskBean.getMsgExtra() : null;
        }
        if (bArr != null) {
            b.a("startapp|broadcast|payload = ".concat(new String(bArr)), new Object[0]);
            if (d.a != null && d.a.equals(str3)) {
                Bundle bundle = new Bundle();
                bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_MSG_DATA);
                bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(str, str2, str2 + ":" + str, bArr));
                a(bundle);
            }
            a(str, str2, str3, bArr);
            return;
        }
        b.a("startapp|broadcast|payload is empty!", new Object[0]);
    }

    public void a(String str, String str2, String str3, String str4, long j) {
        String str5 = str;
        if (d.a != null && d.a.equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putInt(PushConsts.CMD_ACTION, 10010);
            bundle.putSerializable(PushConsts.KEY_CMD_MSG, new FeedbackCmdMessage(str2, str3, str4, j, PushConsts.THIRDPART_FEEDBACK));
            a(bundle);
        }
        Intent g = g();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(PushConsts.CMD_ACTION, PushConsts.THIRDPART_FEEDBACK);
        bundle2.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, str);
        String str6 = str2;
        bundle2.putString("taskid", str2);
        String str7 = str3;
        bundle2.putString("actionid", str3);
        String str8 = str4;
        bundle2.putString(WiseOpenHianalyticsData.UNION_RESULT, str4);
        bundle2.putLong("timestamp", j);
        g.putExtras(bundle2);
        d.e.sendBroadcast(g, d.az);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, 10011);
        bundle.putSerializable(PushConsts.KEY_NOTIFICATION_ARRIVED, new GTNotificationMessage(str, str2, str3, str4, str5, str6, str7));
        a(bundle);
    }

    public void b() {
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_SDKONLINESTATE);
        bundle.putBoolean(PushConsts.KEY_ONLINE_STATE, d.l);
        a(bundle);
        Intent g = g();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(PushConsts.CMD_ACTION, PushConsts.GET_SDKONLINESTATE);
        bundle2.putBoolean(PushConsts.KEY_ONLINE_STATE, d.l);
        g.putExtras(bundle2);
        d.e.sendBroadcast(g, d.az);
    }

    public void b(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new BindAliasCmdMessage(str, str2, 10010));
        a(bundle);
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.ACTION_NOTIFICATION_CLICKED);
        bundle.putSerializable(PushConsts.KEY_NOTIFICATION_CLICKED, new GTNotificationMessage(str, str2, str3, str4, str5, str6, str7));
        a(bundle);
    }

    public void c() {
        Log.d("PushService", "clientid is " + d.s);
        b.a("broadcastClientId|" + d.s, new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_CLIENTID);
        bundle.putString(PushConsts.KEY_CLIENT_ID, d.s);
        a(bundle);
        Intent g = g();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(PushConsts.CMD_ACTION, PushConsts.GET_CLIENTID);
        bundle2.putString(PushConsts.KEY_CLIENT_ID, d.s);
        g.putExtras(bundle2);
        d.e.sendBroadcast(g, d.az);
    }

    public void c(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new UnBindAliasCmdMessage(str, str2, 10011));
        a(bundle);
    }

    public Class d() {
        return x.a().c(d.e);
    }

    public void handleMessage(Message message) {
        int i = message.what;
        super.handleMessage(message);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b.a("MsgServerSender|remote iservice connected ", new Object[0]);
        Message.obtain(this.c.a(), 1, iBinder).sendToTarget();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        b.a("MsgServerSender|remote iservice disConnected ~~~", new Object[0]);
        Message.obtain(this.c.a(), 2, 0, 0).sendToTarget();
    }
}
