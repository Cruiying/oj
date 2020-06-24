package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.Problem;
import com.hqz.hzuoj.service.ProblemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Problem)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("problem")
public class ProblemController {
    /**
     * 服务对象
     */
    @Resource
    private ProblemService problemService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Problem selectOne(Integer id) {
        return this.problemService.queryById(id);
    }

}
