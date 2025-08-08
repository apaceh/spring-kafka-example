package com.example.kafka;

import com.example.kafka.producer.KafkaProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestRunner implements CommandLineRunner {

    private final KafkaProducerService producer;

    public TestRunner(KafkaProducerService producer) {
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending test message to Kafka...");

        for (int i = 0; i <= 10; i++) {
            ObjectMapper objMapper = new ObjectMapper();
            Map<String, Object> tupple = new HashMap<>();
            tupple.put("idProses", "asdas-asd-ee-12-wdad" + i);
            String convert = objMapper.writeValueAsString(tupple);

            producer.sendMessage("spring-topic", convert);
        }
    }
}
