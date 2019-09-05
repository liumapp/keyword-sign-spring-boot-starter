package com.liumapp.keywordsign.core.pfx.impl;

import com.liumapp.keywordsign.core.config.KeywordSignConfigFactory;
import com.liumapp.keywordsign.core.pfx.PfxHandler;
import com.liumapp.qtools.file.base64.Base64FileTool;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * file PfxCoreHandlerTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class PfxCoreHandlerTest {

    /**
     * 请自行使用命令 keytool -v -list -keystore ./demo.ks 查看pfx证书是否写入成功
     */
    @Test
    public void writePfxToKeyStore() throws IOException {
        PfxHandler pfxHandler = PfxHandlerFactory.getInstance();
        pfxHandler.writePfxToKeyStore("./data/demo.ks",
                "123456",
                "liumapp",
                Base64FileTool.filePathToBase64("./data/liumapp.pfx"),
                "123123123"
                );
    }
}