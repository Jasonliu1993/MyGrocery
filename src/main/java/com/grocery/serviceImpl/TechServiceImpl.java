package com.grocery.serviceImpl;

import com.grocery.dao.TechSharingMapper;
import com.grocery.domain.TechSharing;
import com.grocery.services.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jason on 25/10/2017.
 */

@Service
public class TechServiceImpl implements TechService{

    @Autowired
    private TechSharingMapper techSharingMapper;

    @Override
    public List<TechSharing> getTechSharingByPaging(Integer pageIndex, Integer pageSize) {
        return techSharingMapper.selectWithoutDetailByPaging((pageIndex - 1) * pageSize,pageSize);
    }

    @Override
    public Integer getTechSharingCount() {
        return techSharingMapper.getCount();
    }

    @Override
    public TechSharing getTechSharingById(Integer id) {
        return techSharingMapper.selectByPrimaryKey(id);
    }
}
