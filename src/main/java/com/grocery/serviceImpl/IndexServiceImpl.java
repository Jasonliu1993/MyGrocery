package com.grocery.serviceImpl;

import com.grocery.dao.NavigatationMenuMapper;
import com.grocery.domain.NavigatationMenu;
import com.grocery.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jason on 11/10/2017.
 */

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private NavigatationMenuMapper navigatationMenuMapper;

    @Override
    public List<NavigatationMenu> getNavMenu() {
        return navigatationMenuMapper.selectAll();
    }
}
