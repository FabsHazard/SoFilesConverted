package org.greenrobot.essentials.hash;

import java.math.BigInteger;
import java.util.zip.Checksum;

public interface Checksum128 extends Checksum {
    BigInteger getValueBigInteger();

    byte[] getValueBytesBigEndian();

    byte[] getValueBytesLittleEndian();

    String getValueHexString();

    long getValueHigh();
}
