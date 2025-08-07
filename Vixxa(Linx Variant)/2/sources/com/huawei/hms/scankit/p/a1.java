package com.huawei.hms.scankit.p;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Locale;

/* compiled from: CountryCodeBean */
public class a1 {
    private static final String c = "a1";
    private String a = GrsBaseInfo.CountryCodeSource.UNKNOWN;
    private String b = GrsBaseInfo.CountryCodeSource.UNKNOWN;

    public a1(Context context, boolean z) {
        a(context, z);
        this.b = this.b.toUpperCase(Locale.ENGLISH);
    }

    private boolean b() {
        return !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(this.b);
    }

    public String a() {
        return this.b;
    }

    private void a(Context context, boolean z) {
        if (context != null) {
            try {
                this.b = GrsApp.getInstance().getIssueCountryCode(context);
                if (b()) {
                    Logger.i(c, "getCountryCode unknown");
                }
            } catch (NullPointerException unused) {
                Logger.w(c, "get CountryCode error");
            } catch (Exception unused2) {
                Logger.w(c, "get CountryCode error");
            }
        }
    }
}
