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
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled,String signReason,
                                    String signLocation,  String keyword, String timestampUrl) {
        return keywordSign.signWithTimeStamp(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, signReason,
                signLocation, keyword, timestampUrl);
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String signReason,
                       String signLocation, String keyword) {
        return keywordSign.sign(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, signReason,
                signLocation, keyword);
    }

    @Override
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String signReason,
                                    String signLocation, String keyword, String timestampUrl) {
        return keywordSign.signWithTimeStamp(ksFileName, ksPassword, certAlias, pfxBase64, pfxPassword, pdfBase64, signPic, signFiled, signReason,
                signLocation, keyword, timestampUrl);
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String signReason,
                       String signLocation, String keyword) {
        return keywordSign.sign(ksFileName, ksPassword, certAlias, pfxBase64, pfxPassword, pdfBase64, signPic, signFiled, signReason,
                signLocation, keyword);
    }
}
