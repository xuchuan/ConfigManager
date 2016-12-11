package net.xuchuan.common.configmanager;

public class NoSuchPropertyException extends RuntimeException {
    public NoSuchPropertyException() {
    }

    public NoSuchPropertyException(String message) {
        super(message);
    }

    public NoSuchPropertyException(String message, Throwable cause) {
        super(message, cause);
    }
}
