package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: LocationCoordinateResultParser */
public class n4 extends t6 {
    private static final Pattern b = Pattern.compile("geo:([\\s\\-0-9.]+),([\\s\\-0-9.]+)(?:[,?].*)?", 2);

    public HmsScan b(s6 s6Var) {
        String a = t6.a(s6Var);
        Matcher matcher = b.matcher(a);
        if (!matcher.matches()) {
            return null;
        }
        try {
            HmsScan.LocationCoordinate locationCoordinate = new HmsScan.LocationCoordinate(Double.parseDouble(matcher.group(1)), Double.parseDouble(matcher.group(2)));
            return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a, HmsScan.LOCATION_COORDINATE_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(locationCoordinate));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
