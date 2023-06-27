package com.spring.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("niuke")
public class NiukeCompetition {
    @TableId
    private Integer contestId;
    @TableField("title")
    private String title;
    @TableField("start_time")
    private String startTime;
    @TableField("last_time")
    private String lastTime;
    @TableField("constructor")
    private String constructor;
    @TableField("contest_url")
    private String contestUrl;
}
