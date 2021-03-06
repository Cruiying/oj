package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.ContestRegister;
import java.util.List;

/**
 * (ContestRegister)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestRegisterService {

    /**
     * 通过ID查询单条数据
     *
     * @param contestRegisterId 主键
     * @return 实例对象
     */
    ContestRegister queryById(Integer contestRegisterId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ContestRegister> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param contestRegister 实例对象
     * @return 实例对象
     */
    ContestRegister insert(ContestRegister contestRegister);

    /**
     * 修改数据
     *
     * @param contestRegister 实例对象
     * @return 实例对象
     */
    ContestRegister update(ContestRegister contestRegister);

    /**
     * 通过主键删除数据
     *
     * @param contestRegisterId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer contestRegisterId);

}
