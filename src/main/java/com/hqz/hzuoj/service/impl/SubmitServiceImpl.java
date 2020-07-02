package com.hqz.hzuoj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqz.hzuoj.common.base.CurrentUser;
import com.hqz.hzuoj.common.constants.Constants;
import com.hqz.hzuoj.common.exception.MyException;
import com.hqz.hzuoj.common.util.PageUtils;
import com.hqz.hzuoj.entity.DO.ProblemDO;
import com.hqz.hzuoj.entity.DO.SubmitDO;
import com.hqz.hzuoj.entity.VO.SubmitQueryVO;
import com.hqz.hzuoj.entity.model.JudgeResult;
import com.hqz.hzuoj.entity.model.Submit;
import com.hqz.hzuoj.mapper.SubmitMapper;
import com.hqz.hzuoj.service.JudgeResultService;
import com.hqz.hzuoj.service.ProblemService;
import com.hqz.hzuoj.service.SubmitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Submit)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("submitService")
public class SubmitServiceImpl implements SubmitService {
    @Resource
    private SubmitMapper submitMapper;

    @Resource
    private ProblemService problemService;

    @Resource
    private JudgeResultService judgeResultService;

    /**
     * 通过ID查询单条数据
     *
     * @param submitId 主键
     * @return 实例对象
     */
    @Override
    public Submit queryById(Integer submitId) {
        return this.submitMapper.queryById(submitId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Submit> queryAllByLimit(int offset, int limit) {
        return this.submitMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param submit 实例对象
     * @return 实例对象
     */
    @Override
    public Submit insert(Submit submit) {
        this.submitMapper.insert(submit);
        return submit;
    }

    /**
     * 修改数据
     *
     * @param submit 实例对象
     * @return 实例对象
     */
    @Override
    public Submit update(Submit submit) {
        this.submitMapper.update(submit);
        return this.queryById(submit.getSubmitId());
    }

    /**
     * 通过主键删除数据
     *
     * @param submitId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer submitId) {
        return this.submitMapper.deleteById(submitId) > 0;
    }

    /**
     * 获取题目提交通过数量
     * @param problemId
     * @return
     */
    @Override
    public Integer findProblemAcceptedTotal(Integer problemId) {
        SubmitQueryVO submitQueryVO = new SubmitQueryVO();
        submitQueryVO.setType(Constants.Submit.Type.PROBLEM);
        submitQueryVO.setPublicCode(Constants.Submit.Public.PUBLIC);
        submitQueryVO.setProblemId(problemId);
        JudgeResult judgeResult = judgeResultService.findJudgeResultByJudgeNameAbbr("AC");
        submitQueryVO.setJudgeResultId(judgeResult.getJudgeResultId());
        return submitMapper.findProblemAcceptedTotal(submitQueryVO);
    }

    /**
     * 获取提交测评列表
     * @param submitQueryVO
     * @return
     */
    @Override
    public PageUtils findSubmits(SubmitQueryVO submitQueryVO) {
        PageHelper.startPage(submitQueryVO.getCurrPage(), submitQueryVO.getPageSize(), true);
        List<SubmitDO> list = submitMapper.findSubmits(submitQueryVO);
        PageInfo<SubmitDO> pageInfo = new PageInfo<>(list);
        return new PageUtils(pageInfo);
    }

    /**
     * 获取提交测评详情
     * @param submitId
     * @return
     */
    @Override
    public SubmitDO findSubmit(Integer submitId) {
        SubmitDO submit = submitMapper.findSubmit(submitId);
        if (submit == null) {
            throw new MyException("测评为空");
        }
        return submit;
    }

    /**
     * 保存测评记录
     * @param submit
     * @return
     */
    @Override
    @Transactional
    public Integer saveSubmit(Submit submit) {
        ProblemDO problem = problemService.findById(submit.getProblemId());
        if (problem == null) {
            throw new MyException("题目不存在");
        }
        Integer userId = CurrentUser.getUserId();
        submit.setUserId(userId);
        submitMapper.saveSubmit(submit);
        return submit.getSubmitId();
    }

    /**
     * 获取当前登录用户是否通过该题目
     * @param problemId
     * @return
     */
    @Override
    public Boolean findProblemAccepted(Integer problemId) {
        if (!CurrentUser.UserIsLogin()) {
            return false;
        }
        SubmitQueryVO submitQueryVO = new SubmitQueryVO();
        submitQueryVO.setPublicCode(Constants.Submit.Public.PUBLIC);
        submitQueryVO.setType(Constants.Submit.Type.PROBLEM);
        submitQueryVO.setCurrPage(1);
        submitQueryVO.setPageSize(1);
        JudgeResult judgeResult = judgeResultService.findJudgeResultByJudgeNameAbbr("AC");
        submitQueryVO.setJudgeResultId(judgeResult.getJudgeResultId());
        submitQueryVO.setUserId(CurrentUser.getUserId());
        PageUtils submits = findSubmits(submitQueryVO);
        return submits.getTotalCount() == 1;
    }

    /**
     * 获取当前题目提交数量
     * @param problemId
     * @return
     */
    @Override
    public Integer findProblemSubmitTotal(Integer problemId) {
        SubmitQueryVO submitQueryVO = new SubmitQueryVO();
        submitQueryVO.setProblemId(problemId);
        submitQueryVO.setPublicCode(Constants.Submit.Public.PUBLIC);
        submitQueryVO.setType(Constants.Submit.Type.PROBLEM);
        return submitMapper.findProblemSubmitTotal(submitQueryVO);
    }

    /**
     * 判断当前登录用户是否有提交
     * @param problemId
     * @return
     */
    @Override
    public Boolean findProblemSubmit(Integer problemId) {
        SubmitQueryVO submitQueryVO = new SubmitQueryVO();
        submitQueryVO.setProblemId(problemId);
        submitQueryVO.setPublicCode(Constants.Submit.Public.PUBLIC);
        submitQueryVO.setType(Constants.Submit.Type.PROBLEM);
        return submitMapper.findProblemSubmit(submitQueryVO) > 0;
    }
}
