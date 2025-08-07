package com.microtech.aidexx.utils;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microtech/aidexx/utils/ContextUtil;", "", "()V", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ContextUtil.kt */
public final class ContextUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static Resources res;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/microtech/aidexx/utils/ContextUtil$Companion;", "", "()V", "res", "Landroid/content/res/Resources;", "getResources", "init", "", "context", "Landroid/content/Context;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ContextUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void init(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ContextUtil.res = resources;
        }

        public final Resources getResources() {
            Resources access$getRes$cp = ContextUtil.res;
            if (access$getRes$cp != null) {
                return access$getRes$cp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("res");
            return null;
        }
    }
}
