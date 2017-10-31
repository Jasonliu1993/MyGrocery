package com.grocery.serviceImpl;

import com.grocery.dao.NewsSharingMapper;
import com.grocery.domain.NewsSharing;
import com.grocery.domain.Sharing;
import com.grocery.services.SharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jason on 25/10/2017.
 */

@Service
public class NewsSharingServiceImpl implements SharingService {

    @Autowired
    private NewsSharingMapper newsSharingMapper;

    @Override
    public List<NewsSharing> getSharingByPaging(Integer pageIndex, Integer pageSize) {
        return newsSharingMapper.selectWithoutDetailByPaging((pageIndex - 1) * pageSize,pageSize);
    }

    @Override
    public Integer getSharingCount() {
        return newsSharingMapper.getCount();
    }

    @Override
    public Sharing getSharingById(Integer id) {
        return newsSharingMapper.selectByPrimaryKey(id);
    }
}
