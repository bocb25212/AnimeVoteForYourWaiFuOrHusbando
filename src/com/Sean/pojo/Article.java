package com.Sean.pojo;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private String image;

    private String summary;

    private Date releasedate;

    private Integer clickhit;

    private Integer replyhit;

    private String keyword;

    private Integer typeId;

    private Integer userId;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Integer getClickhit() {
        return clickhit;
    }

    public void setClickhit(Integer clickhit) {
        this.clickhit = clickhit;
    }

    public Integer getReplyhit() {
        return replyhit;
    }

    public void setReplyhit(Integer replyhit) {
        this.replyhit = replyhit;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}