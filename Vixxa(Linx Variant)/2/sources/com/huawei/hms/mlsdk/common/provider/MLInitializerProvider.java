package com.huawei.hms.mlsdk.common.provider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.ml.common.utils.ActivityMgr;
import com.huawei.hms.ml.common.utils.SmartLog;

public class MLInitializerProvider extends ContentProvider {
    private static final String TAG = "MLInitializerProvider";

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        try {
            ActivityMgr.INST.init((Application) getContext().getApplicationContext());
            SmartLog.e(TAG, "MLInitializerProvider Done");
            return false;
        } catch (Throwable th) {
            SmartLog.e(TAG, "MLInitializerProvider e: " + th);
            return false;
        }
    }
}
