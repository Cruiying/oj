package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.OssResource;
import com.hqz.hzuoj.service.OssResourceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OssResource)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("ossResource")
public class OssResourceController {
    /**
     * 服务对象
     */
    @Resource
    private OssResourceService ossResourceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OssResource selectOne(Integer id) {
        return this.ossResourceService.queryById(id);
    }

}
