package com.grocery.services;

import com.grocery.domain.Message;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Jason on 14/10/2017.
 */
public interface ImageService {

    byte[] getPhotographyPhoto(Integer id);
    byte[] getAvator(Integer id);

    Message processUEditorUpload(MultipartFile file);
}
