package ru.gorchanyuk.artemis.tdd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import ru.gorchanyuk.artemis.tdd.XmlOut;

@RequiredArgsConstructor
public class ProducerImpl implements Producer {

    private final JmsTemplate jmsTemplate;

    @Override
    public void send() {
        jmsTemplate.convertAndSend("out", new XmlOut());
    }
}
