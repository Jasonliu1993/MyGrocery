package com.grocery.serviceImpl;

import com.grocery.dao.FoodSharingMapper;
import com.grocery.domain.FoodSharing;
import com.grocery.domain.Sharing;
import com.grocery.services.SharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jason on 25/10/2017.
 */

@Service
public class FoodSharingServiceImpl implements SharingService {

    @Autowired
    private FoodSharingMapper foodSharingMapper;

    @Override
    public List<FoodSharing> getSharingByPaging(Integer pageIndex, Integer pageSize) {
        return foodSharingMapper.selectWithoutDetailByPaging((pageIndex - 1) * pageSize,pageSize);
    }

    @Override
    public Integer getSharingCount() {
        return foodSharingMapper.getCount();
    }

    @Override
    public Sharing getSharingById(Integer id) {
        return foodSharingMapper.selectByPrimaryKey(id);
    }
}
