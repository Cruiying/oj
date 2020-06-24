package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.entity.Discussion;
import com.hqz.hzuoj.service.DiscussionService;
import com.hqz.hzuoj.service.UserService;
import com.hqz.hzuoj.VO.DiscussionQueryVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Discussion)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("discussion")
public class DiscussionController {
    /**
     * 服务对象
     */
    @Resource
    private DiscussionService discussionService;


    @RequestMapping(value = "/{discussionId}", method = RequestMethod.POST)
    @ApiOperation("根据讨论id获取讨论详情")
    public R queryDiscussionById(@PathVariable Integer discussionId) {
        return R.ok("获取成功", discussionService.findById(discussionId));
    }


    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation("保存或更新讨论")
    public R saveOrUpdateDiscussion(@RequestBody Discussion discussion) {
        if (discussion.getDiscussionId() != null) {
            Discussion updateDiscussion = discussionService.update(discussion);
            return R.ok("更新成功", updateDiscussion);
        } else {
            Discussion saveDiscussion = discussionService.insert(discussion);
            return R.ok("保存成功",saveDiscussion);
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation("获取讨论列表")
    public R queryDiscussions(@RequestBody DiscussionQueryVO discussionQueryVO) {
        return R.ok("获取成功", discussionService.findDiscussions(discussionQueryVO));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation("删除讨论")
    public R deleteDiscussion(Integer discussionId) {
        return R.ok("删除成功", discussionService.deleteById(discussionId));
    }

}
