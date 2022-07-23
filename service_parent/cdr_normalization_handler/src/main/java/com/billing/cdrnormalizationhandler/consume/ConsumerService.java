package com.billing.cdrnormalizationhandler.consume;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.blg.client.constants.Topics.NORMALIZATION_READ_LINE_CHANNEL;

@Component
public class ConsumerService {

    @KafkaListener(topics = NORMALIZATION_READ_LINE_CHANNEL, groupId = "group_id")
    public void consumeCDR(String line) {
        System.out.println(line);
    }

}
