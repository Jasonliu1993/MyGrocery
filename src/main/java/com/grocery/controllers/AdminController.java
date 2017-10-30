package com.grocery.controllers;

import com.baidu.ueditor.ActionEnter;
import com.grocery.domain.UploadResponseMessage;
import com.grocery.services.AdminService;
import com.grocery.services.ImageService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jason on 21/10/2017.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private AdminService adminService;

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

        return imageService.processUEditorUpload(file);
    }

    @PostMapping("/saveTechSharing")
    public void saveTechSharing(String editorContent, String type, String title, HttpServletResponse response ) {

        adminService.saveArticle(editorContent,type,title);

        try {
            response.sendRedirect("/admin");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/adminDetail/{id}")
    public String adminDetail(@PathVariable("id") String id) {

        return "/admin/admin_detail";
    }

}
