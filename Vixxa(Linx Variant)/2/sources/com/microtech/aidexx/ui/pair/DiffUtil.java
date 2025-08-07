package com.microtech.aidexx.ui.pair;

import androidx.recyclerview.widget.DiffUtil;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/microtech/aidexx/ui/pair/DiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldData", "", "Lcom/microtechmd/blecomm/controller/BleControllerProxy;", "newData", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DiffUtil.kt */
public final class DiffUtil extends DiffUtil.Callback {
    private final List<BleControllerProxy> newData;
    private final List<BleControllerProxy> oldData;

    public DiffUtil(List<? extends BleControllerProxy> list, List<? extends BleControllerProxy> list2) {
        Intrinsics.checkNotNullParameter(list, "oldData");
        Intrinsics.checkNotNullParameter(list2, "newData");
        this.oldData = list;
        this.newData = list2;
    }

    public int getOldListSize() {
        return this.oldData.size();
    }

    public int getNewListSize() {
        return this.newData.size();
    }

    public boolean areItemsTheSame(int i, int i2) {
        return this.oldData.get(i).getMac().equals(this.newData.get(i2).getMac());
    }

    public boolean areContentsTheSame(int i, int i2) {
        return this.oldData.get(i).getName().equals(this.newData.get(i2).getName());
    }
}
