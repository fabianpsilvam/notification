package com.zebrands.notification.manager.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zebrands.notification.constants.Managers;
import com.zebrands.notification.dto.NotificationDto;
import com.zebrands.notification.manager.base.BaseEventManager;
import com.zebrands.notification.requesters.AuthorizationRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component(value = Managers.NOTIFICATION_MANAGER)
public class NotificationManager extends BaseEventManager {

    @Autowired
    private AuthorizationRequest authorizationRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void process(NotificationDto notificationDto) throws JsonProcessingException {

        var authEmails = authorizationRequest.getAdministrators(notificationDto.getUser());
        var emailsToNotify = objectMapper.readValue(authEmails, new TypeReference<List<String>>() {
        });

        emailsToNotify.forEach(email -> {
            log.info("Sending email");
        });
    }
}
