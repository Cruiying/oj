package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.Submit;
import java.util.List;

/**
 * (Submit)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface SubmitService {

    /**
     * 通过ID查询单条数据
     *
     * @param submitId 主键
     * @return 实例对象
     */
    Submit queryById(Integer submitId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Submit> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param submit 实例对象
     * @return 实例对象
     */
    Submit insert(Submit submit);

    /**
     * 修改数据
     *
     * @param submit 实例对象
     * @return 实例对象
     */
    Submit update(Submit submit);

    /**
     * 通过主键删除数据
     *
     * @param submitId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer submitId);

}
