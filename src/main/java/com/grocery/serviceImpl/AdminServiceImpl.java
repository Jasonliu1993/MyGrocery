package com.grocery.serviceImpl;

import com.grocery.dao.TechSharingMapper;
import com.grocery.domain.TechSharing;
import com.grocery.services.AdminService;
import com.grocery.utilities.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;

/**
 * Created by Jason on 23/10/2017.
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TechSharingMapper techSharingMapper;

    @Override
    @Transactional
    public void saveArticle(String editorContent, String type, String title) {
        TechSharing techSharing = new TechSharing();

        try {
            techSharing.setVersion(1);
            techSharing.setTitle(title);
            techSharing.setType(type);
            techSharing.setContent(editorContent.getBytes("UTF-8"));
            techSharing.setCreateDatetime(DateUtility.getCurrentDate());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        techSharingMapper.insertSelective(techSharing);

    }
}
