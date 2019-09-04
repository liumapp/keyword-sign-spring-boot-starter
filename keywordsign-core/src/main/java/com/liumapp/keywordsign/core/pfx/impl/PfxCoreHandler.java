package com.liumapp.keywordsign.core.pfx.impl;

import com.liumapp.keywordsign.core.exceptions.KeyStoreException;
import com.liumapp.keywordsign.core.pfx.PfxHandler;
import com.liumapp.keywordsign.core.utils.PfxUtil;

/**
 * file PfxCoreHandler.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class PfxCoreHandler implements PfxHandler {

    protected PfxCoreHandler() {
    }

    @Override
    public void writePfxToKeyStore(String keystoreFileName, String keystorePassword, String certAlias, String pfxBase64, String pfxPassword) {
        try {
            PfxUtil pfxUtil = new PfxUtil();
            pfxUtil.PfxBase642JKS(pfxBase64,
                    pfxPassword,
                    keystoreFileName,
                    keystorePassword,
                    certAlias);
        } catch (Exception e) {
            throw new KeyStoreException("写入pfx证书失败", e.getCause());
        }

    }

}
