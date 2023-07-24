package com.bok.blog.support.res;

import com.bok.blog.support.res.result.ResHead;
import com.bok.blog.support.res.result.ResResult;
import com.bok.blog.support.res.result.ResStatus;

public class ResUtil {

    public static ResResult makeResult(ResStatus status, Object data){
        return ResResult.builder()
                .head(ResHead.builder().result_code(status.getCode()).result_msg(status.getMsg()).build())
                .body(data)
                .build();
    }

    public static ResResult makeResult(String resultCode, String resultMsg,  Object data){
        return ResResult.builder()
                .head(ResHead.builder().result_code(resultCode).result_msg(resultMsg).build())
                .body(data)
                .build();
    }
}
