package com.grocery.controllers;

import com.grocery.domain.Message;
import com.grocery.services.PersonalDataService;
import com.grocery.utilities.PackingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
        modelMap.addAttribute("CurrentType", "avator");
        return "/personal-data/personal_main";
    }

    @PostMapping("/updatePersonalInfo")
    @ResponseBody
    public Message updatePersonalInfo(@RequestParam("newInfo") String newInfo,@RequestParam("object") String object) {
        return personalDataService.updatePersonalInfo(newInfo, object);
    }

}
