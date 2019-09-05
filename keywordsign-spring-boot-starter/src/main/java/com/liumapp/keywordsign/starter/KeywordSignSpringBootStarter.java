package com.liumapp.keywordsign.starter;

import com.liumapp.keywordsign.core.KeywordSign;
import com.liumapp.keywordsign.core.KeywordSignFactory;
import com.liumapp.keywordsign.core.config.KeywordSignConfig;
import com.liumapp.keywordsign.core.config.KeywordSignConfigFactory;
import com.liumapp.keywordsign.core.keystore.KeyStore;
import com.liumapp.keywordsign.core.keystore.impl.KeyStoreFactory;
import com.liumapp.keywordsign.core.pfx.PfxHandler;
import com.liumapp.keywordsign.core.pfx.impl.PfxHandlerFactory;
import com.liumapp.keywordsign.core.signpic.SignPic;
import com.liumapp.keywordsign.core.signpic.impl.SignPicFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * file ukeyAutoConfiguration.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/8/8
 */
@Configuration
@EnableConfigurationProperties(KeywordProperties.class)
public class KeywordSignSpringBootStarter {

    @Autowired
    private KeywordProperties keywordProperties;

    @Bean
    @ConditionalOnMissingBean //确保只有一个bean实例产生
    public KeywordSignConfig keywordSignConfig (KeywordProperties keywordProperties) {
        KeywordSignConfig keywordSignConfig = KeywordSignConfigFactory.getInstance();
        keywordSignConfig.setTmpPath(noNull(keywordProperties.getTmpPath(), "keyword的tmpath不能为空"));
        keywordSignConfig.setBeforeKeywordSymbol(noNull(keywordProperties.getBeforeKeywordSymbol(), "keyword的前置修饰符不能为空"));
        keywordSignConfig.setAfterKeywordSymbok(noNull(keywordProperties.getAfterKeywordSymbok(), "keyword的后置修饰符不能为空"));
        keywordSignConfig.setTimeStampUrl(noNull(keywordProperties.getTimeStampUrl(), "keyword的时间戳服务地址不能为空"));
        keywordSignConfig.setTimeStampCode(noNull(keywordProperties.getTimeStampCode(), "keyword的时间戳服务码不能为空"));
        keywordSignConfig.setDefaultKeyStorePassword(noNull(keywordProperties.getDefaultKeyStorePassword(), "keyword的默认证书容器密码不能为空"));
        return keywordSignConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public KeywordSign keywordSign () {
        return KeywordSignFactory.getInstance();
    }

    @Bean
    @ConditionalOnMissingBean
    public KeyStore keyStore () {
        return KeyStoreFactory.getInstance();
    }

    @Bean
    @ConditionalOnMissingBean
    public PfxHandler pfxHandler () {
        return PfxHandlerFactory.getInstance();
    }

    @Bean
    @ConditionalOnMissingBean
    public SignPic signPic () {
        return SignPicFactory.getInstance();
    }


    private String noNull (String o, String errorMsg) {
        if (o == null) {
            throw new NullPointerException(errorMsg);
        }
        return o;
    }
}
