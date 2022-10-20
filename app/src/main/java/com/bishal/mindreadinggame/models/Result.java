package com.bishal.mindreadinggame.models;

public class Result {
    public Result(String id, Urls urls) {
        this.id = id;
        this.urls = urls;
    }

    public String id;
    public Urls urls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }
}
