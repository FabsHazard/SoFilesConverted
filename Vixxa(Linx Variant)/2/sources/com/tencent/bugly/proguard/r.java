package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcelable;
import androidx.work.PeriodicWorkRequest;
import com.microtech.aidexx.utils.TimeUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class r {
    private static boolean e = true;
    private Context a;
    /* access modifiers changed from: private */
    public long b;
    private int c;
    /* access modifiers changed from: private */
    public boolean d;

    public r(Context context, boolean z) {
        this.a = context;
        this.d = z;
    }

    public final void a(int i, boolean z) {
        ac a2 = ac.a();
        int i2 = 0;
        if (a2 == null || a2.c().g || i == 1 || i == 3) {
            if (i == 1 || i == 3) {
                this.c++;
            }
            aa a3 = aa.a(this.a);
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.b = i;
            userInfoBean.c = a3.d;
            userInfoBean.d = a3.f();
            userInfoBean.e = System.currentTimeMillis();
            userInfoBean.f = -1;
            userInfoBean.n = a3.o;
            if (i == 1) {
                i2 = 1;
            }
            userInfoBean.o = i2;
            userInfoBean.l = a3.a();
            userInfoBean.m = a3.y;
            userInfoBean.g = a3.z;
            userInfoBean.h = a3.A;
            userInfoBean.i = a3.B;
            userInfoBean.k = a3.C;
            userInfoBean.r = a3.t();
            userInfoBean.s = a3.y();
            userInfoBean.p = a3.z();
            userInfoBean.q = a3.x;
            ak.a().a(new a(userInfoBean, z), 0);
            return;
        }
        al.e("UserInfo is disable", new Object[0]);
    }

    public final void a(long j) {
        ak.a().a(new c(j), j);
    }

    public final void a() {
        this.b = ap.b() + TimeUtils.oneDayMillis;
        ak.a().a(new b(), (this.b - System.currentTimeMillis()) + 5000);
    }

    /* compiled from: BUGLY */
    class a implements Runnable {
        private boolean b;
        private UserInfoBean c;

        public a(UserInfoBean userInfoBean, boolean z) {
            this.c = userInfoBean;
            this.b = z;
        }

        public final void run() {
            if (r.this.d) {
                try {
                    UserInfoBean userInfoBean = this.c;
                    if (userInfoBean != null) {
                        r.a(userInfoBean);
                        al.c("[UserInfo] Record user info.", new Object[0]);
                        r.this.a(this.c, false);
                    }
                    if (this.b) {
                        r.this.b();
                    }
                } catch (Throwable th) {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    private static void a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i = 0;
            while (i < list.size() - 1) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < list.size(); i3++) {
                    if (list.get(i).e > list.get(i3).e) {
                        list.set(i, list.get(i3));
                        list.set(i3, list.get(i));
                    }
                }
                i = i2;
            }
            for (int i4 = 0; i4 < size; i4++) {
                list2.add(list.get(i4));
            }
        }
    }

    private static void b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f != -1) {
                it.remove();
                if (next.e < ap.b()) {
                    list2.add(next);
                }
            }
        }
    }

    private static int a(List<UserInfoBean> list) {
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (UserInfoBean next : list) {
            if (next.e > currentTimeMillis - 600000 && (next.b == 1 || next.b == 4 || next.b == 3)) {
                i++;
            }
        }
        return i;
    }

    private void a(final List<UserInfoBean> list, boolean z) {
        aa b2;
        if (!b(z)) {
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean next : list) {
                next.f = currentTimeMillis;
                a(next, true);
            }
            al.d("uploadCheck failed", new Object[0]);
            return;
        }
        int i = this.c == 1 ? 1 : 2;
        bv bvVar = null;
        if (!(list == null || list.size() == 0 || (b2 = aa.b()) == null)) {
            b2.o();
            bv bvVar2 = new bv();
            bvVar2.b = b2.d;
            bvVar2.c = b2.g();
            ArrayList<bu> arrayList = new ArrayList<>();
            for (UserInfoBean a2 : list) {
                bu a3 = ae.a(a2);
                if (a3 != null) {
                    arrayList.add(a3);
                }
            }
            bvVar2.d = arrayList;
            bvVar2.e = new HashMap();
            Map<String, String> map = bvVar2.e;
            b2.getClass();
            map.put("A7", "");
            bvVar2.e.put("A6", aa.n());
            bvVar2.e.put("A5", b2.m());
            bvVar2.e.put("A2", new StringBuilder().append(b2.k()).toString());
            bvVar2.e.put("A1", new StringBuilder().append(b2.k()).toString());
            bvVar2.e.put("A24", b2.k);
            bvVar2.e.put("A17", new StringBuilder().append(b2.l()).toString());
            bvVar2.e.put("A15", b2.q());
            bvVar2.e.put("A13", new StringBuilder().append(b2.r()).toString());
            bvVar2.e.put("F08", b2.E);
            bvVar2.e.put("F09", b2.F);
            Map<String, String> y = b2.y();
            if (y != null && y.size() > 0) {
                for (Map.Entry next2 : y.entrySet()) {
                    bvVar2.e.put("C04_" + ((String) next2.getKey()), next2.getValue());
                }
            }
            if (i == 1) {
                bvVar2.a = 1;
            } else if (i != 2) {
                al.e("unknown up type %d ", Integer.valueOf(i));
            } else {
                bvVar2.a = 2;
            }
            bvVar = bvVar2;
        }
        if (bvVar == null) {
            al.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] a4 = ae.a((m) bvVar);
        if (a4 == null) {
            al.d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        bq a5 = ae.a(this.a, 840, a4);
        if (a5 == null) {
            al.d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        AnonymousClass1 r9 = new ah() {
            public final void a(boolean z, String str) {
                if (z) {
                    al.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (UserInfoBean userInfoBean : list) {
                        userInfoBean.f = currentTimeMillis;
                        r.this.a(userInfoBean, true);
                    }
                }
            }
        };
        ai.a().a(1001, a5, ac.a().c().q, StrategyBean.a, r9, this.c == 1);
    }

    public final void b() {
        ak a2 = ak.a();
        if (a2 != null) {
            a2.a(new Runnable() {
                final /* synthetic */ boolean a = false;

                public final void run() {
                    try {
                        r.this.a(this.a);
                    } catch (Throwable th) {
                        al.a(th);
                    }
                }
            });
        }
    }

    /* compiled from: BUGLY */
    class b implements Runnable {
        b() {
        }

        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < r.this.b) {
                ak.a().a(new b(), (r.this.b - currentTimeMillis) + 5000);
                return;
            }
            r.this.a(3, false);
            r.this.a();
        }
    }

    /* compiled from: BUGLY */
    class c implements Runnable {
        private long b;

        public c(long j) {
            this.b = j;
        }

        public final void run() {
            r.this.b();
            r.this.a(this.b);
        }
    }

    /* access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a2;
        if (userInfoBean != null) {
            if (z || userInfoBean.b == 1 || (a2 = a(aa.a(this.a).d)) == null || a2.size() < 20) {
                long a3 = w.a().a("t_ui", b(userInfoBean), (v) null);
                if (a3 >= 0) {
                    al.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a3));
                    userInfoBean.a = a3;
                    return;
                }
                return;
            }
            al.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a2.size()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x009b A[Catch:{ all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a0 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> a(java.lang.String r7) {
        /*
            java.lang.String r0 = "t_ui"
            r1 = 0
            boolean r2 = com.tencent.bugly.proguard.ap.a((java.lang.String) r7)     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x000b
            r7 = r1
            goto L_0x0020
        L_0x000b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "_pc = '"
            r2.<init>(r3)     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r7 = r2.append(r7)     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = "'"
            java.lang.StringBuilder r7 = r7.append(r2)     // Catch:{ all -> 0x0093 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0093 }
        L_0x0020:
            com.tencent.bugly.proguard.w r2 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x0093 }
            android.database.Cursor r7 = r2.a((java.lang.String) r0, (java.lang.String[]) r1, (java.lang.String) r7)     // Catch:{ all -> 0x0093 }
            if (r7 != 0) goto L_0x0030
            if (r7 == 0) goto L_0x002f
            r7.close()
        L_0x002f:
            return r1
        L_0x0030:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r2.<init>()     // Catch:{ all -> 0x0091 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0091 }
            r3.<init>()     // Catch:{ all -> 0x0091 }
        L_0x003a:
            boolean r4 = r7.moveToNext()     // Catch:{ all -> 0x0091 }
            if (r4 == 0) goto L_0x0067
            com.tencent.bugly.crashreport.biz.UserInfoBean r4 = a((android.database.Cursor) r7)     // Catch:{ all -> 0x0091 }
            if (r4 == 0) goto L_0x004a
            r3.add(r4)     // Catch:{ all -> 0x0091 }
            goto L_0x003a
        L_0x004a:
            java.lang.String r4 = "_id"
            int r4 = r7.getColumnIndex(r4)     // Catch:{ all -> 0x005e }
            long r4 = r7.getLong(r4)     // Catch:{ all -> 0x005e }
            java.lang.String r6 = " or _id = "
            java.lang.StringBuilder r6 = r2.append(r6)     // Catch:{ all -> 0x005e }
            r6.append(r4)     // Catch:{ all -> 0x005e }
            goto L_0x003a
        L_0x005e:
            java.lang.String r4 = "[Database] unknown id."
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0091 }
            com.tencent.bugly.proguard.al.d(r4, r5)     // Catch:{ all -> 0x0091 }
            goto L_0x003a
        L_0x0067:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0091 }
            int r4 = r2.length()     // Catch:{ all -> 0x0091 }
            if (r4 <= 0) goto L_0x008b
            r4 = 4
            java.lang.String r2 = r2.substring(r4)     // Catch:{ all -> 0x0091 }
            com.tencent.bugly.proguard.w r4 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x0091 }
            int r2 = r4.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = "[Database] deleted %s error data %d"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0091 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r2}     // Catch:{ all -> 0x0091 }
            com.tencent.bugly.proguard.al.d(r4, r0)     // Catch:{ all -> 0x0091 }
        L_0x008b:
            if (r7 == 0) goto L_0x0090
            r7.close()
        L_0x0090:
            return r3
        L_0x0091:
            r0 = move-exception
            goto L_0x0095
        L_0x0093:
            r0 = move-exception
            r7 = r1
        L_0x0095:
            boolean r2 = com.tencent.bugly.proguard.al.a(r0)     // Catch:{ all -> 0x00a4 }
            if (r2 != 0) goto L_0x009e
            r0.printStackTrace()     // Catch:{ all -> 0x00a4 }
        L_0x009e:
            if (r7 == 0) goto L_0x00a3
            r7.close()
        L_0x00a3:
            return r1
        L_0x00a4:
            r0 = move-exception
            if (r7 == 0) goto L_0x00aa
            r7.close()
        L_0x00aa:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.r.a(java.lang.String):java.util.List");
    }

    private static void b(List<UserInfoBean> list) {
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < list.size() && i < 50) {
                sb.append(" or _id = ").append(list.get(i).a);
                i++;
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                sb2 = sb2.substring(4);
            }
            sb.setLength(0);
            try {
                al.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb2)));
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static ContentValues b(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", ap.a((Parcelable) userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ap.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(boolean r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.d     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x0006
            goto L_0x0022
        L_0x0006:
            com.tencent.bugly.proguard.ai r0 = com.tencent.bugly.proguard.ai.a()     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x000d
            goto L_0x0022
        L_0x000d:
            com.tencent.bugly.proguard.ac r1 = com.tencent.bugly.proguard.ac.a()     // Catch:{ all -> 0x008c }
            if (r1 != 0) goto L_0x0014
            goto L_0x0022
        L_0x0014:
            boolean r1 = r1.b()     // Catch:{ all -> 0x008c }
            if (r1 == 0) goto L_0x0024
            r1 = 1001(0x3e9, float:1.403E-42)
            boolean r0 = r0.b((int) r1)     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x0024
        L_0x0022:
            monitor-exit(r6)
            return
        L_0x0024:
            android.content.Context r0 = r6.a     // Catch:{ all -> 0x008c }
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.a((android.content.Context) r0)     // Catch:{ all -> 0x008c }
            java.lang.String r0 = r0.d     // Catch:{ all -> 0x008c }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x008c }
            r1.<init>()     // Catch:{ all -> 0x008c }
            java.util.List r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x008c }
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0056
            a((java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>) r0, (java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>) r1)     // Catch:{ all -> 0x008c }
            b(r0, r1)     // Catch:{ all -> 0x008c }
            int r4 = a((java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>) r0)     // Catch:{ all -> 0x008c }
            r5 = 15
            if (r4 <= r5) goto L_0x005b
            java.lang.String r3 = "[UserInfo] Upload user info too many times in 10 min: %d"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x008c }
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch:{ all -> 0x008c }
            com.tencent.bugly.proguard.al.d(r3, r4)     // Catch:{ all -> 0x008c }
            r3 = r2
            goto L_0x005b
        L_0x0056:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x008c }
            r0.<init>()     // Catch:{ all -> 0x008c }
        L_0x005b:
            int r4 = r1.size()     // Catch:{ all -> 0x008c }
            if (r4 <= 0) goto L_0x0064
            b((java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>) r1)     // Catch:{ all -> 0x008c }
        L_0x0064:
            if (r3 == 0) goto L_0x0083
            int r1 = r0.size()     // Catch:{ all -> 0x008c }
            if (r1 != 0) goto L_0x006d
            goto L_0x0083
        L_0x006d:
            java.lang.String r1 = "[UserInfo] Upload user info(size: %d)"
            int r2 = r0.size()     // Catch:{ all -> 0x008c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x008c }
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch:{ all -> 0x008c }
            com.tencent.bugly.proguard.al.c(r1, r2)     // Catch:{ all -> 0x008c }
            r6.a((java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>) r0, (boolean) r7)     // Catch:{ all -> 0x008c }
            monitor-exit(r6)
            return
        L_0x0083:
            java.lang.String r7 = "[UserInfo] There is no user info in local database."
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x008c }
            com.tencent.bugly.proguard.al.c(r7, r0)     // Catch:{ all -> 0x008c }
            monitor-exit(r6)
            return
        L_0x008c:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x008c }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.r.a(boolean):void");
    }

    private boolean b(boolean z) {
        boolean z2 = true;
        if (!e) {
            return true;
        }
        File file = new File(this.a.getFilesDir(), "bugly_last_us_up_tm");
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            am.a(file, String.valueOf(currentTimeMillis), 1024, false);
            return true;
        }
        if (!file.exists()) {
            am.a(file, String.valueOf(currentTimeMillis), 1024, false);
        } else {
            BufferedReader a2 = ap.a(file);
            if (a2 != null) {
                try {
                    long longValue = Long.valueOf(a2.readLine().trim()).longValue();
                    if (currentTimeMillis >= longValue) {
                        if (currentTimeMillis - longValue <= TimeUtils.oneDayMillis) {
                            if (currentTimeMillis - longValue < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                                z2 = false;
                            }
                        }
                    }
                    am.a(file, String.valueOf(currentTimeMillis), 1024, false);
                } catch (Throwable th) {
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (Exception e2) {
                            al.a(e2);
                        }
                    }
                    throw th;
                }
            }
            if (a2 != null) {
                a2.close();
            }
        }
        return z2;
    }

    static /* synthetic */ void a(UserInfoBean userInfoBean) {
        aa b2;
        if (userInfoBean != null && (b2 = aa.b()) != null) {
            userInfoBean.j = b2.d();
        }
    }
}
