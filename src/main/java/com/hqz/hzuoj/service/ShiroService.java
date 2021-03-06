package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.User;
import com.hqz.hzuoj.VO.SysUserTokenVO;

import java.util.Set;

/**
 * ShiroService
 *
 * @author Cruiying
 * @date 2018/10/08 19:58
 * @email 2322144259@qq.com
 * @description service接口类
 */
public interface ShiroService {

    /**
     * 获取用户的所有权限
     * @param userId
     * @return
     */
    Set<String> getUserPermissions(Integer userId);

    /**
     * 查询token
     * @param token
     * @return
     */
    SysUserTokenVO queryByToken(String token);

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    User queryUser(Integer userId);

    /**
     * 续期
     * @param userId
     * @param accessToken
     */
    void refreshToken(Integer userId, String accessToken);
}
