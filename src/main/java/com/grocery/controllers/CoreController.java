package com.grocery.controllers;

import com.grocery.annotation.LogAnnotation;
import com.grocery.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jason on 10/10/2017.
 */

@Controller
public class CoreController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/index")
    public String index(ModelMap modelMap) {

        modelMap.addAttribute(indexService.getNavMenu());
        return "index";
    }

}
