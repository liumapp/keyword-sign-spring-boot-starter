package com.liumapp.keywordsign.core.location;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.keywordsign.core.dto.KeywordLocationDTO;
import com.liumapp.keywordsign.core.job.JobDetail;
import lombok.Data;

/**
 * file KeywordLocation.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/3
 */
@Data
public class KeywordLocation extends JobDetail <KeywordLocationDTO> {

    @Override
    public JSONObject handle(KeywordLocationDTO data) {
        return null;
    }

}
