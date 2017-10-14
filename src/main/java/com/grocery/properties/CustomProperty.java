package com.grocery.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Jason on 14/10/2017.
 */

@Component
@ConfigurationProperties(prefix="CustomProps")
public class CustomProperty {
    private String photographyDetailPageSize;
    private String paginationDisplayNum;

    public String getPhotographyDetailPageSize() {
        return photographyDetailPageSize;
    }

    public void setPhotographyDetailPageSize(String photographyDetailPageSize) {
        this.photographyDetailPageSize = photographyDetailPageSize;
    }

    public String getPaginationDisplayNum() {
        return paginationDisplayNum;
    }

    public void setPaginationDisplayNum(String paginationDisplayNum) {
        this.paginationDisplayNum = paginationDisplayNum;
    }
}
