package com.wxtrick.recommends.VO;

import lombok.Data;

/**
 * @author tianyi
 * @date 2018-04-29 01:52
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer resultCode;

    /** 提示信息. */
    private String resultMsg;

    /** 具体内容. */
    private T data;
}
