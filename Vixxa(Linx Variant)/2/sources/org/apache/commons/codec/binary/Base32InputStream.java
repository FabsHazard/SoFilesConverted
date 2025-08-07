package org.apache.commons.codec.binary;

import java.io.InputStream;
import kotlin.io.encoding.Base64;
import org.apache.commons.codec.CodecPolicy;

public class Base32InputStream extends BaseNCodecInputStream {
    public Base32InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public Base32InputStream(InputStream inputStream, boolean z) {
        super(inputStream, new Base32(false), z);
    }

    public Base32InputStream(InputStream inputStream, boolean z, int i, byte[] bArr) {
        super(inputStream, new Base32(i, bArr), z);
    }

    public Base32InputStream(InputStream inputStream, boolean z, int i, byte[] bArr, CodecPolicy codecPolicy) {
        super(inputStream, new Base32(i, bArr, false, Base64.padSymbol, codecPolicy), z);
    }
}
