package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.ProblemData;
import com.hqz.hzuoj.service.ProblemDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProblemData)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("problemData")
public class ProblemDataController {
    /**
     * 服务对象
     */
    @Resource
    private ProblemDataService problemDataService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProblemData selectOne(Integer id) {
        return this.problemDataService.queryById(id);
    }

}
