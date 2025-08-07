package com.microtech.aidexx.utils;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import com.microtech.aidexx.common.ExtendsKt;
import java.text.DecimalFormatSymbols;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\r\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0006\u0010\u0018\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/microtech/aidexx/utils/DecimalInputTextWatcher;", "Landroid/text/TextWatcher;", "editText", "Landroid/widget/EditText;", "totalDigits", "", "decimalDigits", "(Landroid/widget/EditText;II)V", "decimalSeparator", "", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "charSequence", "", "i", "i1", "i2", "getDoubleValue", "", "()Ljava/lang/Double;", "onTextChanged", "setValue", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DecimalInputTextWatcher.kt */
public final class DecimalInputTextWatcher implements TextWatcher {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_DECIMAL_DIGITS = 2;
    private static final String Zero = "0";
    private final int decimalDigits;
    private String decimalSeparator;
    private EditText editText;
    private final int totalDigits;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
    }

    public final void setValue() {
    }

    public DecimalInputTextWatcher(EditText editText2, int i, int i2) {
        Intrinsics.checkNotNullParameter(editText2, "editText");
        this.editText = editText2;
        if (i <= 0) {
            throw new RuntimeException("totalDigits must > 0");
        } else if (i2 > 0) {
            this.totalDigits = i;
            this.decimalDigits = i2;
            this.decimalSeparator = String.valueOf(DecimalFormatSymbols.getInstance(ExtendsKt.getLocale()).getDecimalSeparator());
            EditText editText3 = this.editText;
            DigitFilter digitFilter = new DigitFilter(this.decimalSeparator);
            digitFilter.pointerLength = 1;
            Unit unit = Unit.INSTANCE;
            editText3.setFilters((InputFilter[]) new DigitFilter[]{digitFilter});
        } else {
            throw new RuntimeException("decimalDigits must > 0");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DecimalInputTextWatcher(EditText editText2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(editText2, i, (i3 & 4) != 0 ? 2 : i2);
    }

    public final Double getDoubleValue() {
        Editable text = this.editText.getText();
        String obj = text != null ? text.toString() : null;
        CharSequence charSequence = obj;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        return StringsKt.toDoubleOrNull(StringsKt.replace$default(obj, this.decimalSeparator, ".", false, 4, (Object) null));
    }

    public void afterTextChanged(Editable editable) {
        int i;
        Editable editable2 = editable;
        Intrinsics.checkNotNullParameter(editable2, "editable");
        try {
            String obj = editable.toString();
            this.editText.removeTextChangedListener(this);
            if (StringsKt.contains$default((CharSequence) obj, (CharSequence) this.decimalSeparator, false, 2, (Object) null)) {
                i = this.totalDigits;
                this.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
                if ((obj.length() - 1) - StringsKt.indexOf$default((CharSequence) obj, this.decimalSeparator, 0, false, 6, (Object) null) > this.decimalDigits) {
                    obj = obj.substring(0, StringsKt.indexOf$default((CharSequence) obj, this.decimalSeparator, 0, false, 6, (Object) null) + this.decimalDigits + 1);
                    Intrinsics.checkNotNullExpressionValue(obj, "substring(...)");
                    int length = editable.length();
                    CharSequence charSequence = obj;
                    int length2 = charSequence.length() - 1;
                    int i2 = 0;
                    boolean z = false;
                    while (true) {
                        if (i2 > length2) {
                            break;
                        }
                        boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i2 : length2), 32) <= 0;
                        if (!z) {
                            if (!z2) {
                                z = true;
                            } else {
                                i2++;
                            }
                        } else if (!z2) {
                            break;
                        } else {
                            length2--;
                        }
                    }
                    editable2.replace(0, length, charSequence.subSequence(i2, length2 + 1).toString());
                }
            } else {
                i = this.totalDigits - this.decimalDigits;
                this.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
                if (obj.length() >= i && !StringsKt.endsWith$default(obj, this.decimalSeparator, false, 2, (Object) null)) {
                    editable2.replace(i - 1, i, "");
                }
            }
            CharSequence charSequence2 = obj;
            int length3 = charSequence2.length() - 1;
            int i3 = 0;
            boolean z3 = false;
            while (true) {
                if (i3 > length3) {
                    break;
                }
                boolean z4 = Intrinsics.compare((int) charSequence2.charAt(!z3 ? i3 : length3), 32) <= 0;
                if (!z3) {
                    if (!z4) {
                        z3 = true;
                    } else {
                        i3++;
                    }
                } else if (!z4) {
                    break;
                } else {
                    length3--;
                }
            }
            if (Intrinsics.areEqual((Object) charSequence2.subSequence(i3, length3 + 1).toString(), (Object) this.decimalSeparator)) {
                obj = '0' + obj;
                int length4 = editable.length();
                CharSequence charSequence3 = obj;
                int length5 = charSequence3.length() - 1;
                int i4 = 0;
                boolean z5 = false;
                while (true) {
                    if (i4 > length5) {
                        break;
                    }
                    boolean z6 = Intrinsics.compare((int) charSequence3.charAt(!z5 ? i4 : length5), 32) <= 0;
                    if (!z5) {
                        if (!z6) {
                            z5 = true;
                        } else {
                            i4++;
                        }
                    } else if (!z6) {
                        break;
                    } else {
                        length5--;
                    }
                }
                editable2.replace(0, length4, charSequence3.subSequence(i4, length5 + 1).toString());
            }
            if (StringsKt.startsWith$default(obj, "0", false, 2, (Object) null)) {
                CharSequence charSequence4 = obj;
                int length6 = charSequence4.length() - 1;
                int i5 = 0;
                boolean z7 = false;
                while (true) {
                    if (i5 > length6) {
                        break;
                    }
                    boolean z8 = Intrinsics.compare((int) charSequence4.charAt(!z7 ? i5 : length6), 32) <= 0;
                    if (!z7) {
                        if (!z8) {
                            z7 = true;
                        } else {
                            i5++;
                        }
                    } else if (!z8) {
                        break;
                    } else {
                        length6--;
                    }
                }
                if (charSequence4.subSequence(i5, length6 + 1).toString().length() > 1) {
                    String substring = obj.substring(1, 2);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    if (!Intrinsics.areEqual((Object) substring, (Object) this.decimalSeparator)) {
                        editable2.replace(0, 1, "");
                    }
                }
            }
            EditText editText2 = this.editText;
            DigitFilter digitFilter = new DigitFilter(this.decimalSeparator);
            digitFilter.pointerLength = 1;
            Unit unit = Unit.INSTANCE;
            editText2.setFilters(new InputFilter[]{digitFilter, new InputFilter.LengthFilter(i)});
            this.editText.addTextChangedListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/microtech/aidexx/utils/DecimalInputTextWatcher$Companion;", "", "()V", "DEFAULT_DECIMAL_DIGITS", "", "Zero", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DecimalInputTextWatcher.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
