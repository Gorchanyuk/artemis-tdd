package ru.gorchanyuk.artemis.tdd.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.gorchanyuk.artemis.tdd.dto.XmlOut;
import ru.gorchanyuk.artemis.tdd.service.Producer;

@Service
@RequiredArgsConstructor
public class ProducerImpl implements Producer {

    private final JmsTemplate jmsTemplate;

    @Override
    public void send() {
        jmsTemplate.convertAndSend("out", new XmlOut());
    }
}
