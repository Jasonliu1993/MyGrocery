package com.grocery.controllers;

import com.grocery.services.IndexService;
import com.grocery.utilities.PackingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Jason on 12/10/2017.
 */

@Controller
public class PhotographyController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/photography/detail/{id}")
    public String photographyDetail(ModelMap modelMap, @PathVariable("id") String id) {

        System.out.println("id: " + id);

        System.out.println("here");

        modelMap.addAttribute("Nav", PackingInfo.changeData2Message(indexService.getNavMenu("/photography")));

        return "/photography/photography_detail";
    }

}
