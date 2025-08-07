package com.microtech.aidexx.ui.main.bg;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatEditText;
import com.microtech.aidexx.databinding.FragmentBgBinding;
import com.microtech.aidexx.utils.DigitFilter;
import com.microtech.aidexx.utils.UnitManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/microtech/aidexx/ui/main/bg/BgFragment$initView$6", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BgFragment.kt */
public final class BgFragment$initView$6 implements TextWatcher {
    final /* synthetic */ BgFragment this$0;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    BgFragment$initView$6(BgFragment bgFragment) {
        this.this$0 = bgFragment;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (i >= 0) {
            try {
                Float floatOrNull = StringsKt.toFloatOrNull(String.valueOf(charSequence));
                if (floatOrNull != null) {
                    BgFragment bgFragment = this.this$0;
                    floatOrNull.floatValue();
                    if (((double) floatOrNull.floatValue()) > bgFragment.maxGlucose) {
                        if (UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L) {
                            ((FragmentBgBinding) bgFragment.getBinding()).etGlucoseValue.setText(String.valueOf(bgFragment.maxGlucose));
                            ((FragmentBgBinding) bgFragment.getBinding()).etGlucoseValue.setSelection(String.valueOf(bgFragment.maxGlucose).length());
                        } else {
                            ((FragmentBgBinding) bgFragment.getBinding()).etGlucoseValue.setText(String.valueOf((int) bgFragment.maxGlucose));
                            ((FragmentBgBinding) bgFragment.getBinding()).etGlucoseValue.setSelection(String.valueOf((int) bgFragment.maxGlucose).length());
                        }
                        AppCompatEditText appCompatEditText = ((FragmentBgBinding) bgFragment.getBinding()).etGlucoseValue;
                        DigitFilter[] digitFilterArr = new DigitFilter[1];
                        DigitFilter digitFilter = new DigitFilter(bgFragment.getPOINTER());
                        digitFilter.setIntOnly(UnitManager.INSTANCE.getGlucoseUnit() != UnitManager.GlucoseUnit.MMOL_PER_L);
                        digitFilter.setGlucoseValue(true);
                        digitFilter.setMaxLength(4);
                        digitFilter.setPointerLength(1);
                        Unit unit = Unit.INSTANCE;
                        digitFilterArr[0] = digitFilter;
                        appCompatEditText.setFilters((InputFilter[]) digitFilterArr);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
