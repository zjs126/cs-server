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
@TableName("likou")
public class LiKou {
    @TableId
    private Integer id;
    @TableField("title")
    private String title;
    @TableField("url")
    private String url;
    @TableField("date")
    private String date;
    @TableField("lasttime")
    private String lasttime;
}
