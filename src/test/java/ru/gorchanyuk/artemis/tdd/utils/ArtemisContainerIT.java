package ru.gorchanyuk.artemis.tdd.utils;

import org.junit.jupiter.api.AfterAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
public abstract class ArtemisContainerIT {

    @Container
    static GenericContainer<?> container =
            new GenericContainer<>(DockerImageName
                    .parse("apache/activemq-artemis:latest-alpine"))
                    .withEnv("ANONYMOUS_LOGIN", "true")
                    .withExposedPorts(61616);

    @DynamicPropertySource
    static void artemisProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.artemis.broker-url",
                () -> "tcp://%s:%d".formatted(container.getHost(),
                        container.getFirstMappedPort()));
    }

    @AfterAll
    static void closeArtemis() {
        container.close();
    }
}