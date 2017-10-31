package com.grocery.serviceImpl;

import com.grocery.dao.ArticleSharingMapper;
import com.grocery.domain.ArticleSharing;
import com.grocery.domain.Sharing;
import com.grocery.services.SharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jason on 25/10/2017.
 */

@Service
public class ArticleSharingServiceImpl implements SharingService {

    @Autowired
    private ArticleSharingMapper articleSharingMapper;

    @Override
    public List<ArticleSharing> getSharingByPaging(Integer pageIndex, Integer pageSize) {
        return articleSharingMapper.selectWithoutDetailByPaging((pageIndex - 1) * pageSize,pageSize);
    }

    @Override
    public Integer getSharingCount() {
        return articleSharingMapper.getCount();
    }

    @Override
    public Sharing getSharingById(Integer id) {
        return articleSharingMapper.selectByPrimaryKey(id);
    }
}
