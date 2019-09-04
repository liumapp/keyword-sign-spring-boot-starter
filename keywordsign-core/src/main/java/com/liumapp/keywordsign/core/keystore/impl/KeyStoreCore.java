package com.liumapp.keywordsign.core.keystore.impl;

import com.liumapp.keywordsign.core.exceptions.KeyStoreException;
import com.liumapp.keywordsign.core.keystore.KeyStore;
import com.liumapp.qtools.date.DateTool;
import com.liumapp.qtools.file.basic.FileTool;

import java.io.FileOutputStream;
import java.util.Date;

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
            return createKeyStoreFile(fileName);
        }
        return true;
    }

    @Override
    public boolean createKeyStoreFile(String fileName) {
        try {
            FileOutputStream out = new FileOutputStream(fileName);

        } catch (Exception e) {
            throw new KeyStoreException("keystore创建失败，指定路径：" + fileName + "不合法，可能是不具备写权限");
        }


        return true;
    }

    @Override
    public void writePfxToKeyStore(String pfxBase64, String certPassword, String alias) {

    }

}
