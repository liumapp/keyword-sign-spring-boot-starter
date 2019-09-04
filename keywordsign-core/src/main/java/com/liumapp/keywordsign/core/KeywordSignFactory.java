package com.liumapp.keywordsign.core;

/**
 * file KeywordSignFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeywordSignFactory {

    private Keyword keyword;

    private static class KeywordSignFactoryHolder {
        private static final KeywordSignFactory INSTANCE = new KeywordSignFactory();
    }

    private KeywordSignFactory () {

    }

    public static synchronized Keyword getInstance () {
        return KeywordSignFactoryHolder.INSTANCE.getCoreInstance();
    }

    private Keyword getCoreInstance () {
        if (this.keyword == null) {
            this.keyword = new KeywordSignCore();
        }
        return this.keyword;
    }



}
