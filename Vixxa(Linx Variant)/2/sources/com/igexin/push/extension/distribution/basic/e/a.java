package com.igexin.push.extension.distribution.basic.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a extends SQLiteOpenHelper {
    SQLiteDatabase a = null;

    public a(Context context) {
        super(context, "pushext.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    private String a(String str, String str2) {
        return "delete from " + str + " where " + str2;
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

    public Cursor a(String str, String[] strArr) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.a = readableDatabase;
        try {
            return readableDatabase.rawQuery(str, strArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public Cursor a(String str, String[] strArr, String str2) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.a = readableDatabase;
        return readableDatabase.query(str, strArr, str2, (String[]) null, (String) null, (String) null, (String) null);
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
            query = this.a.query(str, strArr3, strArr4[0] + " = ? ", strArr2, (String) null, (String) null, str2);
        } else {
            query = this.a.query(str, strArr3, a(strArr, strArr2, strArr5.length), (String[]) null, (String) null, (String) null, str2);
        }
        cursor = query;
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
        return cursor;
    }

    public void a(String str, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            this.a.insert(str, (String) null, contentValues);
            this.a.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.a.endTransaction();
            throw th;
        }
        this.a.endTransaction();
    }

    public void a(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        try {
            writableDatabase.replace(str, str2, contentValues);
        } catch (Exception unused) {
        }
    }

    public void a(String str, String[] strArr, String[] strArr2) {
        SQLiteDatabase sQLiteDatabase;
        String a2;
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
                a2 = a(str, a(strArr, strArr2, strArr.length));
            } else if (strArr2.length == 1) {
                this.a.delete(str, strArr[0] + " = ?", strArr2);
            } else {
                sQLiteDatabase = this.a;
                a2 = a(str, a(strArr, strArr2, strArr2.length));
            }
            sQLiteDatabase.execSQL(a2);
        }
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
    }

    public void close() {
        try {
            this.a.close();
        } catch (Exception unused) {
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("create table if not exists image(id integer primary key autoincrement, imageurl text, imagesrc text, taskid text, createtime bigint)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("create table if not exists message(id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,createtime integer)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            sQLiteDatabase.endTransaction();
            throw th2;
        }
        sQLiteDatabase.endTransaction();
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("create table if not exists sc(id integer primary key autoincrement, title text, value text)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused3) {
        } catch (Throwable th3) {
            sQLiteDatabase.endTransaction();
            throw th3;
        }
        sQLiteDatabase.endTransaction();
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("create table if not exists extconfig (key integer primary key, value text)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused4) {
        } catch (Throwable th4) {
            sQLiteDatabase.endTransaction();
            throw th4;
        }
        sQLiteDatabase.endTransaction();
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i2, i);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("drop table if exists image");
        } catch (Exception unused) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists message");
        } catch (Exception unused2) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists sc");
        } catch (Exception unused3) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists extconfig");
        } catch (Exception unused4) {
        }
        onCreate(sQLiteDatabase);
    }
}
