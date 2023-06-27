package com.spring.controller;

import com.spring.pojo.Result;
import com.spring.service.impl.CrawlServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *爬虫controller
 * */

@Slf4j
@RequestMapping("/crawl")
@RestController
@CrossOrigin
public class CrawlController {

    @Autowired
    CrawlServiceImpl crawlService;

    @GetMapping("/cf")
    public Result CFcrawl()  {
        log.info("爬取cf近期比赛信息");

        Result result = crawlService.CFcrawl();
        return result;
    }

    @GetMapping("/lg")
    public Result LGcrawl() {
        log.info("爬取洛谷近期比赛信息");

        Result result = crawlService.LGcrawl();
        return result;
    }


    @GetMapping("/jsjdscontent")
    public Result JSJDSContentcrawl()  {
        log.info("计算机大赛内容");

        Result result = crawlService.JSJDSContentcrawl();
        return result;
    }

    @GetMapping("/jsjdsothers")
    public Result JSJDSOtherscrawl(){
        log.info("计算机大赛其他信息");

        Result result = crawlService.JSJDSOtherscrawl();
        return result;
    }
}
