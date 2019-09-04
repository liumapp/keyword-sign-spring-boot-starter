package com.liumapp.keywordsign.core.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
}
