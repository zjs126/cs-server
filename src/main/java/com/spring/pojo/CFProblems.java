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
@TableName("cf_questions")
public class CFProblems {
    @TableId
    private Integer id;
    @TableField("content")
    private String content;
    @TableField("header")
    private String header;
    @TableField("input")
    private String input;
    @TableField("note")
    private String note;
    @TableField("output")
    private String output;
    @TableField("sample")
    private String sample;
    @TableField("url")
    private String url;
}
