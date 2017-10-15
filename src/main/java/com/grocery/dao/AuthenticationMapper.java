package com.grocery.dao;

import com.grocery.domain.SystemUser;
import org.springframework.stereotype.Repository;

/**
 * Created by Jason on 15/10/2017.
 */

@Repository
public interface AuthenticationMapper {
    SystemUser Auth(String userNameOrEmail,String password);
}
