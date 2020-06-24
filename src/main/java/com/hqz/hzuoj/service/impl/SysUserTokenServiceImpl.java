package com.hqz.hzuoj.service.impl;


import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.common.constants.RedisKeyConstants;
import com.hqz.hzuoj.common.util.RedisUtil;
import com.hqz.hzuoj.config.shiro.TokenGenerator;
import com.hqz.hzuoj.entity.User;
import com.hqz.hzuoj.service.SysUserTokenService;
import com.hqz.hzuoj.VO.SysUserTokenVO;
import com.hqz.hzuoj.service.UserService;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SysUserTokenServiceImpl
 *
 * @author Cruiying
 * @date 2018/10/20 15:18
 * @email 2322144259@qq.com
 * @description
 */
@Service
public class SysUserTokenServiceImpl implements SysUserTokenService {

    //30天后过期
    private final static int EXPIRE = 3600 * 24 * 30;

    @Autowired
    private RedisUtil redisUtil;

    @Resource
    private UserService userService;

    /**
     * 生成Token
     *
     * @param userId
     * @return
     */
    @Override
    public R createToken(Integer userId) {
        // 生成一个token
        String token = TokenGenerator.generateValue();

        String tokenKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + token;
        String userIdKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + userId;

        //判断是否生成过token
        String tokenInRedis = (String)redisUtil.get(userIdKey);
        if (!StringUtils.isEmpty(tokenInRedis)) {
            // 将原来的token删除
            redisUtil.del(RedisKeyConstants.MANAGE_SYS_USER_TOKEN + tokenInRedis);
        }
        // 将token存进redis
        redisUtil.set(tokenKey, userId, EXPIRE);
        redisUtil.set(userIdKey, token, EXPIRE);

        return R.ok(token);
    }

    /**
     * 查询token
     *
     * @param token
     * @return
     */
    @Override
    public SysUserTokenVO queryByToken(String token) {
        String userId = redisUtil.get(token).toString();
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        SysUserTokenVO sysUserToken = new SysUserTokenVO();
        User user = userService.queryById(Integer.parseInt(userId));
        sysUserToken.setUser(user);
        return sysUserToken;
    }

    /**
     * 退出登录
     *
     * @param userId
     */
    @Override
    public void logout(Integer userId) {
        String userIdKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + userId;
        String token = redisUtil.get(userIdKey).toString();
        String tokenKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + token;
        redisUtil.del(userIdKey);
        redisUtil.del(tokenKey);
    }

    /**
     * 续期
     *
     * @param userId
     * @param token
     */
    @Override
    public void refreshToken(Integer userId, String token) {
        String tokenKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + token;
        String userIdKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + userId;
        redisUtil.expire(tokenKey, EXPIRE);
        redisUtil.expire(userIdKey, EXPIRE);
    }


}
