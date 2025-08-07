package net.lingala.zip4j.headers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.outputstream.CountingOutputStream;
import net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;
import okhttp3.internal.ws.WebSocketProtocol;

public class HeaderWriter {
    private static final short AES_EXTRA_DATA_RECORD_SIZE = 11;
    private static final short ZIP64_EXTRA_DATA_RECORD_SIZE_FH = 28;
    private static final short ZIP64_EXTRA_DATA_RECORD_SIZE_LFH = 16;
    private final byte[] intBuff = new byte[4];
    private final byte[] longBuff = new byte[8];
    private final RawIO rawIO = new RawIO();

    /* JADX WARNING: Removed duplicated region for block: B:10:0x006e A[Catch:{ all -> 0x0164, all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0086 A[Catch:{ all -> 0x0164, all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00b5 A[Catch:{ all -> 0x0164, all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c5 A[Catch:{ all -> 0x0164, all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c8 A[Catch:{ all -> 0x0164, all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cf A[Catch:{ all -> 0x0164, all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d9 A[Catch:{ all -> 0x0164, all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00de A[Catch:{ all -> 0x0164, all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0109 A[Catch:{ all -> 0x0164, all -> 0x0169 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeLocalFileHeader(net.lingala.zip4j.model.ZipModel r11, net.lingala.zip4j.model.LocalFileHeader r12, java.io.OutputStream r13, java.nio.charset.Charset r14) throws java.io.IOException {
        /*
            r10 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            net.lingala.zip4j.util.RawIO r1 = r10.rawIO     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.headers.HeaderSignature r2 = r12.getSignature()     // Catch:{ all -> 0x0164 }
            long r2 = r2.getValue()     // Catch:{ all -> 0x0164 }
            int r2 = (int) r2     // Catch:{ all -> 0x0164 }
            r1.writeIntLittleEndian(r0, r2)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r1 = r10.rawIO     // Catch:{ all -> 0x0164 }
            int r2 = r12.getVersionNeededToExtract()     // Catch:{ all -> 0x0164 }
            r1.writeShortLittleEndian(r0, r2)     // Catch:{ all -> 0x0164 }
            byte[] r1 = r12.getGeneralPurposeFlag()     // Catch:{ all -> 0x0164 }
            r0.write(r1)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r1 = r10.rawIO     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.model.enums.CompressionMethod r2 = r12.getCompressionMethod()     // Catch:{ all -> 0x0164 }
            int r2 = r2.getCode()     // Catch:{ all -> 0x0164 }
            r1.writeShortLittleEndian(r0, r2)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r1 = r10.rawIO     // Catch:{ all -> 0x0164 }
            byte[] r2 = r10.longBuff     // Catch:{ all -> 0x0164 }
            long r3 = r12.getLastModifiedTime()     // Catch:{ all -> 0x0164 }
            r5 = 0
            r1.writeLongLittleEndian(r2, r5, r3)     // Catch:{ all -> 0x0164 }
            byte[] r1 = r10.longBuff     // Catch:{ all -> 0x0164 }
            r2 = 4
            r0.write(r1, r5, r2)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r1 = r10.rawIO     // Catch:{ all -> 0x0164 }
            byte[] r3 = r10.longBuff     // Catch:{ all -> 0x0164 }
            long r6 = r12.getCrc()     // Catch:{ all -> 0x0164 }
            r1.writeLongLittleEndian(r3, r5, r6)     // Catch:{ all -> 0x0164 }
            byte[] r1 = r10.longBuff     // Catch:{ all -> 0x0164 }
            r0.write(r1, r5, r2)     // Catch:{ all -> 0x0164 }
            long r3 = r12.getCompressedSize()     // Catch:{ all -> 0x0164 }
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            r3 = 1
            if (r1 >= 0) goto L_0x006b
            long r8 = r12.getUncompressedSize()     // Catch:{ all -> 0x0164 }
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r1 = r5
            goto L_0x006c
        L_0x006b:
            r1 = r3
        L_0x006c:
            if (r1 == 0) goto L_0x0086
            net.lingala.zip4j.util.RawIO r4 = r10.rawIO     // Catch:{ all -> 0x0164 }
            byte[] r8 = r10.longBuff     // Catch:{ all -> 0x0164 }
            r4.writeLongLittleEndian(r8, r5, r6)     // Catch:{ all -> 0x0164 }
            byte[] r4 = r10.longBuff     // Catch:{ all -> 0x0164 }
            r0.write(r4, r5, r2)     // Catch:{ all -> 0x0164 }
            byte[] r4 = r10.longBuff     // Catch:{ all -> 0x0164 }
            r0.write(r4, r5, r2)     // Catch:{ all -> 0x0164 }
            r11.setZip64Format(r3)     // Catch:{ all -> 0x0164 }
            r12.setWriteCompressedSizeInZip64ExtraRecord(r3)     // Catch:{ all -> 0x0164 }
            goto L_0x00a9
        L_0x0086:
            net.lingala.zip4j.util.RawIO r11 = r10.rawIO     // Catch:{ all -> 0x0164 }
            byte[] r4 = r10.longBuff     // Catch:{ all -> 0x0164 }
            long r6 = r12.getCompressedSize()     // Catch:{ all -> 0x0164 }
            r11.writeLongLittleEndian(r4, r5, r6)     // Catch:{ all -> 0x0164 }
            byte[] r11 = r10.longBuff     // Catch:{ all -> 0x0164 }
            r0.write(r11, r5, r2)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r11 = r10.rawIO     // Catch:{ all -> 0x0164 }
            byte[] r4 = r10.longBuff     // Catch:{ all -> 0x0164 }
            long r6 = r12.getUncompressedSize()     // Catch:{ all -> 0x0164 }
            r11.writeLongLittleEndian(r4, r5, r6)     // Catch:{ all -> 0x0164 }
            byte[] r11 = r10.longBuff     // Catch:{ all -> 0x0164 }
            r0.write(r11, r5, r2)     // Catch:{ all -> 0x0164 }
            r12.setWriteCompressedSizeInZip64ExtraRecord(r5)     // Catch:{ all -> 0x0164 }
        L_0x00a9:
            byte[] r11 = new byte[r5]     // Catch:{ all -> 0x0164 }
            java.lang.String r2 = r12.getFileName()     // Catch:{ all -> 0x0164 }
            boolean r2 = net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(r2)     // Catch:{ all -> 0x0164 }
            if (r2 == 0) goto L_0x00bd
            java.lang.String r11 = r12.getFileName()     // Catch:{ all -> 0x0164 }
            byte[] r11 = net.lingala.zip4j.headers.HeaderUtil.getBytesFromString(r11, r14)     // Catch:{ all -> 0x0164 }
        L_0x00bd:
            net.lingala.zip4j.util.RawIO r2 = r10.rawIO     // Catch:{ all -> 0x0164 }
            int r4 = r11.length     // Catch:{ all -> 0x0164 }
            r2.writeShortLittleEndian(r0, r4)     // Catch:{ all -> 0x0164 }
            if (r1 == 0) goto L_0x00c8
            r2 = 20
            goto L_0x00c9
        L_0x00c8:
            r2 = r5
        L_0x00c9:
            net.lingala.zip4j.model.AESExtraDataRecord r4 = r12.getAesExtraDataRecord()     // Catch:{ all -> 0x0164 }
            if (r4 == 0) goto L_0x00d1
            int r2 = r2 + 11
        L_0x00d1:
            net.lingala.zip4j.util.RawIO r4 = r10.rawIO     // Catch:{ all -> 0x0164 }
            r4.writeShortLittleEndian(r0, r2)     // Catch:{ all -> 0x0164 }
            int r2 = r11.length     // Catch:{ all -> 0x0164 }
            if (r2 <= 0) goto L_0x00dc
            r0.write(r11)     // Catch:{ all -> 0x0164 }
        L_0x00dc:
            if (r1 == 0) goto L_0x0103
            net.lingala.zip4j.util.RawIO r11 = r10.rawIO     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.headers.HeaderSignature r1 = net.lingala.zip4j.headers.HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE     // Catch:{ all -> 0x0164 }
            long r1 = r1.getValue()     // Catch:{ all -> 0x0164 }
            int r1 = (int) r1     // Catch:{ all -> 0x0164 }
            r11.writeShortLittleEndian(r0, r1)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r11 = r10.rawIO     // Catch:{ all -> 0x0164 }
            r1 = 16
            r11.writeShortLittleEndian(r0, r1)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r11 = r10.rawIO     // Catch:{ all -> 0x0164 }
            long r1 = r12.getUncompressedSize()     // Catch:{ all -> 0x0164 }
            r11.writeLongLittleEndian(r0, r1)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r11 = r10.rawIO     // Catch:{ all -> 0x0164 }
            long r1 = r12.getCompressedSize()     // Catch:{ all -> 0x0164 }
            r11.writeLongLittleEndian(r0, r1)     // Catch:{ all -> 0x0164 }
        L_0x0103:
            net.lingala.zip4j.model.AESExtraDataRecord r11 = r12.getAesExtraDataRecord()     // Catch:{ all -> 0x0164 }
            if (r11 == 0) goto L_0x0159
            net.lingala.zip4j.model.AESExtraDataRecord r11 = r12.getAesExtraDataRecord()     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r12 = r10.rawIO     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.headers.HeaderSignature r1 = r11.getSignature()     // Catch:{ all -> 0x0164 }
            long r1 = r1.getValue()     // Catch:{ all -> 0x0164 }
            int r1 = (int) r1     // Catch:{ all -> 0x0164 }
            r12.writeShortLittleEndian(r0, r1)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r12 = r10.rawIO     // Catch:{ all -> 0x0164 }
            int r1 = r11.getDataSize()     // Catch:{ all -> 0x0164 }
            r12.writeShortLittleEndian(r0, r1)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r12 = r10.rawIO     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.model.enums.AesVersion r1 = r11.getAesVersion()     // Catch:{ all -> 0x0164 }
            int r1 = r1.getVersionNumber()     // Catch:{ all -> 0x0164 }
            r12.writeShortLittleEndian(r0, r1)     // Catch:{ all -> 0x0164 }
            java.lang.String r12 = r11.getVendorID()     // Catch:{ all -> 0x0164 }
            byte[] r12 = net.lingala.zip4j.headers.HeaderUtil.getBytesFromString(r12, r14)     // Catch:{ all -> 0x0164 }
            r0.write(r12)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.model.enums.AesKeyStrength r12 = r11.getAesKeyStrength()     // Catch:{ all -> 0x0164 }
            int r12 = r12.getRawCode()     // Catch:{ all -> 0x0164 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x0164 }
            byte[] r14 = new byte[r3]     // Catch:{ all -> 0x0164 }
            r14[r5] = r12     // Catch:{ all -> 0x0164 }
            r0.write(r14)     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.util.RawIO r12 = r10.rawIO     // Catch:{ all -> 0x0164 }
            net.lingala.zip4j.model.enums.CompressionMethod r11 = r11.getCompressionMethod()     // Catch:{ all -> 0x0164 }
            int r11 = r11.getCode()     // Catch:{ all -> 0x0164 }
            r12.writeShortLittleEndian(r0, r11)     // Catch:{ all -> 0x0164 }
        L_0x0159:
            byte[] r11 = r0.toByteArray()     // Catch:{ all -> 0x0164 }
            r13.write(r11)     // Catch:{ all -> 0x0164 }
            r0.close()
            return
        L_0x0164:
            r11 = move-exception
            r0.close()     // Catch:{ all -> 0x0169 }
            goto L_0x016d
        L_0x0169:
            r12 = move-exception
            r11.addSuppressed(r12)
        L_0x016d:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.headers.HeaderWriter.writeLocalFileHeader(net.lingala.zip4j.model.ZipModel, net.lingala.zip4j.model.LocalFileHeader, java.io.OutputStream, java.nio.charset.Charset):void");
    }

    public void writeExtendedLocalHeader(LocalFileHeader localFileHeader, OutputStream outputStream) throws IOException {
        if (localFileHeader == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot write extended local header");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.rawIO.writeIntLittleEndian(byteArrayOutputStream, (int) HeaderSignature.EXTRA_DATA_RECORD.getValue());
            this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getCrc());
            byteArrayOutputStream.write(this.longBuff, 0, 4);
            if (localFileHeader.isWriteCompressedSizeInZip64ExtraRecord()) {
                this.rawIO.writeLongLittleEndian(byteArrayOutputStream, localFileHeader.getCompressedSize());
                this.rawIO.writeLongLittleEndian(byteArrayOutputStream, localFileHeader.getUncompressedSize());
            } else {
                this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getCompressedSize());
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getUncompressedSize());
                byteArrayOutputStream.write(this.longBuff, 0, 4);
            }
            outputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void finalizeZipFile(ZipModel zipModel, OutputStream outputStream, Charset charset) throws IOException {
        if (zipModel == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            processHeaderData(zipModel, outputStream);
            long offsetOfCentralDirectory = getOffsetOfCentralDirectory(zipModel);
            writeCentralDirectory(zipModel, byteArrayOutputStream, this.rawIO, charset);
            int size = byteArrayOutputStream.size();
            if (zipModel.isZip64Format() || offsetOfCentralDirectory >= InternalZipConstants.ZIP_64_SIZE_LIMIT || zipModel.getCentralDirectory().getFileHeaders().size() >= 65535) {
                if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                    zipModel.setZip64EndOfCentralDirectoryRecord(new Zip64EndOfCentralDirectoryRecord());
                }
                if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                    zipModel.setZip64EndOfCentralDirectoryLocator(new Zip64EndOfCentralDirectoryLocator());
                }
                zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(((long) size) + offsetOfCentralDirectory);
                if (isSplitZipFile(outputStream)) {
                    int currentSplitFileCounter = getCurrentSplitFileCounter(outputStream);
                    zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(currentSplitFileCounter);
                    zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(currentSplitFileCounter + 1);
                } else {
                    zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(0);
                    zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(1);
                }
                Zip64EndOfCentralDirectoryRecord buildZip64EndOfCentralDirectoryRecord = buildZip64EndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory);
                zipModel.setZip64EndOfCentralDirectoryRecord(buildZip64EndOfCentralDirectoryRecord);
                writeZip64EndOfCentralDirectoryRecord(buildZip64EndOfCentralDirectoryRecord, byteArrayOutputStream, this.rawIO);
                writeZip64EndOfCentralDirectoryLocator(zipModel.getZip64EndOfCentralDirectoryLocator(), byteArrayOutputStream, this.rawIO);
            }
            writeEndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory, byteArrayOutputStream, this.rawIO, charset);
            writeZipHeaderBytes(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
            byteArrayOutputStream.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void finalizeZipFileWithoutValidations(ZipModel zipModel, OutputStream outputStream, Charset charset) throws IOException {
        if (zipModel == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot finalize zip file without validations");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            long offsetOfCentralDirectory = getOffsetOfCentralDirectory(zipModel);
            writeCentralDirectory(zipModel, byteArrayOutputStream, this.rawIO, charset);
            int size = byteArrayOutputStream.size();
            if (zipModel.isZip64Format() || offsetOfCentralDirectory >= InternalZipConstants.ZIP_64_SIZE_LIMIT || zipModel.getCentralDirectory().getFileHeaders().size() >= 65535) {
                if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                    zipModel.setZip64EndOfCentralDirectoryRecord(new Zip64EndOfCentralDirectoryRecord());
                }
                if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                    zipModel.setZip64EndOfCentralDirectoryLocator(new Zip64EndOfCentralDirectoryLocator());
                }
                zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(((long) size) + offsetOfCentralDirectory);
                Zip64EndOfCentralDirectoryRecord buildZip64EndOfCentralDirectoryRecord = buildZip64EndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory);
                zipModel.setZip64EndOfCentralDirectoryRecord(buildZip64EndOfCentralDirectoryRecord);
                writeZip64EndOfCentralDirectoryRecord(buildZip64EndOfCentralDirectoryRecord, byteArrayOutputStream, this.rawIO);
                writeZip64EndOfCentralDirectoryLocator(zipModel.getZip64EndOfCentralDirectoryLocator(), byteArrayOutputStream, this.rawIO);
            }
            writeEndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory, byteArrayOutputStream, this.rawIO, charset);
            writeZipHeaderBytes(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
            byteArrayOutputStream.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void updateLocalFileHeader(FileHeader fileHeader, ZipModel zipModel, SplitOutputStream splitOutputStream) throws IOException {
        boolean z;
        SplitOutputStream splitOutputStream2;
        String str;
        String str2;
        if (fileHeader == null || zipModel == null) {
            throw new ZipException("invalid input parameters, cannot update local file header");
        }
        if (fileHeader.getDiskNumberStart() != splitOutputStream.getCurrentSplitFileCounter()) {
            String parent = zipModel.getZipFile().getParent();
            String zipFileNameWithoutExtension = FileUtils.getZipFileNameWithoutExtension(zipModel.getZipFile().getName());
            if (parent != null) {
                str = parent + System.getProperty("file.separator");
            } else {
                str = "";
            }
            z = true;
            if (fileHeader.getDiskNumberStart() < 9) {
                str2 = str + zipFileNameWithoutExtension + ".z0" + (fileHeader.getDiskNumberStart() + 1);
            } else {
                str2 = str + zipFileNameWithoutExtension + ".z" + (fileHeader.getDiskNumberStart() + 1);
            }
            splitOutputStream2 = new SplitOutputStream(new File(str2));
        } else {
            splitOutputStream2 = splitOutputStream;
            z = false;
        }
        long filePointer = splitOutputStream2.getFilePointer();
        splitOutputStream2.seek(fileHeader.getOffsetLocalHeader() + 14);
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCrc());
        splitOutputStream2.write(this.longBuff, 0, 4);
        updateFileSizesInLocalFileHeader(splitOutputStream2, fileHeader);
        if (z) {
            splitOutputStream2.close();
        } else {
            splitOutputStream.seek(filePointer);
        }
    }

    private void updateFileSizesInLocalFileHeader(SplitOutputStream splitOutputStream, FileHeader fileHeader) throws IOException {
        if (fileHeader.getUncompressedSize() >= InternalZipConstants.ZIP_64_SIZE_LIMIT) {
            this.rawIO.writeLongLittleEndian(this.longBuff, 0, InternalZipConstants.ZIP_64_SIZE_LIMIT);
            splitOutputStream.write(this.longBuff, 0, 4);
            splitOutputStream.write(this.longBuff, 0, 4);
            int fileNameLength = fileHeader.getFileNameLength() + 8;
            if (splitOutputStream.skipBytes(fileNameLength) == fileNameLength) {
                this.rawIO.writeLongLittleEndian(splitOutputStream, fileHeader.getUncompressedSize());
                this.rawIO.writeLongLittleEndian(splitOutputStream, fileHeader.getCompressedSize());
                return;
            }
            throw new ZipException("Unable to skip " + fileNameLength + " bytes to update LFH");
        }
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCompressedSize());
        splitOutputStream.write(this.longBuff, 0, 4);
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getUncompressedSize());
        splitOutputStream.write(this.longBuff, 0, 4);
    }

    private boolean isSplitZipFile(OutputStream outputStream) {
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).isSplitZipFile();
        }
        if (outputStream instanceof CountingOutputStream) {
            return ((CountingOutputStream) outputStream).isSplitZipFile();
        }
        return false;
    }

    private int getCurrentSplitFileCounter(OutputStream outputStream) {
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).getCurrentSplitFileCounter();
        }
        return ((CountingOutputStream) outputStream).getCurrentSplitFileCounter();
    }

    private void writeZipHeaderBytes(ZipModel zipModel, OutputStream outputStream, byte[] bArr, Charset charset) throws IOException {
        if (bArr == null) {
            throw new ZipException("invalid buff to write as zip headers");
        } else if (!(outputStream instanceof CountingOutputStream) || !((CountingOutputStream) outputStream).checkBuffSizeAndStartNextSplitFile(bArr.length)) {
            outputStream.write(bArr);
        } else {
            finalizeZipFile(zipModel, outputStream, charset);
        }
    }

    private void processHeaderData(ZipModel zipModel, OutputStream outputStream) throws IOException {
        int i;
        if (outputStream instanceof OutputStreamWithSplitZipSupport) {
            OutputStreamWithSplitZipSupport outputStreamWithSplitZipSupport = (OutputStreamWithSplitZipSupport) outputStream;
            zipModel.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(outputStreamWithSplitZipSupport.getFilePointer());
            i = outputStreamWithSplitZipSupport.getCurrentSplitFileCounter();
        } else {
            i = 0;
        }
        if (zipModel.isZip64Format()) {
            if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                zipModel.setZip64EndOfCentralDirectoryRecord(new Zip64EndOfCentralDirectoryRecord());
            }
            if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                zipModel.setZip64EndOfCentralDirectoryLocator(new Zip64EndOfCentralDirectoryLocator());
            }
            zipModel.getZip64EndOfCentralDirectoryRecord().setOffsetStartCentralDirectoryWRTStartDiskNumber(zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory());
            zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(i);
            zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(i + 1);
        }
        zipModel.getEndOfCentralDirectoryRecord().setNumberOfThisDisk(i);
        zipModel.getEndOfCentralDirectoryRecord().setNumberOfThisDiskStartOfCentralDir(i);
    }

    private void writeCentralDirectory(ZipModel zipModel, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO2, Charset charset) throws ZipException {
        if (zipModel.getCentralDirectory() != null && zipModel.getCentralDirectory().getFileHeaders() != null && zipModel.getCentralDirectory().getFileHeaders().size() > 0) {
            for (FileHeader writeFileHeader : zipModel.getCentralDirectory().getFileHeaders()) {
                writeFileHeader(zipModel, writeFileHeader, byteArrayOutputStream, rawIO2, charset);
            }
        }
    }

    private void writeFileHeader(ZipModel zipModel, FileHeader fileHeader, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO2, Charset charset) throws ZipException {
        byte[] bArr;
        ZipModel zipModel2 = zipModel;
        FileHeader fileHeader2 = fileHeader;
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        RawIO rawIO3 = rawIO2;
        Charset charset2 = charset;
        if (fileHeader2 != null) {
            try {
                byte[] bArr2 = {0, 0};
                boolean isZip64Entry = isZip64Entry(fileHeader2);
                rawIO3.writeIntLittleEndian(byteArrayOutputStream2, (int) fileHeader.getSignature().getValue());
                rawIO3.writeShortLittleEndian(byteArrayOutputStream2, fileHeader.getVersionMadeBy());
                rawIO3.writeShortLittleEndian(byteArrayOutputStream2, fileHeader.getVersionNeededToExtract());
                byteArrayOutputStream2.write(fileHeader.getGeneralPurposeFlag());
                rawIO3.writeShortLittleEndian(byteArrayOutputStream2, fileHeader.getCompressionMethod().getCode());
                rawIO3.writeLongLittleEndian(this.longBuff, 0, fileHeader.getLastModifiedTime());
                byteArrayOutputStream2.write(this.longBuff, 0, 4);
                rawIO3.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCrc());
                byteArrayOutputStream2.write(this.longBuff, 0, 4);
                if (isZip64Entry) {
                    rawIO3.writeLongLittleEndian(this.longBuff, 0, InternalZipConstants.ZIP_64_SIZE_LIMIT);
                    byteArrayOutputStream2.write(this.longBuff, 0, 4);
                    byteArrayOutputStream2.write(this.longBuff, 0, 4);
                    zipModel2.setZip64Format(true);
                    bArr = bArr2;
                } else {
                    bArr = bArr2;
                    rawIO3.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCompressedSize());
                    byteArrayOutputStream2.write(this.longBuff, 0, 4);
                    rawIO3.writeLongLittleEndian(this.longBuff, 0, fileHeader.getUncompressedSize());
                    byteArrayOutputStream2.write(this.longBuff, 0, 4);
                }
                byte[] bArr3 = new byte[0];
                if (Zip4jUtil.isStringNotNullAndNotEmpty(fileHeader.getFileName())) {
                    bArr3 = HeaderUtil.getBytesFromString(fileHeader.getFileName(), charset2);
                }
                rawIO3.writeShortLittleEndian(byteArrayOutputStream2, bArr3.length);
                byte[] bArr4 = new byte[4];
                if (isZip64Entry) {
                    rawIO3.writeLongLittleEndian(this.longBuff, 0, InternalZipConstants.ZIP_64_SIZE_LIMIT);
                    System.arraycopy(this.longBuff, 0, bArr4, 0, 4);
                } else {
                    rawIO3.writeLongLittleEndian(this.longBuff, 0, fileHeader.getOffsetLocalHeader());
                    System.arraycopy(this.longBuff, 0, bArr4, 0, 4);
                }
                rawIO3.writeShortLittleEndian(byteArrayOutputStream2, calculateExtraDataRecordsSize(fileHeader2, isZip64Entry));
                String fileComment = fileHeader.getFileComment();
                byte[] bArr5 = new byte[0];
                if (Zip4jUtil.isStringNotNullAndNotEmpty(fileComment)) {
                    bArr5 = HeaderUtil.getBytesFromString(fileComment, charset2);
                }
                rawIO3.writeShortLittleEndian(byteArrayOutputStream2, bArr5.length);
                if (isZip64Entry) {
                    rawIO3.writeIntLittleEndian(this.intBuff, 0, 65535);
                    byteArrayOutputStream2.write(this.intBuff, 0, 2);
                } else {
                    rawIO3.writeShortLittleEndian(byteArrayOutputStream2, fileHeader.getDiskNumberStart());
                }
                byteArrayOutputStream2.write(bArr);
                byteArrayOutputStream2.write(fileHeader.getExternalFileAttributes());
                byteArrayOutputStream2.write(bArr4);
                if (bArr3.length > 0) {
                    byteArrayOutputStream2.write(bArr3);
                }
                if (isZip64Entry) {
                    zipModel2.setZip64Format(true);
                    rawIO3.writeShortLittleEndian(byteArrayOutputStream2, (int) HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue());
                    rawIO3.writeShortLittleEndian(byteArrayOutputStream2, 28);
                    rawIO3.writeLongLittleEndian(byteArrayOutputStream2, fileHeader.getUncompressedSize());
                    rawIO3.writeLongLittleEndian(byteArrayOutputStream2, fileHeader.getCompressedSize());
                    rawIO3.writeLongLittleEndian(byteArrayOutputStream2, fileHeader.getOffsetLocalHeader());
                    rawIO3.writeIntLittleEndian(byteArrayOutputStream2, fileHeader.getDiskNumberStart());
                }
                if (fileHeader.getAesExtraDataRecord() != null) {
                    AESExtraDataRecord aesExtraDataRecord = fileHeader.getAesExtraDataRecord();
                    rawIO3.writeShortLittleEndian(byteArrayOutputStream2, (int) aesExtraDataRecord.getSignature().getValue());
                    rawIO3.writeShortLittleEndian(byteArrayOutputStream2, aesExtraDataRecord.getDataSize());
                    rawIO3.writeShortLittleEndian(byteArrayOutputStream2, aesExtraDataRecord.getAesVersion().getVersionNumber());
                    byteArrayOutputStream2.write(HeaderUtil.getBytesFromString(aesExtraDataRecord.getVendorID(), charset2));
                    byteArrayOutputStream2.write(new byte[]{(byte) aesExtraDataRecord.getAesKeyStrength().getRawCode()});
                    rawIO3.writeShortLittleEndian(byteArrayOutputStream2, aesExtraDataRecord.getCompressionMethod().getCode());
                }
                writeRemainingExtraDataRecordsIfPresent(fileHeader2, byteArrayOutputStream2);
                if (bArr5.length > 0) {
                    byteArrayOutputStream2.write(bArr5);
                }
            } catch (Exception e) {
                throw new ZipException(e);
            }
        } else {
            throw new ZipException("input parameters is null, cannot write local file header");
        }
    }

    private int calculateExtraDataRecordsSize(FileHeader fileHeader, boolean z) {
        int i = z ? 32 : 0;
        if (fileHeader.getAesExtraDataRecord() != null) {
            i += 11;
        }
        if (fileHeader.getExtraDataRecords() != null) {
            for (ExtraDataRecord next : fileHeader.getExtraDataRecords()) {
                if (!(next.getHeader() == HeaderSignature.AES_EXTRA_DATA_RECORD.getValue() || next.getHeader() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue())) {
                    i += next.getSizeOfData() + 4;
                }
            }
        }
        return i;
    }

    private void writeRemainingExtraDataRecordsIfPresent(FileHeader fileHeader, OutputStream outputStream) throws IOException {
        if (fileHeader.getExtraDataRecords() != null && fileHeader.getExtraDataRecords().size() != 0) {
            for (ExtraDataRecord next : fileHeader.getExtraDataRecords()) {
                if (!(next.getHeader() == HeaderSignature.AES_EXTRA_DATA_RECORD.getValue() || next.getHeader() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue())) {
                    this.rawIO.writeShortLittleEndian(outputStream, (int) next.getHeader());
                    this.rawIO.writeShortLittleEndian(outputStream, next.getSizeOfData());
                    if (next.getSizeOfData() > 0 && next.getData() != null) {
                        outputStream.write(next.getData());
                    }
                }
            }
        }
    }

    private void writeZip64EndOfCentralDirectoryRecord(Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO2) throws IOException {
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, (int) zip64EndOfCentralDirectoryRecord.getSignature().getValue());
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getSizeOfZip64EndCentralDirectoryRecord());
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getVersionMadeBy());
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getVersionNeededToExtract());
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getNumberOfThisDisk());
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getNumberOfThisDiskStartOfCentralDirectory());
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectoryOnThisDisk());
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectory());
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getSizeOfCentralDirectory());
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getOffsetStartCentralDirectoryWRTStartDiskNumber());
    }

    private void writeZip64EndOfCentralDirectoryLocator(Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO2) throws IOException {
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, (int) HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR.getValue());
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryLocator.getNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord());
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryLocator.getOffsetZip64EndOfCentralDirectoryRecord());
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryLocator.getTotalNumberOfDiscs());
    }

    private void writeEndOfCentralDirectoryRecord(ZipModel zipModel, int i, long j, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO2, Charset charset) throws IOException {
        byte[] bArr = new byte[8];
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, (int) HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue());
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk());
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDiskStartOfCentralDir());
        long size = (long) zipModel.getCentralDirectory().getFileHeaders().size();
        long countNumberOfFileHeaderEntriesOnDisk = zipModel.isSplitArchive() ? countNumberOfFileHeaderEntriesOnDisk(zipModel.getCentralDirectory().getFileHeaders(), zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) : size;
        if (countNumberOfFileHeaderEntriesOnDisk > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            countNumberOfFileHeaderEntriesOnDisk = 65535;
        }
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, (int) countNumberOfFileHeaderEntriesOnDisk);
        if (size > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            size = 65535;
        }
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, (int) size);
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, i);
        if (j > InternalZipConstants.ZIP_64_SIZE_LIMIT) {
            rawIO2.writeLongLittleEndian(bArr, 0, InternalZipConstants.ZIP_64_SIZE_LIMIT);
            byteArrayOutputStream.write(bArr, 0, 4);
        } else {
            rawIO2.writeLongLittleEndian(bArr, 0, j);
            byteArrayOutputStream.write(bArr, 0, 4);
        }
        String comment = zipModel.getEndOfCentralDirectoryRecord().getComment();
        if (Zip4jUtil.isStringNotNullAndNotEmpty(comment)) {
            byte[] bytesFromString = HeaderUtil.getBytesFromString(comment, charset);
            rawIO2.writeShortLittleEndian(byteArrayOutputStream, bytesFromString.length);
            byteArrayOutputStream.write(bytesFromString);
            return;
        }
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, 0);
    }

    private long countNumberOfFileHeaderEntriesOnDisk(List<FileHeader> list, int i) throws ZipException {
        if (list != null) {
            int i2 = 0;
            for (FileHeader diskNumberStart : list) {
                if (diskNumberStart.getDiskNumberStart() == i) {
                    i2++;
                }
            }
            return (long) i2;
        }
        throw new ZipException("file headers are null, cannot calculate number of entries on this disk");
    }

    private boolean isZip64Entry(FileHeader fileHeader) {
        return fileHeader.getCompressedSize() >= InternalZipConstants.ZIP_64_SIZE_LIMIT || fileHeader.getUncompressedSize() >= InternalZipConstants.ZIP_64_SIZE_LIMIT || fileHeader.getOffsetLocalHeader() >= InternalZipConstants.ZIP_64_SIZE_LIMIT || fileHeader.getDiskNumberStart() >= 65535;
    }

    private long getOffsetOfCentralDirectory(ZipModel zipModel) {
        if (!zipModel.isZip64Format() || zipModel.getZip64EndOfCentralDirectoryRecord() == null || zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() == -1) {
            return zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory();
        }
        return zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber();
    }

    private Zip64EndOfCentralDirectoryRecord buildZip64EndOfCentralDirectoryRecord(ZipModel zipModel, int i, long j) throws ZipException {
        Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = new Zip64EndOfCentralDirectoryRecord();
        zip64EndOfCentralDirectoryRecord.setSignature(HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD);
        zip64EndOfCentralDirectoryRecord.setSizeOfZip64EndCentralDirectoryRecord(44);
        if (!(zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null || zipModel.getCentralDirectory().getFileHeaders().size() <= 0)) {
            FileHeader fileHeader = zipModel.getCentralDirectory().getFileHeaders().get(0);
            zip64EndOfCentralDirectoryRecord.setVersionMadeBy(fileHeader.getVersionMadeBy());
            zip64EndOfCentralDirectoryRecord.setVersionNeededToExtract(fileHeader.getVersionNeededToExtract());
        }
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDisk(zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk());
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDirectory(zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDiskStartOfCentralDir());
        long size = (long) zipModel.getCentralDirectory().getFileHeaders().size();
        zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(zipModel.isSplitArchive() ? countNumberOfFileHeaderEntriesOnDisk(zipModel.getCentralDirectory().getFileHeaders(), zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) : size);
        zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(size);
        zip64EndOfCentralDirectoryRecord.setSizeOfCentralDirectory((long) i);
        zip64EndOfCentralDirectoryRecord.setOffsetStartCentralDirectoryWRTStartDiskNumber(j);
        return zip64EndOfCentralDirectoryRecord;
    }
}
