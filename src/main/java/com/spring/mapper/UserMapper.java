package com.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 员工管理
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user(username, password, email, phone, gender, tag)" +
            "values(#{username},#{password},#{email},#{phone},#{gender},#{tag})")
    void register(User user);

    @Select("select * from user where username=#{username} and password =#{password}")
    User getByUsernameAndPassword(User user);

    @Select("select * from user where email=#{email} and password =#{password}")
    User getByEmailAndPassword(User user);

    @Select("select * from user where id=#{id} and username =#{username}")
    User UserSearch(Integer id, String username);

    @Select("select * from user where username =#{username}")
    User searchUserbyName(String username);

}
