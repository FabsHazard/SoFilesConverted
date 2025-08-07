package com.microtech.aidexx.utils;

import com.microtech.aidexx.common.ExtendsKt;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\b¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/utils/FileUtils;", "", "()V", "delete", "", "file", "Ljava/io/File;", "path", "", "deleteDir", "dir", "deleteFile", "getDownloadDir", "subDir", "isFileExists", "filePath", "setPermission", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FileUtils.kt */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    public final void setPermission(String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        try {
            Runtime.getRuntime().exec("chmod 777 " + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final String getDownloadDir(String str) {
        String str2;
        File externalCacheDir = ExtendsKt.getContext().getExternalCacheDir();
        Intrinsics.checkNotNull(externalCacheDir);
        String absolutePath = externalCacheDir.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        if (str != null) {
            str2 = absolutePath + "/aidex/" + str + '/';
        } else {
            str2 = absolutePath + "/aidex/";
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public final boolean isFileExists(String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        return isFileExists(new File(str));
    }

    public final boolean isFileExists(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.isFile() && file.exists();
    }

    public final boolean delete(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        return delete(new File(str));
    }

    public final boolean delete(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return deleteDir(file);
        }
        return deleteFile(file);
    }

    private final boolean deleteFile(File file) {
        return file != null && (file.exists() || (file.isFile() && file.delete()));
    }

    private final boolean deleteDir(File file) {
        boolean z = true;
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            if (listFiles.length != 0) {
                z = false;
            }
            if (!z) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory()) {
                        Intrinsics.checkNotNull(file2);
                        if (!deleteDir(file2)) {
                            return false;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return file.delete();
    }
}
