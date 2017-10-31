package com.grocery.serviceImpl;

import com.grocery.dao.SoftwareSharingMapper;
import com.grocery.domain.Sharing;
import com.grocery.domain.SoftwareSharing;
import com.grocery.services.SharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jason on 25/10/2017.
 */

@Service
public class SoftwareSharingServiceImpl implements SharingService {

    @Autowired
    private SoftwareSharingMapper softwareSharingMapper;

    @Override
    public List<SoftwareSharing> getSharingByPaging(Integer pageIndex, Integer pageSize) {
        return softwareSharingMapper.selectWithoutDetailByPaging((pageIndex - 1) * pageSize,pageSize);
    }

    @Override
    public Integer getSharingCount() {
        return softwareSharingMapper.getCount();
    }

    @Override
    public Sharing getSharingById(Integer id) {
        return softwareSharingMapper.selectByPrimaryKey(id);
    }
}
