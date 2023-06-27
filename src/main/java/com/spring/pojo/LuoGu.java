package com.spring.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("luogu")
public class LuoGu {
    @TableField("status")
    private String status;
    @TableField("title")
    private String title;
    @TableField("url")
    private String url;
    @TableField("type")
    private String type;
    @TableField("time")
    private String time;
    @TableField("count")
    private String count;
    @TableField("constructor")
    private String constructor;
    @TableField("userUrl")
    private String userUrl;
}
