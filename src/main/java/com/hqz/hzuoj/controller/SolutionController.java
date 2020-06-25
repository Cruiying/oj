package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.Solution;
import com.hqz.hzuoj.service.SolutionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Solution)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("solution")
public class SolutionController {
    /**
     * 服务对象
     */
    @Resource
    private SolutionService solutionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Solution selectOne(Integer id) {
        return this.solutionService.queryById(id);
    }

}
