package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.CRC32;
import kotlin.UByte;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderReader;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.DataDescriptor;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.PasswordCallback;
import net.lingala.zip4j.util.Zip4jUtil;

public class ZipInputStream extends InputStream {
    private boolean canSkipExtendedLocalFileHeader;
    private CRC32 crc32;
    private DecompressedInputStream decompressedInputStream;
    private byte[] endOfEntryBuffer;
    private boolean entryEOFReached;
    private HeaderReader headerReader;
    private PushbackInputStream inputStream;
    private LocalFileHeader localFileHeader;
    private char[] password;
    private PasswordCallback passwordCallback;
    private boolean streamClosed;
    private Zip4jConfig zip4jConfig;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ZipInputStream(InputStream inputStream2) {
        this(inputStream2, (char[]) null, (Charset) null);
        char[] cArr = null;
        Charset charset = null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ZipInputStream(InputStream inputStream2, Charset charset) {
        this(inputStream2, (char[]) null, charset);
        char[] cArr = null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ZipInputStream(InputStream inputStream2, char[] cArr) {
        this(inputStream2, cArr, (Charset) null);
        Charset charset = null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ZipInputStream(InputStream inputStream2, PasswordCallback passwordCallback2) {
        this(inputStream2, passwordCallback2, (Charset) null);
        Charset charset = null;
    }

    public ZipInputStream(InputStream inputStream2, char[] cArr, Charset charset) {
        this(inputStream2, cArr, new Zip4jConfig(charset, 4096, true));
    }

    public ZipInputStream(InputStream inputStream2, PasswordCallback passwordCallback2, Charset charset) {
        this(inputStream2, passwordCallback2, new Zip4jConfig(charset, 4096, true));
    }

    public ZipInputStream(InputStream inputStream2, char[] cArr, Zip4jConfig zip4jConfig2) {
        this(inputStream2, cArr, (PasswordCallback) null, zip4jConfig2);
    }

    public ZipInputStream(InputStream inputStream2, PasswordCallback passwordCallback2, Zip4jConfig zip4jConfig2) {
        this(inputStream2, (char[]) null, passwordCallback2, zip4jConfig2);
    }

    private ZipInputStream(InputStream inputStream2, char[] cArr, PasswordCallback passwordCallback2, Zip4jConfig zip4jConfig2) {
        this.headerReader = new HeaderReader();
        this.crc32 = new CRC32();
        this.canSkipExtendedLocalFileHeader = false;
        this.streamClosed = false;
        this.entryEOFReached = false;
        if (zip4jConfig2.getBufferSize() >= 512) {
            this.inputStream = new PushbackInputStream(inputStream2, zip4jConfig2.getBufferSize());
            this.password = cArr;
            this.passwordCallback = passwordCallback2;
            this.zip4jConfig = zip4jConfig2;
            return;
        }
        throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
    }

    public LocalFileHeader getNextEntry() throws IOException {
        return getNextEntry((FileHeader) null, true);
    }

    public LocalFileHeader getNextEntry(FileHeader fileHeader, boolean z) throws IOException {
        PasswordCallback passwordCallback2;
        if (this.localFileHeader != null && z) {
            readUntilEndOfEntry();
        }
        LocalFileHeader readLocalFileHeader = this.headerReader.readLocalFileHeader(this.inputStream, this.zip4jConfig.getCharset());
        this.localFileHeader = readLocalFileHeader;
        if (readLocalFileHeader == null) {
            return null;
        }
        if (readLocalFileHeader.isEncrypted() && this.password == null && (passwordCallback2 = this.passwordCallback) != null) {
            setPassword(passwordCallback2.getPassword());
        }
        verifyLocalFileHeader(this.localFileHeader);
        this.crc32.reset();
        if (fileHeader != null) {
            this.localFileHeader.setCrc(fileHeader.getCrc());
            this.localFileHeader.setCompressedSize(fileHeader.getCompressedSize());
            this.localFileHeader.setUncompressedSize(fileHeader.getUncompressedSize());
            this.localFileHeader.setDirectory(fileHeader.isDirectory());
            this.canSkipExtendedLocalFileHeader = true;
        } else {
            this.canSkipExtendedLocalFileHeader = false;
        }
        this.decompressedInputStream = initializeEntryInputStream(this.localFileHeader);
        this.entryEOFReached = false;
        return this.localFileHeader;
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & UByte.MAX_VALUE;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.streamClosed) {
            throw new IOException("Stream closed");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Negative read length");
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.localFileHeader == null) {
                return -1;
            }
            try {
                int read = this.decompressedInputStream.read(bArr, i, i2);
                if (read == -1) {
                    endOfCompressedDataReached();
                } else {
                    this.crc32.update(bArr, i, read);
                }
                return read;
            } catch (IOException e) {
                if (isEncryptionMethodZipStandard(this.localFileHeader)) {
                    throw new ZipException(e.getMessage(), e.getCause(), ZipException.Type.WRONG_PASSWORD);
                }
                throw e;
            }
        }
    }

    public void close() throws IOException {
        if (!this.streamClosed) {
            DecompressedInputStream decompressedInputStream2 = this.decompressedInputStream;
            if (decompressedInputStream2 != null) {
                decompressedInputStream2.close();
            }
            this.streamClosed = true;
        }
    }

    public int available() throws IOException {
        assertStreamOpen();
        return this.entryEOFReached ^ true ? 1 : 0;
    }

    public void setPassword(char[] cArr) {
        this.password = cArr;
    }

    private void endOfCompressedDataReached() throws IOException {
        this.decompressedInputStream.endOfEntryReached(this.inputStream, this.decompressedInputStream.pushBackInputStreamIfNecessary(this.inputStream));
        readExtendedLocalFileHeaderIfPresent();
        verifyCrc();
        resetFields();
        this.entryEOFReached = true;
    }

    private DecompressedInputStream initializeEntryInputStream(LocalFileHeader localFileHeader2) throws IOException {
        return initializeDecompressorForThisEntry(initializeCipherInputStream(new ZipEntryInputStream(this.inputStream, getCompressedSize(localFileHeader2)), localFileHeader2), localFileHeader2);
    }

    private CipherInputStream<?> initializeCipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader2) throws IOException {
        if (!localFileHeader2.isEncrypted()) {
            return new NoCipherInputStream(zipEntryInputStream, localFileHeader2, this.password, this.zip4jConfig.getBufferSize());
        }
        if (localFileHeader2.getEncryptionMethod() == EncryptionMethod.AES) {
            return new AesCipherInputStream(zipEntryInputStream, localFileHeader2, this.password, this.zip4jConfig.getBufferSize(), this.zip4jConfig.isUseUtf8CharsetForPasswords());
        } else if (localFileHeader2.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD) {
            return new ZipStandardCipherInputStream(zipEntryInputStream, localFileHeader2, this.password, this.zip4jConfig.getBufferSize(), this.zip4jConfig.isUseUtf8CharsetForPasswords());
        } else {
            throw new ZipException(String.format("Entry [%s] Strong Encryption not supported", new Object[]{localFileHeader2.getFileName()}), ZipException.Type.UNSUPPORTED_ENCRYPTION);
        }
    }

