package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.ProblemExample;
import com.hqz.hzuoj.service.ProblemExampleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProblemExample)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("problemExample")
public class ProblemExampleController {
    /**
     * 服务对象
     */
    @Resource
    private ProblemExampleService problemExampleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProblemExample selectOne(Integer id) {
        return this.problemExampleService.queryById(id);
    }

}
