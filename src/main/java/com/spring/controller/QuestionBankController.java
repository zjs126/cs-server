package com.spring.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.pojo.CFProblems;
import com.spring.pojo.LuoGuProblems;
import com.spring.pojo.Result;
import com.spring.service.QuestionBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/questionBank")
@CrossOrigin
public class QuestionBankController {
    @Autowired
    private QuestionBankService questionBankService;

    /**
     * 分页获取题目
     *
     * @param numKeywords 由数字组成的关键字字符串
     * @param pages       页码数
     * @param rows        每一页有多少行
     * @return 向前端发送结果集
     */
    @GetMapping("/getLuoGuQuestions/{numKeywords}/{pages}/{rows}")
    public Result getLuoGuQuestionsByPage(@PathVariable(value = "numKeywords") String numKeywords,
                                          @PathVariable(value = "pages") Integer pages,
                                          @PathVariable(value = "rows") Integer rows) {
        Page<LuoGuProblems> pageQuestions = questionBankService.searchLuoGuQuestions(numKeywords, pages, rows);

        if (pageQuestions == null) {
            log.info("尝试获取题目 " + " 获取题目失败 " + "pages: " + pages + ", rows: " + rows);
            return new Result(0, "获取题目失败", null);
        }
        log.info("尝试获取题目" + " 获取题目成功 " + "pages:" + pages + ", rows:" + rows);
        return new Result(1, "获取题目成功", pageQuestions);
    }

//    /**
//     * 提交洛谷上面题库的题目答案时调用的函数
//     *
//     * @param data 在洛谷网站提交题目时所需的参数
//     * @return 向前端发送结果集
//     */
//    @PostMapping("/submitAnswerLuogu")
//    public Result submitAnswerLuoGu(@RequestParam HashMap<String, String> data) {
//        String s = questionBankService.submitAnswerLuoGu(data);
//
//        if (s == null) {
//            return new Result(0, "提交失败", null);
//        }
//
//        return new Result(1, "提交成功", JSON.parseObject(s));
//    }
//
//    /**
//     * 提交题目
//     * 暂时没想好怎么写
//     *
//     * @param data
//     * @return
//     */
//    @PostMapping("/submitAnswerCF")
//    public Result submitAnswerCF(HashMap<String, String> data) {
//        return null;
//    }

    /**
     * 根据关键字查询 CodeForces 的题目
     *
     * @param numKeywords 由数字组成的关键字字符串
     * @param pages       页码数
     * @param rows        一页有多少行
     * @return 结果集
     */
    @GetMapping("/getCFQuestions/{numKeywords}/{pages}/{rows}")
    public Result getCFQuestions(@PathVariable(value = "numKeywords") String numKeywords,
                                 @PathVariable(value = "pages") Integer pages,
                                 @PathVariable(value = "rows") Integer rows) {
        Page<CFProblems> cfQuestions = questionBankService.searchCFQuestions(numKeywords, pages, rows);
        log.info("尝试获取题目：" + numKeywords + " pages: " + pages + " rows: " + rows);
        if (cfQuestions == null)
            return Result.error("搜索题目失败");
        return Result.success(cfQuestions);
    }
}
