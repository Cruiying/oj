package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.common.constants.Constants;
import com.hqz.hzuoj.entity.DO.SubmitDO;
import com.hqz.hzuoj.entity.VO.SubmitQueryVO;
import com.hqz.hzuoj.entity.model.Submit;
import com.hqz.hzuoj.service.SubmitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Submit)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("submit")
public class SubmitController {
    /**
     * 服务对象
     */
    @Resource
    private SubmitService submitService;


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation("获取提交测评列表")
    public R submits(@RequestBody SubmitQueryVO submitQueryVO) {
        submitQueryVO.setType(Constants.Submit.Type.PROBLEM);
        submitQueryVO.setPublicCode(Constants.Submit.Public.PUBLIC);
        return R.ok("获取成功", submitService.findSubmits(submitQueryVO));
    }

    @RequestMapping(value = "/{submitId}", method = RequestMethod.POST)
    @ApiOperation("获取测评详情")
    public R submit(@PathVariable Integer submitId) {
        SubmitDO submit = submitService.findSubmit(submitId);
        if (!Constants.Submit.Public.PUBLIC.equals(submit.getPublicCode()) || !Constants.Submit.Type.PROBLEM.equals(submit.getType())) {
            return R.ok("题目不存在");
        }
        return R.ok("获取成功", submit);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation("保存用户在题库中提交的测评")
    public R saveSubmit(@RequestBody Submit submit) {
        submit.setSubmitType(Constants.Submit.Type.PROBLEM);
        submit.setPublicCode(Constants.Submit.Public.PUBLIC);
        return R.ok("提交成功", submitService.saveSubmit(submit));
    }
}
