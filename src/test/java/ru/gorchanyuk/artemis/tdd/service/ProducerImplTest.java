package ru.gorchanyuk.artemis.tdd.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jms.core.JmsTemplate;
import ru.gorchanyuk.artemis.tdd.dto.XmlOut;
import ru.gorchanyuk.artemis.tdd.service.impl.ProducerImpl;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тестирование отправки сообщений в очередь")
public class ProducerImplTest {

    @Mock
    JmsTemplate jmsTemplate;
    @InjectMocks
    ProducerImpl producer;

    @Test
    void testSend(){

        producer.send();

        verify(jmsTemplate).convertAndSend(anyString(), any(XmlOut.class));
    }
}
