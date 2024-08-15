package ru.gorchanyuk.artemis.tdd.config;

import org.springframework.oxm.Marshaller;
import org.junit.jupiter.api.Test;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class ConverterConfigurationTest {

    private final ConverterConfiguration configuration = new ConverterConfiguration();

    @Test
    void testGetMessageConverter() {
        Marshaller marshaller = mock(Jaxb2Marshaller.class);

        MessageConverter converter = configuration.getMessageConverter(marshaller);

        assertTrue(converter instanceof MarshallingMessageConverter);
    }

    @Test
    void testGetMarshaller(){

        Marshaller marshaller = configuration.getMarshaller();

        assertTrue(marshaller instanceof Jaxb2Marshaller);
        assertEquals("ru.gorchanyuk.artemis.tdd.dto",((Jaxb2Marshaller) marshaller).getPackagesToScan());
    }
}
