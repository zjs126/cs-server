package com.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LuoGuRecentCompetitions implements Serializable {
    private String name;
    private String url;
    private String nature;//比赛性质
    private String condition;
    private String StartEndtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getStartEndtime() {
        return StartEndtime;
    }

    public void setStartEndtime(String startEndtime) {
        StartEndtime = startEndtime;
    }

    @Override
    public String toString() {
        return "LuoGuRecentCompetitions{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", nature='" + nature + '\'' +
                ", condition='" + condition + '\'' +
                ", StartEndtime='" + StartEndtime + '\'' +
                '}';
    }
}
