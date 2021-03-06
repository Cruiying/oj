package com.hqz.hzuoj.common.base;


import com.hqz.hzuoj.common.exception.MyException;
import com.hqz.hzuoj.common.exception.enums.ErrorEnum;
import com.hqz.hzuoj.entity.User;
import org.apache.shiro.SecurityUtils;

/**
 * AbstractController
 *
 * @author Cruiying
 * @date 2020/6/23 12:35
 * @email 2322144259@qq.com
 * @description
 */
public class CurrentUser {

    public static User getUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public static Integer getUserId(){
        User user = getUser();
        if (null == user) {
            throw new MyException("用户未登录");
        }
        return user.getUserId();
    }
}
