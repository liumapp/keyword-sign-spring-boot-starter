package com.liumapp.keywordsign.core.pfx.impl;

import com.liumapp.keywordsign.core.pfx.PfxHandler;

/**
 * file PfxHandlerFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class PfxHandlerFactory {

    private PfxHandler pfxHandler;

    private static class PfxHandlerFactoryHolder {
        private static final PfxHandlerFactory INSTANCE = new PfxHandlerFactory();
    }

    private PfxHandlerFactory() {

    }

    public static PfxHandler getInstance () {
        return PfxHandlerFactoryHolder.INSTANCE.getPfxHandler();
    }

    public PfxHandler getPfxHandler() {
        if (this.pfxHandler == null) {
            this.pfxHandler = new PfxCoreHandler();
        }
        return this.pfxHandler;
    }
}
