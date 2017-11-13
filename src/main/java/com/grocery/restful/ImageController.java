package com.grocery.restful;

import com.grocery.domain.FileInputResponseMessage;
import com.grocery.domain.Message;
import com.grocery.services.ImageService;
import com.grocery.services.PersonalDataService;
import com.grocery.utilities.PackingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Jason on 14/10/2017.
 */

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private PersonalDataService personalDataService;

    @GetMapping("/photography/{id}")
    public byte[] getPhotographyPhoto(@PathVariable("id") Integer id) {
        return imageService.getPhotographyPhoto(id);
    }

    @GetMapping("/avator/{id}")
    public byte[] getAvator(@PathVariable("id") Integer id) {
        return imageService.getAvator(id);
    }

    @GetMapping("/getUploadImage/{id}")
    public byte[] getUploadImage(@PathVariable("id") Integer id) {
        return imageService.getUploadImage(id);
    }

    @PostMapping("/deletePhotography/{id}")
    public String deletePhotography(@PathVariable("id") Integer id) {
        imageService.deletePhotography(id);
        return "0";
    }

    @PostMapping(value = "/saveImage", produces = "application/json; charset=utf-8")
    @ResponseBody
    public FileInputResponseMessage saveImage(@RequestParam(value = "file_data") MultipartFile avator) throws IOException {
        return personalDataService.saveAvator(avator);
    }

}
