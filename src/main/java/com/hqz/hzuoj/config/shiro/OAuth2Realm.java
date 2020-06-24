package com.hqz.hzuoj.config.shiro;


import com.hqz.hzuoj.entity.User;
import com.hqz.hzuoj.service.ShiroService;
import com.hqz.hzuoj.VO.SysUserTokenVO;
import com.hqz.hzuoj.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * OAuth2Realm
 *
 * @author Cruiying
 * @date 2018/10/07 16:39
 * @email 2322144259@qq.com
 * @description Shiro 认证类
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    @Resource
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.err.println("ffffff");
        return null;
//        User user = (User)principals.getPrimaryPrincipal();
//        if (user == null) {
//            return new SimpleAuthorizationInfo();
//        }
//        Integer userId = user.getUserId();
//        //用户权限列表
//        Set<String> permsSet = shiroService.getUserPermissions(userId);
//        if (permsSet == null) {
//            return new SimpleAuthorizationInfo();
//        }
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(permsSet);
//        return info;
    }

    /**
     * 认证(登录时调用)
     * @param token
     * @return
     * @throws AuthenticationException
     */
    //认证访法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.err.println("认证");
        UsernamePasswordToken acceptedToken = (UsernamePasswordToken) token;
        String username = acceptedToken.getUsername();

        //根据用户名查询数据·库中的密码
        User user = userService.queryByUsername(username);
        if (user == null) {
            //用户不存在
            return null;
        }
        //如果能查询到，再由框架比对数据库中查询到的密码和页面提交的密码是否一致
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),null);

        return info;
    }
}
