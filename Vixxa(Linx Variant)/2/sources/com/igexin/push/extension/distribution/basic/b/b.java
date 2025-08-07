package com.igexin.push.extension.distribution.basic.b;

import android.text.TextUtils;
import com.github.mikephil.charting.utils.Utils;
import com.igexin.push.core.bean.BaseAction;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends BaseAction {
    private long a;

    public static b a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("actionid")) {
            bVar.setActionId(jSONObject.getString("actionid"));
        }
        if (jSONObject.has(TransmitterActivityKt.OPERATION_TYPE)) {
            bVar.setType(jSONObject.getString(TransmitterActivityKt.OPERATION_TYPE));
        }
        if (jSONObject.has("do")) {
            bVar.setDoActionId(jSONObject.getString("do"));
        }
        if (jSONObject.has("delay")) {
            double d = jSONObject.getDouble("delay");
            if (d > Utils.DOUBLE_EPSILON) {
                bVar.a((long) (d * 1000.0d));
                return bVar;
            }
        }
        bVar.a(200);
        return bVar;
    }

    public long a() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }
}
