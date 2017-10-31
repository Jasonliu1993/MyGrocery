package com.grocery.controllers;

import com.baidu.ueditor.ActionEnter;
import com.grocery.domain.Sharing;
import com.grocery.domain.UploadResponseMessage;
import com.grocery.services.AdminService;
import com.grocery.services.ImageService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
        return "/admin/admin_create_article";
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

    @PostMapping("/saveSharing")
    public void saveSharing(String editorContent, String type, String title, HttpServletResponse response) {

        adminService.saveArticle(editorContent, type, title);

        try {
            response.sendRedirect("/admin?type=" + type + "&pageIndex=1");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/adminDetail")
    public String adminDetail(@RequestParam("id") Integer id, @RequestParam("currentType") String currentType, ModelMap modelMap) throws UnsupportedEncodingException {

        modelMap.addAttribute("AdminDetail", adminService.getAdminDetail(id, currentType));

        modelMap.addAttribute("UEditor", new String(((Sharing) adminService.getAdminDetail(id, currentType).getData()).getContent(), "utf-8"));

        return "/admin/admin_update_detail";
    }

    @PostMapping("/updateSharing")
    public void updateSharing(String editorContent,String type, String title, Integer id, HttpServletResponse response) {
        adminService.updateArticle(editorContent, type, title, id);

        try {
            response.sendRedirect("/admin?type=" + type + "&pageIndex=1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
