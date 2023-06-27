package com.spring;

import com.spring.pojo.Result;
import com.spring.service.CrawlService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class ApplicationTests {

    @Autowired
    CrawlService crawlService;
//    @Test
//    public void testLGProblemCrawl() {
//        List<LuoGuProblems> luoGuProblemsList = CrawlUtils.LuoGuproblemCrawl();
//    }


    @Test
    public void testjsjdsotherscrawl() {
        Result result = crawlService.JSJDSOtherscrawl();
        System.out.println(result);
    }

    @Test
    public void testjsjdscontentcrawl() {
        Result result = crawlService.JSJDSContentcrawl();
        System.out.println(result);
    }

    @Test
    public void testlgcrawl() {
        Result result = crawlService.LGcrawl();
        System.out.println(result);
    }

    @Test
    public void testcfcrawl() {
        Result result = crawlService.CFcrawl();
        System.out.println(result);
    }

    @Test
    public void testUuid() {
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Test
    public void testGenJwt() {

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "atheism")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("atheism")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4MzIxMTg0Mn0.DvJXEmbATWEOahxiDqrwVvdHvZ9L9_hdzk1MRsJlqlA")
                .getBody();
        System.out.println(claims);
    }
}
