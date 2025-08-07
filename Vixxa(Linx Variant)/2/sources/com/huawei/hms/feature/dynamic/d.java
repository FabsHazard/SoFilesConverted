package com.huawei.hms.feature.dynamic;

import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class d {
    public static final String b = "d";
    public static final d c = new d();
    public Set<String> a;

    public static d a() {
        return c;
    }

    public void a(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("installed_module_name");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            Logger.w(b, "Get installed module name failed.");
            this.a = new HashSet();
            return;
        }
        Logger.i(b, "Installed module name:" + stringArrayList);
        this.a = new HashSet(stringArrayList);
    }
}
