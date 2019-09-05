package com.liumapp.keywordsign.core;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.layout.element.Image;
import com.itextpdf.signatures.*;
import com.liumapp.keywordsign.core.config.KeywordSignConfigFactory;
import com.liumapp.keywordsign.core.exceptions.KeyStoreException;
import com.liumapp.keywordsign.core.keystore.KeyStore;
import com.liumapp.keywordsign.core.keystore.impl.KeyStoreFactory;
import com.liumapp.keywordsign.core.keyword.Keyword;
import com.liumapp.keywordsign.core.keyword.impl.KeywordFactory;
import com.liumapp.keywordsign.core.signpic.SignPic;
import com.liumapp.keywordsign.core.signpic.impl.SignPicFactory;
import com.liumapp.qtools.date.DateTool;
import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.security.encrypt.Sha1Tool;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.List;

/**
 * file KeywordSignCore.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/3
 */
class KeywordSignCore implements KeywordSign {

    private Keyword keyWord = KeywordFactory.getInstance();

    private KeyStore keyStore = KeyStoreFactory.getInstance();

    private SignPic signPic = SignPicFactory.getInstance();

    /**
     * 真正做事情的方法
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
        ByteArrayOutputStream resultStream = null;
        try {
            resultStream = new ByteArrayOutputStream();
            PdfReader pdfReader = new PdfReader(Base64FileTool.decodeBase64ToInputStream(pdfBase64));
            PdfSigner signer = new PdfSigner(pdfReader, resultStream, false);

            //暂时只支持单关键词签署
            HashMap<String, Float> keywordPosition = null;
            try {
                List<HashMap<String, Float>> positionList = keyWord.getKeywordPosition(pdfBase64, keyword);
                keywordPosition = positionList.get(positionList.size() - 1);
            } catch (Exception e) {
                throw new KeyStoreException("没有找到合同签署关键词", e.getCause());
            }

            int[] signPicInfo = this.signPic.readWidthAndHeightFromBase64Pic(signPic);

            // Creating the appearance
            PdfSignatureAppearance appearance = signer.getSignatureAppearance()
                    .setReason(signReason)
                    .setLocation(signLocation)
                    .setReuseAppearance(false)
                    .setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC)
                    .setSignatureGraphic(ImageDataFactory.create(Base64FileTool.decodeBase64ToOutputStream(signPic).toByteArray()));
//            Rectangle rect = new Rectangle(keywordPosition.get("x"), keywordPosition.get("y"), signPicInfo[0], signPicInfo[1]);
            //使用固定长高执行签署
            Rectangle rect = new Rectangle(keywordPosition.get("x"), keywordPosition.get("y"), 100, 100);
            int page = Math.round(keywordPosition.get("page"));
            appearance
                    .setPageRect(rect)
                    .setPageNumber(page);
            signer.setFieldName(signFiled);
            // Creating the signature
            PrivateKey pk = keyStore.readPrivateKeyFromKeyStore(
                    ksFileName,
                    ksPassword,
                    certAlias,
                    certPassword
            );
            IExternalSignature pks = new PrivateKeySignature(pk, DigestAlgorithms.SHA256, new BouncyCastleProvider().getName());
            IExternalDigest digest = new BouncyCastleDigest();
            signer.signDetached(digest, pks, keyStore.readCertificateChainFromKeyStore(
                    ksFileName,
                    ksPassword,
                    certAlias,
                    certPassword
            ), null, null,  new TSAClientBouncyCastle(timestampUrl), 0, PdfSigner.CryptoStandard.CMS);
        } catch (Exception e) {
            e.printStackTrace();
            throw new KeyStoreException("签署PDF失败", e.getCause());
        }
        return Base64FileTool.ByteArrayToBase64(resultStream.toByteArray());
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
     * 不需要做任何操作，保留即可
     * 在装饰类WritePfxToJksDecorator中已经解决
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
