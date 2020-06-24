package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.Submit;
import com.hqz.hzuoj.service.SubmitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Submit)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("submit")
public class SubmitController {
    /**
     * 服务对象
     */
    @Resource
    private SubmitService submitService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Submit selectOne(Integer id) {
        return this.submitService.queryById(id);
    }

}
