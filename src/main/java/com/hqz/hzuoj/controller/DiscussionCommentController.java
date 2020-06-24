package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.entity.DiscussionComment;
import com.hqz.hzuoj.service.DiscussionCommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DiscussionComment)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@RestController
@RequestMapping("discussionComment")
public class DiscussionCommentController {

    @Resource
    private DiscussionCommentService discussionCommentService;

    @RequestMapping(value = "/{discussionId}", method = RequestMethod.POST)
    @ApiOperation("获取讨论回复")
    public R queryDiscussionComment(@PathVariable Integer discussionId) {
        return R.ok("讨论回复获取成功", discussionCommentService.findDiscussionComment(discussionId));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation("删除讨论回复")
    public R deleteDiscussionComment(Integer discussionCommentId) {
        return R.ok("删除成功", discussionCommentService.deleteById(discussionCommentId));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation("讨论回复")
    public R saveDiscussionComment(@RequestBody DiscussionComment discussionComment) {
        discussionCommentService.saveDiscussionComment(discussionComment);
        return R.ok("回复成功");
    }

}
