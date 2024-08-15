package ru.gorchanyuk.artemis.tdd.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.gorchanyuk.artemis.tdd.config.QueueProperty;
import ru.gorchanyuk.artemis.tdd.dto.XmlIn;
import ru.gorchanyuk.artemis.tdd.dto.XmlOut;
import ru.gorchanyuk.artemis.tdd.service.Consumer;

@Service
@RequiredArgsConstructor
public class ConsumerImpl implements Consumer {

    private final QueueProperty property;
    private final JmsTemplate jmsTemplate;

    @Override
    @JmsListener(destination = "${queue.in}")
    public void receive(XmlIn in) {

        jmsTemplate.convertAndSend(property.getOut(), new XmlOut());
    }
}
