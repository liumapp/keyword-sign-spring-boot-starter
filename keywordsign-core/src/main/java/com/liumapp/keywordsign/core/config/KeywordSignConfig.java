package com.liumapp.keywordsign.core.config;

import lombok.*;

/**
 * file KeywordSignConfig.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
@Data
public class KeywordSignConfig {

    /**
     * 临时文件存放目录
     */
    private String tmpPath = "./data";

    /**
     * 关键词前置装饰符
     */
    private String beforeKeywordSymbol = "\\$\\{";

    /**
     * 关键词后置装饰符
     */
    private String afterKeywordSymbok = "\\}";

    private String timeStampUrl = "http://ets.wotrus.com/tk_3_";

    private String timeStampCode = "1zPz3KSTtj5SE7s";

    public KeywordSignConfig() {
    }

    public KeywordSignConfig(String tmpPath) {
        this.tmpPath = tmpPath;
    }

    public KeywordSignConfig(String tmpPath, String beforeKeywordSymbol, String afterKeywordSymbok) {
        this.tmpPath = tmpPath;
        this.beforeKeywordSymbol = beforeKeywordSymbol;
        this.afterKeywordSymbok = afterKeywordSymbok;
    }

    public KeywordSignConfig(String tmpPath, String beforeKeywordSymbol, String afterKeywordSymbok, String timeStampUrl, String timeStampCode) {
        this.tmpPath = tmpPath;
        this.beforeKeywordSymbol = beforeKeywordSymbol;
        this.afterKeywordSymbok = afterKeywordSymbok;
        this.timeStampUrl = timeStampUrl;
        this.timeStampCode = timeStampCode;
    }
}
