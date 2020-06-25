package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.Contest;
import com.hqz.hzuoj.service.ContestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Contest)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("contest")
public class ContestController {
    /**
     * 服务对象
     */
    @Resource
    private ContestService contestService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Contest selectOne(Integer id) {
        return this.contestService.queryById(id);
    }

}
