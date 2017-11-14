package com.grocery.services;

import com.grocery.domain.FileInputResponseMessage;
import com.grocery.domain.Message;
import com.grocery.domain.PersonalMenu;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Jason on 11/11/2017.
 */
public interface PersonalDataService {

    List<PersonalMenu> getPersonalMenuOrder();

    FileInputResponseMessage saveAvator(MultipartFile image) throws IOException;

    Message updatePersonalInfo(String newInfo, String object);
}
