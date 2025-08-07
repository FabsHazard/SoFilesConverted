package com.huawei.hms.feature.dynamic.f;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

public class e {
    public static final String a = "X509CertUtil";
    public static final String b = "X.509";
    public static final int c = 5;
    public static final String d = "OU";
    public static final String e = "CN";
    public static final String f = "MIIFZDCCA0ygAwIBAgIIYsLLTehAXpYwDQYJKoZIhvcNAQELBQAwUDELMAkGA1UEBhMCQ04xDzANBgNVBAoMBkh1YXdlaTETMBEGA1UECwwKSHVhd2VpIENCRzEbMBkGA1UEAwwSSHVhd2VpIENCRyBSb290IENBMB4XDTE3MDgyMTEwNTYyN1oXDTQyMDgxNTEwNTYyN1owUDELMAkGA1UEBhMCQ04xDzANBgNVBAoMBkh1YXdlaTETMBEGA1UECwwKSHVhd2VpIENCRzEbMBkGA1UEAwwSSHVhd2VpIENCRyBSb290IENBMIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEA1OyKm3Ig/6eibB7Uz2o93UqGk2M784WdfF8mvffvu218d61G5M3Px54E3kefUTk5Ky1ywHvw7Rp9KDuYv7ktaHkk+yr59Ihseu3a7iM/C6SnMSGt+LfB/Bcob9Abw95EigXQ4yQddX9hbNrin3AwZw8wMjEISYYDo5GuYDL0NbAiYg2Y5GpfYIqRzoi6GqDz+evLrsl20kJeCEPgJZN4Jg00Iq9k++EKOZ5Jc/Zx22ZUgKpdwKABkvzshEgG6WWUPB+gosOiLv++inu/9blDpEzQZhjZ9WVHpURHDK1YlCvubVAMhDpnbqNHZ0AxlPletdoyugrH/OLKl5inhMXNj3Re7Hl8WsBWLUKp6sXFf0dvSFzqnr2jkhicS+K2IYZnjghC9cOBRO8fnkonh0EBt0evjUIKr5ClbCKioBX8JU+d4ldtWOpp2FlxeFTLreDJ5ZBU4//bQpTwYMt7gwMK+MO5WtokUx3UF98Z6GdUgbl6nBjBe82c7oIQXhHGHPnURQO7DDPgyVnNOnTPIkmiHJh/e3vkVhiZNHFCCLTip6GoJVrLxwb9i4q+d0thw4doxVJ5NB9OfDMV64/ybJgpf7m3Ld2yE0gsf1prrRlDFDXjlYyqqpf1l9Y0u3ctXo7UpXMgbyDEpUQhq3a7txZQO/17luTDoA6Tz1ADavvBwHkCAwEAAaNCMEAwDgYDVR0PAQH/BAQDAgEGMA8GA1UdEwEB/wQFMAMBAf8wHQYDVR0OBBYEFKrE03lH6G4ja+/wqWwicz16GWmhMA0GCSqGSIb3DQEBCwUAA4ICAQC1d3TMB+VHZdGrWJbfaBShFNiCTN/MceSHOpzBn6JumQP4N7mxCOwdRSsGKQxV2NPH7LTXWNhUvUw5Sek96FWx/+Oa7jsj3WNAVtmS3zKpCQ5iGb08WIROcFnx3oUQ5rcO8r/lUk7Q2cN0E+rF4xsdQrH9k2cd3kAXZXBjfxfKPJTdPy1XnZR/h8H5EwEK5DWjSzK1wKd3G/Fxdm3E23pcr4FZgdYdOlFSiqW2TJ3Qe6lF4GOKOOydWHkpu54ieTsqoYcuMKnKMjT2SLNNgv9Gu5ipaG8Olz6g9C7Htp943lmK/1VtnhggpL3rDTsFX/+ehk7OtxuNzRMD9lXUtEfok7f8XB0dcL4ZjnEhDmp5QZqC1kMubHQtQnTauEiv0YkSGOwJAUZpK1PIff5GgxXYfaHfBC6Op4q02ppl5Q3URl7XIjYLjvs9t4S9xPe8tb6416V2fe1dZ62vOXMMKHkZjVihh+IceYpJYHuyfKoYJyahLOQXZykGK5iPAEEtq3HPfMVF43RKHOwfhrAH5KwelUA/0EkcR4Gzth1MKEqojdnYNemkkSy7aNPPT4LEm5R7sV6vG1CjwbgvQrWCgc4nMb8ngdfnVF7Ydqjqi9SAqUzIk4+Uf0ZY+6RY5IcHdCaiPaWIE1xURQ8B0DRUURsQwXdjZhgLN/DKJpCl5aCCxg==";

