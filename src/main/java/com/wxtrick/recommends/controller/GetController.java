package com.wxtrick.recommends.controller;

import com.wxtrick.recommends.VO.ResultVO;
import com.wxtrick.recommends.repository.AboutMsgRepository;
import com.wxtrick.recommends.repository.MovieRepository;
import com.wxtrick.recommends.utils.ResultVOUtil;
import com.wxtrick.recommends.utils.ToolUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 获取操作
 * @author tianyi
 * @date 2018-04-29 01:45
 */
@Slf4j
@RestController
@RequestMapping("/recommends/get")
public class GetController {

    @Autowired
    private AboutMsgRepository aboutMsgRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/about")
    public ResultVO about(){
        return ResultVOUtil.success(aboutMsgRepository.findAll());
    }

    @GetMapping("/movie")
    public ResultVO movie(){
        return ResultVOUtil.success(movieRepository.findAll());
    }

    @GetMapping("/detail/{doubanId}")
    public JSONObject doubanMovie(@PathVariable(value = "doubanId") int doubanId){
        try {

            URL url=new URL("http://api.douban.com/v2/movie/subject/"+doubanId);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            byte[] response = new byte[is.available()];
            is.read(response);
            is.close();
            if (response == null || response.length == 0) {
               //return ResultVOUtil.error(441,"获取豆瓣详情失败");
            }
            String rt = new String(response, "UTF-8");
            JSONObject deal=ToolUtil.badString(rt);
            Iterator iterator = deal.keys();
            ArrayList<String> toDelete=new ArrayList<>();
            while(iterator.hasNext()){
                Object key = iterator.next();
                //log.error("key={},value={}",key,deal.get(key));
                if (deal.get(key).toString().isEmpty()||deal.get(key).toString().equals("null")){
                    toDelete.add(key.toString());
                    //log.warn("addDelete={}",key.toString());
                };
            }
            for (String per:
                 toDelete) {
                deal.remove(per);
            }
            deal.remove("directors");
            //log.error("json={}",deal);
            Iterator again = deal.keys();
            while(again.hasNext()){
                Object key = again.next();
                if (!(deal.get(key).toString().isEmpty()||deal.get(key).toString().equals("null"))){
                    //log.error("key={},value={}",key,deal.get(key));
                };
            }
            log.info("ID={},《电影》={}",doubanId,deal.get("title"));
            // log.info("json={}",deal);
            //return ResultVOUtil.success(JSONObject.fromObject("{a:0,b:[{bb:1},{bb:2}],c:3,d:[\"123\",\"456\",\"789\"]}"));
            //return ResultVOUtil.success(deal);
            return deal;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return ResultVOUtil.error(442,"获取豆瓣详情失败");
        return JSONObject.fromObject("{}");
    }

    /*@GetMapping("/test")
    public ResultVO test(){
        return ResultVOUtil.success(QiniuUtil.getUpToken());
    }*/
}
