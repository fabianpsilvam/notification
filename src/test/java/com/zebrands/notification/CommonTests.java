package com.zebrands.notification;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zebrands.notification.manager.kafka.KafkaConsumerManager;
import com.zebrands.notification.repository.TrackingRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Rollback
@Transactional
public class CommonTests {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected KafkaConsumerManager kafkaConsumerManager;

    @Autowired
    protected TrackingRepository trackingRepository;
}
