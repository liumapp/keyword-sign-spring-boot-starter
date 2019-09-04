package com.liumapp.keywordsign.core.sign;

/**
 * file DigitalSign.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public interface DigitalSign {

    /**
     * 执行合同签署
     * @param keystoreFile 证书容器
     * @param keystorePassword 证书容器密码
     * @param certAlias 证书别名
     * @param certPassword 证书密码
     * @param pdfBase64 PDF合同base64
     * @param signPicBase64 签章图片base64
     * @param X 左下角X
     * @param Y 左下角Y
     * @param picWith 签章图片宽度
     * @param picHeight 签章图片高度
     * @param signFiled 签名字段
     * @return 签署成功后的PDF合同Base64
     */
    public String signPDF (String keystoreFile,
                         String keystorePassword,
                         String certAlias,
                         String certPassword,
                         String pdfBase64,
                         String signPicBase64,
                         Float X,
                         Float Y,
                         Float picWith,
                         Float picHeight,
                         String signFiled
    );

}
