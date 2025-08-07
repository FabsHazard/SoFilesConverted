package com.igexin.sdk;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class a extends Handler {
    final /* synthetic */ GTIntentService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(GTIntentService gTIntentService) {
        super(Looper.getMainLooper());
        this.a = gTIntentService;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            if (message.what == 1 && (message.obj instanceof Intent)) {
                GTIntentService gTIntentService = this.a;
                gTIntentService.processOnHandleIntent(gTIntentService, (Intent) message.obj);
            }
            super.handleMessage(message);
        }
    }
}