    private DecompressedInputStream initializeDecompressorForThisEntry(CipherInputStream<?> cipherInputStream, LocalFileHeader localFileHeader2) throws ZipException {
        if (Zip4jUtil.getCompressionMethod(localFileHeader2) == CompressionMethod.DEFLATE) {
            return new InflaterInputStream(cipherInputStream, this.zip4jConfig.getBufferSize());
        }
        return new StoreInputStream(cipherInputStream);
    }

    private void readExtendedLocalFileHeaderIfPresent() throws IOException {
        if (this.localFileHeader.isDataDescriptorExists() && !this.canSkipExtendedLocalFileHeader) {
            DataDescriptor readDataDescriptor = this.headerReader.readDataDescriptor(this.inputStream, checkIfZip64ExtraDataRecordPresentInLFH(this.localFileHeader.getExtraDataRecords()));
            this.localFileHeader.setCompressedSize(readDataDescriptor.getCompressedSize());
            this.localFileHeader.setUncompressedSize(readDataDescriptor.getUncompressedSize());
            this.localFileHeader.setCrc(readDataDescriptor.getCrc());
        }
    }

    private void verifyLocalFileHeader(LocalFileHeader localFileHeader2) throws IOException {
        if (!isEntryDirectory(localFileHeader2.getFileName()) && localFileHeader2.getCompressionMethod() == CompressionMethod.STORE && localFileHeader2.getUncompressedSize() < 0) {
            throw new IOException("Invalid local file header for: " + localFileHeader2.getFileName() + ". Uncompressed size has to be set for entry of compression type store which is not a directory");
        }
    }

