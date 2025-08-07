package com.igexin.push.extension.distribution.basic.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class b extends SQLiteOpenHelper {
    SQLiteDatabase a = null;
    private boolean b = true;

    public b(Context context) {
        super(context, "pushsdk.db", (SQLiteDatabase.CursorFactory) null, 4);
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

    public boolean a() {
        return this.b;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.b = false;
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.b = false;
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.b = false;
    }
}
