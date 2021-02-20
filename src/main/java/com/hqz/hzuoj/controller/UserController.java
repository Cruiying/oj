package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.entity.VO.RankingQueryVO;
import com.hqz.hzuoj.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/ranking", method = RequestMethod.POST)
    @ApiOperation("获取用户排行榜")
    public R ranking(@RequestBody RankingQueryVO rankingQueryVO) {
        return R.ok("获取成功", userService.ranking(rankingQueryVO));
    }
}
