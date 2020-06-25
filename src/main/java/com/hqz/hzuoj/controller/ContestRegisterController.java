package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.ContestRegister;
import com.hqz.hzuoj.service.ContestRegisterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ContestRegister)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("contestRegister")
public class ContestRegisterController {
    /**
     * 服务对象
     */
    @Resource
    private ContestRegisterService contestRegisterService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ContestRegister selectOne(Integer id) {
        return this.contestRegisterService.queryById(id);
    }

}
