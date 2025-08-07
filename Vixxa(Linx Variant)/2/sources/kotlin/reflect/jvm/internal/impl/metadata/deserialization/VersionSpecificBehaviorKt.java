package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: versionSpecificBehavior.kt */
public final class VersionSpecificBehaviorKt {
    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, WiseOpenHianalyticsData.UNION_VERSION);
        return isKotlin1Dot4OrLater(binaryVersion);
    }

    public static final boolean isKotlin1Dot4OrLater(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, WiseOpenHianalyticsData.UNION_VERSION);
        return binaryVersion.getMajor() == 1 && binaryVersion.getMinor() >= 4;
    }
}
