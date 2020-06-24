package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.Dictionary;
import com.hqz.hzuoj.service.DictionaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Dictionary)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("dictionary")
public class DictionaryController {
    /**
     * 服务对象
     */
    @Resource
    private DictionaryService dictionaryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Dictionary selectOne(Integer id) {
        return this.dictionaryService.queryById(id);
    }

}
