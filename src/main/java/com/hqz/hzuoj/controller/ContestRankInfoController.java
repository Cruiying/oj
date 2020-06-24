package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.ContestRankInfo;
import com.hqz.hzuoj.service.ContestRankInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ContestRankInfo)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("contestRankInfo")
public class ContestRankInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ContestRankInfoService contestRankInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ContestRankInfo selectOne(Integer id) {
        return this.contestRankInfoService.queryById(id);
    }

}
