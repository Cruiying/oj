package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.SubmitCase;
import com.hqz.hzuoj.service.SubmitCaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SubmitCase)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("submitCase")
public class SubmitCaseController {
    /**
     * 服务对象
     */
    @Resource
    private SubmitCaseService submitCaseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SubmitCase selectOne(Integer id) {
        return this.submitCaseService.queryById(id);
    }

}
