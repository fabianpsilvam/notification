package com.zebrands.notification.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zebrands.notification.CommonTests;
import com.zebrands.notification.constants.Constants;
import com.zebrands.notification.dto.NotificationDto;
import com.zebrands.notification.requesters.AuthorizationRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

public class TrackingManagerTest extends CommonTests {

    @MockBean
    private AuthorizationRequest authorizationRequest;

    @Test
    public void evaluate_Event_Error() throws JsonProcessingException {

        kafkaConsumerManager.evaluateNotificationEvent(
                objectMapper.writeValueAsString("this is not an object")
        );
        var tracings = trackingRepository.findAll();
        Assertions.assertEquals(tracings.size(), 0);
    }

    @Test
    public void tracking_Event_Ok() throws JsonProcessingException {

        kafkaConsumerManager.evaluateNotificationEvent(
                objectMapper.writeValueAsString(NotificationDto.builder()
                        .type(Constants.TRACKING)
                        .user("test-user")
                        .params("params-test")
                        .build())
        );
        var tracings = trackingRepository.findAll();
        Assertions.assertEquals(tracings.size(), 1);
        Assertions.assertEquals(tracings.get(0).getType(), Constants.TRACKING);
    }

    @Test
    public void notification_Event_Ok() throws JsonProcessingException {

        var emails = new ArrayList<>();
        emails.add("test@mail.com");
        Mockito.when(authorizationRequest.getAdministrators(Mockito.anyString()))
                .thenReturn(objectMapper.writeValueAsString(emails));

        kafkaConsumerManager.evaluateNotificationEvent(
                objectMapper.writeValueAsString(NotificationDto.builder()
                        .type(Constants.EMAIL)
                        .user("test-user")
                        .params("params-test")
                        .build())
        );
        var tracings = trackingRepository.findAll();
        Assertions.assertEquals(tracings.size(), 0);
    }
}
