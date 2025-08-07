package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.ExtractNativeUtils;
import com.huawei.hms.common.util.Logger;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AssetLoadManager {
    public static final String a = "AssetLoadManager";
    public static final String b = "dynamic_modules";
    public static final String c = ".apk";
    public static final String d = "com.huawei.hms.feature.dynamic.descriptors.";
    public static final String e = ".AssetModuleDescriptor";

    public static int a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            return context.getClassLoader().loadClass(d + str + e).getDeclaredField("MODULE_VERSION").getInt((Object) null);
        } catch (ClassNotFoundException unused) {
            Logger.w(a, "Cannot get the class of module descriptor for " + str);
            return 0;
        } catch (Exception e2) {
            Logger.w(a, "Get local asset module info failed.", (Throwable) e2);
            return 0;
        }
    }

    public static Bundle a(Context context, File file, String str) {
        String[] list = file.list();
        if (list == null || list.length == 0) {
            Logger.w(a, "No version in module path.");
            return new Bundle();
        }
        int i = 0;
        for (String parseInt : list) {
            i = Math.max(Integer.parseInt(parseInt), i);
        }
        if (i == 0) {
            Logger.w(a, "Cannot get module version path.");
            return new Bundle();
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            ModuleCopy.clearLowVersionModule(i, canonicalPath, list, a);
            if (a(context, str) > i) {
                Logger.i(a, "There is a higher loader version in assets.");
                return new Bundle();
            }
            String str2 = canonicalPath + File.separator + i + File.separator + str + ".apk";
            if (!new File(str2).exists()) {
                Logger.w(a, "Cannot find module apk in asset decompressed path.");
                return new Bundle();
            }
            Bundle bundle = new Bundle();
            bundle.putString(b.j, str);
            bundle.putString(b.n, str2);
            bundle.putInt(b.m, i);
            Logger.i(a, "Get module info from decompressed asset path success: ModuleName:" + str + ", ModuleVersion:" + i + ", ModulePath:" + str2);
            return bundle;
        } catch (IOException e2) {
            Logger.w(a, "request modulePath error: " + e2.getMessage());
            return new Bundle();
        }
    }

    public static String a(Context context, String str, int i, String str2) {
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStream = context.getAssets().open("dynamic_modules" + File.separator + str + File.separator + str2);
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    String str3 = ModuleCopy.getProtectedPath(context) + File.separator + "dynamic_modules" + File.separator + str + File.separator + i;
                    if (new File(str3).exists() || new File(str3).mkdirs()) {
                        String str4 = str3 + File.separator + str + ".apk";
                        fileOutputStream = new FileOutputStream(str4);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 4096);
                                if (read != -1) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    Logger.i(a, "Decompress module:" + str + " from assets success.");
                                    ModuleCopy.closeQuietly(bufferedInputStream);
                                    ModuleCopy.closeQuietly(fileOutputStream);
                                    ModuleCopy.closeQuietly(inputStream);
                                    return str4;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Logger.w(a, "Cannot find module:" + str + " in assets.", (Throwable) e);
                                ModuleCopy.closeQuietly(bufferedInputStream);
                                ModuleCopy.closeQuietly(fileOutputStream);
                                ModuleCopy.closeQuietly(inputStream);
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream2 = fileOutputStream;
                                ModuleCopy.closeQuietly(bufferedInputStream);
                                ModuleCopy.closeQuietly(fileOutputStream2);
                                ModuleCopy.closeQuietly(inputStream);
                                throw th;
                            }
                        }
                    } else {
                        Logger.w(a, "mkdirs local loaderPath failed.");
                        ModuleCopy.closeQuietly(bufferedInputStream);
                        ModuleCopy.closeQuietly((Closeable) null);
                        ModuleCopy.closeQuietly(inputStream);
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    Logger.w(a, "Cannot find module:" + str + " in assets.", (Throwable) e);
                    ModuleCopy.closeQuietly(bufferedInputStream);
                    ModuleCopy.closeQuietly(fileOutputStream);
                    ModuleCopy.closeQuietly(inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    ModuleCopy.closeQuietly(bufferedInputStream);
                    ModuleCopy.closeQuietly(fileOutputStream2);
                    ModuleCopy.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
                bufferedInputStream = null;
                Logger.w(a, "Cannot find module:" + str + " in assets.", (Throwable) e);
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(fileOutputStream);
                ModuleCopy.closeQuietly(inputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(fileOutputStream2);
                ModuleCopy.closeQuietly(inputStream);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            inputStream = null;
            fileOutputStream = null;
            bufferedInputStream = null;
            Logger.w(a, "Cannot find module:" + str + " in assets.", (Throwable) e);
            ModuleCopy.closeQuietly(bufferedInputStream);
            ModuleCopy.closeQuietly(fileOutputStream);
            ModuleCopy.closeQuietly(inputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            bufferedInputStream = null;
            ModuleCopy.closeQuietly(bufferedInputStream);
            ModuleCopy.closeQuietly(fileOutputStream2);
            ModuleCopy.closeQuietly(inputStream);
            throw th;
        }
    }

    public static Bundle b(Context context, String str) {
        try {
            String[] list = context.getAssets().list("dynamic_modules" + File.separator + str);
            if (list != null) {
                if (list.length != 0) {
                    String str2 = list[0];
                    int a2 = a(context, str);
                    String a3 = a(context, str, a2, str2);
                    if (!TextUtils.isEmpty(a3)) {
                        if (new File(a3).exists()) {
                            if (!ExtractNativeUtils.a(context, a3) || ExtractNativeUtils.a(new File(a3), ModuleCopy.trimLastSection(a3)) == 0) {
                                Bundle bundle = new Bundle();
                                bundle.putString(b.j, str);
                                bundle.putString(b.n, a3);
                                bundle.putInt(b.m, a2);
                                Logger.i(a, "Get dynamic module info from asset success: ModuleName:" + str + ", ModuleVersion:" + a2 + ", ModulePath:" + a3);
                                return bundle;
                            }
                            Logger.w(a, "Extract native to current dir failed.");
                            return new Bundle();
                        }
                    }
                    Logger.w(a, "Decompress module from assets failed.");
                    return new Bundle();
                }
            }
            Logger.w(a, "No module apk in asset path.");
            return new Bundle();
        } catch (Exception e2) {
            Logger.i(a, "getModuleFromAsset failed.", e2);
            return new Bundle();
        }
    }

    public static Bundle getAssetModuleInfo(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(a, "The context or moduleName is null.");
            return new Bundle();
        }
        try {
            File file = new File(ModuleCopy.getProtectedPath(context) + File.separator + "dynamic_modules" + File.separator + str);
            if (file.exists()) {
                Bundle a2 = a(context, file, str);
                if (a2.getInt(b.m) > 0) {
                    Logger.i(a, "Successfully get module info from decompressed asset path.");
                    return a2;
                }
            }
            Bundle b2 = b(context, str);
            if (b2.getInt(b.m) > 0) {
                Logger.i(a, "Successfully get module info from asset.");
                return b2;
            }
        } catch (Exception e2) {
            Logger.i(a, "getDataModuleInfo failed.", e2);
        }
        return new Bundle();
    }
}
