package com.wxtrick.recommends.doc;

/**
 * @author tianyi
 * @date 2018-04-30 16:11
 */
public class AboutDoc {
    /**
     *  @apiDefine ResultVO
     *  @apiSuccess {Integer} resultCode 响应结果
     *  @apiSuccess {String} resultMsg 错误信息
     *  @apiSuccess {Object} data 主体信息
     */

    /**
     * @apiDefine About About
     */

        /**
         * @api {get} /get/about 获取关于信息
         * @apiGroup About
         * @apiParam {int} null 此接口无需传参
         * @apiUse ResultVO
         * @apiSuccessExample Success-Response:
         *{
        "resultCode": 200,
        "resultMsg": "成功",
        "data": [
        {
        "id": 1,
        "version": "v0.0.0",
        "mail": "326640559@qq.com"
        }
        ]
        }
         */
    void getAbout(){

    }
    /**
     * @api {post} /update/about 修改关于信息
     * @apiGroup About
     * @apiParam {String} version 版本号
     * @apiParam {String} mail 联系邮箱
     * @apiSuccessExample Success-Request:
     * {
     *     version:V0.0.1
     *     mail:326640559@qq.com
     * }
     * @apiUse ResultVO
     * @apiSuccessExample Success-Response:
     * {
    "resultCode": 200,
    "resultMsg": "成功",
    "data": {
    "id": 1,
    "version": "V0.0.1",
    "mail": "326640559@qq.com"
    }
    }
     */
    void updateAbout(){

    }

}
