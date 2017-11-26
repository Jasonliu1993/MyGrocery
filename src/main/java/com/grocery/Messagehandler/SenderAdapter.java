package com.grocery.Messagehandler;

import com.grocery.domain.SystemUser;

public abstract class SenderAdapter implements Sender {

    @Override
    public void send(SystemUser sender, SystemUser receiver, String content, MessageFromType messageFromType) {
    }

}
