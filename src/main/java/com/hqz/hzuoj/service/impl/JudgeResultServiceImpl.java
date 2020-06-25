package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.JudgeResult;
import com.hqz.hzuoj.mapper.JudgeResultMapper;
import com.hqz.hzuoj.service.JudgeResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (JudgeResult)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("judgeResultService")
public class JudgeResultServiceImpl implements JudgeResultService {
    @Resource
    private JudgeResultMapper judgeResultDao;

    /**
     * 通过ID查询单条数据
     *
     * @param judgeResultId 主键
     * @return 实例对象
     */
    @Override
    public JudgeResult queryById(Integer judgeResultId) {
        return this.judgeResultDao.queryById(judgeResultId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<JudgeResult> queryAllByLimit(int offset, int limit) {
        return this.judgeResultDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param judgeResult 实例对象
     * @return 实例对象
     */
    @Override
    public JudgeResult insert(JudgeResult judgeResult) {
        this.judgeResultDao.insert(judgeResult);
        return judgeResult;
    }

    /**
     * 修改数据
     *
     * @param judgeResult 实例对象
     * @return 实例对象
     */
    @Override
    public JudgeResult update(JudgeResult judgeResult) {
        this.judgeResultDao.update(judgeResult);
        return this.queryById(judgeResult.getJudgeResultId());
    }

    /**
     * 通过主键删除数据
     *
     * @param judgeResultId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer judgeResultId) {
        return this.judgeResultDao.deleteById(judgeResultId) > 0;
    }
}
