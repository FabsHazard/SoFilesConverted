package net.lingala.zip4j.exception;

import java.io.IOException;

public class ZipException extends IOException {
    private static final long serialVersionUID = 1;
    private Type type;

    public enum Type {
        WRONG_PASSWORD,
        TASK_CANCELLED_EXCEPTION,
        CHECKSUM_MISMATCH,
        UNKNOWN_COMPRESSION_METHOD,
        FILE_NOT_FOUND,
        UNSUPPORTED_ENCRYPTION,
        UNKNOWN
    }

    public ZipException(String str) {
        super(str);
        this.type = Type.UNKNOWN;
    }

    public ZipException(Exception exc) {
        super(exc);
        this.type = Type.UNKNOWN;
    }

    public ZipException(String str, Exception exc) {
        super(str, exc);
        this.type = Type.UNKNOWN;
    }

    public ZipException(String str, Type type2) {
        super(str);
        Type type3 = Type.UNKNOWN;
        this.type = type2;
    }

    public ZipException(String str, Throwable th, Type type2) {
        super(str, th);
        Type type3 = Type.UNKNOWN;
        this.type = type2;
    }

    public Type getType() {
        return this.type;
    }
}
