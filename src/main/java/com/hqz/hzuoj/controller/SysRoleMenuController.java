package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.entity.SysRoleMenu;
import com.hqz.hzuoj.service.SysRoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysRoleMenu)表控制层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@RestController
@RequestMapping("sysRoleMenu")
public class SysRoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysRoleMenu selectOne(Integer id) {
        return this.sysRoleMenuService.queryById(id);
    }

}
