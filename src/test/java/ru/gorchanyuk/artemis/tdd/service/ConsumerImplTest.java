package ru.gorchanyuk.artemis.tdd.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gorchanyuk.artemis.tdd.dto.XmlIn;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тестирование получения сообщений")
public class ConsumerImplTest {

    @Mock
    private Producer producer;
    @InjectMocks
    private Consumer consumer;

    @Test
    void testGetMessage() {
        XmlIn in = new XmlIn();

        consumer.receive(in);

        verify(producer).send();
    }
}
