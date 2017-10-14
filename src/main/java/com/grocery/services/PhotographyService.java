package com.grocery.services;

import com.grocery.domain.PhotographyDetail;

import java.util.List;

/**
 * Created by Jason on 14/10/2017.
 */
public interface PhotographyService {

    List<PhotographyDetail> getPhotographyDetailBypaging(Integer pageNum, Integer pageSize);
    PhotographyDetail getPhotographyDetailById(Integer id);
    Integer getPhotographyDetailCount();

}
