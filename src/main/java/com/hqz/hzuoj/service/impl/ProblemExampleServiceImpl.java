package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.ProblemExample;
import com.hqz.hzuoj.mapper.ProblemExampleMapper;
import com.hqz.hzuoj.service.ProblemExampleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProblemExample)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("problemExampleService")
public class ProblemExampleServiceImpl implements ProblemExampleService {
    @Resource
    private ProblemExampleMapper problemExampleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param problemExampleId 主键
     * @return 实例对象
     */
    @Override
    public ProblemExample queryById(Integer problemExampleId) {
        return this.problemExampleDao.queryById(problemExampleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProblemExample> queryAllByLimit(int offset, int limit) {
        return this.problemExampleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param problemExample 实例对象
     * @return 实例对象
     */
    @Override
    public ProblemExample insert(ProblemExample problemExample) {
        this.problemExampleDao.insert(problemExample);
        return problemExample;
    }

    /**
     * 修改数据
     *
     * @param problemExample 实例对象
     * @return 实例对象
     */
    @Override
    public ProblemExample update(ProblemExample problemExample) {
        this.problemExampleDao.update(problemExample);
        return this.queryById(problemExample.getProblemExampleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param problemExampleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer problemExampleId) {
        return this.problemExampleDao.deleteById(problemExampleId) > 0;
    }
}
