package com.grocery.domain;

import java.util.List;

/**
 * Created by Jason on 09/11/2017.
 */
public class FileInputResponseMessage {

    private List<Integer> imageIds;
    private Integer imageId;

    public List<Integer> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
