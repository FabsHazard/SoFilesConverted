package com.microtech.aidexx.data.resource;

import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.entity.event.UnitEntity;
import com.microtech.aidexx.utils.LogUtils;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\b\u0010!\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020\u0017J\u000e\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020\tJ\b\u0010)\u001a\u00020%H\u0002J\u0010\u0010*\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020\u0017J\u0016\u0010+\u001a\u00020%2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/microtech/aidexx/data/resource/EventUnitManager;", "", "()V", "EVENT_TYPE_DIET", "", "EVENT_TYPE_EXERCISE", "EVENT_TYPE_INSULIN", "EVENT_TYPE_MEDICINE", "GET_UNIT_DATA", "", "TAG", "kotlin.jvm.PlatformType", "UNIT_CONFIG_FILE_NAME", "UPDATE_INTERVAL", "isUpdating", "", "mUnitMap", "", "", "Lcom/microtech/aidexx/data/resource/SpecificationModel;", "updateExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "updateScope", "Lkotlinx/coroutines/CoroutineScope;", "canStartTask", "getDietUnit", "unit", "getDietUnitList", "getInsulinUnit", "getMedicationUnit", "getMedicationUnitList", "getTimeUnit", "getTimeUnitList", "isLoadedCurrentApkVer", "loadFromAssets", "Lcom/microtech/aidexx/db/entity/event/UnitConfig;", "loadUnit", "", "lang", "coroutineScope", "onLanguageChanged", "stopUpdate", "update", "updateMemo", "list", "", "Lcom/microtech/aidexx/db/entity/event/UnitEntity;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventUnitManager.kt */
public final class EventUnitManager {
    private static final int EVENT_TYPE_DIET = 1;
    private static final int EVENT_TYPE_EXERCISE = 3;
    private static final int EVENT_TYPE_INSULIN = 4;
    private static final int EVENT_TYPE_MEDICINE = 2;
    private static final String GET_UNIT_DATA = "/eventBizUnitMultiLangMap";
    public static final EventUnitManager INSTANCE = new EventUnitManager();
    /* access modifiers changed from: private */
    public static final String TAG = "EventUnitManager";
    private static final String UNIT_CONFIG_FILE_NAME = "unit.json";
    private static final int UPDATE_INTERVAL = 86400000;
    private static boolean isUpdating;
    private static final Map<Integer, List<SpecificationModel>> mUnitMap = new LinkedHashMap();
    private static final CoroutineExceptionHandler updateExceptionHandler = new EventUnitManager$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    private static final CoroutineScope updateScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));

    private EventUnitManager() {
    }

    public static /* synthetic */ void update$default(EventUnitManager eventUnitManager, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineScope = updateScope;
        }
        eventUnitManager.update(coroutineScope);
    }

    public final synchronized void update(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        if (canStartTask()) {
            isUpdating = true;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, updateExceptionHandler, (CoroutineStart) null, new EventUnitManager$update$1((Continuation<? super EventUnitManager$update$1>) null), 2, (Object) null);
        }
    }

    public final void onLanguageChanged(String str) {
        Intrinsics.checkNotNullParameter(str, "lang");
        loadUnit$default(this, str, (CoroutineScope) null, 2, (Object) null);
    }

    public static /* synthetic */ void loadUnit$default(EventUnitManager eventUnitManager, String str, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineScope = updateScope;
        }
        eventUnitManager.loadUnit(str, coroutineScope);
    }

    public final void loadUnit(String str, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(str, "lang");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EventUnitManager$loadUnit$1(str, (Continuation<? super EventUnitManager$loadUnit$1>) null), 3, (Object) null);
    }

    private final boolean canStartTask() {
        if (isUpdating) {
            LogUtils.Companion companion = LogUtils.Companion;
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            companion.debug(str, "正在升级...");
            return false;
        } else if (System.currentTimeMillis() - MmkvManager.INSTANCE.getUnitLatestUpdateTime() >= ((long) UPDATE_INTERVAL)) {
            return true;
        } else {
            LogUtils.Companion companion2 = LogUtils.Companion;
            String str2 = TAG;
            Intrinsics.checkNotNullExpressionValue(str2, "TAG");
            companion2.debug(str2, "不在升级时间区间");
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void stopUpdate() {
        isUpdating = false;
    }

    private final boolean isLoadedCurrentApkVer() {
        return MmkvManager.INSTANCE.getUnitLoadedApkVersion() >= 1710;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.microtech.aidexx.db.entity.event.UnitConfig loadFromAssets() {
        /*
            r3 = this;
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.AssetManager r0 = r0.getAssets()
            java.lang.String r1 = "unit.json"
            java.io.InputStream r0 = r0.open(r1)
            java.lang.String r1 = "open(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            r2.<init>(r0, r1)
            java.io.Reader r2 = (java.io.Reader) r2
            boolean r0 = r2 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0027
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2
            goto L_0x002f
        L_0x0027:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r2, r1)
            r2 = r0
        L_0x002f:
            java.io.Closeable r2 = (java.io.Closeable) r2
            r0 = r2
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0     // Catch:{ all -> 0x0051 }
            java.io.Reader r0 = (java.io.Reader) r0     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0051 }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r1)
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Class<com.microtech.aidexx.db.entity.event.UnitConfig> r2 = com.microtech.aidexx.db.entity.event.UnitConfig.class
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, r2)
            java.lang.String r1 = "fromJson(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.microtech.aidexx.db.entity.event.UnitConfig r0 = (com.microtech.aidexx.db.entity.event.UnitConfig) r0
            return r0
        L_0x0051:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.EventUnitManager.loadFromAssets():com.microtech.aidexx.db.entity.event.UnitConfig");
    }

    /* access modifiers changed from: private */
    public final void updateMemo(List<UnitEntity> list) {
        Map linkedHashMap = new LinkedHashMap();
        for (UnitEntity unitEntity : list) {
            SpecificationModel specificationModel = new SpecificationModel(unitEntity.getName(), unitEntity.getRatio(), unitEntity.isDefault() == 1, unitEntity.getValue(), false, 16, (DefaultConstructorMarker) null);
            if (linkedHashMap.containsKey(Integer.valueOf(unitEntity.getEventType()))) {
                linkedHashMap.get(Integer.valueOf(unitEntity.getEventType()));
                List list2 = (List) linkedHashMap.get(Integer.valueOf(unitEntity.getEventType()));
                if (list2 != null) {
                    list2.add(specificationModel);
                }
            } else {
                linkedHashMap.put(Integer.valueOf(unitEntity.getEventType()), CollectionsKt.mutableListOf(specificationModel));
            }
        }
        if (!linkedHashMap.isEmpty()) {
            Map<Integer, List<SpecificationModel>> map = mUnitMap;
            map.clear();
            map.putAll(linkedHashMap);
        }
    }

    public final List<SpecificationModel> getDietUnitList() {
        List<SpecificationModel> list = mUnitMap.get(1);
        if (list != null) {
            return list;
        }
        String string = ExtendsKt.getContext().getString(R.string.default_unit_g);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = ExtendsKt.getContext().getString(R.string.default_unit_kg);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = ExtendsKt.getContext().getString(R.string.default_unit_ml);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = ExtendsKt.getContext().getString(R.string.default_unit_l);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return CollectionsKt.arrayListOf(new SpecificationModel(string, 1.0d, true, 0, false, 16, (DefaultConstructorMarker) null), new SpecificationModel(string2, 1000.0d, false, 1, false, 16, (DefaultConstructorMarker) null), new SpecificationModel(string3, 1.0d, false, 2, false, 16, (DefaultConstructorMarker) null), new SpecificationModel(string4, 1000.0d, false, 3, false, 16, (DefaultConstructorMarker) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r4 = r1.getSpecification();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getDietUnit(int r4) {
        /*
            r3 = this;
            java.util.List r0 = r3.getDietUnitList()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.microtech.aidexx.data.resource.SpecificationModel r2 = (com.microtech.aidexx.data.resource.SpecificationModel) r2
            r2.isDefault()
            int r2 = r2.getCode()
            if (r4 != r2) goto L_0x000a
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            com.microtech.aidexx.data.resource.SpecificationModel r1 = (com.microtech.aidexx.data.resource.SpecificationModel) r1
            if (r1 == 0) goto L_0x002d
            java.lang.String r4 = r1.getSpecification()
            if (r4 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            java.lang.String r4 = ""
        L_0x002f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.EventUnitManager.getDietUnit(int):java.lang.String");
    }

    public final List<SpecificationModel> getMedicationUnitList() {
        List<SpecificationModel> list = mUnitMap.get(2);
        if (list != null) {
            return list;
        }
        String string = ExtendsKt.getContext().getString(R.string.default_unit_mg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = ExtendsKt.getContext().getString(R.string.default_unit_g);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = ExtendsKt.getContext().getString(R.string.default_unit_piece);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = ExtendsKt.getContext().getString(R.string.default_unit_capsule);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return CollectionsKt.arrayListOf(new SpecificationModel(string, 1.0d, true, 0, false, 16, (DefaultConstructorMarker) null), new SpecificationModel(string2, 1000.0d, false, 1, false, 16, (DefaultConstructorMarker) null), new SpecificationModel(string3, 1.0d, false, 2, false, 16, (DefaultConstructorMarker) null), new SpecificationModel(string4, 1.0d, false, 3, false, 16, (DefaultConstructorMarker) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r4 = r1.getSpecification();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getMedicationUnit(int r4) {
        /*
            r3 = this;
            java.util.List r0 = r3.getMedicationUnitList()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.microtech.aidexx.data.resource.SpecificationModel r2 = (com.microtech.aidexx.data.resource.SpecificationModel) r2
            r2.isDefault()
            int r2 = r2.getCode()
            if (r4 != r2) goto L_0x000a
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            com.microtech.aidexx.data.resource.SpecificationModel r1 = (com.microtech.aidexx.data.resource.SpecificationModel) r1
            if (r1 == 0) goto L_0x002d
            java.lang.String r4 = r1.getSpecification()
            if (r4 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            java.lang.String r4 = ""
        L_0x002f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.EventUnitManager.getMedicationUnit(int):java.lang.String");
    }

    public final List<SpecificationModel> getTimeUnitList() {
        List<SpecificationModel> list = mUnitMap.get(3);
        if (list != null) {
            return list;
        }
        String string = ExtendsKt.getContext().getString(R.string.default_unit_minute);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = ExtendsKt.getContext().getString(R.string.default_unit_hour);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return CollectionsKt.arrayListOf(new SpecificationModel(string, 1.0d, true, 0, false, 16, (DefaultConstructorMarker) null), new SpecificationModel(string2, 60.0d, false, 1, false, 16, (DefaultConstructorMarker) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r4 = r1.getSpecification();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getTimeUnit(int r4) {
        /*
            r3 = this;
            java.util.List r0 = r3.getTimeUnitList()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.microtech.aidexx.data.resource.SpecificationModel r2 = (com.microtech.aidexx.data.resource.SpecificationModel) r2
            r2.isDefault()
            int r2 = r2.getCode()
            if (r4 != r2) goto L_0x000a
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            com.microtech.aidexx.data.resource.SpecificationModel r1 = (com.microtech.aidexx.data.resource.SpecificationModel) r1
            if (r1 == 0) goto L_0x002d
            java.lang.String r4 = r1.getSpecification()
            if (r4 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            java.lang.String r4 = ""
        L_0x002f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.EventUnitManager.getTimeUnit(int):java.lang.String");
    }

    public final List<SpecificationModel> getInsulinUnit() {
        List<SpecificationModel> list = mUnitMap.get(4);
        if (list != null) {
            return list;
        }
        return CollectionsKt.arrayListOf(new SpecificationModel("U", 1.0d, true, 0, false, 16, (DefaultConstructorMarker) null));
    }
}
