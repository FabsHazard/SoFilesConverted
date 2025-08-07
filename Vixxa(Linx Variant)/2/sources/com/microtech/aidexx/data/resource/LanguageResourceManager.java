package com.microtech.aidexx.data.resource;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.entity.LanguageConfEntity;
import com.microtech.aidexx.db.entity.LanguageEntity;
import com.microtech.aidexx.db.repository.LanguageDbRepository;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.SettingItemWidget;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013H\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nJ\u0016\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nJ\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0!H\u0002J\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0!H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0011\u0010#\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u000eJ\u0006\u0010)\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020\u000eJ\u0011\u0010+\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0006\u0010,\u001a\u00020\u000eJ\u0019\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u0004J\u0010\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\u0004H\u0002J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u000206R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lcom/microtech/aidexx/data/resource/LanguageResourceManager;", "", "()V", "DEFAULT_EN", "", "DEFAULT_ZH", "TAG", "actResourcesMap", "", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/content/res/Resources;", "applicationResource", "mLanguageStrMap", "needToastWhenTouch", "", "fillTextToView", "view", "Landroid/view/View;", "block", "Lkotlin/Function2;", "", "", "findStringValueByName", "stringName", "getAidexApplicationResourceInspector", "resources", "getAidexResourceInspector", "activity", "getCurLanguageConfEntity", "Lcom/microtech/aidexx/db/entity/LanguageConfEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurLanguageTag", "getDefaultSupportLanguages", "", "getSupportLanguages", "initLanguageTag", "", "injectFactory2", "layoutInflater", "Landroid/view/LayoutInflater;", "isAlabo", "isLocalNumber", "isRTL", "loadLanguageInfo", "needLoad", "onLanguageChanged", "languageConf", "(Lcom/microtech/aidexx/db/entity/LanguageConfEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAppLocale", "languageTag", "updateLanguage", "language", "verifySpecialResources", "item", "Lcom/microtech/aidexx/db/entity/LanguageEntity;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LanguageResourceManager.kt */
public final class LanguageResourceManager {
    private static final String DEFAULT_EN = "en";
    private static final String DEFAULT_ZH = "zh-Hans-CN";
    public static final LanguageResourceManager INSTANCE = new LanguageResourceManager();
    private static final String TAG = "LanguageResourceManager";
    /* access modifiers changed from: private */
    public static final Map<AppCompatActivity, Resources> actResourcesMap = new LinkedHashMap();
    private static Resources applicationResource;
    private static final Map<String, String> mLanguageStrMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public static final boolean needToastWhenTouch = false;

    public final void verifySpecialResources(LanguageEntity languageEntity) {
        Intrinsics.checkNotNullParameter(languageEntity, "item");
    }

    private LanguageResourceManager() {
    }

