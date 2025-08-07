package com.microtech.aidexx.utils;

import com.microtech.aidexx.data.resource.LanguageResourceManager;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/utils/FormatUtil;", "", "()V", "getOneDigitFormat", "Ljava/text/DecimalFormat;", "getOneDigitFormatWithLocale", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FormatUtil.kt */
public final class FormatUtil {
    public static final FormatUtil INSTANCE = new FormatUtil();

    private FormatUtil() {
    }

    public final DecimalFormat getOneDigitFormat() {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat;
    }

    public final DecimalFormat getOneDigitFormatWithLocale() {
        Locale locale;
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        List split$default = StringsKt.split$default((CharSequence) LanguageResourceManager.INSTANCE.getCurLanguageTag(), new char[]{Soundex.SILENT_MARKER}, false, 0, 6, (Object) null);
        if (split$default.size() > 1) {
            locale = new Locale((String) split$default.get(0), (String) split$default.get(1));
        } else {
            locale = new Locale((String) split$default.get(0));
        }
        decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(locale));
        return decimalFormat;
    }
}
