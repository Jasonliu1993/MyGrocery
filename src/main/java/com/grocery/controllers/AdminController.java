package com.grocery.controllers;

import com.baidu.ueditor.ActionEnter;
import com.grocery.domain.SharingImages;
import com.grocery.domain.UploadResponseMessage;
import com.grocery.services.ImageService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jason on 21/10/2017.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/createArticle")
    public String createArticle() {
        return "/admin/create_article";
    }

    @GetMapping("/readUEditorConfig")
    @ResponseBody
    public String readUEditorConfig(HttpServletRequest request) {
        String rootPath = request.getServletContext().getRealPath("/");
        try {
            return new ActionEnter(request, rootPath).exec();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(value = "/saveImage", produces = "application/json; charset=utf-8")
    @ResponseBody
    public UploadResponseMessage saveUEditorImage(@RequestParam(value = "upfile") MultipartFile file) {

        UploadResponseMessage uploadResponseMessage = imageService.processUEditorUpload(file);

        return uploadResponseMessage;
    }


}
