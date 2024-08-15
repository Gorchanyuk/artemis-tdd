package ru.gorchanyuk.artemis.tdd.config;

import jakarta.xml.bind.Marshaller;
import org.junit.jupiter.api.Test;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class ConverterConfigurationTest {

    private ConverterConfiguration configuration = new ConverterConfiguration();

    @Test
    void testGetMessageConverter() {
        Marshaller marshaller = mock(Marshaller.class);

        MessageConverter converter = configuration.getMessageConverter(marshaller);

        assertTrue(converter instanceof MarshallingMessageConverter);

    }
}
