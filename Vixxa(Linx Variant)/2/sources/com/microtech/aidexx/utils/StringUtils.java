package com.microtech.aidexx.utils;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.Constants;
import com.microtech.aidexx.ui.web.WebActivity;
import com.microtech.aidexx.views.HyperLinkText;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0004J0\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020!J\u000e\u0010#\u001a\u00020\t2\u0006\u0010 \u001a\u00020!J\u001a\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004¨\u0006("}, d2 = {"Lcom/microtech/aidexx/utils/StringUtils;", "", "()V", "binaryToHex", "", "bytes", "", "binaryToHexString", "checkEmail", "", "email", "checkPhoneNumber", "pn", "checkPwd", "pwd", "checkVerCode", "code", "getMaskedEmail", "getMaskedPhone", "phone", "hexStringToByteArray", "hexString", "initProtocol", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "type", "", "gyPolicyName", "gyPolicyUrl", "isMatch", "regex", "input", "", "isURI", "isURL", "versionCompare", "setupVer", "onLineVer", "CustomHyperText", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StringUtils.kt */
public final class StringUtils {
    public static final StringUtils INSTANCE = new StringUtils();

    private StringUtils() {
    }

    public final boolean isURL(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        return isMatch("^((?:https?\\:\\/\\/|www\\.)(?:[-a-z0-9]+\\.)*[-a-z0-9]+.*)", charSequence);
    }

    private final boolean isMatch(String str, CharSequence charSequence) {
        return charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }

    public final boolean isURI(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        return isMatch("[a-zA-z]+://[^\\s]*", charSequence);
    }

