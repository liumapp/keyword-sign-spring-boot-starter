package com.liumapp.keywordsign.core.keyword.impl;

import com.liumapp.keywordsign.core.keyword.Keyword;

import java.util.HashMap;
import java.util.List;

/**
 * file KeywordCore.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeywordCore implements Keyword {

    protected KeywordCore () {

    }

    @Override
    public List<HashMap<String, Float>> getKeywordPosition(String pdfBase64, String keyword) {
        return null;
    }

}
