package com.spring.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @TableId
    private Integer postid;
    private String type;
    private String username;
    private String title;
    private String content;
    private LocalDateTime localDateTime;
    private Integer likenumbers;
    private Integer statementnumbers;
}
