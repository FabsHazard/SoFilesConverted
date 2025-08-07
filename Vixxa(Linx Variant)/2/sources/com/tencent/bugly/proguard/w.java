package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class w {
    public static boolean a = false;
    private static w b;
    private static x c;

    private w(Context context, List<o> list) {
        c = new x(context, list);
    }

    public static synchronized w a(Context context, List<o> list) {
        w wVar;
        synchronized (w.class) {
            if (b == null) {
                b = new w(context, list);
            }
            wVar = b;
        }
        return wVar;
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            wVar = b;
        }
        return wVar;
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        return a(str, strArr, str2, (String) null, (String) null);
    }

    public final Cursor a(String str, String[] strArr, String str2, String str3, String str4) {
        return a(false, str, strArr, str2, (String[]) null, (String) null, (String) null, str3, str4, (v) null);
    }

    public final int a(String str, String str2) {
        return a(str, str2, (String[]) null, (v) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r2 != null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        if (r2 != null) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long a(java.lang.String r8, android.content.ContentValues r9, com.tencent.bugly.proguard.v r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = -1
            r2 = 0
            com.tencent.bugly.proguard.x r3 = c     // Catch:{ all -> 0x003f }
            android.database.sqlite.SQLiteDatabase r2 = r3.getWritableDatabase()     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x002e
            if (r9 == 0) goto L_0x002e
            java.lang.String r3 = "_id"
            long r3 = r2.replace(r8, r3, r9)     // Catch:{ all -> 0x003f }
            r5 = 0
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 < 0) goto L_0x0024
            java.lang.String r9 = "[Database] insert %s success."
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch:{ all -> 0x003f }
            com.tencent.bugly.proguard.al.c(r9, r8)     // Catch:{ all -> 0x003f }
            goto L_0x002d
        L_0x0024:
            java.lang.String r9 = "[Database] replace %s error."
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch:{ all -> 0x003f }
            com.tencent.bugly.proguard.al.d(r9, r8)     // Catch:{ all -> 0x003f }
        L_0x002d:
            r0 = r3
        L_0x002e:
            if (r10 == 0) goto L_0x0033
            java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x003d }
        L_0x0033:
            boolean r8 = a     // Catch:{ all -> 0x003d }
            if (r8 == 0) goto L_0x0055
            if (r2 == 0) goto L_0x0055
        L_0x0039:
            r2.close()     // Catch:{ all -> 0x003d }
            goto L_0x0055
        L_0x003d:
            r8 = move-exception
            goto L_0x0067
        L_0x003f:
            r8 = move-exception
            boolean r9 = com.tencent.bugly.proguard.al.a(r8)     // Catch:{ all -> 0x0057 }
            if (r9 != 0) goto L_0x0049
            r8.printStackTrace()     // Catch:{ all -> 0x0057 }
        L_0x0049:
            if (r10 == 0) goto L_0x004e
            java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x003d }
        L_0x004e:
            boolean r8 = a     // Catch:{ all -> 0x003d }
            if (r8 == 0) goto L_0x0055
            if (r2 == 0) goto L_0x0055
            goto L_0x0039
        L_0x0055:
            monitor-exit(r7)
            return r0
        L_0x0057:
            r8 = move-exception
            if (r10 == 0) goto L_0x005d
            java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x003d }
        L_0x005d:
            boolean r9 = a     // Catch:{ all -> 0x003d }
            if (r9 == 0) goto L_0x0066
            if (r2 == 0) goto L_0x0066
            r2.close()     // Catch:{ all -> 0x003d }
        L_0x0066:
            throw r8     // Catch:{ all -> 0x003d }
        L_0x0067:
            monitor-exit(r7)     // Catch:{ all -> 0x003d }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(java.lang.String, android.content.ContentValues, com.tencent.bugly.proguard.v):long");
    }

    /* access modifiers changed from: private */
    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, v vVar) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = c.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
        return cursor;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r1 != null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0033, code lost:
        if (r1 != null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int a(java.lang.String r4, java.lang.String r5, java.lang.String[] r6, com.tencent.bugly.proguard.v r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            r1 = 0
            com.tencent.bugly.proguard.x r2 = c     // Catch:{ all -> 0x0020 }
            android.database.sqlite.SQLiteDatabase r1 = r2.getWritableDatabase()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x000f
            int r0 = r1.delete(r4, r5, r6)     // Catch:{ all -> 0x0020 }
        L_0x000f:
            if (r7 == 0) goto L_0x0014
            java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x001e }
        L_0x0014:
            boolean r4 = a     // Catch:{ all -> 0x001e }
            if (r4 == 0) goto L_0x0036
            if (r1 == 0) goto L_0x0036
        L_0x001a:
            r1.close()     // Catch:{ all -> 0x001e }
            goto L_0x0036
        L_0x001e:
            r4 = move-exception
            goto L_0x0048
        L_0x0020:
            r4 = move-exception
            boolean r5 = com.tencent.bugly.proguard.al.a(r4)     // Catch:{ all -> 0x0038 }
            if (r5 != 0) goto L_0x002a
            r4.printStackTrace()     // Catch:{ all -> 0x0038 }
        L_0x002a:
            if (r7 == 0) goto L_0x002f
            java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x001e }
        L_0x002f:
            boolean r4 = a     // Catch:{ all -> 0x001e }
            if (r4 == 0) goto L_0x0036
            if (r1 == 0) goto L_0x0036
            goto L_0x001a
        L_0x0036:
            monitor-exit(r3)
            return r0
        L_0x0038:
            r4 = move-exception
            if (r7 == 0) goto L_0x003e
            java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x001e }
        L_0x003e:
            boolean r5 = a     // Catch:{ all -> 0x001e }
            if (r5 == 0) goto L_0x0047
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ all -> 0x001e }
        L_0x0047:
            throw r4     // Catch:{ all -> 0x001e }
        L_0x0048:
            monitor-exit(r3)     // Catch:{ all -> 0x001e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(java.lang.String, java.lang.String, java.lang.String[], com.tencent.bugly.proguard.v):int");
    }

    public final boolean a(int i, String str, byte[] bArr, boolean z) {
        if (z) {
            return a(i, str, bArr, (v) null);
        }
        a aVar = new a();
        aVar.a(i, str, bArr);
        ak.a().a(aVar);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean a(int i, String str, byte[] bArr, v vVar) {
        try {
            y yVar = new y();
            yVar.a = (long) i;
            yVar.f = str;
            yVar.e = System.currentTimeMillis();
            yVar.g = bArr;
            boolean b2 = b(yVar);
            if (vVar == null) {
                return b2;
            }
            Boolean.valueOf(b2);
            return b2;
        } catch (Throwable th) {
            if (vVar != null) {
                Boolean bool = Boolean.FALSE;
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, byte[]> a(int r3, com.tencent.bugly.proguard.v r4) {
        /*
            r2 = this;
            r4 = 0
            java.util.List r3 = r2.c((int) r3)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0035
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x002b }
            r0.<init>()     // Catch:{ all -> 0x002b }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0028 }
        L_0x0010:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0028 }
            if (r4 == 0) goto L_0x0026
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0028 }
            com.tencent.bugly.proguard.y r4 = (com.tencent.bugly.proguard.y) r4     // Catch:{ all -> 0x0028 }
            byte[] r1 = r4.g     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0010
            java.lang.String r4 = r4.f     // Catch:{ all -> 0x0028 }
            r0.put(r4, r1)     // Catch:{ all -> 0x0028 }
            goto L_0x0010
        L_0x0026:
            r4 = r0
            goto L_0x0035
        L_0x0028:
            r3 = move-exception
            r4 = r0
            goto L_0x002c
        L_0x002b:
            r3 = move-exception
        L_0x002c:
            boolean r0 = com.tencent.bugly.proguard.al.a(r3)
            if (r0 != 0) goto L_0x0035
            r3.printStackTrace()
        L_0x0035:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(int, com.tencent.bugly.proguard.v):java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
        return false;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0043=Splitter:B:24:0x0043, B:37:0x005a=Splitter:B:37:0x005a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(com.tencent.bugly.proguard.y r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r1 = 0
            com.tencent.bugly.proguard.x r2 = c     // Catch:{ all -> 0x0050 }
            android.database.sqlite.SQLiteDatabase r1 = r2.getWritableDatabase()     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x0043
            android.content.ContentValues r2 = c((com.tencent.bugly.proguard.y) r7)     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x0043
            java.lang.String r3 = "t_lr"
            java.lang.String r4 = "_id"
            long r2 = r1.replace(r3, r4, r2)     // Catch:{ all -> 0x0050 }
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x0038
            java.lang.String r4 = "[Database] insert %s success."
            java.lang.String r5 = "t_lr"
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x0050 }
            com.tencent.bugly.proguard.al.c(r4, r5)     // Catch:{ all -> 0x0050 }
            r7.a = r2     // Catch:{ all -> 0x0050 }
            boolean r7 = a     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x0035
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x0035:
            monitor-exit(r6)
            r7 = 1
            return r7
        L_0x0038:
            boolean r7 = a     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x0041
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x0041:
            monitor-exit(r6)
            return r0
        L_0x0043:
            boolean r7 = a     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x004c
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x004c:
            monitor-exit(r6)
            return r0
        L_0x004e:
            r7 = move-exception
            goto L_0x0070
        L_0x0050:
            r7 = move-exception
            boolean r2 = com.tencent.bugly.proguard.al.a(r7)     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x005a
            r7.printStackTrace()     // Catch:{ all -> 0x0065 }
        L_0x005a:
            boolean r7 = a     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x0063
            if (r1 == 0) goto L_0x0063
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x0063:
            monitor-exit(r6)
            return r0
        L_0x0065:
            r7 = move-exception
            boolean r0 = a     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x006f
            if (r1 == 0) goto L_0x006f
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x006f:
            throw r7     // Catch:{ all -> 0x004e }
        L_0x0070:
            monitor-exit(r6)     // Catch:{ all -> 0x004e }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(com.tencent.bugly.proguard.y):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
        return false;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0043=Splitter:B:24:0x0043, B:37:0x005a=Splitter:B:37:0x005a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean b(com.tencent.bugly.proguard.y r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r1 = 0
            com.tencent.bugly.proguard.x r2 = c     // Catch:{ all -> 0x0050 }
            android.database.sqlite.SQLiteDatabase r1 = r2.getWritableDatabase()     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x0043
            android.content.ContentValues r2 = d(r7)     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x0043
            java.lang.String r3 = "t_pf"
            java.lang.String r4 = "_id"
            long r2 = r1.replace(r3, r4, r2)     // Catch:{ all -> 0x0050 }
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x0038
            java.lang.String r4 = "[Database] insert %s success."
            java.lang.String r5 = "t_pf"
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x0050 }
            com.tencent.bugly.proguard.al.c(r4, r5)     // Catch:{ all -> 0x0050 }
            r7.a = r2     // Catch:{ all -> 0x0050 }
            boolean r7 = a     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x0035
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x0035:
            monitor-exit(r6)
            r7 = 1
            return r7
        L_0x0038:
            boolean r7 = a     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x0041
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x0041:
            monitor-exit(r6)
            return r0
        L_0x0043:
            boolean r7 = a     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x004c
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x004c:
            monitor-exit(r6)
            return r0
        L_0x004e:
            r7 = move-exception
            goto L_0x0070
        L_0x0050:
            r7 = move-exception
            boolean r2 = com.tencent.bugly.proguard.al.a(r7)     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x005a
            r7.printStackTrace()     // Catch:{ all -> 0x0065 }
        L_0x005a:
            boolean r7 = a     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x0063
            if (r1 == 0) goto L_0x0063
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x0063:
            monitor-exit(r6)
            return r0
        L_0x0065:
            r7 = move-exception
            boolean r0 = a     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x006f
            if (r1 == 0) goto L_0x006f
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x006f:
            throw r7     // Catch:{ all -> 0x004e }
        L_0x0070:
            monitor-exit(r6)     // Catch:{ all -> 0x004e }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.b(com.tencent.bugly.proguard.y):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a5, code lost:
        return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b0 A[Catch:{ all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b5 A[SYNTHETIC, Splitter:B:56:0x00b5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.tencent.bugly.proguard.y> a(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            com.tencent.bugly.proguard.x r0 = c     // Catch:{ all -> 0x00d4 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x00d4 }
            r9 = 0
            if (r0 == 0) goto L_0x00d2
            if (r12 < 0) goto L_0x001c
            java.lang.String r1 = "_tp = "
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0018 }
            java.lang.String r12 = r1.concat(r12)     // Catch:{ all -> 0x0018 }
            r4 = r12
            goto L_0x001d
        L_0x0018:
            r12 = move-exception
            r1 = r9
            goto L_0x00aa
        L_0x001c:
            r4 = r9
        L_0x001d:
            java.lang.String r2 = "t_lr"
            r7 = 0
            r8 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r1 = r0
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0018 }
            if (r12 != 0) goto L_0x003b
            if (r12 == 0) goto L_0x0030
            r12.close()     // Catch:{ all -> 0x00d4 }
        L_0x0030:
            boolean r12 = a     // Catch:{ all -> 0x00d4 }
            if (r12 == 0) goto L_0x0039
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ all -> 0x00d4 }
        L_0x0039:
            monitor-exit(r11)
            return r9
        L_0x003b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r1.<init>()     // Catch:{ all -> 0x00a6 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00a6 }
            r2.<init>()     // Catch:{ all -> 0x00a6 }
        L_0x0045:
            boolean r3 = r12.moveToNext()     // Catch:{ all -> 0x00a6 }
            if (r3 == 0) goto L_0x0072
            com.tencent.bugly.proguard.y r3 = a((android.database.Cursor) r12)     // Catch:{ all -> 0x00a6 }
            if (r3 == 0) goto L_0x0055
            r2.add(r3)     // Catch:{ all -> 0x00a6 }
            goto L_0x0045
        L_0x0055:
            java.lang.String r3 = "_id"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ all -> 0x0069 }
            long r3 = r12.getLong(r3)     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = " or _id = "
            java.lang.StringBuilder r5 = r1.append(r5)     // Catch:{ all -> 0x0069 }
            r5.append(r3)     // Catch:{ all -> 0x0069 }
            goto L_0x0045
        L_0x0069:
            java.lang.String r3 = "[Database] unknown id."
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00a6 }
            com.tencent.bugly.proguard.al.d(r3, r4)     // Catch:{ all -> 0x00a6 }
            goto L_0x0045
        L_0x0072:
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a6 }
            int r3 = r1.length()     // Catch:{ all -> 0x00a6 }
            if (r3 <= 0) goto L_0x0096
            r3 = 4
            java.lang.String r1 = r1.substring(r3)     // Catch:{ all -> 0x00a6 }
            java.lang.String r3 = "t_lr"
            int r1 = r0.delete(r3, r1, r9)     // Catch:{ all -> 0x00a6 }
            java.lang.String r3 = "[Database] deleted %s illegal data %d"
            java.lang.String r4 = "t_lr"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00a6 }
            java.lang.Object[] r1 = new java.lang.Object[]{r4, r1}     // Catch:{ all -> 0x00a6 }
            com.tencent.bugly.proguard.al.d(r3, r1)     // Catch:{ all -> 0x00a6 }
        L_0x0096:
            if (r12 == 0) goto L_0x009b
            r12.close()     // Catch:{ all -> 0x00d4 }
        L_0x009b:
            boolean r12 = a     // Catch:{ all -> 0x00d4 }
            if (r12 == 0) goto L_0x00a4
            if (r0 == 0) goto L_0x00a4
            r0.close()     // Catch:{ all -> 0x00d4 }
        L_0x00a4:
            monitor-exit(r11)
            return r2
        L_0x00a6:
            r1 = move-exception
            r10 = r1
            r1 = r12
            r12 = r10
        L_0x00aa:
            boolean r2 = com.tencent.bugly.proguard.al.a(r12)     // Catch:{ all -> 0x00c2 }
            if (r2 != 0) goto L_0x00b3
            r12.printStackTrace()     // Catch:{ all -> 0x00c2 }
        L_0x00b3:
            if (r1 == 0) goto L_0x00b8
            r1.close()     // Catch:{ all -> 0x00d4 }
        L_0x00b8:
            boolean r12 = a     // Catch:{ all -> 0x00d4 }
            if (r12 == 0) goto L_0x00d2
            if (r0 == 0) goto L_0x00d2
            r0.close()     // Catch:{ all -> 0x00d4 }
            goto L_0x00d2
        L_0x00c2:
            r12 = move-exception
            if (r1 == 0) goto L_0x00c8
            r1.close()     // Catch:{ all -> 0x00d4 }
        L_0x00c8:
            boolean r1 = a     // Catch:{ all -> 0x00d4 }
            if (r1 == 0) goto L_0x00d1
            if (r0 == 0) goto L_0x00d1
            r0.close()     // Catch:{ all -> 0x00d4 }
        L_0x00d1:
            throw r12     // Catch:{ all -> 0x00d4 }
        L_0x00d2:
            monitor-exit(r11)
            return r9
        L_0x00d4:
            r12 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00d4 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0088, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.util.List<com.tencent.bugly.proguard.y> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 == 0) goto L_0x0087
            int r0 = r7.size()     // Catch:{ all -> 0x0084 }
            if (r0 != 0) goto L_0x000b
            goto L_0x0087
        L_0x000b:
            com.tencent.bugly.proguard.x r0 = c     // Catch:{ all -> 0x0084 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0082
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r1.<init>()     // Catch:{ all -> 0x0084 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0084 }
        L_0x001c:
            boolean r2 = r7.hasNext()     // Catch:{ all -> 0x0084 }
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r7.next()     // Catch:{ all -> 0x0084 }
            com.tencent.bugly.proguard.y r2 = (com.tencent.bugly.proguard.y) r2     // Catch:{ all -> 0x0084 }
            java.lang.String r3 = " or _id = "
            java.lang.StringBuilder r3 = r1.append(r3)     // Catch:{ all -> 0x0084 }
            long r4 = r2.a     // Catch:{ all -> 0x0084 }
            r3.append(r4)     // Catch:{ all -> 0x0084 }
            goto L_0x001c
        L_0x0034:
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x0084 }
            int r2 = r7.length()     // Catch:{ all -> 0x0084 }
            if (r2 <= 0) goto L_0x0043
            r2 = 4
            java.lang.String r7 = r7.substring(r2)     // Catch:{ all -> 0x0084 }
        L_0x0043:
            r2 = 0
            r1.setLength(r2)     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = "t_lr"
            r2 = 0
            int r7 = r0.delete(r1, r7, r2)     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "[Database] deleted %s data %d"
            java.lang.String r2 = "t_lr"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0066 }
            java.lang.Object[] r7 = new java.lang.Object[]{r2, r7}     // Catch:{ all -> 0x0066 }
            com.tencent.bugly.proguard.al.c(r1, r7)     // Catch:{ all -> 0x0066 }
            boolean r7 = a     // Catch:{ all -> 0x0084 }
            if (r7 == 0) goto L_0x0082
            r0.close()     // Catch:{ all -> 0x0084 }
            monitor-exit(r6)
            return
        L_0x0066:
            r7 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r7)     // Catch:{ all -> 0x0079 }
            if (r1 != 0) goto L_0x0070
            r7.printStackTrace()     // Catch:{ all -> 0x0079 }
        L_0x0070:
            boolean r7 = a     // Catch:{ all -> 0x0084 }
            if (r7 == 0) goto L_0x0082
            r0.close()     // Catch:{ all -> 0x0084 }
            monitor-exit(r6)
            return
        L_0x0079:
            r7 = move-exception
            boolean r1 = a     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x0081
            r0.close()     // Catch:{ all -> 0x0084 }
        L_0x0081:
            throw r7     // Catch:{ all -> 0x0084 }
        L_0x0082:
            monitor-exit(r6)
            return
        L_0x0084:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0084 }
            throw r7
        L_0x0087:
            monitor-exit(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(java.util.List):void");
    }

    public final synchronized void b(int i) {
        String str;
        SQLiteDatabase writableDatabase = c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = ".concat(String.valueOf(i));
                } catch (Throwable th) {
                    if (a && writableDatabase != null) {
                        writableDatabase.close();
                    }
                    throw th;
                }
            } else {
                str = null;
            }
            al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, (String[]) null)));
            if (a && writableDatabase != null) {
                writableDatabase.close();
            }
        }
    }

    private static ContentValues c(y yVar) {
        if (yVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (yVar.a > 0) {
                contentValues.put("_id", Long.valueOf(yVar.a));
            }
            contentValues.put("_tp", Integer.valueOf(yVar.b));
            contentValues.put("_pc", yVar.c);
            contentValues.put("_th", yVar.d);
            contentValues.put("_tm", Long.valueOf(yVar.e));
            if (yVar.g != null) {
                contentValues.put("_dt", yVar.g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static y a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.b = cursor.getInt(cursor.getColumnIndex("_tp"));
            yVar.c = cursor.getString(cursor.getColumnIndex("_pc"));
            yVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            yVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a2, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ac, code lost:
        if (r1 != null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ae, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c9, code lost:
        if (r1 != null) goto L_0x00ae;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bd A[Catch:{ all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c2 A[SYNTHETIC, Splitter:B:60:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.List<com.tencent.bugly.proguard.y> c(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            com.tencent.bugly.proguard.x r1 = c     // Catch:{ all -> 0x00b4 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x00a8
            java.lang.String r2 = "_id = "
            java.lang.String r3 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x00a5 }
            java.lang.String r10 = r2.concat(r3)     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "t_pf"
            r8 = 0
            r9 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r2 = r1
            r5 = r10
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00a5 }
            if (r2 != 0) goto L_0x0033
            if (r2 == 0) goto L_0x0028
            r2.close()     // Catch:{ all -> 0x00b2 }
        L_0x0028:
            boolean r12 = a     // Catch:{ all -> 0x00b2 }
            if (r12 == 0) goto L_0x0031
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ all -> 0x00b2 }
        L_0x0031:
            monitor-exit(r11)
            return r0
        L_0x0033:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a3 }
            r3.<init>()     // Catch:{ all -> 0x00a3 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00a3 }
            r4.<init>()     // Catch:{ all -> 0x00a3 }
        L_0x003d:
            boolean r5 = r2.moveToNext()     // Catch:{ all -> 0x00a3 }
            if (r5 == 0) goto L_0x006a
            com.tencent.bugly.proguard.y r5 = b((android.database.Cursor) r2)     // Catch:{ all -> 0x00a3 }
            if (r5 == 0) goto L_0x004d
            r4.add(r5)     // Catch:{ all -> 0x00a3 }
            goto L_0x003d
        L_0x004d:
            java.lang.String r5 = "_tp"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = " or _tp = "
            java.lang.StringBuilder r6 = r3.append(r6)     // Catch:{ all -> 0x0061 }
            r6.append(r5)     // Catch:{ all -> 0x0061 }
            goto L_0x003d
        L_0x0061:
            java.lang.String r5 = "[Database] unknown id."
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00a3 }
            com.tencent.bugly.proguard.al.d(r5, r6)     // Catch:{ all -> 0x00a3 }
            goto L_0x003d
        L_0x006a:
            int r5 = r3.length()     // Catch:{ all -> 0x00a3 }
            if (r5 <= 0) goto L_0x0093
            java.lang.String r5 = " and _id = "
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ all -> 0x00a3 }
            r3.append(r12)     // Catch:{ all -> 0x00a3 }
            r12 = 4
            java.lang.String r12 = r10.substring(r12)     // Catch:{ all -> 0x00a3 }
            java.lang.String r3 = "t_pf"
            int r12 = r1.delete(r3, r12, r0)     // Catch:{ all -> 0x00a3 }
            java.lang.String r3 = "[Database] deleted %s illegal data %d."
            java.lang.String r5 = "t_pf"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x00a3 }
            java.lang.Object[] r12 = new java.lang.Object[]{r5, r12}     // Catch:{ all -> 0x00a3 }
            com.tencent.bugly.proguard.al.d(r3, r12)     // Catch:{ all -> 0x00a3 }
        L_0x0093:
            if (r2 == 0) goto L_0x0098
            r2.close()     // Catch:{ all -> 0x00b2 }
        L_0x0098:
            boolean r12 = a     // Catch:{ all -> 0x00b2 }
            if (r12 == 0) goto L_0x00a1
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ all -> 0x00b2 }
        L_0x00a1:
            monitor-exit(r11)
            return r4
        L_0x00a3:
            r12 = move-exception
            goto L_0x00b7
        L_0x00a5:
            r12 = move-exception
            r2 = r0
            goto L_0x00b7
        L_0x00a8:
            boolean r12 = a     // Catch:{ all -> 0x00b2 }
            if (r12 == 0) goto L_0x00cc
            if (r1 == 0) goto L_0x00cc
        L_0x00ae:
            r1.close()     // Catch:{ all -> 0x00b2 }
            goto L_0x00cc
        L_0x00b2:
            r12 = move-exception
            goto L_0x00de
        L_0x00b4:
            r12 = move-exception
            r1 = r0
            r2 = r1
        L_0x00b7:
            boolean r3 = com.tencent.bugly.proguard.al.a(r12)     // Catch:{ all -> 0x00ce }
            if (r3 != 0) goto L_0x00c0
            r12.printStackTrace()     // Catch:{ all -> 0x00ce }
        L_0x00c0:
            if (r2 == 0) goto L_0x00c5
            r2.close()     // Catch:{ all -> 0x00b2 }
        L_0x00c5:
            boolean r12 = a     // Catch:{ all -> 0x00b2 }
            if (r12 == 0) goto L_0x00cc
            if (r1 == 0) goto L_0x00cc
            goto L_0x00ae
        L_0x00cc:
            monitor-exit(r11)
            return r0
        L_0x00ce:
            r12 = move-exception
            if (r2 == 0) goto L_0x00d4
            r2.close()     // Catch:{ all -> 0x00b2 }
        L_0x00d4:
            boolean r0 = a     // Catch:{ all -> 0x00b2 }
            if (r0 == 0) goto L_0x00dd
            if (r1 == 0) goto L_0x00dd
            r1.close()     // Catch:{ all -> 0x00b2 }
        L_0x00dd:
            throw r12     // Catch:{ all -> 0x00b2 }
        L_0x00de:
            monitor-exit(r11)     // Catch:{ all -> 0x00b2 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.c(int):java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f A[Catch:{ all -> 0x0081 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074 A[SYNTHETIC, Splitter:B:29:0x0074] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(int r6, java.lang.String r7, com.tencent.bugly.proguard.v r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            com.tencent.bugly.proguard.x r2 = c     // Catch:{ all -> 0x0068 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x0057
            boolean r3 = com.tencent.bugly.proguard.ap.a((java.lang.String) r7)     // Catch:{ all -> 0x0054 }
            if (r3 == 0) goto L_0x001c
            java.lang.String r7 = "_id = "
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0054 }
            java.lang.String r6 = r7.concat(r6)     // Catch:{ all -> 0x0054 }
            goto L_0x003b
        L_0x001c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = "_id = "
            r3.<init>(r4)     // Catch:{ all -> 0x0054 }
            java.lang.StringBuilder r6 = r3.append(r6)     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = " and _tp = \""
            java.lang.StringBuilder r6 = r6.append(r3)     // Catch:{ all -> 0x0054 }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x0054 }
            java.lang.String r7 = "\""
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x0054 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0054 }
        L_0x003b:
            java.lang.String r7 = "t_pf"
            int r6 = r2.delete(r7, r6, r1)     // Catch:{ all -> 0x0054 }
            java.lang.String r7 = "[Database] deleted %s data %d"
            java.lang.String r1 = "t_pf"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0054 }
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r3}     // Catch:{ all -> 0x0054 }
            com.tencent.bugly.proguard.al.c(r7, r1)     // Catch:{ all -> 0x0054 }
            if (r6 <= 0) goto L_0x0057
            r0 = 1
            goto L_0x0057
        L_0x0054:
            r6 = move-exception
            r1 = r2
            goto L_0x0069
        L_0x0057:
            if (r8 == 0) goto L_0x005c
            java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0066 }
        L_0x005c:
            boolean r6 = a     // Catch:{ all -> 0x0066 }
            if (r6 == 0) goto L_0x007f
            if (r2 == 0) goto L_0x007f
            r2.close()     // Catch:{ all -> 0x0066 }
            goto L_0x007f
        L_0x0066:
            r6 = move-exception
            goto L_0x0090
        L_0x0068:
            r6 = move-exception
        L_0x0069:
            boolean r7 = com.tencent.bugly.proguard.al.a(r6)     // Catch:{ all -> 0x0081 }
            if (r7 != 0) goto L_0x0072
            r6.printStackTrace()     // Catch:{ all -> 0x0081 }
        L_0x0072:
            if (r8 == 0) goto L_0x0076
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0066 }
        L_0x0076:
            boolean r6 = a     // Catch:{ all -> 0x0066 }
            if (r6 == 0) goto L_0x007f
            if (r1 == 0) goto L_0x007f
            r1.close()     // Catch:{ all -> 0x0066 }
        L_0x007f:
            monitor-exit(r5)
            return r0
        L_0x0081:
            r6 = move-exception
            if (r8 == 0) goto L_0x0086
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0066 }
        L_0x0086:
            boolean r7 = a     // Catch:{ all -> 0x0066 }
            if (r7 == 0) goto L_0x008f
            if (r1 == 0) goto L_0x008f
            r1.close()     // Catch:{ all -> 0x0066 }
        L_0x008f:
            throw r6     // Catch:{ all -> 0x0066 }
        L_0x0090:
            monitor-exit(r5)     // Catch:{ all -> 0x0066 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(int, java.lang.String, com.tencent.bugly.proguard.v):boolean");
    }

    private static ContentValues d(y yVar) {
        if (yVar != null && !ap.a(yVar.f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (yVar.a > 0) {
                    contentValues.put("_id", Long.valueOf(yVar.a));
                }
                contentValues.put("_tp", yVar.f);
                contentValues.put("_tm", Long.valueOf(yVar.e));
                if (yVar.g != null) {
                    contentValues.put("_dt", yVar.g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private static y b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f = cursor.getString(cursor.getColumnIndex("_tp"));
            yVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* compiled from: BUGLY */
    class a extends Thread {
        private int b = 4;
        private v c = null;
        private String d;
        private ContentValues e;
        private boolean f;
        private String[] g;
        private String h;
        private String[] i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String n;
        private String[] o;
        private int p;
        private String q;
        private byte[] r;

        public a() {
        }

        public final void a(int i2, String str, byte[] bArr) {
            this.p = i2;
            this.q = str;
            this.r = bArr;
        }

        public final void run() {
            switch (this.b) {
                case 1:
                    long unused = w.this.a(this.d, this.e, this.c);
                    return;
                case 2:
                    int unused2 = w.this.a(this.d, this.n, this.o, this.c);
                    return;
                case 3:
                    Cursor a2 = w.this.a(this.f, this.d, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.c);
                    if (a2 != null) {
                        a2.close();
                        return;
                    }
                    return;
                case 4:
                    boolean unused3 = w.this.a(this.p, this.q, this.r, this.c);
                    return;
                case 5:
                    Map unused4 = w.this.a(this.p, this.c);
                    return;
                case 6:
                    boolean unused5 = w.this.a(this.p, this.q, this.c);
                    return;
                default:
                    return;
            }
        }
    }
}
