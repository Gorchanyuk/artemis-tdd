package ru.gorchanyuk.artemis.tdd.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jms.core.JmsTemplate;
import ru.gorchanyuk.artemis.tdd.config.QueueProperty;
import ru.gorchanyuk.artemis.tdd.dto.XmlIn;
import ru.gorchanyuk.artemis.tdd.dto.XmlOut;
import ru.gorchanyuk.artemis.tdd.service.impl.ConsumerImpl;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тестирование получения сообщений")
class ConsumerImplTest {

    @Mock
    private JmsTemplate jmsTemplate;
    @Mock
    private QueueProperty property;
    @InjectMocks
    private ConsumerImpl consumer;

    @Test
    void testGetMessage() {
        XmlIn in = new XmlIn();
        when(property.getOut()).thenReturn("out");

        consumer.receive(in);

        verify(jmsTemplate).convertAndSend(anyString(), any(XmlOut.class));
    }
}
