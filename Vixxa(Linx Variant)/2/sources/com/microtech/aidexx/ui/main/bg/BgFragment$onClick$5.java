package com.microtech.aidexx.ui.main.bg;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.FragmentBgBinding;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.utils.eventbus.DataChangedType;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.views.dialog.standard.StandardDialog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BgFragment.kt */
final class BgFragment$onClick$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BloodGlucoseEntity $bgEntity;
    final /* synthetic */ BgFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BgFragment$onClick$5(BgFragment bgFragment, BloodGlucoseEntity bloodGlucoseEntity) {
        super(0);
        this.this$0 = bgFragment;
        this.$bgEntity = bloodGlucoseEntity;
    }

    public final void invoke() {
        new Handler(Looper.getMainLooper()).post(new BgFragment$onClick$5$$ExternalSyntheticLambda2(this.this$0, this.$bgEntity));
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2(BgFragment bgFragment, BloodGlucoseEntity bloodGlucoseEntity) {
        StandardDialog create;
        Intrinsics.checkNotNullParameter(bgFragment, "this$0");
        Intrinsics.checkNotNullParameter(bloodGlucoseEntity, "$bgEntity");
        StandardDialog.Setter setter = new StandardDialog.Setter(bgFragment.getContext());
        Context context = bgFragment.getContext();
        String str = null;
        if (context != null) {
            int i = R.string.com_actionState_success;
            Context context2 = bgFragment.getContext();
            if (context2 != null) {
                str = context2.getString(R.string.com_action_save);
            }
            str = context.getString(i, new Object[]{str});
        }
        StandardDialog.Setter onDismissListener = setter.content(str).setPositive(new BgFragment$onClick$5$$ExternalSyntheticLambda0(bgFragment, bloodGlucoseEntity)).setOnDismissListener(new BgFragment$onClick$5$$ExternalSyntheticLambda1(bgFragment));
        if (onDismissListener != null && (create = onDismissListener.create(0)) != null) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$0(BgFragment bgFragment, BloodGlucoseEntity bloodGlucoseEntity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(bgFragment, "this$0");
        Intrinsics.checkNotNullParameter(bloodGlucoseEntity, "$bgEntity");
        dialogInterface.dismiss();
        Editable text = ((FragmentBgBinding) bgFragment.getBinding()).etGlucoseValue.getText();
        if (text != null) {
            text.clear();
        }
        bgFragment.timeSlot = null;
        bgFragment.updateLastRecord();
        TimeSlopAdapter access$getTimeSlopAdapter$p = bgFragment.timeSlopAdapter;
        if (access$getTimeSlopAdapter$p != null) {
            access$getTimeSlopAdapter$p.clearCheck();
        }
        EventBusManager.INSTANCE.send(EventBusKey.EVENT_DATA_CHANGED, new Pair(DataChangedType.ADD, CollectionsKt.listOf(bloodGlucoseEntity)));
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(BgFragment bgFragment) {
        Intrinsics.checkNotNullParameter(bgFragment, "this$0");
        bgFragment.updateLastRecord();
    }
}
