package com.hqz.hzuoj.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (ProblemExample)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class ProblemExample implements Serializable {
    private static final long serialVersionUID = -92397934252878613L;

    @ApiModelProperty("${column.comment}")
    private Integer problemExampleId;
    /**
    * 题目ID
    */
    @ApiModelProperty("题目ID")
    private Integer problemId;
    /**
    * 输入样例
    */
    @ApiModelProperty("输入样例")
    private String inputContent;
    /**
    * 输出样例
    */
    @ApiModelProperty("输出样例")
    private String ouputContent;


    public Integer getProblemExampleId() {
        return problemExampleId;
    }

    public void setProblemExampleId(Integer problemExampleId) {
        this.problemExampleId = problemExampleId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public String getOuputContent() {
        return ouputContent;
    }

    public void setOuputContent(String ouputContent) {
        this.ouputContent = ouputContent;
    }

}
