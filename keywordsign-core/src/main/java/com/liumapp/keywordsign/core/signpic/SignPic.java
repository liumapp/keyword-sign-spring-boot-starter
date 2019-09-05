package com.liumapp.keywordsign.core.signpic;

/**
 * file SignPic.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/5
 */
public interface SignPic {

    /**
     * 根据图片的base64读取图片宽高数据
     * int[0] : width
     * int[1] : height
     * @param picBase64
     * @return
     */
    public int[] readWidthAndHeightFromBase64Pic (String picBase64);

}
