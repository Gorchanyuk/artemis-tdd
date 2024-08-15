package ru.gorchanyuk.artemis.tdd.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.gorchanyuk.artemis.tdd.dto.XmlIn;
import ru.gorchanyuk.artemis.tdd.dto.XmlOut;
import ru.gorchanyuk.artemis.tdd.service.Consumer;

@Service
@RequiredArgsConstructor
public class ConsumerImpl implements Consumer {

    @Value("${queue.out}")
    private String queueOut;
    private final JmsTemplate jmsTemplate;

    @Override
    @JmsListener(destination = "${queue.in}")
    public void receive(XmlIn in) {

        jmsTemplate.convertAndSend(queueOut, new XmlOut());
    }
}
