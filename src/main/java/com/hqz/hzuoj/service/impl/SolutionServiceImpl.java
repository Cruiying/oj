package com.hqz.hzuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqz.hzuoj.common.base.CurrentUser;
import com.hqz.hzuoj.common.exception.MyException;
import com.hqz.hzuoj.common.util.PageUtils;
import com.hqz.hzuoj.entity.DO.ProblemDO;
import com.hqz.hzuoj.entity.DO.SolutionDo;
import com.hqz.hzuoj.entity.VO.SolutionQueryVO;
import com.hqz.hzuoj.entity.model.Solution;
import com.hqz.hzuoj.mapper.SolutionMapper;
import com.hqz.hzuoj.service.ProblemService;
import com.hqz.hzuoj.service.SolutionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Solution)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("solutionService")
public class SolutionServiceImpl implements SolutionService {
    @Resource
    private SolutionMapper solutionMapper;

    @Resource
    private ProblemService problemService;

    /**
     * 通过ID查询单条数据
     *
     * @param solutionId 主键
     * @return 实例对象
     */
    @Override
    public Solution queryById(Integer solutionId) {
        return this.solutionMapper.queryById(solutionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Solution> queryAllByLimit(int offset, int limit) {
        return this.solutionMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param solution 实例对象
     * @return 实例对象
     */
    @Override
    public Solution insert(Solution solution) {
        solution.setModifyTime(new Date());
        solution.setCreateTime(new Date());
        solution.setUserId(CurrentUser.getUserId());
        ProblemDO problem = problemService.findById(solution.getProblemId());
        if (problem == null) {
            throw new MyException("题目不存在");
        }
        this.solutionMapper.insert(solution);
        return solution;
    }

    /**
     * 修改数据
     *
     * @param solution 实例对象
     * @return 实例对象
     */
    @Override
    public Solution update(Solution solution) {
        Integer userId = CurrentUser.getUserId();
        if (CurrentUser.UserIsLogin()) {
            throw new MyException("用户未登录");
        }
        Solution dbSolution = queryById(solution.getSolutionId());
        if (!userId.equals(dbSolution.getUserId())) {
            throw new MyException("修改失败！");
        }
        ProblemDO problem = problemService.findById(solution.getProblemId());
        if (problem == null) {
            throw new MyException("题目不存在");
        }
        solution.setModifyTime(new Date());
        this.solutionMapper.update(solution);
        return this.queryById(solution.getSolutionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param solutionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer solutionId) {
        return this.solutionMapper.deleteById(solutionId) > 0;
    }

    /**
     * 获取题解列表
     * @param solutionQueryVO
     * @return
     */
    @Override
    public PageUtils findSolutions(SolutionQueryVO solutionQueryVO) {
        PageHelper.startPage(solutionQueryVO.getCurrPage(), solutionQueryVO.getPageSize());
        List<SolutionDo> list = solutionMapper.findSolutions(solutionQueryVO);
        PageInfo<SolutionDo> pageInfo = new PageInfo<>(list);
        return new PageUtils(pageInfo);
    }

    /**
     * 获取题解详情
     * @param solutionId
     * @return
     */
    @Override
    public Solution findSolution(Integer solutionId) {
        return solutionMapper.findSolution(solutionId);

    }
}
