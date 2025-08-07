package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.huawei.secure.android.common.ssl.util.g;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public abstract class SSLUtil {
    private static final String a = "SSLUtil";
    private static final String b = "TLSv1.3";
    private static final String c = "TLSv1.2";
    private static final String d = "TLS";
    private static final String e = "TLSv1";
    private static final String[] f = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};
    private static final String[] g = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};
    private static final String[] h = {"TLS_RSA", "CBC", "TEA", "SHA0", MessageDigestAlgorithms.MD2, "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", MessageDigestAlgorithms.MD5, "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static String[] getEnabledCipherSuites(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static String[] getEnabledProtocols(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void printTLSAndCipher(SSLSocket sSLSocket) {
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        int length = enabledProtocols.length;
        for (int i = 0; i < length; i++) {
            g.c(a, "new enable protocols is : " + enabledProtocols[i]);
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        int length2 = enabledCipherSuites.length;
        for (int i2 = 0; i2 < length2; i2++) {
            g.c(a, "new cipher suites is : " + enabledCipherSuites[i2]);
        }
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setBlackListCipherSuites(sSLSocket, h);
    }

    public static void setEnableSafeCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket != null && !setWhiteListCipherSuites(sSLSocket)) {
            setBlackListCipherSuites(sSLSocket);
        }
    }

    public static void setEnabledProtocols(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                sSLSocket.setEnabledProtocols(new String[]{b, c});
            }
            if (Build.VERSION.SDK_INT < 29) {
                sSLSocket.setEnabledProtocols(new String[]{c});
            }
        }
    }

    public static SSLContext setSSLContext() throws NoSuchAlgorithmException {
        if (Build.VERSION.SDK_INT >= 29) {
            return SSLContext.getInstance(b);
        }
        return SSLContext.getInstance(c);
    }

    public static void setSSLSocketOptions(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            setEnabledProtocols(sSLSocket);
            setEnableSafeCipherSuites(sSLSocket);
        }
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    arrayList.add(str);
                    break;
                } else if (upperCase.contains(strArr[i].toUpperCase(Locale.ENGLISH))) {
                    break;
                } else {
                    i++;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setWhiteListCipherSuites(sSLSocket, g);
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setEnabledProtocols(SSLSocket sSLSocket, String[] strArr) {
        if (!(sSLSocket == null || strArr == null)) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e2) {
                g.b(a, "setEnabledProtocols: exception : " + e2.getMessage());
            }
        }
        return false;
    }
}