    private boolean checkIfZip64ExtraDataRecordPresentInLFH(List<ExtraDataRecord> list) {
        if (list == null) {
            return false;
        }
        for (ExtraDataRecord header : list) {
            if (header.getHeader() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                return true;
            }
        }
        return false;
    }

    private void verifyCrc() throws IOException {
        if ((this.localFileHeader.getEncryptionMethod() != EncryptionMethod.AES || !this.localFileHeader.getAesExtraDataRecord().getAesVersion().equals(AesVersion.TWO)) && this.localFileHeader.getCrc() != this.crc32.getValue()) {
            ZipException.Type type = ZipException.Type.CHECKSUM_MISMATCH;
            if (isEncryptionMethodZipStandard(this.localFileHeader)) {
                type = ZipException.Type.WRONG_PASSWORD;
            }
            throw new ZipException("Reached end of entry, but crc verification failed for " + this.localFileHeader.getFileName(), type);
        }
    }

    private void resetFields() {
        this.localFileHeader = null;
        this.crc32.reset();
    }

    private boolean isEntryDirectory(String str) {
        return str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) || str.endsWith("\\");
    }

    private long getCompressedSize(LocalFileHeader localFileHeader2) throws ZipException {
        if (Zip4jUtil.getCompressionMethod(localFileHeader2).equals(CompressionMethod.STORE)) {
            return localFileHeader2.getUncompressedSize();
        }
        if (!localFileHeader2.isDataDescriptorExists() || this.canSkipExtendedLocalFileHeader) {
            return localFileHeader2.getCompressedSize() - ((long) getEncryptionHeaderSize(localFileHeader2));
        }
        return -1;
    }

    private int getEncryptionHeaderSize(LocalFileHeader localFileHeader2) throws ZipException {
        if (!localFileHeader2.isEncrypted()) {
            return 0;
        }
        if (localFileHeader2.getEncryptionMethod().equals(EncryptionMethod.AES)) {
            return getAesEncryptionHeaderSize(localFileHeader2.getAesExtraDataRecord());
        }
        if (localFileHeader2.getEncryptionMethod().equals(EncryptionMethod.ZIP_STANDARD)) {
            return 12;
        }
        return 0;
    }

    private void readUntilEndOfEntry() throws IOException {
        if (this.endOfEntryBuffer == null) {
            this.endOfEntryBuffer = new byte[512];
        }
        do {
        } while (read(this.endOfEntryBuffer) != -1);
        this.entryEOFReached = true;
    }

    private int getAesEncryptionHeaderSize(AESExtraDataRecord aESExtraDataRecord) throws ZipException {
        if (aESExtraDataRecord != null && aESExtraDataRecord.getAesKeyStrength() != null) {
            return aESExtraDataRecord.getAesKeyStrength().getSaltLength() + 12;
        }
        throw new ZipException("AesExtraDataRecord not found or invalid for Aes encrypted entry");
    }

    private boolean isEncryptionMethodZipStandard(LocalFileHeader localFileHeader2) {
        return localFileHeader2.isEncrypted() && EncryptionMethod.ZIP_STANDARD.equals(localFileHeader2.getEncryptionMethod());
    }

    private void assertStreamOpen() throws IOException {
        if (this.streamClosed) {
            throw new IOException("Stream closed");
        }
    }
}
