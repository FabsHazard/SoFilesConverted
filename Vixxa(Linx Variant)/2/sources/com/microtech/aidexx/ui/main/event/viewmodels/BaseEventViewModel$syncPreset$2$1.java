package com.microtech.aidexx.ui.main.event.viewmodels;

import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tH@¢\u0006\u0004\b\f\u0010\r"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "D", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "ret", "Lkotlin/Pair;", "", "", "emit", "(Lkotlin/Pair;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventViewModel.kt */
final class BaseEventViewModel$syncPreset$2$1<T> implements FlowCollector {
    final /* synthetic */ boolean $isSys;
    final /* synthetic */ int $type;
    final /* synthetic */ String $version;

    BaseEventViewModel$syncPreset$2$1(int i, String str, boolean z) {
        this.$type = i;
        this.$version = str;
        this.$isSys = z;
    }

    public final Object emit(Pair<Boolean, Integer> pair, Continuation<? super Unit> continuation) {
        if (Intrinsics.areEqual((Object) pair.getFirst(), (Object) Boxing.boxBoolean(true))) {
            MmkvManager.INSTANCE.setPresetVersion(this.$type, this.$version, this.$isSys);
        }
        LogUtil.Companion.d("预设数据同步 type=" + this.$type + " isDone=" + pair.getFirst() + " pageIdx=" + pair.getSecond().intValue(), BaseEventViewModel.TAG);
        return Unit.INSTANCE;
    }
}
