package com.grocery.controllers;

import com.grocery.utilities.SharingServiceUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jason on 11/11/2017.
 */

@Controller
@RequestMapping("/sharing")
public class SharingController {

    @Autowired
    private SharingServiceUtility sharingServiceUtility;

    @GetMapping("/sharingDetail/{type}/{id}")
    public String sharingDetail(@PathVariable("type") String type, @PathVariable("id") Integer id, ModelMap modelMap) {

//        sharingServiceUtility.proceedTypeAndPageIndex(modelMap, type, "/sharing/sharingDetail/{type}/", id);

        return "/sharing/sharing_detail";
    }

}
