package com.feedme.feedme.feed.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed {

    @SerializedName("version")
    protected String version;

    @SerializedName("title")
    protected String title;

    @SerializedName("description")
    protected String description;

    @SerializedName("home_page_url")
    protected String homePageUrl;

    @SerializedName("feed_url")
    protected String feedUrl;

    @SerializedName("user_comment")
    protected String userComment;

    @SerializedName("favicon")
    protected String favicon;

    @SerializedName("author")
    protected Author author;

    @SerializedName("items")
    protected List<Items> items;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
