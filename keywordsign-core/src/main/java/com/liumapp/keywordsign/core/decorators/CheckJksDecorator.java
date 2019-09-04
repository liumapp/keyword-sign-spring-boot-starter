package com.liumapp.keywordsign.core.decorators;

import com.liumapp.keywordsign.core.KeywordSign;
import com.liumapp.keywordsign.core.templates.impl.KeywordSignTemplate;

/**
 * file CheckJksDecorator.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class CheckJksDecorator extends KeywordSignTemplate {

    public CheckJksDecorator(KeywordSign keywordSign) {
        super(keywordSign);
    }

    @Override
    public String signWithoutTimeStamp(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return super.signWithoutTimeStamp(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, keyword);
    }

    @Override
    public String signWithoutTimeStamp(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return super.signWithoutTimeStamp(ksFileName, ksPassword, certAlias, pfxBase64, pfxPassword, signPic, signFiled, keyword);
    }

    @Override
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String keyword, String timestampUrl) {
        return super.signWithTimeStamp(ksFileName, ksPassword, certAlias, pfxBase64, pfxPassword, signPic, signFiled, keyword, timestampUrl);
    }

    @Override
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword, String timestampUrl) {
        return super.signWithTimeStamp(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, keyword, timestampUrl);
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return super.sign(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, keyword);
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return super.sign(ksFileName, ksPassword, certAlias, pfxBase64, pfxPassword, pdfBase64, signPic, signFiled, keyword);
    }
}
