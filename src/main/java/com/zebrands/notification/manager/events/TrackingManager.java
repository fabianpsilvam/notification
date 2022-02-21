package com.zebrands.notification.manager.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zebrands.notification.constants.Managers;
import com.zebrands.notification.dto.NotificationDto;
import com.zebrands.notification.entity.TrackingEntity;
import com.zebrands.notification.manager.base.BaseEventManager;
import com.zebrands.notification.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = Managers.TRACKING_MANAGER)
public class TrackingManager extends BaseEventManager {

    @Autowired
    private TrackingRepository trackingRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void process(NotificationDto notificationDto) throws JsonProcessingException {
        trackingRepository.save(TrackingEntity.builder()
                .type(notificationDto.getType())
                .user(notificationDto.getUser())
                .params(objectMapper.writeValueAsString(notificationDto.getParams()))
                .build());
    }
}
