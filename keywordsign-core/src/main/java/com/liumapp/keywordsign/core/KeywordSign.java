package com.liumapp.keywordsign.core;

/**
 * file KeywordSign.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public interface KeywordSign {

    public void checkKeyStore (String ksFileName);

    public void installPfx ();

    public void checkKeyWord ();

    public void signWithoutTimeStamp ();

    public void signWithTimeStamp ();

    public void sign ();

}
