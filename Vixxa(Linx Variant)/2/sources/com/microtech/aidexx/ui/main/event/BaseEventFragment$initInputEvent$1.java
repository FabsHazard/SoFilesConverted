package com.microtech.aidexx.ui.main.event;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.microtech.aidexx.db.entity.event.BaseEventDetail;
import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import com.microtech.aidexx.utils.blankj.KeyboardUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "position", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventFragment.kt */
final class BaseEventFragment$initInputEvent$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ EditText $inputEditText;
    final /* synthetic */ ViewGroup $presetRecyclerViewContainer;
    final /* synthetic */ BaseEventFragment<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventFragment$initInputEvent$1(EditText editText, BaseEventFragment<VM, VB> baseEventFragment, ViewGroup viewGroup) {
        super(1);
        this.$inputEditText = editText;
        this.this$0 = baseEventFragment;
        this.$presetRecyclerViewContainer = viewGroup;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        KeyboardUtils.INSTANCE.hideSoftInput((View) this.$inputEditText);
        BasePresetEntity basePresetEntity = (BasePresetEntity) this.this$0.getViewModel().getPresetList().get(i);
        BaseEventDetail access$presetToDetail = this.this$0.presetToDetail(basePresetEntity);
        BaseEventFragment<VM, VB> baseEventFragment = this.this$0;
        Intrinsics.checkNotNull(access$presetToDetail);
        boolean z = basePresetEntity.getIdx() == 0;
        final BaseEventFragment<VM, VB> baseEventFragment2 = this.this$0;
        BaseEventFragment.showPresetDialog$default(baseEventFragment, access$presetToDetail, z, false, true, new Function1<BaseEventDetail, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BaseEventDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(BaseEventDetail baseEventDetail) {
                Intrinsics.checkNotNullParameter(baseEventDetail, "detailEntity");
                baseEventDetail.setId(0);
                baseEventFragment2.getViewModel().addToSaveDetailList(baseEventDetail);
                baseEventFragment2.getToSaveDetailAdapter().getData().add(0, baseEventDetail);
                baseEventFragment2.getToSaveDetailAdapter().notifyItemInserted(0);
            }
        }, (Function1) null, 36, (Object) null);
        this.$presetRecyclerViewContainer.setVisibility(8);
    }
}
