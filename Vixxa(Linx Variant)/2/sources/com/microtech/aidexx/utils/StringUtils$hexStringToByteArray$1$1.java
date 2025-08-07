package com.microtech.aidexx.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: StringUtils.kt */
final class StringUtils$hexStringToByteArray$1$1 extends Lambda implements Function1<List<? extends Character>, String> {
    public static final StringUtils$hexStringToByteArray$1$1 INSTANCE = new StringUtils$hexStringToByteArray$1$1();

    StringUtils$hexStringToByteArray$1$1() {
        super(1);
    }

    public final String invoke(List<Character> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return CollectionsKt.joinToString$default(list, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
