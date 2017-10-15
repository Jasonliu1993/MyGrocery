package com.grocery.controllers;

import com.grocery.domain.SystemUser;
import com.grocery.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jason on 15/10/2017.
 */

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private IndexService indexService;

    @PostMapping("/login")
    public void login(String userNameOrEmail, String password4log, HttpSession session, HttpServletResponse response) throws IOException {
        SystemUser user = null;
        if ((user = indexService.loginAuthentication(userNameOrEmail, password4log)) != null) {
            session.setAttribute("User", user);
            response.sendRedirect("/index");
        } else
            response.sendRedirect("/error/loginFailed");
    }

}
