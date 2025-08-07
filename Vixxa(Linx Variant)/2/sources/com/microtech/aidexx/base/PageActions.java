package com.microtech.aidexx.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/base/PageActions;", "", "canLeave", "Lkotlin/Function0;", "", "Lcom/microtech/aidexx/base/AfterLeaveCallback;", "getPageName", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PageActions.kt */
public interface PageActions {
    Function0<Unit> canLeave();

    String getPageName();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PageActions.kt */
    public static final class DefaultImpls {
        public static String getPageName(PageActions pageActions) {
            return "";
        }
    }
}
