package com.wxtrick.recommends.controller;

import com.wxtrick.recommends.VO.ResultVO;
import com.wxtrick.recommends.entity.AboutMsg;
import com.wxtrick.recommends.entity.Movie;
import com.wxtrick.recommends.repository.AboutMsgRepository;
import com.wxtrick.recommends.repository.MovieRepository;
import com.wxtrick.recommends.utils.QiniuUtil;
import com.wxtrick.recommends.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Optional;

/**
 * @author tianyi
 * @date 2018-04-29 17:00
 */
@RestController
@RequestMapping("/update")
@Slf4j
public class UpdateController {
    @Autowired
    private AboutMsgRepository aboutMsgRepository;

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/about")
    public ResultVO about(@RequestParam(value = "version")String version,
                          @RequestParam(value = "mail")String mail){
        AboutMsg aboutMsg=aboutMsgRepository.findFirstById(1);
        if (version!=null){
        aboutMsg.setVersion(version);}
        if (mail!=null){
        aboutMsg.setMail(mail);}
        return ResultVOUtil.success(aboutMsgRepository.save(aboutMsg));
    }

    @PostMapping("/movie")
    public ResultVO movie(@RequestParam(value = "id")Integer id,
                          @RequestParam(value = "doubanId")int doubanId,
                          @RequestParam(value = "reason")String reason,
                          HttpServletRequest request){

        Movie movie=movieRepository.findFirstById(id);
        if (doubanId!=0){
            movie.setDoubanId(doubanId);
        }
        if (reason!=null){
            movie.setReason(reason);
        }
        //转化request
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //获取文件
        MultipartFile file = multipartRequest.getFile("moviePicture");
        if (file!=null){
            try {
                //文件转流
                InputStream input = file.getInputStream();
                //流转byte[]
                byte[] byt = new byte[input.available()];
                input.read(byt);
                //byte[]上传
                String qiniuURL = QiniuUtil.uploadByByte(byt);
                log.info(qiniuURL);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ResultVOUtil.success(movieRepository.save(movie));
    }



}
