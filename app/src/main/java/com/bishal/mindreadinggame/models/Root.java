package com.bishal.mindreadinggame.models;

import java.util.ArrayList;

public class Root {
    public int total;
    public int total_pages;
    public ArrayList<Result> results;

    public Root(int total, int total_pages, ArrayList<Result> results) {
        this.total = total;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
}
