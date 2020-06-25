package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.Problem;
import com.hqz.hzuoj.mapper.ProblemMapper;
import com.hqz.hzuoj.service.ProblemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Problem)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("problemService")
public class ProblemServiceImpl implements ProblemService {
    @Resource
    private ProblemMapper problemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param problemId 主键
     * @return 实例对象
     */
    @Override
    public Problem queryById(Integer problemId) {
        return this.problemDao.queryById(problemId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Problem> queryAllByLimit(int offset, int limit) {
        return this.problemDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    @Override
    public Problem insert(Problem problem) {
        this.problemDao.insert(problem);
        return problem;
    }

    /**
     * 修改数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    @Override
    public Problem update(Problem problem) {
        this.problemDao.update(problem);
        return this.queryById(problem.getProblemId());
    }

    /**
     * 通过主键删除数据
     *
     * @param problemId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer problemId) {
        return this.problemDao.deleteById(problemId) > 0;
    }
}
