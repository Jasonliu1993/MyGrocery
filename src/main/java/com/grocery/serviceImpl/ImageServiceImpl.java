package com.grocery.serviceImpl;

import com.grocery.dao.PhotographyPhotoMapper;
import com.grocery.domain.PhotographyPhoto;
import com.grocery.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jason on 14/10/2017.
 */

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private PhotographyPhotoMapper photographyPhotoMapper;

    @Override
    public byte[] getPhotographyPhoto(Integer id) {
        return photographyPhotoMapper.selectByPrimaryKey(id).getPhoto();
    }
}
