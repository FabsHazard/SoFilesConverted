package com.microtech.aidexx.common.net.cookie;

import com.microtech.aidexx.common.net.OkHttpCompat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public class CookieStore implements ICookieJar {
    private static final int appVersion = 1;
    private final File directory;
    private DiskLruCache diskCache;
    private final long maxSize;
    private Map<String, ConcurrentHashMap<String, Cookie>> memoryCache;

    public CookieStore() {
        this((File) null, 2147483647L, true);
    }

    public CookieStore(File file) {
        this(file, 2147483647L, true);
    }

    public CookieStore(File file, boolean z) {
        this(file, 2147483647L, z);
    }

    public CookieStore(File file, long j, boolean z) {
        if (z || file != null) {
            if (z) {
                this.memoryCache = new ConcurrentHashMap();
            }
            this.directory = file;
            this.maxSize = j;
            return;
        }
        throw new IllegalArgumentException("Memory or disk caching must be enabled");
    }

    private DiskLruCache getDiskLruCache() {
        if (this.directory != null && this.diskCache == null) {
            this.diskCache = OkHttpCompat.newDiskLruCache(FileSystem.SYSTEM, this.directory, 1, 1, this.maxSize);
        }
        return this.diskCache;
    }

    public void saveCookie(HttpUrl httpUrl, Cookie cookie) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(cookie);
        saveCookie(httpUrl, (List<Cookie>) arrayList);
    }

    public void saveCookie(HttpUrl httpUrl, List<Cookie> list) {
        ConcurrentHashMap concurrentHashMap;
        String host = httpUrl.host();
        Map<String, ConcurrentHashMap<String, Cookie>> map = this.memoryCache;
        if (map != null) {
            concurrentHashMap = map.get(host);
            if (concurrentHashMap == null) {
                Map<String, ConcurrentHashMap<String, Cookie>> map2 = this.memoryCache;
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                map2.put(host, concurrentHashMap2);
                concurrentHashMap = concurrentHashMap2;
            }
        } else {
            concurrentHashMap = new ConcurrentHashMap();
        }
        for (Cookie next : list) {
            concurrentHashMap.put(getToken(next), next);
        }
        DiskLruCache diskLruCache = getDiskLruCache();
        if (diskLruCache != null) {
            DiskLruCache.Editor editor = null;
            try {
                editor = diskLruCache.edit(md5(host));
                if (editor == null) {
                    abortQuietly(editor);
                    return;
                }
                writeCookie(editor, concurrentHashMap);
                editor.commit();
                abortQuietly(editor);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                abortQuietly(editor);
                throw th;
            }
        }
    }

    public List<Cookie> loadCookie(HttpUrl httpUrl) {
        Map map;
        String host = httpUrl.host();
        Map<String, ConcurrentHashMap<String, Cookie>> map2 = this.memoryCache;
        if (map2 != null && (map = map2.get(host)) != null) {
            return matchCookies(httpUrl, map);
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        DiskLruCache diskLruCache = getDiskLruCache();
        if (diskLruCache != null) {
            DiskLruCache.Snapshot snapshot = null;
            try {
                snapshot = diskLruCache.get(md5(host));
                if (snapshot == null) {
                    return Collections.emptyList();
                }
                for (Cookie next : readCookie(httpUrl, snapshot.getSource(0))) {
                    concurrentHashMap.put(getToken(next), next);
                }
                OkHttpCompat.closeQuietly(snapshot);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                OkHttpCompat.closeQuietly(snapshot);
            }
        }
        if (this.memoryCache != null && !concurrentHashMap.isEmpty()) {
            this.memoryCache.put(host, concurrentHashMap);
        }
        return matchCookies(httpUrl, concurrentHashMap);
    }

    private List<Cookie> matchCookies(HttpUrl httpUrl, Map<String, Cookie> map) {
        ArrayList arrayList = new ArrayList();
        for (Cookie next : map.values()) {
            if (next.matches(httpUrl) && next.expiresAt() > System.currentTimeMillis()) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private String getToken(Cookie cookie) {
        return cookie.name() + "; " + cookie.domain() + "; " + cookie.path() + "; " + cookie.secure();
    }

    public void removeCookie(HttpUrl httpUrl) {
        String host = httpUrl.host();
        Map<String, ConcurrentHashMap<String, Cookie>> map = this.memoryCache;
        if (map != null) {
            map.remove(host);
        }
        DiskLruCache diskLruCache = getDiskLruCache();
        if (diskLruCache != null) {
            try {
                diskLruCache.remove(md5(host));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeAllCookie() {
        Map<String, ConcurrentHashMap<String, Cookie>> map = this.memoryCache;
        if (map != null) {
            map.clear();
        }
        DiskLruCache diskLruCache = getDiskLruCache();
        if (diskLruCache != null) {
            try {
                diskLruCache.evictAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Cookie> readCookie(HttpUrl httpUrl, Source source) throws IOException {
        ArrayList arrayList = new ArrayList();
        try {
            BufferedSource buffer = Okio.buffer(source);
            int readInt = buffer.readInt();
            for (int i = 0; i < readInt; i++) {
                arrayList.add(Cookie.parse(httpUrl, buffer.readUtf8LineStrict()));
            }
            return arrayList;
        } finally {
            source.close();
        }
    }

    private void writeCookie(DiskLruCache.Editor editor, Map<String, Cookie> map) throws IOException {
        BufferedSink buffer = Okio.buffer(editor.newSink(0));
        buffer.writeInt(map.size());
        for (Cookie cookie : map.values()) {
            buffer.writeUtf8(cookie.toString()).writeByte(10);
        }
        buffer.close();
    }

    private void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (Exception unused) {
            }
        }
    }

    private static String md5(String str) {
        return ByteString.encodeUtf8(str).md5().hex();
    }
}
