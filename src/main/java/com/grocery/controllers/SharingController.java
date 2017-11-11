package com.grocery.controllers;

import com.grocery.domain.Sharing;
import com.grocery.services.AdminService;
import com.grocery.utilities.SharingServiceUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

/**
 * Created by Jason on 11/11/2017.
 */

@Controller
@RequestMapping("/sharing")
public class SharingController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/sharingDetail/{type}/{id}")
    public String sharingDetail(@PathVariable("type") String currentType, @PathVariable("id") Integer id, ModelMap modelMap) throws UnsupportedEncodingException {

        modelMap.addAttribute("SharingDetail", adminService.getAdminDetail(id, currentType));

        modelMap.addAttribute("UEditor", new String(((Sharing) adminService.getAdminDetail(id, currentType).getData()).getContent(), "utf-8"));


        return "/sharing/sharing_detail";
    }

}
