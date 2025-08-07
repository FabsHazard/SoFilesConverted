package com.microtech.aidexx.ui.pair;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterAdapter.kt */
final class TransmitterAdapter$mOnClickListener$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ TransmitterAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterAdapter$mOnClickListener$1(TransmitterAdapter transmitterAdapter) {
        super(1);
        this.this$0 = transmitterAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        int absoluteAdapterPosition;
        Function1<BleControllerProxy, Unit> onPairClick;
        Intrinsics.checkNotNullParameter(view, "v");
        Object tag = view.getTag();
        if (tag != null && this.this$0.mList.size() > (absoluteAdapterPosition = ((RecyclerView.ViewHolder) tag).getAbsoluteAdapterPosition()) && (onPairClick = this.this$0.getOnPairClick()) != null) {
            onPairClick.invoke(this.this$0.mList.get(absoluteAdapterPosition));
        }
    }
}
