package com.grocery.messageHandler;

import com.grocery.dao.InstationSenderContentMapper;
import com.grocery.dao.InstationSenderMappingMapper;
import com.grocery.domain.InstationSenderContent;
import com.grocery.domain.InstationSenderMapping;
import com.grocery.domain.SystemUser;
import com.grocery.utilities.ApplicationContextUtility;
import com.grocery.utilities.DateUtility;
import org.springframework.transaction.annotation.Transactional;

public class InstationSender extends SenderAdapter {

    private InstationSenderMappingMapper instationSenderMappingMapper;

    private InstationSenderContentMapper instationSenderContentMapper;

    public InstationSender() {
        this.instationSenderMappingMapper = (InstationSenderMappingMapper)ApplicationContextUtility.getBean("instationSenderMappingMapper");
        this.instationSenderContentMapper = (InstationSenderContentMapper)ApplicationContextUtility.getBean("instationSenderContentMapper");
    }

    @Override
    @Transactional
    public void send(SystemUser sender, SystemUser receiver, String content, MessageFromType messageFromType) {
        InstationSenderContent instationSenderContent = new InstationSenderContent();
        InstationSenderMapping instationSenderMapping = new InstationSenderMapping();

        instationSenderContent.setVersion(1);
        instationSenderContent.setTitle(messageFromType.getType());
        instationSenderContent.setContent(content);
        instationSenderContent.setCreateDatetime(DateUtility.getCurrentDate());

        instationSenderContentMapper.insertSelective(instationSenderContent);

        instationSenderMapping.setInstationSenderContentId(instationSenderContent.getId());
        instationSenderMapping.setReadFlag("N");
        instationSenderMapping.setCreateDatetime(DateUtility.getCurrentDate());
        instationSenderMapping.setVersion(1);
        instationSenderMapping.setReceiverUserId(receiver.getId());
        instationSenderMapping.setSenderUserId(sender.getId());

        instationSenderMappingMapper.insertSelective(instationSenderMapping);

    }
}
