package com.hqz.hzuoj.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("排行榜搜索")
public class RankingQueryVO implements Serializable {

    /**
     * 每页记录数
     */
    @ApiModelProperty("每页记录数")
    private int pageSize = 10;
    /**
     * 当前页数
     */
    @ApiModelProperty("当前页数")
    private int currPage = 1;
    /**
     * 用户Id
     */
    @ApiModelProperty("用户Id")
    private Integer userId;
    /**
     * 搜索内容
     */
    @ApiModelProperty("搜索内容")
    private String indistinct;
    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private String order = "desc";

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIndistinct() {
        return indistinct;
    }

    public void setIndistinct(String indistinct) {
        this.indistinct = indistinct;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "RankingQueryVO{" +
                "pageSize=" + pageSize +
                ", currPage=" + currPage +
                ", userId=" + userId +
                ", indistinct='" + indistinct + '\'' +
                ", type='" + type + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
