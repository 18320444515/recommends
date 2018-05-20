package com.wxtrick.recommends.utils;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tianyi
 * @date 2018-04-29 14:15
 */
@Component
@Slf4j
public class QiniuUtil {
    /**基本配置-从七牛管理后台拿到*/
    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static String ACCESS_KEY;
    private static String SECRET_KEY;
    //要上传的空间名--
    private static String spacename;
    private static String openUrl;
    @Value("${qiniu.AK}")
    public void setAccessKey(String accessKey) {
        ACCESS_KEY = accessKey;
    }
    @Value("${qiniu.SK}")
    public void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }
    @Value("${qiniu.spacename}")
    public void setSpacename(String spacename) {
        QiniuUtil.spacename = spacename;
    }
    @Value("${qiniu.openUrl}")
    public void setOpenUrl(String openUrl) {
        QiniuUtil.openUrl = openUrl;
    }

    //构造一个带指定Zone对象的配置类，华南用Zone.zone2()
    static UploadManager uploadManager = new UploadManager(new Configuration(Zone.zone2()));

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public static String getUpToken(){
        log.warn("AK={},SK={},SPACE={},OPENURL={}",ACCESS_KEY,SECRET_KEY,spacename,openUrl);
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        return auth.uploadToken(spacename);
    }

    public static String uploadByByte(byte[] fileByte){
        try{
            //uploadManager.put({文件内容}, {上传后的名称}, getUpToken());
            //默认不指定key的情况下，以文件内容的hash值作为文件名
            Response response=uploadManager.put(fileByte,null,getUpToken());
            //打印返回的信息
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            log.info(putRet.hash);
            return openUrl+"/"+putRet.hash;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "errorInFileUploadByByte";
    }
}
