package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.entity.VO.DiscussionQueryVO;
import com.hqz.hzuoj.entity.VO.SolutionQueryVO;
import com.hqz.hzuoj.entity.model.Discussion;
import com.hqz.hzuoj.entity.model.Solution;
import com.hqz.hzuoj.service.SolutionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Solution)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("solution")
public class SolutionController {
    /**
     * 服务对象
     */
    @Resource
    private SolutionService solutionService;


    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation("修改或者保存题解")
    public R saveOrUpdateSolution(@RequestBody Solution solution) {
        if (solution.getSolutionId() != null) {
            return R.ok("更新成功", solutionService.update(solution));
        } else {
            return R.ok("保存成功",solutionService.insert(solution));
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation("获取题解列表")
    public R querySolutions(@RequestBody SolutionQueryVO solutionQueryVO) {
        return R.ok("获取成功", solutionService.findSolutions(solutionQueryVO));
    }

    @RequestMapping(value = "/{problemId}/{solutionId}", method = RequestMethod.POST)
    @ApiOperation("获取题解详情")
    public R querySolution(@PathVariable Integer problemId, @PathVariable Integer solutionId) {
        return R.ok("获取成功");
    }
}
