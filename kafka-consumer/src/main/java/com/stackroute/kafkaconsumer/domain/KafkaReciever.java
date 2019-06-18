package com.stackroute.kafkaconsumer.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class KafkaReciever {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(KafkaReciever.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "helloworld.t")
    public void receive(String payload) {
        LOGGER.info("received payload='{}'", payload);
        System.out.println(payload + "  this is my payload !!!");
        latch.countDown();
    }
}
