package com.microtech.aidexx.data.resource;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/data/resource/LanguageResourceManager$getAidexApplicationResourceInspector$1", "Landroid/content/res/Resources;", "getString", "", "id", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LanguageResourceManager.kt */
public final class LanguageResourceManager$getAidexApplicationResourceInspector$1 extends Resources {
    final /* synthetic */ Resources $resources;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LanguageResourceManager$getAidexApplicationResourceInspector$1(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.$resources = resources;
    }

    public String getString(int i) {
        LanguageResourceManager languageResourceManager = LanguageResourceManager.INSTANCE;
        String resourceEntryName = this.$resources.getResourceEntryName(i);
        Intrinsics.checkNotNullExpressionValue(resourceEntryName, "getResourceEntryName(...)");
        String findStringValueByName = languageResourceManager.findStringValueByName(resourceEntryName);
        if (findStringValueByName != null) {
            return findStringValueByName;
        }
        String string = super.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
