package com.microtech.aidexx.common;

import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExtendsKt$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ BigDecimal m(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }
}
