package com.grocery.messageHandler;

public abstract class AbstractProviderFactoryAdapter implements ProviderFactory {

    @Override
    public Sender getSender() {
        return new InstationSender();
    }
}
