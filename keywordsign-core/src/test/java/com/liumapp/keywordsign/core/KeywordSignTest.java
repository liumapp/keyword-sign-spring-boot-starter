package com.liumapp.keywordsign.core;

import com.liumapp.keywordsign.core.config.KeywordSignConfig;
import com.liumapp.keywordsign.core.config.KeywordSignConfigFactory;
import com.liumapp.qtools.date.DateTool;
import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.security.encrypt.Sha1Tool;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * file KeywordSignTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeywordSignTest {

    @Test
    public void testSign () throws IOException {
        KeywordSign keywordSign = KeywordSignFactory.getInstance();
        String signedPdfBase64 = keywordSign.sign("./data/demo.ks",
                "123456",
                "liumapp",
                Base64FileTool.filePathToBase64("./data/liumapp.pfx"),
                "123123123",
                Base64FileTool.filePathToBase64("./data/test.pdf"),
                Base64FileTool.filePathToBase64("./data/me.jpg"),
                "signFiled1",
                "this is sign reason",
                "this is sign location",
                "year"
                );
        Base64FileTool.saveBase64File(signedPdfBase64, "./data/result.pdf");
    }

    @Test
    public void testSign2 () throws IOException {
        KeywordSignConfig keywordSignConfig = KeywordSignConfigFactory.getInstance();
        keywordSignConfig.setBeforeKeywordSymbol("");
        keywordSignConfig.setAfterKeywordSymbok("");
        keywordSignConfig.setXDeviation(50);
        keywordSignConfig.setYDeviation(-50);
        KeywordSign keywordSign = KeywordSignFactory.getInstance();
        String signedPdfBase64 = keywordSign.sign("./data/demo.ks",
                "123456",
                "liumapp",
                Base64FileTool.filePathToBase64("./data/liumapp.pfx"),
                "123123123",
                Base64FileTool.filePathToBase64("./data/test2.pdf"),
                Base64FileTool.filePathToBase64("./data/signPic1.png"),
                "signFiled1",
                "this is sign reason",
                "this is sign location",
                "甲方签署"
        );
        Base64FileTool.saveBase64File(signedPdfBase64, "./data/result2_1.pdf");

        String signedPdfBase642 = keywordSign.sign("./data/demo.ks",
                "123456",
                "liumapp",
                Base64FileTool.filePathToBase64("./data/liumapp.pfx"),
                "123123123",
                Base64FileTool.filePathToBase64("./data/result2_1.pdf"),
                Base64FileTool.filePathToBase64("./data/signPic2.png"),
                "signFiled2",
                "this is sign reason",
                "this is sign location",
                "乙方签署"
        );
        Base64FileTool.saveBase64File(signedPdfBase642, "./data/result2_2.pdf");
    }


}