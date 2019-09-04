package com.liumapp.keywordsign.core;

import com.liumapp.qtools.file.base64.Base64FileTool;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * file KeywordSignTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeywordSignTest {

    @Test
    public void testSign () throws IOException {
        KeywordSignConfigFactory.buildInstance("./data");
        KeywordSign keywordSign = KeywordSignFactory.getInstance();
        keywordSign.sign("./demo.ks",
                "123456",
                "liumapp",
                "123123123",
                Base64FileTool.filePathToBase64("./data/test.pdf"),
                Base64FileTool.filePathToBase64("./data/me.jpg"),
                "signFiled1",
                "year"
                );

    }

}