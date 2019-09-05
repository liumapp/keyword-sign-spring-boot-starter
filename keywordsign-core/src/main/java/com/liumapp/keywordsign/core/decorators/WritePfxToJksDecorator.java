package com.liumapp.keywordsign.core.decorators;

import com.liumapp.keywordsign.core.KeywordSign;
import com.liumapp.keywordsign.core.pfx.PfxHandler;
import com.liumapp.keywordsign.core.pfx.impl.PfxHandlerFactory;
import com.liumapp.keywordsign.core.templates.impl.KeywordSignTemplate;

/**
 * file WritePfxToJksDecorator.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class WritePfxToJksDecorator extends KeywordSignTemplate {

    private PfxHandler pfxHandler = PfxHandlerFactory.getInstance();

    public WritePfxToJksDecorator(KeywordSign keywordSign) {
        super(keywordSign);
    }

    @Override
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String signReason,
                                    String signLocation, String keyword, String timestampUrl) {
        return super.signWithTimeStamp(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, signReason,
                signLocation, keyword, timestampUrl);
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String signReason,
                       String signLocation, String keyword) {
        return super.sign(ksFileName, ksPassword, certAlias, certPassword, pdfBase64, signPic, signFiled, signReason,
                signLocation, keyword);
    }

    @Override
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String signReason,
                                    String signLocation, String keyword, String timestampUrl) {
        pfxHandler.writePfxToKeyStore(ksFileName, ksPassword, certAlias, pfxBase64, pfxPassword);
        return super.signWithTimeStamp(ksFileName, ksPassword, certAlias, pfxPassword, pdfBase64, signPic, signFiled, signReason,
                signLocation, keyword, timestampUrl);
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String signReason,
                       String signLocation, String keyword) {
        pfxHandler.writePfxToKeyStore(ksFileName, ksPassword, certAlias, pfxBase64, pfxPassword);
        return super.sign(ksFileName, ksPassword, certAlias, pfxPassword, pdfBase64, signPic, signFiled, signReason,
                signLocation, keyword);
    }
}
