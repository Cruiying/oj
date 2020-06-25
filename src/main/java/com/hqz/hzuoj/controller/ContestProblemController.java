package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.ContestProblem;
import com.hqz.hzuoj.service.ContestProblemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ContestProblem)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("contestProblem")
public class ContestProblemController {
    /**
     * 服务对象
     */
    @Resource
    private ContestProblemService contestProblemService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ContestProblem selectOne(Integer id) {
        return this.contestProblemService.queryById(id);
    }

}
