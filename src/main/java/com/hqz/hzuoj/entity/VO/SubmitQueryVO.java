package com.hqz.hzuoj.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("提交测评列表搜索")
public class SubmitQueryVO implements Serializable {

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
     * 测评Id
     */
    @ApiModelProperty("测评Id")
    private Integer submitId;

    /**
     * 题目标题
     */
    @ApiModelProperty("题目标题")
    private String title;

    /**
     * 测评结果Id
     */
    @ApiModelProperty("测评结果Id")
    private Integer judgeResultId;

    /**
     * 语言id
     */
    @ApiModelProperty("语言Id")
    private Integer languageId;

    /**
     * 用户Id
     */
    @ApiModelProperty("用户Id")
    private Integer userId;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 题目Id
     */
    @ApiModelProperty("题目Id")
    private Integer problemId;

    /**
     * 查看类型
     */
    @ApiModelProperty("查看类型")
    private Integer publicCode;

    /**
     * 提交类型
     */
    @ApiModelProperty("提交类型")
    private Integer type;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getJudgeResultId() {
        return judgeResultId;
    }

    public void setJudgeResultId(Integer judgeResultId) {
        this.judgeResultId = judgeResultId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
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

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

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


    public Integer getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Integer submitId) {
        this.submitId = submitId;
    }

    public Integer getPublicCode() {
        return publicCode;
    }

    public void setPublicCode(Integer publicCode) {
        this.publicCode = publicCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SubmitListQueryVO{" +
                "pageSize=" + pageSize +
                ", currPage=" + currPage +
                ", submitId=" + submitId +
                ", title='" + title + '\'' +
                ", judgeResultId=" + judgeResultId +
                ", languageId=" + languageId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", problemId=" + problemId +
                ", publicCode=" + publicCode +
                ", type=" + type +
                '}';
    }
}
