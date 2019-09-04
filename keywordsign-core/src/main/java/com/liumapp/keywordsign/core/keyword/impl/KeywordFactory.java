package com.liumapp.keywordsign.core.keyword.impl;

import com.liumapp.keywordsign.core.keyword.Keyword;

/**
 * file KeywordFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeywordFactory {

    public Keyword keyword;

    private static class KeywordFactoryHolder {
        private static final KeywordFactory INSTANCE = new KeywordFactory();
    }

    private KeywordFactory() {
    }

    public static Keyword getInstance () {
        return KeywordFactoryHolder.INSTANCE.getKeyword();
    }

    public Keyword getKeyword() {
        if (this.keyword == null) {
            this.keyword = new KeywordCore();
        }
        return this.keyword;
    }
}
