package com.microtech.aidexx.data.resource;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"com/microtech/aidexx/data/resource/LanguageResourceManager$injectFactory2$1", "Landroid/view/LayoutInflater$Factory2;", "onCreateView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "toastWhenTouch", "", "view", "resourceId", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LanguageResourceManager.kt */
public final class LanguageResourceManager$injectFactory2$1 implements LayoutInflater.Factory2 {
    LanguageResourceManager$injectFactory2$1() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.View r12, java.lang.String r13, android.content.Context r14, android.util.AttributeSet r15) {
        /*
            r11 = this;
            java.lang.String r0 = "factory2 view=null name="
            java.lang.String r1 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "attrs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r14)
            r2 = 0
            if (r12 != 0) goto L_0x0020
            boolean r3 = r14 instanceof androidx.appcompat.app.AppCompatActivity
            if (r3 == 0) goto L_0x0034
            r3 = r14
            androidx.appcompat.app.AppCompatActivity r3 = (androidx.appcompat.app.AppCompatActivity) r3
            goto L_0x0035
        L_0x0020:
            android.content.Context r3 = r12.getContext()
            boolean r3 = r3 instanceof androidx.appcompat.app.AppCompatActivity
            if (r3 == 0) goto L_0x0034
            android.content.Context r3 = r12.getContext()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)
            androidx.appcompat.app.AppCompatActivity r3 = (androidx.appcompat.app.AppCompatActivity) r3
            goto L_0x0035
        L_0x0034:
            r3 = r2
        L_0x0035:
            if (r3 != 0) goto L_0x0038
            return r2
        L_0x0038:
            androidx.appcompat.app.AppCompatDelegate r3 = r3.getDelegate()
            java.lang.String r4 = "getDelegate(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            android.view.View r12 = r3.createView(r12, r13, r14, r15)
            r4.element = r12
            T r12 = r4.element
            if (r12 != 0) goto L_0x00cc
            r5 = r13
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r9 = 6
            r10 = 0
            r6 = 46
            r7 = 0
            r8 = 0
            int r12 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r5, (char) r6, (int) r7, (boolean) r8, (int) r9, (java.lang.Object) r10)
            if (r12 <= 0) goto L_0x00cc
            r12 = 0
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            r5 = 25
            if (r3 > r5) goto L_0x0083
            java.lang.Class<android.view.LayoutInflater> r3 = android.view.LayoutInflater.class
            java.lang.String r5 = "mConstructorArgs"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r5)     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            r5 = 1
            r3.setAccessible(r5)     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            if (r3 == 0) goto L_0x0081
            r5 = r3[r12]     // Catch:{ Exception -> 0x007f }
            r3[r12] = r14     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            goto L_0x0085
        L_0x007f:
            r1 = move-exception
            goto L_0x009a
        L_0x0081:
            r5 = r2
            goto L_0x0085
        L_0x0083:
            r3 = r2
            r5 = r3
        L_0x0085:
            android.view.View r1 = r1.createView(r13, r2, r15)     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            r4.element = r1     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            if (r3 == 0) goto L_0x00cc
            r3[r12] = r5
            goto L_0x00cc
        L_0x0090:
            r13 = move-exception
            goto L_0x00c6
        L_0x0092:
            r1 = move-exception
            r2 = r5
            goto L_0x009a
        L_0x0095:
            r13 = move-exception
            r5 = r2
            goto L_0x00c7
        L_0x0098:
            r1 = move-exception
            r3 = r2
        L_0x009a:
            r1.printStackTrace()     // Catch:{ all -> 0x00c4 }
            com.microtech.aidexx.utils.LogUtil$Companion r5 = com.microtech.aidexx.utils.LogUtil.Companion     // Catch:{ all -> 0x00c4 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c4 }
            r6.<init>(r0)     // Catch:{ all -> 0x00c4 }
            java.lang.StringBuilder r13 = r6.append(r13)     // Catch:{ all -> 0x00c4 }
            java.lang.String r0 = " e="
            java.lang.StringBuilder r13 = r13.append(r0)     // Catch:{ all -> 0x00c4 }
            java.lang.String r0 = r1.getMessage()     // Catch:{ all -> 0x00c4 }
            java.lang.StringBuilder r13 = r13.append(r0)     // Catch:{ all -> 0x00c4 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00c4 }
            java.lang.String r0 = "LanguageResourceManager"
            r5.xLogE(r13, r0)     // Catch:{ all -> 0x00c4 }
            if (r3 == 0) goto L_0x00cc
            r3[r12] = r2
            goto L_0x00cc
        L_0x00c4:
            r13 = move-exception
            r5 = r2
        L_0x00c6:
            r2 = r3
        L_0x00c7:
            if (r2 == 0) goto L_0x00cb
            r2[r12] = r5
        L_0x00cb:
            throw r13
        L_0x00cc:
            com.microtech.aidexx.data.resource.LanguageResourceManager r12 = com.microtech.aidexx.data.resource.LanguageResourceManager.INSTANCE
            T r13 = r4.element
            android.view.View r13 = (android.view.View) r13
            com.microtech.aidexx.data.resource.LanguageResourceManager$injectFactory2$1$onCreateView$3 r0 = new com.microtech.aidexx.data.resource.LanguageResourceManager$injectFactory2$1$onCreateView$3
            r0.<init>(r14, r15, r11, r4)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            java.lang.Object unused = r12.fillTextToView(r13, r0)
            T r12 = r4.element
            android.view.View r12 = (android.view.View) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LanguageResourceManager$injectFactory2$1.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        LogUtil.Companion.xLogE("factory2 onCreateView2", "LanguageResourceManager");
        return null;
    }

    /* access modifiers changed from: private */
    public final void toastWhenTouch(View view, int i) {
        view.setOnTouchListener(new LanguageResourceManager$injectFactory2$1$$ExternalSyntheticLambda0(view.getResources().getResourceEntryName(i)));
    }

    /* access modifiers changed from: private */
    public static final boolean toastWhenTouch$lambda$2(String str, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        Intrinsics.checkNotNull(str);
        ExtendsKt.toastShort(str);
        return false;
    }
}
