package com.hqz.hzuoj.controller;


import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.common.base.CurrentUser;
import com.hqz.hzuoj.common.exception.enums.ErrorEnum;
import com.hqz.hzuoj.entity.User;
import com.hqz.hzuoj.service.SysCaptchaService;
import com.hqz.hzuoj.service.SysUserTokenService;
import com.hqz.hzuoj.service.UserService;
import com.hqz.hzuoj.VO.SysUserLoginFormVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
    public R login(@RequestBody SysUserLoginFormVO loginUser) {
        boolean captcha = sysCaptchaService.validate(loginUser.getUuid(), loginUser.getCaptcha());
        //获得当前用户到登录对象，现在状态为未认证
        Subject subject = SecurityUtils.getSubject();
        //用户名密码令牌
        AuthenticationToken token = new UsernamePasswordToken(loginUser.getUsername(), loginUser.getPassword());
        //shiro 使用异常捕捉登录失败消息
        try {
            //将令牌传到shiro提供的login方法验证，需要自定义realm
            subject.login(token);
            //没有异常表示验证成功
            User user = userService.queryByUsername(loginUser.getUsername());
            //生成token，并保存到redis
            return sysUserTokenService.createToken(user.getUserId());
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
