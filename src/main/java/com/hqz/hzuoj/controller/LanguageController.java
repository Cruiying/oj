package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.Language;
import com.hqz.hzuoj.service.LanguageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Language)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("language")
public class LanguageController {
    /**
     * 服务对象
     */
    @Resource
    private LanguageService languageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Language selectOne(Integer id) {
        return this.languageService.queryById(id);
    }

}
