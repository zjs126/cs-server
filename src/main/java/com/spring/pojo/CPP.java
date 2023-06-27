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
@TableName("cpp")
public class CPP {
    @TableId
    private Integer id;
    @TableField("title")
    private String title;
    @TableField("state")
    private String state;
    @TableField("authority")
    private String authority;
    @TableField("constructor")
    private String constructor;
    @TableField("contest_url")
    private String contest_url;
}