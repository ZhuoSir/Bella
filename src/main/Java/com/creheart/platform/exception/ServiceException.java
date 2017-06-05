package com.creheart.platform.exception;

/**
 *
 * Created by sunny-chen on 2017/6/5.
 */
public class ServiceException extends Exception {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super("ServiceException: " + message);
    }

    public ServiceException(String message, Throwable cause) {
        super("ServiceException: " + message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
