package ru.gorchanyuk.artemis.tdd.service;

import jakarta.jms.Message;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import ru.gorchanyuk.artemis.tdd.dto.XmlIn;
import ru.gorchanyuk.artemis.tdd.dto.XmlOut;
import ru.gorchanyuk.artemis.tdd.utils.ArtemisContainerIT;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsumerImplIT extends ArtemisContainerIT {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private MessageConverter converter;

    @SneakyThrows
    @Test
    @DisplayName("Проверка получения из очереди in и отправки в очередь out")
    void testReceive() {

        XmlIn in = new XmlIn();
        jmsTemplate.convertAndSend(QUEUE_IN, in);

        Message message = jmsTemplate.receive(QUEUE_OUT);

        assertNotNull(message);
        Object result = converter.fromMessage(message);
        assertTrue(result instanceof XmlOut);
    }
}
