package com.zebrands.notification.manager.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zebrands.notification.dto.NotificationDto;

public abstract class BaseEventManager {

    protected abstract void process(NotificationDto notificationDto) throws JsonProcessingException;
}
