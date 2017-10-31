package com.grocery.serviceImpl;

import com.grocery.dao.TechSharingMapper;
import com.grocery.domain.Sharing;
import com.grocery.domain.TechSharing;
import com.grocery.services.SharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jason on 25/10/2017.
 */

@Service
public class TechServiceImpl implements SharingService {

    @Autowired
    private TechSharingMapper techSharingMapper;

    @Override
    public List<TechSharing> getSharingByPaging(Integer pageIndex, Integer pageSize) {
        return techSharingMapper.selectWithoutDetailByPaging((pageIndex - 1) * pageSize,pageSize);
    }

    @Override
    public Integer getSharingCount() {
        return techSharingMapper.getCount();
    }

    @Override
    public Sharing getSharingById(Integer id) {
        return techSharingMapper.selectByPrimaryKey(id);
    }
}
