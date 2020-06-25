package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.JudgeResult;
import com.hqz.hzuoj.service.JudgeResultService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (JudgeResult)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("judgeResult")
public class JudgeResultController {
    /**
     * 服务对象
     */
    @Resource
    private JudgeResultService judgeResultService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public JudgeResult selectOne(Integer id) {
        return this.judgeResultService.queryById(id);
    }

}