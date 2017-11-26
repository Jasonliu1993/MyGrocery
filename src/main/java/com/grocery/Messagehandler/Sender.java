package com.grocery.Messagehandler;

import com.grocery.domain.SystemUser;

public interface Sender {

    void send(SystemUser sender, SystemUser receiver, String content,MessageFromType messageFromType);

}
