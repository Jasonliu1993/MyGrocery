package com.grocery.services;

import com.grocery.domain.PersonalMenu;

import java.util.List;

/**
 * Created by Jason on 11/11/2017.
 */
public interface PersonalDataService {

    List<PersonalMenu> getPersonalMenuOrder();

}
