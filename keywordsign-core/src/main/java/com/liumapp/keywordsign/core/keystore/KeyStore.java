package com.liumapp.keywordsign.core.keystore;

import java.security.PrivateKey;
import java.security.cert.Certificate;

/**
 * file KeyStore.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public interface KeyStore {

    /**
     * 检查keystore是否存在，不存在则创建
     * @param fileName
     * @return
     */
    public boolean chkKeyStoreFile (String fileName);

    /**
     * 创建keystore
     * @param fileName
     * @return
     */
    public boolean createKeyStoreFile (String fileName, String keystorePassword);

    /**
     * 从keystore中读取私钥
     * 证书链可以从私钥中获取
     * @param keystoreFile
     * @param keystorePassword
     * @param certAlias
     * @param certPassword
     * @return
     */
    public PrivateKey readPrivateKeyFromKeyStore (String keystoreFile, String keystorePassword, String certAlias, String certPassword);


    public Certificate[] readCertificateChainFromKeyStore (String keystoreFile, String keystorePassword, String certAlias, String certPassword);

}
