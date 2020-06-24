package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.DictionaryOption;
import com.hqz.hzuoj.service.DictionaryOptionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DictionaryOption)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("dictionaryOption")
public class DictionaryOptionController {
    /**
     * 服务对象
     */
    @Resource
    private DictionaryOptionService dictionaryOptionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DictionaryOption selectOne(Integer id) {
        return this.dictionaryOptionService.queryById(id);
    }

}
