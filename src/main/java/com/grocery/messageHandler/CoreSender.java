package com.grocery.messageHandler;

import com.grocery.domain.SystemUser;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CoreSender extends SenderAdapter {

    private static Map<String, ProviderFactory> providerFactories = new ConcurrentHashMap<>();

    public Map<String, ProviderFactory> getProviderFactories() {
        return providerFactories;
    }

    public void setProviderFactories(Map<String, ProviderFactory> providerFactories) {
        this.providerFactories = providerFactories;
    }

    public void addProviderFactories(String name, ProviderFactory providerFactory) {

        providerFactories.put(name,providerFactory);

    }

    public ProviderFactory getProviderFactorie(String name) {

        return providerFactories.get(name);

    }

    @Override
    public void send(SystemUser sender, SystemUser receiver, String content, MessageFromType messageFromType) {
        Set senderSet = getProviderFactories().entrySet();

        if (senderSet != null) {
            Iterator iterator = senderSet.iterator();

            while(iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                ProviderFactory providerFactory = (ProviderFactory) entry.getValue();

                Sender senderEntry = providerFactory.getSender();

                senderEntry.send(sender,receiver,content,messageFromType);
            }
        }

    }
}
