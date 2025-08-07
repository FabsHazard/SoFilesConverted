package com.igexin.assist.action;

import android.text.TextUtils;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;

class b extends Thread {
    MessageBean a;
    final /* synthetic */ MessageManger b;

    b(MessageManger messageManger, MessageBean messageBean) {
        this.b = messageManger;
        this.a = messageBean;
    }

    public void run() {
        try {
            MessageBean messageBean = this.a;
            if (messageBean == null) {
                return;
            }
            if (messageBean.getMessageType().equals(AssistPushConsts.MSG_TYPE_TOKEN)) {
                String stringMessage = this.a.getStringMessage();
                com.igexin.a.a.c.b.a("Assist_MessageManger|token = " + stringMessage, new Object[0]);
                this.b.a(this.a.getContext(), stringMessage, this.a.extra.getBoolean("isForce"));
            } else if (this.a.getMessageType().equals(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
                if (!TextUtils.isEmpty(this.a.getStringMessage())) {
                    d dVar = new d();
                    dVar.a(this.a);
                    if (dVar.a(false) && dVar.e().equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                        this.b.a(dVar, this.a.getContext());
                    }
                }
            } else if (this.a.getMessageType().equals(AssistPushConsts.MSG_TYPE_ACTIONS)) {
                String stringMessage2 = this.a.getStringMessage();
                com.igexin.a.a.c.b.a("Assist_MessageManger|actions = " + stringMessage2, new Object[0]);
                if (!TextUtils.isEmpty(stringMessage2)) {
                    d dVar2 = new d();
                    dVar2.a(this.a);
                    if (dVar2.a(true) && dVar2.e().equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                        this.b.a(this.a.getContext(), dVar2);
                    }
                }
            }
        } catch (Throwable th) {
            com.igexin.a.a.c.b.a("Assist_MessageManger|err = " + th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }
}
