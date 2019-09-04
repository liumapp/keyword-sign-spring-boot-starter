package com.liumapp.keywordsign.core.utils;

import com.liumapp.qtools.file.base64.Base64FileTool;
import org.bouncycastle.util.encoders.Base64;

import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;

/**
 * author liumapp
 * file PfxUtil.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/8/2
 */
public class PfxUtil {

    /**
     * pfx into jks method
     * @param INpfxpath pfx file path
     * @param pfxPWD pfx file password
     * @param outJKSpath jks path
     * @param jksPWD jks password
     * @param certpath export cert path
     * @throws NoSuchAlgorithmException exception
     * @throws KeyStoreException exception
     * @throws UnrecoverableKeyException exception
     * @throws KeyStoreException exception
     * @throws CertificateException exception
     * @throws NoSuchAlgorithmException exception
     */
    public void Pfx2NewJKS(String INpfxpath, String pfxPWD, String outJKSpath, String jksPWD , String certpath) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, KeyStoreException, CertificateException, NoSuchAlgorithmException {

        KeyStore inputKeyStore = KeyStore.getInstance("PKCS12");
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(INpfxpath);
            // 将PKCS12格式的数字证书转写入到密钥容器
            try {
                inputKeyStore.load(inputStream, pfxPWD.toCharArray());
                inputStream.close();
                KeyStore keyStoreOutPut = KeyStore.getInstance("JKS");
                keyStoreOutPut.load(null, jksPWD.toCharArray());
                Enumeration enums = inputKeyStore.aliases();
                while (enums.hasMoreElements()) {
                    String keyAlias = (String) enums.nextElement();
                    if (inputKeyStore.isKeyEntry(keyAlias)) {
                        Key key = inputKeyStore.getKey(keyAlias, pfxPWD.toCharArray());
                        Certificate[] certChain = inputKeyStore.getCertificateChain(keyAlias);
                        keyStoreOutPut.setKeyEntry(keyAlias, key, jksPWD.toCharArray(), certChain);

                        //Certificate certificate = new Certificate(certChain[0].getEncoded());
                        System.out.println("公钥证书base64"+new String(Base64.encode(certChain[0].getEncoded())));
                        //System.out.println("证书序列号"+certificate.serialNumber());

                        certChain[0].getEncoded();

                        if (certpath != null) {
                            FileOutputStream out1 = new FileOutputStream(certpath);
                            out1.write(	certChain[0].getEncoded());
                            out1.close();
                        }

                    }
                }
                FileOutputStream out = new FileOutputStream(outJKSpath);
                keyStoreOutPut.store(out, jksPWD.toCharArray());
                out.close();
            } catch (CertificateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * pfx into jks method
     * @param INpfxpath pfx file path
     * @param pfxPWD pfx file password
     * @param JKSpath jks path
     * @param jksPWD jks password
     * @param certpath export cert path
     * @throws NoSuchAlgorithmException exception
     * @throws KeyStoreException exception
     * @throws UnrecoverableKeyException exception
     * @throws KeyStoreException exception
     * @throws CertificateException exception
     * @throws NoSuchAlgorithmException exception
     */
    public void Pfx2OldJKS(String INpfxpath, String pfxPWD, String JKSpath, String jksPWD , String certpath, String alias) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, KeyStoreException, CertificateException, NoSuchAlgorithmException {

        KeyStore inputKeyStore = KeyStore.getInstance("PKCS12");
        FileInputStream inputStream;
        FileInputStream readJKS;
        try {
            inputStream = new FileInputStream(INpfxpath);
            // 将PKCS12格式的数字证书转写入到密钥容器
            try {
                inputKeyStore.load(inputStream, pfxPWD.toCharArray());
                inputStream.close();
                KeyStore keyStoreOutPut = KeyStore.getInstance("JKS");

                readJKS = new FileInputStream(JKSpath);
                keyStoreOutPut.load(readJKS, jksPWD.toCharArray());
                readJKS.close();

                Enumeration enums = inputKeyStore.aliases();
                while (enums.hasMoreElements()) {
                    String keyAlias = (String) enums.nextElement();
                    if (inputKeyStore.isKeyEntry(keyAlias)) {
                        Key key = inputKeyStore.getKey(keyAlias, pfxPWD.toCharArray());
                        Certificate[] certChain = inputKeyStore.getCertificateChain(keyAlias);
                        keyStoreOutPut.setKeyEntry(alias, key, pfxPWD.toCharArray(), certChain);
                        certChain[0].getEncoded();
                        if (certpath != null) {
                            FileOutputStream out1 = new FileOutputStream(certpath);
                            out1.write(	certChain[0].getEncoded());
                            out1.close();
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(JKSpath);
                keyStoreOutPut.store(out, jksPWD.toCharArray());
                out.close();
            } catch (CertificateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void PfxBase642JKS(String pfxBase64, String pfxPWD, String JKSpath, String jksPWD , String alias) throws Exception {
        KeyStore inputKeyStore = KeyStore.getInstance("PKCS12");
        ByteArrayInputStream inputStream;
        FileInputStream readJKS;

        inputStream = Base64FileTool.decodeBase64ToInputStream(pfxBase64);

        // 将PKCS12格式的数字证书转写入到密钥容器
        inputKeyStore.load(inputStream, pfxPWD.toCharArray());
        inputStream.close();
        KeyStore keyStoreOutPut = KeyStore.getInstance("JKS");

        readJKS = new FileInputStream(JKSpath);
        keyStoreOutPut.load(readJKS, jksPWD.toCharArray());
        readJKS.close();

        Enumeration enums = inputKeyStore.aliases();
        while (enums.hasMoreElements()) {
            String keyAlias = (String) enums.nextElement();
            if (inputKeyStore.isKeyEntry(keyAlias)) {
                Key key = inputKeyStore.getKey(keyAlias, pfxPWD.toCharArray());
                Certificate[] certChain = inputKeyStore.getCertificateChain(keyAlias);
                keyStoreOutPut.setKeyEntry(alias, key, pfxPWD.toCharArray(), certChain);
                certChain[0].getEncoded();
            }
        }
        FileOutputStream out = new FileOutputStream(JKSpath);
        keyStoreOutPut.store(out, jksPWD.toCharArray());
        out.close();
    }

    /**
     * @param baseContent base64 content of pfx file
     * @param savePath pfx file save path
     */
    public void makePfxFileByBase64 (String baseContent, String savePath, String savename) throws IOException {
        String pfxPath = savePath + "/" + savename;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(pfxPath));
            fileOutputStream.write(Base64.decode(baseContent));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new IOException("生成pfx文件失败，请检查保存目录是否有效或具备写权限：" + pfxPath);
        }
    }

}
