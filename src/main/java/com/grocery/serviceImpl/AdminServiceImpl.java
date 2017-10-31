package com.grocery.serviceImpl;

import com.grocery.dao.AdminMenuMapper;
import com.grocery.dao.TechSharingMapper;
import com.grocery.domain.AdminMenu;
import com.grocery.domain.Message;
import com.grocery.domain.Sharing;
import com.grocery.domain.TechSharing;
import com.grocery.services.AdminService;
import com.grocery.utilities.DateUtility;
import com.grocery.utilities.PackingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Jason on 23/10/2017.
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TechSharingMapper techSharingMapper;

    @Autowired
    private AdminMenuMapper adminMenuMapper;

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

    public List<AdminMenu> getAdminMenu() {
        return adminMenuMapper.selectAdminMenuOrder();
    }

    @Override
    public Message getAdminDetail(Integer id, String type) {
        Message message = null;

        if ("article".equals(type)) {
            //文章

        } else if ("tech".equals(type)) {
            //技术
            message = PackingInfo.changeData2Message(techSharingMapper.selectByPrimaryKey(id));
        } else if ("software".equals(type)) {
            //软甲

        } else if ("news".equals(type)) {
            //新闻

        } else {
            //美食

        }

        return message;
    }

    @Override
    @Transactional
    public void updateArticle(String editorContent, String type, String title, Integer id) {

        Sharing Sharing = null;

        try {
            switch (type) {

                case "article":

                    break;
                case "software":

                    break;
                case "photography":

                    break;
                case "news":

                    break;
                case "food":

                    break;
                default:
                    Sharing = new TechSharing();
                    Sharing.setVersion(techSharingMapper.selectByPrimaryKey(id).getVersion() + 1);
                    Sharing.setId(id);
                    Sharing.setType(type);
                    Sharing.setTitle(title);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    techSharingMapper.updateByPrimaryKeyWithBLOBs((TechSharing)Sharing);
                    break;

            }



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
