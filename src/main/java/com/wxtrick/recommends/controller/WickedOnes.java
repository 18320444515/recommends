package com.wxtrick.recommends.controller;

import com.wxtrick.recommends.VO.ResultVO;
import com.wxtrick.recommends.entity.ClassicMusic;
import com.wxtrick.recommends.entity.NatureMusic;
import com.wxtrick.recommends.repository.ClassicMusicRepository;
import com.wxtrick.recommends.repository.NatureMusicRepository;
import com.wxtrick.recommends.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author tianyi
 * @date 2018-05-26 13:07
 */
@Slf4j
@RestController
@RequestMapping("/weather")
public class WickedOnes {

    @Autowired
    private NatureMusicRepository natureMusicRepository;

    @Autowired
    private ClassicMusicRepository classicMusicRepository;

    @GetMapping("lifestyle/{longitude}/{latitude}")
    public ResultVO getLifeStyleCode(@PathVariable(value = "longitude") double lg, @PathVariable(value = "latitude") double la){
        try {
            //log.warn(lg+","+la);
            //定义url
            URL url=new URL("https://free-api.heweather.com/s6/weather/lifestyle?parameters&location="+lg+","+la+"&key=c15b52d96b6045478c846c70881bfd5f&");
            //log.warn(String.valueOf(url));
            //生成url连接
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            //访问url
            connection.setRequestMethod("GET");
            connection.connect();
            // 连接发起请求,处理服务器响应 (从连接获取到输入流并包装为bufferedReader)
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder(); // 用来存储响应数据

            // 循环读取流,若不到结尾处
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }
            bf.close(); // 重要且易忽略步骤 (关闭流,切记!)
            connection.disconnect(); // 销毁连接


            JSONObject deal= JSONObject.fromObject(sb.toString());
            JSONArray temp1= deal.getJSONArray("HeWeather6");
            JSONObject temp2=temp1.getJSONObject(0);
            JSONArray lifestyle=temp2.getJSONArray("lifestyle");
            JSONObject rt=new JSONObject();
            StringBuffer sbf=new StringBuffer("");
            for (int i=0;i<lifestyle.size();i++){
                switch (i){
                    case 1:
                        //穿衣指数
                        rt.put("drsg",lifestyle.get(i));
                        sbf.append(ToNum(lifestyle.getJSONObject(i).get("brf").toString(),i));break;
                    case 3:
                        //运动指数
                        rt.put("sport",lifestyle.get(i));
                        sbf.append(ToNum(lifestyle.getJSONObject(i).get("brf").toString(),i));break;
                    case 5:
                        //紫外线指数
                        rt.put("uv",lifestyle.get(i));
                        sbf.append(ToNum(lifestyle.getJSONObject(i).get("brf").toString(),i));break;
                    case 7:
                        //空气污染扩散指数
                        rt.put("air",lifestyle.get(i));
                        sbf.append(ToNum(lifestyle.getJSONObject(i).get("brf").toString(),i));break;
                    default:
                        ;break;
                }
            }
            rt.put("stylecode",sbf.toString());
            log.warn(rt.toString());

            //return ResultVOUtil.success();
            return ResultVOUtil.success(rt);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultVOUtil.error(442,"获取生活指数失败");
        //return JSONObject.fromObject("{}");
    }

    private static int ToNum(String brf,int i) {
        //若有错则返回0
        int rt=0;
        switch (i){
            case 1:{
                //穿衣指数 炎热	热	舒适	 较舒适	较冷 冷	寒冷
                switch (brf){
                    case "炎热":return 1;
                    case "热":return 2;
                    case "舒适":return 3;
                    case "较舒适":return 4;
                    case "较冷":return 5;
                    case "冷":return 6;
                    case "寒冷":return 7;
                }
            }break;
            case 3: {
                //运动指数 适宜	较适宜	较不宜
                switch (brf){
                    case "适宜":return 1;
                    case "较适宜":return 2;
                    case "较不宜":return 3;
                }
            }break;
            case 5: {
                //紫外线指数 最弱 弱	中等 强	很强
                switch (brf){
                    case "最弱":return 1;
                    case "弱":return 2;
                    case "中等":return 3;
                    case "强":return 4;
                    case "很强":return 5;
                }
            }break;
            case 7: {
                //空气污染扩散指数 优	 良	中	较差	 很差
                switch (brf){
                    case "优":return 1;
                    case "良":return 2;
                    case "中":return 3;
                    case "较差":return 4;
                    case "很差":return 5;
                }
            }break;
            default:
                ;break;
        }
        return rt;
    }

