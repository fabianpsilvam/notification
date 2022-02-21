package com.zebrands.notification.manager.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zebrands.notification.constants.Kafka;
import com.zebrands.notification.dto.NotificationDto;
import com.zebrands.notification.manager.base.EventManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class KafkaConsumerManager {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EventManager eventManager;

    @KafkaListener(topics = Kafka.NOTIFICATION)
    public void evaluateNotificationEvent(String message) {
        log.info("Mensaje de kafka: {}", message);
        try {
            var notification = objectMapper.readValue(message, NotificationDto.class);
            eventManager.processByTypeAndName(notification);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}
