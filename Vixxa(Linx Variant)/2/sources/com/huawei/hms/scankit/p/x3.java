package com.huawei.hms.scankit.p;

import android.os.Bundle;
import com.huawei.hms.feature.DynamicModuleInitializer;
import java.util.LinkedHashMap;

/* compiled from: HaLog60002 */
public final class x3 extends u3 {

    /* compiled from: HaLog60002 */
    class a extends LinkedHashMap<String, String> {
        a() {
            x3.this.g();
            putAll(x3.this.b);
        }
    }

    public x3() {
        super((Bundle) null, DynamicModuleInitializer.getContext());
    }

    public void c(Bundle bundle) {
        if (bundle != null && a()) {
            try {
                if (bundle.containsKey("scanType") && (bundle.get("scanType") instanceof Integer)) {
                    bundle.putString("scanType", u3.a(bundle.getInt("scanType")));
                }
                a aVar = new a();
                for (String str : bundle.keySet()) {
                    aVar.put(str, String.valueOf(bundle.get(str)));
                }
                a4.b().b("60002", aVar);
            } catch (RuntimeException unused) {
                o4.b("HaLog60002", "RuntimeException");
            } catch (Exception unused2) {
                o4.b("HaLog60002", "Exception");
            }
        }
    }
}
