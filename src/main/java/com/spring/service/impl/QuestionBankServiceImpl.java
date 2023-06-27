package com.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.mapper.CFQuestionMapper;
import com.spring.mapper.LuoGuQuestionMapper;
import com.spring.pojo.CFProblems;
import com.spring.pojo.LuoGuProblems;
import com.spring.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 题库：
 * 洛谷，
 * codeForce，
 * ......
 */
@Service
public class QuestionBankServiceImpl implements QuestionBankService {
    /**
     * 洛谷，功能包括分页获取题目、提交题目、根据关键语句查询
     */
    @Autowired
    private LuoGuQuestionMapper luoGuQuestionMapper;

    private final String[] questionKeywords = {"全部", "数组", "字符串", "哈希表", "数学", "排序", "贪心", "树"};

    // 这是给 CodeForces 用的
    private final String[] CFQuestionKeyword = {"all", "array", "string", "hash", "math", "sort", "greedy", "tree"};

//    /**
//     * 调用 python 脚本发送请求，上传题目
//     *
//     * @param headersAndData 发送请求所需的数据
//     * @return 响应体
//     */
//    @Override
//    public String submitAnswerLuoGu(HashMap<String, String> headersAndData) {
//        String temp;
//        StringBuilder data = new StringBuilder();
//        try {
//            String[] args = new String[]{"python", "lgsubmit.py",
//                    headersAndData.get("url"), headersAndData.get("User-Agent"),
//                    headersAndData.get("cookie"), headersAndData.get("referer"),
//                    headersAndData.get("x-csrf-token"), headersAndData.get("code")
//            };
//            Process proc = Runtime.getRuntime().exec(args);
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//
//            while ((temp = in.readLine()) != null) {
//                data.append(temp);
//            }
//
//            if (data.toString().contains("400")) {
//                return null;
//            }
//
//            JSONObject jsonObject = JSON.parseObject(data.toString());
//
//            args = new String[]{"python", "lgsubmit.py",
//                    "https://www.luogu.com.cn/record/" + jsonObject.get("rid") + "?_contentOnly=1", headersAndData.get("User-Agent"),
//                    headersAndData.get("cookie"), headersAndData.get("referer"),
//                    headersAndData.get("x-csrf-token")
//            };
//            proc = Runtime.getRuntime().exec(args);
//            in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//
//            data.delete(0, data.length());
//            while ((temp = in.readLine()) != null) {
//                data.append(temp);
//            }
//
//            in.close();
//            proc.waitFor();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//        return data.toString();
//    }

    /**
     * 根据关键字分页查询 洛谷 题目
     *
     * @param numKeywords 由数组组成的关键字字符串
     * @param pages       页码数
     * @param rows        一页有多少行
     * @return 洛谷题目
     */
    @Override
    public Page<LuoGuProblems> searchLuoGuQuestions(String numKeywords, Integer pages, Integer rows) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < questionKeywords.length; ++i) {
            if (numKeywords.contains(String.valueOf(i)))
                nums.add(i);
        }

        LambdaQueryWrapper<LuoGuProblems> queryWrapper = new LambdaQueryWrapper<>();
        for (Integer num : nums) {
            queryWrapper = queryWrapper.like(LuoGuProblems::getContent, questionKeywords[num])
                    .or().like(LuoGuProblems::getQuestiondescription, questionKeywords[num]);
        }
        return luoGuQuestionMapper.selectPage(new Page<>(pages, rows), queryWrapper);
    }


    /**
     * codeForce，功能包括分页获取题目、提交题目、根据关键语句查询
     */
    @Autowired
    private CFQuestionMapper cfQuestionMapper;
//
//    /**
//     * 提交 codeForce 的题目
//     *
//     * @param data 提交时所需的数据
//     * @return 响应体
//     */
//    @Override
//    public String submitAnswerCF(HashMap<String, String> data) {
//        return null;
//    }

    /**
     * 根据关键字分页查询 CodeForces 的题目
     *
     * @param numKeywords 由数字组成的关键字字符串
     * @param pages       页码数
     * @param rows        一页有多少行
     * @return CodeForces 题目
     */
    @Override
    public Page<CFProblems> searchCFQuestions(String numKeywords, Integer pages, Integer rows) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < CFQuestionKeyword.length; ++i) {
            if (numKeywords.contains(String.valueOf(i)))
                nums.add(i);
        }
        LambdaQueryWrapper<CFProblems> queryWrapper = new LambdaQueryWrapper<>();
        for (Integer num : nums) {
            queryWrapper = queryWrapper.like(CFProblems::getContent, CFQuestionKeyword[num])
                    .or().like(CFProblems::getHeader, CFQuestionKeyword[num]);
        }

        return cfQuestionMapper.selectPage(new Page<>(pages, rows), queryWrapper);
    }
}
