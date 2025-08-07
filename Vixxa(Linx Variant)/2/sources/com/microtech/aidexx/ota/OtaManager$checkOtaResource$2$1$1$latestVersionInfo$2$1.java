package com.microtech.aidexx.ota;

import com.microtech.aidexx.db.entity.OtaResourceEntity;
import com.microtech.aidexx.utils.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "o1", "Lcom/microtech/aidexx/db/entity/OtaResourceEntity;", "kotlin.jvm.PlatformType", "o2", "invoke", "(Lcom/microtech/aidexx/db/entity/OtaResourceEntity;Lcom/microtech/aidexx/db/entity/OtaResourceEntity;)Ljava/lang/Integer;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaManager.kt */
final class OtaManager$checkOtaResource$2$1$1$latestVersionInfo$2$1 extends Lambda implements Function2<OtaResourceEntity, OtaResourceEntity, Integer> {
    public static final OtaManager$checkOtaResource$2$1$1$latestVersionInfo$2$1 INSTANCE = new OtaManager$checkOtaResource$2$1$1$latestVersionInfo$2$1();

    OtaManager$checkOtaResource$2$1$1$latestVersionInfo$2$1() {
        super(2);
    }

    public final Integer invoke(OtaResourceEntity otaResourceEntity, OtaResourceEntity otaResourceEntity2) {
        return Integer.valueOf(StringUtils.INSTANCE.versionCompare(otaResourceEntity2.getVersion(), otaResourceEntity.getVersion()) ? 1 : -1);
    }
}
