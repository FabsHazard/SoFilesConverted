package com.igexin.assist.action;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.a.a.c.a.f;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.sdk.a;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.a.e;
import com.igexin.push.core.b.i;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import com.igexin.push.core.r;
import com.igexin.push.util.b;
import com.igexin.push.util.o;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.GTTransmitMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class MessageManger {
    private final ExecutorService a;
    private String b;
    private Class c;

    private MessageManger() {
        this.a = Executors.newSingleThreadExecutor();
    }

    /* synthetic */ MessageManger(a aVar) {
        this();
    }

    private PushTaskBean a(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(dVar.d());
        pushTaskBean.setMessageId(dVar.c());
        pushTaskBean.setTaskId(dVar.b());
        pushTaskBean.setId(String.valueOf(currentTimeMillis));
        pushTaskBean.setCurrentActionid(1);
        return pushTaskBean;
    }

    private Class a(Context context) {
        try {
            String str = (String) o.c(context, "uis", "", new String[0]);
            if (!TextUtils.isEmpty(str)) {
                return Class.forName(str);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, d dVar) {
        if (!d.f.get()) {
            AssistUtils.startGetuiService(context);
        }
        if (dVar != null) {
            Message obtain = Message.obtain();
            obtain.what = CoreConsts.l;
            obtain.obj = dVar.g();
            Bundle bundle = new Bundle();
            bundle.putString("content", dVar.g());
            if (dVar.a() != null) {
                bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, dVar.a());
            }
            obtain.setData(bundle);
            c.a().a(obtain);
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            new com.igexin.push.core.b.d(context).c(str);
            if (d.f.get()) {
                a(str, z);
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new a(this, str, z), 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(d dVar, Context context) {
        StringBuilder append;
        if (dVar != null && context != null) {
            try {
                com.igexin.push.core.b.d dVar2 = new com.igexin.push.core.b.d(context);
                if (!dVar2.a(dVar.b())) {
                    dVar2.b(dVar.b());
                    if (this.c == null) {
                        Class a2 = a(context);
                        this.c = a2;
                        if (a2 == null) {
                            this.c = (Class) b.a(context, GTIntentService.class).second;
                        }
                    }
                    if (this.c != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_MSG_DATA);
                        bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(dVar.b(), dVar.c(), dVar.c() + ":" + dVar.b(), dVar.a()));
                        r.a().a(bundle);
                    } else {
                        Intent intent = new Intent();
                        intent.addFlags(32);
                        intent.setAction("com.igexin.sdk.action." + dVar.d());
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt(PushConsts.CMD_ACTION, PushConsts.GET_MSG_DATA);
                        bundle2.putString("taskid", dVar.b());
                        bundle2.putString("messageid", dVar.c());
                        bundle2.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, dVar.d());
                        bundle2.putString("payloadid", dVar.c() + ":" + dVar.b());
                        bundle2.putString("packagename", dVar.f());
                        bundle2.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, dVar.a());
                        intent.putExtras(bundle2);
                        context.sendBroadcast(intent, d.az);
                    }
                    append = new StringBuilder().append(getBrandCode(context)).append("0");
                } else {
                    append = new StringBuilder().append(getBrandCode(context)).append("1");
                }
                feedbackPushMessage(context, dVar, append.toString());
            } catch (Throwable unused) {
            }
        }
    }

    private void a(String str) {
        try {
            r.a().a(str);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z) {
        Log.e("Assist_MessageManger", "other token = " + str);
        a(str);
        if (!z) {
            try {
                if (str.equals(d.z)) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        i.a().c(str);
        if (d.l) {
            e.a().e();
        } else if (z) {
            i.a().d("");
        }
    }

    public static MessageManger getInstance() {
        return c.a;
    }

    public void addMessage(MessageBean messageBean) {
        ExecutorService executorService = this.a;
        if (executorService != null) {
            executorService.execute(new b(this, messageBean));
        }
    }

    public void feedbackPushMessage(Context context, d dVar, String str) {
        try {
            if (d.f.get()) {
                e.a().a(a(dVar), str);
                return;
            }
            com.igexin.push.core.b.d dVar2 = new com.igexin.push.core.b.d(context);
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", String.valueOf(currentTimeMillis));
            jSONObject.put("messageid", dVar.c());
            jSONObject.put("taskid", dVar.b());
            jSONObject.put("multaid", str);
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
            dVar2.a(dVar.b(), jSONObject);
        } catch (Throwable unused) {
        }
    }

    public String getBrandCode(Context context) {
        String str;
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        if (a.e(context)) {
            str = "2";
        } else if (a.b(context)) {
            str = "3";
        } else if (a.c(context)) {
            str = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ;
        } else if (a.f(context)) {
            str = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_OPPO;
        } else if (a.g(context)) {
            str = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_VIVO;
        } else {
            if (a.h(context)) {
                str = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_ST;
            }
            return this.b;
        }
        this.b = str;
        return this.b;
    }

    public void log(String str) {
        f.a().a(str);
    }
}
