package com.liumapp.keywordsign.core.config;

import java.security.InvalidParameterException;

/**
 * file KeywordSignConfigFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeywordSignConfigFactory {

    private KeywordSignConfig keywordSignConfig;

    private static class KeywordSignConfigFactoryHolder {
        private static final KeywordSignConfigFactory INSTANCE = new KeywordSignConfigFactory();
    }

    private KeywordSignConfigFactory() {

    }

    public static KeywordSignConfig getInstance () {
        return KeywordSignConfigFactoryHolder.INSTANCE.getKeywordSignConfig();
    }

    public static void buildInstance (String tmpPath) {
        KeywordSignConfigFactoryHolder.INSTANCE.buildKeywordSignConfig(tmpPath);
    }

    public static void buildInstance (String tmpPath, String beforeKeywordSymbol, String afterKeywordSymbol) {
        KeywordSignConfigFactoryHolder.INSTANCE.buildKeywordSignConfig(tmpPath, beforeKeywordSymbol, afterKeywordSymbol);
    }

    public static void buildInstance (String tmpPath, String beforeKeywordSymbol, String afterKeywordSymbol, String timestampUrl, String timestampCode) {
        KeywordSignConfigFactoryHolder.INSTANCE.buildKeywordSignConfig(tmpPath, beforeKeywordSymbol, afterKeywordSymbol, timestampUrl, timestampCode);
    }

    public KeywordSignConfig getKeywordSignConfig () {
        if (this.keywordSignConfig == null) {
            this.keywordSignConfig = new KeywordSignConfig();
        }
        return this.keywordSignConfig;
    }

    public void buildKeywordSignConfig (String tmpPath) {
        this.keywordSignConfig = new KeywordSignConfig(tmpPath);
    }


    public void buildKeywordSignConfig (String tmpPath, String beforeKeywordSymbol, String afterKeywordSymbol) {
        this.keywordSignConfig = new KeywordSignConfig(tmpPath, beforeKeywordSymbol, afterKeywordSymbol);
    }

    public void buildKeywordSignConfig (String tmpPath,
                                        String beforeKeywordSymbol,
                                        String afterKeywordSymbol,
                                        String timestampUrl,
                                        String timestampCode
                                        ) {
        this.keywordSignConfig = new KeywordSignConfig(tmpPath, beforeKeywordSymbol, afterKeywordSymbol, timestampUrl, timestampCode);
    }

}
