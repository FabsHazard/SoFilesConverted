package com.igexin.push.core.d;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import net.lingala.zip4j.util.InternalZipConstants;

public class n extends g {
    private static String e;

    public n() {
        super("cn.nubia.identity", "identity");
    }

    public String b(Context context) {
        Bundle bundle;
        if (TextUtils.isEmpty(e)) {
            try {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse("content://" + this.a + InternalZipConstants.ZIP_FILE_SEPARATOR + this.b));
                if (acquireContentProviderClient != null) {
                    bundle = acquireContentProviderClient.call("getOAID", (String) null, (Bundle) null);
                    Class.forName("android.content.ContentProviderClient").getMethod("close", new Class[0]).invoke(acquireContentProviderClient, new Object[0]);
                } else {
                    bundle = null;
                }
                if (bundle == null) {
                    return null;
                }
                if (bundle.getInt("code", -1) != 0) {
                    bundle.getString(CrashHianalyticsData.MESSAGE);
                } else {
                    e = bundle.getString("id");
                }
            } catch (Throwable unused) {
            }
        }
        return e;
    }
}
