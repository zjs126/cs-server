package com.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.pojo.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ForumPostMapper extends BaseMapper<Post> {

    @Select("select * from post where type=#{id}")
    List<Post> selectByType(String id);

    @Update("update post set statement_numbers=statement_numbers+1 where postid=#{postid}")
    void updateStatementNumbers(String postid);

    @Update("update post set like_numbers=like_numbers+1 where postid=#{postid}")
    void updatelike(Integer postid);

    @Select("select * from post where postid=#{id} ")
    Post SelectById(Integer id);

    @Select("select * from post where type='经验分享' or type='题解分析' or type='大佬求助' or type='资料分享' ")
    List<Post> findall();

    @Delete("delete from post where postid=#{id} or type=#{id}")
    void DeleteById(String id);

    @Select("select * from post where username=#{username} and type in ('经验分享','题解分析','大佬求助','资料分享')")
    List<Post> searchPostByUsername(String username);

    @Select("select type from post where username=#{username} and type not in ('经验分享','题解分析','大佬求助','资料分享')")
    List<String> searchPostidByUsername(String username);
}
