package com.microtech.aidexx.common.net.cookie;

import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public interface ICookieJar extends CookieJar {
    List<Cookie> loadCookie(HttpUrl httpUrl);

    void removeAllCookie();

    void removeCookie(HttpUrl httpUrl);

    void saveCookie(HttpUrl httpUrl, List<Cookie> list);

    void saveCookie(HttpUrl httpUrl, Cookie cookie);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        saveCookie(httpUrl, list);
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl) {
        return loadCookie(httpUrl);
    }
}
