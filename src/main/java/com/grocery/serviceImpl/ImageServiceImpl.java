package com.grocery.serviceImpl;

import com.grocery.dao.AvatorMapper;
import com.grocery.dao.PhotographyPhotoMapper;
import com.grocery.dao.SharingImagesMapper;
import com.grocery.domain.Message;
import com.grocery.domain.SharingImages;
import com.grocery.domain.UploadResponseMessage;
import com.grocery.exception.ErrorException;
import com.grocery.exception.StatusCode;
import com.grocery.services.ImageService;
import com.grocery.utilities.DateUtility;
import com.grocery.utilities.PackingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Jason on 14/10/2017.
 */

@Service
public class ImageServiceImpl implements ImageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PhotographyPhotoMapper photographyPhotoMapper;

    @Autowired
    private AvatorMapper avatorMapper;

    @Autowired
    private SharingImagesMapper sharingImagesMapper;

    @Override
    public byte[] getPhotographyPhoto(Integer id) {
        return photographyPhotoMapper.selectByPrimaryKey(id).getPhoto();
    }

    @Override
    public byte[] getAvator(Integer id) {
        return avatorMapper.selectByPrimaryKey(id).getPhoto();
    }

    @Override
    public byte[] getUploadImage(Integer id) {
        return sharingImagesMapper.selectByPrimaryKey(id).getPhoto();
    }

    @Override
    @Transactional
    public UploadResponseMessage processUEditorUpload(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
//        String filePath = resourceLocation;
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        try {
            byte[] stream = file.getBytes();

            SharingImages sharingImages = new SharingImages();
            sharingImages.setVersion(1);
            sharingImages.setCreateDatetime(DateUtility.getCurrentDate());
            sharingImages.setPhoto(stream);

            sharingImagesMapper.insertSelective(sharingImages);
            logger.error(sharingImages.getId().toString());
            UploadResponseMessage uploadResponseMessage = new UploadResponseMessage();

            uploadResponseMessage.setState("SUCCESS");
            uploadResponseMessage.setUrl("/image/getUploadImage/" + sharingImages.getId());
            uploadResponseMessage.setTitle("uploadImage");
            uploadResponseMessage.setOriginal("uploadImage");

            return uploadResponseMessage;

        } catch (IOException e) {
            e.printStackTrace();
        }



        return null;

    }
}
