package com.wxtrick.recommends.controller;

import com.wxtrick.recommends.VO.ResultVO;
import com.wxtrick.recommends.entity.Movie;
import com.wxtrick.recommends.repository.AboutMsgRepository;
import com.wxtrick.recommends.repository.MovieRepository;
import com.wxtrick.recommends.utils.QiniuUtil;
import com.wxtrick.recommends.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * 添加操作
 * @author tianyi
 * @date 2018-04-29 01:45
 */
@RestController
@RequestMapping("/recommends/add")
@Slf4j
public class AddController {

    @Autowired
    private AboutMsgRepository aboutMsgRepository;

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/movie")
    public ResultVO movie(@RequestParam(value = "doubanId")int doubanId,
                                  @RequestParam(value = "reason")String reason,
                                  HttpServletRequest request)throws Exception{
        //转化request
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //获取文件
        MultipartFile file = multipartRequest.getFile("moviePicture");
        //文件转流
        InputStream input = file.getInputStream();
        //流转byte[]
        byte[] byt = new byte[input.available()];
        input.read(byt);
        //byte[]上传
        String qiniuURL=QiniuUtil.uploadByByte(byt);
        log.info(qiniuURL);
        //创建对象并存储
        Movie movie=new Movie();
        movie.setDoubanId(doubanId);
        movie.setQiniuUrl(qiniuURL);
        movie.setReason(reason);
        movieRepository.save(movie);
        return ResultVOUtil.success(movie);
    }
}
