package com.grocery.services;

import com.grocery.domain.AdminMenu;
import com.grocery.dto.Message;

import java.util.List;

/**
 * Created by Jason on 23/10/2017.
 */
public interface AdminService {

    void saveArticle(String editorContent, String type, String title);
    void savePhotography(String comments, String theme,String photoRefId);

    List<AdminMenu> getAdminMenu();

    Message getAdminDetail(Integer id, String type);

    void updateArticle(String editorContent, String type, String title, Integer id);
    void updatePhotography(String comments, String theme,String photoRefId, Integer id);
}
