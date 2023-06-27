package com.spring.utils;

/*
 * 爬取洛谷的所有题目封装成类的列表
 * */
//    public static List<LuoGuProblems> LuoGuproblemCrawl() {
//        val session = PulsarContexts.createSession();
//        List<LuoGuProblems> luoGuProblems = new ArrayList<LuoGuProblems>();
//        for (int i = 2; i < 5; i++) {
//            LGpage_url = new StringBuilder(LGpage_url).append("?page=").append(i).toString();
//            val page = session.load(LGpage_url);
//            val document = session.parse(page);
//            Elements rows = document.select("div[class=row-wrap]").select("div[class=row]");
//
//            for (Element row : rows) {
//                String url = LGdefaulturl + row.select("div[class=title]").select("a").attr("href");
//                String header = row.select("div[class=title]").select("a").text().strip();
//                LuoGuProblems luoGuProblem = new LuoGuProblems();
//                luoGuProblem.setUrl(url);
//                luoGuProblem.setHeader(header);
//                luoGuProblems.add(luoGuProblem);
//            }
//        }
//
//        for (LuoGuProblems luoGuProblem : luoGuProblems) {
//            val page = session.load(luoGuProblem.getUrl());
//            val document = session.parse(page);
//            val statement = document.select("div[class=card problem-card padding-default]");
//            int i = 0;
//            if (statement.select("h2[class=lfe-h2]").eq(0).text().equals("题目背景")) {
//                i++;
//            }
//            String content = statement.select("div[class=marked]").eq(i++).text();
//            String input = statement.select("div[class=marked]").eq(i++).text();
//            String output = statement.select("div[class=marked]").eq(i++).text();
//            String sample = statement.select("div[class=sample-wrap sample]").text();
//            luoGuProblem.setContent(content);
//            luoGuProblem.setInput(input);
//            luoGuProblem.setOutput(output);
//            luoGuProblem.setSample(sample);
//
//            try {
//                String note = statement.select("div[class=marked]").eq(i).text();
//                luoGuProblem.setNote(note);
//            } catch (Exception e) {
//                e.printStackTrace();
//                luoGuProblem.setNote("无");
//            }
//
//            System.out.println(luoGuProblem);
//        }
//        return luoGuProblems;
//    }
