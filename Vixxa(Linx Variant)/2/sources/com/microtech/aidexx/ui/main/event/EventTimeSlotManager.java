package com.microtech.aidexx.ui.main.event;

import android.content.Context;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.microtech.aidexx.common.ExtendsKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u001e\u001a\u00020\u00062\b\b\u0001\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016J\u0018\u0010#\u001a\u00020\u00062\b\b\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%J\u0012\u0010&\u001a\u00020 2\b\b\u0001\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010'\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060)2\b\b\u0001\u0010\u001f\u001a\u00020 H\u0016J\u001c\u0010*\u001a\u00020\u00062\b\b\u0001\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010+\u001a\u00020,H\u0002J\u001c\u0010-\u001a\u00020 2\b\b\u0001\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010+\u001a\u00020,H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/EventTimeSlotManager;", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "beforeSleep", "", "getBeforeSleep", "()Ljava/lang/String;", "breakfast", "getBreakfast", "getCtx", "()Landroid/content/Context;", "dietTimeSlot", "dinner", "getDinner", "extraMeal", "getExtraMeal", "insulinTimeSlot", "lunch", "getLunch", "makeup", "getMakeup", "medicineTimeSlot", "other", "getOther", "slots", "", "getSlots", "()Ljava/util/List;", "getEventSlot", "type", "", "getEventSlotByIndex", "index", "getEventSlotByTime", "time", "Ljava/util/Date;", "getEventSlotIndex", "getTimeSlotByType", "getTypes", "", "slotForCondition", "isIn2024", "", "slotIndexForCondition", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventTimeSlotManager.kt */
public class EventTimeSlotManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String beforeSleep;
    private final String breakfast;
    private final Context ctx;
    private EventTimeSlotManager dietTimeSlot;
    private final String dinner;
    private final String extraMeal;
    private EventTimeSlotManager insulinTimeSlot;
    private final String lunch;
    private final String makeup;
    private EventTimeSlotManager medicineTimeSlot;
    private final String other;
    private final List<String> slots;

    public EventTimeSlotManager() {
        this((Context) null, 1, (DefaultConstructorMarker) null);
    }

    public EventTimeSlotManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        this.ctx = context;
        this.breakfast = "";
        this.lunch = "";
        this.dinner = "";
        this.beforeSleep = "";
        this.makeup = "";
        this.extraMeal = "";
        this.other = "";
        this.slots = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EventTimeSlotManager(Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ExtendsKt.getContext() : context);
    }

    public final Context getCtx() {
        return this.ctx;
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

    public String getMakeup() {
        return this.makeup;
    }

    public String getExtraMeal() {
        return this.extraMeal;
    }

    public String getOther() {
        return this.other;
    }

    public List<String> getSlots() {
        return this.slots;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/EventTimeSlotManager$Companion;", "", "()V", "instance", "Lcom/microtech/aidexx/ui/main/event/EventTimeSlotManager;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EventTimeSlotManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EventTimeSlotManager instance() {
            return new EventTimeSlotManager((Context) null, 1, (DefaultConstructorMarker) null);
        }
    }

    public List<String> getTypes(int i) {
        return getTimeSlotByType(i).getSlots();
    }

    private final EventTimeSlotManager getTimeSlotByType(int i) {
        EventTimeSlotManager eventTimeSlotManager;
        if (i == 1) {
            if (this.dietTimeSlot == null) {
                this.dietTimeSlot = new DietSlot();
            }
            eventTimeSlotManager = this.dietTimeSlot;
            if (eventTimeSlotManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dietTimeSlot");
                return null;
            }
        } else if (i != 2) {
            if (this.insulinTimeSlot == null) {
                this.insulinTimeSlot = new InsulinSlot();
            }
            eventTimeSlotManager = this.insulinTimeSlot;
            if (eventTimeSlotManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("insulinTimeSlot");
                return null;
            }
        } else {
            if (this.medicineTimeSlot == null) {
                this.medicineTimeSlot = new MedicineSlot();
            }
            eventTimeSlotManager = this.medicineTimeSlot;
            if (eventTimeSlotManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("medicineTimeSlot");
                return null;
            }
        }
        return eventTimeSlotManager;
    }

    public String getEventSlot(int i) {
        Calendar instance = Calendar.getInstance();
        EventTimeSlotManager timeSlotByType = getTimeSlotByType(i);
        int i2 = instance.get(11);
        if (6 <= i2 && i2 < 10) {
            return timeSlotByType.getSlots().get(0);
        }
        if (10 <= i2 && i2 < 14) {
            return timeSlotByType.getSlots().get(1);
        }
        if (16 <= i2 && i2 < 20) {
            return timeSlotByType.getSlots().get(2);
        }
        if (20 > i2 || i2 >= 24) {
            return slotForCondition$default(this, i, false, 2, (Object) null);
        }
        return slotForCondition(i, true);
    }

    public final String getEventSlotByTime(int i, Date date) {
        Intrinsics.checkNotNullParameter(date, CrashHianalyticsData.TIME);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i2 = instance.get(11);
        if (6 <= i2 && i2 < 10) {
            return getSlots().get(0);
        }
        if (10 <= i2 && i2 < 14) {
            return getSlots().get(1);
        }
        if (16 <= i2 && i2 < 20) {
            return getSlots().get(2);
        }
        if (20 > i2 || i2 >= 24) {
            return slotForCondition$default(this, i, false, 2, (Object) null);
        }
        return slotForCondition(i, true);
    }

    static /* synthetic */ String slotForCondition$default(EventTimeSlotManager eventTimeSlotManager, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return eventTimeSlotManager.slotForCondition(i, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slotForCondition");
    }

    private final String slotForCondition(int i, boolean z) {
        EventTimeSlotManager timeSlotByType = getTimeSlotByType(i);
        if (i == 1) {
            return timeSlotByType.getExtraMeal();
        }
        if (i == 2) {
            return z ? timeSlotByType.getBeforeSleep() : timeSlotByType.getOther();
        }
        if (i != 3) {
            return timeSlotByType.getSlots().get(0);
        }
        return z ? timeSlotByType.getBeforeSleep() : timeSlotByType.getMakeup();
    }

    public String getEventSlotByIndex(int i, int i2) {
        List<String> types = getTypes(i);
        if (i2 < 0 || i2 >= types.size()) {
            return "";
        }
        return types.get(i2);
    }

    public int getEventSlotIndex(int i) {
        Calendar instance = Calendar.getInstance();
        EventTimeSlotManager timeSlotByType = getTimeSlotByType(i);
        int i2 = instance.get(11);
        if (6 <= i2 && i2 < 10) {
            return timeSlotByType.getSlots().indexOf(timeSlotByType.getBreakfast());
        }
        if (10 <= i2 && i2 < 14) {
            return timeSlotByType.getSlots().indexOf(timeSlotByType.getLunch());
        }
        if (16 <= i2 && i2 < 20) {
            return timeSlotByType.getSlots().indexOf(timeSlotByType.getDinner());
        }
        if (20 > i2 || i2 >= 24) {
            return slotIndexForCondition$default(this, i, false, 2, (Object) null);
        }
        return slotIndexForCondition(i, true);
    }

    static /* synthetic */ int slotIndexForCondition$default(EventTimeSlotManager eventTimeSlotManager, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return eventTimeSlotManager.slotIndexForCondition(i, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slotIndexForCondition");
    }

    private final int slotIndexForCondition(int i, boolean z) {
        int i2;
        EventTimeSlotManager timeSlotByType = getTimeSlotByType(i);
        List<String> slots2 = timeSlotByType.getSlots();
        int size = getSlots().size();
        if (i == 1) {
            i2 = slots2.indexOf(timeSlotByType.getExtraMeal());
        } else if (i != 2) {
            if (i != 3) {
                i2 = 0;
            } else if (z) {
                i2 = slots2.indexOf(timeSlotByType.getBeforeSleep());
            } else {
                i2 = slots2.indexOf(timeSlotByType.getMakeup());
            }
        } else if (z) {
            i2 = slots2.indexOf(timeSlotByType.getBeforeSleep());
        } else {
            i2 = slots2.indexOf(timeSlotByType.getOther());
        }
        return size + i2;
    }
}
