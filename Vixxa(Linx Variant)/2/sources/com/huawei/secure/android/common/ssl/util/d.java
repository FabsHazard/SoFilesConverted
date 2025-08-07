package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

public class d extends AsyncTask<Context, Integer, Boolean> {
    private static final String a = "d";

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e) {
            g.b(a, "doInBackground: exception : " + e.getMessage());
            inputStream = null;
        }
        g.a(a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream == null) {
            return false;
        }
        f.a(inputStream);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        g.a(a, "onPreExecute");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            g.c(a, "onPostExecute: upate done");
        } else {
            g.b(a, "onPostExecute: upate failed");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        g.c(a, "onProgressUpdate");
    }
}
