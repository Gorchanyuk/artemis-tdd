package ru.gorchanyuk.artemis.tdd.service;

import lombok.RequiredArgsConstructor;
import ru.gorchanyuk.artemis.tdd.XmlIn;

@RequiredArgsConstructor
public class ConsumerImpl implements Consumer {

    private final Producer producer;

    @Override
    public void receive(XmlIn in) {

        producer.send();
    }
}
