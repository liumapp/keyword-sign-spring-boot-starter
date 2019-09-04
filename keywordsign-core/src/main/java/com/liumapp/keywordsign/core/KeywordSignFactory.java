package com.liumapp.keywordsign.core;

import com.liumapp.keywordsign.core.decorators.CheckJksDecorator;
import com.liumapp.keywordsign.core.decorators.WritePfxToJksDecorator;

/**
 * file KeywordSignFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeywordSignFactory {

    private KeywordSign keywordSign;

    private static class KeywordSignFactoryHolder {
        private static final KeywordSignFactory INSTANCE = new KeywordSignFactory();
    }

    private KeywordSignFactory () {

    }

    public static synchronized KeywordSign getInstance () {
        return KeywordSignFactoryHolder.INSTANCE.getCoreInstance();
    }

    private KeywordSign getCoreInstance () {
        if (this.keywordSign == null) {
            this.keywordSign = new CheckJksDecorator(new WritePfxToJksDecorator(new KeywordSignCore()));
        }
        return this.keywordSign;
    }



}
