package com.microtech.aidexx.db.entity.event;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/EventActions;", "", "getEventDesc", "", "splitter", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventActions.kt */
public interface EventActions {
    String getEventDesc(String str);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EventActions.kt */
    public static final class DefaultImpls {
        public static String getEventDesc(EventActions eventActions, String str) {
            return "";
        }

        public static /* synthetic */ String getEventDesc$default(EventActions eventActions, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return eventActions.getEventDesc(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEventDesc");
        }
    }
}
