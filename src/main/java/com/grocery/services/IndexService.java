package com.grocery.services;

import com.grocery.domain.AuthInfo;
import com.grocery.domain.NavigatationMenu;
import com.grocery.domain.SystemUser;

import java.util.List;

/**
 * Created by Jason on 11/10/2017.
 */
public interface IndexService {
    List<NavigatationMenu> getNavMenu(String path);
    SystemUser loginAuthentication(String userName, String password);
    SystemUser registerAuthentication(String userName, String password4Register, String activeEmail);
    AuthInfo doAuthInfo(String object, String content);
    void loggingInfo();
}
