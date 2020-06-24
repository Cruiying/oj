package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.AccessRecord;
import com.hqz.hzuoj.service.AccessRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AccessRecord)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("accessRecord")
public class AccessRecordController {
    /**
     * 服务对象
     */
    @Resource
    private AccessRecordService accessRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AccessRecord selectOne(Long id) {
        return this.accessRecordService.queryById(id);
    }

}
