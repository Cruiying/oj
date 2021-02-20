package com.hqz.hzuoj.entity.DO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SolutionDo implements Serializable {

    @ApiModelProperty("${column.comment}")
    private Integer solutionId;
    /**
     * 题目ID
     */
    @ApiModelProperty("题目ID")
    private Integer problemId;
    /**
     * 题解内容
     */
    @ApiModelProperty("题解内容")
    private String content;

    /**
     * 审核结果
     */
    @ApiModelProperty("审核结果")
    private Integer statusCode;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 积分
     */
    @ApiModelProperty("积分")
    private Integer rating;
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date modifyTime;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "SolutionDo{" +
                "solutionId=" + solutionId +
                ", problemId=" + problemId +
                ", content='" + content + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", rating=" + rating +
                ", title='" + title + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
