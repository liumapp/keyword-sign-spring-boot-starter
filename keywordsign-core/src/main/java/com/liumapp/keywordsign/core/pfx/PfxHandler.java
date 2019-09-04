package com.liumapp.keywordsign.core.pfx;

/**
 * file PfxHandler.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public interface PfxHandler {

    public void writePfxToKeyStore(String keystoreFileName, String keystorePassword, String certAlias, String pfxBase64, String pfxPassword);

}
