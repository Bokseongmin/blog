package com.bok.blog.support.res.result;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResHead {
    private String result_code;
    private String result_msg;
}
