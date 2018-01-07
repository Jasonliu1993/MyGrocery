package com.grocery.services;

import com.grocery.domain.FileInputResponseMessage;
import com.grocery.dto.UploadResponseMessage;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Jason on 14/10/2017.
 */
public interface ImageService {

    byte[] getPhotographyPhoto(Integer id);
    byte[] getAvator(Integer id);
    byte[] getUploadImage(Integer id);

    UploadResponseMessage processUEditorUpload(MultipartFile file);
    FileInputResponseMessage processPhotographyUpload(MultipartFile file);
    void deletePhotography(Integer id);

}
