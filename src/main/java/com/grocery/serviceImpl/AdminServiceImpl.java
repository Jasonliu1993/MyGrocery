package com.grocery.serviceImpl;

import com.grocery.dao.*;
import com.grocery.domain.*;
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
    private SoftwareSharingMapper softwareSharingMapper;

    @Autowired
    private NewsSharingMapper newsSharingMapper;

    @Autowired
    private FoodSharingMapper foodSharingMapper;

    @Autowired
    private ArticleSharingMapper articleSharingMapper;

    @Autowired
    private AdminMenuMapper adminMenuMapper;

    @Autowired
    private PhotographyDetailMapper photographyDetailMapper;

    @Override
    @Transactional
    public void saveArticle(String editorContent, String type, String title) {

        Sharing Sharing = null;

        try {
            switch (type) {

                case "article":
                    Sharing = new ArticleSharing();
                    Sharing.setVersion(1);
                    Sharing.setTitle(title);
                    Sharing.setType(type);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    articleSharingMapper.insertSelective((ArticleSharing) Sharing);
                    break;
                case "software":
                    Sharing = new SoftwareSharing();
                    Sharing.setVersion(1);
                    Sharing.setTitle(title);
                    Sharing.setType(type);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    softwareSharingMapper.insertSelective((SoftwareSharing) Sharing);
                    break;
                case "news":
                    Sharing = new NewsSharing();
                    Sharing.setVersion(1);
                    Sharing.setTitle(title);
                    Sharing.setType(type);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    newsSharingMapper.insertSelective((NewsSharing) Sharing);

                    break;
                case "food":
                    Sharing = new FoodSharing();
                    Sharing.setVersion(1);
                    Sharing.setTitle(title);
                    Sharing.setType(type);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    foodSharingMapper.insertSelective((FoodSharing) Sharing);
                    break;
                default:
                    Sharing = new TechSharing();
                    Sharing.setVersion(1);
                    Sharing.setTitle(title);
                    Sharing.setType(type);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    techSharingMapper.insertSelective((TechSharing) Sharing);
                    break;
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void savePhotography(String comments, String theme, String photoRefId) {
        PhotographyDetail photographyDetail = new PhotographyDetail();

        photographyDetail.setVersion(1);
        photographyDetail.setTheme(theme);
        photographyDetail.setPhotoRefId(Integer.valueOf(photoRefId));
        photographyDetail.setComments(comments);
        photographyDetail.setCreateDatetime(DateUtility.getCurrentDate());

        photographyDetailMapper.insertSelective(photographyDetail);
    }

    public List<AdminMenu> getAdminMenu() {
        return adminMenuMapper.selectAdminMenuOrder();
    }

    @Override
    public Message getAdminDetail(Integer id, String type) {
        Message message = null;

        switch (type) {

            case "article":
                message = PackingInfo.changeData2Message(articleSharingMapper.selectByPrimaryKey(id));
                break;
            case "software":
                message = PackingInfo.changeData2Message(softwareSharingMapper.selectByPrimaryKey(id));
                break;
            case "news":
                message = PackingInfo.changeData2Message(newsSharingMapper.selectByPrimaryKey(id));
                break;
            case "food":
                message = PackingInfo.changeData2Message(foodSharingMapper.selectByPrimaryKey(id));
                break;
            default:
                message = PackingInfo.changeData2Message(techSharingMapper.selectByPrimaryKey(id));
                break;
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
                    Sharing = new ArticleSharing();
                    Sharing.setVersion(articleSharingMapper.selectByPrimaryKey(id).getVersion() + 1);
                    Sharing.setId(id);
                    Sharing.setType(type);
                    Sharing.setTitle(title);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    articleSharingMapper.updateByPrimaryKeyWithBLOBs((ArticleSharing) Sharing);
                    break;
                case "software":
                    Sharing = new SoftwareSharing();
                    Sharing.setVersion(softwareSharingMapper.selectByPrimaryKey(id).getVersion() + 1);
                    Sharing.setId(id);
                    Sharing.setType(type);
                    Sharing.setTitle(title);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    softwareSharingMapper.updateByPrimaryKeyWithBLOBs((SoftwareSharing) Sharing);
                    break;
                case "news":
                    Sharing = new NewsSharing();
                    Sharing.setVersion(newsSharingMapper.selectByPrimaryKey(id).getVersion() + 1);
                    Sharing.setId(id);
                    Sharing.setType(type);
                    Sharing.setTitle(title);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    newsSharingMapper.updateByPrimaryKeyWithBLOBs((NewsSharing) Sharing);
                    break;
                case "food":
                    Sharing = new FoodSharing();
                    Sharing.setVersion(foodSharingMapper.selectByPrimaryKey(id).getVersion() + 1);
                    Sharing.setId(id);
                    Sharing.setType(type);
                    Sharing.setTitle(title);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    foodSharingMapper.updateByPrimaryKeyWithBLOBs((FoodSharing) Sharing);
                    break;
                default:
                    Sharing = new TechSharing();
                    Sharing.setVersion(techSharingMapper.selectByPrimaryKey(id).getVersion() + 1);
                    Sharing.setId(id);
                    Sharing.setType(type);
                    Sharing.setTitle(title);
                    Sharing.setContent(editorContent.getBytes("UTF-8"));
                    Sharing.setCreateDatetime(DateUtility.getCurrentDate());

                    techSharingMapper.updateByPrimaryKeyWithBLOBs((TechSharing) Sharing);
                    break;

            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}
