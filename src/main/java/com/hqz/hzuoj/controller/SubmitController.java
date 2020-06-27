package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.entity.VO.SubmitListQueryVO;
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
@RequestMapping("submits")
public class SubmitController {
    /**
     * 服务对象
     */
    @Resource
    private SubmitService submitService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation("获取提交测评列表")
    public R submits(@RequestBody SubmitListQueryVO submitListQueryVO) {
        return R.ok("获取成功", submitService.findSubmits(submitListQueryVO));
    }

    @RequestMapping(value = "/{submitId}", method = RequestMethod.POST)
    public R submit(@PathVariable Integer submitId) {
        return R.ok("获取成功", submitService.findSubmit(submitId));
    }

}
