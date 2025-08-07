package io.objectbox.exception;

public class DbMaxDataSizeExceededException extends DbException {
    public DbMaxDataSizeExceededException(String str) {
        super(str);
    }
}
