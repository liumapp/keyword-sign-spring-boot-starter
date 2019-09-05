package com.liumapp.keywordsign.core.keyword.impl;

import com.liumapp.keywordsign.core.config.KeywordSignConfigFactory;
import com.liumapp.keywordsign.core.keyword.Keyword;
import com.liumapp.qtools.file.base64.Base64FileTool;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * file KeywordCoreTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/5
 */
public class KeywordCoreTest {

    @Test
    public void getKeywordPosition() throws IOException {
        Keyword keyword = KeywordFactory.getInstance();
        List<HashMap<String, Float>> results = keyword.getKeywordPosition(Base64FileTool.filePathToBase64("./data/test.pdf"), "year");
        Assert.assertEquals(1, results.size());
        for (HashMap<String, Float> item : results) {
            System.out.println("page is : " + item.get("page"));
            System.out.println("x is : " + item.get("x"));
            System.out.println("y is : " + item.get("y"));
        }
    }
}