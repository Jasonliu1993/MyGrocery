package com.grocery.restful;

import com.grocery.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jason on 14/10/2017.
 */

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/photography/{id}")
    public byte[] getPhotographyPhoto(@PathVariable("id") Integer id) {
        return imageService.getPhotographyPhoto(id);
    }

    @GetMapping("/avator/{id}")
    public byte[] getAvator(@PathVariable("id") Integer id) {
        return imageService.getAvator(id);
    }

    /*@GetMapping("/saveImage")
    public String saveUEditorImage() {
        return "";
    }*/

}
