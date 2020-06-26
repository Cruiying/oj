package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.entity.DO.ProblemListDO;
import com.hqz.hzuoj.entity.VO.ProblemQueryVO;
import com.hqz.hzuoj.service.ProblemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Problem)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("problem")
public class ProblemController {
    /**
     * 服务对象
     */
    @Resource
    private ProblemService problemService;


    @RequestMapping(value = "{problemId}", method = RequestMethod.POST)
    @ApiOperation("获取题目详情")
    public R problem(@PathVariable Integer problemId) {
        return R.ok("题目获取成功", problemService.findById(problemId));
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation("获取题目列表")
    public R problems(@RequestBody ProblemQueryVO problemQueryVO) {
        return R.ok("题目列表获取成功", problemService.findProblems(problemQueryVO));
    }
}
