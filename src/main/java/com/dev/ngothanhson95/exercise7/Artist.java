package com.dev.ngothanhson95.exercise7;

/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class Artist {
    private String name;
    private int imgRes;

    public Artist(int imgRes, String name) {
        this.imgRes = imgRes;
        this.name = name;
    }

    public int getImgRes() {
        return imgRes;
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
