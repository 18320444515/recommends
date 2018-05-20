package com.wxtrick.recommends.doc;

/**
 * @author tianyi
 * @date 2018-04-30 16:11
 */
public class MovieDoc {
    /**
     *  @apiDefine ResultVO
     *  @apiSuccess {Integer} resultCode 响应结果
     *  @apiSuccess {String} resultMsg 错误信息
     *  @apiSuccess {Object} data 主体信息
     */

    /**
     * @apiDefine Movie Movie
     */

    /**
     * @api {post} /add/movie 添加电影信息
     * @apiGroup Movie
     * @apiParam {int} doubanId 豆瓣对应id
     * @apiParam {String} reason 推荐理由
     * @apiParam {File} moviePicture 电影海报
     * @apiSuccessExample Success-Request:
     * {
     *     doubanId:2257094,
    reason:很阳很活泼的女主，↵很美丽的精神，最终这故事连回忆都没有给他们留下。但观众们久久不能忘记。
    (还有 moviePicture)
     * }
     * @apiUse ResultVO
     * @apiSuccessExample Success-Response:
     *{
    "resultCode": 200,
    "resultMsg": "成功",
    "data": {
    "id": 12,
    "doubanId": 2257094,
    "qiniuUrl": "http://p7xnxhjxx.bkt.clouddn.com/Fj-6lmVFGQWrragNvLXVrEGyCpvU",
    "reason": "很阳很活泼的女主，\r\n很美丽的精神，最终这故事连回忆都没有给他们留下。但观众们久久不能忘记。"
    }
    }
     */
    void addMovie(){

    }

    /**
     * @api {get} /get/movie 获取电影信息
     * @apiGroup Movie
     * @apiParam {int} null 此接口无需传参
     * @apiUse ResultVO
     * @apiSuccessExample Success-Response:
     * {
    "resultCode": 200,
    "resultMsg": "成功",
    "data": [
        {
        "id": 2,
        "doubanId": 2257094,
        "qiniuUrl": "1",
        "reason": "很阳很活泼的女主，\r\n很美丽的精神，最终这故事连回忆都没有给他们留下。但观众们久久不能忘记。"
        }
        ]
        }
     */
    void getMovie(){

    }

    /**
     * @api {post} /update/movie 修改电影信息
     * @apiGroup Movie
     * @apiParam {Integer} id 数据对应id
     * @apiParam {int} doubanId 电影对应豆瓣id号
     * @apiParam {String} reason 推荐理由
     * @apiSuccessExample Success-Request:
     * {
     *     id:2,
    doubanId:2257094,
    reason:"aaaaaaaaaaaaaaaa很阳很活泼的女主，\r\n很美丽的精神，最终这故事连回忆都没有给他们留下。但观众们久久不能忘记。"
     * }
     * @apiUse ResultVO
     * @apiSuccessExample Success-Response:
     * {
    "resultCode": 200,
    "resultMsg": "成功",
    "data": {
    "id": 2,
    "doubanId": 2257094,
    "qiniuUrl": "1",
    "reason": "\"aaaaaaaaaaaaaaaa很阳很活泼的女主，\\r\\n很美丽的精神，最终这故事连回忆都没有给他们留下。但观众们久久不能忘记。\""
    }
    }
     */
    void updateMovie(){

    }

    /**
     * @api {post} /delete/movie 删除电影信息
     * @apiGroup Movie
     * @apiParam {Integer} guessID 要删除的数据对应的id，保密作用
     * @apiSuccessExample Success-Request:
     * {
     *     guessID:2
     * }
     * @apiUse ResultVO
     * @apiSuccessExample Success-Response:
     * {
    "resultCode": 200,
    "resultMsg": "成功",
    "data": null
    }
     */
    void deleteMovie(){

    }
}
