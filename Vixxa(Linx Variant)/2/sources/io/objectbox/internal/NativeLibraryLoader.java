package io.objectbox.internal;

import io.objectbox.BoxStore;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.greenrobot.essentials.io.IoUtils;

public class NativeLibraryLoader {
    private static final String OBJECTBOX_JNI = "objectbox-jni";

    public static void ensureLoaded() {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00b3 A[Catch:{ UnsatisfiedLinkError -> 0x00e1, UnsatisfiedLinkError -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00bb  */
    static {
        /*
            java.lang.String r0 = "File not available: "
            java.lang.String r1 = "java.vendor"
            java.lang.String r2 = java.lang.System.getProperty(r1)
            java.lang.String r1 = "os.name"
            java.lang.String r1 = java.lang.System.getProperty(r1)
            java.lang.String r3 = r1.toLowerCase()
            java.lang.String r1 = "Android"
            boolean r1 = r2.contains(r1)
            java.lang.String r4 = "objectbox-jni"
            r5 = 1
            if (r1 != 0) goto L_0x00a3
            java.lang.String r6 = "mac"
            boolean r6 = r3.contains(r6)
            r7 = 0
            if (r6 == 0) goto L_0x002f
            java.lang.String r5 = "libobjectbox-jni-macos.dylib"
            checkUnpackLib(r5)
            java.lang.String r6 = "objectbox-jni-macos"
            goto L_0x00a8
        L_0x002f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "-"
            r6.<init>(r8)
            java.lang.String r8 = getCpuArch()
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.String r8 = "windows"
            boolean r8 = r3.contains(r8)
            if (r8 == 0) goto L_0x0070
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "objectbox-jni-windows"
            r5.<init>(r8)
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r8 = ".dll"
            java.lang.StringBuilder r5 = r5.append(r8)
            java.lang.String r5 = r5.toString()
            checkUnpackLib(r5)
            goto L_0x00a8
        L_0x0070:
            java.lang.String r7 = "linux"
            boolean r7 = r3.contains(r7)
            if (r7 == 0) goto L_0x00a3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "objectbox-jni-linux"
            r7.<init>(r8)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r6 = r6.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "lib"
            r7.<init>(r8)
            java.lang.StringBuilder r7 = r7.append(r6)
            java.lang.String r8 = ".so"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            checkUnpackLib(r7)
            r10 = r7
            r7 = r5
            r5 = r10
            goto L_0x00a8
        L_0x00a3:
            java.lang.String r6 = "objectbox-jni.so"
            r7 = r5
            r5 = r6
            r6 = r4
        L_0x00a8:
            java.io.File r8 = new java.io.File     // Catch:{ UnsatisfiedLinkError -> 0x00f1 }
            r8.<init>(r5)     // Catch:{ UnsatisfiedLinkError -> 0x00f1 }
            boolean r5 = r8.exists()     // Catch:{ UnsatisfiedLinkError -> 0x00f1 }
            if (r5 == 0) goto L_0x00bb
            java.lang.String r0 = r8.getAbsolutePath()     // Catch:{ UnsatisfiedLinkError -> 0x00f1 }
            java.lang.System.load(r0)     // Catch:{ UnsatisfiedLinkError -> 0x00f1 }
            goto L_0x00ef
        L_0x00bb:
            if (r1 == 0) goto L_0x00c7
            boolean r0 = loadLibraryAndroid()     // Catch:{ UnsatisfiedLinkError -> 0x00e1 }
            if (r0 != 0) goto L_0x00ef
            java.lang.System.loadLibrary(r6)     // Catch:{ UnsatisfiedLinkError -> 0x00e1 }
            goto L_0x00ef
        L_0x00c7:
            java.io.PrintStream r5 = java.lang.System.err     // Catch:{ UnsatisfiedLinkError -> 0x00e1 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x00e1 }
            r9.<init>(r0)     // Catch:{ UnsatisfiedLinkError -> 0x00e1 }
            java.lang.String r0 = r8.getAbsolutePath()     // Catch:{ UnsatisfiedLinkError -> 0x00e1 }
            java.lang.StringBuilder r0 = r9.append(r0)     // Catch:{ UnsatisfiedLinkError -> 0x00e1 }
            java.lang.String r0 = r0.toString()     // Catch:{ UnsatisfiedLinkError -> 0x00e1 }
            r5.println(r0)     // Catch:{ UnsatisfiedLinkError -> 0x00e1 }
            java.lang.System.loadLibrary(r6)     // Catch:{ UnsatisfiedLinkError -> 0x00e1 }
            goto L_0x00ef
        L_0x00e1:
            r0 = move-exception
            if (r1 != 0) goto L_0x00f0
            if (r7 == 0) goto L_0x00f0
            boolean r0 = loadLibraryAndroid()     // Catch:{ UnsatisfiedLinkError -> 0x00f1 }
            if (r0 != 0) goto L_0x00ef
            java.lang.System.loadLibrary(r4)     // Catch:{ UnsatisfiedLinkError -> 0x00f1 }
        L_0x00ef:
            return
        L_0x00f0:
            throw r0     // Catch:{ UnsatisfiedLinkError -> 0x00f1 }
        L_0x00f1:
            r0 = move-exception
            java.lang.String r4 = "os.arch"
            java.lang.String r4 = java.lang.System.getProperty(r4)
            if (r1 == 0) goto L_0x0109
            java.lang.String r1 = getSupportedABIsAndroid()
            java.lang.Object[] r1 = new java.lang.Object[]{r2, r3, r4, r1}
            java.lang.String r2 = "[ObjectBox] Android failed to load native library, check your APK/App Bundle includes a supported ABI or use ReLinker https://docs.objectbox.io/android/app-bundle-and-split-apk (vendor=%s,os=%s,os.arch=%s,SUPPORTED_ABIS=%s)"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            goto L_0x0121
        L_0x0109:
            java.lang.String r1 = "sun.arch.data.model"
            java.lang.String r5 = java.lang.System.getProperty(r1)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r7)
            java.lang.String r7 = getCpuArchOSOrNull()
            java.lang.Object[] r1 = new java.lang.Object[]{r2, r3, r4, r5, r6, r7}
            java.lang.String r2 = "[ObjectBox] Loading native library failed, please report this to us: vendor=%s,os=%s,os.arch=%s,model=%s,linux=%s,machine=%s"
            java.lang.String r1 = java.lang.String.format(r2, r1)
        L_0x0121:
            java.lang.LinkageError r2 = new java.lang.LinkageError
            r2.<init>(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.internal.NativeLibraryLoader.<clinit>():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0083, code lost:
        if (r4.startsWith("armv6") != false) goto L_0x0066;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getCpuArch() {
        /*
            java.lang.String r0 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.lang.String r1 = "x64"
            java.lang.String r2 = "x86"
            r3 = 0
            if (r0 == 0) goto L_0x009d
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r4 = "amd64"
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 != 0) goto L_0x009c
            java.lang.String r4 = "x86_64"
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0023
            goto L_0x009c
        L_0x0023:
            boolean r4 = r0.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x002c
            r3 = r2
            goto L_0x009d
        L_0x002c:
            java.lang.String r4 = "aarch64"
            boolean r4 = r4.equals(r0)
            java.lang.String r5 = "arm64"
            if (r4 != 0) goto L_0x009a
            java.lang.String r4 = "armv8"
            boolean r4 = r0.startsWith(r4)
            if (r4 != 0) goto L_0x009a
            boolean r4 = r0.startsWith(r5)
            if (r4 == 0) goto L_0x0045
            goto L_0x009a
        L_0x0045:
            java.lang.String r4 = "arm"
            boolean r5 = r0.startsWith(r4)
            if (r5 == 0) goto L_0x009d
            java.lang.String r5 = "armv7"
            boolean r6 = r0.startsWith(r5)
            java.lang.String r7 = "armv6"
            if (r6 != 0) goto L_0x0086
            java.lang.String r6 = "armeabi-v7"
            boolean r6 = r0.startsWith(r6)
            if (r6 == 0) goto L_0x0060
            goto L_0x0086
        L_0x0060:
            boolean r6 = r0.startsWith(r7)
            if (r6 == 0) goto L_0x0068
        L_0x0066:
            r3 = r7
            goto L_0x0087
        L_0x0068:
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0087
            java.lang.String r4 = getCpuArchOSOrNull()
            if (r4 == 0) goto L_0x0087
            java.lang.String r4 = r4.toLowerCase()
            boolean r6 = r4.startsWith(r5)
            if (r6 == 0) goto L_0x007f
            goto L_0x0086
        L_0x007f:
            boolean r4 = r4.startsWith(r7)
            if (r4 == 0) goto L_0x0087
            goto L_0x0066
        L_0x0086:
            r3 = r5
        L_0x0087:
            if (r3 != 0) goto L_0x009d
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.String r4 = getCpuArchOSOrNull()
            java.lang.Object[] r4 = new java.lang.Object[]{r7, r0, r4}
            java.lang.String r5 = "[ObjectBox] 32-bit ARM os.arch unknown (will use %s), please report this to us: os.arch=%s, machine=%s%n"
            r3.printf(r5, r4)
            r3 = r7
            goto L_0x009d
        L_0x009a:
            r3 = r5
            goto L_0x009d
        L_0x009c:
            r3 = r1
        L_0x009d:
            if (r3 != 0) goto L_0x00ca
            java.lang.String r3 = "sun.arch.data.model"
            java.lang.String r3 = java.lang.System.getProperty(r3)
            java.lang.String r4 = "64"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x00ae
            goto L_0x00ba
        L_0x00ae:
            java.lang.String r1 = "32"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b8
            r1 = r2
            goto L_0x00ba
        L_0x00b8:
            java.lang.String r1 = "unknown"
        L_0x00ba:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.String r4 = getCpuArchOSOrNull()
            java.lang.Object[] r0 = new java.lang.Object[]{r1, r0, r3, r4}
            java.lang.String r3 = "[ObjectBox] os.arch unknown (will use %s), please report this to us: os.arch=%s, model=%s, machine=%s%n"
            r2.printf(r3, r0)
            r3 = r1
        L_0x00ca:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.internal.NativeLibraryLoader.getCpuArch():java.lang.String");
    }

    @Nullable
    private static String getCpuArchOSOrNull() {
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("uname -m").getInputStream(), Charset.defaultCharset()));
            str = bufferedReader.readLine();
            bufferedReader.close();
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    private static void checkUnpackLib(String str) {
        BufferedOutputStream bufferedOutputStream;
        String str2 = "/native/" + str;
        URL resource = NativeLibraryLoader.class.getResource(str2);
        if (resource == null) {
            System.err.println("Not available in classpath: " + str2);
            return;
        }
        File file = new File(str);
        try {
            URLConnection openConnection = resource.openConnection();
            int contentLength = openConnection.getContentLength();
            long lastModified = openConnection.getLastModified();
            if (!file.exists() || file.length() != ((long) contentLength) || file.lastModified() != lastModified) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    IoUtils.copyAllBytes(bufferedInputStream, bufferedOutputStream);
                    IoUtils.safeClose(bufferedOutputStream);
                    IoUtils.safeClose(bufferedInputStream);
                    if (lastModified > 0) {
                        file.setLastModified(lastModified);
                    }
                } catch (Throwable th) {
                    IoUtils.safeClose(bufferedInputStream);
                    throw th;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean loadLibraryAndroid() {
        if (BoxStore.getContext() == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.content.Context");
            if (BoxStore.getRelinker() == null) {
                Class.forName("com.getkeepsafe.relinker.ReLinker").getMethod("loadLibrary", new Class[]{cls, String.class, String.class}).invoke((Object) null, new Object[]{BoxStore.getContext(), OBJECTBOX_JNI, BoxStore.JNI_VERSION});
            } else {
                BoxStore.getRelinker().getClass().getMethod("loadLibrary", new Class[]{cls, String.class, String.class}).invoke(BoxStore.getRelinker(), new Object[]{BoxStore.getContext(), OBJECTBOX_JNI, BoxStore.JNI_VERSION});
            }
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    @Nonnull
    private static String getSupportedABIsAndroid() {
        String[] strArr = null;
        try {
            strArr = (String[]) Class.forName("android.os.Build").getField("SUPPORTED_ABIS").get((Object) null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
        }
        if (strArr != null) {
            return Arrays.toString(strArr);
        }
        return "";
    }
}
