package com.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.pojo.CFProblems;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CFQuestionMapper extends BaseMapper<CFProblems> {
}