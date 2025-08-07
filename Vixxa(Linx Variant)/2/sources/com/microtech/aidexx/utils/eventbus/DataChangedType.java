package com.microtech.aidexx.utils.eventbus;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/utils/eventbus/DataChangedType;", "", "(Ljava/lang/String;I)V", "ADD", "DELETE", "UPDATE", "DATA_STATE_ADD", "DATA_STATE_DELETE", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventBusEntity.kt */
public enum DataChangedType {
    ADD,
    DELETE,
    UPDATE,
    DATA_STATE_ADD,
    DATA_STATE_DELETE;

    public static EnumEntries<DataChangedType> getEntries() {
        return $ENTRIES;
    }

    static {
        DataChangedType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
