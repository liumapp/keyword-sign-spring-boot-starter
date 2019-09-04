package com.liumapp.keywordsign.core.keystore.impl;

import com.liumapp.keywordsign.core.keystore.KeyStore;

/**
 * file KeyStoreFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeyStoreFactory {

    private KeyStore keyStore;

    private static class KeyStoreFactoryHolder {
        private static final KeyStoreFactory INSTANCE = new KeyStoreFactory();
    }

    private KeyStoreFactory() {

    }

    public static KeyStore getInstance () {
        return KeyStoreFactoryHolder.INSTANCE.getKeyStore();
    }

    public KeyStore getKeyStore () {
        if (this.keyStore == null) {
            this.keyStore = new KeyStoreCore();
        }
        return this.keyStore;
    }


}
