package com.zebrands.notification.requesters;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface AuthorizationRequest {

    String getAdministrators(String user) throws JsonProcessingException;
}
