package com.zebrands.notification.manager.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zebrands.notification.dto.NotificationDto;
import com.zebrands.notification.factories.NotificationFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class EventManager {

    @Autowired
    private NotificationFactory notificationFactory;

    public void processByTypeAndName(NotificationDto notificationDto) throws JsonProcessingException {
        var eventManager = notificationFactory.getByTypeAndNameBean(notificationDto.getType());
        if (eventManager != null) {
            eventManager.process(notificationDto);
        } else {
            log.error("Unhandled {}", notificationDto.getType());
        }
    }
}
