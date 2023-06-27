package com.spring.utils;

import ai.platon.pulsar.context.PulsarContexts;
import com.spring.pojo.CFRecentCompetitions;
import com.spring.pojo.JSJDSContent;
import com.spring.pojo.JSJDSothers;
import com.spring.pojo.LuoGuRecentCompetitions;
import lombok.val;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CrawlUtils {

    private static String CFUrl = "https://www.codeforces.com/contests";
    private static String LGdefaulturl = "https://www.luogu.com.cn";
    private static String LGpage_url = "https://www.luogu.com.cn/problem/list";
    private static String LGUrl = "https://www.luogu.com.cn";
    private static String JSJDSUrl = "http://jsjds.blcu.edu.cn/index.htm";

    /*
     * 爬取codeforce近期将要开始的比赛信息
     * */
    public List<CFRecentCompetitions> CFCrawl(){
        val session =  PulsarContexts.createSession();
        val page = session.load(CFUrl,"-refresh");
        val document = session.parse(page);
        Elements element = document.select("div[style=background-color: white;margin:0.3em 3px 0 3px;position:relative;]").first().select("tr[data-contestid]");

        List<CFRecentCompetitions> cfRecentCompetitions = new ArrayList<CFRecentCompetitions>();

        for (Element tr : element) {
            Elements tds = tr.select("td");
            String name = tds.first().text();
            String starttime = tds.eq(2).select("a[href]").text();
            String length = tds.eq(3).text();
            String url = null;
            try {
                url = tds.eq(5).select("a[href]").attr("href");
            } finally {
                if (url == "") {
                    url = "can't registration now";
                } else {
                    url = "https://www.codeforces.com" + url;
                }
            }
            CFRecentCompetitions cfRecentCompetition = new CFRecentCompetitions();
            cfRecentCompetition.setName(name);
            cfRecentCompetition.setLength(length);
            cfRecentCompetition.setStarttime(starttime);
            cfRecentCompetition.setUrl(url);
            cfRecentCompetitions.add(cfRecentCompetition);
        }
        return cfRecentCompetitions;
    }

    /*
     * 爬取codeforce近期比赛信息
     * */
    public List<LuoGuRecentCompetitions> LGCrawl(){
        val session =  PulsarContexts.createSession();
        List<LuoGuRecentCompetitions> luoGuRecentCompetitions = new ArrayList<LuoGuRecentCompetitions>();
        val page = session.load(LGUrl,"-refresh");
        val document = session.parse(page);
        Elements sections = document.select("div[class=lg-article]")
                .eq(2)
                .select("section");

        for (Element section : sections) {
            String name = section.select("header").select("h3").select("a").text();
            if (name == null) break;
            String url = section.select("header").select("h3").select("a").attr("href");
            String nature = section.select("div[class=am-panel-bd]").select("span[class=lg-small lg-inline-up]").eq(0).text();
            String condition = section.select("div[class=am-panel-bd]").select("span[class=lg-small lg-inline-up]").eq(1).select("strong").text();
            String startendtime = section.select("div[class=am-panel-bd]").select("span[class=lg-small lg-inline-up lg-right lg-md-hide]").text();

            LuoGuRecentCompetitions luoGuRecentCompetition = new LuoGuRecentCompetitions();
            luoGuRecentCompetition.setName(name);
            luoGuRecentCompetition.setUrl("https://www.luogu.com.cn" + url);
            luoGuRecentCompetition.setNature(nature);
            luoGuRecentCompetition.setCondition(condition);
            luoGuRecentCompetition.setStartEndtime(startendtime);
            luoGuRecentCompetitions.add(luoGuRecentCompetition);
        }
        return luoGuRecentCompetitions;
    }

    /*
     * 计算机设计大赛
     * */
    public List<JSJDSContent> JSJDSContentCrawl() {
        val session =  PulsarContexts.createSession();
        List<JSJDSContent> jsjdsContents = new ArrayList<JSJDSContent>();
        val page = session.load(JSJDSUrl,"-refresh");
        val document = session.parse(page);
        Elements lis = document.select("div[class=xmt-con fl]").select("li[class]");

        for (Element li : lis) {
            String url = li.select("a").attr("href");
            String area = li.select("a").select("h3").text();
            String subject = li.select("a").select("p").text();

            JSJDSContent jsjdsContent = new JSJDSContent();
            jsjdsContent.setArea(area);
            jsjdsContent.setUrl("http://jsjds.blcu.edu.cn/" + url);
            jsjdsContent.setSubject(subject);

            val info = session.load(jsjdsContent.getUrl(),"-refresh");
            val html = session.parse(info);

            String content = html.select("div[id=vsb_content_2_1708_u91]").select("div[id=vsb_content_2]").text();
            jsjdsContent.setContent(content);

            jsjdsContents.add(jsjdsContent);
        }
        return jsjdsContents;
    }

    public List<JSJDSothers> JSJDSothersCrawl(){
        val session =  PulsarContexts.createSession();
        List<JSJDSothers> jsjdSothers = new ArrayList<JSJDSothers>();

        val page = session.load(JSJDSUrl,"-refresh");
        val document = session.parse(page);

        Elements DSDT = document.select("div[class=wid1000]").select("div[class=tzgg fl]")
                .select("div[class=tzgg-con fl]").select("ul").select("li");
        for (Element dsdt : DSDT) {
            String url = dsdt.select("a").attr("href");
            String title = dsdt.select("a").text();

            JSJDSothers jsjdSother = new JSJDSothers();
            jsjdSother.setUrl("http://jsjds.blcu.edu.cn/" + url);
            jsjdSother.setType("DSDT");
            jsjdSother.setTitle(title);
            jsjdSothers.add(jsjdSother);
        }

        Elements WQSS = document.select("div[class=wid1000]").select("div[class=gyhd fl]")
                .select("div[class=gyhd-con fl]").select("ul").select("li");
        for (Element wqss : DSDT) {
            String url = wqss.select("a").attr("href");
            String title = wqss.select("a").text();

            JSJDSothers jsjdSother = new JSJDSothers();
            jsjdSother.setUrl("http://jsjds.blcu.edu.cn/" + url);
            jsjdSother.setType("WQSS");
            jsjdSother.setTitle(title);
            jsjdSothers.add(jsjdSother);
        }

        Elements ZLXZ = document.select("div[class=wid1000]").select("div[class=xshd fl]")
                .select("div[class=xshd-con fl]").select("ul").select("li");
        for (Element zlxz : DSDT) {
            String url = zlxz.select("a").attr("href");
            String title = zlxz.select("a").text();

            JSJDSothers jsjdSother = new JSJDSothers();
            jsjdSother.setUrl("http://jsjds.blcu.edu.cn/" + url);
            jsjdSother.setType("ZLXZ");
            jsjdSother.setTitle(title);
            jsjdSothers.add(jsjdSother);
        }
        return jsjdSothers;
    }
}
