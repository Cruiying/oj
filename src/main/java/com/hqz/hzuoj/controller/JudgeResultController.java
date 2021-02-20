package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.entity.model.JudgeResult;
import com.hqz.hzuoj.service.JudgeResultService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (JudgeResult)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("judgeResults")
public class JudgeResultController {
    /**
     * 服务对象
     */
    @Resource
    private JudgeResultService judgeResultService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation("获取所有测评结果")
    public R judgeResults() {
        return R.ok("获取成功", judgeResultService.findJudgeResults());
    }

}
