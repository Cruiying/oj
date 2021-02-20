package com.hqz.hzuoj.service;

import com.hqz.hzuoj.common.util.PageUtils;
import com.hqz.hzuoj.entity.DO.SubmitDO;
import com.hqz.hzuoj.entity.VO.SubmitQueryVO;
import com.hqz.hzuoj.entity.model.Submit;

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

    /**
     * 获取题目提交通过数量
     * @param problemId
     * @return
     */
    Integer findProblemAcceptedTotal(Integer problemId);

    /**
     * 获取提交测评列表
     * @param submitQueryVO
     * @return
     */
    PageUtils findSubmits(SubmitQueryVO submitQueryVO);

    /**
     * 根据提交测评Id获取信息
     * @param submitId
     * @return
     */
    SubmitDO findSubmit(Integer submitId);

    /**
     * 保存测评记录
     * @param submit
     * @return
     */
    Integer saveSubmit(Submit submit);

    /**
     * 获取当前登录用户是否通过该题目
     * @param problemId
     * @return
     */
    Boolean findProblemAccepted(Integer problemId);

    /**
     * 获取题目提交数量
     * @param problemId
     * @return
     */
    Integer findProblemSubmitTotal(Integer problemId);

    /**
     * 判断当前登录用户是否有提交
     * @param problemId
     * @return
     */
    Boolean findProblemSubmit(Integer problemId);
}
