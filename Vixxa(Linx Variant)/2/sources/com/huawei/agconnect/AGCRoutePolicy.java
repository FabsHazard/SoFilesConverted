package com.huawei.agconnect;

import com.huawei.hms.feature.dynamic.f.e;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Arrays;

public final class AGCRoutePolicy {
    public static final AGCRoutePolicy CHINA = new AGCRoutePolicy(1);
    public static final AGCRoutePolicy GERMANY = new AGCRoutePolicy(2);
    public static final AGCRoutePolicy RUSSIA = new AGCRoutePolicy(3);
    public static final AGCRoutePolicy SINGAPORE = new AGCRoutePolicy(4);
    public static final AGCRoutePolicy UNKNOWN = new AGCRoutePolicy(0);
    private final int route;

    private AGCRoutePolicy(int i) {
        this.route = i;
    }

    private int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.route == ((AGCRoutePolicy) obj).route;
    }

    public String getRouteName() {
        int i = this.route;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "SG" : "RU" : "DE" : e.e;
    }

    public int hashCode() {
        return hash(Integer.valueOf(this.route));
    }
}
