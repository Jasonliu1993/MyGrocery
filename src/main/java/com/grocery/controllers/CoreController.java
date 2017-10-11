package com.grocery.controllers;

import com.grocery.services.IndexService;
import com.grocery.utilities.PackingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Jason on 10/10/2017.
 */

@Controller
public class CoreController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/index")
    public String index(ModelMap modelMap) {

        modelMap.addAttribute("Nav",PackingInfo.changeData2Message(indexService.getNavMenu("/index")));
        return "index";
    }

    @GetMapping("/photography")
    public String photography(ModelMap modelMap) {
        modelMap.addAttribute("Nav",PackingInfo.changeData2Message(indexService.getNavMenu("/photography")));
        return "/photography/photography_index";
    }

}
