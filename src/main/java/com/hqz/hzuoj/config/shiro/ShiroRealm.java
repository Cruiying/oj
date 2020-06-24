package com.hqz.hzuoj.config.shiro;


import com.hqz.hzuoj.common.util.SessionUtils;
import com.hqz.hzuoj.entity.User;
import com.hqz.hzuoj.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();

        /*验证用户名*/
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
        User user = userService.queryByUsername(userName);

        if (user == null || !StringUtils.equals(user.getUsername(), userName)) {
            return null;
        }

        //返回用户信息  会自动判断密码
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = SessionUtils.get("user");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.setRoles(user.getRoles());
        //info.setStringPermissions(user.getPermissions());
        return info;
    }

}