    @PostMapping("/post/nature")
    public ResultVO postNatureMusic(@RequestParam(value = "name")String name,
                                    @RequestParam(value = "url")String url){
        if (natureMusicRepository.findByName(name)!=null){
            return ResultVOUtil.error(411,"同名文件已存在，请移步修改接口");
        }else {
            NatureMusic natureMusic=new NatureMusic();
            natureMusic.setName(name);
            natureMusic.setUrl(url);
            return ResultVOUtil.success(natureMusicRepository.save(natureMusic));
        }
    }

    @PostMapping("/post/classic")
    public ResultVO postClassicMusic(@RequestParam(value = "name")String name,
                                    @RequestParam(value = "url")String url){
        if (classicMusicRepository.findByName(name)!=null){
            return ResultVOUtil.error(411,"同名文件已存在，请移步修改接口");
        }else {
            ClassicMusic classicMusic=new ClassicMusic();
            classicMusic.setName(name);
            classicMusic.setUrl(url);
            return ResultVOUtil.success(classicMusicRepository.save(classicMusic));
        }
    }

    @PostMapping("/update/nature")
    public ResultVO updateNatureMusic(@RequestParam(value = "id")int id,
                                      @RequestParam(value = "name")String name,
                                    @RequestParam(value = "url")String url){
        NatureMusic natureMusic=natureMusicRepository.findById(id);
        if (natureMusic==null){
            return ResultVOUtil.error(422,"同名文件不存在，请移步新增音乐接口");
        }else {
            natureMusic.setName(name);
            natureMusic.setUrl(url);
            return ResultVOUtil.success(natureMusicRepository.save(natureMusic));
        }
    }

    @PostMapping("/update/classic")
    public ResultVO updateClassicMusic(@RequestParam(value = "id")int id,
                                       @RequestParam(value = "name")String name,
                                     @RequestParam(value = "url")String url){
        ClassicMusic classicMusic=classicMusicRepository.findById(id);
        if (classicMusic==null){
            return ResultVOUtil.error(422,"同名文件不存在，请移步新增音乐接口");
        }else {
            classicMusic.setName(name);
            classicMusic.setUrl(url);
            return ResultVOUtil.success(classicMusicRepository.save(classicMusic));
        }
    }

    @PostMapping("/delete/nature")
    public ResultVO deleteNatureMusic(@RequestParam(value = "name")String name){
        NatureMusic natureMusic=natureMusicRepository.findByName(name);
        if (natureMusic==null){
            return ResultVOUtil.error(422,"同名文件不存在，请移步新增音乐接口");
        }else {
            natureMusicRepository.delete(natureMusic);
            return ResultVOUtil.success();
        }
    }

    @PostMapping("/delete/classic")
    public ResultVO deleteClassicMusic(@RequestParam(value = "name")String name){
        ClassicMusic classicMusic=classicMusicRepository.findByName(name);
        if (classicMusic==null){
            return ResultVOUtil.error(422,"同名文件不存在，请移步新增音乐接口");
        }else {
            classicMusicRepository.delete(classicMusic);
            return ResultVOUtil.success();
        }
    }

    @GetMapping("/get/nature")
    public ResultVO getNatureMusicAll(){
        return ResultVOUtil.success(natureMusicRepository.findAll());
    }

    @GetMapping("/get/classic")
    public ResultVO getClassicMusicAll(){
        return ResultVOUtil.success(classicMusicRepository.findAll());
    }
}
