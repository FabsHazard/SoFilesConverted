package com.microtech.aidexx.ui.pair;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J<\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000RC\u0010\u0005\u001a+\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/ui/pair/SnInputFilter;", "Landroid/text/InputFilter;", "lengthLimit", "", "(I)V", "onInputComplete", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "", "Lkotlin/ParameterName;", "name", "input", "", "getOnInputComplete", "()Lkotlin/jvm/functions/Function1;", "setOnInputComplete", "(Lkotlin/jvm/functions/Function1;)V", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SnInputFilter.kt */
public final class SnInputFilter implements InputFilter {
    private final int lengthLimit;
    private Function1<? super Pair<Boolean, String>, Unit> onInputComplete;

    public SnInputFilter(int i) {
        this.lengthLimit = i;
    }

    public final Function1<Pair<Boolean, String>, Unit> getOnInputComplete() {
        return this.onInputComplete;
    }

    public final void setOnInputComplete(Function1<? super Pair<Boolean, String>, Unit> function1) {
        this.onInputComplete = function1;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String upperCase = new StringBuilder().append(spanned).append(charSequence).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (String.valueOf(charSequence).length() == 0) {
            Function1<? super Pair<Boolean, String>, Unit> function1 = this.onInputComplete;
            if (function1 != null) {
                function1.invoke(new Pair(false, upperCase));
            }
            return "";
        }
        if (!(spanned == null || charSequence == null)) {
            if (spanned.length() + charSequence.length() < this.lengthLimit) {
                Function1<? super Pair<Boolean, String>, Unit> function12 = this.onInputComplete;
                if (function12 != null) {
                    function12.invoke(new Pair(false, upperCase));
                }
            } else if (spanned.length() + charSequence.length() != this.lengthLimit) {
                return "";
            } else {
                Function1<? super Pair<Boolean, String>, Unit> function13 = this.onInputComplete;
                if (function13 != null) {
                    function13.invoke(new Pair(true, upperCase));
                }
            }
        }
        String upperCase2 = String.valueOf(charSequence).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        return upperCase2;
    }
}
