package com.grocery.serviceImpl;

import com.grocery.annotation.LogAnnotation;
import com.grocery.dao.NavigatationMenuMapper;
import com.grocery.domain.NavigatationMenu;
import com.grocery.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jason on 11/10/2017.
 */

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private NavigatationMenuMapper navigatationMenuMapper;

    @Override
    public List<NavigatationMenu> getNavMenu(String path) {
        List<NavigatationMenu> navigatationMenus = navigatationMenuMapper.selectAll();

        /**
         * 标识是在哪个页面，将导航条设置成高亮
         */
        for(NavigatationMenu navigatationMenu : navigatationMenus) {
            if (path.equals(navigatationMenu.getInterlinkage()))
                navigatationMenu.setCustom1("Y");
        }

        return navigatationMenus;
    }
}
