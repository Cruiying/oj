package com.hqz.hzuoj.VO;

import com.hqz.hzuoj.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统用户Token
 */
@Data
@ApiModel("系统用户Token")
public class SysUserTokenVO implements Serializable {

    private User user;

    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SysUserTokenVO{" +
                "user=" + user +
                ", token='" + token + '\'' +
                '}';
    }
}
