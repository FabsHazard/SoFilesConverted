package com.microtech.aidexx.data.resource;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "intArray", "", "index", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LanguageResourceManager.kt */
final class LanguageResourceManager$injectFactory2$1$onCreateView$3 extends Lambda implements Function2<int[], Integer, String> {
    final /* synthetic */ AttributeSet $attrs;
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.ObjectRef<View> $view;
    final /* synthetic */ LanguageResourceManager$injectFactory2$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LanguageResourceManager$injectFactory2$1$onCreateView$3(Context context, AttributeSet attributeSet, LanguageResourceManager$injectFactory2$1 languageResourceManager$injectFactory2$1, Ref.ObjectRef<View> objectRef) {
        super(2);
        this.$context = context;
        this.$attrs = attributeSet;
        this.this$0 = languageResourceManager$injectFactory2$1;
        this.$view = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((int[]) obj, ((Number) obj2).intValue());
    }

    public final String invoke(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "intArray");
        TypedArray obtainStyledAttributes = this.$context.obtainStyledAttributes(this.$attrs, iArr);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int resourceId = obtainStyledAttributes.getResourceId(i, 0);
        obtainStyledAttributes.recycle();
        if (resourceId == 0) {
            return null;
        }
        if (LanguageResourceManager.needToastWhenTouch) {
            LanguageResourceManager$injectFactory2$1 languageResourceManager$injectFactory2$1 = this.this$0;
            T t = this.$view.element;
            Intrinsics.checkNotNullExpressionValue(t, "element");
            languageResourceManager$injectFactory2$1.toastWhenTouch((View) t, resourceId);
        }
        LanguageResourceManager languageResourceManager = LanguageResourceManager.INSTANCE;
        String resourceEntryName = ((View) this.$view.element).getResources().getResourceEntryName(resourceId);
        Intrinsics.checkNotNullExpressionValue(resourceEntryName, "getResourceEntryName(...)");
        return languageResourceManager.findStringValueByName(resourceEntryName);
    }
}
