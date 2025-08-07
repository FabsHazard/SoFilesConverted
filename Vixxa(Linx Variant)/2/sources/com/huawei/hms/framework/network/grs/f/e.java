package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class e {
    private static final String a = "e";
    public static final Set<String> b = Collections.unmodifiableSet(new a(16));

    class a extends HashSet<String> {
        a(int i) {
            super(i);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    private static String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        String str2;
        StringBuilder sb;
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str3 : str.split(">")) {
            if (b.contains(str3.trim())) {
                if ("ser_country".equals(str3.trim()) && !TextUtils.isEmpty(serCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(serCountry)) {
                    str2 = a;
                    sb = new StringBuilder("current route_by is serCountry and routerCountry is: ");
                } else if ("reg_country".equals(str3.trim()) && !TextUtils.isEmpty(regCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(regCountry)) {
                    Logger.i(a, "current route_by is regCountry and routerCountry is: " + regCountry);
                    return regCountry;
                } else if ("issue_country".equals(str3.trim()) && !TextUtils.isEmpty(issueCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(issueCountry)) {
                    Logger.i(a, "current route_by is issueCountry and routerCountry is: " + issueCountry);
                    return issueCountry;
                } else if ("geo_ip".equals(str3.trim())) {
                    serCountry = new b(context, aVar, grsBaseInfo).a(z);
                    str2 = a;
                    sb = new StringBuilder("current route_by is geo_ip and routerCountry is: ");
                }
                Logger.i(str2, sb.append(serCountry).toString());
                return serCountry;
            }
        }
        return "";
    }

    public static String b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(a, "routeBy must be not empty string or null.");
            return null;
        } else if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return a(context, aVar, str, grsBaseInfo, z);
        } else {
            Logger.v(a, "routeBy equals NO_ROUTE_POLICY");
            return "no_route_country";
        }
    }
}
