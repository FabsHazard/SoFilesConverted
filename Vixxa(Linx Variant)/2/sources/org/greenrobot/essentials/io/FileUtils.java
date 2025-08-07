package org.greenrobot.essentials.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.Checksum;

public class FileUtils {
    public static byte[] readBytes(File file) throws IOException {
        return IoUtils.readAllBytesAndClose(new FileInputStream(file));
    }

    public static void writeBytes(File file, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
        } finally {
            IoUtils.safeClose(fileOutputStream);
        }
    }

    public static String readUtf8(File file) throws IOException {
        return readChars(file, "UTF-8");
    }

    public static String readChars(File file, String str) throws IOException {
        return IoUtils.readAllCharsAndClose(new InputStreamReader(new FileInputStream(file), str));
    }

    public static void writeUtf8(File file, CharSequence charSequence) throws IOException {
        writeChars(file, "UTF-8", charSequence, false);
    }

    public static void appendUtf8(File file, CharSequence charSequence) throws IOException {
        writeChars(file, "UTF-8", charSequence, true);
    }

    public static void writeChars(File file, String str, CharSequence charSequence, boolean z) throws IOException {
        IoUtils.writeAllCharsAndClose(new OutputStreamWriter(new FileOutputStream(file, z), str), charSequence);
    }

    public static void copyFile(File file, File file2) throws IOException {
        BufferedOutputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            bufferedInputStream = new BufferedOutputStream(new FileOutputStream(file2));
            IoUtils.copyAllBytes(bufferedInputStream, bufferedInputStream);
        } catch (Throwable th) {
            throw th;
        } finally {
            IoUtils.safeClose(bufferedInputStream);
        }
    }

    public static void copyFile(String str, String str2) throws IOException {
        copyFile(new File(str), new File(str2));
    }

    public static <T> T readObject(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            return objectInputStream.readObject();
        } finally {
            IoUtils.safeClose(objectInputStream);
        }
    }

    public static void writeObject(File file, Object obj) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            fileOutputStream.getFD().sync();
        } finally {
            IoUtils.safeClose(objectOutputStream);
        }
    }

    public static String getMd5(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            return IoUtils.getMd5(bufferedInputStream);
        } finally {
            IoUtils.safeClose(bufferedInputStream);
        }
    }

    public static String getSha1(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            return IoUtils.getSha1(bufferedInputStream);
        } finally {
            IoUtils.safeClose(bufferedInputStream);
        }
    }

    public static String getSha256(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            return IoUtils.getSha256(bufferedInputStream);
        } finally {
            IoUtils.safeClose(bufferedInputStream);
        }
    }

    public static void updateChecksum(File file, Checksum checksum) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            IoUtils.updateChecksum(bufferedInputStream, checksum);
        } finally {
            IoUtils.safeClose(bufferedInputStream);
        }
    }

    public static void deleteDirRecursive(File file) throws IOException {
        File deleteDirRecursiveInternal = deleteDirRecursiveInternal(file, true);
        if (deleteDirRecursiveInternal != null) {
            throw new IOException("Could not delete file: " + deleteDirRecursiveInternal.getPath());
        }
    }

    public static boolean deleteDirRecursiveBestEffort(File file) {
        deleteDirRecursiveInternal(file, false);
        return !file.exists();
    }

    private static File deleteDirRecursiveInternal(File file, boolean z) {
        File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                File deleteDirRecursiveInternal = deleteDirRecursiveInternal(file2, z);
                if (z && deleteDirRecursiveInternal != null) {
                    return deleteDirRecursiveInternal;
                }
            }
            if (!file2.delete() && z && file2.exists()) {
                return file2;
            }
        }
        if (file.delete() || !z || !file.exists()) {
            return null;
        }
        return file;
    }
}
