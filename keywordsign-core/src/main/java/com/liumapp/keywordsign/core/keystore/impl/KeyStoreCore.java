package com.liumapp.keywordsign.core.keystore.impl;

import com.liumapp.keywordsign.core.adapter.KeyTool;
import com.liumapp.keywordsign.core.config.KeywordSignConfig;
import com.liumapp.keywordsign.core.config.KeywordSignConfigFactory;
import com.liumapp.keywordsign.core.exceptions.KeyStoreException;
import com.liumapp.keywordsign.core.keystore.KeyStore;
import com.liumapp.qtools.file.basic.FileTool;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.temporal.ChronoUnit;

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
        if (!FileTool.isFileExists(fileName)) {
            return createKeyStoreFile(fileName, KeywordSignConfigFactory.getInstance().getDefaultKeyStorePassword());
        }
        return true;
    }

    @Override
    public boolean createKeyStoreFile(String fileName, String keystorePassword) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            KeyTool.newKeyStore(keystorePassword)
                    .newKeyPair()
                    .keyLength(2048)
                    .generateWithCertificate()
                    .withValidity(1, ChronoUnit.YEARS)g
                    .withDistinguishName()
                    .commonName("liumapp")
                    .state("HangZhou")
                    .locality("ZheJiang")
                    .country("China")
                    .build()
                    .createInKeyStore("first-cert", "123123123")
                    .writeTo(out);
        } catch (Exception e) {
            throw new KeyStoreException("keystore创建失败，指定路径：" + fileName + "不合法，可能是不具备写权限");
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                throw new KeyStoreException("keystore创建失败，指定路径：" + fileName + "不合法，可能是不具备写权限");
            }
        }
        return true;
    }

    @Override
    public void writePfxToKeyStore(String pfxBase64, String certPassword, String alias) {

    }

}
