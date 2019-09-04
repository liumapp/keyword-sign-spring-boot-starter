package com.liumapp.keywordsign.core;

import com.liumapp.keywordsign.core.config.KeywordSignConfigFactory;
import com.liumapp.keywordsign.core.keyword.Keyword;
import com.liumapp.qtools.date.DateTool;
import com.liumapp.qtools.security.encrypt.Sha1Tool;

/**
 * file KeywordSignCore.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/3
 */
class KeywordSignCore implements KeywordSign
{

    @Override
    public String signWithoutTimeStamp(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return null;
    }

    @Override
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword, String timestampUrl) {
        return null;
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return this.signWithTimeStamp(ksFileName,
                ksPassword,
                certAlias,
                certPassword,
                pdfBase64, signPic,
                signFiled,
                keyword,
                KeywordSignConfigFactory.getInstance().getTimeStampUrl() + Sha1Tool.toSHA1(DateTool.getSimpleUTCDateString() + "_" + KeywordSignConfigFactory.getInstance().getTimeStampCode())
                );
    }

    @Override
    public String signWithoutTimeStamp(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return null;
    }

    @Override
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String keyword, String timestampUrl) {
        return null;
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return this.signWithTimeStamp(ksFileName,
                ksPassword,
                certAlias,
                pfxBase64,
                pfxPassword,
                pdfBase64, signPic,
                signFiled,
                keyword,
                KeywordSignConfigFactory.getInstance().getTimeStampUrl() + Sha1Tool.toSHA1(DateTool.getSimpleUTCDateString() + "_" + KeywordSignConfigFactory.getInstance().getTimeStampCode())
        );
    }
}