    public final boolean needLoad() {
        return mLanguageStrMap.isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onLanguageChanged(com.microtech.aidexx.db.entity.LanguageConfEntity r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.data.resource.LanguageResourceManager$onLanguageChanged$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.data.resource.LanguageResourceManager$onLanguageChanged$1 r0 = (com.microtech.aidexx.data.resource.LanguageResourceManager$onLanguageChanged$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.resource.LanguageResourceManager$onLanguageChanged$1 r0 = new com.microtech.aidexx.data.resource.LanguageResourceManager$onLanguageChanged$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004f
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r5 = r5.getCode()
            if (r5 == 0) goto L_0x0059
            com.microtech.aidexx.data.resource.LanguageResourceManager r6 = INSTANCE
            r6.updateLanguage(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.loadLanguageInfo(r0)
            if (r6 != r1) goto L_0x004f
            return r1
        L_0x004f:
            com.microtech.aidexx.data.resource.EventUnitManager r6 = com.microtech.aidexx.data.resource.EventUnitManager.INSTANCE
            r6.onLanguageChanged(r5)
            com.microtech.aidexx.data.resource.LanguageResourceManager r6 = INSTANCE
            r6.setAppLocale(r5)
        L_0x0059:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LanguageResourceManager.onLanguageChanged(com.microtech.aidexx.db.entity.LanguageConfEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadLanguageInfo(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.microtech.aidexx.data.resource.LanguageResourceManager$loadLanguageInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.microtech.aidexx.data.resource.LanguageResourceManager$loadLanguageInfo$1 r0 = (com.microtech.aidexx.data.resource.LanguageResourceManager$loadLanguageInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.resource.LanguageResourceManager$loadLanguageInfo$1 r0 = new com.microtech.aidexx.data.resource.LanguageResourceManager$loadLanguageInfo$1
            r0.<init>(r8, r9)
        L_0x0019:
            r5 = r0
            java.lang.Object r9 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r0 = r5.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0055
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = r8.getCurLanguageTag()
            com.microtech.aidexx.db.repository.LanguageDbRepository r1 = new com.microtech.aidexx.db.repository.LanguageDbRepository
            r1.<init>()
            r5.L$0 = r9
            r5.label = r2
            r3 = 0
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r9
            java.lang.Object r1 = com.microtech.aidexx.db.repository.LanguageDbRepository.query$default(r1, r2, r3, r4, r5, r6, r7)
            if (r1 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r0 = r9
            r9 = r1
        L_0x0055:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x00a2
            java.util.Map<java.lang.String, java.lang.String> r1 = mLanguageStrMap
            r1.clear()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r2)
            int r2 = kotlin.collections.MapsKt.mapCapacity(r2)
            r3 = 16
            int r2 = kotlin.ranges.RangesKt.coerceAtLeast((int) r2, (int) r3)
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>(r2)
            java.util.Map r3 = (java.util.Map) r3
            java.util.Iterator r9 = r9.iterator()
        L_0x007b:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x009f
            java.lang.Object r2 = r9.next()
            com.microtech.aidexx.db.entity.LanguageEntity r2 = (com.microtech.aidexx.db.entity.LanguageEntity) r2
            java.lang.String r4 = r2.getKey()
            java.lang.String r2 = r2.getValue()
            kotlin.Pair r2 = kotlin.TuplesKt.to(r4, r2)
            java.lang.Object r4 = r2.getFirst()
            java.lang.Object r2 = r2.getSecond()
            r3.put(r4, r2)
            goto L_0x007b
        L_0x009f:
            r1.putAll(r3)
        L_0x00a2:
            com.microtech.aidexx.utils.LogUtil$Companion r9 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "curLanguage="
            r1.<init>(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = " mLanguageStrMap.size="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.util.Map<java.lang.String, java.lang.String> r1 = mLanguageStrMap
            int r1 = r1.size()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "LanguageResourceManager"
            r9.xLogE(r0, r1)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LanguageResourceManager.loadLanguageInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSupportLanguages(kotlin.coroutines.Continuation<? super java.util.List<com.microtech.aidexx.db.entity.LanguageConfEntity>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.microtech.aidexx.data.resource.LanguageResourceManager$getSupportLanguages$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.microtech.aidexx.data.resource.LanguageResourceManager$getSupportLanguages$1 r0 = (com.microtech.aidexx.data.resource.LanguageResourceManager$getSupportLanguages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.resource.LanguageResourceManager$getSupportLanguages$1 r0 = new com.microtech.aidexx.data.resource.LanguageResourceManager$getSupportLanguages$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.microtech.aidexx.data.resource.LanguageResourceManager r0 = (com.microtech.aidexx.data.resource.LanguageResourceManager) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004a
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            com.microtech.aidexx.db.repository.LanguageDbRepository r5 = new com.microtech.aidexx.db.repository.LanguageDbRepository
            r5.<init>()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.querySupportLanguages(r0)
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r4
        L_0x004a:
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x005b
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x0057
            r5 = 0
        L_0x0057:
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x005f
        L_0x005b:
            java.util.List r5 = r0.getDefaultSupportLanguages()
        L_0x005f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LanguageResourceManager.getSupportLanguages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x016d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initLanguageTag(kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            r21 = this;
            r0 = r22
            boolean r1 = r0 instanceof com.microtech.aidexx.data.resource.LanguageResourceManager$initLanguageTag$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.microtech.aidexx.data.resource.LanguageResourceManager$initLanguageTag$1 r1 = (com.microtech.aidexx.data.resource.LanguageResourceManager$initLanguageTag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r21
            goto L_0x001f
        L_0x0018:
            com.microtech.aidexx.data.resource.LanguageResourceManager$initLanguageTag$1 r1 = new com.microtech.aidexx.data.resource.LanguageResourceManager$initLanguageTag$1
            r2 = r21
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 45
            java.lang.String r6 = "LanguageResourceManager"
            r7 = 1
            if (r4 == 0) goto L_0x0051
            if (r4 != r7) goto L_0x0049
            java.lang.Object r3 = r1.L$4
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r1.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r1.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r1.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r1 = r1.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0126
        L_0x0049:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r0)
            com.microtech.aidexx.utils.mmkv.MmkvManager r0 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r0 = r0.getCurrentLanguageTag()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0218
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r4 = r0.getLanguage()
            java.lang.String r9 = r0.getScript()
            java.lang.String r8 = r0.getCountry()
            com.microtech.aidexx.utils.LogUtil$Companion r10 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "languageTag="
            r11.<init>(r12)
            java.lang.String r12 = r0.toLanguageTag()
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.xLogI(r11, r6)
            com.microtech.aidexx.utils.LogUtil$Companion r10 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "l="
            r11.<init>(r12)
            java.lang.StringBuilder r11 = r11.append(r4)
            java.lang.String r12 = " script="
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.StringBuilder r11 = r11.append(r9)
            java.lang.String r12 = " region="
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.StringBuilder r11 = r11.append(r8)
            java.lang.String r11 = r11.toString()
            r10.xLogI(r11, r6)
            com.microtech.aidexx.utils.LogUtil$Companion r10 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "dl="
            r11.<init>(r12)
            java.lang.String r12 = r0.getDisplayLanguage()
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = " ds="
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = r0.getDisplayScript()
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = " dr="
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r0 = r0.getDisplayCountry()
            java.lang.StringBuilder r0 = r11.append(r0)
            java.lang.String r0 = r0.toString()
            r10.xLogI(r0, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            com.microtech.aidexx.data.resource.LanguageResourceManager r11 = INSTANCE
            r1.L$0 = r4
            r1.L$1 = r9
            r1.L$2 = r8
            r1.L$3 = r0
            r1.L$4 = r10
            r1.label = r7
            java.lang.Object r1 = r11.getSupportLanguages(r1)
            if (r1 != r3) goto L_0x011f
            return r3
        L_0x011f:
            r3 = r10
            r20 = r4
            r4 = r0
            r0 = r1
            r1 = r20
        L_0x0126:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x012e:
            boolean r10 = r0.hasNext()
            r11 = 0
            r12 = 2
            r13 = 0
            if (r10 == 0) goto L_0x016d
            java.lang.Object r10 = r0.next()
            r14 = r10
            com.microtech.aidexx.db.entity.LanguageConfEntity r14 = (com.microtech.aidexx.db.entity.LanguageConfEntity) r14
            java.lang.String r14 = r14.getCode()
            if (r14 == 0) goto L_0x0169
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.StringBuilder r15 = r15.append(r1)
            java.lang.StringBuilder r15 = r15.append(r5)
            java.lang.String r15 = r15.toString()
            boolean r15 = kotlin.text.StringsKt.startsWith$default(r14, r15, r13, r12, r11)
            if (r15 != 0) goto L_0x0161
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r1)
            if (r15 == 0) goto L_0x0164
        L_0x0161:
            r3.add(r14)
        L_0x0164:
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r14)
            goto L_0x016a
        L_0x0169:
            r14 = r13
        L_0x016a:
            if (r14 == 0) goto L_0x012e
            goto L_0x016e
        L_0x016d:
            r10 = r11
        L_0x016e:
            com.microtech.aidexx.db.entity.LanguageConfEntity r10 = (com.microtech.aidexx.db.entity.LanguageConfEntity) r10
            if (r10 == 0) goto L_0x0179
            com.microtech.aidexx.data.resource.LanguageResourceManager r0 = INSTANCE
            r0.updateLanguage(r4)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
        L_0x0179:
            if (r11 != 0) goto L_0x0218
            int r0 = r3.size()
            if (r0 != r7) goto L_0x0189
            java.lang.Object r0 = r3.get(r13)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x01ff
        L_0x0189:
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x0193
            java.lang.String r0 = "en"
            goto L_0x01ff
        L_0x0193:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r0 = r3.iterator()
            java.lang.String r1 = ""
            r3 = r1
            r4 = r13
        L_0x019d:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x01fe
            java.lang.Object r5 = r0.next()
            java.lang.String r5 = (java.lang.String) r5
            r14 = r5
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String[] r15 = new java.lang.String[r7]
            java.lang.String r10 = "-"
            r15[r13] = r10
            r18 = 6
            r19 = 0
            r16 = 0
            r17 = 0
            java.util.List r10 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r14, (java.lang.String[]) r15, (boolean) r16, (int) r17, (int) r18, (java.lang.Object) r19)
            int r11 = r10.size()
            if (r12 > r11) goto L_0x01c9
            r14 = 4
            if (r11 >= r14) goto L_0x01c9
            r11 = r7
            goto L_0x01ca
        L_0x01c9:
            r11 = r13
        L_0x01ca:
            if (r11 == 0) goto L_0x01f8
            int r11 = r10.size()
            if (r11 != r12) goto L_0x01da
            java.lang.Object r10 = r10.get(r7)
            java.lang.String r10 = (java.lang.String) r10
            r11 = r1
            goto L_0x01e6
        L_0x01da:
            java.lang.Object r11 = r10.get(r7)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r10 = r10.get(r12)
            java.lang.String r10 = (java.lang.String) r10
        L_0x01e6:
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x01ee
            r11 = r12
            goto L_0x01ef
        L_0x01ee:
            r11 = r7
        L_0x01ef:
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x01f9
            int r11 = r11 + 1
            goto L_0x01f9
        L_0x01f8:
            r11 = r7
        L_0x01f9:
            if (r11 <= r4) goto L_0x019d
            r3 = r5
            r4 = r11
            goto L_0x019d
        L_0x01fe:
            r0 = r3
        L_0x01ff:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "第一次进入app语言="
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            r1.xLogI(r3, r6)
            com.microtech.aidexx.data.resource.LanguageResourceManager r1 = INSTANCE
            r1.updateLanguage(r0)
        L_0x0218:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LanguageResourceManager.initLanguageTag(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getCurLanguageTag() {
        return MmkvManager.INSTANCE.getCurrentLanguageTag();
    }

    public final boolean isRTL() {
        return Intrinsics.areEqual((Object) MmkvManager.INSTANCE.getCurrentLanguageTag(), (Object) "ar");
    }

    public final boolean isAlabo() {
        return Intrinsics.areEqual((Object) MmkvManager.INSTANCE.getCurrentLanguageTag(), (Object) "ar");
    }

    public final boolean isLocalNumber() {
        return ArraysKt.contains((T[]) new String[]{"ar", "my"}, MmkvManager.INSTANCE.getCurrentLanguageTag());
    }

    public final Object getCurLanguageConfEntity(Continuation<? super LanguageConfEntity> continuation) {
        return new LanguageDbRepository().queryConfById(getCurLanguageTag(), continuation);
    }

    private final void updateLanguage(String str) {
        SettingsManager.INSTANCE.setLanguage(str);
        MmkvManager.INSTANCE.setCurrentLanguageTag(str);
    }

    public final void setAppLocale(String str) {
        Intrinsics.checkNotNullParameter(str, "languageTag");
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Resources resources = ExtendsKt.getContext().getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    private final List<LanguageConfEntity> getDefaultSupportLanguages() {
        return CollectionsKt.mutableListOf(new LanguageConfEntity((Long) null, "简体中文", (String) null, DEFAULT_ZH, (String) null, 21, (DefaultConstructorMarker) null), new LanguageConfEntity((Long) null, "English", (String) null, DEFAULT_EN, (String) null, 21, (DefaultConstructorMarker) null));
    }

    public final String findStringValueByName(String str) {
        Intrinsics.checkNotNullParameter(str, "stringName");
        String str2 = mLanguageStrMap.get(str);
        if (str2 != null) {
            return StringsKt.replace$default(str2, "\\n", "\n", false, 4, (Object) null);
        }
        return null;
    }

    public final Resources getAidexResourceInspector(AppCompatActivity appCompatActivity, Resources resources) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        if (appCompatActivity.isDestroyed()) {
            return resources;
        }
        Map<AppCompatActivity, Resources> map = actResourcesMap;
        Resources resources2 = map.get(appCompatActivity);
        if (resources2 != null) {
            return resources2;
        }
        LanguageResourceManager languageResourceManager = this;
        LanguageResourceManager$getAidexResourceInspector$1$target$1 languageResourceManager$getAidexResourceInspector$1$target$1 = new LanguageResourceManager$getAidexResourceInspector$1$target$1(resources, resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        map.put(appCompatActivity, languageResourceManager$getAidexResourceInspector$1$target$1);
        appCompatActivity.getLifecycle().addObserver(new LanguageResourceManager$getAidexResourceInspector$1$1(appCompatActivity));
        return languageResourceManager$getAidexResourceInspector$1$target$1;
    }

    public final Resources getAidexApplicationResourceInspector(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        if (applicationResource == null) {
            applicationResource = new LanguageResourceManager$getAidexApplicationResourceInspector$1(resources, resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        }
        Resources resources2 = applicationResource;
        Intrinsics.checkNotNull(resources2);
        return resources2;
    }

    /* access modifiers changed from: private */
    public final Object fillTextToView(View view, Function2<? super int[], ? super Integer, String> function2) {
        if (view instanceof EditText) {
            String invoke = function2.invoke(new int[]{16843088}, 0);
            if (invoke == null) {
                return null;
            }
            ((EditText) view).setHint(invoke);
            return Unit.INSTANCE;
        } else if (view instanceof TextView) {
            String invoke2 = function2.invoke(new int[]{16843087}, 0);
            if (invoke2 == null) {
                return null;
            }
            ((TextView) view).setText(invoke2);
            return Unit.INSTANCE;
        } else if (view instanceof SettingItemWidget) {
            int[] iArr = R.styleable.SettingItemWidget;
            Intrinsics.checkNotNullExpressionValue(iArr, "SettingItemWidget");
            String invoke3 = function2.invoke(iArr, Integer.valueOf(R.styleable.SettingItemWidget_title));
            if (invoke3 == null) {
                return null;
            }
            ((SettingItemWidget) view).setTitle(invoke3);
            return Unit.INSTANCE;
        } else if (!(view instanceof ActionBarWidget)) {
            return null;
        } else {
            int[] iArr2 = R.styleable.ActionBarWidget;
            Intrinsics.checkNotNullExpressionValue(iArr2, "ActionBarWidget");
            String invoke4 = function2.invoke(iArr2, Integer.valueOf(R.styleable.ActionBarWidget_titleText));
            if (invoke4 == null) {
                return null;
            }
            ((ActionBarWidget) view).setTitle(invoke4);
            return Unit.INSTANCE;
        }
    }

    public final void injectFactory2(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        LayoutInflaterCompat.setFactory2(layoutInflater, new LanguageResourceManager$injectFactory2$1());
    }
}
