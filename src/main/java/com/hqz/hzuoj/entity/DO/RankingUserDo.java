package com.hqz.hzuoj.entity.DO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("排行榜")
public class RankingUserDo implements Serializable {
    /**
     * 排名
     */
    @ApiModelProperty("排名")
    private Integer rank;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String img;
    /**
     * 学校
     */
    @ApiModelProperty("学校")
    private String school;
    /**
     * 积分
     */
    @ApiModelProperty("疾风")
    private Integer rating;
    /**
     * 个性签名
     */
    @ApiModelProperty("个性签名")
    private Integer signature;
    /**
     * 通过数量
     */
    @ApiModelProperty("个性签名")
    private Integer acceptedTotal;


    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getSignature() {
        return signature;
    }

    public void setSignature(Integer signature) {
        this.signature = signature;
    }

    public Integer getAcceptedTotal() {
        return acceptedTotal;
    }

    public void setAcceptedTotal(Integer acceptedTotal) {
        this.acceptedTotal = acceptedTotal;
    }

    @Override
    public String toString() {
        return "RankingUserDo{" +
                "rank=" + rank +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", img='" + img + '\'' +
                ", school='" + school + '\'' +
                ", rating=" + rating +
                ", signature=" + signature +
                ", acceptedTotal=" + acceptedTotal +
                '}';
    }
}
