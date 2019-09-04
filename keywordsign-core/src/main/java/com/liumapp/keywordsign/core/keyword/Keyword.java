package com.liumapp.keywordsign.core.keyword;

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
     * 获取关键词x坐标
     * @return
     */
    public Float getKeywordPositionX();

    /**
     * 获取关键词y坐标
     * @return
     */
    public Float getKeywordPositionY();

    /**
     * 设置关键词
     */
    public void buildPositionKeyword(String word);

}
