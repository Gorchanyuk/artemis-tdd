package ru.gorchanyuk.artemis.tdd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConverterConfiguration {

    @Bean
    public MessageConverter getMessageConverter(Marshaller marshaller) {
        MarshallingMessageConverter converter = new MarshallingMessageConverter(marshaller);
        converter.setTargetType(MessageType.TEXT);
        return converter;
    }

    @Bean
    public Marshaller getMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("ru.gorchanyuk.artemis.tdd.dto");
        return marshaller;
    }
}
