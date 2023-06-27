package com.spring.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.pojo.CFProblems;
import com.spring.pojo.LuoGuProblems;

public interface QuestionBankService {
//    String submitAnswerLuoGu(HashMap<String, String> headersAndData);
    Page<LuoGuProblems> searchLuoGuQuestions(String keywords, Integer pages, Integer rows);
//    String submitAnswerCF(HashMap<String, String> data);
    Page<CFProblems> searchCFQuestions(String keywords, Integer pages, Integer rows);
}
