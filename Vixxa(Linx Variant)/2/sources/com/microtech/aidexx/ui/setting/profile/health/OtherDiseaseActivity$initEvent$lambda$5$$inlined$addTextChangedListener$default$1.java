package com.microtech.aidexx.ui.setting.profile.health;

import android.text.Editable;
import android.text.TextWatcher;
import com.microtech.aidexx.common.net.entity.MenuEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TextView.kt */
public final class OtherDiseaseActivity$initEvent$lambda$5$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ OtherDiseaseActivity this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public OtherDiseaseActivity$initEvent$lambda$5$$inlined$addTextChangedListener$default$1(OtherDiseaseActivity otherDiseaseActivity) {
        this.this$0 = otherDiseaseActivity;
    }

    public void afterTextChanged(Editable editable) {
        List arrayList = new ArrayList();
        CharSequence charSequence = editable;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.this$0.uncheckedData.removeIf(new OtherDiseaseActivity$sam$java_util_function_Predicate$0(OtherDiseaseActivity$initEvent$1$2$1.INSTANCE));
            arrayList.addAll(this.this$0.checkedData);
            arrayList.addAll(this.this$0.uncheckedData);
        } else {
            String obj = StringsKt.trim((CharSequence) editable.toString()).toString();
            boolean z = false;
            for (MenuEntity menuEntity : this.this$0.checkedData) {
                if (StringsKt.contains$default((CharSequence) menuEntity.getItemName(), (CharSequence) obj, false, 2, (Object) null)) {
                    arrayList.add(menuEntity);
                    if (Intrinsics.areEqual((Object) menuEntity.getItemName(), (Object) obj)) {
                        z = true;
                    }
                }
            }
            Collection arrayList2 = new ArrayList();
            for (Object next : this.this$0.uncheckedData) {
                MenuEntity menuEntity2 = (MenuEntity) next;
                if (Intrinsics.areEqual((Object) menuEntity2.getItemName(), (Object) obj)) {
                    z = true;
                }
                if (StringsKt.contains$default((CharSequence) menuEntity2.getItemName(), (CharSequence) obj, false, 2, (Object) null)) {
                    arrayList2.add(next);
                }
            }
            arrayList.addAll((List) arrayList2);
            if (!z) {
                arrayList.add(0, new MenuEntity(StringsKt.trim((CharSequence) editable.toString()).toString(), 4, (String) null, (Integer) null, false, 28, (DefaultConstructorMarker) null));
            }
        }
        this.this$0.otherDiseaseAdapter.setNewInstance(arrayList);
    }
}
