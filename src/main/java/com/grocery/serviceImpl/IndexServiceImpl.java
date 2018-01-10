package com.grocery.serviceImpl;

import com.grocery.dao.*;
import com.grocery.dao.cache.RedisDao;
import com.grocery.domain.*;
import com.grocery.services.IndexService;
import com.grocery.utilities.ClientInfoUtility;
import com.grocery.utilities.DateType;
import com.grocery.utilities.DateUtility;
import com.grocery.utilities.EncryptionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Jason on 11/10/2017.
 */

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private NavigatationMenuMapper navigatationMenuMapper;

    @Autowired
    private AuthenticationMapper authenticationMapper;

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private PersonalInfoMapper personalInfoMapper;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private ClientInfoMapper clientInfoMapper;

    @Override
    public List<NavigatationMenu> getNavMenu(String path) {
        List<NavigatationMenu> navigatationMenus = redisDao.getNavigatationMenus();

        if (navigatationMenus == null) {
            navigatationMenus = navigatationMenuMapper.selectAll();

            redisDao.putNavigatationMenu(navigatationMenus);
        }

        /**
         * 标识是在哪个页面，将导航条设置成高亮
         */
        for (NavigatationMenu navigatationMenu : navigatationMenus) {

            if (navigatationMenu.getLinkMatching().contains("&")) {
                String[] strings = navigatationMenu.getLinkMatching().split("&");
                for (String str : strings) {
                    if (path.startsWith(str))
                        navigatationMenu.setCustom1("Y");
                }
            } else {
                if (path.startsWith(navigatationMenu.getLinkMatching()))
                    navigatationMenu.setCustom1("Y");
            }
        }

        return navigatationMenus;
    }

    @Override
    @Transactional
    public SystemUser loginAuthentication(String userNameOrEmail, String password) {
        SystemUser systemUser = null;

        if ((systemUser = authenticationMapper.Auth(userNameOrEmail, password)) != null) {
            systemUser.setLastLoginDatetime(DateUtility.getCurrentDate());
            systemUserMapper.updateByPrimaryKeySelective(systemUser);
            systemUser.setPersonalInfo(personalInfoMapper.selectByUserId(systemUser.getId()));
        }

        return systemUser;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public SystemUser registerAuthentication(String userName, String password4Register, String activeEmail) {
        SystemUser systemUser = new SystemUser();
        PersonalInfo personalInfo = new PersonalInfo();

        systemUser.setUserName(userName);
        systemUser.setPassword(password4Register);
        systemUser.setType("custom");
        systemUser.setEmail(activeEmail);
        systemUser.setCreateDatetime(DateUtility.getCurrentDate());
        systemUser.setLastLoginDatetime(DateUtility.getCurrentDate());

        systemUserMapper.insertSelective(systemUser);

        personalInfo.setVersion(1);
        personalInfo.setUserId(systemUser.getId());
        personalInfo.setAvator(1);

        personalInfoMapper.insertSelective(personalInfo);

        return systemUser;
    }

    @Override
    public AuthInfo doAuthInfo(String object, String content) {

        AuthInfo authInfo = new AuthInfo();

        switch (object) {
            case "UserName":
                if (systemUserMapper.checkUserName(content) > 0) {
                    authInfo.setObject("UserName");
                    authInfo.setErrorFlag("N");
                    authInfo.setErrorMessage("用户名已存在");
                } else {
                    authInfo.setObject("UserName");
                    authInfo.setErrorFlag("Y");
                }
                break;
            case "Email":
                if (systemUserMapper.checkEmail(content) > 0) {
                    authInfo.setObject("Email");
                    authInfo.setErrorFlag("N");
                    authInfo.setErrorMessage("邮箱已存在");
                } else {
                    authInfo.setObject("Email");
                    authInfo.setErrorFlag("Y");
                }
                break;
            case "Password":
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                HttpSession session = request.getSession();
                SystemUser systemUser = (SystemUser) session.getAttribute("User");
                if (!EncryptionUtility.encrypt4MD5(content).equals(systemUser.getPassword())) {
                    authInfo.setObject("Password");
                    authInfo.setErrorFlag("N");
                    authInfo.setErrorMessage("密码不正确");
                } else {
                    authInfo.setObject("Password");
                    authInfo.setErrorFlag("Y");
                }
                break;
            default:
                authInfo.setObject("Unkonw");
                authInfo.setErrorFlag("N");
                authInfo.setErrorMessage("未知错误");
        }

        return authInfo;
    }

    @Override
    @Transactional
    public void loggingInfo() {

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        String ip = ClientInfoUtility.getIpAddr(request);
        ClientInfo clientInfo = null;

        if ((clientInfo = clientInfoMapper.selectByIp(ip)) != null) {
            clientInfo.setCreateDatetime(new Date());
            clientInfo.setVersion(clientInfo.getVersion() + 1);

            clientInfoMapper.updateByPrimaryKey(clientInfo);
        } else {
            clientInfo = new ClientInfo();
            clientInfo.setVersion(0);
            clientInfo.setSession(session.getId());
            clientInfo.setCreateDatetime(new Date());
            clientInfo.setLastAccessedTime(DateUtility.getFormattedDateByDate(DateType.YMDHMS_,new Date(session.getLastAccessedTime())));
            clientInfo.setVisitorBrowserVersion(ClientInfoUtility.getRequestBrowserInfo(request));
            clientInfo.setVisitorIp(ip);
            clientInfo.setVisitorHostName(ClientInfoUtility.getHostName(ip));
            clientInfo.setVisitorSystemVersion(ClientInfoUtility.getRequestSystemInfo(request));

            clientInfoMapper.insert(clientInfo);
        }

    }
}
