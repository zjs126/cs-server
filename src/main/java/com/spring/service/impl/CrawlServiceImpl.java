package com.spring.service.impl;

import com.spring.pojo.*;
import com.spring.service.CrawlService;
import com.spring.utils.CrawlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

@Service
public class CrawlServiceImpl implements CrawlService {

    @Autowired
    CrawlUtils crawlUtils;

    //判断文件是否超过1天
    private boolean isWithinOneDay(long timestamp) {
        LocalDate cacheDate = LocalDate.ofEpochDay(timestamp / (24 * 60 * 60 * 1000));
        LocalDate currentDate = LocalDate.now();
        return cacheDate.isAfter(currentDate.minusDays(1));
    }
//&& isWithinOneDay(cacheFile.lastModified())
    @Override
    public Result CFcrawl() {

        File cacheFile = new File("cf_cache.txt");
        List<CFRecentCompetitions> cfRecentCompetitions = null;

        // Check if cache file exists and its timestamp is within 1 day
        if (cacheFile.exists()) {
            // Read from cache file
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cacheFile))) {
                cfRecentCompetitions = (List<CFRecentCompetitions>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();

            }
        } else {
            // Cache file doesn't exist or is outdated, crawl the data again
            cfRecentCompetitions = crawlUtils.CFCrawl();

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cacheFile))) {
                oos.writeObject(cfRecentCompetitions);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Result.success(cfRecentCompetitions);
    }

    @Override
    public Result LGcrawl() {

        File cacheFile = new File("lg_cache.txt");
        List<LuoGuRecentCompetitions> luoGuRecentCompetitions = null;

        // Check if cache file exists and its timestamp is within 1 day
        if (cacheFile.exists()) {
            // Read from cache file
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cacheFile))) {
                luoGuRecentCompetitions = (List<LuoGuRecentCompetitions>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();

            }
        } else {
            // Cache file doesn't exist or is outdated, crawl the data again
            luoGuRecentCompetitions = crawlUtils.LGCrawl();

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cacheFile))) {
                oos.writeObject(luoGuRecentCompetitions);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Result.success(luoGuRecentCompetitions);
    }

    @Override
    public Result JSJDSContentcrawl() {

        File cacheFile = new File("jsjdscontent_cache.txt");
        List<JSJDSContent> jsjdsContents = null;

        // Check if cache file exists and its timestamp is within 1 day
        if (cacheFile.exists()) {
            // Read from cache file
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cacheFile))) {
                jsjdsContents = (List<JSJDSContent>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Cache file doesn't exist or is outdated, crawl the data again
            jsjdsContents = crawlUtils.JSJDSContentCrawl();

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cacheFile))) {
                oos.writeObject(jsjdsContents);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Result.success(jsjdsContents);
    }

    @Override
    public Result JSJDSOtherscrawl() {

        File cacheFile = new File("jsjdsothers_cache.txt");
        List<JSJDSothers> jsjdSothers = null;

        // Check if cache file exists and its timestamp is within 1 day
        if (cacheFile.exists() ) {
            // Read from cache file
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cacheFile))) {
                jsjdSothers = (List<JSJDSothers>) ois.readObject();
           } catch (Exception e) {
                e.printStackTrace();

            }
        } else {
            // Cache file doesn't exist or is outdated, crawl the data again
            jsjdSothers = crawlUtils.JSJDSothersCrawl();

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cacheFile))) {
                oos.writeObject(jsjdSothers);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Result.success(jsjdSothers);
    }

}
