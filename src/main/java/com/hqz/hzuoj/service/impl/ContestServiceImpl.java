package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.Contest;
import com.hqz.hzuoj.mapper.ContestMapper;
import com.hqz.hzuoj.service.ContestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Contest)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("contestService")
public class ContestServiceImpl implements ContestService {
    @Resource
    private ContestMapper contestDao;

    /**
     * 通过ID查询单条数据
     *
     * @param contestId 主键
     * @return 实例对象
     */
    @Override
    public Contest queryById(Integer contestId) {
        return this.contestDao.queryById(contestId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Contest> queryAllByLimit(int offset, int limit) {
        return this.contestDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param contest 实例对象
     * @return 实例对象
     */
    @Override
    public Contest insert(Contest contest) {
        this.contestDao.insert(contest);
        return contest;
    }

    /**
     * 修改数据
     *
     * @param contest 实例对象
     * @return 实例对象
     */
    @Override
    public Contest update(Contest contest) {
        this.contestDao.update(contest);
        return this.queryById(contest.getContestId());
    }

    /**
     * 通过主键删除数据
     *
     * @param contestId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer contestId) {
        return this.contestDao.deleteById(contestId) > 0;
    }
}
