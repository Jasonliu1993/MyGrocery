package com.grocery.serviceImpl;

import com.grocery.dao.AvatorMapper;
import com.grocery.dao.PersonalInfoMapper;
import com.grocery.dao.PersonalMenuMapper;
import com.grocery.dao.SystemUserMapper;
import com.grocery.domain.*;
import com.grocery.services.PersonalDataService;
import com.grocery.utilities.DateUtility;
import com.grocery.utilities.EncryptionUtility;
import com.grocery.utilities.PackingInfo;
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

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public List<PersonalMenu> getPersonalMenuOrder() {
        return personalMenuMapper.selectPersonalMenuOrder();
    }

    @Transactional
    @Override
    public FileInputResponseMessage saveAvator(MultipartFile image) throws IOException {
        FileInputResponseMessage responseMessage = new FileInputResponseMessage();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();

        Avator avator = new Avator();

        avator.setVersion(1);
        avator.setPhoto(image.getBytes());

        avatorMapper.insertSelective(avator);

        PersonalInfo personalInfo = personalInfoMapper.selectByUserId(((SystemUser) session.getAttribute("User")).getId());

        if (personalInfo.getAvator() != 1) {
            avatorMapper.deleteByPrimaryKey(personalInfo.getAvator());
        }

        personalInfo.setAvator(avator.getId());

        personalInfoMapper.updateByPrimaryKey(personalInfo);

        ((SystemUser) session.getAttribute("User")).getPersonalInfo().setAvator(avator.getId());

        return responseMessage;
    }

    @Override
    @Transactional
    public Message updatePersonalInfo(String newInfo, String object) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();

        SystemUser systemUser = (SystemUser) session.getAttribute("User");

        switch (object) {

            case "UserName":
                systemUser.setUserName(newInfo);
                break;

            case "Email":
                systemUser.setEmail(newInfo);
                break;

            case "Password":
                systemUser.setPassword(EncryptionUtility.encrypt4MD5(newInfo));
                break;

        }
        systemUser.setVersion(systemUser.getVersion() + 1);

        systemUserMapper.updateByPrimaryKeySelective(systemUser);

        Message message = PackingInfo.changeData2Message("Y");

        return message;
    }
}
