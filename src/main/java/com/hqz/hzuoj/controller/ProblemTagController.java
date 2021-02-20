package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.ProblemTag;
import com.hqz.hzuoj.service.ProblemTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProblemTag)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("problemTag")
public class ProblemTagController {
    /**
     * 服务对象
     */
    @Resource
    private ProblemTagService problemTagService;



}
