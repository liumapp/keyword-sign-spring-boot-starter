package com.liumapp.keywordsign.core.keyword;

import java.util.HashMap;
import java.util.List;

/**
 * file Keyword.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public interface Keyword {

    /**
     * 关键词坐标集合
     * list: 复数个关键词区域的坐标集合
     * map.get("page") : 关键词所在页数
     * map.get("x") : 关键词x坐标
     * map.get("y") : 关键词y坐标
     * float
     * @return
     */
    public List<HashMap<String, Float>> getKeywordPosition (String pdfBase64, String keyword) ;

}
