package ru.gorchanyuk.artemis.tdd.config;

import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.oxm.Marshaller;

public class ConverterConfiguration {
    public MessageConverter getMessageConverter(Marshaller marshaller) {
        MarshallingMessageConverter converter = new MarshallingMessageConverter(marshaller);
        converter.setTargetType(MessageType.TEXT);
        return converter;
    }
}
