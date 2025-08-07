package com.igexin.push.core.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.igexin.a.a.b.c;
import com.igexin.a.b.a;
import com.igexin.push.core.bean.h;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class e implements b {
    private static e a;
    private List<h> b = new CopyOnWriteArrayList();

    private e() {
    }

    private int a(byte b2) {
        int i = 0;
        for (h c : this.b) {
            if (c.c() == b2) {
                i++;
            }
        }
        return i;
    }

    public static e a() {
        if (a == null) {
            a = new e();
        }
        return a;
    }

    private h a(long j) {
        for (h next : this.b) {
            if (next.a() == j) {
                return next;
            }
        }
        return null;
    }

    private static ContentValues b(h hVar) {
        if (hVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(hVar.a()));
        contentValues.put("data", a.b(hVar.b().getBytes()));
        contentValues.put(TransmitterActivityKt.OPERATION_TYPE, Byte.valueOf(hVar.c()));
        contentValues.put(CrashHianalyticsData.TIME, Long.valueOf(hVar.d()));
        return contentValues;
    }

    private void b(byte b2) {
        h hVar;
        try {
            Iterator<h> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hVar = null;
                    break;
                }
                hVar = it.next();
                if (hVar.c() == b2) {
                    break;
                }
            }
            if (hVar != null) {
                a(hVar.a(), true, true);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(long j, boolean z, boolean z2) {
        h a2 = a(j);
        if (a2 != null) {
            this.b.remove(a2);
        }
        if (z) {
            c.b().a(new g(this, b(a2), j), z2, !z2);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
    }

    public void a(h hVar) {
        if (hVar == null) {
            return;
        }
        if (this.b.size() < 319 || hVar.c() == 2 || hVar.c() == 7 || hVar.c() == 9) {
            switch (hVar.c()) {
                case 2:
                case 7:
                case 9:
                    b(hVar.c());
                    break;
                case 3:
                    if (a((byte) 3) >= 300) {
                        return;
                    }
                    break;
                case 5:
                    if (a((byte) 5) >= 3) {
                        return;
                    }
                    break;
                case 6:
                    if (a((byte) 6) >= 10) {
                        return;
                    }
                    break;
                case 8:
                    if (a((byte) 8) >= 3) {
                        return;
                    }
                    break;
            }
            this.b.add(hVar);
            c.b().a(new f(this, b(hVar)), false, true);
        }
    }

    public boolean a(long j, long j2) {
        h a2 = a(j);
        if (a2 == null) {
            return false;
        }
        a2.a(j2);
        c.b().a(new h(this, b(a2), j), true, true);
        return true;
    }

    public List<h> b() {
        return this.b;
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("ral", new String[]{"id", "data", TransmitterActivityKt.OPERATION_TYPE, CrashHianalyticsData.TIME}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            long currentTimeMillis = System.currentTimeMillis();
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    long j = cursor.getLong(0);
                    byte b2 = (byte) cursor.getInt(2);
                    long j2 = cursor.getLong(3);
                    if (currentTimeMillis - j2 > 259200000) {
                        a(j, true, true);
                    } else {
                        this.b.add(new h(j, new String(a.c(cursor.getBlob(1))), b2, j2));
                    }
                }
            }
            if (cursor == null) {
                return;
            }
        } catch (Exception unused) {
            if (cursor == null) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
    }
}
