package com.wxtrick.recommends.controller;

import com.wxtrick.recommends.VO.ResultVO;
import com.wxtrick.recommends.repository.AboutMsgRepository;
import com.wxtrick.recommends.repository.MovieRepository;
import com.wxtrick.recommends.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianyi
 * @date 2018-04-29 17:32
 */
@RestController
@RequestMapping("/recommends/delete")
@Slf4j
public class DeleteController {
    @Autowired
    private AboutMsgRepository aboutMsgRepository;

    @Autowired
    private MovieRepository movieRepository;

    
    @PostMapping("/movie")
    public ResultVO movie(@RequestParam(value = "guessID")Integer id){
        if (movieRepository.findFirstById(id)!=null){
            movieRepository.deleteById(id);
            return ResultVOUtil.success();
        }else{
            log.error("想要删除的内容不存在");
            return ResultVOUtil.error(444,"Unexist");
        }
    }
}
