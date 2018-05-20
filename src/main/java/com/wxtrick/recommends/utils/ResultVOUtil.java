package com.wxtrick.recommends.utils;

import com.wxtrick.recommends.VO.ResultVO;

/**
 * @author tianyi
 * @date 2018-04-29 01:57
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO rt=new ResultVO();
        rt.setResultCode(200);
        rt.setResultMsg("成功");
        rt.setData(object);
        return rt;
    }

    public static ResultVO success(){return success(null);}

    public static ResultVO error(Integer code, String msg){
        ResultVO rt=new ResultVO();
        rt.setResultCode(code);
        rt.setResultMsg(msg);
        rt.setData(null);
        return rt;
    }
}
