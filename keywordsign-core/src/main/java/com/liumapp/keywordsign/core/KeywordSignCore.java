package com.liumapp.keywordsign.core;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.signatures.*;
import com.liumapp.keywordsign.core.config.KeywordSignConfigFactory;
import com.liumapp.keywordsign.core.exceptions.KeyStoreException;
import com.liumapp.keywordsign.core.keyword.Keyword;
import com.liumapp.keywordsign.core.keyword.impl.KeywordFactory;
import com.liumapp.qtools.date.DateTool;
import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.security.encrypt.Sha1Tool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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

    private Keyword keyword = KeywordFactory.getInstance();

    /**
     * 不需要做任何操作，保留即可
     * 在装饰类WritePfxToJksDecorator中已经解决
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
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String signReason,
                                    String signLocation, String keyword, String timestampUrl) {
        return null;
    }

    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String certPassword, String pdfBase64, String signPic, String signFiled, String signReason,
                       String signLocation, String keyword) {
        return this.signWithTimeStamp(ksFileName,
                ksPassword,
                certAlias,
                certPassword,
                pdfBase64, signPic,
                signFiled,
                signReason,
                signLocation,
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
    public String signWithTimeStamp(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled,String signReason,
                                    String signLocation,  String keyword, String timestampUrl) {
        ByteArrayOutputStream resultStream = null;
        try {
            resultStream = new ByteArrayOutputStream();
            PdfReader pdfReader = new PdfReader(Base64FileTool.decodeBase64ToInputStream(pdfBase64));
            PdfSigner signer = new PdfSigner(pdfReader, resultStream, false);
            // Creating the appearance
            PdfSignatureAppearance appearance = signer.getSignatureAppearance()
                    .setReason(signReason)
                    .setLocation(signLocation)
                    .setReuseAppearance(false);
            Rectangle rect = new Rectangle(36, 648, 200, 100);
            appearance
                    .setPageRect(rect)
                    .setPageNumber(1);
            signer.setFieldName(signFiled);
            // Creating the signature
            IExternalSignature pks = new PrivateKeySignature(pk, digestAlgorithm, provider);
            IExternalDigest digest = new BouncyCastleDigest();
            signer.signDetached(digest, pks, chain, null, null, null, 0, subfilter);
        } catch (Exception e) {
            throw new KeyStoreException("签署PDF失败", e.getCause());
        }
        return null;
    }



    @Override
    public String sign(String ksFileName, String ksPassword, String certAlias, String pfxBase64, String pfxPassword, String pdfBase64, String signPic, String signFiled, String signReason,
                       String signLocation, String keyword) {
        return this.signWithTimeStamp(ksFileName,
                ksPassword,
                certAlias,
                pfxBase64,
                pfxPassword,
                pdfBase64, signPic,
                signFiled,
                signReason,
                signLocation,
                keyword,
                KeywordSignConfigFactory.getInstance().getTimeStampUrl() + Sha1Tool.toSHA1(DateTool.getSimpleUTCDateString() + "_" + KeywordSignConfigFactory.getInstance().getTimeStampCode())
        );
    }
}
