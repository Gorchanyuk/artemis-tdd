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

import static org.junit.jupiter.api.Assertions.*;

class ConsumerImplIT extends ArtemisContainerIT {

    @Autowired
    private JmsTemplate jmsTemplate;

    @SneakyThrows
    @Test
    @DisplayName("Проверка получения из очереди in и отправки в очередь out")
    void testReceive() {

        XmlIn in = new XmlIn();
        jmsTemplate.convertAndSend(QUEUE_IN, in);
        MessageConverter converter = jmsTemplate.getMessageConverter();

        Message messageFromOut = jmsTemplate.receive(QUEUE_OUT);

        assertNotNull(messageFromOut);
        assertNotNull(converter);
        Object result = converter.fromMessage(messageFromOut);
        assertInstanceOf(XmlOut.class, result);
    }

    @SneakyThrows
    @Test
    @DisplayName("Проверка отправки неправильного сообщения")
    void testReceiveFail() {

        XmlOut out = new XmlOut();
        jmsTemplate.convertAndSend(QUEUE_IN, out);

        Message messageFromOut = jmsTemplate.receive("DLQ");

        assertNotNull(messageFromOut);
    }
}
