package ru.gorchanyuk.artemis.tdd.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.gorchanyuk.artemis.tdd.dto.XmlIn;
import ru.gorchanyuk.artemis.tdd.dto.XmlOut;
import ru.gorchanyuk.artemis.tdd.service.Consumer;

@Service
@RequiredArgsConstructor
public class ConsumerImpl implements Consumer {

    private final JmsTemplate jmsTemplate;

    @Override
    public void receive(XmlIn in) {

        jmsTemplate.convertAndSend("out", new XmlOut());
    }
}
