package com.microtech.aidexx.ui.main.event;

import android.content.Context;
import com.microtech.aidexx.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/MedicineSlot;", "Lcom/microtech/aidexx/ui/main/event/EventTimeSlotManager;", "()V", "beforeSleep", "", "getBeforeSleep", "()Ljava/lang/String;", "breakfast", "getBreakfast", "dinner", "getDinner", "lunch", "getLunch", "other", "getOther", "slots", "", "getSlots", "()Ljava/util/List;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventTimeSlotManager.kt */
public final class MedicineSlot extends EventTimeSlotManager {
    private final String beforeSleep;
    private final String breakfast;
    private final String dinner;
    private final String lunch;
    private final String other;
    private final List<String> slots = CollectionsKt.mutableListOf(getBreakfast(), getLunch(), getDinner(), getBeforeSleep(), getOther());

    public MedicineSlot() {
        super((Context) null, 1, (DefaultConstructorMarker) null);
        String string = getCtx().getResources().getString(R.string.event_medicine_slot_breakfirst);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.breakfast = string;
        String string2 = getCtx().getResources().getString(R.string.event_medicine_slot_launch);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.lunch = string2;
        String string3 = getCtx().getResources().getString(R.string.event_medicine_slot_dinner);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.dinner = string3;
        String string4 = getCtx().getResources().getString(R.string.event_medicine_slot_sleep);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.beforeSleep = string4;
        String string5 = getCtx().getResources().getString(R.string.event_medicine_slot_other);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.other = string5;
    }

    public String getBreakfast() {
        return this.breakfast;
    }

    public String getLunch() {
        return this.lunch;
    }

    public String getDinner() {
        return this.dinner;
    }

    public String getBeforeSleep() {
        return this.beforeSleep;
    }

    public String getOther() {
        return this.other;
    }

    public List<String> getSlots() {
        return this.slots;
    }
}
