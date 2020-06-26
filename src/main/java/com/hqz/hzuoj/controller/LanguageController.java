package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.entity.model.Language;
import com.hqz.hzuoj.service.LanguageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Language)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("languages")
public class LanguageController {
    /**
     * 服务对象
     */
    @Resource
    private LanguageService languageService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public R languages() {
        return R.ok("语言获取成功", languageService.findLanguages());
    }

}
