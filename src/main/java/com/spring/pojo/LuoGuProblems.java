package com.spring.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("luogu_problems")
public class LuoGuProblems {
    @TableId
    private Integer question_id;

    private String content;

    @TableField("question_description")
    private String questiondescription;

    @TableField("question_background")
    private String questionbackground;

    @TableField("input_format")
    private String inputformat;

    @TableField("output_format")
    private String outputformat;

    @TableField("input_example")
    private String inputexample;

    @TableField("output_example")
    private String outputexample;

    @TableField("question_url")
    private String questionurl;
}
