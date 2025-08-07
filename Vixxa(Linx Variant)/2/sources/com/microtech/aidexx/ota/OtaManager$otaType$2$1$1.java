package com.microtech.aidexx.ota;

import com.microtech.aidexx.db.entity.OtaResourceEntity;
import com.microtech.aidexx.utils.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "o1", "Lcom/microtech/aidexx/db/entity/OtaResourceEntity;", "o2", "invoke", "(Lcom/microtech/aidexx/db/entity/OtaResourceEntity;Lcom/microtech/aidexx/db/entity/OtaResourceEntity;)Ljava/lang/Integer;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaManager.kt */
final class OtaManager$otaType$2$1$1 extends Lambda implements Function2<OtaResourceEntity, OtaResourceEntity, Integer> {
    public static final OtaManager$otaType$2$1$1 INSTANCE = new OtaManager$otaType$2$1$1();

    OtaManager$otaType$2$1$1() {
        super(2);
    }

    public final Integer invoke(OtaResourceEntity otaResourceEntity, OtaResourceEntity otaResourceEntity2) {
        StringUtils stringUtils = StringUtils.INSTANCE;
        String str = null;
        String version = otaResourceEntity2 != null ? otaResourceEntity2.getVersion() : null;
        if (otaResourceEntity != null) {
            str = otaResourceEntity.getVersion();
        }
        return Integer.valueOf(stringUtils.versionCompare(version, str) ? 1 : -1);
    }
}
