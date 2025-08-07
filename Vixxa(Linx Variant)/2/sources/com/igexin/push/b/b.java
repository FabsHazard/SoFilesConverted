package com.igexin.push.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.igexin.push.core.b.i;

public class b extends SQLiteOpenHelper {
    private SQLiteDatabase a = null;

    public b(Context context) {
        super(context, "pushsdk.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    private String a(String[] strArr, String[] strArr2, int i) {
        StringBuilder sb = new StringBuilder(" ");
        if (strArr.length == 1) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(strArr[0]).append(" = '").append(strArr2[i2]).append("'");
                if (i2 < i - 1) {
                    sb.append(" or ");
                }
            }
        } else {
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(strArr[i3]).append(" = '").append(strArr2[i3]).append("'");
                if (i3 < i - 1) {
                    sb.append(" and ");
                }
            }
        }
        return sb.toString();
    }

    private String b(String str, String str2) {
        return "delete from " + str + " where " + str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        r4.a.endTransaction();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0038 A[ExcHandler: all (r5v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x000c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "DBHelper|del "
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()
            r4.a = r1
            r1.beginTransaction()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r4.a     // Catch:{ Exception -> 0x003f, all -> 0x0038 }
            r3 = 0
            int r5 = r2.delete(r5, r6, r3)     // Catch:{ Exception -> 0x003f, all -> 0x0038 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0036, all -> 0x0038 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0036, all -> 0x0038 }
            java.lang.StringBuilder r6 = r6.append(r5)     // Catch:{ Exception -> 0x0036, all -> 0x0038 }
            java.lang.String r0 = " msg"
            java.lang.StringBuilder r6 = r6.append(r0)     // Catch:{ Exception -> 0x0036, all -> 0x0038 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0036, all -> 0x0038 }
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0036, all -> 0x0038 }
            com.igexin.a.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r0)     // Catch:{ Exception -> 0x0036, all -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r6 = r4.a     // Catch:{ Exception -> 0x0036, all -> 0x0038 }
            r6.setTransactionSuccessful()     // Catch:{ Exception -> 0x0036, all -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r6 = r4.a
            r6.endTransaction()
            goto L_0x0045
        L_0x0036:
            r1 = r5
            goto L_0x003f
        L_0x0038:
            r5 = move-exception
            android.database.sqlite.SQLiteDatabase r6 = r4.a
            r6.endTransaction()
            throw r5
        L_0x003f:
            android.database.sqlite.SQLiteDatabase r5 = r4.a
            r5.endTransaction()
            r5 = r1
        L_0x0045:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.b.a(java.lang.String, java.lang.String):int");
    }

    public Cursor a(String str, String[] strArr, String str2) {
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.a = readableDatabase;
            return readableDatabase.query(str, strArr, str2, (String[]) null, (String) null, (String) null, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Cursor a(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2) {
        Cursor query;
        String[] strArr4 = strArr;
        String[] strArr5 = strArr2;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.a = readableDatabase;
        readableDatabase.beginTransaction();
        Cursor cursor = null;
        if (strArr4 == null) {
            try {
                query = this.a.query(str, strArr3, (String) null, (String[]) null, (String) null, (String) null, str2);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.a.endTransaction();
                throw th;
            }
        } else if (strArr4.length != 1) {
            query = this.a.query(str, strArr3, a(strArr, strArr2, strArr4.length), (String[]) null, (String) null, (String) null, str2);
        } else if (strArr5.length == 1) {
            query = this.a.query(str, strArr3, strArr4[0] + "= ?", strArr2, (String) null, (String) null, str2);
        } else {
            query = this.a.query(str, strArr3, a(strArr, strArr2, strArr5.length), (String[]) null, (String) null, (String) null, str2);
        }
        cursor = query;
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
        return cursor;
    }

    public void a(String str, ContentValues contentValues, String[] strArr, String[] strArr2) {
        SQLiteDatabase sQLiteDatabase;
        String a2;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.beginTransaction();
        if (strArr == null) {
            try {
                this.a.update(str, contentValues, (String) null, (String[]) null);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.a.endTransaction();
                throw th;
            }
        } else {
            if (strArr.length != 1) {
                sQLiteDatabase = this.a;
                a2 = a(strArr, strArr2, strArr.length);
            } else if (strArr2.length == 1) {
                sQLiteDatabase = this.a;
                a2 = strArr[0] + "='" + strArr2[0] + "'";
            } else {
                sQLiteDatabase = this.a;
                a2 = a(strArr, strArr2, strArr2.length);
            }
            sQLiteDatabase.update(str, contentValues, a2, (String[]) null);
        }
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
    }

    public void a(String str, String[] strArr, String[] strArr2) {
        SQLiteDatabase sQLiteDatabase;
        String b;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.beginTransaction();
        if (strArr == null) {
            try {
                this.a.delete(str, (String) null, (String[]) null);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.a.endTransaction();
                throw th;
            }
        } else {
            if (strArr.length != 1) {
                sQLiteDatabase = this.a;
                b = b(str, a(strArr, strArr2, strArr.length));
            } else if (strArr2.length == 1) {
                com.igexin.a.a.c.b.a("DBHelper|del " + str + " cnt = " + this.a.delete(str, strArr[0] + " = ?", strArr2), new Object[0]);
            } else {
                sQLiteDatabase = this.a;
                b = b(str, a(strArr, strArr2, strArr2.length));
            }
            sQLiteDatabase.execSQL(b);
        }
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
    }

    public boolean a(String str, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            this.a.insert(str, (String) null, contentValues);
            this.a.setTransactionSuccessful();
            this.a.endTransaction();
            return true;
        } catch (Exception unused) {
            this.a.endTransaction();
            return false;
        } catch (Throwable th) {
            this.a.endTransaction();
            throw th;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("create table if not exists config (id integer primary key,value text)");
            sQLiteDatabase.execSQL("create table if not exists runtime (id integer primary key,value text)");
            sQLiteDatabase.execSQL("create table if not exists message (id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,status integer,createtime integer)");
            sQLiteDatabase.execSQL("create table if not exists ral (id integer primary key,data text,type integer,time integer)");
            sQLiteDatabase.execSQL("create table if not exists ca (pkgname text primary key,signature text,permissions text, accesstoken blob, expire integer)");
            sQLiteDatabase.execSQL("create table if not exists bi(id integer primary key autoincrement, start_service_count integer, login_count integer, loginerror_nonetwork_count integer, loginerror_timeout_count integer, loginerror_connecterror_count integer, loginerror_other_count integer, online_time long, network_time long, running_time long, create_time text, type integer)");
            sQLiteDatabase.execSQL("create table if not exists st(id integer primary key autoincrement,type integer,value blob,time integer)");
            sQLiteDatabase.execSQL("create table if not exists at (id integer primary key autoincrement,from_page text,page text,enterTime text,exitTime text,is_exist text,create_time long)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i2, i);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        i.a().d(sQLiteDatabase);
        try {
            sQLiteDatabase.execSQL("drop table if exists config");
        } catch (Exception unused) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists runtime");
        } catch (Exception unused2) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists message");
        } catch (Exception unused3) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists ral");
        } catch (Exception unused4) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists ca");
        } catch (Exception unused5) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists bi");
        } catch (Exception unused6) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists st");
        } catch (Exception unused7) {
        }
        onCreate(sQLiteDatabase);
    }
}
