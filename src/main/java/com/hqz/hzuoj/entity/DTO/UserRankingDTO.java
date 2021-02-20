package com.hqz.hzuoj.entity.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("查询用户排名")
public class UserRankingDTO implements Serializable {

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 用户积分
     */
    @ApiModelProperty("用户积分")
    private Integer rating;
    /**
     * 用户通过数量
     */
    @ApiModelProperty("用户通过数量")
    private Integer acceptedTotal;
    /**
     * 查找排名类型
     */
    @ApiModelProperty("查找排名类型")
    private String type;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getAcceptedTotal() {
        return acceptedTotal;
    }

    public void setAcceptedTotal(Integer acceptedTotal) {
        this.acceptedTotal = acceptedTotal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserRankingDTO{" +
                "userId=" + userId +
                ", rating=" + rating +
                ", acceptedTotal=" + acceptedTotal +
                ", type='" + type + '\'' +
                '}';
    }
}
