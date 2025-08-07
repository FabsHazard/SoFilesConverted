package com.igexin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.a.a.c.b;
import com.igexin.push.core.a.e;
import com.igexin.push.core.x;

public class GetuiActivity extends Activity {
    private String a = "GetuiActivity";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Intent intent = new Intent(this, e.a().a((Context) this));
        try {
            super.onCreate(bundle);
            Intent intent2 = getIntent();
            if (intent2 != null && intent2.hasExtra(PushConsts.CMD_ACTION) && intent2.hasExtra("broadcast_intent")) {
                intent.putExtra(PushConsts.CMD_ACTION, intent2.getStringExtra(PushConsts.CMD_ACTION));
                intent.putExtra("broadcast_intent", (Intent) intent2.getParcelableExtra("broadcast_intent"));
            }
        } catch (Throwable th) {
            b.a(this.a + "|put extra exception" + th.toString(), new Object[0]);
        }
        x.a().a((Context) this, intent);
        finish();
    }
}
