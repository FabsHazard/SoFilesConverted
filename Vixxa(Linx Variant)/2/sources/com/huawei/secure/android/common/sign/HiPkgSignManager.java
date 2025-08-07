package com.huawei.secure.android.common.sign;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.util.LogsUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class HiPkgSignManager {
    private static final String a = "HiPkgSignManager";

    private static PackageInfo a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageArchiveInfo(str, 64);
            }
            return null;
        } catch (Exception e) {
            LogsUtil.e(a, "Exception : " + e.getMessage(), true);
            return null;
        }
    }

    private static String b(byte[] bArr) {
        try {
            return a(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bArr));
        } catch (NoSuchAlgorithmException e) {
            LogsUtil.e(a, "NoSuchAlgorithmException" + e.getMessage());
            return "";
        }
    }

    public static boolean doCheckArchiveApk(Context context, String str, String str2, String str3) {
        PackageInfo a2;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null || TextUtils.isEmpty(str3) || (a2 = a(context, str2)) == null) {
            return false;
        }
        String b = b(a2.signatures[0].toByteArray());
        String str4 = a2.packageName;
        if (!str.equalsIgnoreCase(b) || !str3.equals(str4)) {
            return false;
        }
        return true;
    }

    public static boolean doCheckInstalled(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return str.equalsIgnoreCase(getInstalledAppHash(context, str2));
    }

    public static boolean doCheckInstalledV2V3(Context context, List<String> list, String str) {
        List<String> installedAppHashV2V3;
        if (TextUtils.isEmpty(str) || list == null || context == null || (installedAppHashV2V3 = getInstalledAppHashV2V3(context, str)) == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String upperCase : list) {
            arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
        }
        for (String contains : installedAppHashV2V3) {
            if (!arrayList.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] getInstalledAPPSignature(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            LogsUtil.e(a, "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(str, 64)) == null)) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e) {
            LogsUtil.e(a, "PackageManager.NameNotFoundException : " + e.getMessage(), true);
        } catch (Exception e2) {
            LogsUtil.e(a, "Exception : " + e2.getMessage(), true);
        }
        return new byte[0];
    }

    public static String getInstalledAppHash(Context context, String str) {
        byte[] installedAPPSignature = getInstalledAPPSignature(context, str);
        return (installedAPPSignature == null || installedAPPSignature.length <= 0) ? "" : b(installedAPPSignature);
    }

    public static List<String> getInstalledAppHashV2V3(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
                if (packageInfo != null) {
                    if (packageInfo.signingInfo != null) {
                        if (packageInfo.signingInfo.hasMultipleSigners()) {
                            return a(packageInfo.signingInfo.getApkContentsSigners());
                        }
                        return a(packageInfo.signingInfo.getSigningCertificateHistory());
                    }
                }
                return null;
            }
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
            if (!(packageInfo2 == null || packageInfo2.signatures == null || packageInfo2.signatures.length == 0)) {
                if (packageInfo2.signatures[0] != null) {
                    return a(packageInfo2.signatures);
                }
            }
            return null;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
    }

    public static String getUnInstalledAPPPackageName(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            LogsUtil.e(a, "archiveFilePath is null or context is null");
            return "";
        }
        PackageInfo a2 = a(context, str);
        if (a2 != null) {
            return a2.packageName;
        }
        return "";
    }

    public static byte[] getUnInstalledAPPSignature(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            LogsUtil.e(a, "archiveFilePath is null or context is null");
            return new byte[0];
        }
        PackageInfo a2 = a(context, str);
        if (a2 != null) {
            Signature signature = a2.signatures[0];
            if (signature != null) {
                return signature.toByteArray();
            }
        } else {
            LogsUtil.e(a, "PackageInfo is null ");
        }
        return new byte[0];
    }

    public static String getUnInstalledAppHash(Context context, String str) {
        byte[] unInstalledAPPSignature = getUnInstalledAPPSignature(context, str);
        return (unInstalledAPPSignature == null || unInstalledAPPSignature.length <= 0) ? "" : b(unInstalledAPPSignature);
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            if ((b & UByte.MAX_VALUE) < 16) {
                stringBuffer.append("0" + Integer.toHexString(bArr[i] & UByte.MAX_VALUE));
            } else {
                stringBuffer.append(Integer.toHexString(b & UByte.MAX_VALUE));
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
    }

    private static List<String> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        if (!(signatureArr == null || signatureArr.length == 0)) {
            for (Signature byteArray : signatureArr) {
                arrayList.add(b(byteArray.toByteArray()));
            }
        }
        return arrayList;
    }
}
