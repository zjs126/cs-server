package com.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFRecentCompetitions implements Serializable {
    private String name;
    private String starttime;
    private String length;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CFRecentCompetitions{" +
                "name='" + name + '\'' +
                ", starttime='" + starttime + '\'' +
                ", length='" + length + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
