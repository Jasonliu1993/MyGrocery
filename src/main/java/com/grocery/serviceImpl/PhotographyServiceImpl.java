package com.grocery.serviceImpl;

import com.grocery.dao.PhotographyDetailMapper;
import com.grocery.domain.PhotographyDetail;
import com.grocery.services.PhotographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jason on 14/10/2017.
 */

@Service
public class PhotographyServiceImpl implements PhotographyService {

    @Autowired
    PhotographyDetailMapper photographyDetailMapper;

    @Override
    public List<PhotographyDetail> getPhotographyDetailBypaging(Integer pageNum, Integer pageSize) {
        return photographyDetailMapper.selectPaging((pageNum - 1) * pageSize,pageSize);
    }

    @Override
    public PhotographyDetail getPhotographyDetailById(Integer id) {
        System.out.println(id);
        return photographyDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getPhotographyDetailCount() {
        return photographyDetailMapper.getCount();
    }
}
