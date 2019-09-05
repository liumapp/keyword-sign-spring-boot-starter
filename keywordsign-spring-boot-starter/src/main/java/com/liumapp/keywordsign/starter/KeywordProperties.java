package com.liumapp.keywordsign.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * file UkeyProperties.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/8/8
 */
@ConfigurationProperties(prefix = "com.liumapp.keywordsign")
@Component
@Data
public class KeywordProperties {

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

    private String defaultKeyStorePassword = "123456";

}
