package com.grocery.services;

import com.grocery.domain.Sharing;
import com.grocery.domain.TechSharing;

import java.util.List;

/**
 * Created by Jason on 24/10/2017.
 */
public interface SharingService {

    List<TechSharing> getSharingByPaging(Integer pageIndex, Integer pageSize);
    Integer getSharingCount();
    Sharing getSharingById(Integer id);

}
