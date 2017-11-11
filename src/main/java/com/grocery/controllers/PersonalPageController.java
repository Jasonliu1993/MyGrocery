package com.grocery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jason on 11/11/2017.
 */

@Controller
@RequestMapping("/personalPage")
public class PersonalPageController {

    @GetMapping("/main")
    public String personalPageMain(ModelMap modelMap) {
        return "/personal-data/personal_main";
    }

}
