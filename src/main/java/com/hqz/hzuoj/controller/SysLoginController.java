package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.common.base.CurrentUser;
import com.hqz.hzuoj.common.constants.RedisKeyConstants;
import com.hqz.hzuoj.common.util.CookieUtil;
import com.hqz.hzuoj.common.util.SessionUtils;
import com.hqz.hzuoj.config.shiro.JwtToken;
import com.hqz.hzuoj.entity.VO.SysUserLoginFormVO;
import com.hqz.hzuoj.entity.model.User;
import com.hqz.hzuoj.service.SysCaptchaService;
import com.hqz.hzuoj.service.SysUserTokenService;
import com.hqz.hzuoj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDate;

/**
 * SysLoginController
 *
 * @author Cruiying
 * @date 2018/10/19 18:47
 * @email 2322144259@qq.com
 * @description
 */
@RestController
public class SysLoginController extends CurrentUser {

    @Autowired
    private SysCaptchaService sysCaptchaService;

    @Autowired
    private UserService userService;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 获取系统验证码
     *
     * @param response
     * @param uuid
     * @throws IOException
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        System.err.println(uuid);
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();

        ImageIO.write(image, "jpg", out);

        out.close();
    }

    /**
     * 用戶登录校验，并返回登录token认证
     *
     * @param loginUser
     * @return
     */
    @PostMapping("/user/sys/login")
    public R login(@RequestBody SysUserLoginFormVO loginUser, HttpServletRequest request, HttpServletResponse response) {
        System.err.println(loginUser);
        boolean captcha = sysCaptchaService.validate(loginUser.getUuid(), loginUser.getCaptcha());
        if (!captcha) {
            return R.error("验证码错误");
        }
        //获得当前用户到登录对象，现在状态为未认证
        Subject subject = SecurityUtils.getSubject();
        //shiro 使用异常捕捉登录失败消息
        try {
            User user = userService.queryByUsername(loginUser.getUsername());
            if (user == null) {
                return R.error("用户名不存在");
            }
            //用户Id密码令牌
            String token = sysUserTokenService.createToken(user.getUserId());
            JwtToken jwtToken = new JwtToken(token);
            // 如果没有抛出异常则代表登入成功，返回true
            subject.login(jwtToken);
            //保存至会话中
            SessionUtils.set("user",user);
            //保存cookie
            CookieUtil.setCookie(request,response, "userToken", token, RedisKeyConstants.TOKEN_EXPIRE_TIME, true);
            //保存到redis，并返回token给用户
            return R.ok("token", token);
        } catch (IncorrectCredentialsException ice) {
            return R.error("用户名或密码不正确！");
        } catch (UnknownAccountException uae) {
            return R.error("未知账户！");
        } catch (LockedAccountException lae) {
            return R.error("账户已锁定！");
        } catch (ExcessiveAttemptsException eae) {
            return R.error("用户名或密码错误次数太多！");
        } catch (AuthenticationException ae) {
            ae.printStackTrace();
            return R.error("验证未通过！");
        } catch (Exception e) {
            return R.error("验证未通过！");
        }
    }

    /**
     * 退出
     */
    @PostMapping("/sys/logout")
    public R logout() {
        sysUserTokenService.logout(getUserId());
        return R.ok("退出成功");
    }
}
