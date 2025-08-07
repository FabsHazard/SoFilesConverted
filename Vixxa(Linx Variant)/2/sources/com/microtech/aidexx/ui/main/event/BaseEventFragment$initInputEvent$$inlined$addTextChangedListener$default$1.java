package com.microtech.aidexx.ui.main.event;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TextView.kt */
public final class BaseEventFragment$initInputEvent$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ ViewGroup $presetRecyclerViewContainer$inlined;
    final /* synthetic */ BaseEventFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public BaseEventFragment$initInputEvent$$inlined$addTextChangedListener$default$1(ViewGroup viewGroup, BaseEventFragment baseEventFragment) {
        this.$presetRecyclerViewContainer$inlined = viewGroup;
        this.this$0 = baseEventFragment;
    }

    public void afterTextChanged(Editable editable) {
        String obj = StringsKt.trim((CharSequence) String.valueOf(editable)).toString();
        if (obj.length() == 0) {
            this.$presetRecyclerViewContainer$inlined.setVisibility(8);
            this.this$0.getViewModel().clearPresetList();
            this.this$0.getPresetAdapter().getData().clear();
            this.this$0.getPresetAdapter().notifyDataSetChanged();
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new BaseEventFragment$initInputEvent$2$1(this.this$0, obj, this.$presetRecyclerViewContainer$inlined, (Continuation<? super BaseEventFragment$initInputEvent$2$1>) null), 3, (Object) null);
    }
}
