package com.liumapp.keywordsign.core.signpic.impl;

import com.liumapp.keywordsign.core.exceptions.KeyStoreException;
import com.liumapp.keywordsign.core.signpic.SignPic;
import com.liumapp.qtools.file.base64.Base64FileTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * file SignPicCore.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/5
 */
public class SignPicCore implements SignPic {

    protected SignPicCore() {
    }

    @Override
    public int[] readWidthAndHeightFromBase64Pic(String picBase64) {
        int[] result = new int[2];
        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(Base64FileTool.decodeBase64ToInputStream(picBase64));
            int width          = bimg.getWidth();
            int height         = bimg.getHeight();
            result[0] = width;
            result[1] = height;
        } catch (IOException e) {
            throw new KeyStoreException("读取签名图片出现异常", e.getCause());
        }

        return result;
    }

}
