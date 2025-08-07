package com.igexin.push.config;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.a.a.b.c;
import com.igexin.push.core.b.b;

public class a implements b {
    public static final String a = "com.igexin.push.config.a";
    private static a b;

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, int i) {
        sQLiteDatabase.delete("config", "id = ?", new String[]{String.valueOf(i)});
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", str);
        sQLiteDatabase.replace("config", (String) null, contentValues);
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace("config", (String) null, contentValues);
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
    }

    public void a(String str) {
        c.b().a(new g(this, str), true, false);
    }

    public void b() {
        c.b().a(new b(this), false, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:150:0x027c, code lost:
        if (r14 != null) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0280, code lost:
        if (r14 != null) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0282, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0285, code lost:
        r14 = new java.lang.StringBuilder();
        r2 = a;
        com.igexin.a.a.c.b.a(r14.append(r2).append("|current ver = 4.4.3.13, last ver = ").append(com.igexin.push.core.d.L).toString(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02ad, code lost:
        if ("4.4.3.13".equals(com.igexin.push.core.d.L) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02b1, code lost:
        if (com.igexin.push.config.l.h == null) goto L_0x030b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02bd, code lost:
        if (com.igexin.push.config.l.h.a().isEmpty() != false) goto L_0x0305;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02bf, code lost:
        com.igexin.a.a.c.b.a(r2 + "|extMap is empty  = false", new java.lang.Object[0]);
        r14 = com.igexin.push.config.l.h.a().keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02e9, code lost:
        if (r14.hasNext() == false) goto L_0x0305;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02eb, code lost:
        r0 = com.igexin.push.config.l.h.a().get(r14.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02fb, code lost:
        if (r0 == null) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02fd, code lost:
        com.igexin.push.util.d.b(r0.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0305, code lost:
        com.igexin.push.config.l.h = null;
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        r14 = new java.io.File(com.igexin.push.core.d.V).listFiles();
        r1 = r14.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0317, code lost:
        if (r0 >= r1) goto L_0x032d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0319, code lost:
        r2 = r14[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0325, code lost:
        if (r2.getName().startsWith("tdata_") == false) goto L_0x032a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0327, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x032a, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001d */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x001d A[LOOP:0: B:4:0x001d->B:178:0x001d, LOOP_START, SYNTHETIC, Splitter:B:4:0x001d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.database.sqlite.SQLiteDatabase r14) {
        /*
            r13 = this;
            r0 = 0
            r1 = 0
            java.lang.String r3 = "config"
            r10 = 2
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch:{ all -> 0x027f }
            java.lang.String r2 = "id"
            r4[r0] = r2     // Catch:{ all -> 0x027f }
            java.lang.String r2 = "value"
            r11 = 1
            r4[r11] = r2     // Catch:{ all -> 0x027f }
            java.lang.String r9 = "id"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r14
            android.database.Cursor r14 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x027f }
            if (r14 == 0) goto L_0x027c
        L_0x001d:
            boolean r2 = r14.moveToNext()     // Catch:{ all -> 0x0280 }
            if (r2 == 0) goto L_0x027c
            int r2 = r14.getInt(r0)     // Catch:{ all -> 0x0280 }
            r3 = 20
            r4 = 58
            r5 = 64
            r6 = 22
            r7 = 21
            if (r2 == r3) goto L_0x005b
            if (r2 == r7) goto L_0x005b
            if (r2 == r6) goto L_0x005b
            r3 = 24
            if (r2 == r3) goto L_0x005b
            r3 = 26
            if (r2 == r3) goto L_0x005b
            r3 = 45
            if (r2 == r3) goto L_0x005b
            r3 = 51
            if (r2 == r3) goto L_0x005b
            r3 = 56
            if (r2 == r3) goto L_0x005b
            if (r2 == r4) goto L_0x005b
            r3 = 62
            if (r2 == r3) goto L_0x005b
            if (r2 != r5) goto L_0x0054
            goto L_0x005b
        L_0x0054:
            java.lang.String r3 = r14.getString(r11)     // Catch:{ all -> 0x0257 }
            r8 = r3
            r3 = r1
            goto L_0x0068
        L_0x005b:
            byte[] r3 = r14.getBlob(r11)     // Catch:{ all -> 0x0257 }
            if (r3 == 0) goto L_0x0067
            java.lang.String r8 = com.igexin.push.core.d.C     // Catch:{ all -> 0x0257 }
            byte[] r3 = com.igexin.a.a.a.a.c(r3, r8)     // Catch:{ all -> 0x0257 }
        L_0x0067:
            r8 = r1
        L_0x0068:
            if (r3 != 0) goto L_0x006d
            if (r8 != 0) goto L_0x006d
            goto L_0x001d
        L_0x006d:
            java.lang.String r9 = "null"
            if (r2 == r11) goto L_0x0249
            if (r2 == r10) goto L_0x023b
            r12 = 3
            if (r2 == r12) goto L_0x022d
            r12 = 4
            if (r2 == r12) goto L_0x021f
            r12 = 7
            if (r2 == r12) goto L_0x0211
            r12 = 28
            if (r2 == r12) goto L_0x0207
            if (r2 == r5) goto L_0x01fe
            r5 = 66
            if (r2 == r5) goto L_0x01f0
            r5 = 15
            if (r2 == r5) goto L_0x01e2
            r5 = 16
            if (r2 == r5) goto L_0x01d4
            if (r2 == r7) goto L_0x01cb
            if (r2 == r6) goto L_0x01c2
            if (r2 == r4) goto L_0x01b9
            r4 = 59
            if (r2 == r4) goto L_0x01ab
            switch(r2) {
                case 24: goto L_0x01a1;
                case 25: goto L_0x0193;
                case 26: goto L_0x0180;
                default: goto L_0x009b;
            }
        L_0x009b:
            switch(r2) {
                case 40: goto L_0x0172;
                case 41: goto L_0x0163;
                case 42: goto L_0x0155;
                case 43: goto L_0x0147;
                default: goto L_0x009e;
            }
        L_0x009e:
            switch(r2) {
                case 45: goto L_0x013e;
                case 46: goto L_0x0130;
                case 47: goto L_0x0122;
                case 48: goto L_0x0114;
                case 49: goto L_0x0106;
                case 50: goto L_0x00f8;
                case 51: goto L_0x00e0;
                case 52: goto L_0x00d2;
                case 53: goto L_0x00c8;
                case 54: goto L_0x00ba;
                case 55: goto L_0x00ac;
                case 56: goto L_0x00a3;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            goto L_0x001d
        L_0x00a3:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0280 }
            r2.<init>(r3)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.A = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x00ac:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.z = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x00ba:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.I = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x00c8:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            com.igexin.push.config.l.K = r8     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x00d2:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.G = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x00e0:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0280 }
            r2.<init>(r3)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.y = r2     // Catch:{ all -> 0x0280 }
            java.lang.String r2 = com.igexin.push.config.l.y     // Catch:{ all -> 0x0280 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            com.igexin.push.core.w r2 = com.igexin.push.core.w.a()     // Catch:{ all -> 0x0280 }
            r2.e()     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x00f8:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.H = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0106:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.F = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0114:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.E = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0122:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.D = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0130:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.C = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x013e:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0280 }
            r2.<init>(r3)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.x = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0147:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.w = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0155:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.v = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0163:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x0280 }
            long r2 = (long) r2     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.u = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0172:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.t = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0180:
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x001d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x001d }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x001d }
            r3.<init>(r2)     // Catch:{ Exception -> 0x001d }
            java.lang.String[] r2 = com.igexin.push.core.a.r.a(r3)     // Catch:{ Exception -> 0x001d }
            com.igexin.push.config.SDKUrlConfig.setIdcConfigUrl(r2)     // Catch:{ Exception -> 0x001d }
            goto L_0x001d
        L_0x0193:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.m = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x01a1:
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x001d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x001d }
            com.igexin.push.config.n.a((java.lang.String) r2, (boolean) r0)     // Catch:{ Exception -> 0x001d }
            goto L_0x001d
        L_0x01ab:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            long r2 = java.lang.Long.parseLong(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.M = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x01b9:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0280 }
            r2.<init>(r3)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.B = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x01c2:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0280 }
            r2.<init>(r3)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.j = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x01cb:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0280 }
            r2.<init>(r3)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.i = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x01d4:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.e = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x01e2:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.d = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x01f0:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.J = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x01fe:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0280 }
            r2.<init>(r3)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.L = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0207:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            com.igexin.push.config.l.s = r8     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0211:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.g = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x021f:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            boolean r2 = java.lang.Boolean.parseBoolean(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.f = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x022d:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            long r2 = java.lang.Long.parseLong(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.c = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x023b:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.b = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0249:
            boolean r2 = r8.equals(r9)     // Catch:{ all -> 0x0280 }
            if (r2 != 0) goto L_0x001d
            int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x0280 }
            com.igexin.push.config.l.a = r2     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x0257:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0280 }
            r3.<init>()     // Catch:{ all -> 0x0280 }
            java.lang.String r4 = a     // Catch:{ all -> 0x0280 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0280 }
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0280 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0280 }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ all -> 0x0280 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0280 }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x0280 }
            com.igexin.a.a.c.b.a((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x0280 }
            goto L_0x001d
        L_0x027c:
            if (r14 == 0) goto L_0x0285
            goto L_0x0282
        L_0x027f:
            r14 = r1
        L_0x0280:
            if (r14 == 0) goto L_0x0285
        L_0x0282:
            r14.close()
        L_0x0285:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r2 = a
            java.lang.StringBuilder r14 = r14.append(r2)
            java.lang.String r3 = "|current ver = 4.4.3.13, last ver = "
            java.lang.StringBuilder r14 = r14.append(r3)
            java.lang.String r3 = com.igexin.push.core.d.L
            java.lang.StringBuilder r14 = r14.append(r3)
            java.lang.String r14 = r14.toString()
            java.lang.Object[] r3 = new java.lang.Object[r0]
            com.igexin.a.a.c.b.a((java.lang.String) r14, (java.lang.Object[]) r3)
            java.lang.String r14 = com.igexin.push.core.d.L
            java.lang.String r3 = "4.4.3.13"
            boolean r14 = r3.equals(r14)
            if (r14 != 0) goto L_0x033d
            com.igexin.push.core.bean.e r14 = com.igexin.push.config.l.h
            if (r14 == 0) goto L_0x030b
            com.igexin.push.core.bean.e r14 = com.igexin.push.config.l.h
            java.util.Map r14 = r14.a()
            boolean r14 = r14.isEmpty()
            if (r14 != 0) goto L_0x0305
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.StringBuilder r14 = r14.append(r2)
            java.lang.String r2 = "|extMap is empty  = false"
            java.lang.StringBuilder r14 = r14.append(r2)
            java.lang.String r14 = r14.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.igexin.a.a.c.b.a((java.lang.String) r14, (java.lang.Object[]) r0)
            com.igexin.push.core.bean.e r14 = com.igexin.push.config.l.h
            java.util.Map r14 = r14.a()
            java.util.Set r14 = r14.keySet()
            java.util.Iterator r14 = r14.iterator()
        L_0x02e5:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x0305
            com.igexin.push.core.bean.e r0 = com.igexin.push.config.l.h
            java.util.Map r0 = r0.a()
            java.lang.Object r2 = r14.next()
            java.lang.Object r0 = r0.get(r2)
            com.igexin.push.core.bean.d r0 = (com.igexin.push.core.bean.d) r0
            if (r0 == 0) goto L_0x02e5
            java.lang.String r0 = r0.a()
            com.igexin.push.util.d.b((java.lang.String) r0)
            goto L_0x02e5
        L_0x0305:
            com.igexin.push.config.l.h = r1
            r13.g()
            goto L_0x032d
        L_0x030b:
            java.io.File r14 = new java.io.File     // Catch:{ Exception -> 0x032d }
            java.lang.String r1 = com.igexin.push.core.d.V     // Catch:{ Exception -> 0x032d }
            r14.<init>(r1)     // Catch:{ Exception -> 0x032d }
            java.io.File[] r14 = r14.listFiles()     // Catch:{ Exception -> 0x032d }
            int r1 = r14.length     // Catch:{ Exception -> 0x032d }
        L_0x0317:
            if (r0 >= r1) goto L_0x032d
            r2 = r14[r0]     // Catch:{ Exception -> 0x032d }
            java.lang.String r4 = r2.getName()     // Catch:{ Exception -> 0x032d }
            java.lang.String r5 = "tdata_"
            boolean r4 = r4.startsWith(r5)     // Catch:{ Exception -> 0x032d }
            if (r4 == 0) goto L_0x032a
            r2.delete()     // Catch:{ Exception -> 0x032d }
        L_0x032a:
            int r0 = r0 + 1
            goto L_0x0317
        L_0x032d:
            com.igexin.push.core.b.i r14 = com.igexin.push.core.b.i.a()
            r14.e((java.lang.String) r3)
            com.igexin.push.core.b.i r14 = com.igexin.push.core.b.i.a()
            r0 = 0
            r14.c((long) r0)
        L_0x033d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.a.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public void b(String str) {
        c.b().a(new h(this, str), true, false);
    }

    public void c() {
        c.b().a(new c(this), false, true);
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, 1, String.valueOf(l.a));
        a(sQLiteDatabase, 2, String.valueOf(l.b));
        a(sQLiteDatabase, 3, String.valueOf(l.c));
        a(sQLiteDatabase, 4, String.valueOf(l.f));
        a(sQLiteDatabase, 7, String.valueOf(l.g));
        a(sQLiteDatabase, 15, String.valueOf(l.d));
        a(sQLiteDatabase, 3, String.valueOf(l.c));
        a(sQLiteDatabase, 25, String.valueOf(l.m));
    }

    public void d() {
        c.b().a(new d(this), false, true);
    }

    public void e() {
        c.b().a(new e(this), false, true);
    }

    public void f() {
        c.b().a(new f(this), false, true);
    }

    public void g() {
        c.b().a(new i(this), true, false);
    }
}
