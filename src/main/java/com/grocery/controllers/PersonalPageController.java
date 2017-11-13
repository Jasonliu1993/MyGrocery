package com.grocery.controllers;

import com.grocery.domain.Message;
import com.grocery.services.PersonalDataService;
import com.grocery.utilities.PackingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Jason on 11/11/2017.
 */

@Controller
@RequestMapping("/personalPage")
public class PersonalPageController {

    @Autowired
    private PersonalDataService personalDataService;

    @GetMapping("/main")
    public String personalPageMain(ModelMap modelMap) {
        modelMap.addAttribute("PersonalMenus", PackingInfo.changeData2Message(personalDataService.getPersonalMenuOrder()));
        modelMap.addAttribute("CurrentType","avator");
        return "/personal-data/personal_main";
    }

    @PostMapping("/saveImage")
    public Message saveImage(@RequestParam(value = "avatar") MultipartFile avator) {

        return PackingInfo.changeData2Message("Y");
    }

}
