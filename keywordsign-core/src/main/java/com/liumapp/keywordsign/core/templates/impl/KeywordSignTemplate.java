package com.liumapp.keywordsign.core.templates.impl;

import com.liumapp.keywordsign.core.KeywordSign;
import com.liumapp.keywordsign.core.templates.Template;

/**
 * file KeywordSignTemplate.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public abstract class KeywordSignTemplate implements Template, KeywordSign {

    public KeywordSign keywordSign;

    public KeywordSignTemplate(KeywordSign keywordSign) {
        this.keywordSign = keywordSign;
    }


    @Override
    public String signWithoutTimeStamp(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return keywordSign.signWithoutTimeStamp(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, keyword);
    }

    @Override
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return keywordSign.signWithTimeStamp(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, keyword);
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return keywordSign.sign(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, keyword);
    }
}
