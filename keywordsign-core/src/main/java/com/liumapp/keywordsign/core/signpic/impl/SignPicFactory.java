package com.liumapp.keywordsign.core.signpic.impl;

import com.liumapp.keywordsign.core.signpic.SignPic;

/**
 * file SignPicFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/5
 */
public class SignPicFactory {

    private SignPic signPic;

    private SignPicFactory() {
    }

    private static class SignPicFactoryHolder {
        private static final SignPicFactory INSTANCE = new SignPicFactory();
    }

    public static SignPic getInstance () {
        return SignPicFactoryHolder.INSTANCE.getSignPic();
    }

    public SignPic getSignPic() {
        if (this.signPic == null) {
            this.signPic = new SignPicCore();
        }
        return this.signPic;
    }
}
