package com.liumapp.keywordsign.core;

/**
 * file KeywordSign.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public interface KeywordSign {

    /**
     * 从keystore中读取证书签署
     * 带有时间戳
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
    public String signWithTimeStamp (String ksFileName,
                                     String ksPassword,
                                     String certAlias,
                                     String pfxBase64,
                                     String pfxPassword,
                                     String pdfBase64,
                                     String signPic,
                                     String signFiled,
                                     String keyword,
                                     String timestampUrl
    );

    /**
     * 直接使用pfx证书签署
     * 带有时间戳
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
    public String signWithTimeStamp (String ksFileName,
                                   String ksPassword,
                                   String certAlias,
                                   String certPassword,
                                   String pdfBase64,
                                   String signPic,
                                   String signFiled,
                                   String keyword,
                                   String timestampUrl
                                     );

    /**
     * 从keystore中读取证书
     * 默认使用带有时间戳的签署
     * @param ksFileName
     * @param ksPassword
     * @param certAlias
     * @param certPassword
     * @param pdfBase64
     * @param signPic
     * @param signFiled
     * @param keyword
     * @return
     */
    public String sign (String ksFileName,
                      String ksPassword,
                      String certAlias,
                      String certPassword,
                      String pdfBase64,
                      String signPic,
                      String signFiled,
                      String keyword);


    /**
     * 直接使用pfx证书签署
     * 默认使用带有时间戳的签署算法
     * @param ksFileName
     * @param ksPassword
     * @param certAlias
     * @param pfxBase64
     * @param pfxPassword
     * @param pdfBase64
     * @param signPic
     * @param signFiled
     * @param keyword
     * @return
     */
    public String sign (String ksFileName,
                        String ksPassword,
                        String certAlias,
                        String pfxBase64,
                        String pfxPassword,
                        String pdfBase64,
                        String signPic,
                        String signFiled,
                        String keyword);

}
