package com.grocery.serviceImpl;

import com.grocery.dao.PersonalMenuMapper;
import com.grocery.domain.PersonalMenu;
import com.grocery.services.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jason on 11/11/2017.
 */

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    @Autowired
    private PersonalMenuMapper personalMenuMapper;


    @Override
    public List<PersonalMenu> getPersonalMenuOrder() {
        return personalMenuMapper.selectPersonalMenuOrder();
    }
}