    public final String binaryToHexString(byte[] bArr) {
        String str = "";
        if (bArr == null) {
            return str;
        }
        for (int i = 0; i < bArr.length; i++) {
            str = str + (String.valueOf(BinTools.hex.charAt((bArr[i] & 240) >> 4)) + BinTools.hex.charAt(bArr[i] & 15)) + ',';
        }
        return str;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00030\u00030\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/microtech/aidexx/utils/StringUtils$CustomHyperText;", "Lcom/microtech/aidexx/views/HyperLinkText;", "context", "Landroid/content/Context;", "title", "", "url", "type", "", "color", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getTitle", "()Ljava/lang/String;", "getType", "()I", "getUrl", "onClick", "", "widget", "Landroid/view/View;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: StringUtils.kt */
    public static final class CustomHyperText extends HyperLinkText {
        private final WeakReference<Context> contextRef;
        private final String title;
        private final int type;
        private final String url;

        public final String getTitle() {
            return this.title;
        }

        public final int getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CustomHyperText(Context context, String str, String str2, int i, int i2) {
            super(i2);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.url = str2;
            this.type = i;
            this.contextRef = new WeakReference<>(context);
        }

        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "widget");
            Context context = (Context) this.contextRef.get();
            if (context != null) {
                WebActivity.Companion companion = WebActivity.Companion;
                String str = this.title;
                String str2 = this.url;
                if (str2 == null) {
                    str2 = Constants.INSTANCE.getUserServicePolicyUrl();
                }
                WebActivity.Companion.loadWeb$default(companion, context, str, str2, false, (String) null, 24, (Object) null);
            }
        }
    }

    public static /* synthetic */ SpannableString initProtocol$default(StringUtils stringUtils, Context context, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        return stringUtils.initProtocol(context, i, str, str2);
    }

    public final SpannableString initProtocol(Context context, int i, String str, String str2) {
        String str3;
        SpannableString spannableString;
        int i2;
        SpannableString spannableString2;
        Context context2 = context;
        int i3 = i;
        Intrinsics.checkNotNullParameter(context2, "context");
        String string = context2.getString(R.string.user_sign_servicePolicy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context2.getString(R.string.user_sign_privatePolicy);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (i3 == 1) {
            str3 = context2.getString(R.string.user_sign_desc_ph, new Object[]{string, string2, context2.getString(R.string.app_name)});
        } else if (i3 != 2) {
            str3 = null;
        } else {
            str3 = context2.getString(R.string.user_sign_agreement, new Object[]{(str == null ? "" : str) + ' ' + string, string2});
        }
        if (str3 == null) {
            return null;
        }
        CharSequence charSequence = str3;
        SpannableString spannableString3 = new SpannableString(charSequence);
        if (str != null) {
            int indexOf$default = StringsKt.indexOf$default(charSequence, str, 0, false, 6, (Object) null);
            spannableString3.setSpan(new CustomHyperText(context, str, str2, 1, context2.getColor(R.color.green_65)), indexOf$default, str.length() + indexOf$default, 33);
        }
        CharSequence charSequence2 = charSequence;
        SpannableString spannableString4 = spannableString3;
        int indexOf$default2 = StringsKt.indexOf$default(charSequence, string, 0, false, 6, (Object) null);
        if (indexOf$default2 != -1) {
            String string3 = context2.getString(R.string.user_sign_servicePolicy);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            spannableString = spannableString4;
            i2 = 33;
            spannableString.setSpan(new CustomHyperText(context, string3, Constants.INSTANCE.getUserServicePolicyUrl(), 2, context2.getColor(R.color.green_65)), indexOf$default2, string.length() + indexOf$default2, 33);
        } else {
            spannableString = spannableString4;
            i2 = 33;
        }
        int i4 = i2;
        SpannableString spannableString5 = spannableString;
        int indexOf$default3 = StringsKt.indexOf$default(charSequence2, string2, 0, false, 6, (Object) null);
        if (indexOf$default3 != -1) {
            String string4 = context2.getString(R.string.user_sign_privatePolicy);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            String privacyPolicyUrl = Constants.INSTANCE.getPrivacyPolicyUrl();
            int color = context2.getColor(R.color.green_65);
            spannableString2 = spannableString5;
            spannableString2.setSpan(new CustomHyperText(context, string4, privacyPolicyUrl, 3, color), indexOf$default3, string2.length() + indexOf$default3, i4);
        } else {
            spannableString2 = spannableString5;
        }
        return spannableString2;
    }

    public final boolean versionCompare(String str, String str2) {
        int i;
        int i2;
        if (!(str == null || str2 == null)) {
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
            List split$default2 = StringsKt.split$default((CharSequence) str2, new String[]{"."}, false, 0, 6, (Object) null);
            char c = 2;
            char c2 = split$default.size() != split$default2.size() ? split$default.size() > split$default2.size() ? (char) 1 : 2 : 0;
            int max = Integer.max(split$default2.size(), split$default.size());
            int min = Integer.min(split$default2.size(), split$default.size());
            float f = 0.0f;
            int i3 = 0;
            float f2 = 0.0f;
            while (i3 < max) {
                if (c2 == 0 || c2 == 1) {
                    i = min;
                    if (i3 < i) {
                        Integer intOrNull = StringsKt.toIntOrNull((String) split$default2.get(i3));
                        if (intOrNull == null) {
                            return false;
                        }
                        f2 += ((float) intOrNull.intValue()) * ((float) Math.pow((double) 256.0f, (double) ((i - 1) - i3)));
                    }
                    Integer intOrNull2 = StringsKt.toIntOrNull((String) split$default.get(i3));
                    if (intOrNull2 == null) {
                        return false;
                    }
                    f += ((float) intOrNull2.intValue()) * ((float) Math.pow((double) 256.0f, (double) ((i - 1) - i3)));
                } else if (c2 != c) {
                    i = min;
                } else {
                    if (i3 < min) {
                        Integer intOrNull3 = StringsKt.toIntOrNull((String) split$default.get(i3));
                        if (intOrNull3 == null) {
                            return false;
                        }
                        i2 = min;
                        f += ((float) intOrNull3.intValue()) * ((float) Math.pow((double) 256.0f, (double) ((min - 1) - i3)));
                    } else {
                        i2 = min;
                    }
                    Integer intOrNull4 = StringsKt.toIntOrNull((String) split$default2.get(i3));
                    if (intOrNull4 == null) {
                        return false;
                    }
                    f2 += ((float) intOrNull4.intValue()) * ((float) Math.pow((double) 256.0f, (double) ((i2 - 1) - i3)));
                    i = i2;
                }
                i3++;
                min = i;
                c = 2;
            }
            if (f < f2) {
                return true;
            }
        }
        return false;
    }

    public final String getMaskedPhone(String str) {
        if (str == null) {
            return null;
        }
        CharSequence charSequence = str;
        if (StringsKt.contains$default(charSequence, (CharSequence) "@", false, 2, (Object) null)) {
            str = INSTANCE.getMaskedEmail(str);
        } else if (str.length() == 11) {
            str = StringsKt.replaceRange(charSequence, 3, 7, (CharSequence) "****").toString();
        }
        return str;
    }

    public final String getMaskedEmail(String str) {
        if (str == null) {
            return null;
        }
        String substring = str.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        CharSequence charSequence = str;
        int i = -1;
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (charSequence.charAt(length) == '@') {
                    i = length;
                    break;
                } else if (i2 < 0) {
                    break;
                } else {
                    length = i2;
                }
            }
        }
        String substring2 = str.substring(i);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        String str2 = substring + "****" + substring2;
        Intrinsics.checkNotNullExpressionValue(str2, "toString(...)");
        return str2;
    }

    public final boolean checkPhoneNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "pn");
        return str.length() >= 11;
    }

    public final boolean checkVerCode(String str) {
        Intrinsics.checkNotNullParameter(str, "code");
        return str.length() >= 6;
    }

    public final boolean checkPwd(String str) {
        Intrinsics.checkNotNullParameter(str, "pwd");
        try {
            Pattern compile = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,16}$");
            Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
            Matcher matcher = compile.matcher(str);
            Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
            return matcher.matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean checkEmail(String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        try {
            Pattern compile = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
            Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
            Matcher matcher = compile.matcher(str);
            Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
            return matcher.matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public final byte[] hexStringToByteArray(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "hexString");
        try {
            Result.Companion companion = Result.Companion;
            Iterable<String> chunked = CollectionsKt.chunked(StringsKt.asIterable(str), 2, StringUtils$hexStringToByteArray$1$1.INSTANCE);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(chunked, 10));
            for (String parseInt : chunked) {
                arrayList.add(Byte.valueOf((byte) Integer.parseInt(parseInt, CharsKt.checkRadix(16))));
            }
            obj = Result.m343constructorimpl(CollectionsKt.toByteArray((List) arrayList));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m343constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m349isFailureimpl(obj)) {
            obj = null;
        }
        return (byte[]) obj;
    }

    public final String binaryToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null) {
            int length = bArr.length;
            for (int i = 0; i < length; i++) {
                sb.append(BinTools.hex.charAt((bArr[i] & 240) >> 4));
                sb.append(BinTools.hex.charAt(bArr[i] & 15));
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
