package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.base.CurrentUser;
import com.hqz.hzuoj.entity.VO.DiscussionQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api("用户界面页面显示")
public class UserViewController {

    @RequestMapping(value = {"", "/index"}, method = RequestMethod.GET)
    @ApiOperation("用户首页")
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "/discussion/editor", method = RequestMethod.GET)
    @ApiOperation("讨论编辑页面")
    public String discussionEditor(Integer discussionId, Model map) {
        map.addAttribute("discussionId", discussionId);
        return "user/d_editor";
    }

    @RequestMapping(value = "/discussion/{discussionId}", method = RequestMethod.GET)
    @ApiOperation("讨论详情页面")
    public String discussion(@PathVariable Integer discussionId, Model map) {
        map.addAttribute("discussionId", discussionId);
        map.addAttribute("user", CurrentUser.getUser());
        return "user/discussion";
    }

    @RequestMapping(value = "/discussions", method = RequestMethod.GET)
    @ApiOperation("讨论列表页面")
    @RequiresPermissions("discussions:list")
    public String discussions(DiscussionQueryVO discussionQueryVO, Model map) {
        map.addAttribute("query", discussionQueryVO);
        return "user/discussions";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    @ApiOperation("用户登录界面")
    public String login() {
        return "user/login";
    }
}
