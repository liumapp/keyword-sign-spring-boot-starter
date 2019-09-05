package com.liumapp.keywordsign.core.signpic.impl;

import com.liumapp.keywordsign.core.signpic.SignPic;
import com.liumapp.qtools.file.base64.Base64FileTool;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * file SignPicCoreTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/5
 */
public class SignPicCoreTest {

    @Test
    public void readWidthAndHeightFromBase64Pic() throws IOException {
        SignPic signPic = SignPicFactory.getInstance();
        int[] result = signPic.readWidthAndHeightFromBase64Pic(Base64FileTool.filePathToBase64("./data/me.jpg"));
        System.out.println("width is : " + result[0] + " and height is : " + result[1]);
        Assert.assertEquals(568, result[0]);
        Assert.assertEquals(568, result[1]);
    }
}