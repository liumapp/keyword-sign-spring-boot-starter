package com.liumapp.keywordsign.core.templates.impl;

import com.liumapp.keywordsign.core.Keyword;
import com.liumapp.keywordsign.core.templates.Template;

/**
 * file KeywordDecoratorTemplate.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public abstract class KeywordDecoratorTemplate implements Keyword, Template {

    private Keyword keyword;

    public KeywordDecoratorTemplate(Keyword keyword) {
        this.keyword = keyword;
    }

}
