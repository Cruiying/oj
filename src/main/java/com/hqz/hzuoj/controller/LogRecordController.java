package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.model.LogRecord;
import com.hqz.hzuoj.service.LogRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (LogRecord)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("logRecord")
public class LogRecordController {
    /**
     * 服务对象
     */
    @Resource
    private LogRecordService logRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public LogRecord selectOne(Integer id) {
        return this.logRecordService.queryById(id);
    }

}
