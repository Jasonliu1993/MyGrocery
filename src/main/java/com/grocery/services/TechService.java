package com.grocery.services;

import com.grocery.domain.TechSharing;

import java.util.List;

/**
 * Created by Jason on 24/10/2017.
 */
public interface TechService {

    List<TechSharing> getTechSharingByPaging(Integer pageIndex, Integer pageSize);
    Integer getTechSharingCount();

}
