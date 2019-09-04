package com.liumapp.keywordsign.core.exceptions;

/**
 * file KeyStoreException.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeyStoreException extends RuntimeException {

    public KeyStoreException() {
        super();
    }

    public KeyStoreException(String message) {
        super(message);
    }

    public KeyStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeyStoreException(Throwable cause) {
        super(cause);
    }

    protected KeyStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
