package com.liumapp.keywordsign.core;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.keywordsign.core.job.JobData;
import com.liumapp.keywordsign.core.job.JobDetail;

/**
 * file KeywordSignCore.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/3
 */
public class KeywordSignCore
{
    public JSONObject doJob(JobDetail jobDetail, JobData jobData) {
        return jobDetail.handle(jobData);
    }
}
