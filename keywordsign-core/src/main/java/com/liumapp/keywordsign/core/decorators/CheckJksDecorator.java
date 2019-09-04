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
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return super.signWithTimeStamp(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, keyword);
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String keyword) {
        return super.sign(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, keyword);
    }
}
