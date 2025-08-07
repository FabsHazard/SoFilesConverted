package com.igexin.push.core.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.common.util.Logger;
import com.igexin.a.a.b.c;
import com.igexin.a.a.c.b;
import com.igexin.a.a.d.e;
import com.igexin.a.b.a;
import com.igexin.push.core.d;
import com.igexin.push.f.b.f;
import com.igexin.push.util.EncryptUtils;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;

public class i implements b {
    private static final String a = "com.igexin.push.core.b.i";
    private static i b;
    private Map<String, String> c = new TreeMap();
    private boolean d;

    private i() {
    }

    public static i a() {
        if (b == null) {
            b = new i();
        }
        return b;
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", str);
        sQLiteDatabase.replace("runtime", (String) null, contentValues);
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace("runtime", (String) null, contentValues);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r12 != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r12 != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(android.database.sqlite.SQLiteDatabase r12, int r13) {
        /*
            r11 = this;
            java.lang.String r0 = "value"
            java.lang.String r1 = "id="
            r2 = 0
            java.lang.String r4 = "runtime"
            r3 = 1
            java.lang.String[] r5 = new java.lang.String[r3]     // Catch:{ Exception -> 0x004c, all -> 0x0045 }
            r3 = 0
            r5[r3] = r0     // Catch:{ Exception -> 0x004c, all -> 0x0045 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004c, all -> 0x0045 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x004c, all -> 0x0045 }
            java.lang.StringBuilder r13 = r3.append(r13)     // Catch:{ Exception -> 0x004c, all -> 0x0045 }
            java.lang.String r6 = r13.toString()     // Catch:{ Exception -> 0x004c, all -> 0x0045 }
            r9 = 0
            r10 = 0
            r7 = 0
            r8 = 0
            r3 = r12
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004c, all -> 0x0045 }
            if (r12 == 0) goto L_0x0042
            boolean r13 = r12.moveToFirst()     // Catch:{ Exception -> 0x004d, all -> 0x003f }
            if (r13 == 0) goto L_0x0042
            int r13 = r12.getColumnIndex(r0)     // Catch:{ Exception -> 0x004d, all -> 0x003f }
            byte[] r13 = r12.getBlob(r13)     // Catch:{ Exception -> 0x004d, all -> 0x003f }
            java.lang.String r0 = com.igexin.push.core.d.C     // Catch:{ Exception -> 0x004d, all -> 0x003f }
            byte[] r13 = com.igexin.a.a.a.a.c(r13, r0)     // Catch:{ Exception -> 0x004d, all -> 0x003f }
            if (r12 == 0) goto L_0x003e
            r12.close()
        L_0x003e:
            return r13
        L_0x003f:
            r13 = move-exception
            r2 = r12
            goto L_0x0046
        L_0x0042:
            if (r12 == 0) goto L_0x0052
            goto L_0x004f
        L_0x0045:
            r13 = move-exception
        L_0x0046:
            if (r2 == 0) goto L_0x004b
            r2.close()
        L_0x004b:
            throw r13
        L_0x004c:
            r12 = r2
        L_0x004d:
            if (r12 == 0) goto L_0x0052
        L_0x004f:
            r12.close()
        L_0x0052:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.i.a(android.database.sqlite.SQLiteDatabase, int):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r12 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r12 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(android.database.sqlite.SQLiteDatabase r12, int r13) {
        /*
            r11 = this;
            java.lang.String r0 = "value"
            java.lang.String r1 = "id="
            r2 = 0
            java.lang.String r4 = "runtime"
            r3 = 1
            java.lang.String[] r5 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            r3 = 0
            r5[r3] = r0     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            java.lang.StringBuilder r13 = r3.append(r13)     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            java.lang.String r6 = r13.toString()     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            r9 = 0
            r10 = 0
            r7 = 0
            r8 = 0
            r3 = r12
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0046, all -> 0x003f }
            if (r12 == 0) goto L_0x003c
            boolean r13 = r12.moveToFirst()     // Catch:{ Exception -> 0x0047, all -> 0x0039 }
            if (r13 == 0) goto L_0x003c
            int r13 = r12.getColumnIndex(r0)     // Catch:{ Exception -> 0x0047, all -> 0x0039 }
            java.lang.String r13 = r12.getString(r13)     // Catch:{ Exception -> 0x0047, all -> 0x0039 }
            if (r12 == 0) goto L_0x0038
            r12.close()
        L_0x0038:
            return r13
        L_0x0039:
            r13 = move-exception
            r2 = r12
            goto L_0x0040
        L_0x003c:
            if (r12 == 0) goto L_0x004c
            goto L_0x0049
        L_0x003f:
            r13 = move-exception
        L_0x0040:
            if (r2 == 0) goto L_0x0045
            r2.close()
        L_0x0045:
            throw r13
        L_0x0046:
            r12 = r2
        L_0x0047:
            if (r12 == 0) goto L_0x004c
        L_0x0049:
            r12.close()
        L_0x004c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.i.b(android.database.sqlite.SQLiteDatabase, int):java.lang.String");
    }

    private void e() {
        String str = d.u;
        if (TextUtils.isEmpty(str) || str.length() <= 8) {
            try {
                str = ExifInterface.GPS_MEASUREMENT_INTERRUPTED + a.a(h() + d.c + UUID.randomUUID());
            } catch (Throwable th) {
                b.a(a + Logger.c + th.toString(), new Object[0]);
                str = ExifInterface.GPS_MEASUREMENT_INTERRUPTED + h();
            }
        }
        d.B = "A-" + str + "-" + System.currentTimeMillis();
        if (d.B.length() >= 64) {
            try {
                d.B = d.B.substring(0, 62);
            } catch (Throwable th2) {
                b.a(a + Logger.c + th2.toString(), new Object[0]);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
        if (r1 == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        if (com.igexin.push.core.d.C != null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (com.igexin.push.core.d.u != null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        r12 = "cantgetimei";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        r12 = com.igexin.push.core.d.u;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        com.igexin.push.core.d.C = com.igexin.a.b.a.a(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0043, code lost:
        if (r1 != null) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(android.database.sqlite.SQLiteDatabase r12) {
        /*
            r11 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r3 = "runtime"
            r2 = 1
            java.lang.String[] r4 = new java.lang.String[r2]     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            r5 = 0
            r4[r5] = r0     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            java.lang.String r6 = "id=?"
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            java.lang.String r2 = "25"
            r7[r5] = r2     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            r8 = 0
            r9 = 0
            r10 = 0
            r2 = r12
            r5 = r6
            r6 = r7
            r7 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            if (r1 == 0) goto L_0x0043
            boolean r12 = r1.moveToFirst()     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            if (r12 == 0) goto L_0x0043
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            byte[] r0 = r1.getBlob(r0)     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            android.content.Context r2 = com.igexin.push.core.d.e     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            java.lang.String r2 = com.igexin.a.b.a.a((java.lang.String) r2)     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            byte[] r0 = com.igexin.a.a.a.a.c(r0, r2)     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            r12.<init>(r0)     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
            com.igexin.push.core.d.C = r12     // Catch:{ Exception -> 0x004d, all -> 0x0046 }
        L_0x0043:
            if (r1 == 0) goto L_0x0052
            goto L_0x004f
        L_0x0046:
            r12 = move-exception
            if (r1 == 0) goto L_0x004c
            r1.close()
        L_0x004c:
            throw r12
        L_0x004d:
            if (r1 == 0) goto L_0x0052
        L_0x004f:
            r1.close()
        L_0x0052:
            java.lang.String r12 = com.igexin.push.core.d.C
            if (r12 != 0) goto L_0x0065
            java.lang.String r12 = com.igexin.push.core.d.u
            if (r12 != 0) goto L_0x005d
            java.lang.String r12 = "cantgetimei"
            goto L_0x005f
        L_0x005d:
            java.lang.String r12 = com.igexin.push.core.d.u
        L_0x005f:
            java.lang.String r12 = com.igexin.a.b.a.a((java.lang.String) r12)
            com.igexin.push.core.d.C = r12
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.i.e(android.database.sqlite.SQLiteDatabase):void");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        String b2 = b(sQLiteDatabase, 2);
        if (!TextUtils.isEmpty(b2)) {
            if (b2.equals("null")) {
                b2 = null;
            }
            d.y = b2;
        }
    }

    private boolean f() {
        return c.b().a(new ab(this), false, true);
    }

    /* access modifiers changed from: private */
    public void g() {
        com.igexin.push.core.e.d.a().b(d.e, d.s);
        com.igexin.push.core.e.d.a().a(d.e, d.r);
        String c2 = com.igexin.push.util.d.c();
        if (c2 == null || c2.length() <= 5) {
            com.igexin.push.util.d.e();
        }
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        String b2 = b(sQLiteDatabase, 46);
        if (!TextUtils.isEmpty(b2)) {
            if (b2.equals("null")) {
                b2 = null;
            }
            d.z = b2;
        }
    }

    private String h() {
        Random random = new Random(Math.abs(new Random().nextLong()));
        String str = "";
        for (int i = 0; i < 15; i++) {
            str = str + random.nextInt(10);
        }
        return str;
    }

    private void h(SQLiteDatabase sQLiteDatabase) {
        String b2 = b(sQLiteDatabase, 48);
        if (!TextUtils.isEmpty(b2)) {
            if (b2.equals("null")) {
                b2 = null;
            }
            d.A = b2;
        }
    }

    /* access modifiers changed from: private */
    public byte[] h(String str) {
        return EncryptUtils.getBytesEncrypted(str.getBytes());
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        String b2 = b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(b2)) {
            if (b2.equals("null")) {
                b2 = null;
            }
            d.B = b2;
        }
    }

    private void j(SQLiteDatabase sQLiteDatabase) {
        byte[] a2 = a(sQLiteDatabase, 1);
        if (a2 != null) {
            try {
                String str = new String(a2);
                d.r = str.equals("null") ? 0 : Long.parseLong(str);
            } catch (Exception unused) {
            }
            b.a(a + "|db version changed, save session = " + d.r, new Object[0]);
        }
    }

    private void k(SQLiteDatabase sQLiteDatabase) {
        byte[] a2 = a(sQLiteDatabase, 20);
        if (a2 != null) {
            String str = new String(a2);
            if (str.equals("null")) {
                str = null;
            }
            d.t = str;
            d.s = str;
            b.a(a + "|db version changed, save cid = " + str, new Object[0]);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
    }

    public boolean a(int i) {
        d.R = i;
        return c.b().a(new p(this), false, true);
    }

    public boolean a(long j) {
        d.a(j);
        return c.b().a(new ac(this), false, true);
    }

    public boolean a(String str) {
        return c.b().a(new aa(this, str), false, true);
    }

    public boolean a(String str, String str2) {
        return c.b().a(new z(this, str, str2), false, true);
    }

    public boolean a(String str, String str2, long j) {
        d.r = j;
        if (TextUtils.isEmpty(d.y)) {
            d.y = str2;
        }
        d.s = str;
        return f();
    }

    public boolean a(String str, boolean z) {
        c b2;
        e rVar;
        if (str == null) {
            return false;
        }
        String str2 = null;
        if (z) {
            if (!str.equals(d.am)) {
                if (!str.equals("null")) {
                    str2 = str;
                }
                d.am = str2;
                b2 = c.b();
                rVar = new q(this, str);
            }
            return false;
        }
        if (!str.equals(d.an)) {
            if (!str.equals("null")) {
                str2 = str;
            }
            d.an = str2;
            b2 = c.b();
            rVar = new r(this, str);
        }
        return false;
        return b2.a(rVar, false, true);
    }

    public boolean a(boolean z) {
        if (d.M == z) {
            return false;
        }
        d.M = z;
        if (!z) {
            com.igexin.push.f.a.k();
        }
        return c.b().a(new n(this), false, true);
    }

    public void b() {
        c.b().a(new j(this), false, true);
    }

    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v20 */
    /* JADX WARNING: Code restructure failed: missing block: B:195:?, code lost:
        com.igexin.push.core.d.r = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0374, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0375, code lost:
        r18 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x037b, code lost:
        if (r2 != null) goto L_0x038e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0380, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0381, code lost:
        if (r18 != null) goto L_0x0383;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0383, code lost:
        r18.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0386, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0387, code lost:
        r14 = false;
        r12 = 1;
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x038c, code lost:
        if (r2 != null) goto L_0x038e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:?, code lost:
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x038e, code lost:
        r2.close();
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0395, code lost:
        if (com.igexin.push.core.d.r != 0) goto L_0x03b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0397, code lost:
        r2 = com.igexin.push.util.d.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x039d, code lost:
        if (r2 == 0) goto L_0x03b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x039f, code lost:
        com.igexin.push.core.d.r = r2;
        a(r10, r12, com.igexin.push.util.EncryptUtils.getBytesEncrypted(java.lang.String.valueOf(r2).getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x03b2, code lost:
        if (com.igexin.push.core.d.s != null) goto L_0x03cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x03b4, code lost:
        r0 = com.igexin.push.util.d.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x03b8, code lost:
        if (r0 == null) goto L_0x03cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x03ba, code lost:
        com.igexin.push.core.d.t = r0;
        com.igexin.push.core.d.s = r0;
        a(r10, 20, com.igexin.push.util.EncryptUtils.getBytesEncrypted(com.igexin.push.core.d.s.getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x03cd, code lost:
        if (com.igexin.push.core.d.s != null) goto L_0x03f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x03d3, code lost:
        if (com.igexin.push.core.d.r == 0) goto L_0x03f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x03d5, code lost:
        com.igexin.push.core.d.t = com.igexin.a.b.a.a(java.lang.String.valueOf(com.igexin.push.core.d.r));
        com.igexin.push.core.d.a(com.igexin.push.core.d.r);
        a(r10, 20, com.igexin.push.util.EncryptUtils.getBytesEncrypted(com.igexin.push.core.d.s.getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x03fb, code lost:
        if ("cfcd208495d565ef66e7dff9f98764da".equals(com.igexin.push.core.d.s) != false) goto L_0x040b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x03ff, code lost:
        if (com.igexin.push.core.d.s == null) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0409, code lost:
        if (com.igexin.push.core.d.s.matches("([a-f]|[0-9]){32}") != false) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x040f, code lost:
        if (com.igexin.push.core.d.r == 0) goto L_0x0422;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0411, code lost:
        a().a(com.igexin.push.core.d.r);
        com.igexin.push.core.d.t = com.igexin.push.core.d.s;
        com.igexin.push.util.d.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0422, code lost:
        com.igexin.push.core.d.t = null;
        com.igexin.push.core.d.s = "null";
        com.igexin.push.core.d.r = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x042e, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.ai) != false) goto L_0x0438;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0436, code lost:
        if ("null".equals(com.igexin.push.core.d.ai) == false) goto L_0x044d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0438, code lost:
        com.igexin.push.core.d.ai = com.igexin.a.b.a.a(32);
        a(r10, 14, com.igexin.push.util.EncryptUtils.getBytesEncrypted(com.igexin.push.core.d.ai.getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x044d, code lost:
        r0 = com.igexin.push.util.d.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0454, code lost:
        if (com.igexin.push.core.d.y != null) goto L_0x0465;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0456, code lost:
        if (r0 == null) goto L_0x0465;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x045c, code lost:
        if (r0.length() <= 5) goto L_0x0465;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x045e, code lost:
        com.igexin.push.core.d.y = r0;
        a(r10, r7, com.igexin.push.core.d.y);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0467, code lost:
        if (com.igexin.push.core.d.B != null) goto L_0x0488;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0469, code lost:
        e();
        a(r10, 3, com.igexin.push.core.d.B);
        com.igexin.a.a.c.b.a(a, "new registerId : " + com.igexin.push.core.d.B);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x048c, code lost:
        if (com.igexin.push.config.l.H == false) goto L_0x04ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x048e, code lost:
        r0 = new com.igexin.push.core.b.d(com.igexin.push.core.d.e).e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x049d, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x04ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x04a5, code lost:
        if (r0.equals(com.igexin.push.core.d.z) != false) goto L_0x04ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x04a7, code lost:
        com.igexin.push.core.d.z = r0;
        a(r10, 46, com.igexin.push.core.d.z);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x04b0, code lost:
        if (r1.d == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x04b2, code lost:
        r1.d = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x04ba, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.C) != false) goto L_0x04d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x04bc, code lost:
        a(r10, 25, com.igexin.a.a.a.a.d(com.igexin.push.core.d.C.getBytes(), com.igexin.a.b.a.a(com.igexin.push.core.d.e.getPackageName())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x04d9, code lost:
        if (com.igexin.push.core.d.r == 0) goto L_0x04ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x04db, code lost:
        a(r10, r12, com.igexin.push.util.EncryptUtils.getBytesEncrypted(java.lang.String.valueOf(com.igexin.push.core.d.r).getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x04f2, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.s) != false) goto L_0x0501;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x04f4, code lost:
        a(r10, 20, com.igexin.push.util.EncryptUtils.getBytesEncrypted(com.igexin.push.core.d.s.getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0507, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.y) != false) goto L_0x0516;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x050f, code lost:
        if (com.igexin.push.core.d.y.length() <= 5) goto L_0x0516;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0511, code lost:
        a(r10, r7, com.igexin.push.core.d.y);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x051c, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.B) != false) goto L_0x0524;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x051e, code lost:
        a(r10, 3, com.igexin.push.core.d.B);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x052a, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.z) != false) goto L_0x0531;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x052c, code lost:
        a(r10, 46, com.igexin.push.core.d.z);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x0537, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.A) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0539, code lost:
        a(r10, 48, com.igexin.push.core.d.A);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:194:0x034a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0374 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0380 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0016] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0383  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.database.sqlite.SQLiteDatabase r22) {
        /*
            r21 = this;
            r1 = r21
            r10 = r22
            java.lang.String r11 = "null"
            r21.e((android.database.sqlite.SQLiteDatabase) r22)
            r13 = 14
            r15 = 20
            r9 = 2
            r8 = 1
            r7 = 0
            r16 = 0
            r18 = 0
            java.lang.String r3 = "runtime"
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch:{ Exception -> 0x0387, all -> 0x0380 }
            java.lang.String r0 = "id"
            r4[r7] = r0     // Catch:{ Exception -> 0x0387, all -> 0x0380 }
            java.lang.String r0 = "value"
            r4[r8] = r0     // Catch:{ Exception -> 0x0387, all -> 0x0380 }
            java.lang.String r0 = "id"
            r5 = 0
            r6 = 0
            r19 = 0
            r20 = 0
            r2 = r22
            r14 = r7
            r7 = r19
            r12 = r8
            r8 = r20
            r9 = r0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x037e, all -> 0x0380 }
            if (r2 == 0) goto L_0x037a
        L_0x0037:
            boolean r0 = r2.moveToNext()     // Catch:{ Exception -> 0x0378, all -> 0x0374 }
            if (r0 == 0) goto L_0x037a
            int r0 = r2.getInt(r14)     // Catch:{ Exception -> 0x0378, all -> 0x0374 }
            r3 = 31
            r4 = 30
            if (r0 == r12) goto L_0x0070
            if (r0 == r13) goto L_0x0070
            r5 = 19
            if (r0 == r5) goto L_0x0070
            if (r0 == r15) goto L_0x0070
            r5 = 23
            if (r0 == r5) goto L_0x0070
            r5 = 25
            if (r0 == r5) goto L_0x0070
            r5 = 22
            if (r0 == r5) goto L_0x0070
            if (r0 == r3) goto L_0x0070
            if (r0 == r4) goto L_0x0070
            r5 = 49
            if (r0 == r5) goto L_0x0070
            r5 = 50
            if (r0 != r5) goto L_0x0068
            goto L_0x0070
        L_0x0068:
            java.lang.String r5 = r2.getString(r12)     // Catch:{ all -> 0x034e }
            r6 = r5
            r5 = r18
            goto L_0x007e
        L_0x0070:
            byte[] r5 = r2.getBlob(r12)     // Catch:{ all -> 0x034e }
            if (r5 == 0) goto L_0x007c
            java.lang.String r6 = com.igexin.push.core.d.C     // Catch:{ all -> 0x034e }
            byte[] r5 = com.igexin.a.a.a.a.c(r5, r6)     // Catch:{ all -> 0x034e }
        L_0x007c:
            r6 = r18
        L_0x007e:
            if (r5 != 0) goto L_0x0083
            if (r6 != 0) goto L_0x0083
            goto L_0x0037
        L_0x0083:
            if (r0 == r12) goto L_0x0333
            r7 = 2
            if (r0 == r7) goto L_0x0327
            r8 = 3
            if (r0 == r8) goto L_0x031b
            r8 = 4
            if (r0 == r8) goto L_0x0307
            r8 = 6
            if (r0 == r8) goto L_0x02f6
            r8 = 8
            if (r0 == r8) goto L_0x02e5
            r8 = 40
            if (r0 == r8) goto L_0x02cd
            if (r0 == r4) goto L_0x029c
            if (r0 == r3) goto L_0x026b
            switch(r0) {
                case 11: goto L_0x025a;
                case 12: goto L_0x0249;
                case 13: goto L_0x023d;
                case 14: goto L_0x0234;
                case 15: goto L_0x0226;
                case 16: goto L_0x0215;
                case 17: goto L_0x0209;
                case 18: goto L_0x01f9;
                case 19: goto L_0x01e8;
                case 20: goto L_0x01d5;
                case 21: goto L_0x01c4;
                case 22: goto L_0x0193;
                case 23: goto L_0x0162;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            switch(r0) {
                case 46: goto L_0x0156;
                case 47: goto L_0x0146;
                case 48: goto L_0x013a;
                case 49: goto L_0x0109;
                case 50: goto L_0x00d8;
                case 51: goto L_0x00c7;
                case 52: goto L_0x00bb;
                case 53: goto L_0x00af;
                case 54: goto L_0x00a4;
                default: goto L_0x00a3;
            }
        L_0x00a3:
            goto L_0x0037
        L_0x00a4:
            boolean r0 = r11.equals(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x00ac
            r6 = r18
        L_0x00ac:
            com.igexin.push.core.d.ay = r6     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x00af:
            boolean r0 = r11.equals(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x00b7
            r6 = r18
        L_0x00b7:
            com.igexin.push.core.d.ax = r6     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x00bb:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x00c3
            r6 = r18
        L_0x00c3:
            com.igexin.push.core.d.av = r6     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x00c7:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x00d0
            r3 = r16
            goto L_0x00d4
        L_0x00d0:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
        L_0x00d4:
            com.igexin.push.core.d.W = r3     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x00d8:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r3 == 0) goto L_0x00e5
            r0 = r18
        L_0x00e5:
            com.igexin.push.core.d.ap = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = "|read last mobileRedirectCmList = "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = com.igexin.push.core.d.ap     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0109:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r3 == 0) goto L_0x0116
            r0 = r18
        L_0x0116:
            com.igexin.push.core.d.ao = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = "|read last wifiRedirectCmList = "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = com.igexin.push.core.d.ao     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x013a:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x0142
            r6 = r18
        L_0x0142:
            com.igexin.push.core.d.A = r6     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0146:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x014e
            r0 = r14
            goto L_0x0152
        L_0x014e:
            int r0 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
        L_0x0152:
            com.igexin.push.core.d.as = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0156:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x015e
            r6 = r18
        L_0x015e:
            com.igexin.push.core.d.z = r6     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0162:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r3 == 0) goto L_0x016f
            r0 = r18
        L_0x016f:
            com.igexin.push.core.d.ak = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = "|DT_ read last mobile result = "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = com.igexin.push.core.d.ak     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0193:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r3 == 0) goto L_0x01a0
            r0 = r18
        L_0x01a0:
            com.igexin.push.core.d.al = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = "|DT_ read last wifi result = "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = com.igexin.push.core.d.al     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x01c4:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x01cd
            r3 = r16
            goto L_0x01d1
        L_0x01cd:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
        L_0x01d1:
            com.igexin.push.core.d.aj = r3     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x01d5:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r3 == 0) goto L_0x01e2
            r0 = r18
        L_0x01e2:
            com.igexin.push.core.d.t = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            com.igexin.push.core.d.s = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x01e8:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r3 == 0) goto L_0x01f5
            r0 = r18
        L_0x01f5:
            com.igexin.push.core.d.x = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x01f9:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x0201
            r0 = r14
            goto L_0x0205
        L_0x0201:
            int r0 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
        L_0x0205:
            com.igexin.push.core.d.R = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0209:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x0211
            r6 = r18
        L_0x0211:
            com.igexin.push.core.d.P = r6     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0215:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x021e
            r3 = r16
            goto L_0x0222
        L_0x021e:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
        L_0x0222:
            com.igexin.push.core.d.N = r3     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0226:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 != 0) goto L_0x0037
            boolean r0 = java.lang.Boolean.parseBoolean(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            com.igexin.push.core.d.M = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0234:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            com.igexin.push.core.d.ai = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x023d:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x0245
            r6 = r18
        L_0x0245:
            com.igexin.push.core.d.L = r6     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0249:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x0252
            r3 = r16
            goto L_0x0256
        L_0x0252:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
        L_0x0256:
            com.igexin.push.core.d.K = r3     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x025a:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x0263
            r3 = r16
            goto L_0x0267
        L_0x0263:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
        L_0x0267:
            com.igexin.push.core.d.J = r3     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x026b:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r3 == 0) goto L_0x0278
            r0 = r18
        L_0x0278:
            com.igexin.push.core.d.am = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = "|DT_ read last domainMobileStatus = "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = com.igexin.push.core.d.am     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x029c:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r3 == 0) goto L_0x02a9
            r0 = r18
        L_0x02a9:
            com.igexin.push.core.d.an = r0     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = "|DT_ read last domainWifiStatus = "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r3 = com.igexin.push.core.d.an     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x02cd:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 != 0) goto L_0x02db
            boolean r0 = java.lang.Boolean.parseBoolean(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x02db
            r8 = r12
            goto L_0x02dc
        L_0x02db:
            r8 = r14
        L_0x02dc:
            com.igexin.push.d.b r0 = com.igexin.push.d.b.a()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.a((boolean) r8)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x02e5:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x02ee
            r3 = r16
            goto L_0x02f2
        L_0x02ee:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
        L_0x02f2:
            com.igexin.push.core.d.H = r3     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x02f6:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x02ff
            r3 = r16
            goto L_0x0303
        L_0x02ff:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
        L_0x0303:
            com.igexin.push.core.d.G = r3     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0307:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 != 0) goto L_0x0316
            boolean r0 = java.lang.Boolean.parseBoolean(r6)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x0314
            goto L_0x0316
        L_0x0314:
            r8 = r14
            goto L_0x0317
        L_0x0316:
            r8 = r12
        L_0x0317:
            com.igexin.push.core.d.k = r8     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x031b:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x0323
            r6 = r18
        L_0x0323:
            com.igexin.push.core.d.B = r6     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0327:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            if (r0 == 0) goto L_0x032f
            r6 = r18
        L_0x032f:
            com.igexin.push.core.d.y = r6     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0333:
            r7 = 2
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x034a, all -> 0x0374 }
            if (r3 == 0) goto L_0x0342
            r3 = r16
            goto L_0x0346
        L_0x0342:
            long r3 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x034a, all -> 0x0374 }
        L_0x0346:
            com.igexin.push.core.d.r = r3     // Catch:{ Exception -> 0x034a, all -> 0x0374 }
            goto L_0x0037
        L_0x034a:
            com.igexin.push.core.d.r = r16     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x034e:
            r0 = move-exception
            r7 = 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            r3.<init>()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r4 = a     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x038c, all -> 0x0374 }
            goto L_0x0037
        L_0x0374:
            r0 = move-exception
            r18 = r2
            goto L_0x0381
        L_0x0378:
            r7 = 2
            goto L_0x038c
        L_0x037a:
            r7 = 2
            if (r2 == 0) goto L_0x0391
            goto L_0x038e
        L_0x037e:
            r7 = 2
            goto L_0x038a
        L_0x0380:
            r0 = move-exception
        L_0x0381:
            if (r18 == 0) goto L_0x0386
            r18.close()
        L_0x0386:
            throw r0
        L_0x0387:
            r14 = r7
            r12 = r8
            r7 = r9
        L_0x038a:
            r2 = r18
        L_0x038c:
            if (r2 == 0) goto L_0x0391
        L_0x038e:
            r2.close()
        L_0x0391:
            long r2 = com.igexin.push.core.d.r
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x03b0
            long r2 = com.igexin.push.util.d.d()
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x03b0
            com.igexin.push.core.d.r = r2
            java.lang.String r0 = java.lang.String.valueOf(r2)
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r12, (byte[]) r0)
        L_0x03b0:
            java.lang.String r0 = com.igexin.push.core.d.s
            if (r0 != 0) goto L_0x03cb
            java.lang.String r0 = com.igexin.push.util.d.b()
            if (r0 == 0) goto L_0x03cb
            com.igexin.push.core.d.t = r0
            com.igexin.push.core.d.s = r0
            java.lang.String r0 = com.igexin.push.core.d.s
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r15, (byte[]) r0)
        L_0x03cb:
            java.lang.String r0 = com.igexin.push.core.d.s
            if (r0 != 0) goto L_0x03f3
            long r2 = com.igexin.push.core.d.r
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x03f3
            long r2 = com.igexin.push.core.d.r
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r0 = com.igexin.a.b.a.a((java.lang.String) r0)
            com.igexin.push.core.d.t = r0
            long r2 = com.igexin.push.core.d.r
            com.igexin.push.core.d.a((long) r2)
            java.lang.String r0 = com.igexin.push.core.d.s
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r15, (byte[]) r0)
        L_0x03f3:
            java.lang.String r0 = "cfcd208495d565ef66e7dff9f98764da"
            java.lang.String r2 = com.igexin.push.core.d.s
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x040b
            java.lang.String r0 = com.igexin.push.core.d.s
            if (r0 == 0) goto L_0x0428
            java.lang.String r0 = com.igexin.push.core.d.s
            java.lang.String r2 = "([a-f]|[0-9]){32}"
            boolean r0 = r0.matches(r2)
            if (r0 != 0) goto L_0x0428
        L_0x040b:
            long r2 = com.igexin.push.core.d.r
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0422
            com.igexin.push.core.b.i r0 = a()
            long r2 = com.igexin.push.core.d.r
            r0.a((long) r2)
            java.lang.String r0 = com.igexin.push.core.d.s
            com.igexin.push.core.d.t = r0
            com.igexin.push.util.d.f()
            goto L_0x0428
        L_0x0422:
            com.igexin.push.core.d.t = r18
            com.igexin.push.core.d.s = r11
            com.igexin.push.core.d.r = r16
        L_0x0428:
            java.lang.String r0 = com.igexin.push.core.d.ai
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0438
            java.lang.String r0 = com.igexin.push.core.d.ai
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x044d
        L_0x0438:
            r0 = 32
            java.lang.String r0 = com.igexin.a.b.a.a((int) r0)
            com.igexin.push.core.d.ai = r0
            java.lang.String r0 = com.igexin.push.core.d.ai
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r13, (byte[]) r0)
        L_0x044d:
            java.lang.String r0 = com.igexin.push.util.d.c()
            java.lang.String r2 = com.igexin.push.core.d.y
            r3 = 5
            if (r2 != 0) goto L_0x0465
            if (r0 == 0) goto L_0x0465
            int r2 = r0.length()
            if (r2 <= r3) goto L_0x0465
            com.igexin.push.core.d.y = r0
            java.lang.String r0 = com.igexin.push.core.d.y
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r7, (java.lang.String) r0)
        L_0x0465:
            java.lang.String r0 = com.igexin.push.core.d.B
            if (r0 != 0) goto L_0x0488
            r21.e()
            java.lang.String r0 = com.igexin.push.core.d.B
            r2 = 3
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r2, (java.lang.String) r0)
            java.lang.String r0 = a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "new registerId : "
            r2.<init>(r4)
            java.lang.String r4 = com.igexin.push.core.d.B
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.String) r2)
        L_0x0488:
            boolean r0 = com.igexin.push.config.l.H
            r2 = 46
            if (r0 == 0) goto L_0x04ae
            com.igexin.push.core.b.d r0 = new com.igexin.push.core.b.d
            android.content.Context r4 = com.igexin.push.core.d.e
            r0.<init>(r4)
            java.lang.String r0 = r0.e()
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x04ae
            java.lang.String r4 = com.igexin.push.core.d.z
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x04ae
            com.igexin.push.core.d.z = r0
            java.lang.String r0 = com.igexin.push.core.d.z
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r2, (java.lang.String) r0)
        L_0x04ae:
            boolean r0 = r1.d
            if (r0 == 0) goto L_0x0540
            r1.d = r14
            java.lang.String r0 = com.igexin.push.core.d.C
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x04d5
            java.lang.String r0 = com.igexin.push.core.d.C
            byte[] r0 = r0.getBytes()
            android.content.Context r4 = com.igexin.push.core.d.e
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r4 = com.igexin.a.b.a.a((java.lang.String) r4)
            byte[] r0 = com.igexin.a.a.a.a.d(r0, r4)
            r4 = 25
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r4, (byte[]) r0)
        L_0x04d5:
            long r4 = com.igexin.push.core.d.r
            int r0 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x04ec
            long r4 = com.igexin.push.core.d.r
            java.lang.String r0 = java.lang.String.valueOf(r4)
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r12, (byte[]) r0)
        L_0x04ec:
            java.lang.String r0 = com.igexin.push.core.d.s
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0501
            java.lang.String r0 = com.igexin.push.core.d.s
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r15, (byte[]) r0)
        L_0x0501:
            java.lang.String r0 = com.igexin.push.core.d.y
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0516
            java.lang.String r0 = com.igexin.push.core.d.y
            int r0 = r0.length()
            if (r0 <= r3) goto L_0x0516
            java.lang.String r0 = com.igexin.push.core.d.y
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r7, (java.lang.String) r0)
        L_0x0516:
            java.lang.String r0 = com.igexin.push.core.d.B
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0524
            java.lang.String r0 = com.igexin.push.core.d.B
            r3 = 3
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r3, (java.lang.String) r0)
        L_0x0524:
            java.lang.String r0 = com.igexin.push.core.d.z
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0531
            java.lang.String r0 = com.igexin.push.core.d.z
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r2, (java.lang.String) r0)
        L_0x0531:
            java.lang.String r0 = com.igexin.push.core.d.A
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0540
            r0 = 48
            java.lang.String r2 = com.igexin.push.core.d.A
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r0, (java.lang.String) r2)
        L_0x0540:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.i.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public boolean b(int i) {
        if (d.as == i) {
            return false;
        }
        d.as = i;
        return c.b().a(new v(this), false, true);
    }

    public boolean b(long j) {
        d.aj = j;
        b.a(a + "|save idc config failed time : " + j, new Object[0]);
        return c.b().a(new k(this, j), false, true);
    }

    public boolean b(String str) {
        d.y = str;
        return c.b().a(new ad(this), false, true);
    }

    public boolean b(String str, boolean z) {
        c b2;
        e tVar;
        if (str == null) {
            return false;
        }
        String str2 = null;
        if (z) {
            if (!str.equals(d.ak)) {
                if (!str.equals("null")) {
                    str2 = str;
                }
                d.ak = str2;
                b2 = c.b();
                tVar = new s(this, str);
            }
            return false;
        }
        if (!str.equals(d.al)) {
            if (!str.equals("null")) {
                str2 = str;
            }
            d.al = str2;
            b2 = c.b();
            tVar = new t(this, str);
        }
        return false;
        return b2.a(tVar, false, true);
    }

    public boolean b(boolean z) {
        return c.b().a(new w(this, z), false, true);
    }

    public void c() {
        d.r = 0;
        d.s = "null";
        f();
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, 1, com.igexin.a.a.a.a.d(String.valueOf(d.r).getBytes(), d.C));
        a(sQLiteDatabase, 4, String.valueOf(d.k));
        a(sQLiteDatabase, 8, String.valueOf(d.H));
        a(sQLiteDatabase, 3, d.B);
        a(sQLiteDatabase, 11, String.valueOf(d.J));
        a(sQLiteDatabase, 12, String.valueOf(d.K));
        a(sQLiteDatabase, 20, com.igexin.a.a.a.a.d(d.s.getBytes(), d.C));
        a(sQLiteDatabase, 2, d.y);
        a(sQLiteDatabase, 25, com.igexin.a.a.a.a.d(d.C.getBytes(), a.a(d.e.getPackageName())));
    }

    public boolean c(long j) {
        if (d.J == j) {
            return false;
        }
        d.J = j;
        return c.b().a(new l(this), false, true);
    }

    public boolean c(String str) {
        d.z = str;
        return c.b().a(new ae(this), false, true);
    }

    public boolean c(String str, boolean z) {
        if (str == null) {
            return false;
        }
        String str2 = str.equals("null") ? null : str;
        if (z && !TextUtils.equals(d.ap, str)) {
            d.ap = str2;
        } else if (z || TextUtils.equals(d.ao, str)) {
            return false;
        } else {
            d.ao = str2;
        }
        b.a(a + "|saveLastRedirectCmList isMobile = " + z + ", lastRedirectCmList = " + str, new Object[0]);
        return c.b().a(new y(this, z, str), false, true);
    }

    public void d() {
        b.a(a + "| found a duplicate cid " + d.s, new Object[0]);
        d.B = null;
        e();
        a().a(d.B);
        a().c();
        d.o = 0;
        f.i().a(SystemClock.elapsedRealtime());
    }

    public void d(SQLiteDatabase sQLiteDatabase) {
        this.d = true;
        e(sQLiteDatabase);
        j(sQLiteDatabase);
        k(sQLiteDatabase);
        i(sQLiteDatabase);
        f(sQLiteDatabase);
        g(sQLiteDatabase);
        h(sQLiteDatabase);
    }

    public boolean d(long j) {
        if (d.G == j) {
            return false;
        }
        d.G = j;
        return c.b().a(new u(this), false, true);
    }

    public boolean d(String str) {
        d.A = str;
        return c.b().a(new af(this), false, true);
    }

    public boolean e(String str) {
        if (str == null || str.equals(d.L)) {
            return false;
        }
        d.L = str;
        c.b().a(new m(this), false, true);
        return true;
    }

    public boolean f(String str) {
        if (str.equals(d.P)) {
            return false;
        }
        d.P = str;
        return c.b().a(new o(this), false, true);
    }

    public boolean g(String str) {
        d.av = str;
        return c.b().a(new x(this, str), false, true);
    }
}
