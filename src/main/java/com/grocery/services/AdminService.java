package com.grocery.services;

import com.grocery.domain.AdminMenu;
import com.grocery.domain.TechSharing;

import java.util.List;

/**
 * Created by Jason on 23/10/2017.
 */
public interface AdminService {

    void saveArticle(String editorContent, String type, String title);

    List<AdminMenu> getAdminMenu();

}
