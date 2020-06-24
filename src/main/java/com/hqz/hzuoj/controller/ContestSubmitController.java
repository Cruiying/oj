package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.ContestSubmit;
import com.hqz.hzuoj.service.ContestSubmitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ContestSubmit)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("contestSubmit")
public class ContestSubmitController {
    /**
     * 服务对象
     */
    @Resource
    private ContestSubmitService contestSubmitService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ContestSubmit selectOne(Integer id) {
        return this.contestSubmitService.queryById(id);
    }

}
