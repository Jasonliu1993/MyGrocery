package com.grocery.serviceImpl;

import com.grocery.dao.AvatorMapper;
import com.grocery.dao.PersonalInfoMapper;
import com.grocery.dao.PersonalMenuMapper;
import com.grocery.domain.Avator;
import com.grocery.domain.PersonalInfo;
import com.grocery.domain.PersonalMenu;
import com.grocery.domain.SystemUser;
import com.grocery.services.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jason on 11/11/2017.
 */

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    @Autowired
    private PersonalMenuMapper personalMenuMapper;

    @Autowired
    private AvatorMapper avatorMapper;

    @Autowired
    private PersonalInfoMapper personalInfoMapper;

    @Override
    public List<PersonalMenu> getPersonalMenuOrder() {
        return personalMenuMapper.selectPersonalMenuOrder();
    }

    @Transactional
    @Override
    public void saveAvator(MultipartFile image) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();

        Avator avator = new Avator();

        avator.setVersion(1);
        avator.setPhoto(image.getBytes());

        avatorMapper.insertSelective(avator);

        PersonalInfo personalInfo = personalInfoMapper.selectByUserId(((SystemUser)session.getAttribute("User")).getId());

        personalInfo.setAvator(avator.getId());

        personalInfoMapper.updateByPrimaryKey(personalInfo);

    }
}
