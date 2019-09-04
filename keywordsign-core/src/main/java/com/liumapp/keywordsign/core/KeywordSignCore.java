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

    /**
     * 不需要做任何操作，保留即可
     * 在装饰类中已经解决
     * @param ksFileName
     * @param ksPassword
     * @param certAlias
     * @param certPassword
     * @param pdfBase64
     * @param signPic
     * @param signFiled
     * @param keyword
     * @param timestampUrl
     * @return
     */
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

    /**
     * 真正做事情的方法
     * @param ksFileName
     * @param ksPassword
     * @param certAlias
     * @param pfxBase64
     * @param pfxPassword
     * @param pdfBase64
     * @param signPic
     * @param signFiled
     * @param keyword
     * @param timestampUrl
     * @return
     */
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
