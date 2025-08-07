package com.microtech.aidexx.common.net.interceptors;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import com.microtech.aidexx.utils.LogUtil;
import com.yalantis.ucrop.UCrop;
import java.io.IOException;
import java.net.URLDecoder;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class LogInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        MediaType mediaType;
        RequestBody body;
        Request request = chain.request();
        long currentTimeMillis = System.currentTimeMillis();
        Response proceed = chain.proceed(chain.request());
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        String str = "Unknown response type";
        if (proceed.body() != null) {
            mediaType = proceed.body().contentType();
            if (canText(mediaType)) {
                str = proceed.body().string();
            } else if (mediaType != null) {
                str = mediaType.toString();
            }
        } else {
            mediaType = null;
        }
        LogUtil.eAiDEX("\n");
        LogUtil.eAiDEX("---------- Start ----------");
        LogUtil.eAiDEX("| " + request);
        if (request.method().equalsIgnoreCase("POST") && (body = request.body()) != null && canText(body.contentType())) {
            LogUtil.eAiDEX("| Request Params:" + bodyToString(request));
        }
        LogUtil.eAiDEX("| Response:" + str);
        LogUtil.eAiDEX("---------- End:" + currentTimeMillis2 + "millis ----------");
        if (!canText(mediaType)) {
            return proceed;
        }
        proceed.close();
        return proceed.newBuilder().body(ResponseBody.create(mediaType, str)).build();
    }

    private String bodyToString(Request request) {
        Request build = request.newBuilder().build();
        Buffer buffer = new Buffer();
        try {
            if (build.body() != null) {
                build.body().writeTo(buffer);
            }
            return buffer.readUtf8();
        } catch (IOException unused) {
            return "something error,when show requestBody";
        }
    }

    private boolean canText(MediaType mediaType) {
        if (mediaType == null) {
            return false;
        }
        if (mediaType.type().contains("text")) {
            return true;
        }
        if (mediaType.subtype().contains("json") || mediaType.subtype().contains("xml") || mediaType.subtype().contains("html") || mediaType.subtype().contains("webviewhtml")) {
            return true;
        }
        return false;
    }

    private String getParam(RequestBody requestBody) {
        Buffer buffer = new Buffer();
        try {
            requestBody.writeTo(buffer);
            return URLDecoder.decode(buffer.readUtf8(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String unicodeToUtf8(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i += 2;
                char charAt2 = str.charAt(i2);
                if (charAt2 == 'u') {
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < 4) {
                        int i5 = i + 1;
                        char charAt3 = str.charAt(i);
                        switch (charAt3) {
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                            case '2':
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE:
                            case '8':
                            case '9':
                                i4 = ((i4 << 4) + charAt3) - 48;
                                break;
                            default:
                                switch (charAt3) {
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
                                    case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                                    case 'D':
                                    case UCrop.REQUEST_CROP /*69*/:
                                    case 'F':
                                        i4 = (((i4 << 4) + 10) + charAt3) - 65;
                                        break;
                                    default:
                                        switch (charAt3) {
                                            case 'a':
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY:
                                                i4 = (((i4 << 4) + 10) + charAt3) - 97;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                        }
                                }
                        }
                        i3++;
                        i = i5;
                    }
                    stringBuffer.append((char) i4);
                } else {
                    if (charAt2 == 't') {
                        charAt2 = 9;
                    } else if (charAt2 == 'r') {
                        charAt2 = 13;
                    } else if (charAt2 == 'n') {
                        charAt2 = 10;
                    } else if (charAt2 == 'f') {
                        charAt2 = 12;
                    }
                    stringBuffer.append(charAt2);
                }
            } else {
                stringBuffer.append(charAt);
                i = i2;
            }
        }
        return stringBuffer.toString();
    }
}
