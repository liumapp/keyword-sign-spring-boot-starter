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

    private KeywordSignCore keywordSignCore;

    private static class KeywordSignFactoryHolder {
        private static final KeywordSignFactory INSTANCE = new KeywordSignFactory();
    }

    private KeywordSignFactory () {

    }

    public static synchronized KeywordSignCore getInstance () {
        return KeywordSignFactoryHolder.INSTANCE.getCoreInstance();
    }

    private KeywordSignCore getCoreInstance () {
        if (this.keywordSignCore == null) {
            this.keywordSignCore = new KeywordSignCore();
        }
        return this.keywordSignCore;
    }



}
