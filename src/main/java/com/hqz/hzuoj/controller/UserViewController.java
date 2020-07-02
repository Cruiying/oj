package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.base.CurrentUser;
import com.hqz.hzuoj.entity.VO.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Cruiying
 * @date
 */
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
        if (discussionId == null) {
            map.addAttribute("discussionId", -1);
        } else {
            map.addAttribute("discussionId", discussionId);
        }
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
    public String discussions(DiscussionQueryVO discussionQueryVO, Model map) {
        map.addAttribute("query", discussionQueryVO);
        return "user/discussions";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    @ApiOperation("用户登录界面")
    public String login() {
        return "user/login";
    }

    @RequestMapping(value = "/problems", method = RequestMethod.GET)
    @ApiOperation("题目列表界面")
    public String problems(ProblemQueryVO problemQueryVO, Model map) {
        map.addAttribute("query", problemQueryVO);
        return "user/problems";
    }

    @RequestMapping(value = "/problem/{problemId}", method = RequestMethod.GET)
    @ApiOperation("题目详情页面")
    public String problem(@PathVariable Integer problemId, Model map) {
        map.addAttribute("problemId", problemId);
        map.addAttribute("contestId", -1);
        return "user/problem";
    }

    @RequestMapping(value = "/submits", method = RequestMethod.GET)
    @ApiOperation("提交列表页面")
    public String submits(SubmitQueryVO submitListQueryVO, Model map)  {
        map.addAttribute("submitQuery", submitListQueryVO);
        return "user/submits";
    }

    @RequestMapping(value = "/submits/{submitId}", method = RequestMethod.GET)
    @ApiOperation("提交测评详情页面")
    public String submit(@PathVariable Integer submitId, Model map) {
        map.addAttribute("submitId", submitId);
        map.addAttribute("contestId", -1);
        return "user/submit";
    }

    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    @ApiOperation("排行榜")
    public String ranking(RankingQueryVO rankingQueryVO, Model map) {
        map.addAttribute("rankingQuery", rankingQueryVO);
        return "user/ranking";
    }

    @RequestMapping(value = "/solution/{problemId}/editor", method = RequestMethod.GET)
    @ApiOperation("题解编辑页面")
    public String solutionEditor(@PathVariable Integer problemId, Integer solutionId, Model map) {
        map.addAttribute("problemId", problemId);
        if (solutionId == null) {
            map.addAttribute("solutionId", -1);
        } else {
            map.addAttribute("solutionId", solutionId);
        }
        return "user/s_editor";
    }

    @RequestMapping(value = "/solution/{solutionId}", method = RequestMethod.GET)
    @ApiOperation("题解详情页面")
    public String solution(@PathVariable Integer solutionId, Model map) {
        map.addAttribute("solutionId", solutionId);
        return "user/solution";
    }

    @RequestMapping(value = "/solutions/{problemId}", method = RequestMethod.GET)
    @ApiOperation("题目题解列表页面")
    public String solutions(@PathVariable Integer problemId, SolutionQueryVO solutionQueryVO, Model map) {
        map.addAttribute("problemId", problemId);
        if (solutionQueryVO == null) {
            solutionQueryVO = new SolutionQueryVO();
        }
        solutionQueryVO.setProblemId(problemId);
        map.addAttribute("query", solutionQueryVO);
        return "user/solutions";
    }


    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ApiOperation("用户详情页面")
    public String user(@PathVariable Integer userId, Model map) {
        map.addAttribute("userId", userId);
        return "user/user";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ApiOperation("用户注册界面")
    public String register() {
        return "user/register";
    }

    @RequestMapping(value = "/contests", method = RequestMethod.GET)
    @ApiOperation("比赛列表界面")
    public String contests() {
        return "user/contests";
    }

    @RequestMapping(value = "/contests/{contestId}", method = RequestMethod.GET)
    @ApiOperation("比赛详情页面")
    public String contest(@PathVariable Integer contestId, Model map) {
        map.addAttribute("contestId", contestId);
        return "user/contest";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "user/home";
    }
}
