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

    public String signWithoutTimeStamp (String ksFileName,
                                      String ksPassword,
                                      String certAlias,
                                      String certPassword,
                                      String pdfBase64,
                                      String signPic,
                                      String signFiled,
                                      String keyword
                                      );

    public String signWithoutTimeStamp (String ksFileName,
                                        String ksPassword,
                                        String certAlias,
                                        String pfxBase64,
                                        String pfxPassword,
                                        String pdfBase64,
                                        String signPic,
                                        String signFiled,
                                        String keyword
    );

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

    public String sign (String ksFileName,
                      String ksPassword,
                      String certAlias,
                      String certPassword,
                      String pdfBase64,
                      String signPic,
                      String signFiled,
                      String keyword);



}
