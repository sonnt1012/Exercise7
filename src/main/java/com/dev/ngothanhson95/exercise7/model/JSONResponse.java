package com.dev.ngothanhson95.exercise7.model;

import java.util.List;

/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class JSONResponse {
    public Pagination pagination;
    public List<Release> releases;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }
}
