package com.grocery.controllers;

import com.grocery.configuration.UEditorConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jason on 21/10/2017.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/createArticle")
    public String createArticle() {
        return "/admin/create_article";
    }

    @GetMapping("/readUEditorConfig")
    public String readUEditorConfig() {
        return UEditorConfig.readUEditorConfig();
    }

    @GetMapping("/saveImage")
    public String saveUEditorImage() {
        return "";
    }


}
