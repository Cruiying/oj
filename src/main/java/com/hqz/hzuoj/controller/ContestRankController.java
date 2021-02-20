package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.ContestRank;
import com.hqz.hzuoj.service.ContestRankService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ContestRank)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("contestRank")
public class ContestRankController {
    /**
     * 服务对象
     */
    @Resource
    private ContestRankService contestRankService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ContestRank selectOne(Integer id) {
        return this.contestRankService.queryById(id);
    }

}
