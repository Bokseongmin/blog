package com.bok.blog.support.res.result;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ResResult {
    private ResHead head;
    private Object body;
}