    public static String a(String str, String str2) {
        int indexOf = str.toUpperCase(Locale.getDefault()).indexOf(str2 + ContainerUtils.KEY_VALUE_DELIMITER);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        int length = indexOf + str2.length() + 1;
        return indexOf2 != -1 ? str.substring(length, indexOf2) : str.substring(length);
    }

    public static X509Certificate a() {
        return a(Base64.decode(f, 2));
    }

    public static X509Certificate a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(a.a(str));
    }

    public static X509Certificate a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            Certificate generateCertificate = CertificateFactory.getInstance(b).generateCertificate(new ByteArrayInputStream(bArr));
            if (generateCertificate instanceof X509Certificate) {
                return (X509Certificate) generateCertificate;
            }
        } catch (CertificateException e2) {
            Log.e(a, "Failed to get cert,CertificateException:", e2);
        }
        return null;
    }

    public static boolean a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        return a(x509Certificate, e, str);
    }

    public static boolean a(X509Certificate x509Certificate, String str, String str2) {
        if (x509Certificate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(a(x509Certificate.getSubjectDN().getName(), str));
    }

    public static boolean a(X509Certificate x509Certificate, List<X509Certificate> list) {
        String str;
        if (list.size() == 0 || x509Certificate == null) {
            return false;
        }
        try {
            x509Certificate.checkValidity();
            PublicKey publicKey = x509Certificate.getPublicKey();
            int size = list.size() - 1;
            while (size >= 0) {
                try {
                    X509Certificate x509Certificate2 = list.get(size);
                    x509Certificate2.verify(publicKey);
                    x509Certificate2.checkValidity();
                    publicKey = x509Certificate2.getPublicKey();
                    size--;
                } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e2) {
                    e = e2;
                    str = "verify failed,Exception:";
                    Log.e(a, str, e);
                    return false;
                }
            }
            return a(list);
        } catch (CertificateExpiredException | CertificateNotYetValidException e3) {
            e = e3;
            str = "verifyCertChain Exception:";
            Log.e(a, str, e);
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) {
        if (x509Certificate == null || bArr == null || bArr2 == null) {
            Log.w(a, "checkSignature parameter is null");
            return false;
        }
        try {
            Signature instance = Signature.getInstance(x509Certificate.getSigAlgName());
            instance.initVerify(x509Certificate.getPublicKey());
            instance.update(bArr);
            return instance.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e2) {
            Log.e(a, "failed checkSignature,Exception:", e2);
            return false;
        }
    }

    public static boolean a(List<X509Certificate> list) {
        for (int i = 1; i < list.size(); i++) {
            if (!a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<X509Certificate> b(String str) {
        return b(c(str));
    }

    public static List<X509Certificate> b(List<String> list) {
        if (list == null) {
            Log.w(a, "base64 CertChain is null.");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String a2 : list) {
            X509Certificate a3 = a(a2);
            if (a3 == null) {
                Log.e(a, "Failed to get cert from CertChain");
            } else {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    public static boolean b(X509Certificate x509Certificate, String str) {
        return a(x509Certificate, d, str);
    }

    public static List<String> c(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 1) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException e2) {
            Log.e(a, "Failed to getCertChain,JSONException:", e2);
            return Collections.emptyList();
        }
    }
}
