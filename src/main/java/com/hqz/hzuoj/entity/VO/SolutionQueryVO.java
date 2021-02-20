package com.hqz.hzuoj.entity.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SolutionQueryVO implements Serializable {

    /**
     * 每页记录数
     */
    @ApiModelProperty("每页记录数")
    private Integer pageSize = 10;
    /**
     * 当前页数
     */
    @ApiModelProperty("当前页数")
    private Integer currPage = 1;

    /**
     * 用户Id
     */
    @ApiModelProperty("用户Id")
    private Integer userId;

    /**
     * 题解Id
     */
    @ApiModelProperty("题解Id")
    private Integer solutionId;

    /**
     * 题目Id
     */
    @ApiModelProperty("题目Id")
    private Integer problemId;

    /**
     * 题解状态
     */
    @ApiModelProperty("题解状态")
    private Integer status;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SolutionQueryVO{" +
                "pageSize=" + pageSize +
                ", currPage=" + currPage +
                ", userId=" + userId +
                ", solutionId=" + solutionId +
                ", problemId=" + problemId +
                ", status=" + status +
                '}';
    }
}
