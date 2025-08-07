package com.microtech.aidexx.common.net;

import com.microtech.aidexx.common.net.exception.HttpStatusCodeException;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public class OkHttpCompat {
    private static String OKHTTP_USER_AGENT;

    public static boolean needDecodeResult(Response response) {
        return !"false".equals(response.request().header("data-decrypt"));
    }

    public static void closeQuietly(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    Util.closeQuietly(closeable);
                }
            }
        }
    }

    public static ResponseBody buffer(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.source().readAll(buffer);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), (BufferedSource) buffer);
    }

    public static RequestBody create(MediaType mediaType, String str) {
        return RequestBody.create(mediaType, str);
    }

    public static RequestBody create(MediaType mediaType, ByteString byteString) {
        return RequestBody.create(mediaType, byteString);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        return RequestBody.create(mediaType, bArr, i, i2);
    }

    public static MultipartBody.Part part(RequestBody requestBody) {
        return MultipartBody.Part.create(requestBody);
    }

    public static MultipartBody.Part part(Headers headers, RequestBody requestBody) {
        return MultipartBody.Part.create(headers, requestBody);
    }

    public static MultipartBody.Part part(String str, String str2, RequestBody requestBody) {
        return MultipartBody.Part.createFormData(str, str2, requestBody);
    }

    public static Request request(Response response) {
        return response.request();
    }

    public static List<String> pathSegments(Response response) {
        return response.request().url().pathSegments();
    }

    public static HttpUrl url(Request request) {
        return request.url();
    }

    public static CookieJar cookieJar(OkHttpClient okHttpClient) {
        return okHttpClient.cookieJar();
    }

    public static String header(Response response, String str) {
        return response.header(str);
    }

    public static boolean isPartialContent(Response response) {
        return response.code() == 206;
    }

    public static long receivedResponseAtMillis(Response response) {
        return response.receivedResponseAtMillis();
    }

    public static ResponseBody throwIfFail(Response response) throws IOException {
        ResponseBody body = response.body();
        if (response.isSuccessful()) {
            return body;
        }
        try {
            throw new HttpStatusCodeException(response.newBuilder().body(buffer(body)).build());
        } catch (Throwable th) {
            body.close();
            throw th;
        }
    }

    public static long getContentLength(Response response) {
        ResponseBody body = response.body();
        long j = -1;
        if (body != null) {
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                return contentLength;
            }
            j = contentLength;
        }
        String header = response.header("Content-Range");
        if (header == null) {
            return j;
        }
        try {
            String[] split = header.substring(header.indexOf(" ") + 1, header.indexOf(InternalZipConstants.ZIP_FILE_SEPARATOR)).split("-");
            return (Long.parseLong(split[1]) - Long.parseLong(split[0])) + 1;
        } catch (Exception unused) {
            return j;
        }
    }

    public static StatusLine parse(String str) throws IOException {
        if (okHttpVersionCompare("4.0.0") >= 0) {
            return StatusLine.Companion.parse(str);
        }
        Class<StatusLine> cls = StatusLine.class;
        try {
            return (StatusLine) cls.getDeclaredMethod("parse", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static DiskLruCache newDiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (okHttpVersionCompare("4.3.0") >= 0) {
            return new DiskLruCache(fileSystem, file, i, i2, j, TaskRunner.INSTANCE);
        } else if (okHttpVersionCompare("4.0.0") >= 0) {
            DiskLruCache.Companion companion = DiskLruCache.Companion;
            try {
                return (DiskLruCache) companion.getClass().getDeclaredMethod("create", new Class[]{FileSystem.class, File.class, Integer.TYPE, Integer.TYPE, Long.TYPE}).invoke(companion, new Object[]{fileSystem, file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
            } catch (Throwable th) {
                th.printStackTrace();
                throw new RuntimeException("Please upgrade OkHttp to V3.12.0 or higher");
            }
        } else {
            try {
                return (DiskLruCache) DiskLruCache.class.getDeclaredMethod("create", new Class[]{FileSystem.class, File.class, Integer.TYPE, Integer.TYPE, Long.TYPE}).invoke((Object) null, new Object[]{fileSystem, file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
            } catch (Throwable th2) {
                th2.printStackTrace();
                throw new RuntimeException("Please upgrade OkHttp to V3.12.0 or higher");
            }
        }
    }

    public static int okHttpVersionCompare(String str) {
        String[] split = getOkHttpUserAgent().split(InternalZipConstants.ZIP_FILE_SEPARATOR);
        return versionCompare(split[split.length - 1], str);
    }

    public static String getOkHttpUserAgent() {
        String str = OKHTTP_USER_AGENT;
        if (str != null) {
            return str;
        }
        try {
            String str2 = (String) Class.forName("okhttp3.internal.Util").getDeclaredField("userAgent").get((Object) null);
            OKHTTP_USER_AGENT = str2;
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            OKHTTP_USER_AGENT = "okhttp/4.2.0";
            return "okhttp/4.2.0";
        }
    }

    private static int versionCompare(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            String str3 = split[i2];
            String str4 = split2[i2];
            int length = str3.length() - str4.length();
            i = length == 0 ? str3.compareTo(str4) : length;
            if (i != 0) {
                break;
            }
        }
        return i != 0 ? i : split.length - split2.length;
    }
}
