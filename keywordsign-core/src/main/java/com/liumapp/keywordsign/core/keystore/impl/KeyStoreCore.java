package com.liumapp.keywordsign.core.keystore.impl;

import com.liumapp.keywordsign.core.keystore.KeyStore;

/**
 * file KeyStore.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeyStoreCore implements KeyStore {

    @Override
    public boolean chkKeyStoreFile(String fileName) {
        return false;
    }

    @Override
    public void writePfxToKeyStore(String pfxBase64, String certPassword, String alias) {

    }

}
