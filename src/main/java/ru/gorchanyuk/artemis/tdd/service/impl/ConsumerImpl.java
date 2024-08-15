package ru.gorchanyuk.artemis.tdd.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gorchanyuk.artemis.tdd.dto.XmlIn;
import ru.gorchanyuk.artemis.tdd.service.Consumer;
import ru.gorchanyuk.artemis.tdd.service.Producer;

@Service
@RequiredArgsConstructor
public class ConsumerImpl implements Consumer {

    private final Producer producer;

    @Override
    public void receive(XmlIn in) {

        producer.send();
    }
}
