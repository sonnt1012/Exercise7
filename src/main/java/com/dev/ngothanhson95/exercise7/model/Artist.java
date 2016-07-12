package com.dev.ngothanhson95.exercise7.model;

/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class Artist {
    private String name;
    private String url;
    private int imgRes;


    public Artist(int imgRes, String name, String url) {
        this.imgRes = imgRes;
        this.name = name;
        this.url = url;
    }

    public int getImgRes() {
        return imgRes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
