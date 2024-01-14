package com.kyc.novel.context.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author kyc
 * @since 2024-01-08
 */
@TableName("novel_info")
@ApiModel(value = "NovelInfo对象", description = "")
public class NovelInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("小说名")
    private String novelName;

    @ApiModelProperty("小说类型")
    private Integer novelType;

    @ApiModelProperty("小说简介")
    private String novelIntroduction;

    @ApiModelProperty("小说状态")
    private Integer novelStatus;

    @ApiModelProperty("小说字数")
    private Integer novelNumberCount;

    @ApiModelProperty("小说作者")
    private String novelAuthor;

    @ApiModelProperty("小说点击量（总）")
    private Integer novelClickCount;

    @ApiModelProperty("小说创建时间")
    private LocalDateTime novelCreateTime;

    @ApiModelProperty("小说更新时间")
    private LocalDateTime novelUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }
    public Integer getNovelType() {
        return novelType;
    }

    public void setNovelType(Integer novelType) {
        this.novelType = novelType;
    }
    public String getNovelIntroduction() {
        return novelIntroduction;
    }

    public void setNovelIntroduction(String novelIntroduction) {
        this.novelIntroduction = novelIntroduction;
    }
    public Integer getNovelStatus() {
        return novelStatus;
    }

    public void setNovelStatus(Integer novelStatus) {
        this.novelStatus = novelStatus;
    }
    public Integer getNovelNumberCount() {
        return novelNumberCount;
    }

    public void setNovelNumberCount(Integer novelNumberCount) {
        this.novelNumberCount = novelNumberCount;
    }
    public String getNovelAuthor() {
        return novelAuthor;
    }

    public void setNovelAuthor(String novelAuthor) {
        this.novelAuthor = novelAuthor;
    }
    public Integer getNovelClickCount() {
        return novelClickCount;
    }

    public void setNovelClickCount(Integer novelClickCount) {
        this.novelClickCount = novelClickCount;
    }
    public LocalDateTime getNovelCreateTime() {
        return novelCreateTime;
    }

    public void setNovelCreateTime(LocalDateTime novelCreateTime) {
        this.novelCreateTime = novelCreateTime;
    }
    public LocalDateTime getNovelUpdateTime() {
        return novelUpdateTime;
    }

    public void setNovelUpdateTime(LocalDateTime novelUpdateTime) {
        this.novelUpdateTime = novelUpdateTime;
    }

    @Override
    public String toString() {
        return "NovelInfo{" +
            "id=" + id +
            ", novelName=" + novelName +
            ", novelType=" + novelType +
            ", novelIntroduction=" + novelIntroduction +
            ", novelStatus=" + novelStatus +
            ", novelNumberCount=" + novelNumberCount +
            ", novelAuthor=" + novelAuthor +
            ", novelClickCount=" + novelClickCount +
            ", novelCreateTime=" + novelCreateTime +
            ", novelUpdateTime=" + novelUpdateTime +
        "}";
    }
}
