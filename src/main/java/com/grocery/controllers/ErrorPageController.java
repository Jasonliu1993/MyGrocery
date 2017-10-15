package com.grocery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jason on 16/10/2017.
 */

@Controller
@RequestMapping("/error")
public class ErrorPageController {

    @RequestMapping("/loginFailed")
    public String loginFailed() {
        return "/error-page/login_failed";
    }

}
