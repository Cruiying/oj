package com.hqz.hzuoj.service;


import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.VO.SysUserTokenVO;

/**
 * SysUserTokenService
 *
 * @author bobbi
 * @date 2018/10/20 15:17
 * @email 571002217@qq.com
 * @description
 */
public interface SysUserTokenService {
    /**
     * 生成Token
     * @param userId
     * @return
     */
    R createToken(Integer userId);

    /**
     * 查询token
     * @param token
     * @return
     */
    SysUserTokenVO queryByToken(String token);

    /**
     * 退出登录
     * @param userId
     */
    void logout(Integer userId);

    /**
     * 续期
     * @param userId
     * @param token
     */
    void refreshToken(Integer userId, String token);
}
