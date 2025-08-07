package com.microtech.aidexx;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/WeekTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setText", "", "text", "", "type", "Landroid/widget/TextView$BufferType;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: WeekTextView.kt */
public final class WeekTextView extends AppCompatTextView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeekTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeekTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        int id = getId();
        if (id == R.id.week_sun) {
            String findStringValueByName = LanguageResourceManager.INSTANCE.findStringValueByName("week_sun");
            if (findStringValueByName == null) {
                findStringValueByName = "Sun";
            }
            charSequence2 = findStringValueByName;
        } else if (id == R.id.week_mon) {
            String findStringValueByName2 = LanguageResourceManager.INSTANCE.findStringValueByName("week_mon");
            if (findStringValueByName2 == null) {
                findStringValueByName2 = "Mon";
            }
            charSequence2 = findStringValueByName2;
        } else if (id == R.id.week_tue) {
            String findStringValueByName3 = LanguageResourceManager.INSTANCE.findStringValueByName("week_tue");
            if (findStringValueByName3 == null) {
                findStringValueByName3 = "Tue";
            }
            charSequence2 = findStringValueByName3;
        } else if (id == R.id.week_wed) {
            String findStringValueByName4 = LanguageResourceManager.INSTANCE.findStringValueByName("week_wed");
            if (findStringValueByName4 == null) {
                findStringValueByName4 = "Wed";
            }
            charSequence2 = findStringValueByName4;
        } else if (id == R.id.week_thu) {
            String findStringValueByName5 = LanguageResourceManager.INSTANCE.findStringValueByName("week_thu");
            if (findStringValueByName5 == null) {
                findStringValueByName5 = "Thu";
            }
            charSequence2 = findStringValueByName5;
        } else if (id == R.id.week_fri) {
            String findStringValueByName6 = LanguageResourceManager.INSTANCE.findStringValueByName("week_fri");
            if (findStringValueByName6 == null) {
                findStringValueByName6 = "Fri";
            }
            charSequence2 = findStringValueByName6;
        } else if (id == R.id.week_sat) {
            String findStringValueByName7 = LanguageResourceManager.INSTANCE.findStringValueByName("week_sat");
            if (findStringValueByName7 == null) {
                findStringValueByName7 = "Sat";
            }
            charSequence2 = findStringValueByName7;
        } else {
            charSequence2 = null;
        }
        super.setText(charSequence2, bufferType);
    }
}
