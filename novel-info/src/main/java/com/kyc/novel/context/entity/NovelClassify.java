package com.kyc.novel.context.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("novel_classify")
@ApiModel(value = "NovelClassify对象", description = "")
public class NovelClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty("1级分类")
    private String levelClassify1;

    @ApiModelProperty("2级分类")
    private String levelClassify2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getLevelClassify1() {
        return levelClassify1;
    }

    public void setLevelClassify1(String levelClassify1) {
        this.levelClassify1 = levelClassify1;
    }
    public String getLevelClassify2() {
        return levelClassify2;
    }

    public void setLevelClassify2(String levelClassify2) {
        this.levelClassify2 = levelClassify2;
    }

    @Override
    public String toString() {
        return "NovelClassify{" +
            "id=" + id +
            ", levelClassify1=" + levelClassify1 +
            ", levelClassify2=" + levelClassify2 +
        "}";
    }
}
