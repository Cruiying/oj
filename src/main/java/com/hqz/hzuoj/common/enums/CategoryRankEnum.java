package com.hqz.hzuoj.common.enums;

import lombok.Getter;

/**
 * CategoryRankEnum
 *
 * @author Cruiying
 * @date 2019/01/08 20:25
 * @email 2322144259@qq.com
 * @description 分类级别枚举
 */
@Getter
public enum CategoryRankEnum {

    /**
     * 一级
     */
    ROOT(-1),
    /**
     * 一级
     */
    FIRST(0),
    /**
     * 二级
     */
    SECOND(1),
    /**
     * 三级
     */
    THIRD(2);

    private int value;

    CategoryRankEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
