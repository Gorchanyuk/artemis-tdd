package ru.gorchanyuk.artemis.tdd.service;

import ru.gorchanyuk.artemis.tdd.dto.XmlIn;

public interface Consumer {
    void receive(XmlIn in);
}
