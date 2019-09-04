package com.liumapp.keywordsign.core.templates.impl;

import com.liumapp.keywordsign.core.KeywordSign;
import com.liumapp.keywordsign.core.templates.Template;

/**
 * file KeywordSignTemplate.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public abstract class KeywordSignTemplate implements Template, KeywordSign {

    public KeywordSign keywordSign;

    public KeywordSignTemplate(KeywordSign keywordSign) {
        this.keywordSign = keywordSign;
    }

}
