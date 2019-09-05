package com.liumapp.keywordsign.core.keystore.impl;

import com.liumapp.keywordsign.core.adapter.KeyTool;
import com.liumapp.keywordsign.core.config.KeywordSignConfig;
import com.liumapp.keywordsign.core.config.KeywordSignConfigFactory;
import com.liumapp.keywordsign.core.exceptions.KeyStoreException;
import com.liumapp.keywordsign.core.keystore.KeyStore;
import com.liumapp.qtools.file.basic.FileTool;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
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

    protected KeyStoreCore() {
    }

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
                    .withValidity(1, ChronoUnit.YEARS)
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
    public PrivateKey readPrivateKeyFromKeyStore(String keystoreFile, String keystorePassword, String certAlias, String certPassword) {
        PrivateKey pk = null;
        try {
            BouncyCastleProvider provider = new BouncyCastleProvider();
            Security.addProvider(provider);
            java.security.KeyStore ks = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
            ks.load(new FileInputStream(keystoreFile), keystorePassword.toCharArray());
            pk = (PrivateKey) ks.getKey(certAlias, certPassword.toCharArray());
        } catch (Exception e) {
            throw new KeyStoreException("读取私钥失败", e.getCause());
        }
        return pk;
    }

    @Override
    public Certificate[] readCertificateChainFromKeyStore(String keystoreFile, String keystorePassword, String certAlias, String certPassword) {
        Certificate[] chain = null;
        try {
            BouncyCastleProvider provider = new BouncyCastleProvider();
            Security.addProvider(provider);
            java.security.KeyStore ks = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
            ks.load(new FileInputStream(keystoreFile), keystorePassword.toCharArray());
            chain = ks.getCertificateChain(certAlias);
        } catch (Exception e) {
            throw new KeyStoreException("读取证书链失败", e.getCause());
        }
        return chain;
    }
}
