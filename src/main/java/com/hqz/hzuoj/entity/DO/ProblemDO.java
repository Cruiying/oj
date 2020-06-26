package com.hqz.hzuoj.entity.DO;

import com.hqz.hzuoj.entity.model.DictionaryOption;
import com.hqz.hzuoj.entity.model.ProblemExample;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

@Data
public class ProblemDO implements Serializable {

    @ApiModelProperty("ID")
    private Integer problemId;
    /**
     * 题目标题
     */
    @ApiModelProperty("题目标题")
    private String title;
    /**
     * 题目内容
     */
    @ApiModelProperty("题目内容")
    private String content;
    /**
     * 题目说明
     */
    @ApiModelProperty("题目说明")
    private String explain;
    /**
     * 输入内容
     */
    @ApiModelProperty("输入内容")
    private String inputContent;
    /**
     * 输出内容
     */
    @ApiModelProperty("输出内容")
    private String outputContent;
    /**
     * 题目背景
     */
    @ApiModelProperty("题目背景")
    private String background;
    /**
     * 题目样例
     */
    @ApiModelProperty("题目样例")
    private List<ProblemExampleListDO> problemExamples;
    /**
     * 题目内存与时间限制
     */
    @ApiModelProperty("题目内存与事件限制")
    private ProblemDataDO problemDataDO;


    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public String getOutputContent() {
        return outputContent;
    }

    public void setOutputContent(String outputContent) {
        this.outputContent = outputContent;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<ProblemExampleListDO> getProblemExamples() {
        return problemExamples;
    }

    public void setProblemExamples(List<ProblemExampleListDO> problemExamples) {
        this.problemExamples = problemExamples;
    }

    public ProblemDataDO getProblemDataDO() {
        return problemDataDO;
    }

    public void setProblemDataDO(ProblemDataDO problemDataDO) {
        this.problemDataDO = problemDataDO;
    }

    @Override
    public String toString() {
        return "ProblemDO{" +
                "problemId=" + problemId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", explain='" + explain + '\'' +
                ", inputContent='" + inputContent + '\'' +
                ", outputContent='" + outputContent + '\'' +
                ", background='" + background + '\'' +
                ", problemExamples=" + problemExamples +
                ", problemDataDO=" + problemDataDO +
                '}';
    }
}
