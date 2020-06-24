package com.hqz.hzuoj.config.shiro;


import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * ShiroConfig
 *
 * @author Cruiying
 * @date 2018/10/07 16:39
 * @email 2322144259@qq.com
 * @description Shiro配置類
 */
@Configuration
public class ShiroConfig {

    //将自己的验证方式加入容器
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        /*securityManager.setCacheManager(redisCacheManager());
        securityManager.setSessionManager(defaultWebSessionManager());*/
        //securityManager.setSessionManager(defaultWebSessionManager());
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<String, String>();
        //登出
        /*
         * anon  无需认证
         * authc  必须认证
         * user  使用rememberme功能可以直接访问
         * perms 资源授权
         * role 校色授权
         * */
        // map.put("/h5pasm/**","anon");
        map.put("/logout", "logout");
        map.put("/user/login", "anon");//对所有用户不认证
        map.put("/regist", "anon");//对所有用户不认证
        map.put("/captcha.jpg", "anon");//对所有用户不认证
        map.put("/user/sys/login", "anon");//对所有用户不认证
        map.put("/**", "authc");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/user/login");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        //shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }


    /**
     * 开启aop注解支持
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
