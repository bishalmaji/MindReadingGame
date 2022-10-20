package com.bishal.mindreadinggame.models;


public class Urls{
    private  String raw;
    private  String full;
    private  String regular;
    private  String small;
    private  String thumb;
    private  String small_s3;

    public Urls(String raw, String full, String regular, String small, String thumb, String small_s3) {
        this.raw = raw;
        this.full = full;
        this.regular = regular;
        this.small = small;
        this.thumb = thumb;
        this.small_s3 = small_s3;
    }

    public String getRaw() {
        return raw;
    }

    public String getFull() {
        return full;
    }

    public String getRegular() {
        return regular;
    }

    public String getSmall() {
        return small;
    }

    public String getThumb() {
        return thumb;
    }

    public String getSmall_s3() {
        return small_s3;
    }
}