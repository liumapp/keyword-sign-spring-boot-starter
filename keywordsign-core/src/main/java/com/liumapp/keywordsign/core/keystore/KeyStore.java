package com.liumapp.keywordsign.core.keystore;

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
    public boolean createKeyStoreFile (String fileName);

    public void writePfxToKeyStore (String pfxBase64, String certPassword, String alias);


}
