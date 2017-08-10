package com.feedme.feedme.feed.domain.model;

import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("id")
    protected String id;

    @SerializedName("url")
    protected String url;

    @SerializedName("title")
    protected String title;

    @SerializedName("content_html")
    protected String contentHtml;

    @SerializedName("date_published")
    protected String datePublished;

}
