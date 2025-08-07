package io.objectbox.exception;

public class FileCorruptException extends DbException {
    public FileCorruptException(String str) {
        super(str);
    }

    public FileCorruptException(String str, int i) {
        super(str, i);
    }
}
