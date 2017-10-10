package com.grocery.controllers;

import com.grocery.annotation.LogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jason on 10/10/2017.
 */

@Controller
public class CoreController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
