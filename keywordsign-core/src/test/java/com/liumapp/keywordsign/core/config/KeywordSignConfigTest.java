package com.liumapp.keywordsign.core.config;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * file KeywordSignConfigTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/5
 */
public class KeywordSignConfigTest {

    @Test
    public void testChangeConfig () {
        KeywordSignConfig keywordSignConfig = KeywordSignConfigFactory.getInstance();
        keywordSignConfig.setBeforeKeywordSymbol("\\$\\[");
        keywordSignConfig.setAfterKeywordSymbok("\\]");

        KeywordSignConfig keywordSignConfig1 = KeywordSignConfigFactory.getInstance();
        Assert.assertEquals("\\$\\[", keywordSignConfig1.getBeforeKeywordSymbol());
        Assert.assertEquals("\\]", keywordSignConfig1.getAfterKeywordSymbok());
    }


}