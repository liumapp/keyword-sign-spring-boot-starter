package com.liumapp.keywordsign.core.keystore.impl;

import com.liumapp.keywordsign.core.config.KeywordSignConfig;
import com.liumapp.keywordsign.core.config.KeywordSignConfigFactory;
import com.liumapp.keywordsign.core.keystore.KeyStore;
import com.liumapp.qtools.file.basic.FileTool;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * file KeyStoreCoreTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeyStoreCoreTest {

    @Test
    public void chkKeyStoreFile() {
        KeywordSignConfigFactory.buildInstance("./data");
        KeyStore keyStore = KeyStoreFactory.getInstance();
        keyStore.chkKeyStoreFile("./data/demo.ks");
        Assert.assertEquals(true, FileTool.isFileExists("./data/demo.ks"));
    }


}