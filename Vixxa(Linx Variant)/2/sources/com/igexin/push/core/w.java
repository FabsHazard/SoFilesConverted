package com.igexin.push.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.push.config.l;
import com.igexin.push.core.a.a.a;
import com.igexin.push.core.a.a.b;
import com.igexin.push.core.a.a.c;
import com.igexin.push.core.a.a.d;
import com.igexin.push.core.a.a.e;
import com.igexin.push.core.a.a.f;
import com.igexin.push.core.a.a.g;
import com.igexin.push.core.a.a.h;
import com.igexin.push.core.a.a.i;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import com.microtech.aidexx.utils.TimeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class w {
    private static w a;
    private static Map<String, a> b;
    private static Set<String> c;

    private w() {
        c = new HashSet();
        b = new HashMap();
        c.add("goto");
        c.add("notification");
        c.add("terminatetask");
        c.add("startmyactivity");
        c.add("startapp");
        c.add("null");
        c.add("startweb");
        c.add("checkapp");
    }

    private a a(String str) {
        Map<String, a> map;
        Object bVar;
        if (TextUtils.isEmpty(str) || !c.contains(str)) {
            return null;
        }
        a aVar = b.get(str);
        if (aVar != null) {
            return aVar;
        }
        String str2 = "goto";
        if (str.equals(str2)) {
            map = b;
            bVar = new d();
        } else {
            str2 = "notification";
            if (str.equals(str2)) {
                map = b;
                bVar = new e();
            } else {
                str2 = "terminatetask";
                if (str.equals(str2)) {
                    map = b;
                    bVar = new i();
                } else {
                    str2 = "startmyactivity";
                    if (str.equals(str2)) {
                        map = b;
                        bVar = new f();
                    } else {
                        str2 = "startapp";
                        if (str.equals(str2)) {
                            map = b;
                            bVar = new h();
                        } else {
                            str2 = "null";
                            if (str.equals(str2)) {
                                map = b;
                                bVar = new c();
                            } else {
                                str2 = "startweb";
                                if (str.equals(str2)) {
                                    map = b;
                                    bVar = new g();
                                } else {
                                    str2 = "checkapp";
                                    if (str.equals(str2)) {
                                        map = b;
                                        bVar = new b();
                                    }
                                    return b.get(str);
                                }
                            }
                        }
                    }
                }
            }
        }
        map.put(str2, bVar);
        return b.get(str);
    }

    public static w a() {
        if (a == null) {
            a = new w();
        }
        return a;
    }

    private void a(int i, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i));
        n.a().b(str, contentValues);
    }

    private boolean a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            return !jSONObject2.has("wifi") && !jSONObject2.has("screenOn") && !jSONObject2.has(TypedValues.TransitionType.S_DURATION) && !jSONObject2.has("netConnected");
        } catch (Exception unused) {
            return true;
        }
    }

    private void b(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            HashMap hashMap = new HashMap();
            if (jSONObject2.has("wifi")) {
                hashMap.put("wifi", jSONObject2.getString("wifi"));
            }
            if (jSONObject2.has("screenOn")) {
                hashMap.put("screenOn", jSONObject2.getString("screenOn"));
            }
            if (jSONObject2.has(TypedValues.TransitionType.S_DURATION)) {
                String string = jSONObject2.getString(TypedValues.TransitionType.S_DURATION);
                if (string.contains("-")) {
                    int indexOf = string.indexOf("-");
                    String substring = string.substring(0, indexOf);
                    String substring2 = string.substring(indexOf + 1, string.length());
                    hashMap.put("startTime", substring);
                    hashMap.put("endTime", substring2);
                }
            }
            if (jSONObject2.has("netConnected")) {
                hashMap.put("netConnected", jSONObject2.getString("netConnected"));
            }
            if (jSONObject2.has("expiredTime")) {
                String string2 = jSONObject2.getString("expiredTime");
                if (!TextUtils.isEmpty(string2) && TextUtils.isDigitsOnly(string2)) {
                    hashMap.put("expiredTime", string2);
                }
            }
            pushTaskBean.setConditionMap(hashMap);
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e4, code lost:
        if (r2 != null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0104, code lost:
        if (r2 == null) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0106, code lost:
        r2.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean h() {
        /*
            r14 = this;
            java.lang.String r0 = "status"
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r1 = com.igexin.push.core.d.ac
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0111
            boolean r1 = com.igexin.push.core.d.n
            if (r1 == 0) goto L_0x0111
            r1 = 0
            r2 = 0
            com.igexin.push.core.c r3 = com.igexin.push.core.c.a()     // Catch:{ all -> 0x00e7 }
            com.igexin.push.b.b r4 = r3.k()     // Catch:{ all -> 0x00e7 }
            java.lang.String r5 = "message"
            r3 = 1
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ all -> 0x00e7 }
            r6[r1] = r0     // Catch:{ all -> 0x00e7 }
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ all -> 0x00e7 }
            java.lang.String r8 = "0"
            r7[r1] = r8     // Catch:{ all -> 0x00e7 }
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r4.a(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00e7 }
            if (r2 == 0) goto L_0x00e2
        L_0x002d:
            boolean r4 = r2.moveToNext()     // Catch:{ all -> 0x00e7 }
            if (r4 == 0) goto L_0x00e2
            java.lang.String r4 = "msgextra"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ all -> 0x00e7 }
            byte[] r4 = r2.getBlob(r4)     // Catch:{ all -> 0x00e7 }
            java.lang.String r5 = "info"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x00e7 }
            byte[] r5 = r2.getBlob(r5)     // Catch:{ all -> 0x00e7 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002d }
            java.lang.String r7 = new java.lang.String     // Catch:{ JSONException -> 0x002d }
            byte[] r5 = com.igexin.a.b.a.c(r5)     // Catch:{ JSONException -> 0x002d }
            r7.<init>(r5)     // Catch:{ JSONException -> 0x002d }
            r6.<init>(r7)     // Catch:{ JSONException -> 0x002d }
            java.lang.String r5 = "id"
            java.lang.String r5 = r6.getString(r5)     // Catch:{ JSONException -> 0x002d }
            java.lang.String r7 = "appid"
            java.lang.String r7 = r6.getString(r7)     // Catch:{ JSONException -> 0x002d }
            java.lang.String r8 = "messageid"
            java.lang.String r8 = r6.getString(r8)     // Catch:{ JSONException -> 0x002d }
            java.lang.String r9 = "taskid"
            java.lang.String r9 = r6.getString(r9)     // Catch:{ JSONException -> 0x002d }
            java.lang.String r10 = "appkey"
            java.lang.String r10 = r6.getString(r10)     // Catch:{ JSONException -> 0x002d }
            java.lang.String r11 = "action_chains"
            org.json.JSONArray r11 = r6.getJSONArray(r11)     // Catch:{ JSONException -> 0x002d }
            com.igexin.push.core.a.e r12 = com.igexin.push.core.a.e.a()     // Catch:{ JSONException -> 0x002d }
            java.lang.String r12 = r12.a((java.lang.String) r9, (java.lang.String) r8)     // Catch:{ JSONException -> 0x002d }
            com.igexin.push.core.bean.PushTaskBean r13 = new com.igexin.push.core.bean.PushTaskBean     // Catch:{ JSONException -> 0x002d }
            r13.<init>()     // Catch:{ JSONException -> 0x002d }
            r13.setAppid(r7)     // Catch:{ JSONException -> 0x002d }
            r13.setMessageId(r8)     // Catch:{ JSONException -> 0x002d }
            r13.setTaskId(r9)     // Catch:{ JSONException -> 0x002d }
            r13.setId(r5)     // Catch:{ JSONException -> 0x002d }
            r13.setAppKey(r10)     // Catch:{ JSONException -> 0x002d }
            r13.setCurrentActionid(r3)     // Catch:{ JSONException -> 0x002d }
            int r5 = r2.getColumnIndex(r0)     // Catch:{ JSONException -> 0x002d }
            int r5 = r2.getInt(r5)     // Catch:{ JSONException -> 0x002d }
            r13.setStatus(r5)     // Catch:{ JSONException -> 0x002d }
            if (r4 == 0) goto L_0x00a8
            r13.setMsgExtra(r4)     // Catch:{ JSONException -> 0x002d }
        L_0x00a8:
            java.lang.String r4 = "condition"
            boolean r4 = r6.has(r4)     // Catch:{ JSONException -> 0x002d }
            if (r4 == 0) goto L_0x00b3
            r14.b((org.json.JSONObject) r6, (com.igexin.push.core.bean.PushTaskBean) r13)     // Catch:{ JSONException -> 0x002d }
        L_0x00b3:
            int r4 = r11.length()     // Catch:{ JSONException -> 0x002d }
            if (r4 <= 0) goto L_0x00db
            boolean r4 = r14.a((org.json.JSONObject) r6, (com.igexin.push.core.bean.PushTaskBean) r13)     // Catch:{ JSONException -> 0x002d }
            if (r4 != 0) goto L_0x00db
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x002d }
            r4.<init>()     // Catch:{ JSONException -> 0x002d }
            java.lang.String r5 = "PushMessageExecutor|load task from db parseActionChains result = false ####### "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ JSONException -> 0x002d }
            java.lang.String r5 = r6.toString()     // Catch:{ JSONException -> 0x002d }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ JSONException -> 0x002d }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x002d }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ JSONException -> 0x002d }
            com.igexin.a.a.c.b.a((java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ JSONException -> 0x002d }
        L_0x00db:
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r4 = com.igexin.push.core.d.ac     // Catch:{ JSONException -> 0x002d }
            r4.put(r12, r13)     // Catch:{ JSONException -> 0x002d }
            goto L_0x002d
        L_0x00e2:
            com.igexin.push.core.d.n = r1     // Catch:{ all -> 0x00e7 }
            if (r2 == 0) goto L_0x0111
            goto L_0x0106
        L_0x00e7:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            r3.<init>()     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "PushMessageExecutor|checkPushMessageMapValue error:"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x010a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x010a }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ all -> 0x010a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x010a }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x010a }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x010a }
            if (r2 == 0) goto L_0x0111
        L_0x0106:
            r2.close()
            goto L_0x0111
        L_0x010a:
            r0 = move-exception
            if (r2 == 0) goto L_0x0110
            r2.close()
        L_0x0110:
            throw r0
        L_0x0111:
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r0 = com.igexin.push.core.d.ac
            boolean r0 = r0.isEmpty()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.w.h():boolean");
    }

    public void a(ContentValues contentValues) {
        try {
            if (d.at < 1000) {
                n.a().a(contentValues.getAsString("taskid"), contentValues);
            } else {
                int a2 = c.a().k().a(CrashHianalyticsData.MESSAGE, "id IN (SELECT id from message where status IS NULL or status=1 or status=2 order by id asc limit 250)");
                d.at -= a2;
                if (a2 < 250) {
                    d.at -= c.a().k().a(CrashHianalyticsData.MESSAGE, "id IN (SELECT id from message where status=0 order by id asc limit " + (ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION - a2) + ")");
                }
                n.a().a(contentValues.getAsString("taskid"), contentValues);
            }
            d.at++;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Intent r12) {
        /*
            r11 = this;
            java.lang.String r0 = "taskid"
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = "messageid"
            java.lang.String r9 = r12.getStringExtra(r1)
            java.lang.String r1 = "actionid"
            java.lang.String r10 = r12.getStringExtra(r1)
            java.lang.String r1 = "accesstoken"
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r2 = "title"
            boolean r3 = r12.hasExtra(r2)
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0028
            java.lang.String r2 = r12.getStringExtra(r2)
            r5 = r2
            goto L_0x0029
        L_0x0028:
            r5 = r4
        L_0x0029:
            java.lang.String r2 = "content"
            boolean r3 = r12.hasExtra(r2)
            if (r3 == 0) goto L_0x0037
            java.lang.String r2 = r12.getStringExtra(r2)
            r6 = r2
            goto L_0x0038
        L_0x0037:
            r6 = r4
        L_0x0038:
            java.lang.String r2 = "notifID"
            r3 = 0
            int r2 = r12.getIntExtra(r2, r3)
            java.lang.String r3 = "url"
            java.lang.String r7 = r12.getStringExtra(r3)
            java.lang.String r3 = "intentUri"
            java.lang.String r8 = r12.getStringExtra(r3)
            java.lang.String r3 = "payload"
            java.lang.String r12 = r12.getStringExtra(r3)
            android.content.Context r3 = com.igexin.push.core.d.e
            java.lang.String r4 = "notification"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.app.NotificationManager r3 = (android.app.NotificationManager) r3
            if (r2 == 0) goto L_0x0061
        L_0x005d:
            r3.cancel(r2)
            goto L_0x0076
        L_0x0061:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.igexin.push.core.d.ad
            boolean r2 = r2.containsKey(r0)
            if (r2 == 0) goto L_0x0076
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.igexin.push.core.d.ad
            java.lang.Object r2 = r2.get(r0)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            goto L_0x005d
        L_0x0076:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.igexin.push.core.d.ad
            r2.remove(r0)
            java.lang.String r2 = com.igexin.push.core.d.ai
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x008f
            java.lang.String r12 = "ACTION_BROADCAST_TO_DOACTION accesstoken NOT match."
            java.lang.Object[] r12 = new java.lang.Object[]{r12}
            java.lang.String r0 = "PushMessageExecutor"
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r12)
            goto L_0x00a0
        L_0x008f:
            com.igexin.push.core.r r1 = com.igexin.push.core.r.a()
            r2 = r0
            r3 = r9
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r12
            r1.b(r2, r3, r4, r5, r6, r7, r8)
            r11.b(r0, r9, r10)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.w.a(android.content.Intent):void");
    }

    public void a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        Message obtain = Message.obtain();
        obtain.what = CoreConsts.h;
        obtain.obj = bundle;
        c.a().a(obtain);
    }

    public boolean a(String str, String str2, String str3) {
        if (Thread.currentThread().getId() == c.a().e()) {
            b(str, str2, str3);
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", str3);
        Message obtain = Message.obtain();
        obtain.what = CoreConsts.i;
        obtain.obj = bundle;
        return c.a().a(obtain);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b7 A[Catch:{ all -> 0x0123 }, LOOP:3: B:22:0x00b7->B:25:0x00c7, LOOP_START, PHI: r7 
      PHI: (r7v3 com.igexin.push.core.bean.BaseAction) = (r7v2 com.igexin.push.core.bean.BaseAction), (r7v9 com.igexin.push.core.bean.BaseAction) binds: [B:21:0x0088, B:25:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(org.json.JSONObject r10, com.igexin.push.core.bean.PushTaskBean r11) {
        /*
            r9 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "PushMessageExecutor------parse pushmessage actionchain json start-------"
            com.igexin.a.a.c.b.a((java.lang.String) r2, (java.lang.Object[]) r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "action_chains"
            org.json.JSONArray r10 = r10.getJSONArray(r2)     // Catch:{ all -> 0x0123 }
            r2 = r0
        L_0x0014:
            int r3 = r10.length()     // Catch:{ all -> 0x0123 }
            java.lang.String r4 = "type"
            if (r2 >= r3) goto L_0x0081
            java.lang.Object r3 = r10.get(r2)     // Catch:{ all -> 0x0123 }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ all -> 0x0123 }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ all -> 0x0123 }
            com.igexin.push.extension.a r4 = com.igexin.push.extension.a.a()     // Catch:{ all -> 0x0123 }
            java.util.List r4 = r4.b()     // Catch:{ all -> 0x0123 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0123 }
        L_0x0032:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0123 }
            if (r5 == 0) goto L_0x0045
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0123 }
            com.igexin.push.extension.stub.IPushExtension r5 = (com.igexin.push.extension.stub.IPushExtension) r5     // Catch:{ all -> 0x0123 }
            boolean r5 = r5.isActionSupported(r3)     // Catch:{ all -> 0x0123 }
            if (r5 == 0) goto L_0x0032
            goto L_0x007e
        L_0x0045:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0123 }
            r4.<init>()     // Catch:{ all -> 0x0123 }
            java.lang.String r5 = "PushMessageExecutor|extension not suport type = "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0123 }
            java.lang.StringBuilder r4 = r4.append(r3)     // Catch:{ all -> 0x0123 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0123 }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x0123 }
            com.igexin.a.a.c.b.a((java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0123 }
            java.util.Set<java.lang.String> r4 = c     // Catch:{ all -> 0x0123 }
            boolean r4 = r4.contains(r3)     // Catch:{ all -> 0x0123 }
            if (r4 != 0) goto L_0x007e
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0123 }
            r10.<init>()     // Catch:{ all -> 0x0123 }
            java.lang.String r2 = "PushMessageExecutor|action cannot be supported! --"
            java.lang.StringBuilder r10 = r10.append(r2)     // Catch:{ all -> 0x0123 }
            java.lang.StringBuilder r10 = r10.append(r3)     // Catch:{ all -> 0x0123 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0123 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0123 }
            com.igexin.a.a.c.b.a((java.lang.String) r10, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0123 }
            return r0
        L_0x007e:
            int r2 = r2 + 1
            goto L_0x0014
        L_0x0081:
            r2 = r0
        L_0x0082:
            int r3 = r10.length()     // Catch:{ all -> 0x0123 }
            if (r2 >= r3) goto L_0x013c
            java.lang.Object r3 = r10.get(r2)     // Catch:{ all -> 0x0123 }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ all -> 0x0123 }
            java.lang.String r5 = r3.getString(r4)     // Catch:{ all -> 0x0123 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0123 }
            r6.<init>()     // Catch:{ all -> 0x0123 }
            java.lang.String r7 = "PushMessageExecutor|start parse type = "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x0123 }
            java.lang.StringBuilder r6 = r6.append(r5)     // Catch:{ all -> 0x0123 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0123 }
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ all -> 0x0123 }
            com.igexin.a.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ all -> 0x0123 }
            com.igexin.push.extension.a r6 = com.igexin.push.extension.a.a()     // Catch:{ all -> 0x0123 }
            java.util.List r6 = r6.b()     // Catch:{ all -> 0x0123 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0123 }
            r7 = 0
        L_0x00b7:
            boolean r8 = r6.hasNext()     // Catch:{ all -> 0x0123 }
            if (r8 == 0) goto L_0x00c9
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0123 }
            com.igexin.push.extension.stub.IPushExtension r7 = (com.igexin.push.extension.stub.IPushExtension) r7     // Catch:{ all -> 0x0123 }
            com.igexin.push.core.bean.BaseAction r7 = r7.parseAction(r3)     // Catch:{ all -> 0x0123 }
            if (r7 == 0) goto L_0x00b7
        L_0x00c9:
            if (r7 != 0) goto L_0x00f4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0123 }
            r6.<init>()     // Catch:{ all -> 0x0123 }
            java.lang.String r8 = "PushMessageExecutor|extension can't process type = "
            java.lang.StringBuilder r6 = r6.append(r8)     // Catch:{ all -> 0x0123 }
            java.lang.StringBuilder r6 = r6.append(r5)     // Catch:{ all -> 0x0123 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0123 }
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch:{ all -> 0x0123 }
            com.igexin.a.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0123 }
            com.igexin.push.core.a.a.a r5 = r9.a((java.lang.String) r5)     // Catch:{ all -> 0x0123 }
            if (r5 == 0) goto L_0x0112
            com.igexin.push.core.bean.BaseAction r3 = r5.a(r3)     // Catch:{ all -> 0x0123 }
            if (r3 == 0) goto L_0x00f2
            r3.setSupportExt(r0)     // Catch:{ all -> 0x0123 }
        L_0x00f2:
            r7 = r3
            goto L_0x0112
        L_0x00f4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0123 }
            r3.<init>()     // Catch:{ all -> 0x0123 }
            java.lang.String r6 = "PushMessageExecutor|extension process type = "
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ all -> 0x0123 }
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ all -> 0x0123 }
            java.lang.String r5 = " success"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ all -> 0x0123 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0123 }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x0123 }
            com.igexin.a.a.c.b.a((java.lang.String) r3, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0123 }
        L_0x0112:
            if (r7 != 0) goto L_0x011c
            java.lang.String r10 = "PushMessageExecutor|action chains can't parse, throw ++++++"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0123 }
            com.igexin.a.a.c.b.a((java.lang.String) r10, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0123 }
            return r0
        L_0x011c:
            r1.add(r7)     // Catch:{ all -> 0x0123 }
            int r2 = r2 + 1
            goto L_0x0082
        L_0x0123:
            r10 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "PushMessageExecutor|"
            r2.<init>(r3)
            java.lang.String r10 = r10.toString()
            java.lang.StringBuilder r10 = r2.append(r10)
            java.lang.String r10 = r10.toString()
            java.lang.Object[] r2 = new java.lang.Object[r0]
            com.igexin.a.a.c.b.a((java.lang.String) r10, (java.lang.Object[]) r2)
        L_0x013c:
            r11.setActionChains(r1)
            java.lang.String r10 = "PushMessageExecutor------parse pushmessage actionchain json end-------"
            java.lang.Object[] r11 = new java.lang.Object[r0]
            com.igexin.a.a.c.b.a((java.lang.String) r10, (java.lang.Object[]) r11)
            r10 = 1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.w.a(org.json.JSONObject, com.igexin.push.core.bean.PushTaskBean):boolean");
    }

    public boolean a(JSONObject jSONObject, byte[] bArr, boolean z) {
        JSONObject jSONObject2;
        w wVar;
        int i;
        JSONObject jSONObject3 = jSONObject;
        byte[] bArr2 = bArr;
        boolean z2 = z;
        try {
            if (!jSONObject3.has(PushConsts.CMD_ACTION) || !jSONObject3.getString(PushConsts.CMD_ACTION).equals("pushmessage")) {
                return true;
            }
            String string = jSONObject3.getString("id");
            String string2 = jSONObject3.getString(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID);
            String string3 = jSONObject3.getString("messageid");
            String string4 = jSONObject3.getString("taskid");
            String string5 = jSONObject3.getString("appkey");
            try {
                JSONArray jSONArray = jSONObject3.getJSONArray("action_chains");
                com.igexin.a.a.c.b.a("pushmessage|" + string4 + Logger.c + string3 + Logger.c + string2 + Logger.c + z2, new Object[0]);
                if (string2.equals(d.a)) {
                    PushTaskBean pushTaskBean = new PushTaskBean();
                    pushTaskBean.setAppid(string2);
                    pushTaskBean.setMessageId(string3);
                    pushTaskBean.setTaskId(string4);
                    pushTaskBean.setId(string);
                    pushTaskBean.setAppKey(string5);
                    pushTaskBean.setCurrentActionid(1);
                    String a2 = com.igexin.push.core.a.e.a().a(string4, string3);
                    if (z2) {
                        com.igexin.push.core.a.e.a().c(pushTaskBean, "0");
                        if (com.igexin.push.util.a.b(string4)) {
                            com.igexin.a.a.c.b.a("PushMessageExecutor|" + string4 + " in blacklist ###", new Object[0]);
                            return true;
                        } else if (com.igexin.push.util.a.a(System.currentTimeMillis())) {
                            return true;
                        } else {
                            if (com.igexin.push.util.a.a(jSONObject)) {
                                com.igexin.a.a.c.b.a("PushMessageExecutor|message have loop", new Object[0]);
                                return true;
                            }
                        }
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("messageid", string3);
                    contentValues.put("taskid", string4);
                    contentValues.put(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, string2);
                    contentValues.put("key", "CACHE_" + a2);
                    contentValues.put(TransmitterActivityKt.BLE_INFO, com.igexin.a.b.a.b(jSONObject.toString().getBytes()));
                    contentValues.put("createtime", Long.valueOf(System.currentTimeMillis()));
                    if (bArr2 != null) {
                        contentValues.put("msgextra", bArr2);
                        pushTaskBean.setMsgExtra(bArr2);
                    }
                    if (jSONArray.length() > 0) {
                        wVar = this;
                        jSONObject2 = jSONObject;
                        if (!wVar.a(jSONObject2, pushTaskBean)) {
                            com.igexin.a.a.c.b.a("PushMessageExecutor parseActionChains result = false #######", new Object[0]);
                            return true;
                        }
                    } else {
                        wVar = this;
                        jSONObject2 = jSONObject;
                    }
                    if (z2) {
                        try {
                            if (n.a().a(string4)) {
                                return true;
                            }
                            if (jSONObject2.has("condition")) {
                                wVar.b(jSONObject2, pushTaskBean);
                                pushTaskBean.setStatus(CoreConsts.m);
                                i = CoreConsts.m;
                            } else {
                                pushTaskBean.setStatus(CoreConsts.n);
                                i = CoreConsts.n;
                            }
                            contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i));
                            wVar.a(contentValues);
                            d.ac.put(a2, pushTaskBean);
                            if (jSONObject2.has("condition")) {
                                f();
                                return true;
                            }
                            wVar.a(string4, string3);
                            return true;
                        } catch (Exception unused) {
                            return true;
                        }
                    } else {
                        if (jSONObject2.has("condition")) {
                            wVar.b(jSONObject2, pushTaskBean);
                        }
                        pushTaskBean.setStatus(CoreConsts.n);
                        d.ac.put(a2, pushTaskBean);
                        return true;
                    }
                } else {
                    com.igexin.a.a.c.b.a("PushMessageExecutor receieve error pushmessage", new Object[0]);
                    return true;
                }
            } catch (Exception e) {
                e = e;
                com.igexin.a.a.c.b.a("PushMessageExecutor " + e.toString(), new Object[0]);
                return true;
            }
        } catch (Exception e2) {
            e = e2;
            com.igexin.a.a.c.b.a("PushMessageExecutor " + e.toString(), new Object[0]);
            return true;
        }
    }

    public void b(String str, String str2) {
        com.igexin.a.a.c.b.a("PushMessageExecutor do processActionExecute", new Object[0]);
        if (str2 != null && str != null) {
            try {
                if (c.a() != null && c(str, str2) == a.success) {
                    a(str, str2, "1");
                }
            } catch (Throwable th) {
                com.igexin.a.a.c.b.a("PushMessageExecutor|" + th.toString(), new Object[0]);
            }
        }
    }

    public boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (d.I <= 0) {
            d.I = currentTimeMillis - TimeUtils.oneMinuteMillis;
            return true;
        } else if (currentTimeMillis - d.I <= TimeUtils.oneMinuteMillis) {
            return false;
        } else {
            d.I = currentTimeMillis;
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009f, code lost:
        if (r8 != null) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a1, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c6, code lost:
        if (r8 == null) goto L_0x00d0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            com.igexin.push.core.a.e r3 = com.igexin.push.core.a.e.a()
            java.lang.String r3 = r3.a((java.lang.String) r0, (java.lang.String) r1)
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r4 = com.igexin.push.core.d.ac
            java.lang.Object r4 = r4.get(r3)
            com.igexin.push.core.bean.PushTaskBean r4 = (com.igexin.push.core.bean.PushTaskBean) r4
            java.lang.String r5 = "PushMessageExecutor|"
            r6 = 1
            r7 = 0
            if (r4 != 0) goto L_0x00d0
            r8 = 0
            com.igexin.push.core.c r9 = com.igexin.push.core.c.a()     // Catch:{ all -> 0x00ab }
            com.igexin.push.b.b r10 = r9.k()     // Catch:{ all -> 0x00ab }
            java.lang.String r11 = "message"
            r9 = 2
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ all -> 0x00ab }
            java.lang.String r13 = "taskid"
            r12[r7] = r13     // Catch:{ all -> 0x00ab }
            java.lang.String r13 = "messageid"
            r12[r6] = r13     // Catch:{ all -> 0x00ab }
            java.lang.String[] r13 = new java.lang.String[r9]     // Catch:{ all -> 0x00ab }
            r13[r7] = r0     // Catch:{ all -> 0x00ab }
            r13[r6] = r1     // Catch:{ all -> 0x00ab }
            r14 = 0
            r15 = 0
            android.database.Cursor r8 = r10.a(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00ab }
            if (r8 == 0) goto L_0x00a5
            int r9 = r8.getCount()     // Catch:{ all -> 0x00ab }
            if (r9 > 0) goto L_0x0047
            goto L_0x00a5
        L_0x0047:
            boolean r9 = r8.moveToNext()     // Catch:{ all -> 0x00ab }
            if (r9 == 0) goto L_0x009f
            java.lang.String r9 = "info"
            int r9 = r8.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x00ab }
            byte[] r9 = r8.getBlob(r9)     // Catch:{ all -> 0x00ab }
            java.lang.String r10 = "msgextra"
            int r10 = r8.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x00ab }
            byte[] r10 = r8.getBlob(r10)     // Catch:{ all -> 0x00ab }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x00ab }
            byte[] r9 = com.igexin.a.b.a.c(r9)     // Catch:{ all -> 0x00ab }
            r11.<init>(r9)     // Catch:{ all -> 0x00ab }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x00ab }
            r9.<init>(r11)     // Catch:{ all -> 0x00ab }
            com.igexin.push.core.w r11 = a()     // Catch:{ all -> 0x00ab }
            r11.a((org.json.JSONObject) r9, (byte[]) r10, (boolean) r7)     // Catch:{ all -> 0x00ab }
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r9 = com.igexin.push.core.d.ac     // Catch:{ all -> 0x00ab }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ab }
            r10.<init>()     // Catch:{ all -> 0x00ab }
            java.lang.StringBuilder r10 = r10.append(r0)     // Catch:{ all -> 0x00ab }
            java.lang.String r11 = ":"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x00ab }
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch:{ all -> 0x00ab }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00ab }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ all -> 0x00ab }
            com.igexin.push.core.bean.PushTaskBean r9 = (com.igexin.push.core.bean.PushTaskBean) r9     // Catch:{ all -> 0x00ab }
            if (r9 != 0) goto L_0x009d
            if (r8 == 0) goto L_0x009c
            r8.close()
        L_0x009c:
            return r7
        L_0x009d:
            r4 = r9
            goto L_0x0047
        L_0x009f:
            if (r8 == 0) goto L_0x00d0
        L_0x00a1:
            r8.close()
            goto L_0x00d0
        L_0x00a5:
            if (r8 == 0) goto L_0x00aa
            r8.close()
        L_0x00aa:
            return r7
        L_0x00ab:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c9 }
            r1.<init>()     // Catch:{ all -> 0x00c9 }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ all -> 0x00c9 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c9 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x00c9 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c9 }
            java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch:{ all -> 0x00c9 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x00c9 }
            if (r8 == 0) goto L_0x00d0
            goto L_0x00a1
        L_0x00c9:
            r0 = move-exception
            if (r8 == 0) goto L_0x00cf
            r8.close()
        L_0x00cf:
            throw r0
        L_0x00d0:
            int r0 = r4.getExecuteTimes()
            r1 = 50
            if (r0 < r1) goto L_0x00f6
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r0 = com.igexin.push.core.d.ac     // Catch:{ Exception -> 0x00de }
            r0.remove(r3)     // Catch:{ Exception -> 0x00de }
            goto L_0x00f5
        L_0x00de:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r7]
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)
        L_0x00f5:
            return r6
        L_0x00f6:
            int r0 = r0 + r6
            r4.setExecuteTimes(r0)
            com.igexin.push.core.a.e r0 = com.igexin.push.core.a.e.a()
            r0.c(r4, r2)
            com.igexin.push.core.bean.BaseAction r0 = r4.getBaseAction(r2)     // Catch:{ all -> 0x0148 }
            if (r0 != 0) goto L_0x0108
            return r7
        L_0x0108:
            boolean r1 = r0.isSupportExt()     // Catch:{ all -> 0x0148 }
            if (r1 == 0) goto L_0x012d
            com.igexin.push.extension.a r1 = com.igexin.push.extension.a.a()     // Catch:{ all -> 0x0148 }
            java.util.List r1 = r1.b()     // Catch:{ all -> 0x0148 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0148 }
        L_0x011a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0148 }
            if (r2 == 0) goto L_0x012d
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0148 }
            com.igexin.push.extension.stub.IPushExtension r2 = (com.igexin.push.extension.stub.IPushExtension) r2     // Catch:{ all -> 0x0148 }
            boolean r2 = r2.executeAction(r4, r0)     // Catch:{ all -> 0x0148 }
            if (r2 == 0) goto L_0x011a
            return r6
        L_0x012d:
            java.lang.String r1 = r0.getType()     // Catch:{ all -> 0x0148 }
            r2 = r16
            com.igexin.push.core.a.a.a r1 = r2.a((java.lang.String) r1)     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x0145
            boolean r3 = r4.isStop()     // Catch:{ all -> 0x0146 }
            if (r3 == 0) goto L_0x0140
            goto L_0x0145
        L_0x0140:
            boolean r0 = r1.b(r4, r0)     // Catch:{ all -> 0x0146 }
            return r0
        L_0x0145:
            return r7
        L_0x0146:
            r0 = move-exception
            goto L_0x014b
        L_0x0148:
            r0 = move-exception
            r2 = r16
        L_0x014b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r7]
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.w.b(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d A[LOOP:1: B:11:0x003d->B:14:0x004f, LOOP_START, PHI: r4 
      PHI: (r4v1 com.igexin.push.core.a) = (r4v0 com.igexin.push.core.a), (r4v7 com.igexin.push.core.a) binds: [B:10:0x0031, B:14:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.a c(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            com.igexin.push.core.a r0 = com.igexin.push.core.a.success
            com.igexin.push.core.a.e r1 = com.igexin.push.core.a.e.a()
            java.lang.String r9 = r1.a((java.lang.String) r8, (java.lang.String) r9)
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r1 = com.igexin.push.core.d.ac
            java.lang.Object r9 = r1.get(r9)
            com.igexin.push.core.bean.PushTaskBean r9 = (com.igexin.push.core.bean.PushTaskBean) r9
            if (r9 != 0) goto L_0x0017
            com.igexin.push.core.a r8 = com.igexin.push.core.a.stop
            return r8
        L_0x0017:
            java.util.List r1 = r9.getActionChains()
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x0020:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0075
            java.lang.Object r3 = r1.next()
            com.igexin.push.core.bean.BaseAction r3 = (com.igexin.push.core.bean.BaseAction) r3
            com.igexin.push.core.a r4 = com.igexin.push.core.a.stop
            if (r3 != 0) goto L_0x0031
            return r4
        L_0x0031:
            com.igexin.push.extension.a r5 = com.igexin.push.extension.a.a()
            java.util.List r5 = r5.b()
            java.util.Iterator r5 = r5.iterator()
        L_0x003d:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0051
            java.lang.Object r4 = r5.next()
            com.igexin.push.extension.stub.IPushExtension r4 = (com.igexin.push.extension.stub.IPushExtension) r4
            com.igexin.push.core.a r4 = r4.prepareExecuteAction(r9, r3)
            com.igexin.push.core.a r6 = com.igexin.push.core.a.stop
            if (r4 == r6) goto L_0x003d
        L_0x0051:
            com.igexin.push.core.a r5 = com.igexin.push.core.a.stop
            if (r4 != r5) goto L_0x0069
            java.lang.String r5 = r3.getType()
            com.igexin.push.core.a.a.a r5 = r7.a((java.lang.String) r5)
            if (r5 != 0) goto L_0x0060
            return r4
        L_0x0060:
            com.igexin.push.core.a r4 = r5.a(r9, r3)
            com.igexin.push.core.a r3 = com.igexin.push.core.a.stop
            if (r4 != r3) goto L_0x0069
            return r4
        L_0x0069:
            com.igexin.push.core.a r3 = com.igexin.push.core.a.success
            if (r0 != r3) goto L_0x006e
            r0 = r4
        L_0x006e:
            com.igexin.push.core.a r3 = com.igexin.push.core.a.wait
            if (r4 != r3) goto L_0x0020
            int r2 = r2 + 1
            goto L_0x0020
        L_0x0075:
            if (r2 == 0) goto L_0x0084
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            r1 = 1
            boolean r8 = com.igexin.push.core.d.a(r8, r9, r1)
            if (r8 != 0) goto L_0x0084
            com.igexin.push.core.a r0 = com.igexin.push.core.a.success
        L_0x0084:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.w.c(java.lang.String, java.lang.String):com.igexin.push.core.a");
    }

    public void c() {
        c.a().k().a(CrashHianalyticsData.MESSAGE, "createtime <= " + (System.currentTimeMillis() - 604800000));
    }

    public void d() {
        c.a().k().a("at", "create_time <= " + (System.currentTimeMillis() - 604800000));
    }

    public void e() {
        try {
            if (TextUtils.isEmpty(l.y)) {
                return;
            }
            if (!PushBuildConfig.sdk_conf_debug_level.equals(l.y)) {
                List<String> asList = Arrays.asList(l.y.split(","));
                if (!asList.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Map.Entry<String, PushTaskBean>> it = d.ac.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        String str = (String) next.getKey();
                        PushTaskBean pushTaskBean = (PushTaskBean) next.getValue();
                        if (!TextUtils.isEmpty(str)) {
                            for (String str2 : asList) {
                                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                                    arrayList.add(pushTaskBean.getTaskId());
                                    it.remove();
                                }
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        String[] strArr = new String[arrayList.size()];
                        for (int i = 0; i < arrayList.size(); i++) {
                            strArr[i] = (String) arrayList.get(i);
                        }
                        c.a().k().a(CrashHianalyticsData.MESSAGE, new String[]{"taskid"}, strArr);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        int i;
        try {
            if (!h()) {
                for (Map.Entry next : d.ac.entrySet()) {
                    try {
                        String str = (String) next.getKey();
                        PushTaskBean pushTaskBean = (PushTaskBean) next.getValue();
                        if (pushTaskBean != null) {
                            if (pushTaskBean.getStatus() == CoreConsts.m) {
                                String taskId = pushTaskBean.getTaskId();
                                Map<String, String> conditionMap = pushTaskBean.getConditionMap();
                                if (conditionMap != null) {
                                    if (com.igexin.push.util.a.b(taskId)) {
                                        a(CoreConsts.o, taskId, str);
                                        i = CoreConsts.n;
                                    } else {
                                        if (conditionMap.size() > 0) {
                                            if (conditionMap.containsKey("expiredTime") && Long.parseLong(conditionMap.get("expiredTime")) < System.currentTimeMillis()) {
                                                a(CoreConsts.o, taskId, str);
                                                i = CoreConsts.n;
                                            } else if (!conditionMap.containsKey("endTime") || Long.parseLong(conditionMap.get("endTime")) >= System.currentTimeMillis()) {
                                                if (conditionMap.containsKey("wifi")) {
                                                    int parseInt = Integer.parseInt(conditionMap.get("wifi"));
                                                    com.igexin.push.util.a.d();
                                                    if (parseInt != d.p) {
                                                    }
                                                }
                                                if (conditionMap.containsKey("screenOn")) {
                                                    int parseInt2 = Integer.parseInt(conditionMap.get("screenOn"));
                                                    com.igexin.push.util.a.e();
                                                    if (parseInt2 != d.q) {
                                                    }
                                                }
                                                if (!conditionMap.containsKey("startTime") || Long.parseLong(conditionMap.get("startTime")) <= System.currentTimeMillis()) {
                                                    if (conditionMap.containsKey("netConnected")) {
                                                        try {
                                                            if (Integer.parseInt(conditionMap.get("netConnected")) != com.igexin.push.util.a.h()) {
                                                            }
                                                        } catch (Exception unused) {
                                                        }
                                                    }
                                                }
                                            } else {
                                                a(CoreConsts.o, taskId, str);
                                                i = CoreConsts.n;
                                            }
                                        }
                                        a(taskId, pushTaskBean.getMessageId());
                                        a(CoreConsts.n, taskId, str);
                                        i = CoreConsts.n;
                                    }
                                    pushTaskBean.setStatus(i);
                                } else {
                                    return;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            return;
                        }
                    } catch (Exception e) {
                        com.igexin.a.a.c.b.a("PushMessageExecutor|" + e.toString(), new Object[0]);
                    }
                }
            }
        } catch (Exception e2) {
            com.igexin.a.a.c.b.a("PushMessageExecutor|" + e2.toString(), new Object[0]);
        }
    }

    public void g() {
        Cursor cursor = null;
        try {
            com.igexin.push.b.b k = c.a().k();
            cursor = k.a(CrashHianalyticsData.MESSAGE, new String[]{NotificationCompat.CATEGORY_STATUS}, new String[]{"0"}, (String[]) null, (String) null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex(TransmitterActivityKt.BLE_INFO));
                    long j = cursor.getLong(cursor.getColumnIndex("createtime"));
                    JSONObject jSONObject = new JSONObject(new String(com.igexin.a.b.a.c(blob)));
                    String string = jSONObject.getString("taskid");
                    if (jSONObject.has("condition") && !a(jSONObject) && System.currentTimeMillis() - j > 259200000) {
                        com.igexin.a.a.c.b.a("PushMessageExecutor|del condition taskid = " + string, new Object[0]);
                        k.a(CrashHianalyticsData.MESSAGE, new String[]{"taskid"}, new String[]{string});
                    }
                }
            }
            if (cursor == null) {
            }
        } catch (Throwable th) {
            try {
                com.igexin.a.a.c.b.a("PushMessageExecutor|del condition" + th.toString(), new Object[0]);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }
}
